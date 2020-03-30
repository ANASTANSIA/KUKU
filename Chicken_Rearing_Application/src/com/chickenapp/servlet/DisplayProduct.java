package com.chickenapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chickenapp.database.Product;
import com.chickenapp.database.Program;
import com.chickenapp.databaseDao.ProductDao;
import com.chickenapp.databaseDao.ProgramDao;

/**
 * Servlet implementation class DisplayProduct
 */
@WebServlet("/DisplayProduct")
public class DisplayProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDao productdao=new ProductDao();
		List<Product> productList=productdao.selectAllProducts();
		
		PrintWriter out = response.getWriter();
		//Program program= new Program(programName, programDescription);
		
		try {
	   
		HttpSession session= request.getSession();
		 session.setAttribute("productList", productList);
		 
		 for (Product product : productList) {
			 
			 System.out.println(product.getProductType());
			
		}
			response.sendRedirect("productPage.jsp");
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Cannot retrieve the programs from database");
			
		}



	}

	

}
