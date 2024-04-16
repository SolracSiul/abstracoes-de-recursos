package so.memory;
import so.Process;
import so.SubProcess;


public class NewMemoryManager {
	
	private PhysicMemory physicMemory;
	
	private static final String MSG_PROCESS = "\nProcess name : %s \n Process size: %d \n Process Id: %s \n" ;
	
	public NewMemoryManager(int totalSize, int qntSubProcessPerPage) {
		
		this.physicMemory = new PhysicMemory(totalSize,qntSubProcessPerPage);
		
	}
	
	
	public void write(Process process) {
		Integer qntPagesProcessUsing = getQntPagesProcessGoingUse(process); 
		Integer processWriten = 0;

		for(int i =0; i< qntPagesProcessUsing; i++) {
			
			physicMemory.getPagesMemory().add(new Page());
			for(int j = 0; j < physicMemory.getQntSubProcessPerPage() ; j++) {
				
				if(processWriten != process.getSizeInMemory()) {
					physicMemory.getPagesMemory().get(i).addSubProcess(new SubProcess(process.getId(),3));
					processWriten = processWriten + 1;
				}
			}
		}
		
		System.out.println("Terminou");
		
	}
	
	
	
	
	
	
	public Integer getQntPagesProcessGoingUse(Process process) {
		
		Integer sizeProcess = process.getSizeInMemory();
		
		Integer qntPages = sizeProcess / physicMemory.getQntSubProcessPerPage();
		
		Integer resto = sizeProcess % physicMemory.getQntSubProcessPerPage();
		
		if(resto != 0 ) {
			qntPages = qntPages + 1;
		}
		
		return qntPages;
	}
	

}
