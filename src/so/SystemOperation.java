package so;

import so.cpu.CpuManager;
import so.memory.MemoryManager;
import so.memory.Strategy;
import so.schedule.Schedule;

import java.util.Objects;

public class SystemOperation {
	public MemoryManager mm;
	public CpuManager cm;
	public Schedule schedule;
	
	public Process systemCall(SystemCallType type, Process p) {
		switch (type) {
			case CREATE_PROCESS:
				createMemoryFirstFit();
				return new Process();
			case WRITE_PROCESS:
				//chama o mememory manager
				mm.write(p);
				break;
			case READ_PROCESS:
				break;
		}
		return null;

	}

	private void createMemoryFirstFit(){//Criando MemoryManager e CpuManager se são nulos
		if(Objects.isNull(mm)) {
			mm = new MemoryManager(Strategy.FIRST_FIT);
		}if(Objects.isNull(cm)) {
			cm = new CpuManager();
		}
	}
}
