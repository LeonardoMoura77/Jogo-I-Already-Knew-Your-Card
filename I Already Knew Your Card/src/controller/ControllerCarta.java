package controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import model.PacoteCarta;

public class ControllerCarta {
	
	private PacoteCarta pacote = new PacoteCarta();

	public void carregarPacote() {

		pacote.carregaPacote();

	}

	public JLabel getCarta(int linha, int coluna) {

		return pacote.getImagem(linha, coluna);

	}

	public void reorganizarPacote(int linhaSelecionada) {

		pacote.reorganizarPacote(linhaSelecionada);

	}

	public int getPossiveisCartas() {

		return pacote.getPossiveisCartas();

	}

	public JLabel getImagemCartaCerta() {

		return pacote.getImagemCartaCerta();

	}

	public JLabel getImagemQualquer(String caminhoImagem, int width, int height) {

		BufferedImage bufferImagem;
		ControllerImagem ctrImagem = new ControllerImagem();

		try {

			bufferImagem = ImageIO.read(getClass().getResource(caminhoImagem));
			bufferImagem = ctrImagem.adjustImage(bufferImagem, width, height);

			return new JLabel(new ImageIcon(bufferImagem));

		} catch (IOException e) {

			e.printStackTrace();

		}

		return null;

	}

	public void inicializarNovoPacote() {

		pacote.carregaPacote();
		pacote.setPossiveisCartas(21);

	}
	
}