package com.projeto.view.veiculo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.TableRowSorter;

import com.projeto.model.models.Condominio;
import com.projeto.model.models.Motorista;
import com.projeto.model.models.Veiculo;
import com.projeto.model.models.Porteiro;
import com.projeto.model.service.VeiculoService;
import com.projeto.view.motorista.TabelaMotorista;
import com.projeto.view.porteiro.RelPorteiro;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.PatternSyntaxException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class TabelaVeiculo extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8351864904343934831L;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JLabel lblPesquisar;
	private JTextField txtPesquisar;
	private JButton btnPesquisar;
	private JLabel lblPagina;
	private JComboBox<String> comboBox;
	private JButton btnPrimeiro;
	private JButton btnProximo;
	private JButton btnAnterior;
	private JButton btnUltimo;
	private JLabel lblPaginaDefinida;
	private JLabel lblPaginaAtual;
	private JLabel lblDe;
	private JLabel lblUltimaPagina;
	private JButton btnInserir;
	private JButton btnAlterar;
	private JButton btnExcluir;
	private JButton btnSair;
	private JPanel panel;
	private JPanel panel_1;
	
	private static final int id_veiculo= 0;
	private static final int placa = 1;
	private static final int marca= 2;
	private static final int modelo= 3 ;
	private static final int nome_motorista= 4;

	private Motorista motorista;
	
	private TabelaVeiculoModel tabelaVeiculoModel;
	private TableRowSorter<TabelaVeiculoModel> sortTabelaVeiculo;
	
	
	private Integer totalData= 0;
	private Integer defaultPagina= 5;
	private Integer totalPagina= 1;
	private Integer numeroPagina= 1;
	private JTable tabelaVeiculo;
	private JButton btnRelatorio;
	private int acao=0;
	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TabelaVeiculo frame = new TabelaVeiculo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	 * Create the frame.
	 */
	public TabelaVeiculo(int acao) {
		this.acao = acao;
		initComponents();
		iniciaPaginacao();
		
		if(acao == 2) {
			bloqueiaBotao();
		}
	}
	private void initComponents() {
		setTitle("TABELA VEICULO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 390);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(175, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		lblPesquisar = new JLabel("Pesquisar:");
		lblPesquisar.setFont(new Font("Arial", Font.PLAIN, 16));
		
		txtPesquisar = new JTextField();
		txtPesquisar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String filtro = txtPesquisar.getText();
				
				filtraNomeVeiculo(filtro);
			}
		});
		txtPesquisar.setToolTipText("Digite um CPF");
		txtPesquisar.setColumns(10);
		
		lblPagina = new JLabel("P\u00E1gina:");
		lblPagina.setFont(new Font("Arial", Font.PLAIN, 16));
		
		comboBox = new JComboBox<String>();
		comboBox.setToolTipText("P\u00E1gina");
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"10", "20", "50"}));
		comboBox.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox.setSelectedIndex(0);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iniciaPaginacao();
			}
		});
		
		
		lblPaginaDefinida = new JLabel("P\u00E1gina:");
		lblPaginaDefinida.setFont(new Font("Arial", Font.PLAIN, 16));
		
		lblPaginaAtual = new JLabel("10");
		lblPaginaAtual.setFont(new Font("Arial", Font.PLAIN, 14));
		
		lblDe = new JLabel("de");
		lblDe.setFont(new Font("Arial", Font.PLAIN, 16));
		
		lblUltimaPagina = new JLabel("50");
		lblUltimaPagina.setFont(new Font("Arial", Font.PLAIN, 14));
		
		panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(new Color(173, 216, 230));
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(173, 216, 230));
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(103)
							.addComponent(lblPesquisar, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtPesquisar, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 631, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblPagina, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addGap(33)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblPaginaDefinida, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(lblPaginaAtual, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(lblDe, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(lblUltimaPagina, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(56)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 542, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(37, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPesquisar, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtPesquisar, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblPagina, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addComponent(lblPaginaAtual, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblDe, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addComponent(lblUltimaPagina, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblPaginaDefinida, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(50, Short.MAX_VALUE))
		);
		
		btnInserir = new JButton("INSERIR");
		btnInserir.setIcon(new ImageIcon(TabelaMotorista.class.getResource("/com/projeto/estrutura/imagens/book_add.png")));
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				incluirVeiculo();
				iniciaPaginacao();
			}
		});
		btnInserir.setFont(new Font("Arial", Font.PLAIN, 14));
		
		btnAlterar = new JButton("ALTERAR");
		btnAlterar.setIcon(new ImageIcon(TabelaMotorista.class.getResource("/com/projeto/estrutura/imagens/book_edit.png")));
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterarVeiculo();
				iniciaPaginacao();
			}
		});
		btnAlterar.setFont(new Font("Arial", Font.PLAIN, 14));
		
		btnExcluir = new JButton("EXCLUIR");
		btnExcluir.setIcon(new ImageIcon(TabelaMotorista.class.getResource("/com/projeto/estrutura/imagens/book_delete.png")));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirVeiculo();
				iniciaPaginacao();
			}
		});
		btnExcluir.setFont(new Font("Arial", Font.PLAIN, 14));
		
		btnSair = new JButton("SAIR");
		btnSair.setIcon(new ImageIcon(TabelaMotorista.class.getResource("/com/projeto/estrutura/imagens/sair.png")));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSair.setFont(new Font("Arial", Font.PLAIN, 14));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnInserir, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnAlterar)
					.addGap(18)
					.addComponent(btnExcluir, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(16, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnInserir, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAlterar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnExcluir)
						.addComponent(btnSair))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		btnPrimeiro = new JButton("");
		btnPrimeiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numeroPagina = 1 ;
				iniciaPaginacao();
			}
		});
		btnPrimeiro.setIcon(new ImageIcon(TabelaMotorista.class.getResource("/com/projeto/estrutura/imagens/go-first.png")));
		btnPrimeiro.setToolTipText("Primeiro");
		
		btnProximo = new JButton("");
		btnProximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(numeroPagina < totalPagina) {
					numeroPagina += 1;
					iniciaPaginacao();
					
				}
			}
		});
		btnProximo.setIcon(new ImageIcon(TabelaMotorista.class.getResource("/com/projeto/estrutura/imagens/go-next.png")));
		btnProximo.setToolTipText("Pr\u00F3ximo");
		
		btnAnterior = new JButton("");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(numeroPagina > 1) {
					numeroPagina = numeroPagina -1;
					iniciaPaginacao();
				}
			}
		});
		btnAnterior.setIcon(new ImageIcon(TabelaMotorista.class.getResource("/com/projeto/estrutura/imagens/go-previous.png")));
		btnAnterior.setToolTipText("Anterior");
		
		btnUltimo = new JButton("");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numeroPagina = totalPagina;
				iniciaPaginacao();
			}
		});
		btnUltimo.setIcon(new ImageIcon(TabelaMotorista.class.getResource("/com/projeto/estrutura/imagens/go-last.png")));
		btnUltimo.setToolTipText("\u00DAltimo");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnPrimeiro, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnProximo, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnAnterior, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnUltimo, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(26, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnUltimo, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(btnAnterior, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(btnProximo, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(btnPrimeiro, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 20, Short.MAX_VALUE))
					.addContainerGap(10, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		tabelaVeiculo = new JTable();
		scrollPane.setViewportView(tabelaVeiculo);
		contentPane.setLayout(gl_contentPane);
	}
	
	/*private void imprimeRelatorio() {
		RelVeiculo relVeiculo = new RelVeiculo(new JFrame(), true);
		relVeiculo.setLocationRelativeTo(null);
		setVisible(false);
		relVeiculo.setVisible(true);
		
	}*/
	
	protected void iniciaPaginacao() {
		totalData = buscaTotalRegistroVeiculo();
		
		defaultPagina = Integer.valueOf(comboBox.getSelectedItem().toString());
		
		Double totalPaginasExistentes = Math.ceil(totalData.doubleValue()/defaultPagina.doubleValue());
		
		totalPagina = totalPaginasExistentes.intValue(); 
		
		if(numeroPagina.equals(1)) {
			btnPrimeiro.setEnabled(false);
			btnProximo.setEnabled(false);
		}
		else {
			btnPrimeiro.setEnabled(true);
			btnProximo.setEnabled(true);
		}
		
		if(numeroPagina.equals(totalPagina)) {
			btnUltimo.setEnabled(false);
			btnProximo.setEnabled(false);
		}
		else {
			btnUltimo.setEnabled(true);
			btnProximo.setEnabled(true);
		}
		
		if(numeroPagina > totalPagina) {
			numeroPagina = 1;
		}
		
		tabelaVeiculoModel = new TabelaVeiculoModel();
		
		tabelaVeiculoModel.setListaVeiculo(carregaListaVeiculo(numeroPagina, defaultPagina));
		
		tabelaVeiculo.setModel(tabelaVeiculoModel);
		
		tabelaVeiculo.setFillsViewportHeight(true);
		
		tabelaVeiculo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		tabelaVeiculoModel.fireTableDataChanged();
		
		sortTabelaVeiculo = new TableRowSorter<TabelaVeiculoModel>(tabelaVeiculoModel);
		
		tabelaVeiculo.setRowSorter(sortTabelaVeiculo);
		
		tabelaVeiculo.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		
		tabelaVeiculo.getColumnModel().getColumn(id_veiculo).setWidth(11);
		tabelaVeiculo.getColumnModel().getColumn(placa).setWidth(50);
		tabelaVeiculo.getColumnModel().getColumn(marca).setWidth(50);
		tabelaVeiculo.getColumnModel().getColumn(modelo).setWidth(50);
		tabelaVeiculo.getColumnModel().getColumn(nome_motorista).setWidth(50);
		
		
		lblPaginaAtual.setText(String.valueOf(numeroPagina));
		lblUltimaPagina.setText(String.valueOf(totalData));
		
	}
	
	
	private void alterarVeiculo() {
		if(tabelaVeiculo.getSelectedRow() != -1 && tabelaVeiculo.getSelectedRow() < tabelaVeiculoModel.getRowCount()) {
			int linha = tabelaVeiculo.getSelectedRow();
			
			CadastroVeiculo veiculo = new CadastroVeiculo(new JFrame(), true, tabelaVeiculo, tabelaVeiculoModel, linha, 2);
			veiculo.setLocationRelativeTo(null);
			veiculo.setResizable(false);
			veiculo.setVisible(true);
			
			
		}
		
	}

	private void incluirVeiculo() {
		CadastroVeiculo veiculo = new CadastroVeiculo(new JFrame(), true, tabelaVeiculo, tabelaVeiculoModel, 0, 1);
		veiculo.setLocationRelativeTo(null);
		veiculo.setResizable(false);
		veiculo.setVisible(true);
		
	}
	
	private void excluirVeiculo() {
		if(tabelaVeiculo.getSelectedRow() != -1 && tabelaVeiculo.getSelectedRow() < tabelaVeiculoModel.getRowCount()) {
			int linha = tabelaVeiculo.getSelectedRow();
			
			CadastroVeiculo veiculo = new CadastroVeiculo(new JFrame(), true, tabelaVeiculo, tabelaVeiculoModel, linha, 3);
			veiculo.setLocationRelativeTo(null);
			veiculo.setResizable(false);
			veiculo.setVisible(true);
			
			
		}
	}
	
	private List<Veiculo> carregaListaVeiculo(Integer numeroPagina, Integer defaultPagina) {
		
		VeiculoService veiculoService = new VeiculoService();
		List<Veiculo> listaVeiculo = new ArrayList<Veiculo>();
		
		listaVeiculo = veiculoService.listVeiculoPaginacao((defaultPagina * (numeroPagina - 1)), defaultPagina);
		return listaVeiculo;
	}
	
	private Integer buscaTotalRegistroVeiculo() {
		
		Integer totalRegistro = 0;
		
		VeiculoService veiculoService = new VeiculoService();
		totalRegistro = veiculoService.countTotalRegister();
		
		return totalRegistro;
	}
	
	public JTable getTable() {
		return tabelaVeiculo;
	}
	
	private void filtraNomeVeiculo(String filtro) {
		RowFilter<TabelaVeiculoModel, Object> rowFilter = null;
		
		try {
			rowFilter = RowFilter.regexFilter(filtro);
		}catch(PatternSyntaxException e) {
			return;
		}
		sortTabelaVeiculo.setRowFilter(rowFilter);
		
	}
	
	private void bloqueiaBotao() {
		btnInserir.setEnabled(false);
		btnExcluir.setEnabled(false);
		
		btnAlterar.setText("VISUALIZAR");
		
		
	}
}
