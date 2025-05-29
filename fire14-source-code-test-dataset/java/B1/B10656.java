package br.com.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Scanner;

public class RecycledNumbers {

    private static int totCasos, contCasos, contador, totNumerosMovidos, indice;
    private static long a, b, n, m;
    private static String numerosN, numerosM;
    private static StringBuilder temp = new StringBuilder();
    private static StringBuilder saida = new StringBuilder();
    private static File arquivoEntrada = new File("/home/emanuel/input.txt");
    private static File arquivoSaida = new File("/home/emanuel/output.txt");
    private static BufferedReader leitura;
    private static FileOutputStream fos;
    private static String linha;
    private static String[] entrada;

    public static void main(String[] args) {
        try {
            leitura = new BufferedReader(new FileReader(arquivoEntrada));
            linha = leitura.readLine();
            totCasos = Integer.parseInt(linha);
            for (int i = 0; i < totCasos; i++) {
                linha = leitura.readLine();
                entrada = linha.split(" ");
                a = Long.parseLong(entrada[0]);
                b = Long.parseLong(entrada[1]);
                for (n = a; n < b - 1; n++) {
                    for (m = n + 1; m <= b; m++) {
                        numerosN = String.valueOf(n);
                        numerosM = String.valueOf(m);
                        indice = numerosN.length() - 1;
                        totNumerosMovidos = 0;
                        while (totNumerosMovidos < numerosN.length()) {
                            temp.append(numerosN.substring(indice)).append(numerosN.substring(0, indice));
                            if (temp.toString().equals(String.valueOf(numerosM))) {
                                contador++;
                                break;
                            }
                            temp.delete(0, temp.length());
                            indice--;
                            totNumerosMovidos++;
                        }
                    }
                }
                contCasos++;
                saida.append("Case #").append(contCasos).append(": ").append(contador).append("\n");
                contador = 0;
            }
            fos = new FileOutputStream(arquivoSaida);
            fos.write(saida.toString().getBytes());
            fos.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
