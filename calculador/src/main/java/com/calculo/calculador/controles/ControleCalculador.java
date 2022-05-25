package com.calculo.calculador.controles;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.calculo.calculador.dto.Calculo;
import com.calculo.calculador.dto.Resposta;

@RestController
public class ControleCalculador {

	private String[] uri = { "http://localhost:8080/somar/numero/{numero1}/mais/{numero2}" };

	@GetMapping("/calcular")
	public ResponseEntity<Resposta> calcular(@RequestBody Calculo calculo) {
		Double numero1 = calculo.getNumero1();
		Double numero2 = calculo.getNumero2();
		String operacao = calculo.getOperacao();

		Map<String, String> dados = new HashMap<>();
		dados.put("numero1", numero1.toString());
		dados.put("numero2", numero2.toString());

		if (operacao.equals("soma")) {
			ResponseEntity<Resposta> entidadeResposta = new RestTemplate().getForEntity(uri[0], Resposta.class, dados);
			Resposta resposta = entidadeResposta.getBody();
			return new ResponseEntity<Resposta>(resposta, HttpStatus.ACCEPTED);

		} else {
			return new ResponseEntity<Resposta>(HttpStatus.BAD_REQUEST);
		}

	}
}