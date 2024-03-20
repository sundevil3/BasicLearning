package org.prannoy.core.jdbc;
import java.sql.*;

public class StoredProcExample {

	private static final String DB_DRIVER = "org.postgresql.Driver";
	private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
	private static final String DB_USER = "postgres";
	private static final String DB_PASSWORD = "postgres";
	private Connection connection = null;


	public static void main(String[] argv) {
		StoredProcExample callStore = new StoredProcExample();
//		callStore.retrieveEmployees();
		callStore.getEmployeeName();
	}


	private void getEmployeeName() {

		Statement stmt = null;
		CallableStatement cstmt = null;
		try {

			Connection connection = getDBConnection();
			String SQL = "{ ? = call getEmployeeName(?) }";
			cstmt = connection.prepareCall(SQL);
			System.out.println("Executing stored procedure...");
			cstmt.setInt(2, 2);
			cstmt.registerOutParameter(1, Types.VARCHAR);
			cstmt.execute();
			System.out.println(cstmt.getString(1));
		} catch (Exception e) {
			e.printStackTrace();
		}finally
		{
			try {
				closeStatement(stmt);
				closeConnection();
				cstmt.close();
			}catch(Exception ex)
			{

			}
		}

		/*CREATE OR REPLACE FUNCTION getEmployeeName(emp_id int) RETURNS  VARCHAR AS $EMP_NAME$
		DECLARE EMP_NAME VARCHAR;
		BEGIN
		SELECT FIRST_NAME into EMP_NAME FROM EMPLOYEE WHERE ID=emp_id;
		RETURN EMP_NAME;
		END;
		$EMP_NAME$ LANGUAGE plpgsql;*/
	}

	private void retrieveEmployees() {

		Statement stmt = null;
		CallableStatement cstmt = null;
		try {

			Connection conn = getDBConnection();
			String SQL = "{ call getemployees() }";
			cstmt = conn.prepareCall(SQL);
			System.out.println("Executing stored procedure...");
			ResultSet resultSet = cstmt.executeQuery();
			while(resultSet.next())
			{
				System.out.print(resultSet.getInt("id")+" ");
				System.out.print(resultSet.getString("first_name")+" ");
				System.out.print(resultSet.getString("last_name")+" ");
				System.out.print(resultSet.getInt("salary")+" ");
				System.out.print(resultSet.getString("emp_dept")+" ");
				System.out.print(resultSet.getString("emp_address"));
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally
		{
			try {
				cstmt.close();
				closeStatement(stmt);
				closeConnection();
			}catch(Exception ex)
			{

			}
		}
	/*	CREATE OR REPLACE FUNCTION getemployees() RETURNS SETOF employee AS $$
		SELECT * FROM employee order by id;
		$$ LANGUAGE sql;*/
	}

	private Connection getDBConnection()
	{
		try {
			if(connection == null) {
				Class.forName(DB_DRIVER);
				connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				return connection;
			}else
			{
				return connection;
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return connection;
	}

	private void closeConnection()
	{
		try
		{
			connection.close();
		}catch(Exception ex)
		{
		}
	}

	private void closeStatement(Statement stmt)
	{
		try
		{
			stmt.close();
		}catch(Exception ex)
		{
		}
	}
}
