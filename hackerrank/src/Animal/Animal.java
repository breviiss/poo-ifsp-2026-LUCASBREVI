package Animal;

public class Animal {
    private String nome;
    private double peso;

    public Animal(String nome, double peso) {
        this.nome = nome;
        this.peso = peso;
    }

    public String getNome() {
        return nome;
    }

    public double getPeso() {
        return peso;
    }

    public void emitirSom() {
        System.out.println("Som desconhecido");
    }

    public void emitirSom(String som) {
        System.out.println(som);
    }
}

