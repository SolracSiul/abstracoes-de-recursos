package so;

public enum PriorityProcessType {
	BAIXA(1), MEDIA(2), ALTA(3), CRITICA(30);
	
	private int level;

	PriorityProcessType(int level){
		this.level = level;
	}

	public int getLevel() {
		return level;
	}
	
}
