package esquenta;
public class Inverte {

    public static void main(String[] args) {
        int[] numeros = {10, 20, 30, 40, 50};

        System.out.print("Entrada: [");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i] + (i < numeros.length - 1 ? ", " : ""));
        }
        System.out.println("]");

        for (int i = 0; i < numeros.length / 2; i++) {
            int temp = numeros[i];

            numeros[i] = numeros[numeros.length - 1 - i];
            numeros[numeros.length - 1 - i] = temp;
        }
        System.out.print("Saída: [");

        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i] + (i < numeros.length - 1 ? ", " : ""));
        }
        System.out.println("]");
    }
}

