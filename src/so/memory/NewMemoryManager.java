package so.memory;

import java.util.ArrayList;
import java.util.List;

import so.Process;
import so.SubProcess;
import so.SystemOperation;
import so.scheduler.Scheduler;

public class NewMemoryManager {

	private PhysicMemory physicMemory;
	private List<Process> processes;
	private static final String MSG_PROCESS = "\nProcess name : %s \n Process size: %d \n Process Id: %s \n";
	private Scheduler scheduler;

	public NewMemoryManager(int totalSize, int qntSubProcessPerPage) {

		this.physicMemory = new PhysicMemory(totalSize, qntSubProcessPerPage);
		this.processes = new ArrayList<>(); 
	}

	public void write(Process process) {
		processes.add(process);
		this.scheduler = new Scheduler(processes); 
		
		Integer qntPagesProcessUsing = getQntPagesProcessGoingUse(process);
		Integer processWriten = 0;
		for (Block block : physicMemory.getBlocksOfMemory()) {
			if (!block.getUsed()) {
				//percorre as pagidas do bloco
				for (int i = 0; i < qntPagesProcessUsing; i++) {
						Page page = block.getPages().get(i);
						//for para inserir o subprocesso
						for(int j = 0; j < physicMemory.getQntSubProcessPerPage();j++ ) {
							if(processWriten != process.getSizeInMemory()) {
								page.addSubProcess(new SubProcess(process.getId(),3));
								processWriten = processWriten + 1;
							}
						}
					}
				block.setUsed(Boolean.TRUE);
				break;
				}						
			}
	
		 
		}
	

	public Integer getQntPagesProcessGoingUse(Process process) {

		Integer sizeProcess = process.getSizeInMemory();

		Integer qntPages = sizeProcess / physicMemory.getQntSubProcessPerPage();

		Integer resto = sizeProcess % physicMemory.getQntSubProcessPerPage();

		if (resto != 0) {
			qntPages = qntPages + 1;
		}

		return qntPages;
	}

	public void printMemory() {
		for (Block block : physicMemory.getBlocksOfMemory()) {
			if(block.getUsed()) {
				System.out.println("Bloco - " + block.getId());
				System.out.println("------------------------");
				Integer contadorPagina = 1;
				for (Page page : block.getPages()) {
					System.out.println("------------");
					Integer contadorPrint = 0;
					
					for (int i = 0; i < physicMemory.getQntSubProcessPerPage();i++) {
						if(i >= page.getQntSubProcess()) {
							System.out.print("null |" );
						}else {
							System.out.print(page.getSubProcesses().get(i).getId() + " | ");
						}
						contadorPrint = contadorPrint + 1;
						if(contadorPrint == 4) {
							System.out.print("PG - " + contadorPagina);
							System.out.println("");
							contadorPrint = 1;
							contadorPagina = contadorPagina + 1;
						}
						
					}
					
				}
			}			
		}
		 Scheduler sc = new Scheduler(processes);
		
	}
	


}
