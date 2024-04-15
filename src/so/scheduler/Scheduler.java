package so.scheduler;

import so.cpu.CpuManager;
import so.Process;

public abstract class Scheduler {
	public  CpuManager cm;
	
	public Scheduler() {
		cm = new CpuManager();
	}
	
	public abstract void execute(Process p);
	public abstract void finish(Process p);
	
	public  CpuManager getCm() {
		return cm;
	}
}
