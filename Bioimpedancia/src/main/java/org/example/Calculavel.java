package org.example;

/**
 * Contrato para quem sabe calcular os valores de bioimpedância.
 * (Papel parecido com o da interface Sonoro no exemplo dos animais.)
 */
public interface Calculavel {

    double calcularMassaMagra(double pesoKg, double resistenciaOhm, double reatanciaOhm);

    double calcularAguaCorporal(double pesoKg, double resistenciaOhm);

    double calcularTmb(double pesoKg);
}
