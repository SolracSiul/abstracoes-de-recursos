package so;

import java.util.List;

import so.memory.NewMemoryManager;

public class Execute {
	 public static void main(String[] args) {
		 
		Process p1 = (Process)SystemOperation.systemCall(SystemCallType.CREATE_PROCESS,50);
		
		NewMemoryManager manager = new NewMemoryManager(256,4);
		manager.write(p1);
		
		
		SystemOperation.systemCall(SystemCallType.WRITE_PROCESS, p1);
		

		List<SubProcess> sps = SystemOperation.systemCall(SystemCallType.WRITE_PROCESS, p1);
		
		
		 
		 
		/*Process p3 = systemOperation.systemCall(SystemCallType.CREATE_PROCESS, null);
		systemOperation.systemCall(SystemCallType.WRITE_PROCESS, p3);
		
		systemOperation.systemCall(SystemCallType.DELETE_PROCESS, p3);*/
	}
}
