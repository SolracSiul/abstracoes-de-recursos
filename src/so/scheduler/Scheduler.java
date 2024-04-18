package so.scheduler;

import java.util.ArrayList;
import java.util.List;

import so.Process;
import so.cpu.CpuManager;
import so.memory.Block;
import so.utils.Logger;
import so.utils.SimpleLogger;

public class Scheduler {
    private CpuManager cm;
    private List<Process> processes = new ArrayList<>();
    private RoundRobin rr;
    private List<Integer> lista = new ArrayList<>();
    private Logger logger = new SimpleLogger();
        
    public Scheduler(List<Process> processes) {
        this.cm = new CpuManager();
        this.processes = processes;
        
        queue();

    };
   
    private static boolean todosZeros(List<Integer> lista) {
        for (int elemento : lista) {
            if (elemento != 0) {
                return false;
            }
        }
        return true;
    }
    
    public void queue() {
    	NewRoundRobin.executarAlgoritmo(logger, processes);
    }
    
    public void execute(Block b) {
    }

    public void finish(Block b) {
    }

    public CpuManager getCm() {
        return cm;
    }

    public void mostrarListaDoSchedule() {
        for (Process process : processes) {
            System.out.println("Processo: " + process.getSizeInMemory());
            lista.add(process.getSizeInMemory());
        }
        System.out.println(lista);
    }

    public List<Process> getProcesses() {
        return processes;
    }

    public void setProcesses(List<Process> processes) {
        this.processes = processes;
    }
}