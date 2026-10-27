package Animal;

public class Cachorro extends Animal {

    public Cachorro(String nome, double peso) {
        super(nome, peso);
    }

    @Override
    public void emitirSom() {
        super.emitirSom("AU AU");
    }
}
