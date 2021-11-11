package com.mycompany.projetointegrador;

import java.sql.Connection;
import java.sql.DriverManager;

public class db {
   public static Connection connect() throws Exception{
        //1. Carregar o Driver
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");


        //2. Conectar no Banco
        //jdbc:sqlserver://localhost:1433;databaseName=jdbc_test;user=utest;password=123456
        Connection conexao = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=projetointegrador;user=livraria;password=123saber");


        //3. Retornar uma conexão para quem chamou
        return conexao; 
    }

    public static void main(String[] args) throws Exception {
        connect();
        System.out.println("Conectado!");
    }
}
