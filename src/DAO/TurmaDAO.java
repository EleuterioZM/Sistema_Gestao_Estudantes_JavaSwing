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


import Model.Turma;
import Util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TurmaDAO {
    // Método para inserir uma nova turma no banco de dados
    public void inserir(Turma turma) {
        try (Connection connection = DatabaseUtil.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO turma (id, descricao) VALUES (?, ?)");
            ps.setInt(1, turma.getId());
            ps.setString(2, turma.getDescricao());
            ps.executeUpdate();
            System.out.println("Turma cadastrada com sucesso!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Método para buscar uma turma pelo ID
    public Turma buscarPorId(int id) {
        Turma turma = null;
        try (Connection connection = DatabaseUtil.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM turma WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                turma = new Turma();
                turma.setId(rs.getInt("id"));
                turma.setDescricao(rs.getString("descricao"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return turma;
    }

    // Método para buscar todas as turmas cadastradas no banco de dados
    public List<Turma> buscarTodos() {
        List<Turma> turmas = new ArrayList<>();
        try (Connection connection = DatabaseUtil.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM turma");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Turma turma = new Turma();
                turma.setId(rs.getInt("id"));
                turma.setDescricao(rs.getString("descricao"));
                turmas.add(turma);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return turmas;
    }

    // Método para atualizar os dados de uma turma no banco de dados
    public void atualizar(Turma turma) {
        try (Connection connection = DatabaseUtil.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("UPDATE turma SET descricao = ? WHERE id = ?");
            ps.setString(1, turma.getDescricao());
            ps.setInt(2, turma.getId());
            ps.executeUpdate();
            System.out.println("Turma atualizada com sucesso!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Método para excluir uma turma do banco de dados pelo ID
    public void excluir(int id) {
        try (Connection connection = DatabaseUtil.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM turma WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Turma excluída com sucesso!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

   public boolean verificarEstudantesPorTurma(int idTurma) {
    try (Connection connection = DatabaseUtil.getConnection();
         PreparedStatement ps = connection.prepareStatement("SELECT COUNT(*) FROM estudante WHERE id_turma = ?")) {
        ps.setInt(1, idTurma);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return false;
}

}

