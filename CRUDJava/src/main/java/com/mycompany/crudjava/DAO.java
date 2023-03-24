/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crudjava;

/**
 *
 * @author aluno
 */
public class DAO {
   public class PessoaDAO {
  private Conexao conexao;

  public PessoaDAO() {
    conexao = new Conexao();
  }

  public void adicionar(Pessoa pessoa) {
    String sql = "INSERT INTO pessoas (nome, email) VALUES ('" + pessoa.getNome() + "', '" + pessoa.getEmail() + "')";

    try {
      Statement stmt = conexao.getConexao().createStatement();
      stmt.executeUpdate(sql);
      stmt.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public Pessoa obterPorId(int id) {
    String sql = "SELECT * FROM pessoas WHERE id = " + id;

    try {
      Statement stmt = conexao.getConexao().createStatement();
      ResultSet rs = stmt.executeQuery(sql);

      if (rs.next()) {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(rs.getInt("id"));
        pessoa.setNome(rs.getString("nome"));
        pessoa.setEmail(rs.getString("email"));

        rs.close();
        stmt.close();

        return pessoa;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return null;
  }

  public void atualizar(Pessoa pessoa) {
    String sql = "UPDATE pessoas SET nome = '" + pessoa.getNome() + "', email = '" + pessoa.getEmail() + "' WHERE id = " + pessoa.getId();

    try {
      Statement stmt = conexao.getConexao().createStatement();
      stmt.executeUpdate(sql);
     

}
