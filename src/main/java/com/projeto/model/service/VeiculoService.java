package com.projeto.model.service;

import java.util.List;

import javax.persistence.EntityTransaction;

import com.projeto.estrutura.util.VariaveisProjeto;
import com.projeto.model.dao.VeiculoDao;
import com.projeto.model.models.Veiculo;



public class VeiculoService extends ConexaoBancoService {

		private VeiculoDao veiculoDao;
		
		
		public VeiculoService() {
			this.veiculoDao = new VeiculoDao(this.getEntityManager());
		}
		
		public Integer save(Veiculo veiculo) {
			
			Integer toReturn =0;
			
			EntityTransaction trx = this.getTransaction();
			
			
			toReturn = validarDigitacao(veiculo);
			if(toReturn == VariaveisProjeto.DIGITACAO_OK) {
				try {
					trx.begin();
					this.getVeiculoDao().save(veiculo);
					trx.commit();
					toReturn = VariaveisProjeto.INCLUSAO_REALIZADA;
					
				}catch(Exception ex){
					ex.printStackTrace();
					if(trx.isActive()) {
						trx.rollback();
					}
					toReturn = VariaveisProjeto.ERRO_INCLUSAO;
				}finally {
					this.close();
				}
			}
			return toReturn;
		}
		
		
		public Integer update(Veiculo veiculo) {
			Integer toReturn =0 ;
			EntityTransaction trx = this.getTransaction();
			
			toReturn = validarDigitacao(veiculo);
			if(toReturn == VariaveisProjeto.DIGITACAO_OK) {
				
				try {
					trx.begin();
					this.getVeiculoDao().update(veiculo);
					trx.commit();
					toReturn = VariaveisProjeto.ALTERECAO_REALIZADA;
				}catch(Exception ex) {
					ex.printStackTrace();
					if(trx.isActive()) {
						trx.rollback();
					}
					toReturn = VariaveisProjeto.ERRO_ALTERACAO;
				}finally {
					this.close();
				}
			}
			return toReturn;
		}
		
		public Integer delete(Veiculo veiculo) {
			Integer toReturn = 0;
			
			EntityTransaction trx = this.getTransaction();
			
			try {
				trx.begin();
				Veiculo veiculoEncontrado = this.getVeiculoDao().findById(veiculo.getId_veiculo());
				this.getVeiculoDao().remove(veiculoEncontrado);
				trx.commit();
				toReturn = VariaveisProjeto.EXCLUSAO_REALIZADA;
				
			}catch(Exception ex){
				ex.printStackTrace();
				if(trx.isActive()) {
					trx.rollback();
				}
				toReturn = VariaveisProjeto.ERRO_EXCLUSAO;
			}finally {
				this.close();
			}
			
			return toReturn;
		}
		
		public Veiculo findById(Integer id) {
			return this.getVeiculoDao().findById(id);
			
		}
		
		public List<Veiculo> findByEmail(String placa) {
			return this.getVeiculoDao().findPlaca(Veiculo.class, placa);
		}
		
		public List<Veiculo> findAll(){
			return this.getVeiculoDao().findAll(Veiculo.class);
		}
		
		public Integer validarDigitacao(Veiculo veiculo) {
			if(VariaveisProjeto.digitacaoCampo(veiculo.getPlaca())) {
				return VariaveisProjeto.CAMPO_VAZIO;
			}
			else {
				return VariaveisProjeto.DIGITACAO_OK;
			}
		}
		
		public Integer countTotalRegister() {
			return veiculoDao.countTotalRegister(Veiculo.class);
		}
			
		public List<Veiculo> listVeiculoPaginacao(Integer numeroPagina, Integer defaultPagina) {
			return veiculoDao.listVeiculoPaginacao(numeroPagina, defaultPagina);
		}

		public VeiculoDao getVeiculoDao() {
			return veiculoDao;
		}

		public void setVeiculoDao(VeiculoDao veiculoDao) {
			this.veiculoDao = veiculoDao;
		}
		
}
