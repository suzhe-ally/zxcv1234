package WTU.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import vo.Info;
import vo.Path;

public class CreateImageCode {
	public BufferedImage createImage(Info info,Path path) {
		BufferedImage image = new BufferedImage(444, 650,
				BufferedImage.TYPE_3BYTE_BGR);
		Graphics g = image.getGraphics();
		int width = 443;
		int height = 649;
		int x = 10;
		int y = 12;
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		g.setColor(Color.BLACK);
		g.drawLine(0, 0, width, 0);//1
		g.drawLine(0, height, width, height);
		g.drawLine(0, 0, 0, height);//1
		g.drawLine(width, 0, width, height);
		// g.setColor(Color.green);
		g.setFont(new Font("黑体", Font.BOLD, 12));
		g.drawString("始发网点："+info.getBegin(), x, y);
		g.drawString("寄件人："+info.getSender()+"  寄件人电话："+info.getSenderPhone(), x, 2 * y);
		g.drawString("寄件公司：", x, 3 * y);
		g.drawString("寄件人地址："+info.getSenderAddress(), x, 4 * y);
		g.setFont(new Font("黑体", Font.BOLD, 20));
		g.drawString("国际件", 360, 2 * y);
		g.drawString("送达", x, 7 * y);
		g.drawString("地址：", x, 7 * y + 20);
		g.setFont(new Font("黑体", Font.BOLD, 12));
		g.drawString("收件人："+info.getReceiver(), 2 * x + 40, 6 * y);
		g.drawString("收件人电话："+info.getReceiverPhone(), 2 * x + 40, 7 * y);
		g.drawString("收件公司：", 2 * x + 40, 8 * y);
		g.drawString("收件地址："+info.getReceiverAddress(), 2 * x + 40, 9 * y);
		g.setFont(new Font("黑体", Font.BOLD, 22));
		g.drawString("集包地："+info.getJibaodi(), x, 11 * y);
		g.drawString("180-E069-000", x + 60, 13 * y);
		g.drawLine(0, 13 * y + 85, width, 13 * y + 85);
		g.drawLine(0, 16 * y + 85, width, 16 * y + 85);
		g.setFont(new Font("黑体", Font.BOLD, 12));
		g.drawString("收件人/签收人", x, 14 * y + 85 + 5);
		g.drawString("签收日期：    年    月    日", (width - 1) / 2, 14 * y + 85 + 5);
		g.drawString("Name of Sign-off", x, 15 * y + 85 + 5);
		g.drawString("数量：3.6", x, 25 * y);
		g.drawLine(0, 31 * y, width, 31 * y);
		g.drawLine(0, 37 * y, width, 37 * y);
		g.drawString("寄件人："+info.getReceiver(), x, 38 * y);
		g.drawString("寄件公司：", x, 39 * y);
		g.drawString("寄件人地址："+info.getReceiverAddress(), x, 40 * y);
		g.drawLine(0, 41 * y, width, 41 * y);
		g.drawLine(280, 41 * y, 280, height);
		g.drawString("收件人："+info.getReceiver(), x, 43 * y);
		g.drawString("收件人电话："+info.getReceiverPhone(), x, 44 * y);
		g.drawString("收件公司：", x, 45 * y);
		g.drawString("收件地址："+info.getReceiverAddress(), x, 46 * y);
//		g.drawString("哈哈哈哈", 9 * x, 47 * y);
		g.drawLine(0, 49 * y, 280, 49 * y);
		g.drawString("官方网址  http://www.yundaex.com", x, 51 * y);
		g.drawString("客服热线  955466", x, 52 * y);

		/*
		 * try { g.drawImage(ImageIO.read(new File("D://二维码.png")), 100, 300,
		 * null); } catch (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		Image Img = null;
		// 插入二维码
		try {
			Img = insertImage(path.getQrCode(), 110, 110, true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.drawImage(Img, 300, 42 * y, null);
		// 插入条形码
		try {
			Img = insertImage(path.getBarCode1(), 300, 80, true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.drawImage(Img, 14 * x, 13 * y, null);
		try {
			Img = insertImage(path.getBarCode3(), 260, 60, true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.drawImage(Img, x, 32 * y, null);
		// 插入条形码2
		try {
			Img = insertImage(path.getBarCode2(), 360, 60, true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.drawImage(Img, 7 * x, 24 * y, null);
		// 插入logo
		try {
			Img = insertImage("D://logo.png", 150, 60, true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.drawImage(Img, 28 * x, 32 * y, null);
		return image;
	}

	public Image insertImage(String imgPath, int imgWidth,
			int imgHeight, boolean isCompress) throws Exception {
		File fileimage = new File(imgPath);
		Image src = ImageIO.read(fileimage);
		if (isCompress) {
			Image image = src.getScaledInstance(imgWidth, imgHeight,
					Image.SCALE_SMOOTH);
			return image;
		}
		return src;
	}
	 public BufferedImage getImage(Info info){
		 Path path=new Path();
			String pathStr="D:/graphics/";
			try {
				//三个条形码
				CreateBarcode cb=new CreateBarcode();
				BufferedImage barCode1=cb.getBarcode1(info.getNumber());
				ImageIO.write(barCode1, "jpg", new File(pathStr+"barCode1.jpg"));
				path.setBarCode1(pathStr+"barCode1.jpg");
				BufferedImage barCode2=cb.getBarcode2();
				ImageIO.write(barCode2, "jpg", new File(pathStr+"barCode2.jpg"));
				path.setBarCode2(pathStr+"barCode2.jpg");
				BufferedImage barCode3=cb.getBarcode3(info.getNumber());
				ImageIO.write(barCode3, "jpg", new File(pathStr+"barCode3.jpg"));
				path.setBarCode3(pathStr+"barCode3.jpg");
				//二维码
				CreateQRcode cqr=new CreateQRcode();
				BufferedImage qrCode=cqr.getQRcode(info.getNumber());
				ImageIO.write(qrCode, "jpg", new File(pathStr+"qrCode.jpg"));
				path.setQrCode(pathStr+"qrCode.jpg");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			//快递单
		 BufferedImage image=createImage(info,path);
		 try {
			ImageIO.write(image, "jpg", new File("D:/graphics/graphics2.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return image;
	 }
}
