package com.backend.backendcadastro.rdn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactroy {
    private String URL = "jdbc:mysql://localhost:3306/animes01";
    private String USER = "root";    
    private String PASSWORD = "980612";

    public Connection getConnection()
    {
        try{
        
            return DriverManager.getConnection(this.URL, this.USER, this.PASSWORD);
            
        }
        catch(SQLException ex){              
             throw new RuntimeException(ex);
        }
    }
}
    
