package so;

import so.cpu.CpuManager;
import so.memory.MemoryManager;
import so.memory.Strategy;
import so.schedule.Schedule;

import java.util.Objects;

public class SystemOperation {
	public static MemoryManager mm;
	public static CpuManager cm;
	public static Schedule schedule;
	
	public static Process systemCall(SystemCallType type, int sizeInMemory) {
		if(type.equals(SystemCallType.CREATE_PROCESS)) {
			if(Objects.isNull(mm)) {
				mm = new MemoryManager(256,4);
			}if(Objects.isNull(cm)) {
				cm = new CpuManager();
			}
		}
		return new Process(sizeInMemory);
	}
	
//	public Process systemCall(SystemCallType type, Process p) {
//		switch (type) {
//			case CREATE_PROCESS:
//				createMemoryFirstFit();
//				return new Process();
//			case WRITE_PROCESS:
//				//chama o mememory manager
//				mm.write(p);
//				break;
//			case READ_PROCESS:
//				break;
//		}
//		return null;
//
//	}
	public static void systemCall(SystemCallType type, Process p) {
		if(type.equals(SystemCallType.WRITE_PROCESS)) {
			mm.write(p);
		}else if(type.equals(SystemCallType.DELETE_PROCESS)) {
			
		}else if(type.equals(SystemCallType.READ_PROCESS)) {
			
		}
	}

//	private void createMemoryFirstFit(){//Criando MemoryManager e CpuManager se são nulos
//		if(Objects.isNull(mm)) {
//			mm = new MemoryManager(Strategy.FIRST_FIT);
//		}if(Objects.isNull(cm)) {
//			cm = new CpuManager();
//		}
//	}
}
