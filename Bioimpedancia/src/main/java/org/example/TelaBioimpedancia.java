package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/** Tela JavaFX. Para abrir a interface, execute esta classe. */
public class TelaBioimpedancia extends Application {

    private final TextField txtNome = new TextField();
    private final DatePicker dpNascimento = new DatePicker();
    private final ComboBox<String> cbSexo = new ComboBox<>();
    private final TextField txtAltura = new TextField();
    private final TextField txtPeso = new TextField();
    private final TextField txtResistencia = new TextField();
    private final TextField txtReatancia = new TextField();
    private final TextArea areaResultado = new TextArea();

    @Override
    public void start(Stage stage) {
        cbSexo.getItems().addAll("Masculino", "Feminino");
        areaResultado.setEditable(false);
        areaResultado.setPrefRowCount(10);

        GridPane form = new GridPane();
        form.setHgap(10);
        form.setVgap(8);
        form.addRow(0, new Label("Nome:"), txtNome);
        form.addRow(1, new Label("Nascimento:"), dpNascimento);
        form.addRow(2, new Label("Sexo:"), cbSexo);
        form.addRow(3, new Label("Altura (cm):"), txtAltura);
        form.addRow(4, new Label("Peso (kg):"), txtPeso);
        form.addRow(5, new Label("Resistência (Ω):"), txtResistencia);
        form.addRow(6, new Label("Reactância (Ω):"), txtReatancia);

        Button btnCalcular = new Button("Calcular");
        btnCalcular.setOnAction(e -> calcular());

        VBox raiz = new VBox(12, form, btnCalcular, areaResultado);
        raiz.setPadding(new Insets(16));

        stage.setTitle("Sistema de Bioimpedância");
        stage.setScene(new Scene(raiz, 460, 560));
        stage.show();
    }

    private void calcular() {
        try {
            if (txtNome.getText().isBlank()) throw new IllegalArgumentException("Nome é obrigatório.");
            if (dpNascimento.getValue() == null) throw new IllegalArgumentException("Data de nascimento é obrigatória.");
            if (cbSexo.getValue() == null) throw new IllegalArgumentException("Selecione o sexo.");

            double altura = lerNumero(txtAltura, "Altura");
            Paciente paciente = cbSexo.getValue().equals("Masculino")
                    ? new Homem(txtNome.getText().trim(), dpNascimento.getValue(), altura)
                    : new Mulher(txtNome.getText().trim(), dpNascimento.getValue(), altura);

            Avaliacao avaliacao = new Avaliacao(
                    paciente,
                    lerNumero(txtPeso, "Peso"),
                    lerNumero(txtResistencia, "Resistência"),
                    lerNumero(txtReatancia, "Reactância"));

            areaResultado.setText(avaliacao.gerarRelatorio());
        } catch (IllegalArgumentException ex) {
            new Alert(Alert.AlertType.WARNING, ex.getMessage()).showAndWait();
        }
    }

    private double lerNumero(TextField campo, String nome) {
        try {
            return Double.parseDouble(campo.getText().trim().replace(',', '.'));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(nome + " inválido(a).");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
