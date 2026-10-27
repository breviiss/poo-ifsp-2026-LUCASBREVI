package Animal;

public class Gato extends Animal {

    public Gato(String nome, double peso) {
        super(nome, peso);
    }

    @Override
    public void emitirSom() {
        super.emitirSom("MIAU");
    }
}

