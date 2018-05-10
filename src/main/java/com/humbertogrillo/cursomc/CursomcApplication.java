package com.humbertogrillo.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.humbertogrillo.cursomc.domain.Categoria;
import com.humbertogrillo.cursomc.domain.Cidade;
import com.humbertogrillo.cursomc.domain.Estado;
import com.humbertogrillo.cursomc.domain.Produto;
import com.humbertogrillo.cursomc.repositories.CategoriaRepository;
import com.humbertogrillo.cursomc.repositories.CidadeRepository;
import com.humbertogrillo.cursomc.repositories.EstadoRepository;
import com.humbertogrillo.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	CategoriaRepository categoriaRepository;
	@Autowired
	ProdutoRepository produtoRepository;
	@Autowired
	CidadeRepository cidadeRepository;
	@Autowired
	EstadoRepository estadoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");

		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().add(p2);

		p1.getCategorias().add(cat1);
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().add(cat1);

		Estado eMG = new Estado(null, "Minas Gerais");
		Estado eSP = new Estado(null,"São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia", eMG);
		Cidade c2 = new Cidade(null, "São Paulo", eSP);
		Cidade c3 = new Cidade(null, "Campinas", eSP);
		
		eMG.getCidades().add(c1);
		eSP.getCidades().addAll(Arrays.asList(c2,c3));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		estadoRepository.saveAll(Arrays.asList(eMG,eSP));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));

	}
}
