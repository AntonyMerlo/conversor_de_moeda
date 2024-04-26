package com.example;

public class Converter {
    private Consulta consulta = new Consulta();

    public String Convertendo(String de, String para, double valor) {
        double resultado;

        if(valor < 1){ 
            throw new RuntimeException("Valor invalido numero escolhido menor que 0.");
        }

        resultado = valor * consulta.busca(de).conversion_rates().get(para);
        return "Conversão de " + de + " para " + para + " deu o total de " + resultado;
    }

    public String MoedaSigla(int numeroMoeda) {
        switch (numeroMoeda) {
            case 1:
                return "USD";
            case 2:
                return "BRL";
            case 3:
                return "EUR";
            case 4:
                return "CAD";
            case 5:
                return "GBP";
            case 6:
                return "CHF";
            case 7:
                return "JPY";
            default:
                return "Moeda inválida. Favor digitar uma valida:";
        }
    }
}
