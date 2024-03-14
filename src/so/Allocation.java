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
			boolean alocado = false;
			for(Memory memoria : memorias) {
				if(!memoria.isAlocado() && memoria.getTamanho() >= p.getSize()) {
					memoria.setAlocado(true);
					memoria.setId_Process(p.getId_newProcess());
					alocado = true;
					System.out.println(memorias);
					System.out.println("Processo: " + p.getName() + " alocado no bloco " + memoria.getId_memory());
					break;
				}
				if(!alocado) {
					System.out.println("Processo: " +p.getName() + " nao pode ser alocado");
				}
			}
		}
	}
	
	
	
}
