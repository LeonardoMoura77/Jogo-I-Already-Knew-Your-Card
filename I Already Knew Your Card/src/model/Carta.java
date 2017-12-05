package model;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import controller.ControllerImagem;

public class Carta {
	
	private boolean possivelCarta = true;
	private String caminhoImagem;
	private JLabel imagem;

	public Carta(String caminhoImagem) {

		BufferedImage bufferImagem;
		ControllerImagem ctrImagem = new ControllerImagem();
		this.caminhoImagem = caminhoImagem;

		try {
			
			bufferImagem = ImageIO.read(getClass().getResource(this.caminhoImagem));
			bufferImagem = ctrImagem.adjustImage(bufferImagem, 110, 160);
			imagem = new JLabel(new ImageIcon(bufferImagem));
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}

	}

	public boolean getPossivelCarta() {

		return possivelCarta;

	}

	public void setPossivelCarta(boolean option) {

		this.possivelCarta = option;

	}

	public JLabel getImagem() {

		return imagem;

	}

	public String getCaminho() {

		return caminhoImagem;

	}
}