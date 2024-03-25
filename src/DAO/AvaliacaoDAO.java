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


import Model.Avaliacao;
import Util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AvaliacaoDAO {
    // Método para inserir uma nova avaliação no banco de dados
    public void inserir(Avaliacao avaliacao) {
        try (Connection connection = DatabaseUtil.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO avaliacao (id, descricao, peso) VALUES (?,?,?)");
            ps.setInt(1, avaliacao.getId());
            ps.setString(2, avaliacao.getDescricao());
            ps.setDouble(3, avaliacao.getPeso());
            ps.executeUpdate();
            System.out.println("Avaliação cadastrada com sucesso!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Método para buscar uma avaliação pelo ID
    public Avaliacao buscarPorId(int id) {
        Avaliacao avaliacao = null;
        try (Connection connection = DatabaseUtil.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM avaliacao WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                avaliacao = new Avaliacao();
                avaliacao.setId(rs.getInt("id"));
                avaliacao.setDescricao(rs.getString("descricao"));
                avaliacao.setPeso(rs.getDouble("peso"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return avaliacao;
    }

    // Método para buscar todas as avaliações cadastradas no banco de dados
    public List<Avaliacao> buscarTodos() {
        List<Avaliacao> avaliacoes = new ArrayList<>();
        try (Connection connection = DatabaseUtil.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM avaliacao");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Avaliacao avaliacao = new Avaliacao();
                avaliacao.setId(rs.getInt("id"));
                avaliacao.setDescricao(rs.getString("descricao"));
                avaliacao.setPeso(rs.getDouble("peso"));
                avaliacoes.add(avaliacao);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return avaliacoes;
    }

    // Método para atualizar os dados de uma avaliação no banco de dados
    public void atualizar(Avaliacao avaliacao) {
        try (Connection connection = DatabaseUtil.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("UPDATE avaliacao SET descricao=?, peso=? WHERE id =?");
            ps.setString(1, avaliacao.getDescricao());
            ps.setDouble(2, avaliacao.getPeso());
            ps.setInt(3, avaliacao.getId());
            ps.executeUpdate();
            System.out.println("Avaliação atualizada com sucesso!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
// Método para excluir uma avaliação do banco de dados pelo ID
public void excluir(int id) {
    try (Connection connection = DatabaseUtil.getConnection()) {
        // Excluir os registros na tabela 'realiza' associados à avaliação
        PreparedStatement psDeleteRealiza = connection.prepareStatement("DELETE FROM realiza WHERE id_avaliacao = ?");
        psDeleteRealiza.setInt(1, id);
        psDeleteRealiza.executeUpdate();
        
        // Em seguida, excluir a avaliação da tabela 'avaliacao'
        PreparedStatement psDeleteAvaliacao = connection.prepareStatement("DELETE FROM avaliacao WHERE id = ?");
        psDeleteAvaliacao.setInt(1, id);
        psDeleteAvaliacao.executeUpdate();
        
        System.out.println("Avaliação excluída com sucesso!");
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}

}
