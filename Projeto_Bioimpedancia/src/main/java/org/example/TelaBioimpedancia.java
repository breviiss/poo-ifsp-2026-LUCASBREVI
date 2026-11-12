package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TelaBioimpedancia extends Application {

    private Historico historico = new Historico();

    private TextField txtNome = new TextField();
    private TextField txtIdade = new TextField();
    private ComboBox<String> cbSexo = new ComboBox<>();
    private TextField txtAltura = new TextField();
    private TextField txtPeso = new TextField();
    private TextField txtResistencia = new TextField();
    private TextField txtReatancia = new TextField();
    private TextArea areaResultado = new TextArea();
    private TextArea areaHistorico = new TextArea();

    @Override
    public void start(Stage stage) {
        cbSexo.getItems().add("Masculino");
        cbSexo.getItems().add("Feminino");

        areaResultado.setEditable(false);
        areaResultado.setPrefRowCount(9);
        areaHistorico.setEditable(false);
        areaHistorico.setPrefRowCount(6);
        areaHistorico.setText(historico.gerarResumo());

        GridPane form = new GridPane();
        form.setHgap(10);
        form.setVgap(8);
        form.addRow(0, new Label("Nome:"), txtNome);
        form.addRow(1, new Label("Idade:"), txtIdade);
        form.addRow(2, new Label("Sexo:"), cbSexo);
        form.addRow(3, new Label("Altura (cm):"), txtAltura);
        form.addRow(4, new Label("Peso (kg):"), txtPeso);
        form.addRow(5, new Label("Resistencia (ohm):"), txtResistencia);
        form.addRow(6, new Label("Reatancia (ohm):"), txtReatancia);

        Button btnCalcular = new Button("Calcular");
        btnCalcular.setOnAction(e -> calcular());

        Button btnLimpar = new Button("Limpar campos");
        btnLimpar.setOnAction(e -> limparCampos());

        Button btnLimparHistorico = new Button("Limpar historico");
        btnLimparHistorico.setOnAction(e -> limparHistorico());

        HBox botoes = new HBox(10, btnCalcular, btnLimpar, btnLimparHistorico);

        VBox raiz = new VBox(10, form, botoes,
                new Label("Resultado:"), areaResultado,
                new Label("Historico:"), areaHistorico);
        raiz.setPadding(new Insets(16));

        stage.setTitle("Sistema de Bioimpedancia");
        stage.setScene(new Scene(raiz, 480, 740));
        stage.show();
    }

    private void calcular() {
        String nome = txtNome.getText().trim();
        if (nome.isEmpty()) {
            mostrarAviso("Digite o nome do paciente!");
            return;
        }
        if (cbSexo.getValue() == null) {
            mostrarAviso("Escolha o sexo!");
            return;
        }

        try {
            int idade = Integer.parseInt(txtIdade.getText().trim());
            double altura = converter(txtAltura.getText());
            double peso = converter(txtPeso.getText());
            double resistencia = converter(txtResistencia.getText());
            double reatancia = converter(txtReatancia.getText());

            if (idade <= 0 || altura <= 0 || peso <= 0 || resistencia <= 0 || reatancia < 0) {
                mostrarAviso("Os valores precisam ser maiores que zero!");
                return;
            }

            Paciente paciente;
            if (cbSexo.getValue().equals("Masculino")) {
                paciente = new Homem(nome, idade, altura);
            } else {
                paciente = new Mulher(nome, idade, altura);
            }

            Avaliacao avaliacao = new Avaliacao(paciente, peso, resistencia, reatancia);
            historico.adicionar(avaliacao);

            areaResultado.setText(avaliacao.gerarRelatorio());
            areaHistorico.setText(historico.gerarResumo());

        } catch (NumberFormatException erro) {
            mostrarAviso("Digite apenas numeros nos campos de numero!");
        }
    }

    private double converter(String texto) {
        texto = texto.trim().replace(",", ".");
        return Double.parseDouble(texto);
    }

    private void limparCampos() {
        txtNome.clear();
        txtIdade.clear();
        cbSexo.setValue(null);
        txtAltura.clear();
        txtPeso.clear();
        txtResistencia.clear();
        txtReatancia.clear();
        areaResultado.clear();
    }

    private void limparHistorico() {
        historico.limpar();
        areaHistorico.setText(historico.gerarResumo());
    }

    private void mostrarAviso(String mensagem) {
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setTitle("Atencao");
        alerta.setHeaderText(null);
        alerta.setContentText(mensagem);
        alerta.showAndWait();
    }

    public static void main(String[] args) {

        launch(args);
    }
}
