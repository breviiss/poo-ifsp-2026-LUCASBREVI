package org.example;

public class Mulher extends Paciente {

    public Mulher(String nome, int idade, double altura) {

        super(nome, idade, altura);
    }

    @Override
    public String getSexo() {

        return "Feminino";
    }

    @Override
    public double calcularMassaMagra(double peso, double resistencia, double reatancia) {
        double indice = calcularIndiceResistivo(resistencia);
        return -9.53 + 0.69 * indice + 0.17 * peso + 0.02 * reatancia;
    }

    @Override
    public double calcularAgua(double peso, double resistencia) {
        double indice = calcularIndiceResistivo(resistencia);
        return 3.75 + 0.45 * indice + 0.11 * peso;
    }

    @Override
    public double calcularTmb(double peso) {

        return 10 * peso + 6.25 * getAltura() - 5 * getIdade() - 161;
    }
}
