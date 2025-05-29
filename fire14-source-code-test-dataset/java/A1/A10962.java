package br.com;

public class Tripla {

	int pontuacaoMaxima;

	public Tripla(int pontuacaoMaxima) {
		this.pontuacaoMaxima = pontuacaoMaxima;
	}

	public int maximaPontuacao() {
		int menor = pontuacaoMaxima / 3;
		if (menor * 3 < pontuacaoMaxima) {
			return menor + 1;
		}
		return menor;
	}

	public int maximaPontuacaoEspecial() {
		if (pontuacaoMaxima == 0) {
			return 0;
		}
		if (pontuacaoMaxima % 3 == 1) {
			return (pontuacaoMaxima / 3) + 1;
		}

		else {
			return (pontuacaoMaxima / 3) + 2;
		}
	}
}
