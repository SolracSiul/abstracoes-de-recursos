package so.utils;

public class SimpleLogger implements Logger {

	@Override
	public void log(String mensagem) {
		System.out.println("LOG: " + mensagem);
	}

}
