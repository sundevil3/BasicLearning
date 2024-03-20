package org.prannoy.core.tests;

import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;

public class CsvReader {
	public static void main(String[] args) {

        String csvFile = "C:\\Users\\Administrator\\Desktop\\Fortune 1000_USA.csv";

        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(csvFile));
            String[] line;
            while ((line = reader.readNext()) != null) {
                System.out.println(line[0]+"	" + line[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
