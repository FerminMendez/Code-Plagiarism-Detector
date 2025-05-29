package br.com.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Scanner;

public class DancingWithTheGooglers {

    private static Scanner scan = new Scanner(System.in);
    private static String[] entrada;
    private static int[] possiveisValoresExtra;
    private static int pontuacao, totEntradas, totSituacoes, totCompetidores, valorMinimo, totPossiveisValoresExtra, totValores, resto, resultado, totSituacoesMontadas, totCasos;
    private static StringBuilder temp = new StringBuilder();
    private static StringBuilder saida = new StringBuilder();
    private static File arquivoEntrada = new File("/home/emanuel/input.txt");
    private static File arquivoSaida = new File("/home/emanuel/output.txt");
    private static BufferedReader leitura;
    private static FileOutputStream fos;
    private static String linha;

    public static void main(String[] args) {
        try {
            leitura = new BufferedReader(new FileReader(arquivoEntrada));
            linha = leitura.readLine();
            totEntradas = Integer.parseInt(linha);
            totCasos = 1;
            for (int i = 0; i < totEntradas; i++) {
                linha = leitura.readLine();
                entrada = linha.split(" ");
                totCompetidores = Integer.parseInt(entrada[0]);
                totSituacoes = Integer.parseInt(entrada[1]);
                valorMinimo = Integer.parseInt(entrada[2]);
                totPossiveisValoresExtra = 0;
                totValores = 0;
                possiveisValoresExtra = new int[totCompetidores];
                for (int j = 3; j < entrada.length; j++) {
                    pontuacao = Integer.parseInt(entrada[j]);
                    if (pontuacao == 0) {
                        if (valorMinimo == 0) {
                            totValores++;
                        }
                        continue;
                    }
                    resto = pontuacao % 3;
                    resultado = (pontuacao / 3);
                    switch (resto) {
                        case 2:
                            if ((resultado + 1) >= valorMinimo) {
                                totValores++;
                                break;
                            }
                            possiveisValoresExtra[totPossiveisValoresExtra++] = pontuacao;
                            break;
                        case 1:
                            if ((resultado + 1) >= valorMinimo) {
                                totValores++;
                            }
                            break;
                        default:
                            if (resultado >= valorMinimo) {
                                totValores++;
                            } else {
                                possiveisValoresExtra[totPossiveisValoresExtra++] = pontuacao;
                            }
                            break;
                    }
                }
                totSituacoesMontadas = 0;
                for (int j = 0; j < totPossiveisValoresExtra && totSituacoesMontadas < totSituacoes; j++) {
                    pontuacao = possiveisValoresExtra[j];
                    resto = pontuacao % 3;
                    resultado = (pontuacao / 3);
                    if (resto == 2) {
                        if ((resultado + 2) >= valorMinimo) {
                            totSituacoesMontadas++;
                            totValores++;
                        }
                    } else {
                        if ((resultado + 1) >= valorMinimo) {
                            totSituacoesMontadas++;
                            totValores++;
                        }
                    }
                }
                saida.append("Case #").append(totCasos++).append(": ").append(totValores).append("\n");
            }
            fos = new FileOutputStream(arquivoSaida);
            fos.write(saida.toString().getBytes());
            fos.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
