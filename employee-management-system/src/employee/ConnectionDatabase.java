package employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConnectionDatabase {
    public Connection connection;
    public Statement statement;

    public ConnectionDatabase(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management","root","Sempakkuda_15");
            statement = connection.createStatement();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
