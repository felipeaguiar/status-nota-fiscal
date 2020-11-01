package com.example.statusnf.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Pageable;

import com.example.statusnf.domain.Disponibilidade;
import com.example.statusnf.domain.Item;
import com.example.statusnf.domain.Item_;
import com.example.statusnf.domain.Status;
import com.example.statusnf.domain.Status_;
import com.example.statusnf.dto.EstadoDto;
import com.example.statusnf.dto.StatusFilter;

public class StatusRepositoryImpl implements StatusRepositoryCustom {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Status> filtrar(StatusFilter filter, Pageable pageable) {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<Status> criteria = builder.createQuery(Status.class);
		Root<Status> root = criteria.from(Status.class);

		Predicate[] predicates = getPredicates(filter, builder, root);

		criteria.select(root);

		if (predicates.length > 0) {
			criteria.where(predicates);
		}

		TypedQuery<Status> query = entityManager.createQuery(criteria);

		int page = pageable.getPageNumber();
		int size = pageable.getPageSize();
		int offset = page * size;

		query.setFirstResult(offset);
		query.setMaxResults(size);

		return query.getResultList();
	}

	@Override
	public Long count(StatusFilter filter) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Status> root = criteria.from(Status.class);

		Predicate[] predicates = getPredicates(filter, builder, root);

		criteria.select(builder.count(root));

		if (predicates.length > 0) {
			criteria.where(predicates);
		}

		return entityManager.createQuery(criteria).getSingleResult();
	}

	private Predicate[] getPredicates(StatusFilter filter, CriteriaBuilder builder, Root<Status> root) {
		List<Predicate> predicates = new ArrayList<>();


		if (filter.getDataDe() != null) {
			Predicate vencimento = builder.greaterThanOrEqualTo(root.get(Status_.timestamp), filter.getDataDe());
			predicates.add(vencimento);
		}

		if (filter.getDataAte() != null) {
			Predicate vencimento = builder.lessThanOrEqualTo(root.get(Status_.timestamp), filter.getDataAte());
			predicates.add(vencimento);
		}

		return predicates.toArray(new Predicate[predicates.size()]);
	}

	@Override
	public List<EstadoDto> obterResumoDisponibilidade() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<EstadoDto> criteria = builder.createQuery(EstadoDto.class);
		Root<Item> root = criteria.from(Item.class);
		
		criteria
			.select(builder.construct(EstadoDto.class,
				root.get(Item_.autorizador),
				builder.count(root.get(Item_.id))
			))
			.where(builder.equal(root.get(Item_.autorizacao), Disponibilidade.VERMELHO))
			.groupBy(root.get(Item_.autorizador));

		return entityManager.createQuery(criteria).getResultList();
	}

}
