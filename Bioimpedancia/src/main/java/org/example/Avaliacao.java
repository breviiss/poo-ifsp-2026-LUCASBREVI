package org.example;

import java.time.LocalDate;

/**
 * Uma medição de bioimpedância de um paciente. Usa o polimorfismo:
 * quem calcula massa magra, água e TMB é o próprio Paciente (Homem ou Mulher).
 */
public class Avaliacao {

    private Paciente paciente;
    private LocalDate data;
    private double pesoKg;
    private double resistenciaOhm;
    private double reatanciaOhm;

    public Avaliacao(Paciente paciente, double pesoKg, double resistenciaOhm, double reatanciaOhm) {
        if (paciente == null) throw new IllegalArgumentException("Paciente não informado.");
        if (pesoKg <= 0) throw new IllegalArgumentException("Peso deve ser maior que zero.");
        if (paciente.getAlturaCm() <= 0) throw new IllegalArgumentException("Altura deve ser maior que zero.");
        if (resistenciaOhm <= 0) throw new IllegalArgumentException("Resistência deve ser maior que zero.");
        if (reatanciaOhm < 0) throw new IllegalArgumentException("Reactância não pode ser negativa.");

        this.paciente = paciente;
        this.pesoKg = pesoKg;
        this.resistenciaOhm = resistenciaOhm;
        this.reatanciaOhm = reatanciaOhm;
        this.data = LocalDate.now();
    }

    public double calcularImc() {
        double alturaM = paciente.getAlturaCm() / 100.0;
        return pesoKg / (alturaM * alturaM);
    }

    public String classificarImc() {
        double imc = calcularImc();
        if (imc < 18.5) return "Abaixo do peso";
        if (imc < 25) return "Peso normal";
        if (imc < 30) return "Sobrepeso";
        if (imc < 35) return "Obesidade grau I";
        if (imc < 40) return "Obesidade grau II";
        return "Obesidade grau III";
    }

    public double calcularMassaMagra() {
        return paciente.calcularMassaMagra(pesoKg, resistenciaOhm, reatanciaOhm);
    }

    public double calcularMassaGorda() {
        return pesoKg - calcularMassaMagra();
    }

    public double calcularPercentualGordura() {
        return calcularMassaGorda() / pesoKg * 100.0;
    }

    public double calcularAguaCorporal() {
        return paciente.calcularAguaCorporal(pesoKg, resistenciaOhm);
    }

    public double calcularPercentualAgua() {
        return calcularAguaCorporal() / pesoKg * 100.0;
    }

    public double calcularAnguloFase() {
        return Math.toDegrees(Math.atan(reatanciaOhm / resistenciaOhm));
    }

    public double calcularTmb() {
        return paciente.calcularTmb(pesoKg);
    }

    public String gerarRelatorio() {
        return String.format(
                "Paciente: %s%n"
              + "Data: %s%n"
              + "IMC: %.1f (%s)%n"
              + "Massa magra: %.1f kg%n"
              + "Massa gorda: %.1f kg%n"
              + "Gordura corporal: %.1f %%%n"
              + "Água corporal total: %.1f L (%.1f %%)%n"
              + "Ângulo de fase: %.1f°%n"
              + "TMB: %.0f kcal/dia",
                paciente, data, calcularImc(), classificarImc(),
                calcularMassaMagra(), calcularMassaGorda(), calcularPercentualGordura(),
                calcularAguaCorporal(), calcularPercentualAgua(),
                calcularAnguloFase(), calcularTmb());
    }

    public Paciente getPaciente() { return paciente; }

    public LocalDate getData() { return data; }

    public double getPesoKg() { return pesoKg; }

    public double getResistenciaOhm() { return resistenciaOhm; }

    public double getReatanciaOhm() { return reatanciaOhm; }
}
