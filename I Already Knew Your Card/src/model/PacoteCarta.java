package model;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import controller.ControllerImagem;

public class PacoteCarta {
	
	private Carta pacote[][] = new Carta[3][7];
	private int qtdPossiveisCartas = 21;

	public void carregaPacote() {

		int numeroCarta = 0, auxPosicao = 0;
		int cartasEscolhidas[] = new int[21];
		boolean procura;

		for (int linha = 0; linha < 3; linha++) {

			for (int coluna = 0; coluna < 7; coluna++) {
				
				procura = true;
				
				while (procura) {

					numeroCarta = (int) (Math.random() * 52);
					int aux = 0;

					for (int k = 0; k < cartasEscolhidas.length; k++) {

						if (numeroCarta != cartasEscolhidas[k])
							aux++;

						if (aux == 21) {
							
							procura = false;
							cartasEscolhidas[auxPosicao] = numeroCarta;
							auxPosicao++;
							
						}

					}

				}

				pacote[linha][coluna] = new Carta("./images/" + numeroCarta + ".png");

			}

		}

	}

	public void reorganizarPacote(int linhaSelecionada) {

		Carta pacoteAux[][] = new Carta[3][7];
		int coluna = (int) (Math.random() * 7);
		int linha = (int) (Math.random() * 3);

		for (int i = 0; i < 7; i++) {

			for (int j = 0; j < 3; j++) {

				pacoteAux[j][i] = pacote[linha][coluna];

				if (coluna == 6) {
					
					coluna = 0;

					if (linha == 2) {
						
						linha = 0;
						
					} else {
						
						linha++;
						
					}

				} else {
					
					coluna++;
					
				}

				if (linha != linhaSelecionada) {

					if (pacote[linha][coluna].getPossivelCarta() == true) {
						
						pacote[linha][coluna].setPossivelCarta(false);
						qtdPossiveisCartas--;
						
					}

				}

			}

		}

		pacote = pacoteAux;

	}

	public JLabel getImagem(int linha, int coluna) {

		return pacote[linha][coluna].getImagem();

	}

	public int getPossiveisCartas() {

		return qtdPossiveisCartas;

	}

	public void setPossiveisCartas(int n) {

		this.qtdPossiveisCartas = n;

	}

	public JLabel getImagemCartaCerta() {

		BufferedImage bufferImagem;
		ControllerImagem ctrImagem = new ControllerImagem();

		for (int i = 0; i < 3; i++) {

			for (int j = 0; j < 7; j++) {

				if (pacote[i][j].getPossivelCarta() == true) {

					try {
						
						bufferImagem = ImageIO.read(getClass().getResource(pacote[i][j].getCaminho()));
						bufferImagem = ctrImagem.adjustImage(bufferImagem, 321, 468);
						
						return (new JLabel(new ImageIcon(bufferImagem)));
						
					} catch (IOException e) {
						
						e.printStackTrace();
						
					}

				}

			}

		}

		return null;
	}

}
