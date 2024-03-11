package so.memory;
import so.Process;

public class MemoryManager {
	private String[] memory;
	private Strategy strategy;
	
	public MemoryManager(Strategy strategy) {
		this.memory = new String[128];
		this.strategy = strategy;
	}
	public void write(Process p) {
		if(strategy.equals(strategy.FIRST_FIT)){
			this.writeUsingFirstFit(p);
		}else if(strategy.equals(strategy.BEST_FIT)) {
			this.writeUsingBestFit(p);
		}else if(strategy.equals(strategy.WORST_FIT)) {
			this.writeUsingWorstFit(p);

		}
	}
	private void writeUsingWorstFit(Process p) {
		// TODO Auto-generated method stub
	}
	private void writeUsingBestFit(Process p) {
		// TODO Auto-generated method stub
	}
	private void writeUsingFirstFit(Process p) {
		// TODO Auto-generated method stub
	}
	private void printMemoryStatus() {
		for(int i = 0; i < memory.length; i++) {
			System.out.print(memory[i] + " | ");
		}
	}
}
