package com.projeto.view.porteiro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.TableRowSorter;

import com.projeto.model.models.Condominio;
import com.projeto.model.models.Porteiro;
import com.projeto.model.service.PorteiroService;
import com.projeto.view.motorista.TabelaMotorista;

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

public class TabelaPorteiro extends JInternalFrame {

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
	
	private static final int id_porteiro= 0;
	private static final int nome_Porteiro = 1;
	private static final int cpf_Porteiro= 2;
	private static final int rg_Porteiro= 3 ;
	private static final int email= 4;
	private static final int telefone= 5;

	private Condominio condominio;
	private TabelaPorteiroModel tabelaPorteiroModel;
	private TableRowSorter<TabelaPorteiroModel> sortTabelaPorteiro;
	
	
	private Integer totalData= 0;
	private Integer defaultPagina= 5;
	private Integer totalPagina= 1;
	private Integer numeroPagina= 1;
	private JTable tabelaPorteiro;
	private JButton btnRelatorio;
	
	private int acao=0;
	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TabelaPorteiro frame = new TabelaPorteiro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	 * Create the frame.
	 */
	public TabelaPorteiro(Condominio condominio, int acao) {
		this.acao = acao;
		this.condominio = condominio;
		initComponents();
		iniciaPaginacao();
		
		if(acao == 2) {
			bloqueiaBotao();
		}
	}
	private void initComponents() {
		setTitle("TABELA PORTEIRO");
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
				
				filtraNomePorteiro(filtro);
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
				incluirPorteiro();
				iniciaPaginacao();
			}
		});
		btnInserir.setFont(new Font("Arial", Font.PLAIN, 14));
		
		btnAlterar = new JButton("ALTERAR");
		btnAlterar.setIcon(new ImageIcon(TabelaMotorista.class.getResource("/com/projeto/estrutura/imagens/book_edit.png")));
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterarPorteiro();
				iniciaPaginacao();
			}
		});
		btnAlterar.setFont(new Font("Arial", Font.PLAIN, 14));
		
		btnExcluir = new JButton("EXCLUIR");
		btnExcluir.setIcon(new ImageIcon(TabelaMotorista.class.getResource("/com/projeto/estrutura/imagens/book_delete.png")));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirPorteiro();
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
		
		tabelaPorteiro = new JTable();
		scrollPane.setViewportView(tabelaPorteiro);
		contentPane.setLayout(gl_contentPane);
	}
	
	private void imprimeRelatorio() {
		RelPorteiro relPorteiro = new RelPorteiro(new JFrame(), true);
		relPorteiro.setLocationRelativeTo(null);
		setVisible(false);
		relPorteiro.setVisible(true);
		
	}
	
	protected void iniciaPaginacao() {
		totalData = buscaTotalRegistroPorteiro();
		
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
		
		tabelaPorteiroModel = new TabelaPorteiroModel();
		
		tabelaPorteiroModel.setListaPorteiro(carregaListaPorteiro(numeroPagina, defaultPagina));
		
		tabelaPorteiro.setModel(tabelaPorteiroModel);
		
		tabelaPorteiro.setFillsViewportHeight(true);
		
		tabelaPorteiro.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		tabelaPorteiroModel.fireTableDataChanged();
		
		sortTabelaPorteiro = new TableRowSorter<TabelaPorteiroModel>(tabelaPorteiroModel);
		
		tabelaPorteiro.setRowSorter(sortTabelaPorteiro);
		
		tabelaPorteiro.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		
		tabelaPorteiro.getColumnModel().getColumn(id_porteiro).setWidth(11);
		tabelaPorteiro.getColumnModel().getColumn(nome_Porteiro).setWidth(100);
		tabelaPorteiro.getColumnModel().getColumn(cpf_Porteiro).setWidth(100);
		tabelaPorteiro.getColumnModel().getColumn(rg_Porteiro).setWidth(100);
		tabelaPorteiro.getColumnModel().getColumn(email).setWidth(100);
		tabelaPorteiro.getColumnModel().getColumn(telefone).setWidth(100);
		
		lblPaginaAtual.setText(String.valueOf(numeroPagina));
		lblUltimaPagina.setText(String.valueOf(totalData));
		
	}
	
	
	private void alterarPorteiro() {
		if(tabelaPorteiro.getSelectedRow() != -1 && tabelaPorteiro.getSelectedRow() < tabelaPorteiroModel.getRowCount()) {
			int linha = tabelaPorteiro.getSelectedRow();
			
			CadastroPorteiro porteiro = new CadastroPorteiro(new JFrame(), true, tabelaPorteiro, tabelaPorteiroModel, linha, 2, this.condominio);
			porteiro.setLocationRelativeTo(null);
			porteiro.setResizable(false);
			porteiro.setVisible(true);
			
			
		}
		
	}

	private void incluirPorteiro() {
		CadastroPorteiro porteiro = new CadastroPorteiro(new JFrame(), true, tabelaPorteiro, tabelaPorteiroModel, 0, 1, this.condominio);
		porteiro.setLocationRelativeTo(null);
		porteiro.setResizable(false);
		porteiro.setVisible(true);
		
	}
	
	private void excluirPorteiro() {
		if(tabelaPorteiro.getSelectedRow() != -1 && tabelaPorteiro.getSelectedRow() < tabelaPorteiroModel.getRowCount()) {
			int linha = tabelaPorteiro.getSelectedRow();
			
			CadastroPorteiro porteiro = new CadastroPorteiro(new JFrame(), true, tabelaPorteiro, tabelaPorteiroModel, linha, 3, this.condominio);
			porteiro.setLocationRelativeTo(null);
			porteiro.setResizable(false);
			porteiro.setVisible(true);
			
		}
	}
	
	private List<Porteiro> carregaListaPorteiro(Integer numeroPagina, Integer defaultPagina) {
		
		PorteiroService porteiroService = new PorteiroService();
		List<Porteiro> listaPorteiro = new ArrayList<Porteiro>();
		
		listaPorteiro = porteiroService.listPorteiroPaginacao((defaultPagina * (numeroPagina - 1)), defaultPagina);
		return listaPorteiro;
	}
	
	private Integer buscaTotalRegistroPorteiro() {
		
		Integer totalRegistro = 0;
		
		PorteiroService porteiroService = new PorteiroService();
		totalRegistro = porteiroService.countTotalRegister();
		
		return totalRegistro;
	}
	
	public JTable getTable() {
		return tabelaPorteiro;
	}
	
	private void filtraNomePorteiro(String filtro) {
		RowFilter<TabelaPorteiroModel, Object> rowFilter = null;
		
		try {
			rowFilter = RowFilter.regexFilter(filtro);
		}catch(PatternSyntaxException e) {
			return;
		}
		sortTabelaPorteiro.setRowFilter(rowFilter);
		
	}
	
	private void bloqueiaBotao() {
		btnInserir.setEnabled(false);
		btnExcluir.setEnabled(false);
		
		btnAlterar.setText("VISUALIZAR");
		
		
	}
}
