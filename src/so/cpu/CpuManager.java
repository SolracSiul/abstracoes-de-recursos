package so.cpu;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import so.SubProcess;

public class CpuManager {
	private Core[] cores;
	
	public static int CAPACITY= 7;
	public static int NUM_OF_CORES =2;
	public static int CLOCK = 5000;
	public static int QUANTUM = 3000; 
	public CpuManager() {
		this.cores = new Core[NUM_OF_CORES];
		for(int i = 0; i < this.cores.length; i++) {
			this.cores[i] = new Core(i,CAPACITY );
		}
		clock();
	}
	public void executeNewProcess(int totalProcessSize) {
		 	int clockCount = 0;
		    int remainingTime = QUANTUM;
		    int instructionsPerClock = NUM_OF_CORES * CAPACITY;
		    while (totalProcessSize > 0 && remainingTime > 0) {
		    	totalProcessSize -= instructionsPerClock;
		        clockCount++;
		        remainingTime -= CLOCK;
		        try {
		            Thread.sleep(CLOCK);
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
		    }

		    if (totalProcessSize <= 0) {
		        System.out.println("Processo concluido apos " + clockCount + " clocks.");
		    } else {
		        System.out.println("Tempo de quantum esgotado. Processo ainda não concluído.");
		    }
	}
	public void registerProcess(int coreIndex, SubProcess sp) {
		this.cores[coreIndex].setCurrentSubProcess(sp);
	}
	public void clock() {
		new Timer().scheduleAtFixedRate(new TimerTask(){
			@Override
			public void run() {
				executeProcesses();
			}
		}, 0, CLOCK);
	}
		
	private void executeProcesses() {
		for(Core core: this.cores) {
			if(core.getCurrentSubProcess() != null) {
				core.run();
			}
		}
	}
	public Core[] getAvaliableCores(){
		return this.cores;
	}
}
