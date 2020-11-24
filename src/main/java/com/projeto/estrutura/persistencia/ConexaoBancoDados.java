package com.projeto.estrutura.persistencia;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.projeto.estrutura.util.VariaveisProjeto;


public class ConexaoBancoDados {
	
	private static ConexaoBancoDados CONEXAO_BANCO_DADOS;
	private static EntityManagerFactory FABRICA_CONEXAO;
	
	private ConexaoBancoDados() {
		
		if(FABRICA_CONEXAO == null) {
			FABRICA_CONEXAO = getCriarFabricaConexao();
			
		}
	}
	
	public static ConexaoBancoDados getConexaoBancoDados() {
		
		if(CONEXAO_BANCO_DADOS == null) {
			CONEXAO_BANCO_DADOS = new ConexaoBancoDados();
		}
		
		return CONEXAO_BANCO_DADOS;
	}
	
	public EntityManager getEntityManager() {
		return FABRICA_CONEXAO.createEntityManager();
	}
	

	private EntityManagerFactory getCriarFabricaConexao() {
		
		Map<String, String> properties = new HashMap<String, String>();
		
		properties.put("javax.persistence.schema-generation.database.action", "update");    //vai gerar o banco de dados
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");					//como vou conversar com o banco de dados
		properties.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
		properties.put("hibernate.connection.url", "jdbc:mysql://127.0.0.1:3306/dontStop?createDatabaseIfNotExist=true&useSSL=false"); //vai procurar o banco no local especificado
		properties.put("hibernate.connection.username", "root");		//username do banco
		//properties.put("hibernate.connection.password", "root");		//senha do usuario
		properties.put("hibernate.c3p0.min_size", "10");				//cria essa quantidade de conexões com o banco simultaneamente, neste caso sao 10
		properties.put("hibernate.c3p0.max_size" ,"20" );				//maximo de conexoes com o banco simultaneamente
		properties.put("hibernate.c3p0.acquire_increment","1");			//conexões de 1 a 1 com o banco
		properties.put("hibernate.c3p0.idle_test_period" ,"30000");		//intervalo de  transações
		properties.put("hibernate.c3p0.max_statements","50" );			//quantas transações ele faz com o banco
		properties.put("hibernate.c3p0.timeout","1800" );				//derruba conexão após 1800 segundos sem fazer nada
		properties.put("hibernate.show_sql", "true");					//mostrar
		properties.put("hibernate.format_sql", "true");					//formato sql
		properties.put("useUnicode", "true");							
		properties.put("characterEncoding", "UTF-8");					//usa caracteres especiais
		properties.put("hibernate.default_schema", "dontStop");			
		
		return Persistence.createEntityManagerFactory(VariaveisProjeto.PERSISTENCE_UNIT_NAME, properties);
	}
}
