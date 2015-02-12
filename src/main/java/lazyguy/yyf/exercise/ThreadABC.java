package lazyguy.yyf.exercise;
public class ThreadABC {
	public static void main(String[] args) {
		Thread_E tc = new Thread_E();
		Thread_E tb = new Thread_E();
		Thread_E td = new Thread_E();
		Thread_A ta = new Thread_A();
		
		ta.setThread(tb);
		tb.setThread(tc);
		tc.setThread(td);
		td.setThread(ta);
		
		ta.setName("A");
		tb.setName("B");
		tc.setName("C");
		td.setName("D");
		
		ta.start();
		tb.start();
		tc.start();
		td.start();
		
	}
}
class Thread_A extends Thread {
	Thread t;
	public void setThread(Thread t) {
		this.t = t;
	}
	public void run() {
		int i = 0;
		while(i++ < 10) {
			System.out.print(Thread.currentThread().getName());
			t.interrupt();
			try {
				this.join();
			} catch (InterruptedException e) {
				
			}		
		}
	}
}
class Thread_E extends Thread {
	Thread t;
	public void setThread(Thread t) {
		this.t = t;
	}
	public void run() {
		int i = 0;
		while(i++ < 10) {
			try {
				this.join();
				
			} catch (InterruptedException e) {
				
			}		
			System.out.print(Thread.currentThread().getName());
			t.interrupt();
		}
	}
}