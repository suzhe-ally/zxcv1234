package WTU.controller;


import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.CreateBarcode;
import util.CreateImageCode;
import util.CreateQRcode;
import vo.Info;
import dao.InfoDao;

@WebServlet(urlPatterns = "/createImageCode.do")
public class CreateImageController extends HttpServlet {

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	/*	request.setCharacterEncoding("utf-8");
		String number=request.getParameter("number");
		InfoDao dao=new InfoDao();
		Info info=dao.get(number);*/
		HttpSession session=request.getSession();
		Info info=(Info)session.getAttribute("info");
		CreateImageCode ci=new CreateImageCode();
		BufferedImage image=ci.getImage(info);
		response.setContentType("img/jpeg");
		response.setDateHeader("Expires", 0);
		ServletOutputStream out=response.getOutputStream();
		ImageIO.write(image, "JPEG", out);
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	/*	request.setCharacterEncoding("utf-8");
		String number=request.getParameter("number");
		InfoDao dao=new InfoDao();
		Info info=dao.get(number);
		CreateImageCode ci=new CreateImageCode();
		BufferedImage image=ci.getImage(info);
		response.setContentType("img/jpeg");
		response.setDateHeader("Expires", 0);
		ServletOutputStream out=response.getOutputStream();
		ImageIO.write(image, "JPEG", out);
		out.flush();
		out.close();*/
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
