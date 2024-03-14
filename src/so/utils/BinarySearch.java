package so.utils;

import java.util.List;

public class BinarySearch {
	public static void main(String[] args) {
		int[] vetor = new int[8];
				//busca binaria so funciona em array ordenado;
				//marca inicio e fim do vetor
				//marca um numero como target;
				// soma o inicio e o fim e divide por 2 
				// o valor achado é maior ou menor que o target ? 
				
				for(int i = 0; i < vetor.length; i++){
					vetor[i] = i *2;
					System.out.println(vetor[i]);
				}
		
		int target = 6;
		boolean find = false;
		int start = 0;
		int end = vetor.length -1;
		int mid;
		int contador = 0;
		while(start <= end) {
			mid = (int) (start + end)/2;
			contador++;
			if(vetor[mid] == target) {
				find = true;
				break;
			}else if(vetor[mid] < target) {
				start = mid +1;
			}else {
				end = mid -1;
			}
		}
		if(find == true) {
			System.out.println("achou");
		}else {
			System.out.println("n achou");
		}
		
	}
	
}
