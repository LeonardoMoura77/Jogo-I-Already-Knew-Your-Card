package controller;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

public class ControllerImagem {

	public BufferedImage adjustImage(BufferedImage imagem, int width, int height) {

		BufferedImage imageSize = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = imageSize.createGraphics();

		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(imagem, 0, 0, width, height, null);
		g2.dispose();

		return imageSize;

	}
	
}
