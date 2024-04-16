package so.memory;

import java.util.ArrayList;
import java.util.List;

import so.*;
import so.Process;

public class Page {
	
	private List<SubProcess> subProcesses = new ArrayList<>();
	
	private Integer qntSubProcess = 0;
	
	
	public void addSubProcess(SubProcess subProcess) {
		subProcesses.add(subProcess);
		qntSubProcess = qntSubProcess + 1;
	}


	
	
	
	
	

}
