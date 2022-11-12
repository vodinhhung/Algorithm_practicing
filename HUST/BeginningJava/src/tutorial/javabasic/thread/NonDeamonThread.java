package tutorial.javabasic.thread;

public class NonDeamonThread extends Thread {
	public void run() {
		
		int i = 0;
		
		while (i<10) {
			System.out.println(" - Hello from None Deamon thread" +i++);
			try {
				Thread.sleep(1000);
			}catch (InterruptedException e) {
			}
		}
		
		System.out.println(" ==> None Deamon Thread ending \n");
	}
}
