//Deadlocks.
 /**
* tryLock() which will only acquire a lock if it’s available and not already acquired by another thread and 
* tryLock(long time,TimeUnit unit),which will try to acquire a lock, 
* and if it's unavailable wait for the specified timer to expire before giving up.
*/

//If you dont use lock, you'll have Multithreading issues as usual during transferring amount from one account to another.
//Always lock onto something, implement your code, and finally unlock your lock.

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Processors {
	Bank_Balance account1 = new Bank_Balance();
	Bank_Balance account2 = new Bank_Balance();
	Lock lock1 = new ReentrantLock();
	Lock lock2 = new ReentrantLock();

	private void getlocks(Lock firstlock, Lock secondlock) throws InterruptedException {
		while (true) {

			boolean gotfirstlock = false; // Initially flag both of the locks as false 
			                              // assuming that they haven't received their locks.
			boolean gotsecondlock = false;

			try {
				gotfirstlock = firstlock.tryLock(); // Try getting both the locks.
				gotsecondlock = secondlock.tryLock();
			} finally {

				if (gotfirstlock && gotsecondlock) { // If got both, return to the program
					return;
				}
				if (gotfirstlock) { // If got the first one, unlock it so other threads could use it.
					firstlock.unlock();
				}

				if (gotsecondlock) {  // If got the second one, unlock it so other threads could use it.
					secondlock.unlock();
				}

			}
			Thread.sleep(1); // Didn't get any locks.

		}
	}

	public void first_thread() throws InterruptedException {
		Random random = new Random();
		for (int i = 0; i < 10000; i++) {
			getlocks(lock1, lock2);
			try {
				Bank_Balance.account_transfer(account1, account2,random.nextInt(100)); //Random transfers.
			} finally {
				lock1.unlock();
				lock2.unlock();
			}
		}
	}

	public void second_thread() throws InterruptedException {
		Random random = new Random();
		for (int i = 0; i < 10000; i++) {
			getlocks(lock2, lock1);
			try {
				Bank_Balance.account_transfer(account1, account2,random.nextInt(100));
			} finally {
				lock1.unlock();
				lock2.unlock();
			}
		}

	}

	public void end_method() {
		System.out.println("Balance of Account 1 is: " + account1.showBalance());
		System.out.println("Balance of Account 2 is: " + account2.showBalance());
		System.out.println("Combined Balance is: " + (account1.showBalance() + account2.showBalance()));
	}

}

class Bank_Balance {

	private int balance = 15000;
	
	public void deposit(int amount){
		balance += amount;
	}
	
	public void withdraw(int amount){
		balance -= amount;
	}
	
	public int showBalance(){
		return balance;
	}
	
	public static void account_transfer(Bank_Balance Account1, Bank_Balance Account2,int amount){
		Account1.withdraw(amount);
		Account2.deposit(amount);
		
	}
}


public class Application {
	public static void main(String[] args) throws InterruptedException {
		final Processors processor = new Processors();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					processor.first_thread();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				try {
					processor.second_thread();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		t1.start();
		t2.start();
		t1.join();
		t2.join();
		processor.end_method();
	}
}
