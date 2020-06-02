package com.yelo.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yelo.core.Entity.Pais;
import com.yelo.core.service.PaisService;

@RestController
@CrossOrigin(origins = "https://angelantoniolopez.github.io/front-paises/")
public class PaisController {
	@Autowired
	PaisService paisService;
	
	@GetMapping("/paises")
	public ResponseEntity<Page<Pais>> paginas(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "2") int size,
			@RequestParam(defaultValue = "nombre") String order,
			@RequestParam(defaultValue = "true") boolean asc
			){
			Page<Pais> paises = paisService.paginas(
					PageRequest.of(page, size, Sort.by(order)));
			if(!asc) {
				paises = paisService.paginas(
						PageRequest.of(page, size, Sort.by(order).ascending()));
				}
			return new ResponseEntity<Page<Pais>>(paises, HttpStatus.OK);
	}
}





















