package com.humbertogrillo.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.humbertogrillo.cursomc.domain.Categoria;
import com.humbertogrillo.cursomc.repositories.CategoriaRepository;
import com.humbertogrillo.cursomc.services.exception.ObjetoNaoEncontradoExcecao;

@Service
public class CategoriaService {

	@Autowired
	public CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjetoNaoEncontradoExcecao(Categoria.class.getName(),"Id",id));
	}
}
