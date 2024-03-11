package so;

import so.cpu.CpuManager;
import so.memory.MemoryManager;
import so.memory.Strategy;
import so.schedule.Schedule;

import java.util.Objects;

import so.Process;

public class SystemOperation {

	public static MemoryManager mm;
	public static CpuManager cm;
	public static Schedule schedule;
	
	public static Object systemCall(SystemCallType type, Process p) {
		if(type.equals(SystemCallType.CREATE_PROCESS)) {
			if(Objects.isNull(mm)) {
				mm = new MemoryManager(Strategy.FIRST_FIT);
			}if(Objects.isNull(cm)) {
				cm = new CpuManager();
			}
			return new Process();
		}else if(type.equals(SystemCallType.WRITE_PROCESS)) {
			//chama o mememory manager
			mm.write(p);
		}else if(type.equals(SystemCallType.READ_PROCESS)) {
			return null;
		}else if(type.equals(SystemCallType.READ_PROCESS)) {
			return null;
		}
		return null;
	}
}
