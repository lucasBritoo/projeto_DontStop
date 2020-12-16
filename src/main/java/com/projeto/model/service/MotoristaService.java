package com.projeto.model.service;

import java.util.List;

import javax.persistence.EntityTransaction;

import com.projeto.estrutura.util.VariaveisProjeto;
import com.projeto.model.dao.MotoristaDao;
import com.projeto.model.models.Motorista;



public class MotoristaService extends ConexaoBancoService {

		private MotoristaDao motoristaDao;
		
		
		public MotoristaService() {
			this.motoristaDao = new MotoristaDao(this.getEntityManager());
		}
		
		public Integer save(Motorista motorista) {
			
			Integer toReturn =0;
			
			EntityTransaction trx = this.getTransaction();
			
			
			toReturn = validarDigitacao(motorista);
			if(toReturn == VariaveisProjeto.DIGITACAO_OK) {
				try {
					trx.begin();
					this.getMotoristaDao().save(motorista);
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
		
		
		public Integer update(Motorista motorista) {
			Integer toReturn =0 ;
			EntityTransaction trx = this.getTransaction();
			
			toReturn = validarDigitacao(motorista);
			if(toReturn == VariaveisProjeto.DIGITACAO_OK) {
				
				try {
					trx.begin();
					this.getMotoristaDao().update(motorista);
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
		
		public Integer delete(Motorista motorista) {
			Integer toReturn = 0;
			
			EntityTransaction trx = this.getTransaction();
			
			try {
				trx.begin();
				Motorista motoristaEncontrado = this.getMotoristaDao().findById(motorista.getId_motorista());
				this.getMotoristaDao().remove(motoristaEncontrado);
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
		
		public Motorista findById(Integer id) {
			return this.getMotoristaDao().findById(id);
			
		}
		
		public List<Motorista> findByEmail(String email) {
			return this.getMotoristaDao().findEmail(Motorista.class, email);
		}
		
		public List<Motorista> findByCpf(long cpf){
			return this.getMotoristaDao().findCpf(Motorista.class, cpf);
		}
		
		public List<Motorista> findAll(){
			return this.getMotoristaDao().findAll(Motorista.class);
		}
		
		public Integer validarDigitacao(Motorista motorista) {
			if(VariaveisProjeto.digitacaoCampo(motorista.getNome_motorista())) {
				return VariaveisProjeto.CAMPO_VAZIO;
			}
			else {
				return VariaveisProjeto.DIGITACAO_OK;
			}
		}
		
		public Integer countTotalRegister() {
			return motoristaDao.countTotalRegister(Motorista.class);
		}
			
		public List<Motorista> listMotoristaPaginacao(Integer numeroPagina, Integer defaultPagina) {
			return motoristaDao.listMotoristaPaginacao(numeroPagina, defaultPagina);
		}

		public MotoristaDao getMotoristaDao() {
			return motoristaDao;
		}

		public void setMotoristaDao(MotoristaDao motoristaDao) {
			this.motoristaDao = motoristaDao;
		}
		
}
