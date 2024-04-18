package so.scheduler;

import so.memory.Block;
import so.Process;

import java.util.List;

public class RoundRobin {
    private static final int CAPACITY = 2; // Capacidade de instruções por clock
    private static final int NUM_OF_CORES = 2;
    private static final int CLOCK = 500; // Tempo de cada clock em milissegundos
    private static final int QUANTUM = 1000; // Tempo de quantum em milissegundos

 
    public RoundRobin(List<Integer> processes) {
    }

    public RoundRobin() {
    }

    public int[] roundRobin(List<Integer> processes) {
    	int n = processes.size();
        int[] quantumUsed = new int[n];

        for (int i = 0; i < n; i++) {
            quantumUsed[i] = 0;
        }

        boolean allFinished = false;

        while (!allFinished) {
            allFinished = true;

            for (int i = 0; i < n; i++) {
                int timeLeft = processes.get(i);

                if (timeLeft > 0) {
                    allFinished = false;

                    int clocksPerQuantum = QUANTUM / CLOCK;

                    int instructionsPerQuantum = CAPACITY * NUM_OF_CORES * clocksPerQuantum;

                    int instructionsExecuted = Math.min(instructionsPerQuantum, timeLeft);
                    processes.set(i, timeLeft - instructionsExecuted);

                    quantumUsed[i]++;

                    if (processes.get(i) <= 0) {
                        System.out.println("Processo " + (i + 1) + " concluido em " + quantumUsed[i] + " quantums.");
                    }
                }
            }
            try {
                Thread.sleep(CLOCK);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return quantumUsed;
    }
}