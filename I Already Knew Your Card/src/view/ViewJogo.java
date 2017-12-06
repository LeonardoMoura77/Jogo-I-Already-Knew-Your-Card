package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.ControllerCarta;

public class ViewJogo implements ActionListener {

	private ControllerCarta ctrCarta = new ControllerCarta();
	private int passo = 1;

	JFrame frame = new JFrame("I ALREADY KNEW YOUR CARD");
	JPanel painelPrincipal = new JPanel(new BorderLayout());

	// Componentes do Menu
	JPanel painelInferior = new JPanel(new BorderLayout());
	JPanel painelMenu = new JPanel();
	JButton btnIniciarJogo = new JButton("Iniciar Jogo");
	JButton btnSair = new JButton("Sair");

	// Componentes do Jogo
	JPanel painelMensagem = new JPanel();
	JLabel lblMensagem = new JLabel("Memorize uma carta e diga sua fileira");
	JPanel painelCartas = new JPanel(new GridLayout(3, 1));
	JPanel painelFileira1 = new JPanel();
	JButton btnFileira1 = new JButton("Fileira 1");
	JPanel painelFileira2 = new JPanel();
	JButton btnFileira2 = new JButton("Fileira 2");
	JPanel painelFileira3 = new JPanel();
	JButton btnFileira3 = new JButton("Fileira 3");

	// Componentes do Resultado
	JPanel painelResultado = new JPanel(new BorderLayout());
	JPanel painelMensagemResultado = new JPanel();
	JLabel lblMensagemResultado = new JLabel("Está é a sua carta?");
	JPanel painelImagemCarta = new JPanel();
	JPanel painelOpcao = new JPanel();
	JButton btnSim = new JButton(("Sim"));
	JButton btnNao = new JButton(("Não"));
	JButton btnTentarNovamente = new JButton("Tentar Novamente");
	JButton btnFechar = new JButton("Menu Principal");

	public ViewJogo() {

		carregaPainelJogo();

		carregaPainelResultado();

		// Carrega painel do Menu
		btnIniciarJogo.setFont(new Font("Arial", Font.PLAIN, 20));
		btnSair.setFont(new Font("Arial", Font.PLAIN, 20));
		painelMenu.add(btnIniciarJogo);
		painelMenu.add(btnSair);
		painelInferior.add(painelMenu, BorderLayout.NORTH);
		painelInferior.add(new JLabel(" Feito por: Leonardo Pereira de Moura"), BorderLayout.SOUTH);
		painelPrincipal.add(ctrCarta.getImagemQualquer("./images/Logo.png", 880, 480), BorderLayout.CENTER);
		painelPrincipal.add(painelInferior, BorderLayout.SOUTH);

		btnIniciarJogo.addActionListener(this);
		btnSair.addActionListener(this);
		btnFileira1.addActionListener(this);
		btnFileira2.addActionListener(this);
		btnFileira3.addActionListener(this);
		btnSim.addActionListener(this);
		btnNao.addActionListener(this);
		btnTentarNovamente.addActionListener(this);
		btnFechar.addActionListener(this);

		frame.setSize(1000, 600);
		frame.add(painelPrincipal);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void carregaPainelJogo() {

		ctrCarta.inicializarNovoPacote();
		lblMensagem.setFont(new Font("Arial", Font.BOLD, 28));
		painelMensagem.add(lblMensagem);

		carregaPaineisFileira();

		painelCartas.add(painelFileira1);
		painelCartas.add(painelFileira2);
		painelCartas.add(painelFileira3);

	}

	public void repaintJogo() {

		passo = 1;
		ctrCarta.inicializarNovoPacote();
		repaintMensagem(passo);
		repaintFileiras();

		painelPrincipal.removeAll();
		painelPrincipal.add(painelMensagem, BorderLayout.NORTH);
		painelPrincipal.add(painelCartas, BorderLayout.CENTER);
		painelPrincipal.repaint();
		painelPrincipal.validate();

	}

	public void repaintMensagem(int passo) {

		painelMensagem.removeAll();

		switch (passo) {
		
		case 1:
			lblMensagem.setText("Memorize uma carta e selecione sua fileira");
			break;
			
		case 2:
			lblMensagem.setText("Procure-a e selecione sua fileira");
			break;
			
		case 3:
			lblMensagem.setText("Procure-a novamente e selecione sua fileira");
			break;
			
		default:
			lblMensagem.setText("Mais uma vez ...");
			break;
			
		}

		painelMensagem.add(lblMensagem);
		painelMensagem.repaint();
		painelMensagem.validate();

	}

	public void carregaPaineisFileira() {

		for (int coluna = 0; coluna < 7; coluna++) {

			painelFileira1.add(ctrCarta.getCarta(0, coluna));

		}

		painelFileira1.add(new JPanel());
		painelFileira1.add(new JPanel());
		btnFileira1.setFont(new Font("Arial", Font.PLAIN, 20));
		painelFileira1.add(btnFileira1);

		for (int coluna = 0; coluna < 7; coluna++) {

			painelFileira2.add(ctrCarta.getCarta(1, coluna));

		}

		painelFileira2.add(new JPanel());
		painelFileira2.add(new JPanel());
		btnFileira2.setFont(new Font("Arial", Font.PLAIN, 20));
		painelFileira2.add(btnFileira2);

		for (int coluna = 0; coluna < 7; coluna++) {

			painelFileira3.add(ctrCarta.getCarta(2, coluna));

		}

		painelFileira3.add(new JPanel());
		painelFileira3.add(new JPanel());
		btnFileira3.setFont(new Font("Arial", Font.PLAIN, 20));
		painelFileira3.add(btnFileira3);

	}

	public void repaintFileiras() {

		painelFileira1.removeAll();
		painelFileira2.removeAll();
		painelFileira3.removeAll();

		carregaPaineisFileira();

		painelFileira1.repaint();
		painelFileira2.repaint();
		painelFileira3.repaint();

		painelFileira1.validate();
		painelFileira2.validate();
		painelFileira3.validate();

	}

	public void carregaPainelResultado() {

		lblMensagemResultado.setFont((new Font("Arial", Font.BOLD, 28)));
		painelMensagemResultado.add(lblMensagemResultado);
		painelResultado.add(painelMensagemResultado, BorderLayout.NORTH);
		painelResultado.add(painelImagemCarta, BorderLayout.CENTER);
		painelResultado.add(painelOpcao, BorderLayout.SOUTH);

		btnTentarNovamente.setFont(new Font("Arial", Font.PLAIN, 20));
		btnFechar.setFont(new Font("Arial", Font.PLAIN, 20));
		btnSim.setFont(new Font("Arial", Font.PLAIN, 20));
		btnNao.setFont(new Font("Arial", Font.PLAIN, 20));
		painelOpcao.add(btnSim);
		painelOpcao.add(btnNao);

	}

	public void repaintResultado(int tipoMensagem) {

		painelMensagemResultado.remove(lblMensagemResultado);

		switch (tipoMensagem) {
		
		case 0:
			lblMensagemResultado.setText("Esta é a sua carta?");
			painelImagemCarta.removeAll();
			painelImagemCarta.add(ctrCarta.getImagemCartaCerta());
			break;
			
		case 1:
			lblMensagemResultado.setText("\"Suspeitei desde o princípio\" - Chapolin Colorado");
			painelImagemCarta.removeAll();
			painelImagemCarta.add(ctrCarta.getImagemQualquer("./images/Acerto.png", 321, 465));
			break;
			
		case 2:
			lblMensagemResultado.setText("Provavelmente você selecionou a fileira errada em uma das etapas.");
			painelImagemCarta.removeAll();
			painelImagemCarta.add(ctrCarta.getImagemQualquer("./images/FileiraErrada.png", 321, 465));
			break;
			
		case 3:	
			lblMensagemResultado.setText("Bobos da corte não são bem-vindos. Seja mais sincero da próxima vez!");
			painelImagemCarta.removeAll();
			painelImagemCarta.add(ctrCarta.getImagemQualquer("./images/CaminhoErrado.png", 321, 465));
			break;
			
		}

		painelMensagemResultado.add(lblMensagemResultado);
		painelMensagemResultado.repaint();
		painelMensagemResultado.validate();

		painelPrincipal.removeAll();
		painelPrincipal.add(painelResultado);
		painelPrincipal.repaint();
		painelPrincipal.validate();

	}

	public void repaintPainelOpcao(int tipoBotoes) {

		painelOpcao.removeAll();

		switch (tipoBotoes) {
		
		case 1:
			painelOpcao.add(btnTentarNovamente);
			painelOpcao.add(btnFechar);
			break;
			
		case 2:
			painelOpcao.add(btnSim);
			painelOpcao.add(btnNao);
			break;
			
		}

		painelOpcao.repaint();
		painelOpcao.validate();

	}

	public void repaintMenu() {

		painelPrincipal.removeAll();
		painelPrincipal.add(ctrCarta.getImagemQualquer("./images/Logo.png", 880, 480), BorderLayout.CENTER);
		painelPrincipal.add(painelInferior, BorderLayout.SOUTH);
		painelPrincipal.repaint();
		painelPrincipal.validate();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String cmd = e.getActionCommand();

		if ("Iniciar Jogo".equals(cmd)) {
			
			repaintJogo();
			
		} else if ("Sair".equals(cmd)) {
			
			System.exit(0);
			
		} if ("Fileira 1".equals(cmd)) {
			
			ctrCarta.reorganizarPacote(0);

			if (ctrCarta.getPossiveisCartas() == 1) {
				
				repaintResultado(0);
				repaintPainelOpcao(2);
				
			} else if (ctrCarta.getPossiveisCartas() == 0) {
				
				repaintResultado(3);
				repaintPainelOpcao(1);
				
			} else {
				
				passo++;
				repaintMensagem(passo);
				repaintFileiras();
				
			}

		} else if ("Fileira 2".equals(cmd)) {
			
			ctrCarta.reorganizarPacote(1);

			if (ctrCarta.getPossiveisCartas() == 1) {
				
				repaintResultado(0);
				repaintPainelOpcao(2);
				
			} else if (ctrCarta.getPossiveisCartas() == 0) {
				
				repaintResultado(3);
				repaintPainelOpcao(1);
				
			} else {
				
				passo++;
				repaintMensagem(passo);
				repaintFileiras();
				
			}

		} else if ("Fileira 3".equals(cmd)) {
			
			ctrCarta.reorganizarPacote(2);

			if (ctrCarta.getPossiveisCartas() == 1) {
				
				repaintResultado(0);
				repaintPainelOpcao(2);
				
			} else if (ctrCarta.getPossiveisCartas() == 0) {
				
				repaintResultado(3);
				repaintPainelOpcao(1);
				
			} else {
				
				passo++;
				repaintMensagem(passo);
				repaintFileiras();
				
			}
			
		} else if ("Sim".equals(cmd)) {
			
			repaintResultado(1);
			repaintPainelOpcao(1);

		} else if ("Não".equals(cmd)) {
			
			repaintResultado(2);
			repaintPainelOpcao(1);
			
		} else if ("Menu Principal".equals(cmd)) {
			
			repaintMenu();
			
		} else if ("Tentar Novamente".equals(cmd)) {
			
			repaintJogo();
			
		}

	}

}