package so;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import so.memory.Memory;

public class Allocation {
	//pegar um processo 
	//pegar uma memória;
	//retornar uma array informando em qual memoria o processo foi alocado;
	private List<NewProcess> processos = Arrays.asList(new NewProcess(), new NewProcess(), new NewProcess());
	//List<NewProcess> process;
	private List<Memory> memorias = Arrays.asList(new Memory(), new Memory(), new Memory());
	
	public void alocar() {
		for(NewProcess p : processos) {
			for(Memory memoria : memorias) {
				if(!memoria.isAlocado()) {
					if(memoria.getTamanho() >= p.getSize()) {
						memoria.setAlocado(true);
						memoria.setNomeDoProcesso(p.getName());
						memoria.setTamanhoDoProcesso(p.getSize());
						memoria.setId_Process(p.getId_newProcess());	
						break;
					}else {
						System.out.println("Processo: " +p.getName() + " nao pode ser alocado tamanho : " + p.getSize());
						break;
					}
				}				
			}
		}
		System.out.println(memorias);
	}	
}
