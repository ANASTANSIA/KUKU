package com.chickenapp.servlet;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
       
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String productType=request.getParameter("productType");
		String description=request.getParameter("descriprion");
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		Float price=Float.parseFloat(request.getParameter("price"));
		String imagePath =request.getParameter("productImagePath");

		Product product=new Product(productType,description,quantity,price,imagePath);
		
		ProductDao accessor=new ProductDao();
		
		try {
			accessor.saveProduct(product);
			System.out.println("nice it worked");
			response.sendRedirect("productlanding.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public String processImage(HttpServletRequest request , HttpServletResponse response) {
		String imagePath;
	      String applicationPath = request.getServletContext().getRealPath("");
	       // constructs path of the directory to save uploaded file
	       String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;
	        
	       // creates the save directory if it does not exists
	       File fileSaveDir = new File(uploadFilePath);
	       if (!fileSaveDir.exists()) {
	           fileSaveDir.mkdirs();
	       }
	       System.out.println("Upload File Directory="+fileSaveDir.getAbsolutePath());
	       
	       String fileName = null;
	       //Get all the parts from request and write it to the file on server
	       for (Part part : request.getParts()) {
	           fileName = getFileName(part);
	           part.write(uploadFilePath + File.separator + fileName);
	       }

	       request.setAttribute("message", fileName + " File uploaded successfully!");
	       getServletContext().getRequestDispatcher("/ImageResponse.jsp").forward(
	               request, response);
	       return imagePath;
	   }

	   /**
	    * Utility method to get file name from HTTP header content-disposition
	    */
	   private String getFileName(Part part) {
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
	
}
