package so;

import so.cpu.CpuManager;
import so.memory.MemoryManager;
import so.memory.NewMemoryManager;
import so.memory.Strategy;
import so.scheduler.Scheduler;

import java.util.List;
import java.util.Objects;

public class SystemOperation {
	public static NewMemoryManager mm;
	public static Scheduler scheduler;
	
	public static Process systemCall(SystemCallType type, int sizeInMemory) {
		if(type.equals(SystemCallType.CREATE_PROCESS)) {
			if(Objects.isNull(mm)) {
				//pageNumber = 256 paginas
				//ofset = cada pagina 4 subprocess;
				mm = new NewMemoryManager(256,4);
			}if(Objects.isNull(scheduler)) {
				//scheduler = new RoundRobin();
			}
		}
		return new Process(sizeInMemory);
	}
	

	public static List<SubProcess> systemCall(SystemCallType type, Process p) {
		if(type.equals(SystemCallType.WRITE_PROCESS)) {
			mm.write(p);
			mm.printMemory();
			//scheduler = new RoundRobin();
			//scheduler.execute(p);
		}else if(type.equals(SystemCallType.CLOSE_PROCESS)) {
			//mm.delete(p);
			//scheduler.finish(p);
		}else if(type.equals(SystemCallType.READ_PROCESS)) {
			//return mm.read(p);
		}
		return null;
	}


}
