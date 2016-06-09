
package br.com.crescer.exerciciosdia03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
    
    private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String user = "CRESCER16";
    private static final String pass = "CRESCER16";
    
    public static Connection getConnection() throws SQLException{
        final Connection connection;
        connection = DriverManager.getConnection(url, user, pass);
        return connection;
    }
    
}
