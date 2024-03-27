package so;


public class Execute {
	 public static void main(String[] args) {
		 SystemOperation systemOperation = new SystemOperation(); 

		Process p1 = systemOperation.systemCall(SystemCallType.CREATE_PROCESS, null);
		systemOperation.systemCall(SystemCallType.WRITE_PROCESS, p1);
		
		/*
		 * Process p2 = systemOperation.systemCall(SystemCallType.CREATE_PROCESS, null);
		 * systemOperation.systemCall(SystemCallType.WRITE_PROCESS, p2);
		 */
		
		/*Process p3 = systemOperation.systemCall(SystemCallType.CREATE_PROCESS, null);
		systemOperation.systemCall(SystemCallType.WRITE_PROCESS, p3);
		
		systemOperation.systemCall(SystemCallType.DELETE_PROCESS, p3);*/
	}
}
