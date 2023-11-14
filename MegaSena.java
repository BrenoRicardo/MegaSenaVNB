package br.com.vainaweb.backendt1.megasena;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class MegaSena {
    public static void main(String[] args) {
        Random random = new Random();
        Set<Integer> numerosSorteados = new HashSet<>();
        
        // Gerando 7 números aleatórios para o sorteio sem repetição
        while (numerosSorteados.size() < 7) {
            int numeroAleatorio = random.nextInt(99 + 1); // Sorteia números de 1 a 100
            numerosSorteados.add(numeroAleatorio);
        }
        
        // Transferindo para um vetor de Integer
        Integer[] numerosVencedores = numerosSorteados.toArray(new Integer[0]);
        
        // Pedindo para o usuário inserir os 7 números
        Scanner scanner = new Scanner(System.in);
        Integer[] numerosEscolhidos = new Integer[7];
        System.out.println("Bem Vindo a MegaSena VNB!! \nEscolha 7 números de 0 a 60:");
        for (int i = 0; i < 7; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, digite um número inteiro.");
                System.out.print("Número " + (i + 1) + ": ");
                scanner.next(); // 
            }
            int numero = scanner.nextInt();
            while (numero < 0 || numero > 100 || Arrays.asList(numerosEscolhidos).contains(numero)) {
                System.out.println("Número inválido ou repetido. Escolha outro número.");
                System.out.print("Número " + (i + 1) + ": ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Por favor, digite um número inteiro.");
                    System.out.print("Número " + (i + 1) + ": ");
                    scanner.next(); // 
                }
                numero = scanner.nextInt();
            }
            numerosEscolhidos[i] = numero;
        }
        
        
        
        // Comparando os números escolhidos com os números sorteados e contando os acertos
        int acertos = 0;
        for (int numero : numerosEscolhidos) {
            if (numerosSorteados.contains(numero)) {
                acertos++;
            }
        }
        
        // Premiação de acordo com os acertos
        if (acertos == 5) {
            System.out.println("Parabéns! Você acertou 5 números! Prêmio de 10 mil reais.");
        } else if (acertos == 6) {
            System.out.println("Parabéns! Você acertou 6 números! Prêmio de 50 mil reais.");
        } else if (acertos == 7) {
            System.out.println("Parabéns! Você acertou 7 números! Prêmio de 200 mil reais.");
        } else {
            System.out.println("Não foi dessa vez. Tente novamente!");
        }
        
        // Exibindo os números vencedores e os números escolhidos pelo usuário
        System.out.println("Números vencedores: " + Arrays.toString(numerosVencedores));
        System.out.println("Seus números escolhidos: " + Arrays.toString(numerosEscolhidos));
    }
}

