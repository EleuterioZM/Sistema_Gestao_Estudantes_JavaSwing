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


import Model.Curso;
import Util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO {
    // Método para inserir um novo curso no banco de dados
    public void inserir(Curso curso) {
        try (Connection connection = DatabaseUtil.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO curso (id, nome) VALUES (?,?)");
            ps.setInt(1, curso.getId());
            ps.setString(2, curso.getNome());
            ps.executeUpdate();
            System.out.println("Curso cadastrado com sucesso!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Método para buscar um curso pelo ID
    public Curso buscarPorId(int id) {
        Curso curso = null;
        try (Connection connection = DatabaseUtil.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM curso WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                curso = new Curso();
                curso.setId(rs.getInt("id"));
                curso.setNome(rs.getString("nome"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return curso;
    }

    // Método para buscar todos os cursos cadastrados no banco de dados
    public List<Curso> buscarTodos() {
        List<Curso> cursos = new ArrayList<>();
        try (Connection connection = DatabaseUtil.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM curso");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Curso curso = new Curso();
                curso.setId(rs.getInt("id"));
                curso.setNome(rs.getString("nome"));
                cursos.add(curso);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return cursos;
    }

    // Método para atualizar os dados de um curso no banco de dados
    public void atualizar(Curso curso) {
        try (Connection connection = DatabaseUtil.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("UPDATE curso SET nome=? WHERE id =?");
            ps.setString(1, curso.getNome());
            ps.setInt(2, curso.getId());
            ps.executeUpdate();
            System.out.println("Curso atualizado com sucesso!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

   // Método para excluir um curso do banco de dados pelo ID
public void excluir(int id) {
    try (Connection connection = DatabaseUtil.getConnection()) {
        // Em primeiro lugar, exclua o curso da tabela 'curso'
        PreparedStatement psDeleteCurso = connection.prepareStatement("DELETE FROM curso WHERE id = ?");
        psDeleteCurso.setInt(1, id);
        psDeleteCurso.executeUpdate();
        
        System.out.println("Curso excluído com sucesso!");
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}
public boolean verificarDadosAssociados(int id) {
    try (Connection connection = DatabaseUtil.getConnection()) {
        // Verificar se existem dados associados ao curso em outras tabelas
        // Aqui você pode fazer consultas para verificar se há dados associados ao curso
        // Por exemplo, você pode verificar se há registros na tabela de estudantes que possuem o ID do curso
        String query = "SELECT COUNT(*) FROM estudante WHERE id_curso = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();

        // Se o resultado da consulta for maior que zero, significa que há dados associados ao curso
        if (resultSet.next()) {
            int count = resultSet.getInt(1);
            return count > 0;
        }
    } catch (SQLException e) {
        // Tratar qualquer exceção que possa ocorrer durante a consulta ao banco de dados
        e.printStackTrace();
    }

    // Se não encontrar dados associados ao curso, retorna false
    return false;
}

}
