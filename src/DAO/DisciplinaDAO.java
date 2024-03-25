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

import Model.Disciplina;
import Util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DisciplinaDAO {
    // Método para inserir uma nova disciplina no banco de dados
    public void inserir(Disciplina disciplina) {
        try (Connection connection = DatabaseUtil.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO disciplina (id, nome, chs, credito) VALUES (?,?,?,?)");
            ps.setInt(1, disciplina.getId());
            ps.setString(2, disciplina.getNome());
            ps.setInt(3, disciplina.getChs());
            ps.setInt(4, disciplina.getCredito());
            ps.executeUpdate();
            System.out.println("Disciplina cadastrada com sucesso!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Método para buscar uma disciplina pelo ID
    public Disciplina buscarPorId(int id) {
        Disciplina disciplina = null;
        try (Connection connection = DatabaseUtil.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM disciplina WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                disciplina = new Disciplina();
                disciplina.setId(rs.getInt("id"));
                disciplina.setNome(rs.getString("nome"));
                disciplina.setChs(rs.getInt("chs"));
                disciplina.setCredito(rs.getInt("credito"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return disciplina;
    }

    // Método para buscar todas as disciplinas cadastradas no banco de dados
    public List<Disciplina> buscarTodos() {
        List<Disciplina> disciplinas = new ArrayList<>();
        try (Connection connection = DatabaseUtil.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM disciplina");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Disciplina disciplina = new Disciplina();
                disciplina.setId(rs.getInt("id"));
                disciplina.setNome(rs.getString("nome"));
                disciplina.setChs(rs.getInt("chs"));
                disciplina.setCredito(rs.getInt("credito"));
                disciplinas.add(disciplina);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return disciplinas;
    }

    // Método para atualizar os dados de uma disciplina no banco de dados
    public void atualizar(Disciplina disciplina) {
        try (Connection connection = DatabaseUtil.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("UPDATE disciplina SET nome=?, chs=?, credito=? WHERE id =?");
            ps.setString(1, disciplina.getNome());
            ps.setInt(2, disciplina.getChs());
            ps.setInt(3, disciplina.getCredito());
            ps.setInt(4, disciplina.getId());
            ps.executeUpdate();
            System.out.println("Disciplina atualizada com sucesso!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
// Método para excluir uma disciplina do banco de dados pelo ID
public void excluir(int id) {
    try (Connection connection = DatabaseUtil.getConnection()) {
        // Verifica se existem associações da disciplina em outras tabelas
        if (verificarAssociacoes(id)) {
            System.out.println("Existem associações da disciplina em outras tabelas. Não é possível excluí-la.");
            return;
        }
        
        // Se não houver associações, exclua a disciplina da tabela 'disciplina'
        PreparedStatement psDeleteDisciplina = connection.prepareStatement("DELETE FROM disciplina WHERE id = ?");
        psDeleteDisciplina.setInt(1, id);
        psDeleteDisciplina.executeUpdate();
        System.out.println("Disciplina excluída com sucesso!");
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}

// Método para verificar se existem associações da disciplina em outras tabelas
public boolean verificarAssociacoes(int id) {
    try (Connection connection = DatabaseUtil.getConnection()) {
        // Verifica se há associações da disciplina na tabela 'avaliacao_disciplina'
        PreparedStatement psVerificarAssociacoes = connection.prepareStatement("SELECT * FROM avaliacao_disciplina WHERE id_disciplina = ?");
        psVerificarAssociacoes.setInt(1, id);
        try (ResultSet rs = psVerificarAssociacoes.executeQuery()) {
            // Se houver associações encontradas, retorne true
            if (rs.next()) {
                return true;
            }
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    // Se não houver associações, retorne false
    return false;
}
public boolean verificarIdExistente(int id) {
    try (Connection connection = DatabaseUtil.getConnection();
         PreparedStatement ps = connection.prepareStatement("SELECT id FROM disciplina WHERE id = ?")) {
        ps.setInt(1, id);
        try (ResultSet rs = ps.executeQuery()) {
            return rs.next(); // Retorna true se o ID já existir na tabela
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        return false;
    }
}

}

