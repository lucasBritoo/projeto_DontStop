package projeto_teste;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.List;

import javax.imageio.ImageIO;

import org.junit.Test;

import com.projeto.model.models.Condominio;
import com.projeto.model.models.Porteiro;
import com.projeto.model.service.PorteiroService;

public class PorteiroTeste {
		
	//@Test(expected = Exception.class)
	public void salvarPorteiroTeste() {
		Porteiro porteiro = new Porteiro();
		Condominio condominio = new Condominio();
		
		try {
			BufferedImage imagem = ImageIO.read(new File("C:/Users/brito/eclipse-workspace/fotos/foto1.jpg"));
			ByteArrayOutputStream bytesImg = new ByteArrayOutputStream();
			ImageIO.write((BufferedImage)imagem, "jpg", bytesImg);
			bytesImg.flush();
			byte[] byteArray = bytesImg.toByteArray();
			bytesImg.close();
			
			porteiro.setNome_Porteiro("PORTEIRO UM MANO");
			porteiro.setCpf_Porteiro(10020030040L);
			porteiro.setRg_Porteiro("526888829");
			porteiro.setTelefone("11973785352");
			porteiro.setEmail("porteiro1@gmail.com");
			porteiro.setSenha("12345678");
			porteiro.setFoto_porteiro(byteArray);
			
			condominio.setId_condominio(1);
			porteiro.setCondominio(condominio);
			
			PorteiroService porteiroService = new PorteiroService();
			porteiroService.save(porteiro);
			
			System.out.println("Gravei poooorra");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/*@Test(expected = Exception.class)
	public void alterarPorteiroTeste() {
		Porteiro porteiro = new Porteiro();
		
		porteiro.setCpf_Porteiro(10020030040L);
		
		PorteiroService porteiroService = new PorteiroService();
		
		
		List<Porteiro> list = porteiroService.findByCpf(10020030040L);
		
		for(Porteiro port: list) {
			System.out.println(port.toString());
		}
		
		
	}*/
}
