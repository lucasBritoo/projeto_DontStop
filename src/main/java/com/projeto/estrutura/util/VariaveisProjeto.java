package com.projeto.estrutura.util;

import java.util.Objects;

public class VariaveisProjeto {
	
	public static final String PERSISTENCE_UNIT_NAME = "dontStop";
	
	public static final Integer ERRO_INCLUSAO = 10;
	public static final Integer ERRO_ALTERACAO = 20;
	public static final Integer ERRO_EXCLUSAO = 30;
	
	public static final Integer DIGITACAO_OK = 100;
	public static final Integer CAMPO_VAZIO = 200;
	
	public static final Integer INCLUSAO_REALIZADA = 1;
	public static final Integer ALTERECAO_REALIZADA = 2;
	public static final Integer EXCLUSAO_REALIZADA = 3;
	
	public static final String LIMPA_CAMPO = "";
	
	public static boolean digitacaoCampo(Integer texto) {
		if(Objects.isNull(texto)) {
			return true;
		}
		
		return false;
	}
	
	public static boolean digitacaoCampo(String texto) {
		if(Objects.isNull(texto)) {
			return true;
		}
		
		if("".equals(texto.trim())) {
			return true;
		}
		return false;
	}
	
	public static Integer convertToInteger(String texto) {
		return Integer.parseInt(texto);
	}
	

}
