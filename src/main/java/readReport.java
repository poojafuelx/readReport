import com.opencsv.CSVReader;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class readReport {

    public static void main(String... args) throws Exception
    {

        try {

            //db connections
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("","","");


            //read from mysql table
            Statement stmt = con.createStatement();
            String sql;
            sql = "SELECT * FROM campaign LIMIT 3;";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){

                String cid= rs.getString("cid");


                System.out.println("ID: " + cid);
            }





            // Create an object of filereader
            // class with CSV file as a parameter.
            FileReader filereader = new FileReader("src/main/resources/46002_Untitled_Report_20190108_172354_0.csv");


            // create csvReader object passing
            // file reader as a parameter
            CSVReader csvReader = new CSVReader(filereader);
            String[] nextRecord;

            // we are going to read data line by line
            while ((nextRecord = csvReader.readNext()) != null) {
                for (String cell : nextRecord) {
                    System.out.print(cell + "\t");
                }
                System.out.println();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
