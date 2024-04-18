package so.scheduler;

import so.utils.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import so.Process;

public class NewRoundRobin {


    public static int[] executarAlgoritmo(Logger logger, List<Process> processes) {
    	logger.log("Inicio executar algoritmo");
        int[] resultado = new int[processes.size()];
        Integer qntLoops = qntLoop(processes);
        List<Integer> listaProcessosSize = getSizeProcesses(processes);
        
        
        	for(int j = 0; j < qntLoops;j++) {
        		for (int i = 0; i < processes.size(); i++) {
            		Integer tamanhoProcesso = listaProcessosSize.get(i);
            		if (tamanhoProcesso == 0) {
            			logger.log("Indice P:" + i + " p zero. Nenhuma operacao realizada.");
            			resultado[i] = 0;
            		} else {
            			
            			Integer novoValor = tamanhoProcesso - 1;
            			listaProcessosSize.set(i, novoValor);
            			logger.log("processo P:" + i + " intrucoes faltantes: " + novoValor);
            			resultado[i] = novoValor;
            			
            		}
            	}
        		logger.log("Array resultante: " + Arrays.toString(resultado));
        	}
        

        
       
        return resultado;
    }
    
    
    public static Integer qntLoop( List<Process> processes) {
    	Integer qnt = 0;
    	for(Process process : processes) {
    		if(process.getSizeInMemory() >= qnt) {
    			qnt = process.getSizeInMemory();
    		}
    	}
    	
    	return qnt;
    }
    
    public static List<Integer> getSizeProcesses(List<Process> pro) {
    	List<Integer> lista = new ArrayList<>();
    	for(Process process : pro) {
    		lista.add(process.getSizeInMemory());
    	}
    	return lista;
    	
    }
    
}

