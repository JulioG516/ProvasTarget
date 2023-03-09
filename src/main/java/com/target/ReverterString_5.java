package com.target;

import java.util.Scanner;

public class ReverterString_5 {
    public static void main(String[] args) {
        /*
        5) Escreva um programa que inverta os caracteres de um string.

        IMPORTANTE:
        a) Essa string pode ser informada através de qualquer entrada de sua preferência ou pode ser previamente definida no código;
        b) Evite usar funções prontas, como, por exemplo, reverse;
         */


        Scanner entrada = new Scanner(System.in);

        System.out.println("\nBem vindo ao Target String Reverser\n");
        System.out.print("Digite seu texto para ser invertido: ");

        // Pega o input do usuario
        String texto = entrada.nextLine();

        // cria um array de char
        char[] textoArray = texto.toCharArray();

        // Cria um string builder para poder ser adicionado os caracteres
        StringBuilder textoInvertido = new StringBuilder();


        for (int i = textoArray.length - 1; i >= 0; i--) {
            textoInvertido.append(textoArray[i]);
        }

        System.out.println("Seu texto original: " + texto);
        System.out.println("Seu texto invertido: " + textoInvertido.toString());
    }
}
