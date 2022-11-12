package tutorial.javabasic.thread;

public class HelloMain {
	public static void main(String[] args) throws InterruptedException {
		
		int idx = 1;
		
		for (int i=0; i<2; i++) {
			System.out.println("Main thread running " +idx++);
			Thread.sleep(1101);
		}
		
		HelloThread helloThread = new HelloThread();
		
		helloThread.start();
		
		for (int i = 0; i<3; i++) {
			System.out.println("Main thread running " +idx++);
			Thread.sleep(2101);
		}
		
		System.out.print("==> Main thread stopped");
	}
}
