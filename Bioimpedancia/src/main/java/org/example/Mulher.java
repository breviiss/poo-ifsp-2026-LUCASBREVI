package org.example;

import java.time.LocalDate;

public class Mulher extends Paciente {

    public Mulher(String nome, LocalDate dataNascimento, double alturaCm) {
        super(nome, dataNascimento, alturaCm);
    }

    @Override
    public String getSexo() {
        return "Feminino";
    }

    // Sun et al. (2003)
    @Override
    public double calcularMassaMagra(double pesoKg, double resistenciaOhm, double reatanciaOhm) {
        return -9.53 + 0.69 * indiceResistivo(resistenciaOhm) + 0.17 * pesoKg + 0.02 * reatanciaOhm;
    }

    // Sun et al. (2003)
    @Override
    public double calcularAguaCorporal(double pesoKg, double resistenciaOhm) {
        return 3.75 + 0.45 * indiceResistivo(resistenciaOhm) + 0.11 * pesoKg;
    }

    // Mifflin-St Jeor
    @Override
    public double calcularTmb(double pesoKg) {
        return 10 * pesoKg + 6.25 * getAlturaCm() - 5 * getIdade() - 161;
    }
}
