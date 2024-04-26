package com.example;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args ){
        Converter converter = new Converter();
        Scanner scanner = new Scanner(System.in);
        int opcao[] = new int[2];
        String moeda[] = new String[2];
        String moedas = """
                          [ 1 ] USD = Dólar Americano
                          [ 2 ] BRL = Real
                          [ 3 ] EUR = Euro
                          [ 4 ] CAD = Dólar Canadense
                          [ 5 ] GBP = Libra Esterlina
                          [ 6 ] CHF = Franco Suíço
                          [ 7 ] JPY = Iene Japonês
                          """;

        try {
            System.out.println("\nBem-vindo ao Conversor de Moedas!");
            System.out.print("Insira o valor a ser convertido: ");
            double valor = scanner.nextDouble();

            for (int i = 0 ; i < 2 ; i++){
                String x = (i == 0) ? "Valor de origem" : "Valor de destino";
                
                System.out.print("\n" + x + "\n" + moedas + "\nInforme a opção: ");
                do{
                    opcao[i] = scanner.nextInt();
                    moeda[i] = converter.MoedaSigla(opcao[i]);
                    System.out.println("moeda: " + moeda[i]);
                }while (!(opcao[i] > 0 && opcao[i] <= 7));  
            }

            System.out.println("\n" + converter.Convertendo(moeda[0], moeda[1], valor) + "\n");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
}
