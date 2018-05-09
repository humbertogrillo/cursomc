package com.humbertogrillo.cursomc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.humbertogrillo.cursomc.domain.Categoria;
import com.humbertogrillo.cursomc.repositories.CategoriaRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{

	@Autowired
	CategoriaRepository categoriaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		List<Categoria> categorias = new ArrayList<>();
		categorias.add(new Categoria(null, "Informática"));
		categorias.add(new Categoria(null, "Escritório"));
		
		categoriaRepository.saveAll(categorias);
		
	}
}
