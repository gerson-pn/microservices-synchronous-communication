package com.calculo.soma.controles;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.calculo.soma.dto.Resposta;

@RestController
public class CalculoControle {

	@GetMapping("/somar/numero/{numero1}/mais/{numero2}")
	public ResponseEntity<Resposta> somar(@PathVariable double numero1, @PathVariable double numero2) {
		Resposta resposta = new Resposta();
		resposta.setNumero1(numero1);
		resposta.setNumero2(numero2);
		resposta.setResultado(numero1 + numero2);
		return new ResponseEntity<Resposta>(resposta, HttpStatus.ACCEPTED);
	}
}