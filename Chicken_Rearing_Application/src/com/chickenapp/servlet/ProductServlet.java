package com.chickenapp.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.chickenapp.database.Product;
import com.chickenapp.database.User;
import com.chickenapp.databaseDao.UserDao;
import com.chickenapp.databaseDao.*;
/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
@MultipartConfig(fileSizeThreshold=1024*1024*10, 	// 10 MB 
maxFileSize=1024*1024*50,      	// 50 MB
maxRequestSize=1024*1024*100)   	// 100 MB
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private static final String UPLOAD_DIR = "uploads";
	private String imagePath;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
       
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String productType=request.getParameter("productType");
		String description=request.getParameter("description");
		int quantity=Integer.parseInt(request.getParameter("productQuantity"));
		Float price=Float.parseFloat(request.getParameter("productPrice"));
		System.out.println(price);
		
		
		HttpSession session= request.getSession();
		session.getAttribute("user");
		User user= new User();
		int userId=user.getUserId();
		
		PrintWriter out = response.getWriter();
		//out.print(productType);
		
		Part part=request.getPart("imagePath");
		String fileName=extractFileName(part);
		
		String productImagePath ="";
	      String applicationPath = request.getServletContext().getRealPath("");
	      
	       String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;
	        
		       File fileSaveDir = new File(uploadFilePath);
		       if (!fileSaveDir.exists()) {
		           fileSaveDir.mkdirs();
		       }
		       System.out.println("Upload File Directory="+fileSaveDir.getAbsolutePath());
		       
		       String fileName1 = null;
		       //Get all the parts from request and write it to the file on server
		       for (Part part1 : request.getParts()) {
		           fileName1 = extractFileName(part);
		           part.write(uploadFilePath + File.separator + fileName1);
		       }

//		       request.setAttribute("message", fileName1 + " File uploaded successfully!");
//		       getServletContext().getRequestDispatcher("/ImageResponse.jsp").forward(
//		               request, response);
		       
		       
		       Product product=new Product(productType,description,quantity,price,fileName,userId);
				
				ProductDao accessor=new ProductDao();
				try {
					accessor.saveProduct(product);
					System.out.println("Product Upload successful");
					//getServletContext().getRequestDispatcher("/DisplayProduct").forward(request, response);
			               
					
				}catch(Exception ex) {
					System.out.println("Cannot add to the product Table");
					ex.printStackTrace();
					
				}
				
		       
			
		}
	
	
		 private String extractFileName(Part part) {
		       String contentDisp = part.getHeader("content-disposition");
		       System.out.println("content-disposition header= "+contentDisp);
		       String[] tokens = contentDisp.split(";");
		       for (String token : tokens) {
		           if (token.trim().startsWith("filename")) {
		               return token.substring(token.indexOf("=") + 2, token.length()-1);
		           }
		       }
		       return "";
		       
		     
		   }

			
	
	}
		
	

