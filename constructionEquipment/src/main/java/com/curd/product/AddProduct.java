package com.curd.product;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connection.connection;

/**
 * Servlet implementation class AddProduct
 */
@WebServlet("/AddProduct")
@MultipartConfig(maxFileSize = 59999999)   // upload file's size up to 5MB
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  String pname = request.getParameter("pname");
          String quantity = request.getParameter("quantity");
          String priceperhr = request.getParameter("priceperhr");  
                    
          Product pro = new Product(pname, quantity, priceperhr);
          try{
        	  inventDataAccess prodao = new inventDataAccess(connection.getConnection());
              if(prodao.addProduct(pro)){
                  response.sendRedirect("invent.jsp");
              }else{
                  System.out.print("wrong credentials!");
              }
              
          }catch(Exception e){
              e.printStackTrace();
          }
	}
}
