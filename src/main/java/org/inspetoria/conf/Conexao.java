package org.inspetoria.conf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private Connection conn;

    public Conexao() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/inspetoria_alunos", "root", "1357");

            System.out.println("Conexão criada com sucesso!");
        }
        catch ( ClassNotFoundException | SQLException e ){
            System.out.println("Falha na conexão");
            e.printStackTrace();
        }
    }

    public Connection getConn(){
        return conn;
    }





}
