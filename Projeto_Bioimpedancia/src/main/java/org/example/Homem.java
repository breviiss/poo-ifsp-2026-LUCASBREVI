package org.example;

public class Homem extends Paciente {

    public Homem(String nome, int idade, double altura) {

        super(nome, idade, altura);
    }

    @Override
    public String getSexo() {

        return "Masculino";
    }

    @Override
    public double calcularMassaMagra(double peso, double resistencia, double reatancia) {
        double indice = calcularIndiceResistivo(resistencia);
        return -10.68 + 0.65 * indice + 0.26 * peso + 0.02 * reatancia;
    }

    @Override
    public double calcularAgua(double peso, double resistencia) {
        double indice = calcularIndiceResistivo(resistencia);
        return 1.2 + 0.45 * indice + 0.18 * peso;
    }

    @Override
    public double calcularTmb(double peso) {

        return 10 * peso + 6.25 * getAltura() - 5 * getIdade() + 5;
    }
}
