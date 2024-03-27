package so;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import so.memory.Memory;
import so.utils.Log;

public class Allocation {
	
	private List<NewProcess> processos = Arrays.asList(new NewProcess(), new NewProcess(), new NewProcess());
	private List<Memory> memorias = Arrays.asList(new Memory(), new Memory(), new Memory());
	
	public void allocationWithFirstFit() {
		int totalProcessSize = 0;
		String idProcess = "";
		for(NewProcess p : processos) {
			for(Memory memoria : memorias) {
				if(!memoria.isAlocado()) {
					if(memoria.getTamanho() >= p.getSize()) {
						memoria.setAlocado(true);
						memoria.setNomeDoProcesso(p.getName());
						memoria.setTamanhoDoProcesso(p.getSize());
						memoria.setId_Process(p.getId_newProcess());
						totalProcessSize = p.getSize();
						idProcess = p.getId_newProcess();
						break;
					}else {
						System.out.println("Processo: " +p.getName() + " nao pode ser alocado tamanho : " + p.getSize());
						break;
					}
				}				
			}
		}
		Log log = new Log(totalProcessSize, idProcess);
		System.out.println(memorias);
		log.showBit();
		
	}
	public void allocationWithBestFit() {
		int n = processos.size();
		int m = memorias.size();
		
		int allocation[] = new int[n];
		
		for(int i = 0; i< allocation.length; i++) {
			allocation[i] = -1;
		}
		for(int i =0; i< n; i++) {
			int bestIndex = -1;
			for (int j = 0; j < m; j++) {
                if (!memorias.get(j).isAlocado() && memorias.get(j).getTamanho() >= processos.get(i).getSize()) {
                    if (bestIndex == -1 || memorias.get(bestIndex).getTamanho() > memorias.get(j).getTamanho()) {
                    	bestIndex = j;
                    }
                }
            }
			if(bestIndex != -1) {
				allocation[i] = bestIndex;
				memorias.get(bestIndex).setAlocado(true);
				memorias.get(bestIndex).setNomeDoProcesso(processos.get(i).getName());
				memorias.get(bestIndex).setTamanhoDoProcesso(processos.get(i).getSize());
				memorias.get(bestIndex).setId_Process(processos.get(i).getId_newProcess());
			}
		}
		for(Memory memoria: memorias) {
			System.out.println(memoria);
		}		
	}
	public void allocationWithWorstFit() {
		int n = processos.size();
        int m = memorias.size();

        int allocation[] = new int[n];
        for (int i = 0; i < allocation.length; i++) {
            allocation[i] = -1;
        }
        for (int i = 0; i < n; i++) {
            int worstIndex = -1;
            for (int j = 0; j < m; j++) {
                if (!memorias.get(j).isAlocado() && memorias.get(j).getTamanho() >= processos.get(i).getSize()) {
                    if (worstIndex == -1 || memorias.get(worstIndex).getTamanho() < memorias.get(j).getTamanho()) {
                    	worstIndex = j;
                    }
                }
            }
            if (worstIndex != -1) {
                allocation[i] = worstIndex;
                memorias.get(worstIndex).setAlocado(true);
                memorias.get(worstIndex).setNomeDoProcesso(processos.get(i).getName());
                memorias.get(worstIndex).setTamanhoDoProcesso(processos.get(i).getSize());
                memorias.get(worstIndex).setId_Process(processos.get(i).getId_newProcess());
            }
        }
        for (Memory memoria : memorias) {
            System.out.println(memoria);
        }
	}
}
