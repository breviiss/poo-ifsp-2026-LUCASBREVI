package Animal;

import java.util.ArrayList;

public class Teste {

    public static void main(String[] args) {
        //ArrayList<Animal> animais = new ArrayList<>();

      //animais.add(new Gato("Gato", 3.0));
       //animais.add(new Cachorro("Orelha", 4.0));
        //animais.add(new Pato("Pato", 1.5));

        Radio r = new Radio();
        ArrayList<Sonoro> barulhentos = new ArrayList<>();
        barulhentos.add(r);
        barulhentos.add(new Cachorro("Orelha", 5.0));
        barulhentos.add(new Gato("Gato", 3.0));
        barulhentos.add(new Pato("Pato", 2.0));

        for (Animal a : animais) {
            a.emitirSom();
        }
    }
}

