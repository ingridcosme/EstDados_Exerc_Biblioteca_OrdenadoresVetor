package br.edu.fateczl.ingridcosme.sort;

class Sort {

	public Sort() {
		
	}
	
	public int[]quickSort(int[] vetor, int inicio, int fim){
		if (fim > inicio) {
			int posicaoPivoFixo = dividirParaEncontrarPivo(vetor, inicio, fim);
			quickSort(vetor, inicio, posicaoPivoFixo - 1);
			quickSort(vetor, posicaoPivoFixo + 1, fim);
		}
		return vetor;
	}
	
	private int dividirParaEncontrarPivo(int[] vetor, int inicio, int fim) {
		int pivoInicial = vetor[inicio];
		int ponteiroEsq = inicio + 1;
		int ponteiroDir = fim;
		
		while (ponteiroEsq <= ponteiroDir) {
			while (ponteiroEsq <= ponteiroDir && vetor[ponteiroEsq] <= pivoInicial) {
				ponteiroEsq++;
			}
			while (ponteiroDir >= ponteiroEsq && vetor[ponteiroDir] > pivoInicial) {
				ponteiroDir--;
			}
			if (ponteiroEsq < ponteiroDir) {
				trocar(vetor, ponteiroEsq, ponteiroDir);
				ponteiroEsq++;
				ponteiroDir--;
			}
		}
		trocar(vetor, inicio, ponteiroDir);
		int posicaoPivoFixo = ponteiroDir;
		return posicaoPivoFixo;
	}
	
	private void trocar(int[] vetor, int i, int j) {
		int aux = vetor[i];
		vetor[i] = vetor[j];
		vetor[j] = aux;		
	}
	
	public int[] mergeSort(int[] vetor, int inicio, int fim) {		
		if(inicio < fim) {
			int meio = (inicio + fim) / 2;
			mergeSort(vetor, inicio, meio);
			mergeSort(vetor, meio + 1, fim);
			intercala(vetor, inicio, meio, fim);
		}
		return vetor;
	}
	
	private void intercala(int[] vetor, int inicio, int meio, int fim) {
		int novoVetor[] = new int[vetor.length];
		for(int i = inicio ; i <= fim ; i++) {
			novoVetor[i] = vetor[i];
		}
		int esq = inicio;
		int dir = meio + 1;
		for(int cont = inicio ; cont <= fim ; cont++) {
			if(esq > meio) {
				vetor[cont] = novoVetor[dir];
				dir++;
			} else if (dir > fim) {
				vetor[cont] = novoVetor[esq];
				esq++;
			} else if(novoVetor[esq] < novoVetor[dir]) {
				vetor[cont] = novoVetor[esq];
				esq++;
			} else {
				vetor[cont] = novoVetor[dir];
				dir++;
			}
		}
	}
	
	public int[] bubbleSort(int[] vetor) {
		int tamanho = vetor.length;

		for(int i = 0 ; i < tamanho ; i++) {
			for(int j = 0 ; j < tamanho - 1 ; j++) {
				if(vetor[j] > vetor[j + 1]) {
					int aux = vetor[j];
					vetor[j] = vetor[j + 1];
					vetor[j + 1] = aux;
				}
			}
		}
		return vetor;
	}

}
