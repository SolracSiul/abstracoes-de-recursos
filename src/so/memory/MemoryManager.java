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
	private String[] memoryss;
	private Strategy strategy;
	private Allocation allocation;
	private int pageSize;
	int sizeMemory = 128;
	public static int NUM_OF_INSTRUCTIONS_PER_SUB_PROCESS = 7;
	
	private static final String MSG_PROCESS = "\nProcess name : %s \n Process size: %d \n Process Id: %s \n" ;
	
	public MemoryManager(int memorySize, int pageSize) {
		//4 linhas por pagina -> 4subProcess
		this.pageSize = pageSize;
		//quantidade total da memoria 256
		this.sizeMemory = memorySize;
		//pagina é 256/4 --- 64 paginas;
		int pages = (int) Math.ceil(this.sizeMemory/this.pageSize);
		//teremos 4 phisicMemory cada um com 64
		this.physicMemory = new SubProcess[pages][pageSize];
		this.logicalMemory = new Hashtable<>();
	}
	public void write(Process p) {
//		this.writeUsingPaging(p);
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

//	private List<FrameMemory> getFrames(Process processo){
//		List<FrameMemory> frames = new LinkedList<>();
//		int numOfPagesProcesss = (int) Math.ceil(processo.getSizeInMemory()/this.pageSize);
//		for(int frame = 0; frame < this.physicMemory.length; frame++) {
//			if(this.physicMemory[frame][0]== null) {
//				frames.add(new FrameMemory(frame));
//				if(frames.size()== numOfPagesProcesss) {
//					return frames;
//				}
//			};
//		}
//		return null;
//	}
	public void delete(Process p) {
		List<FrameMemory> frames = (List<FrameMemory>) this.logicalMemory.get(p.getId());
		for(int i = 0; i < frames.size();i++) {
			FrameMemory actuallyFrame = frames.get(i);
			for(int j = actuallyFrame.getPageNumber(); j < actuallyFrame.getOffset(); j++) {
				this.physicMemory[j] = null;
			}
		}
		this.logicalMemory.remove(p.getId());
	}
	
//	private void writeUsingPaging(Process p) {
//		List<FrameMemory> frames = this.getFrames(p);
//		if(frames != null) {
//			//fazendo for na quantidade de paginas que será necessaria para o processo
//			for(int i =0; i< frames.size(); i++) {
//				//fazendo for na quantidade de subprocessos na pagina
//				for(int offset = 0; offset < this.pageSize; offset++) {
//					FrameMemory frame = frames.get(i);
//					//atualiza memoria fisica
//					SubProcess sp = new SubProcess(p.getId(),NUM_OF_INSTRUCTIONS_PER_SUB_PROCESS );
//					this.physicMemory[frame.getPageNumber()][offset]= sp;
//					//atualiza memoria logica
//					frame.setOffset(offset);
//					this.logicalMemory.put(MSG_PROCESS, frame);
//				}
//			}
//		}else {
//			
//		}
//		SubProcess.count = 0;
//		this.printMemoryStatus();
//	};
	public List<SubProcess> read(Process p){
		List<String> ids = p.getProcesses();
		List<SubProcess> sps = new LinkedList<>();
		for(String id : ids) {
			FrameMemory actuallyFrame = this.logicalMemory.get(id);
			sps.add(this.physicMemory[actuallyFrame.getPageNumber()][actuallyFrame.getOffset()]);
		}
		return sps;
	}
	public void newDelete(Process p) {
		return;
	}
	

}
