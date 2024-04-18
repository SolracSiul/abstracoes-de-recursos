package so.scheduler;

import so.utils.Logger;

import java.util.Arrays;
import java.util.List;

import so.Process;

public class NewRoundRobin {
	private Scheduler scheduler;
    private Logger logger;

    public NewRoundRobin(Scheduler scheduler, Logger logger) {
        this.scheduler = scheduler;
        this.logger = logger;
    }

    public int[] executarAlgoritmo() {
        int[] resultado = new int[scheduler.getProcesses().size()];

        for (int i = 0; i < scheduler.getProcesses().size(); i++) {
            Process elemento = scheduler.getProcesses().get(i);
            if (elemento.getSizeInMemory() == 0) {
                logger.log("Indice P:" + i + " p zero. Nenhuma operação realizada.");
                resultado[i] = 0;
            } else {
                int novoValor = elemento.getSizeInMemory() - 1;
                logger.log("processo P:" + i + " intrucoes faltantes: " + novoValor);
                resultado[i] = novoValor;
            }
        }

        logger.log("Array resultante: " + Arrays.toString(resultado));
       
        return resultado;
    }
    
}

