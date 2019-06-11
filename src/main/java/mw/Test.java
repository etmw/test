package mw;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
	public static void main(String[] args) {
		ExecutorService ex=Executors.newSingleThreadExecutor();
		
		for(int i=0;i<5;i++) {
			ex.submit(new Runnable() {
				
				@Override
				public void run() {
					for(int j=0;j<10;j++) {
						System.out.println(Thread.currentThread().getName()+"1111"+j);
					}
					
				}
			});
		}
		ex.shutdown();
	}	
}
