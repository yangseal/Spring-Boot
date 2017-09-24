package com.cnten.platform.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class CheckMard {
	private static final char[] CHARS = { '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'K', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

	private static Random random = new Random();

	public String check(HttpServletRequest request) {
		String checkresult = "NO";
		String CHECKMARD = request.getParameter("CHECKMARD");
		System.out.println(CHECKMARD + "1");
		Object SE = request.getSession().getAttribute("checkmard");
		System.out.println(SE + "2");
		String SESSIONCHECKMARD = SE != null ? SE.toString() : "";

		if ((CHECKMARD != null) && (!SESSIONCHECKMARD.equals("")) && (SESSIONCHECKMARD.equalsIgnoreCase(CHECKMARD))) {
			System.out.println(SESSIONCHECKMARD + "3");
			checkresult = "OK";
		}
		return checkresult;
	}

	public void getChekMard(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("image/jpeg");
		String checkmard = getRandomString();
		HttpSession session = request.getSession();

		session.setAttribute("checkmard", checkmard);

		Color color = getColor();
		Color revercolor = getReverseColor(color);

		BufferedImage img = new BufferedImage(100, 30, 1);
		Graphics2D gp = img.createGraphics();
		Font font = new Font("SansSerif", 1, 20);
		gp.setFont(font);
		gp.setColor(color);
		gp.fillRect(0, 0, 100, 30);
		gp.setColor(revercolor);
		gp.drawString(checkmard, 18, 20);

		for (int i = 0; i < 20; i++) {
			gp.drawRect(random.nextInt(100), random.nextInt(30), 1, 1);
		}

		ServletOutputStream out = null;
		try {
			out = response.getOutputStream();
			JPEGImageEncoder encode = JPEGCodec.createJPEGEncoder(out);
			encode.encode(img);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
			try {
				if (out != null)
					out.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				if (out != null)
					out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static String getRandomString() {
		String str = "";
		for (int i = 0; i < 4; i++) {
			str = str + CHARS[random.nextInt(CHARS.length)];
		}
		return str;
	}

	private static Color getColor() {
		Color color = new Color(6, 65, 135);
		return color;
	}

	private static Color getReverseColor(Color c) {
		Color color = new Color(255 - c.getRed(), 255 - c.getGreen(), 255 - c.getBlue());
		return color;
	}
}
