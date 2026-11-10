package org.example;

import java.time.LocalDate;

public class Homem extends Paciente {

    public Homem(String nome, LocalDate dataNascimento, double alturaCm) {
        super(nome, dataNascimento, alturaCm);
    }

    @Override
    public String getSexo() {
        return "Masculino";
    }

    // Sun et al. (2003)
    @Override
    public double calcularMassaMagra(double pesoKg, double resistenciaOhm, double reatanciaOhm) {
        return -10.68 + 0.65 * indiceResistivo(resistenciaOhm) + 0.26 * pesoKg + 0.02 * reatanciaOhm;
    }

    // Sun et al. (2003)
    @Override
    public double calcularAguaCorporal(double pesoKg, double resistenciaOhm) {
        return 1.2 + 0.45 * indiceResistivo(resistenciaOhm) + 0.18 * pesoKg;
    }

    // Mifflin-St Jeor
    @Override
    public double calcularTmb(double pesoKg) {
        return 10 * pesoKg + 6.25 * getAlturaCm() - 5 * getIdade() + 5;
    }
}
