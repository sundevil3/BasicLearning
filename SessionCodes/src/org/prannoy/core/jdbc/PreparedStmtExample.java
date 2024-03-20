package org.prannoy.core.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PreparedStmtExample {
	private static final String DB_DRIVER = "org.postgresql.Driver";
	private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
	private static final String DB_USER = "postgres";
	private static final String DB_PASSWORD = "postgres";
	private Connection connection = null;
	public PreparedStmtExample() {
		
	}
	public static void main(String[] args) 
	{
		PreparedStmtExample pstmtEx = new PreparedStmtExample();
		pstmtEx.prepareStmtExample();
	}

	private void prepareStmtExample()
	{
//		Statement stmt = null;
		PreparedStatement pstmt = null;

		try
		{
			connection = getDBConnection();
//			String SQL = "Update Employee SET age = ? WHERE id = ? ";
			String SQL = "select * from Employee";                                   //  1            2
			pstmt = connection.prepareStatement(SQL);
			/*pstmt.setInt(1, 10);
			pstmt.setInt(2, 2);*/
			 pstmt.execute();//int count =
			ResultSet results = pstmt.getResultSet();

			while(results.next())
			{
				System.out.println(results.getInt("age"));
			}
//			System.out.println("DB Update Status: "+count);

			SQL = "select count(*) from Employee";
			pstmt = connection.prepareStatement(SQL);
			ResultSet rs  = pstmt.executeQuery();
			while(rs.next())
			{
				System.out.println("The record count "+rs.getInt(1));
			}
//			System.out.println("DB Update Status: "+update_status);
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}finally
		{
			try {
				pstmt.close();
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
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
