
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class JdbcDataGetter extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String JDBC_DRIVER = "org.postgresql.Driver";
	private static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/Blockbuster";
	private static final String USER = "prannoy2";
	private static final String PASS = "1234";
	private static String[][] employeeDataRetrievedFromDb;
	
	public void init() throws ServletException {
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

		Connection conn = null;
		Statement statement = null;
		Statement statement2 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			String sql = "SELECT \"ID\", \"FNAME\", \"LNAME\", \"EMAIL\", \"SALARY\" FROM \"EMPLOYEE\" ORDER BY \"ID\" ";
			statement = conn.createStatement();
			rs = statement.executeQuery(sql);
			String sql2 = "SELECT COUNT(*) FROM \"EMPLOYEE\"";
			statement2 = conn.createStatement();
			rs2 = statement2.executeQuery(sql2);
			int sizeOfTable = 100;
			while(rs2.next()) {
				sizeOfTable = rs2.getInt("count");
			}
			employeeDataRetrievedFromDb = new String[sizeOfTable][5];
			for (int r=0; r<100; r++) {
				while (rs.next()) {
					employeeDataRetrievedFromDb[r][0]= rs.getString("id");
					employeeDataRetrievedFromDb[r][1]= rs.getString("fname");
					employeeDataRetrievedFromDb[r][2]= rs.getString("lname");
					employeeDataRetrievedFromDb[r][3]= rs.getString("email");
					employeeDataRetrievedFromDb[r][4]= rs.getString("salary");
					r++;	
				}
			}
			for (int i=0; i<employeeDataRetrievedFromDb.length;i++) {
			
				Employee employee = new Employee(employeeDataRetrievedFromDb[i][1],employeeDataRetrievedFromDb[i][2],employeeDataRetrievedFromDb[i][3],employeeDataRetrievedFromDb[i][4]);
				out.println(employee.toString());
				out.println("<br>");
			}
			statement.close();
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
		
		out.close();

	}

	/*   public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

      response.setContentType("text/html");
      String color = request.getParameter("colorAnshul");

      PrintWriter out = response.getWriter();
      out.println("<h1> The color chosen is : " + color + "</h1>");
      out.close();

   }*/



	public void destroy() {
		// do nothing.
	}
}