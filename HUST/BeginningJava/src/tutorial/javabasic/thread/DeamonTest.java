package tutorial.javabasic.thread;

public class DeamonTest {
	
	public static void main(String[] args) {
		System.out.println("==> Main Thread running .. \n");
		
		Thread deamonthread = new DeamonThread();
		
		deamonthread.setDaemon(true);
		deamonthread.start();
		
		new NonDeamonThread().start();
		
		try {
			Thread.sleep(2000);
		}catch(InterruptedException e) {	
		}
		
		System.out.println("\n ==> Main Thread ending \n");
	}
}
