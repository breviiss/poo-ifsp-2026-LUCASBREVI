package EXERCICIOSHR;

import java.util.*;
import java.io.*;

public class Loops2 {

    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();

            int resultado = a;
            int potencia = 1;

            for( int j = 0; j < n; j++){
                resultado += potencia * b;
                System.out.print(resultado + " ");

                potencia *= 2;
            }
            System.out.println();
        }
        in.close();
    }
}
