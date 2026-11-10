package org.example;

import java.time.LocalDate;

/** Teste rápido no console, sem JavaFX. */
public class Teste {

    public static void main(String[] args) {
        Paciente joao = new Homem("João Silva", LocalDate.of(1995, 5, 20), 178);
        Paciente maria = new Mulher("Maria Souza", LocalDate.of(1998, 11, 3), 165);

        Avaliacao a1 = new Avaliacao(joao, 80.0, 480, 55);
        Avaliacao a2 = new Avaliacao(maria, 62.0, 560, 58);

        System.out.println(a1.gerarRelatorio());
        System.out.println("-----------------------------");
        System.out.println(a2.gerarRelatorio());
    }
}
