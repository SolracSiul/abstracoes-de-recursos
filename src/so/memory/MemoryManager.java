package so.memory;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

import so.Allocation;
import so.Process;
import so.SubProcess;

public class MemoryManager {
	private Hashtable<String, FrameMemory> logicalMemory;
	private SubProcess[][] physicMemory;
	private String[] memory;
	private Strategy strategy;
	private Allocation allocation;
	private int pageSize;
	int sizeMemory = 128;
	public static int NUM_OF_INSTRUCTIONS_PER_SUB_PROCESS = 7;
	
	private static final String MSG_PROCESS = "\nProcess name : %s \n Process size: %d \n Process Id: %s \n" ;
	
	public MemoryManager(int memorySize, int pageSize) {
		this.pageSize = pageSize;
		this.sizeMemory = memorySize;
		int pages = (int) Math.ceil(this.sizeMemory/this.pageSize);
		this.physicMemory = new SubProcess[pages][pageSize];
		this.logicalMemory = new Hashtable<>();
	}
	
		
	public void write(Process p) {
		//if(strategy.equals(strategy.FIRST_FIT)){
			//aqui criamos um novo processo 
		//	this.firstFit();
		//}else if(strategy.equals(strategy.BEST_FIT)) {
		//	this.writeUsingBestFit(p);
		//}else if(strategy.equals(strategy.WORST_FIT)) {
		//	this.writeUsingWorstFit(p);
		//}
		this.writeUsingPaging(p);
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
		for(int i = 0; i <this.physicMemory.length; i++) {
			for(int j = 0; j < this.physicMemory[i].length; j++) {
				SubProcess sp = this.physicMemory[i][j];
				String spId = null;
				if(sp !=null) {
					spId = sp.getId();
				}
				if( j == this.physicMemory[i].length -1) {
					System.out.println(spId);
				}else {
					System.out.print(spId + " | ");
				}
			}
		}
	}

	private List<FrameMemory> getFrames(Process p){
		List<FrameMemory> frames = new LinkedList<>();
		int numOfPages = (int) Math.ceil(p.getSizeInMemory()/this.pageSize);
		for(int frame = 0; frame < this.physicMemory.length; frame++) {
			if(this.physicMemory[frame][0]== null) {
				frames.add(new FrameMemory(frame));
				if(frames.size()== numOfPages) {
					return frames;
				}
			};
		}
		return null;
	}
	private void delete(Process p) {
		List<FrameMemory> frames = (List<FrameMemory>) this.logicalMemory.get(p.getId());
		for(int i = 0; i < frames.size();i++) {
			FrameMemory actuallyFrame = frames.get(i);
			for(int j = actuallyFrame.getPageNumber(); j < actuallyFrame.getOffset(); j++) {
				this.physicMemory[j] = null;
			}
		}
		this.logicalMemory.remove(p.getId());
	}
	
	private void writeUsingPaging(Process p) {
		List<FrameMemory> frames = this.getFrames(p);
		if(frames != null) {
			for(int i =0; i< frames.size(); i++) {
				for(int offset = 0; offset < this.pageSize; offset++) {
					FrameMemory frame = frames.get(i);
					//atualiza memoria fisica
					SubProcess sp = new SubProcess(p.getId(),NUM_OF_INSTRUCTIONS_PER_SUB_PROCESS );
					this.physicMemory[frame.getPageNumber()][offset]= sp;
					//atualiza memoria logica
					frame.setOffset(offset);
					this.logicalMemory.put(MSG_PROCESS, frame);
				}
			}
		}
		this.printMemoryStatus();
	}
	

}
