package so.scheduler;

import java.util.Comparator;

import so.Process;
import so.SubProcess;

public class SJF extends SchedulerQueue {

	public SJF(Comparator<SubProcess> comparator) {
		super(new Comparator<Process>() {

			@Override
			public int compare(Process sp1, Process sp2) {
				// TODO Auto-generated method stub
				return sp1.getTimeToExecute() <= sp2.getTimeToExecute() ? 1 : -1 ;
			}
			
		});
	}

	@Override
	public void execute(Process p) {
		
	}

	@Override
	public void finish(Process p) {
		
	}

}
