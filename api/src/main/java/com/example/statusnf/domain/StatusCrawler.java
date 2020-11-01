package com.example.statusnf.domain;

import java.time.LocalDateTime;
import java.util.Optional;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

@Component
public class StatusCrawler {
	
	public static final String URL = "http://www.nfe.fazenda.gov.br/portal/disponibilidade.aspx";
	
	public Optional<Status> carregarDados() {
		Status status = new Status();
		status.setTimestamp(LocalDateTime.now());
		
		try {
			Document document = Jsoup.connect(URL).get();			
			Element table = document.select("table.tabelaListagemDados").first();
			
	        for (Element row : table.select("tr")) {
	            Elements tds = row.select("td");
	            	            
	            if (tds.size() > 7) {
	            	Item item = new Item();
	            	
	            	item.setAutorizador(tds.get(0).text());
	            	item.setAutorizacao(getStatus(tds.get(1).html()));
	            	item.setRetornoAutorizacao(getStatus(tds.get(2).html()));
	            	item.setInutilizacao(getStatus(tds.get(3).html()));
	            	item.setConsultaProtocolo(getStatus(tds.get(4).html()));
	            	item.setStatusServico(getStatus(tds.get(5).html()));
	            	item.setConsultaCadastro(getStatus(tds.get(7).html()));
	            	item.setRecepcaoEvento(getStatus(tds.get(8).html()));
	            	
	            	status.addItens(item);
	            }
	        }
	        
	        return Optional.of(status);
		} catch (Exception e) {
			return Optional.empty();
		}
    
	}

	private Disponibilidade getStatus(String html) {
		if (html.indexOf("bola_vermelho") > -1) {
			return Disponibilidade.VERMELHO;
		}
		
		if (html.indexOf("bola_amarela") > -1) {
			return Disponibilidade.AMARELO;
		}
		
		if (html.indexOf("bola_verde") > -1) {
			return Disponibilidade.VERDE;
		}
		
		return null;
	}

}
