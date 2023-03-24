/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.crudjava;

/**
 *
 * @author aluno
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUDJava {
  public class Conexao {
  private Connection conexao;

  public Conexao() {
    String url = "jdbc:mysql://localhost:3306/seu_banco_de_dados";
    String usuario = "seu_usuario";
    String senha = "sua_senha";

    try {
      conexao = DriverManager.getConnection(url, usuario, senha);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public Connection getConexao() {
    return conexao;
  }

  public void fecharConexao() {
    try {
      conexao.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}

    
}
