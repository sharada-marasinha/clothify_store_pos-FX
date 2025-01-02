package db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static DBConnection instance;
    private Connection connection;
    private DBConnection() throws SQLException, ClassNotFoundException {
        connection= DriverManager.getConnection("jdbc:mysql://localhost/clothfystore","root","1234");
    }
//    ?useSSL=false
    public Connection getConnection(){
        return connection;
    }
    public static DBConnection getInstance() throws ClassNotFoundException, SQLException {
        if(null==instance){
            instance=new DBConnection();
        }
        return instance;
    }
}
