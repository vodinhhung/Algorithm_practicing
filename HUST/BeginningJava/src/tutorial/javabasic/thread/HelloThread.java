package tutorial.javabasic.thread;

public class HelloThread extends Thread {
	
	public void run() {
		int index = 1;
		
		for (int i=0; i<10; i++) {
			System.out.println(" - Hello Thread running " + index++);
			
			try {
				Thread.sleep(3020);
				
			}catch(InterruptedException e){
			}
			
		}
		
		System.out.println(" - === Hello Thread stopped");
		
	}
}
