package so.scheduler;

import so.cpu.CpuManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import so.Process;
import so.memory.*;

public class Scheduler {
    private CpuManager cm;
    private List<Process> processes = new ArrayList<>();
    private RoundRobin rr;
    private List<Integer> lista = new ArrayList<>();
    
    public Scheduler(List<Process> processes) {
        this.cm = new CpuManager();
        this.processes = processes;
        this.rr = new RoundRobin();
        
        mostrarListaDoSchedule();
        queue();
    }

    public void queue() {
        rr.roundRobin(lista);
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
