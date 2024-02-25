package HongZe.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/signin")
public class SingInServlet extends HttpServlet {
	// 模拟一个数据库:
	private Map<String, String> users = Map.of("fan", "fan123", "zhuo", "zhuo123", "jiaze", "jiaze123", "jiahong",
			"jiahong123");

	// GET请求时显示登录页:
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		pw.write("<h1>Sing In</h1>");
		pw.write("<form action=\"/signin\" method=\"post\">");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
