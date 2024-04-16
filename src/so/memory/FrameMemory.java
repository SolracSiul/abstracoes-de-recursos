package so.memory;

public class FrameMemory {
	//aqui indica o numero da pagina
	private static int pageNumber;
	//aqui indica a qtd de subProcess por pagina;
	private int offset;
	
	public FrameMemory(int pageNumber, int offset) {
		this.pageNumber = pageNumber;
		this.offset = offset;
	}
	public FrameMemory(int pageNumber) {
		this(pageNumber,0);
	}
	
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	
}
