package temp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) throws SQLException {


        Scanner sc= new Scanner(System.in);

        System.out.println("Enter Roll :");
        int roll = sc.nextInt();

        System.out.println("Enter name :");
        String name = sc.next();

        System.out.println("Enter marks :");
        int mark = sc.nextInt();


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("problem with loading the driver related main class");
        }


        String url = "jdbc:mysql://localhost:3306/test";


        try(Connection conn=  DriverManager.getConnection(url, "root", "root")) {


            Statement st= conn.createStatement();

            int x = st.executeUpdate("insert into student values('"+name+"',"+mark+","+roll+")");

            if(x > 0)
                System.out.println("record inserted sucessfully..!");
            else
                System.out.println("not inserted..");


        }catch(SQLException e) {

            e.printStackTrace();
            System.out.println(e.getMessage());
        }


    }

}