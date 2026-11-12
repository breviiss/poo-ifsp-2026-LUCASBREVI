package org.example;

import java.util.ArrayList;

public class Historico {

    private ArrayList<Avaliacao> avaliacoes = new ArrayList<>();

    public void adicionar(Avaliacao avaliacao) {
        avaliacoes.add(avaliacao);
    }

    public void remover(int posicao) {
        if (posicao >= 0 && posicao < avaliacoes.size()) {
            avaliacoes.remove(posicao);
        }
    }

    public void limpar() {
        avaliacoes.clear();
    }

    public int quantidade() {
        return avaliacoes.size();
    }

    public ArrayList<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public ArrayList<Avaliacao> buscarPorNome(String nome) {
        ArrayList<Avaliacao> encontradas = new ArrayList<>();
        for (int i = 0; i < avaliacoes.size(); i++) {
            Avaliacao a = avaliacoes.get(i);
            if (a.getPaciente().getNome().equalsIgnoreCase(nome)) {
                encontradas.add(a);
            }
        }
        return encontradas;
    }

    public double calcularMediaGordura() {
        if (avaliacoes.size() == 0) {
            return 0;
        }
        double soma = 0;
        for (int i = 0; i < avaliacoes.size(); i++) {
            soma = soma + avaliacoes.get(i).calcularPercentualGordura();
        }
        return soma / avaliacoes.size();
    }

    public String gerarResumo() {
        if (avaliacoes.size() == 0) {
            return "Nenhuma avaliacao feita ainda.";
        }
        String texto = "";
        for (int i = 0; i < avaliacoes.size(); i++) {
            Avaliacao a = avaliacoes.get(i);
            texto = texto + (i + 1) + " - " + a.getPaciente().getNome()
                    + " | IMC " + Avaliacao.arredondar(a.calcularImc())
                    + " | Gordura " + Avaliacao.arredondar(a.calcularPercentualGordura()) + " %\n";
        }
        texto = texto + "Media de gordura: " + Avaliacao.arredondar(calcularMediaGordura()) + " %";
        return texto;
    }
}
