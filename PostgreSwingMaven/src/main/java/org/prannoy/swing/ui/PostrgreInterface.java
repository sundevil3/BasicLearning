package org.prannoy.swing.ui;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.filechooser.FileSystemView;
import org.apache.log4j.*;

import org.prannoy.swing.model.Employee;
import org.prannoy.swing.utils.PostgresUtils;

import com.opencsv.CSVReader;

public class PostrgreInterface {

	private static String filePath;
	private String idFromRow;
	private JFrame frmImcsProject;
	private JFrame frame_1 = new JFrame();
	private JFrame frame_2 = new JFrame();
	private static int rowCountOfCSV = 0;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	JLabel lblNewLabel_5 = new JLabel("First Name");
	JLabel lblNewLabel_6 = new JLabel("Last Name");
	JLabel lblNewLabel_7 = new JLabel("Email");
	JLabel lblNewLabel_8 = new JLabel("Salary");
	JButton btnSubmit_2 = new JButton("Submit");

	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTable table_1;

	String[] columnNames = { "ID", "First Name", "Last Name", "EMAIL", "Salary" };
	static String[][] employeeData;
	static String[][] employeeDataRetrievedFromDb;
	
	JPanel panelForTable;
	
	static  Logger logger = Logger.getLogger(PostrgreInterface.class.getName());

	public static void main(String[] args) {
//		int rowCountOfCSV =0;
		CSVReader reader = null;
		
		try {
			reader = new CSVReader(new FileReader("C:\\Users\\Administrator\\Desktop\\IMCS\\100_Records.csv"));
			reader.readNext();
			while((reader.readNext())!=null) {
					rowCountOfCSV++;
			}
		logger.debug("The number of records in the CSV file is: "+rowCountOfCSV);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			
			//UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			//UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		} 

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PostrgreInterface window = new PostrgreInterface();
					window.frmImcsProject.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public PostrgreInterface() {
		initialize();
	}

	private void initialize() {
		frmImcsProject = new JFrame();
		frmImcsProject.setTitle("IMCS Project 1");
		frmImcsProject.setBounds(500, 100, 470, 569);
		frmImcsProject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton btnCreateDb = new JButton("IMPORT DATA");
		btnCreateDb.setBounds(168, 112, 132, 36);


		btnCreateDb.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				jfc.setDialogTitle("Choose a directory to save your file: ");
				jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int returnValue = jfc.showSaveDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					//system.out.println("You selected the directory: " + jfc.getSelectedFile());
					filePath = jfc.getSelectedFile().toString();
				}
				CSVReader reader = null;
				String[] line;
				employeeData = new String[rowCountOfCSV][4];
				try {
					reader = new CSVReader(new FileReader(filePath));
					line = reader.readNext();
					for(int r=0;r<rowCountOfCSV;r++) {
					while((line=reader.readNext())!=null) {

							employeeData[r][0] = line[0];
							employeeData[r][1] = line[1];
							employeeData[r][2] = line[2];
							employeeData[r][3] = line[3];
							r++;
						}
					}
				
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				Employee employeeCsvInfo = new Employee(employeeData,rowCountOfCSV);
				System.out.println(employeeCsvInfo.toString());
				Employee employee1 = new Employee(1);
				Employee employee2 = new Employee(2);
				Employee employee3 = new Employee(3);
				Employee employee4 = new Employee(4);
				Employee employee5 = new Employee(5);
				Employee employee6 = new Employee(6);
				Employee employee7 = new Employee(7);
				Employee employee8 = new Employee(8);
				Employee employee9 = new Employee(9);
				Employee employee0 = new Employee(0);
				
				Thread t1 = new Thread(employee1, "THR1");
				Thread t2 = new Thread(employee2, "THR2");
				Thread t3 = new Thread(employee3, "THR3");
				Thread t4 = new Thread(employee4, "THR4");
				Thread t5 = new Thread(employee5, "THR5");
				Thread t6 = new Thread(employee6, "THR6");
				Thread t7 = new Thread(employee7, "THR7");
				Thread t8 = new Thread(employee8, "THR8");
				Thread t9 = new Thread(employee9, "THR9");
				Thread t0 = new Thread(employee0, "THR10");
				
				
				
				t1.start();
				t2.start();
				t3.start();
				t4.start();
				t5.start();
				t6.start();
				t7.start();
				t8.start();
				t9.start();
				t0.start();
				
				
				
			/*	ExecutorService executor = Executors.newFixedThreadPool(10);
				for (int i = 0; i < 10; i++) {

					Runnable worker = new Employee(i);
					executor.execute(worker);
				}
				executor.shutdown();
				while (!executor.isTerminated()) {
		 
				}*/
				try {
				t1.join();
				t2.join();
				t3.join();
				t4.join();
				t5.join();
				t6.join();
				t7.join();
				t8.join();
				t9.join();
				t0.join();
				} catch (Exception e) {
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(null,"The data has been inserted");
			}
		});

		JButton btnInsertRow = new JButton("INSERT ROW");
		btnInsertRow.setBounds(172, 203, 128, 36);


		btnInsertRow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				frame_1.getContentPane().setLayout(null);
				frame_1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame_1.setBounds(150, 100, 464, 603);
				frame_1.setVisible(true);

				textField = new JTextField();
				textField.setBounds(206, 167, 137, 31);
				frame_1.getContentPane().add(textField);
				textField.setColumns(10);
				
				textField_1 = new JTextField();
				textField_1.setBounds(206, 217, 137, 31);
				frame_1.getContentPane().add(textField_1);
				textField_1.setColumns(10);
				
				textField_2 = new JTextField();
				textField_2.setBounds(206, 266, 137, 31);
				frame_1.getContentPane().add(textField_2);
				textField_2.setColumns(10);
				
				textField_3 = new JTextField();
				textField_3.setBounds(206, 315, 137, 31);
				frame_1.getContentPane().add(textField_3);
				textField_3.setColumns(10);
				
				JLabel lblNewLabel_1 = new JLabel("First Name");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabel_1.setBounds(46, 170, 106, 20);
				frame_1.getContentPane().add(lblNewLabel_1);
				
				JLabel lblNewLabel_2 = new JLabel("Last Name");
				lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabel_2.setBounds(46, 220, 80, 14);
				frame_1.getContentPane().add(lblNewLabel_2);
				
				JLabel lblNewLabel_3 = new JLabel("Email");
				lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabel_3.setBounds(46, 269, 71, 14);
				frame_1.getContentPane().add(lblNewLabel_3);
				
				JLabel lblNewLabel_4 = new JLabel("Salary");
				lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabel_4.setBounds(46, 318, 71, 14);
				frame_1.getContentPane().add(lblNewLabel_4);
				
				btnSubmit_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
				btnSubmit_2.setBounds(135, 382, 146, 43);
				frame_1.getContentPane().add(btnSubmit_2);
	
			}
		});


		JButton btnNewButton_2 = new JButton("UPDATE DATA");
		btnNewButton_2.setBounds(168, 293, 132, 36);
	
		frmImcsProject.getContentPane().setLayout(null);
		frmImcsProject.getContentPane().add(btnCreateDb);
		frmImcsProject.getContentPane().add(btnInsertRow);
		frmImcsProject.getContentPane().add(btnNewButton_2);

		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				frame_2.getContentPane().removeAll();
				frame_2.getContentPane().revalidate();
				frame_2.getContentPane().repaint();
				frame_2.getContentPane().setLayout(null/*new FlowLayout(1,20,1)*/);
				frame_2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame_2.setBounds(200, 100, 1054, 819);
				frame_2.setVisible(true);

				JLabel lblNewLabel_5 = new JLabel("First Name");
				lblNewLabel_5.setBounds(89, 128, 88, 14);
				lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
				frame_2.getContentPane().add(lblNewLabel_5);

				JLabel lblNewLabel_6 = new JLabel("Last Name");
				lblNewLabel_6.setBounds(89, 173, 88, 14);
				lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
				frame_2.getContentPane().add(lblNewLabel_6);

				JLabel lblNewLabel_7 = new JLabel("Email");
				lblNewLabel_7.setBounds(89, 215, 88, 14);
				lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
				frame_2.getContentPane().add(lblNewLabel_7);

				JLabel lblNewLabel_8 = new JLabel("Salary");
				lblNewLabel_8.setBounds(89, 254, 88, 14);
				lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
				frame_2.getContentPane().add(lblNewLabel_8);

				JButton btnNewButton = new JButton("UPDATE ROW");
				btnNewButton.setBounds(60, 305, 118, 23);
				frame_2.getContentPane().add(btnNewButton);

				JButton btnNewButton_1 = new JButton("DELETE ROW");
				btnNewButton_1.setBounds(196, 305, 118, 23);
				frame_2.getContentPane().add(btnNewButton_1);


				textField_4 = new JTextField();
				textField_4.setBounds(187, 125, 86, 20);
				frame_2.getContentPane().add(textField_4);
				textField_4.setColumns(10);

				textField_5 = new JTextField();
				textField_5.setBounds(187, 170, 86, 20);
				frame_2.getContentPane().add(textField_5);
				textField_5.setColumns(10);

				textField_6 = new JTextField();
				textField_6.setBounds(187, 212, 86, 20);
				frame_2.getContentPane().add(textField_6);
				textField_6.setColumns(10);

				textField_7 = new JTextField();
				textField_7.setBounds(187, 251, 86, 20);
				frame_2.getContentPane().add(textField_7);
				textField_7.setColumns(10);
				
				//JUST TO PRINT THE TABLE HERE
				Connection conn = null;
				Statement statement = null;
				Statement statement2 = null;
				ResultSet rs = null;
				ResultSet rs2 = null;
				try {
					Class.forName(PostgresUtils.JDBC_DRIVER);
					conn = DriverManager.getConnection(PostgresUtils.DB_URL, PostgresUtils.USER, PostgresUtils.PASS);
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
					logger.debug("Data has been read from the database to display on the JTable ");
				} catch (Exception ex) {
					ex.printStackTrace();
				} finally {
					try {
						statement.close();
						conn.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				//ENDING PRINTING TABLE
				
				panelForTable = new JPanel();
				panelForTable.setBounds(296, 46, 726, 553);
				frame_2.getContentPane().add(panelForTable);
				panelForTable.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
				
				table_1 = new JTable(employeeDataRetrievedFromDb,columnNames);
				table_1.setRowHeight(38);
				JScrollPane sp = new JScrollPane(table_1);
				
				panelForTable.add(sp);
				frame_2.getContentPane().add(panelForTable); 

				table_1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						int row = table_1.getSelectedRow();
						idFromRow = (String) table_1.getModel().getValueAt(row, 0);
						textField_4.setBackground(Color.WHITE);
						textField_4.setText((String) table_1.getModel().getValueAt(row, 1));
						textField_5.setBackground(Color.WHITE);
						textField_5.setText((String) table_1.getModel().getValueAt(row, 2));
						textField_6.setBackground(Color.WHITE);
						textField_6.setText((String) table_1.getModel().getValueAt(row, 3));
						textField_7.setBackground(Color.WHITE);
						textField_7.setText((String) table_1.getModel().getValueAt(row, 4));
					}
				});

				btnNewButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						Connection conn = null;
						PreparedStatement preparedStatement = null;
						try {
							try {
								Class.forName(PostgresUtils.JDBC_DRIVER);
								conn = DriverManager.getConnection(PostgresUtils.DB_URL, PostgresUtils.USER, PostgresUtils.PASS);
								String sql = "UPDATE \"EMPLOYEE\"	SET \"FNAME\"=?, \"LNAME\"=?, \"EMAIL\"=?, \"SALARY\"=?	WHERE \"ID\" = ?";
								preparedStatement = conn.prepareStatement(sql);
								Employee employee = new Employee(textField_4.getText(),textField_5.getText(),textField_6.getText(),textField_7.getText());
								preparedStatement.setString(1, employee.getFirstName());
								preparedStatement.setString(2, employee.getLastName());
								preparedStatement.setString(3, employee.getEmail());
								preparedStatement.setString(4, employee.getSalary());
								preparedStatement.setInt(5, Integer.parseInt(idFromRow));
								preparedStatement.execute();
								logger.debug("Employee Record with the ID "+ Integer.parseInt(idFromRow) + " has been Updated as: "+  employee.toString());
							} 
							finally {
								preparedStatement.close();
								conn.close();
							}
						}  catch (Exception xe) {
							xe.printStackTrace();
						}
						JOptionPane.showMessageDialog(null,"Data has been updated");
						textField_4.setText("");
						textField_5.setText("");
						textField_6.setText("");
						textField_7.setText("");
						frame_2.dispose();
					}
				});
				btnNewButton_1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int row = table_1.getSelectedRow();
						idFromRow = (String) table_1.getModel().getValueAt(row, 0);
						//system.out.println(idFromRow);
						Connection conn = null;
						PreparedStatement preparedStatement = null;
						try {
							try {
								Class.forName(PostgresUtils.JDBC_DRIVER);
								conn = DriverManager.getConnection(PostgresUtils.DB_URL, PostgresUtils.USER, PostgresUtils.PASS);
								String sql = "DELETE FROM \"EMPLOYEE\" WHERE \"ID\" = ?";
								preparedStatement = conn.prepareStatement(sql);
								preparedStatement.setInt(1, Integer.parseInt(idFromRow));
								preparedStatement.execute();
								logger.debug("Employee Record with the ID"+ Integer.parseInt(idFromRow) + " has been Deleted Successfully");
							} 
							finally {
								preparedStatement.close();
								conn.close();
							}
						}  catch (Exception xe) {
							xe.printStackTrace();
						}
						JOptionPane.showMessageDialog(null,"Data has been deleted");
						textField_4.setText("");
						textField_5.setText("");
						textField_6.setText("");
						textField_7.setText("");
						frame_2.dispose();
					}
				});
			}
		});

		btnSubmit_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Connection conn = null;
				PreparedStatement preparedStatement = null;
				try {
					Employee employee = new Employee(textField.getText(),textField_1.getText(),textField_2.getText(),textField_3.getText());
					try {
						Class.forName(PostgresUtils.JDBC_DRIVER);
						conn = DriverManager.getConnection(PostgresUtils.DB_URL, PostgresUtils.USER, PostgresUtils.PASS);
						String sql = "INSERT INTO \"EMPLOYEE\"(\"FNAME\", \"LNAME\", \"EMAIL\", \"SALARY\") VALUES (?, ?, ?, ?)";
						preparedStatement = conn.prepareStatement(sql);
						preparedStatement.setString(1, employee.getFirstName());
						preparedStatement.setString(2, employee.getLastName());
						preparedStatement.setString(3, employee.getEmail());
						preparedStatement.setString(4, employee.getSalary());
						preparedStatement.execute();
						logger.debug("Employee Record with the details: "+employee.toString()+" has been inserted successfully");
					} 
					finally {
						preparedStatement.close();
						conn.close();
					}
				}  catch (Exception e) {
					e.printStackTrace();	
				}
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				JOptionPane.showMessageDialog(null,"Data has been inserted");
				frame_1.dispose();
			}
		});
	}
}
