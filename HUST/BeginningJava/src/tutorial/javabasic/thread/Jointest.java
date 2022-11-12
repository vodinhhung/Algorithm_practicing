package tutorial.javabasic.thread;

public class Jointest {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("\n ==> Main thread starting ..\n");
		
		Thread joinThreadA = new JoinThread("A*",2);
		Thread joinThreadB = new JoinThread("B*",3);
		
		Thread nojoinThreadC = new JoinThread("C",5);
		
		joinThreadA.start();
		joinThreadB.start();
		nojoinThreadC.start();
		
		joinThreadA.join();
		joinThreadB.join();
		
		System.out.println("Hello from main thread ...");
		
		System.out.println("Thread A is alive " +joinThreadA.isAlive());
		System.out.println("Thread B is alive " +joinThreadB.isAlive());
		System.out.println("Thread C is alive " +nojoinThreadC.isAlive());
		
		System.out.println("\n ==> Main thread end! \n");
	}
}
