package org.example;

import java.util.ArrayList;

public class Teste {

    public static void main(String[] args) {
        ArrayList<Paciente> pacientes = new ArrayList<>();
        pacientes.add(new Homem("Joao Silva", 31, 178));
        pacientes.add(new Mulher("Maria Souza", 28, 165));
        pacientes.add(new Homem("Carlos Lima", 45, 172));

        Historico historico = new Historico();
        historico.adicionar(new Avaliacao(pacientes.get(0), 80.0, 480, 55));
        historico.adicionar(new Avaliacao(pacientes.get(1), 62.0, 560, 58));
        historico.adicionar(new Avaliacao(pacientes.get(2), 95.0, 450, 50));

        ArrayList<Avaliacao> lista = historico.getAvaliacoes();
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i).gerarRelatorio());
            System.out.println("-----------------------------");
        }

        System.out.println(historico.gerarResumo());

        ArrayList<Avaliacao> achadas = historico.buscarPorNome("maria souza");
        System.out.println("Avaliacoes da Maria: " + achadas.size());
    }
}
