package com.curd.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connection.connection;

/**
 * Servlet implementation class EditUser
 */
@WebServlet("/EditUser")
public class EditUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUser() {
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
		int u_id = Integer.parseInt(request.getParameter("u_id"));
		String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String dob = request.getParameter("dob");   
        String gender = request.getParameter("gender");
        String phoneno = request.getParameter("phoneno");
        String email = request.getParameter("email");
        
        User euser = new User(u_id, fname, lname, dob, gender, phoneno, email);
        euser.setFname(fname);
        euser.setLname(lname);
        euser.setDob(dob);
        euser.setGender(gender);
        euser.setPhoneno(phoneno);
        euser.setEmail(email);
        euser.setU_id(u_id);
       
        UserDataAccess userdao = new UserDataAccess(connection.getConnection());
        boolean success = userdao.editUserInfo(euser);
        if(success) {
        	response.sendRedirect("UserManage.jsp");
        }else {
        	System.out.println("error");
        }
        
	}

}
