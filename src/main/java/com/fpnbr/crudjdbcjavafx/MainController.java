package com.fpnbr.crudjdbcjavafx;

import com.fpnbr.crudjdbcjavafx.models.dao.PessoaDAO;
import com.fpnbr.crudjdbcjavafx.models.dto.PacienteDTO;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    PessoaDAO pessoaDAO = new PessoaDAO();
    Alert alert = new Alert(Alert.AlertType.INFORMATION);

    @FXML
    private Button btnAtualizar;

    @FXML
    private Button btnCadastrar;

    @FXML
    private Button btnDeletar;

    @FXML
    private TableColumn<PacienteDTO, String> colunaDataNascimento;

    @FXML
    private TableColumn<PacienteDTO, Long> colunaID;

    @FXML
    private TableColumn<PacienteDTO, Integer> colunaIdade;

    @FXML
    private TableColumn<PacienteDTO, String> colunaMedico;

    @FXML
    private TableColumn<PacienteDTO, String> colunaNome;

    @FXML
    private TableColumn<PacienteDTO, String> colunaPatologia;

    @FXML
    private TableView<PacienteDTO> tabela;

    @FXML
    private TextField txtDataNascimento;

    @FXML
    private TextField txtIdade;

    @FXML
    private TextField txtMedico;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtPatologia;

    private int myIndex;

    private long id;

    public void tabelaPaciente() throws SQLException {
        tabela.setItems(pessoaDAO.listarPaciente());
        colunaID.setCellValueFactory(f -> f.getValue().idProperty().asObject());
        colunaNome.setCellValueFactory(f -> f.getValue().nomeProperty());
        colunaDataNascimento.setCellValueFactory(f -> f.getValue().dataNascimento());
        colunaIdade.setCellValueFactory(f -> f.getValue().idade().asObject());
        colunaPatologia.setCellValueFactory(f -> f.getValue().patologiaProperty());
        colunaMedico.setCellValueFactory(f -> f.getValue().medicoProperty());

        tabela.setRowFactory(tv -> {
            TableRow<PacienteDTO> tableRow = new TableRow<>();
            tableRow.setOnMouseClicked(event ->
            {
                if (event.getClickCount() == 1 && (!tableRow.isEmpty())) {
                    myIndex = tabela.getSelectionModel().getSelectedIndex();
                    id = (tabela.getItems().get(myIndex).getId());
                    txtNome.setText(tabela.getItems().get(myIndex).getNome());
                    txtDataNascimento.setText(tabela.getItems().get(myIndex).getDataNascimento());
                    txtIdade.setText(Integer.toString((tabela.getItems().get(myIndex).getIdade())));
                    txtPatologia.setText(tabela.getItems().get(myIndex).getPatologia());
                    txtMedico.setText(tabela.getItems().get(myIndex).getMedico());
                }
            });
            return tableRow;
        });
    }

    @FXML
    void Add(ActionEvent event) throws SQLException {
        String nome, dataNascimento, patologia, medico;
        int idade;
        nome = txtNome.getText();
        dataNascimento = txtDataNascimento.getText();
        idade = Integer.parseInt(txtIdade.getText());
        patologia = txtPatologia.getText();
        medico = txtMedico.getText();

        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setNome(nome);
        pacienteDTO.setDataNascimento(dataNascimento);
        pacienteDTO.setIdade(idade);
        pacienteDTO.setPatologia(patologia);
        pacienteDTO.setMedico(medico);
        pessoaDAO.criarPaciente(pacienteDTO);

        alert.setTitle("Tela de registro");
        alert.setHeaderText("Registro de Paciente");
        alert.setContentText("Paciente registrado!");
        alert.showAndWait();

        tabelaPaciente();

        txtNome.setText("");
        txtDataNascimento.setText("");
        txtIdade.setText("");
        txtPatologia.setText("");
        txtMedico.setText("");
        txtNome.requestFocus();
    }

    @FXML
    void Delete(ActionEvent event) throws Exception {
        myIndex = tabela.getSelectionModel().getSelectedIndex();
        id = tabela.getItems().get(myIndex).getId();
        pessoaDAO.deletarPaciente(id);

        alert.setTitle("Tela de registro");
        alert.setHeaderText("Deleção de Paciente");
        alert.setContentText("Paciente Deletado!");
        alert.showAndWait();

        tabelaPaciente();
    }

    @FXML
    void Update(ActionEvent event) throws SQLException {
        String nome, dataNascimento, patologia, medico;
        int idade;
        myIndex = tabela.getSelectionModel().getSelectedIndex();
        id = tabela.getItems().get(myIndex).getId();
        nome = txtNome.getText();
        dataNascimento = txtDataNascimento.getText();
        idade = Integer.parseInt(txtIdade.getText());
        patologia = txtPatologia.getText();
        medico = txtMedico.getText();
        pessoaDAO.atualizarPaciente(nome, dataNascimento, idade, patologia, medico, id);

        alert.setTitle("Tela de registro");
        alert.setHeaderText("Atualização de Paciente");
        alert.setContentText("Paciente Atualizado!");
        alert.showAndWait();

        tabelaPaciente();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            tabelaPaciente();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}