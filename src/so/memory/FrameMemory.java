package so.memory;

public class FrameMemory {
	private static int pageNumber;
	private int offset;
	
	public FrameMemory(int pageNumber, int offset) {
		super();
		this.pageNumber = pageNumber;
		this.offset = offset;
	}
	public FrameMemory(int pageNumbert) {
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
