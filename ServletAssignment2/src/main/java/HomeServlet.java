
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class HomeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public void init() throws ServletException {
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String name  = request.getParameter("userName");
		PrintWriter out = response.getWriter();
		out.println("<h1> Welcome  " + name + "</h1>");
		out.println("<br>");
		

	}

	public void destroy() {
		// do nothing.
	}
}