package so.scheduler;

import java.util.Comparator;
import java.util.Hashtable;
import java.util.List;
import java.util.PriorityQueue;

import so.Process;
import so.SubProcess;
import so.SystemCallType;
import so.SystemOperation;
import so.cpu.Core;
import so.memory.Block;

public  class SchedulerQueue extends Scheduler {
	public SchedulerQueue(List<Process> processes) {
		super(processes);
		// TODO Auto-generated constructor stub
	}

	private PriorityQueue<Process> queue;
	private Hashtable<String, List<SubProcess>> subProcess;
	
//	public SchedulerQueue (Comparator<Process> comparator){
//		this.queue = new PriorityQueue<>(comparator);
//	}

	public PriorityQueue<Process> getQueue() {
		return queue;
	}

//	private void registerSubProcesses() {
//		Process p = this.queue.peek();
//		List<SubProcess> sps = this.subProcess.get(p.getId());
//		Core[] cores = this.getCm().getAvaliableCores();
//		for(Core core: cores) {
//			if(core.getCurrentSubProcess() != null){
//				SubProcess sp = sps.get(0);
//				this.getCm().registerProcess(core.getId(), sp);
//			}
//		}
//	}

	@Override
	public void execute(Block b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void finish(Block b) {
		// TODO Auto-generated method stub
		
	}
	


	
	
}
