/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author Eleuterio_Mabecuane
 */


import Model.Realiza;
import Util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RealizaDAO {
    // Método para inserir um novo registro de realização no banco de dados
    public void inserir(Realiza realizacao) {
        try (Connection connection = DatabaseUtil.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO realiza (id_estudante, id_avaliacao, nota) VALUES (?,?,?)");
            ps.setInt(1, realizacao.getIdEstudante());
            ps.setInt(2, realizacao.getIdAvaliacao());
            ps.setDouble(3, realizacao.getNota());
            ps.executeUpdate();
            System.out.println("Registro de realização cadastrado com sucesso!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Método para buscar uma realização pelo ID da avaliação
public Realiza buscarPorIdAvaliacao(int idAvaliacao) {
    Realiza realizacao = null;
    try (Connection connection = DatabaseUtil.getConnection()) {
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM realiza WHERE id_avaliacao = ?");
        ps.setInt(1, idAvaliacao);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            realizacao = new Realiza();
            realizacao.setIdEstudante(rs.getInt("id_estudante"));
            realizacao.setIdAvaliacao(rs.getInt("id_avaliacao"));
            realizacao.setNota(rs.getDouble("nota"));
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return realizacao;
}


    // Método para buscar todas as realizações cadastradas no banco de dados
    public List<Realiza> buscarTodos() {
        List<Realiza> realizacoes = new ArrayList<>();
        try (Connection connection = DatabaseUtil.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM realiza");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Realiza realizacao = new Realiza();
                realizacao.setIdEstudante(rs.getInt("id_estudante"));
                realizacao.setIdAvaliacao(rs.getInt("id_avaliacao"));
                realizacao.setNota(rs.getDouble("nota"));
                realizacoes.add(realizacao);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return realizacoes;
    }

    // Método para atualizar os dados de uma realização no banco de dados
    public void atualizar(Realiza realizacao) {
        try (Connection connection = DatabaseUtil.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("UPDATE realiza SET nota=? WHERE id_estudante =? AND id_avaliacao = ?");
            ps.setDouble(1, realizacao.getNota());
            ps.setInt(2, realizacao.getIdEstudante());
            ps.setInt(3, realizacao.getIdAvaliacao());
            ps.executeUpdate();
            System.out.println("Registro de realização atualizado com sucesso!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void excluir(int idAvaliacao) {
    try (Connection connection = DatabaseUtil.getConnection()) {
        boolean dadosAssociados = verificarDadosAssociados(idAvaliacao);

        if (dadosAssociados) {
            throw new SQLException("Existem dados associados a esta avaliação. Não é possível excluí-la.");
        } else {
            PreparedStatement psDeleteRealiza = connection.prepareStatement("DELETE FROM realiza WHERE id_avaliacao = ?");
            psDeleteRealiza.setInt(1, idAvaliacao);
          
            psDeleteRealiza.executeUpdate();
            System.out.println("Registro de realização excluído com sucesso!");
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}



public boolean verificarDadosAssociados(int idAvaliacao) {
    try (Connection connection = DatabaseUtil.getConnection()) {
        // Verificar se existem dados associados à realização na tabela 'realiza' com base no ID da avaliação
        String query = "SELECT COUNT(*) FROM realiza WHERE id_avaliacao = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, idAvaliacao);
        ResultSet resultSet = statement.executeQuery();

        // Se o resultado da consulta for maior que zero, significa que há dados associados à realização
        if (resultSet.next()) {
            int count = resultSet.getInt(1);
            return count > 0;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    // Se não encontrar dados associados à realização, retorna false
    return false;
}

}
