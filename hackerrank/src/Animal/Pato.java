package Animal;

public class Pato extends Animal {

    public Pato(String nome, double peso) {
        super(nome, peso);
    }

    @Override
    public void emitirSom() {
        super.emitirSom("QUACK");
    }
}

