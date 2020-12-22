package WTU.util;


import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class CreateQRcode {
	public static BufferedImage createQRCode(String contents,int width,int height,int margin){
		//��ά�������������
		Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
		// ���ñ����ַ���utf-8
		 hints.put(EncodeHintType.CHARACTER_SET, CharacterSetECI.UTF8);
		/* ���þ���ȼ�L/M/Q/H,����ά�뱻���һ����ʱ������ȼ�Խ�ߣ�Խ���ܶ�ȡ�ɹ���
		 ͬ���ģ�����ȼ�Խ�ߣ���λ����ڵ���ĵ�Խ�࣬����ɨ��ʱ��ʶ������ʱ��Խ������ǰ���õȼ�Ϊ��ߵȼ�H*/
		 hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
		// �����÷�ΧΪ0-10�������ĸ��仯0 1(2) 3(4 5 6) 7(8 9 10)
		 hints.put(EncodeHintType.MARGIN, margin);
	       // ����ͼƬ����ΪQRCode
	        BarcodeFormat format = BarcodeFormat.QR_CODE;
		// ����λ�������
	        BitMatrix matrix = null;
	        try {
	            // ���ɶ�ά���Ӧ��λ�������
	            matrix = new MultiFormatWriter().encode(contents, format, width, height, hints);
	        } catch (WriterException e) {
	            e.printStackTrace();
	        }
	        // ����λ����תͼƬ�Ĳ���
	        MatrixToImageConfig config = new MatrixToImageConfig(Color.black.getRGB(), Color.white.getRGB());
	        // λ�������תBufferedImage����
	        BufferedImage qrcode = MatrixToImageWriter.toBufferedImage(matrix, config);
	        return qrcode;
	}
	public static boolean generateQRCodeToPath(BufferedImage bufferedImage,String filePath){
		boolean result = false;
        try {
            // ���ͼƬ�ļ���ָ��λ��
            result = ImageIO.write(bufferedImage, "png", new File("D://��ά��.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
	}
	public BufferedImage getQRcode(String number){
        int width = 220;// ��ά����
        int height = 220;// ��ά��߶�
        int margin = 0;// ��ά��߾�
		//���ɶ�ά��
		BufferedImage qrcode =createQRCode(number,width,height,margin);
		return qrcode;
	}
}
