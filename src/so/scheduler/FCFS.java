package so.scheduler;

import java.util.Comparator;

import so.Process;
import so.SubProcess;

public class FCFS extends SchedulerQueue {

	public FCFS() {
		super(new Comparator<Process>() {
			@Override
			public int compare(Process sp1, Process sp2) {
				// reposiciona na fila de quem sera processado em fifo;
				//todo mundo vai pra o final da fila;
				return -1;
			}
		});
	}


}
