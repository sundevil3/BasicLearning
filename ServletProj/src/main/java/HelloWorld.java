
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorld extends HttpServlet {
 
   private String message;

   public void init() throws ServletException {
      message = "That is so damn true!";
   }
   
   public void doGet(HttpServletRequest request, HttpServletResponse response)
		      throws ServletException, IOException {
		      
		      response.setContentType("text/html");
		      String color = request.getParameter("colorAnshul");
		      String color2 = request.getParameter("colorAnshul2");
		      PrintWriter out = response.getWriter();
		      out.println("<h1> The color chosen is : " + color + "</h1>");
		      out.println("<br>");
		      out.println("<h1> The color chosen is : " + color2 + "</h1>");
		      out.close();
		      
		   }

   public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      
      response.setContentType("text/html");
      String color = request.getParameter("colorAnshul");
      
      PrintWriter out = response.getWriter();
      out.println("<h1> The color chosen is : " + color + "</h1>");
      out.close();
      
   }
   
   

   public void destroy() {
      // do nothing.
   }
}