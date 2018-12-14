package br.com.agenda.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class FazConexao {

    public static Connection conexao;

    public static Connection getConexao() {

        try {
            Class.forName("org.mariadb.jdbc.Driver");

            conexao = DriverManager.getConnection("jdbc:mariadb://mariadbinstance.crzswjdcnrzp.us-east-2.rds.amazonaws.com:3306/" + "agenda", "root", "12345678");
            System.out.println("Conectado");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("erro na conexão");
        }

        return conexao;
}
    
    public static void main(String...a) {
        FazConexao con = new FazConexao();
        con.getConexao();
    }
}
    


//package br.com.agenda.jdbc;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//
//public class FazConexao {
//
//    public static Connection conexao;
//
//    public static Connection getConexao() {
//
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//
//            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "agenda", "root", "");
//            System.out.println("Conectado");
//
//        } catch (Exception e) {
//            System.out.println("erro na conexão");
//        }
//
//        return conexao;
//}
//    
//    public static void main(String...a) {
//        FazConexao con = new FazConexao();
//        con.getConexao();
//    }
//}
    



    
    

