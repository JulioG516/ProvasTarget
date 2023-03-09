package com.target;

import java.util.Scanner;

public class Fibonacci_2 {
    public static void main(String[] args) {
        /*
      2) Dado a sequência de Fibonacci, onde se inicia por 0 e 1 e o próximo valor sempre será a
      soma dos 2 valores anteriores (exemplo: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34...), escreva um programa na
      linguagem que desejar onde, informado um número, ele calcule a sequência de Fibonacci e retorne uma
      mensagem avisando se o número informado pertence ou não a sequência.
         */

        Scanner entrada = new Scanner(System.in);
        System.out.print("Informe um número inteiro: ");
        int num = entrada.nextInt();

        boolean pertence = false;
        int a = 0, b = 1, c;

        System.out.print("Sequência de Fibonacci: " + a + " " + b);

        while (b <= num) {
            c = a + b;
            System.out.print(" " + c);

            if (c == num) {
                pertence = true;
            }

            a = b;
            b = c;
        }

        System.out.println();

        if (pertence) {
            System.out.println(num + " pertence à sequência de Fibonacci.");
        } else {
            System.out.println(num + " não pertence à sequência de Fibonacci.");
        }

        entrada.close();
    }

}