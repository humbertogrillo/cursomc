package com.humbertogrillo.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.humbertogrillo.cursomc.domain.Categoria;
import com.humbertogrillo.cursomc.services.CategoriaService;

@RestController
@RequestMapping(value = RestEndpoint.CATEGORIA)
public class CategoriaResource {

	@Autowired
	CategoriaService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> listar(@PathVariable Integer id) {
		Categoria obj = service.buscar(id);

		return ResponseEntity.ok(obj);
	}
}
