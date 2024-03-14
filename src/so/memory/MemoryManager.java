package so.memory;
import so.Allocation;
import so.NewProcess;
import so.Process;

public class MemoryManager {
	private String[] memory;
	private Strategy strategy;
	private Allocation allocation;
	
	private static final String MSG_PROCESS = "\nProcess name : %s \n Process size: %d \n Process Id: %s \n" ;
	
	public MemoryManager(Strategy strategy) {
		this.memory = new String[128]; //TAMANHO DA MEMORIA RAM
		this.strategy = strategy;
	}
	public void write(Process p) {
		if(strategy.equals(strategy.FIRST_FIT)){
			this.worstFit();
		}else if(strategy.equals(strategy.BEST_FIT)) {
			this.writeUsingBestFit(p);
		}else if(strategy.equals(strategy.WORST_FIT)) {
			this.writeUsingWorstFit(p);

		}
	}
	private void writeUsingFirstFit(Process p) {	
		int actualSize = 0;
		System.out.print(MSG_PROCESS.formatted(p.getName(),p.getSizeInMemory(), p.getId()));
		for( int i = 0; i < memory.length ; i++) {
			if(i == (memory.length -1)) {
				if(actualSize != memory.length -1) {
					System.out.println("memoria ja alocada");
					break;
				}
				if(actualSize > 0) {
					if(p.getSizeInMemory() <= actualSize) { //Se o tamanho do processo é menor ou igual a memoria ram
						int start = (i - actualSize);
						/*int end = i;*/
						for (int j = start; j < p.getSizeInMemory(); j++ ) {
							memory[j] = p.getId();
						}
						break;
					}
				}
			}
			else if(memory[i] == null) {
				actualSize++;
			}else {
				if(actualSize > 0) {
					if(p.getSizeInMemory() <= actualSize) {
						int start = i - actualSize;
						int end = i -1;
						for (int j = start; j <= end; j++ ) {
							memory[j] = p.getId();
						}
						break;
					}
				}
				actualSize =0;
			}
		}
		printMemoryStatus();
	}
	private void firstFit() {
		System.out.println("new first fit: ");
		Allocation a = new Allocation();
		a.allocationWithFirstFit();		
	}
	private void bestFit() {
		System.out.println("new bestFit: ");
		Allocation a = new Allocation();
		a.allocationWithBestFit();
	}
	private void worstFit() {
		System.out.println("new worstFit: ");
		Allocation a = new Allocation();
		a.allocationWithWorstFit();
	}
	private void printMemoryStatus() {
		System.out.println("MEMORIA ATUAL:\n");
		for(int i = 0; i < memory.length; i++) {
			System.out.print(memory[i] + " | ");
		}
	}

	private void writeUsingWorstFit(Process p) {
		// done
	}
	private void writeUsingBestFit(Process p) {
		// done
	}

}
