package com.fpnbr.crudjdbcjavafx.models.dao;

import com.fpnbr.crudjdbcjavafx.models.ConexaoJDBC;
import com.fpnbr.crudjdbcjavafx.models.entidades.Medico;
import com.fpnbr.crudjdbcjavafx.models.entidades.Paciente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PessoaDAO {

    private Connection connection;

    public PessoaDAO() {
        connection = ConexaoJDBC.getConnection();
    }

    public void criarPaciente(Paciente paciente) {
        try {
            String sql = "insert into paciente (nome, datanascimento, idade, patologia, medico) values (?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, paciente.getNome());
            preparedStatement.setString(2, paciente.getDataNascimento());
            preparedStatement.setInt(3, paciente.getIdade());
            preparedStatement.setString(4, paciente.getPatologia());
            preparedStatement.setString(5, paciente.getMedico());
            preparedStatement.execute();
            connection.commit();
        }
        catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            }
            catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    public ObservableList<Paciente> listarPaciente() throws SQLException {
        ObservableList<Paciente> list = FXCollections.observableArrayList();

        String sql = "select id, nome, datanascimento, idade, patologia, medico from paciente";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultado = preparedStatement.executeQuery();

        while (resultado.next()) {
            Paciente paciente = new Paciente();
            paciente.setId(resultado.getLong("id"));
            paciente.setNome(resultado.getString("nome"));
            paciente.setDataNascimento(resultado.getString("datanascimento"));
            paciente.setIdade(resultado.getInt("idade"));
            paciente.setPatologia(resultado.getString("patologia"));
            paciente.setMedico(resultado.getString("medico"));
            list.add(paciente);
        }
        return list;
    }

    public void atualizarPaciente(String nome, String dataNascimento, int idade, String patologia, String medico, Long id) {
        try {
            String sql = "update paciente set nome = ?, dataNascimento = ?, idade = ?, patologia = ?, medico = ? where id = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, dataNascimento);
            preparedStatement.setInt(3, idade);
            preparedStatement.setString(4, patologia);
            preparedStatement.setString(5, medico);
            preparedStatement.setLong(6, id);
            preparedStatement.executeUpdate();
            connection.commit();
        }
        catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            }
            catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    public void deletarPaciente(Long id) throws Exception {
        try {
            String sql = "delete from paciente where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            connection.commit();
        }
        catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            }
            catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    public void criarMedico(Medico medico) {
        try {
            String sql = "insert into medico (nome, datanascimento, idade, crm, especialidade) values (?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, medico.getNome());
            preparedStatement.setString(2, medico.getDataNascimento());
            preparedStatement.setInt(3, medico.getIdade());
            preparedStatement.setString(4, medico.getCrm());
            preparedStatement.setString(5, medico.getEspecialidade());
            preparedStatement.execute();
            connection.commit();
        }
        catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            }
            catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    public ObservableList<Medico> listarMedico() throws SQLException {
        ObservableList<Medico> list = FXCollections.observableArrayList();

        String sql = "select id, nome, datanascimento, idade, crm, especialidade from medico";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultado = preparedStatement.executeQuery();

        while (resultado.next()) {
            Medico medico = new Medico();
            medico.setId(resultado.getLong("id"));
            medico.setNome(resultado.getString("nome"));
            medico.setDataNascimento(resultado.getString("datanascimento"));
            medico.setIdade(resultado.getInt("idade"));
            medico.setCrm(resultado.getString("crm"));
            medico.setEspecialidade(resultado.getString("especialidade"));
            list.add(medico);
        }
        return list;
    }

    public void atualizarMedico(String nome, String dataNascimento, int idade, String crm, String especialidade, Long id) {
        try {
            String sql = "update medico set nome = ?, dataNascimento = ?, idade = ?, patologia = ?, medico = ? where id = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, dataNascimento);
            preparedStatement.setInt(3, idade);
            preparedStatement.setString(4, crm);
            preparedStatement.setString(5, especialidade);
            preparedStatement.setLong(6, id);
            preparedStatement.executeUpdate();
            connection.commit();
        }
        catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            }
            catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    public void deletarMedico(Long id) {
        try {
            String sql = "delete from medico where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            connection.commit();
        }
        catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            }
            catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
}