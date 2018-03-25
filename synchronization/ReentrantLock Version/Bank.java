import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class Bank {
	private final ReentrantLock myLock = new ReentrantLock();
	private final Condition codition;

	private final double[] accounts;

	public Bank(int n,double initialBalance) {
		accounts = new double[n];
		for(int i = 0; i < accounts.length; i++)
			accounts[i] = initialBalance;
		codition = myLock.newCondition();
	}

	public void transfer(int from,int to,double amount) throws InterruptedException {
		// if(accounts[from] < amount) return;
		myLock.lock();
		try {
			while(accounts[from] < amount)
				codition.await();

			System.out.print(Thread.currentThread());
			accounts[from] -= amount;
			System.out.printf(" %10.2f from %d to %d, accounts[%d] = %10.2f, accounts[%d] = %10.2f",
				amount,from,to,from,accounts[from],to,accounts[to]);
			accounts[to] += amount;
			System.out.printf(" Total Balanc: %10.2f\n",getTotalBalance());

			codition.signalAll();
		} finally {
			myLock.unlock();
		}
	}

	public double getTotalBalance() {
		myLock.lock();
		try {
			double sum = 0;
			for(double a : accounts) {
				sum += a;
			}
			return sum;
		} finally {
			myLock.unlock();
		}
		
	}

	public int size() {
		return accounts.length;
	}
}