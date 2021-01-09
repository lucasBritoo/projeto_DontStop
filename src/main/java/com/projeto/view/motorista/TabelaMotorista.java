package com.projeto.view.motorista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableRowSorter;

import com.projeto.model.models.Condominio;
import com.projeto.model.models.Motorista;
import com.projeto.model.models.Porteiro;
import com.projeto.model.service.MotoristaService;
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

public class TabelaMotorista extends JInternalFrame {

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
	
	private static final int id_motorista= 0;
	private static final int nome_Motorista = 1;
	private static final int cpf_Motorista= 2;
	private static final int rg_Motorista= 3 ;
	private static final int telefone= 4;
	private static final int email= 5;

	private Condominio condominio;
	//private Porteiro porteiro;
	private TabelaMotoristaModel tabelaMotoristaModel;
	private TableRowSorter<TabelaMotoristaModel> sortTabelaMotorista;
	
	
	private Integer totalData= 0;
	private Integer defaultPagina= 5;
	private Integer totalPagina= 1;
	private Integer numeroPagina= 1;
	private JTable tabelaMotorista;
	private JButton btnRelatorio;
	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TabelaMotorista frame = new TabelaMotorista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	 * Create the frame.
	 */
	public TabelaMotorista(Condominio condominio) {
		this.condominio = condominio;
		//this.porteiro = porteiro;
		initComponents();
		//iniciaPaginacao();
	}
	private void initComponents() {
		setTitle("Tabela Motorista");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(175, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		scrollPane = new JScrollPane();
		
		lblPesquisar = new JLabel("Pesquisar:");
		lblPesquisar.setFont(new Font("Arial", Font.PLAIN, 16));
		
		txtPesquisar = new JTextField();
		txtPesquisar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String filtro = txtPesquisar.getText();
				
				filtraNomeMotorista(filtro);
			}
		});
		txtPesquisar.setToolTipText("Digite um CPF");
		txtPesquisar.setColumns(10);
		
		btnPesquisar = new JButton("");
		btnPesquisar.setIcon(new ImageIcon(TabelaMotorista.class.getResource("/com/projeto/estrutura/imagens/search.png")));
		btnPesquisar.setToolTipText("Buscar");
		
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
		
		btnInserir = new JButton("INSERIR");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				incluirMotorista();
				iniciaPaginacao();
			}
		});
		btnInserir.setFont(new Font("Arial", Font.PLAIN, 16));
		
		btnAlterar = new JButton("ALTERAR");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterarMotorista();
				iniciaPaginacao();
			}
		});
		btnAlterar.setFont(new Font("Arial", Font.PLAIN, 16));
		
		btnExcluir = new JButton("EXCLUIR");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirMotorista();
				iniciaPaginacao();
			}
		});
		btnExcluir.setFont(new Font("Arial", Font.PLAIN, 16));
		
		btnSair = new JButton("SAIR");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSair.setFont(new Font("Arial", Font.PLAIN, 16));
		
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
		
		btnRelatorio = new JButton("RELAT\u00D3RIO");
		btnRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imprimeRelatorio();
			}
		});
		btnRelatorio.setFont(new Font("Arial", Font.PLAIN, 16));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(68)
							.addComponent(lblPesquisar, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(txtPesquisar, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE)
							.addGap(27)
							.addComponent(btnPesquisar, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 687, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(34)
							.addComponent(lblPagina, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addGap(51)
							.addComponent(btnPrimeiro, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnProximo, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnAnterior, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnUltimo, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
							.addGap(45)
							.addComponent(lblPaginaDefinida, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(lblPaginaAtual, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(lblDe, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(lblUltimaPagina, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(58)
							.addComponent(btnInserir, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnAlterar, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnExcluir, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnRelatorio)))
					.addContainerGap(57, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addComponent(lblPesquisar, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(txtPesquisar, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnPesquisar, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 321, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(5)
							.addComponent(lblPagina, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(11)
							.addComponent(lblPaginaAtual, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(9)
							.addComponent(lblDe, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(11)
							.addComponent(lblUltimaPagina, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(9)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPaginaDefinida, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnPrimeiro, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addComponent(btnAnterior)
									.addComponent(btnProximo, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnUltimo)))))
					.addGap(52)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnInserir, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAlterar, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnExcluir, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnRelatorio, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		
		tabelaMotorista = new JTable();
		scrollPane.setViewportView(tabelaMotorista);
		contentPane.setLayout(gl_contentPane);
	}
	
	private void imprimeRelatorio() {
		RelMotorista relMotorista = new RelMotorista(new JFrame(), true);
		relMotorista.setLocationRelativeTo(null);
		setVisible(false);
		relMotorista.setVisible(true);
		
	}
	
	protected void iniciaPaginacao() {
		totalData = buscaTotalRegistroMotorista();
		
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
		
		tabelaMotoristaModel = new TabelaMotoristaModel();
		
		tabelaMotoristaModel.setListaMotorista(carregaListaMotorista(numeroPagina, defaultPagina));
		
		tabelaMotorista.setModel(tabelaMotoristaModel);
		
		tabelaMotorista.setFillsViewportHeight(true);
		
		tabelaMotorista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		tabelaMotoristaModel.fireTableDataChanged();
		
		sortTabelaMotorista = new TableRowSorter<TabelaMotoristaModel>(tabelaMotoristaModel);
		
		tabelaMotorista.setRowSorter(sortTabelaMotorista);
		
		tabelaMotorista.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		
		tabelaMotorista.getColumnModel().getColumn(id_motorista).setWidth(11);
		tabelaMotorista.getColumnModel().getColumn(nome_Motorista).setWidth(50);
		tabelaMotorista.getColumnModel().getColumn(cpf_Motorista).setWidth(50);
		tabelaMotorista.getColumnModel().getColumn(rg_Motorista).setWidth(50);
		tabelaMotorista.getColumnModel().getColumn(email).setWidth(50);
		tabelaMotorista.getColumnModel().getColumn(telefone).setWidth(50);
		
		
		lblPaginaAtual.setText(String.valueOf(numeroPagina));
		lblUltimaPagina.setText(String.valueOf(totalData));
		
	}
	
	
	private void alterarMotorista() {
		if(tabelaMotorista.getSelectedRow() != -1 && tabelaMotorista.getSelectedRow() < tabelaMotoristaModel.getRowCount()) {
			int linha = tabelaMotorista.getSelectedRow();
			
			CadastroMotorista motorista = new CadastroMotorista(new JFrame(), true, tabelaMotorista, tabelaMotoristaModel, linha, 2, this.condominio);
			motorista.setLocationRelativeTo(null);
			motorista.setResizable(false);
			motorista.setVisible(true);
			
			
		}
		
	}

	private void incluirMotorista() {
		CadastroMotorista motorista = new CadastroMotorista(new JFrame(), true, tabelaMotorista, tabelaMotoristaModel, 0, 1, this.condominio);
		motorista.setLocationRelativeTo(null);
		motorista.setResizable(false);
		motorista.setVisible(true);
		
	}
	
	private void excluirMotorista() {
		if(tabelaMotorista.getSelectedRow() != -1 && tabelaMotorista.getSelectedRow() < tabelaMotoristaModel.getRowCount()) {
			int linha = tabelaMotorista.getSelectedRow();
			
			CadastroMotorista motorista = new CadastroMotorista(new JFrame(), true, tabelaMotorista, tabelaMotoristaModel, linha, 3, this.condominio);
			motorista.setLocationRelativeTo(null);
			motorista.setResizable(false);
			motorista.setVisible(true);
			
			
		}
	}
	
	private List<Motorista> carregaListaMotorista(Integer numeroPagina, Integer defaultPagina) {
		
		MotoristaService motoristaService = new MotoristaService();
		List<Motorista> listaMotorista = new ArrayList<Motorista>();
		
		listaMotorista = motoristaService.listMotoristaPaginacao((defaultPagina * (numeroPagina - 1)), defaultPagina);
		return listaMotorista;
	}
	
	private Integer buscaTotalRegistroMotorista() {
		
		Integer totalRegistro = 0;
		
		MotoristaService motoristaService = new MotoristaService();
		totalRegistro = motoristaService.countTotalRegister();
		
		return totalRegistro;
	}
	
	public JTable getTable() {
		return tabelaMotorista;
	}
	
	private void filtraNomeMotorista(String filtro) {
		RowFilter<TabelaMotoristaModel, Object> rowFilter = null;
		
		try {
			rowFilter = RowFilter.regexFilter(filtro);
		}catch(PatternSyntaxException e) {
			return;
		}
		sortTabelaMotorista.setRowFilter(rowFilter);
		
	}
}
