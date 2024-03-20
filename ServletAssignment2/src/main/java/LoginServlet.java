
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public void init() throws ServletException {
		// do nothing.
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String name = request.getParameter("userName");
		String passWord = request.getParameter("passWord"); 
		PrintWriter out = response.getWriter();
		/*out.println("<h1> Hi " + name+ "</h1>");
		out.println("<br>");*/
		if(passWord.equals("12345")) {
			RequestDispatcher rd = request.getRequestDispatcher("homePage");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			out.println("<h1> Hi " + name+ "! The Username Passwrod combo you entered is wrong!</h1>");
			rd.include(request, response);
			
		}
		 

	}



	public void destroy() {
		// do nothing.
	}
}