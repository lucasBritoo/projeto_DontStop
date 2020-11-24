package projeto_teste;

import java.util.List;

import org.junit.Test;

import com.projeto.model.models.Condominio;
import com.projeto.model.service.CondominioService;


public class CondominioTeste {
	
		@Test(expected = Exception.class)
		public void salvarCondominioBancoDadosTeste() {
			Condominio condominio = new Condominio();
			
			//condominio.setId_condominio(1);
			condominio.setNome_condominio("Condominio Azul");
			condominio.setLogradouro("Rua Baleia");
			condominio.setCep("0162020-550");
			condominio.setN_instituicao(250);
			condominio.setBairro("Baleia");
			condominio.setComplemento("De frente a praia");
			condominio.setCidade("São Sebastião");
			condominio.setEstado("SP");
			condominio.setTelefone("0124692-1824");
			condominio.setEmail("condominioAzul@gmail.com");
			condominio.setSenha("condominio12345");
			
			CondominioService condominioService = new CondominioService();
			
			condominioService.save(condominio);
			
			System.out.println("Gravando dados no banco de dados");
		}
		
		//@Test(expected = Exception.class)
		public void alterarCondominioBancoDadosTeste() {
			Condominio condominio = new Condominio();
			
			condominio.setId_condominio(2);
			
			CondominioService condominioService = new CondominioService();
			
			condominio = condominioService.findById(condominio.getId_condominio());
			
			System.out.println(condominio.toString());
			
			condominio.setEmail("troqueiCaraio@gmail.com");
			
			condominioService.save(condominio);
			
			System.out.println("Alteração do usuario no banco de dados");
		}
		
		//@Test(expected= Exception.class)
		public void listarTodosCondominiosTabelaCondominio() {
			CondominioService condominioService = new CondominioService();
			List<Condominio> listaCondominio = condominioService.findAll();
			
			for(Condominio condominio: listaCondominio) {
				System.out.println(condominio.toString());
			}
		}
		
		//@Test(expected = Exception.class)
		public void excluirCondominioDaTabela() {
			Condominio condominio = new Condominio();
			condominio.setId_condominio(2);
			
			CondominioService condominioService = new CondominioService();
			
			condominioService.delete(condominio);
		}
}
