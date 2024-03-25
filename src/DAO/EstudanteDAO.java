package DAO;

import Model.Estudante;
import Util.DatabaseUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstudanteDAO {
    // Método para inserir um novo estudante no banco de dados
    public void inserir(Estudante estudante) {
        try (Connection connection = DatabaseUtil.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO estudante (nr_matricula, nome, apelido, endereco, contacto) VALUES (?,?,?,?,?)");
            ps.setInt(1, estudante.getNrMatricula());
            ps.setString(2, estudante.getNome());
            ps.setString(3, estudante.getApelido());
            ps.setString(4, estudante.getEndereco());
            ps.setString(5, estudante.getContacto());
            ps.executeUpdate();
            System.out.println("Estudante cadastrado com sucesso!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Método para buscar um estudante pelo número de matrícula
    public Estudante buscarPorMatricula(int nrMatricula) {
        Estudante estudante = null;
        try (Connection connection = DatabaseUtil.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM estudante WHERE nr_matricula = ?");
            ps.setInt(1, nrMatricula);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                estudante = new Estudante();
                estudante.setNrMatricula(rs.getInt("nr_matricula"));
                estudante.setNome(rs.getString("nome"));
                estudante.setApelido(rs.getString("apelido"));
                estudante.setEndereco(rs.getString("endereco"));
                estudante.setContacto(rs.getString("contacto"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return estudante;
    }

    // Método para buscar todos os estudantes cadastrados no banco de dados
    public List<Estudante> buscarTodos() {
        List<Estudante> estudantes = new ArrayList<>();
        try (Connection connection = DatabaseUtil.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM estudante");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Estudante estudante = new Estudante();
                estudante.setNrMatricula(rs.getInt("nr_matricula"));
                estudante.setNome(rs.getString("nome"));
                estudante.setApelido(rs.getString("apelido"));
                estudante.setEndereco(rs.getString("endereco"));
                estudante.setContacto(rs.getString("contacto"));
                estudantes.add(estudante);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return estudantes;
    }

    // Método para atualizar os dados de um estudante no banco de dados
    public void atualizar(Estudante estudante) {
        try (Connection connection = DatabaseUtil.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("UPDATE estudante SET nome=?, apelido=?, endereco=?, contacto=? WHERE nr_matricula =?");
            ps.setString(1, estudante.getNome());
            ps.setString(2, estudante.getApelido());
            ps.setString(3, estudante.getEndereco());
            ps.setString(4, estudante.getContacto());
            ps.setInt(5, estudante.getNrMatricula());
            ps.executeUpdate();
            System.out.println("Estudante atualizado com sucesso!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Método para excluir um estudante do banco de dados pelo número de matrícula
    // Método para excluir um estudante do banco de dados pelo número de matrícula
public void excluir(int nrMatricula) {
    try (Connection connection = DatabaseUtil.getConnection()) {
        // Excluir os registros na tabela 'realiza' associados ao estudante
        PreparedStatement psDeleteRealiza = connection.prepareStatement("DELETE FROM realiza WHERE id_estudante = ?");
        psDeleteRealiza.setInt(1, nrMatricula);
        psDeleteRealiza.executeUpdate();
        
        // Em seguida, excluir o estudante da tabela 'estudante'
        PreparedStatement psDeleteEstudante = connection.prepareStatement("DELETE FROM estudante WHERE nr_matricula = ?");
        psDeleteEstudante.setInt(1, nrMatricula);
        psDeleteEstudante.executeUpdate();
        
        System.out.println("Estudante excluído com sucesso!");
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}
public boolean verificarMatriculaExistente(int nrMatricula) {
    // Variável para armazenar se a matrícula existe ou não
    boolean matriculaExiste = false;

    try (Connection connection = DatabaseUtil.getConnection()) {
        // Preparando a consulta SQL
        String sql = "SELECT COUNT(*) AS total FROM estudante WHERE nr_matricula = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, nrMatricula);

        // Executando a consulta
        ResultSet resultSet = statement.executeQuery();

        // Verificando se há resultados
        if (resultSet.next()) {
            // Obtendo o total de registros com a matrícula fornecida
            int total = resultSet.getInt("total");

            // Se o total for maior que 0, significa que a matrícula existe
            if (total > 0) {
                matriculaExiste = true;
            }
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }

    return matriculaExiste;
}

}
