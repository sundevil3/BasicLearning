package org.prannoy.core.tests;

import java.io.FileReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.prannoy.core.models.RunnableExampleString;

import com.opencsv.CSVReader;

public class RunnableStringTest {
	private static int rowCountOfCSV = 0;
	public static void main(String args[]) {
		//int rowCountOfCSV = 0;
		CSVReader reader = null;
		CSVReader reader2 = null;
		String[] line2;
		String[][] employeeData;
		try {
			reader = new CSVReader(new FileReader("C:\\Users\\Administrator\\Desktop\\5K_Records.csv"));
			while((reader.readNext())!=null) {
					rowCountOfCSV++;
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		employeeData = new String[rowCountOfCSV][4];
		try {
			reader2 = new CSVReader(new FileReader("C:\\Users\\Administrator\\Desktop\\5K_Records.csv"));
			line2 = reader2.readNext();
			for(int r=0;r<rowCountOfCSV;r++) {
			while((line2=reader2.readNext())!=null) {

					employeeData[r][0] = line2[0];
					employeeData[r][1] = line2[1];
					employeeData[r][2] = line2[2];
					employeeData[r][3] = line2[3];
					r++;
				}
	}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	/*	RunnableExampleString runnableExampleString = new RunnableExampleString(employeeData,rowCountOfCSV);
		
		RunnableExampleString runnableExample1 = new RunnableExampleString(1);

		
		Thread t1 = new Thread(runnableExample1, "THR1");

		t1.start();*/
		
		
		long currentTime = System.currentTimeMillis();
		ExecutorService executor = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 10; i++) {
			 

			Runnable worker = new RunnableExampleString(i);
			executor.execute(worker);
		}
		executor.shutdown();
		// Wait until all threads are finish
		while (!executor.isTerminated()) {
 
		}
		long currentTime2 = System.currentTimeMillis();
		System.out.println("Time taken for 99 rows is: "+ (currentTime2 - currentTime));
		System.out.println("\nFinished all threads");

		
	}
}
