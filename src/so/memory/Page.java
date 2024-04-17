package so.memory;

import java.util.ArrayList;
import java.util.List;

import so.*;
import so.Process;

public class Page {
	
	private String id;
	
	private List<SubProcess> subProcesses = new ArrayList<>();
	
	private Integer qntSubProcess = 0;
	
	
	public Page(String id) {
		this.id = id;
	}
	
	public void addSubProcess(SubProcess subProcess) {
		subProcesses.add(subProcess);
		qntSubProcess = qntSubProcess + 1;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<SubProcess> getSubProcesses() {
		return subProcesses;
	}

	public void setSubProcesses(List<SubProcess> subProcesses) {
		this.subProcesses = subProcesses;
	}

	public Integer getQntSubProcess() {
		return qntSubProcess;
	}

	
	
	
	


	
	
	
	
	

}
