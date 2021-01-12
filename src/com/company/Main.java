package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double valor = 4.50;

        double icms = (valor * 0.18);
        double ipi = (valor * 0.04);
        double pis = (valor * 0.0186);
        double cofins = (valor * 0.0854);

        double totalImpostos = 0;
        double totalMercadorias = 0;
        double totalGeral = 0;

        while (true) {
            String pedidoCompra = sc.nextLine();
            if (pedidoCompra == null || pedidoCompra.equals("")) {
                break;
            }

            String[] compra = pedidoCompra.split(";");
            double quantidade = Double.parseDouble(compra[1]);

            double impIcms = icms * quantidade;
            double impIpi = ipi * quantidade;
            double impPis = pis * quantidade;
            double impCofins = cofins * quantidade;

            double valorCompra = valor * quantidade;
            double valorImpostos = impCofins + impIpi + impIcms + impPis;
            double valorComImposto = valorCompra + valorImpostos;

            totalImpostos += valorImpostos;
            totalMercadorias += valorCompra;
            totalGeral += valorComImposto;

            System.out.print("Cliente: " + compra[0] + "\n");
            System.out.printf("ICMS: R$ %.2f", impIcms);
            System.out.printf("; IPI: R$ %.2f", impIpi);
            System.out.printf("; PIS: R$ %.2f", impPis);
            System.out.printf("; COFINS: R$ %.2f", impCofins);
            System.out.printf("; Total: R$ %.2f", valorComImposto);
            System.out.println("\n");
        }

        System.out.printf("Total Impostos: R$ %.2f\n", totalImpostos);
        System.out.printf("Total Mercadorias: R$ %.2f\n", totalMercadorias);
        System.out.printf("Total Geral: R$ %.2f", totalGeral);


    }
}
