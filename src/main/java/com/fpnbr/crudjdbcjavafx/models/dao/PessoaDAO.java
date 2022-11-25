package com.fpnbr.crudjdbcjavafx.models.dao;

import com.fpnbr.crudjdbcjavafx.models.dto.MedicoDTO;
import com.fpnbr.crudjdbcjavafx.models.dto.PacienteDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PessoaDAO {

    private Connection connection;

    public PessoaDAO() {
        connection = ConexaoJdbcDAO.getConnection();
    }

    public void criarPaciente(PacienteDTO pacienteDTO) {
        try {
            String sql = "insert into paciente (nome, datanascimento, idade, patologia, medico) values (?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, pacienteDTO.getNome());
            preparedStatement.setString(2, pacienteDTO.getDataNascimento());
            preparedStatement.setInt(3, pacienteDTO.getIdade());
            preparedStatement.setString(4, pacienteDTO.getPatologia());
            preparedStatement.setString(5, pacienteDTO.getMedico());
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

    public ObservableList<PacienteDTO> listarPaciente() throws SQLException {
        ObservableList<PacienteDTO> list = FXCollections.observableArrayList();

        String sql = "select id, nome, datanascimento, idade, patologia, medico from paciente";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultado = preparedStatement.executeQuery();

        while (resultado.next()) {
            PacienteDTO pacienteDTO = new PacienteDTO();
            pacienteDTO.setId(resultado.getLong("id"));
            pacienteDTO.setNome(resultado.getString("nome"));
            pacienteDTO.setDataNascimento(resultado.getString("datanascimento"));
            pacienteDTO.setIdade(resultado.getInt("idade"));
            pacienteDTO.setPatologia(resultado.getString("patologia"));
            pacienteDTO.setMedico(resultado.getString("medico"));
            list.add(pacienteDTO);
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

    public void criarMedico(MedicoDTO medicoDTO) {
        try {
            String sql = "insert into medico (nome, datanascimento, idade, crm, especialidade) values (?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, medicoDTO.getNome());
            preparedStatement.setString(2, medicoDTO.getDataNascimento());
            preparedStatement.setInt(3, medicoDTO.getIdade());
            preparedStatement.setString(4, medicoDTO.getCrm());
            preparedStatement.setString(5, medicoDTO.getEspecialidade());
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

    public ObservableList<MedicoDTO> listarMedico() throws SQLException {
        ObservableList<MedicoDTO> list = FXCollections.observableArrayList();

        String sql = "select id, nome, datanascimento, idade, crm, especialidade from medico";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultado = preparedStatement.executeQuery();

        while (resultado.next()) {
            MedicoDTO medicoDTO = new MedicoDTO();
            medicoDTO.setId(resultado.getLong("id"));
            medicoDTO.setNome(resultado.getString("nome"));
            medicoDTO.setDataNascimento(resultado.getString("datanascimento"));
            medicoDTO.setIdade(resultado.getInt("idade"));
            medicoDTO.setCrm(resultado.getString("crm"));
            medicoDTO.setEspecialidade(resultado.getString("especialidade"));
            list.add(medicoDTO);
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