
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connection.connection;
import com.curd.user.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// PrintWriter out = response.getWriter();
		String uname = request.getParameter("uname");
		String password = request.getParameter("password");
		


		User login = new User(uname, password);
		login.setUname(uname);
		login.setPassword(password);

		Dataaccess ldao = new Dataaccess(connection.getConnection());

		if (ldao.validate(login)) {
			RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");  
	        rd.forward(request,response);
			//response.sendRedirect("welcome.jsp");
		} else {
			request.setAttribute("errorMessage", "Wrong credentials!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
			//response.sendRedirect("errorlogin.jsp");
		}
	}
}
