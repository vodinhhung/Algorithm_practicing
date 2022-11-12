package tutorial.javabasic.thread;

public class DeamonThread extends Thread {
	
	public void run() {
		
		int count = 0;
		
		while(true) {
			System.out.println("-Hello from Deamon Thread" +count++);
			try {
				Thread.sleep(2000);
			}catch(InterruptedException e) {
			}
		}
	}
}
