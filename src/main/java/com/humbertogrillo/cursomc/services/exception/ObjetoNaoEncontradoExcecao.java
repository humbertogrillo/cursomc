package com.humbertogrillo.cursomc.services.exception;

public class ObjetoNaoEncontradoExcecao extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ObjetoNaoEncontradoExcecao(String msg) {
		super(msg);
	}
	
	public ObjetoNaoEncontradoExcecao(String classe, String campo, Object valor) {
		super(geraMensagem(classe, campo, valor));
		
	}
	
	private static String geraMensagem(String classe, String campo, Object valor) {
		StringBuilder msg = new StringBuilder("");
		msg.append("Objeto não encontrado: ");
		msg.append(classe);
		msg.append(" com ").append(campo).append(" valor ").append(valor);
		return msg.toString();
	}
	
	public ObjetoNaoEncontradoExcecao(String msg, Throwable causa) {
		super(msg,causa);
	}

}
