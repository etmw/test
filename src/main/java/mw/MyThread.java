package mw;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
 
public class MyThread implements Callable<String> {
	private int count = 20;
 
	@Override
	public String call() throws Exception {
		for (int i = count; i > 0; i--) {
//			Thread.yield();
			System.out.println(Thread.currentThread().getName()+"当前票数：" + i);
		}
		return "sale out";
	} 
 
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Callable<String> callable  =new MyThread();
		FutureTask<String> futureTask=new FutureTask<String>(callable);
		FutureTask<String> futureTask1=new FutureTask<String>(callable);
		FutureTask<String> futureTask2=new FutureTask<String>(callable);
		Thread mThread=new Thread(futureTask,"1");
		Thread mThread2=new Thread(futureTask1,"2");
		Thread mThread3=new Thread(futureTask2,"3");
//		mThread.setName("hhh");
		mThread.start();
		mThread2.start();
		mThread3.start();
		System.out.println(futureTask.get());
		
	}
}




