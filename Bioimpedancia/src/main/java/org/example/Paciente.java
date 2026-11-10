package org.example;

import java.time.LocalDate;
import java.time.Period;

/**
 * Classe base (abstrata). Homem e Mulher herdam dela e implementam
 * as equações específicas de cada sexo.
 */
public abstract class Paciente implements Calculavel {

    private String nome;
    private LocalDate dataNascimento;
    private double alturaCm;

    public Paciente(String nome, LocalDate dataNascimento, double alturaCm) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.alturaCm = alturaCm;
    }

    public abstract String getSexo();

    public int getIdade() {
        return Period.between(dataNascimento, LocalDate.now()).getYears();
    }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public LocalDate getDataNascimento() { return dataNascimento; }

    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }

    public double getAlturaCm() { return alturaCm; }

    public void setAlturaCm(double alturaCm) { this.alturaCm = alturaCm; }

    /** Índice resistivo H²/R usado nas equações de bioimpedância. */
    protected double indiceResistivo(double resistenciaOhm) {
        return (alturaCm * alturaCm) / resistenciaOhm;
    }

    @Override
    public String toString() {
        return nome + " (" + getSexo() + ", " + getIdade() + " anos)";
    }
}
