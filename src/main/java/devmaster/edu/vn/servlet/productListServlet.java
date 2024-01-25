package devmaster.edu.vn.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import devmaster.edu.vn.beans.Product;
import devmaster.edu.vn.conn.ConnectionUtils;
import devmaster.edu.vn.utils.ProductUtils;

@WebServlet("/productList")
public class productListServlet extends HttpServlet {
	private static final long serialVersionUID =1L;
	
	public productListServlet() {
		super();
	}
	protected void doGet(HttpServletRequest request,HttpServletResponse response ) throws ServletException,IOException {
		Connection conn=null;
		String errorString = null;
		List<Product> list = null;
		try {
			conn= ConnectionUtils.getMSSQLConnection();
			try {
				list=ProductUtils.queryProduct(conn);
				
			} catch (SQLException e) {
				e.printStackTrace();
				errorString = e.getMessage();
			}
			request.setAttribute("errorString", errorString);
			request.setAttribute("ProductList", list);
			
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/productList.jsp");
			dispatcher.forward(request, response);
			
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
			errorString = e1.getMessage();
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/productList.jsp");
			request.setAttribute("errorString", errorString);
			dispatcher.forward(request, response);
		}
	}
		protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
			doGet(request, response);
		}
}