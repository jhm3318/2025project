//뱅크어카운트 기본
class baBase {
	public static void main(String[] args)
			throws InterruptedException {
		BankAccount b = new	BankAccount();
		Parent p = new Parent(b);
		Child c = new Child(b);
		p.start();
		c.start();
		p.join();
		c.join();
		System.out.println(
				"\nbalance = " + b.getBalance());
		}
	}

class BankAccount {
	int balance;
	void deposit(int amount, int i) {
		int temp1=amount;
		int temp2=balance + temp1;
		System.out.print("입");
		balance = temp2;
		//balance = balance + amount;
		System.out.print(i+1+"번째 1000원 입금완료 / 잔액 : "+balance+"\n");
		}
	void withdraw(int amount, int i) {
		int temp1=amount;
		int temp2=balance - temp1;
		System.out.print("출");
		balance = temp2;
		//balance = balance - amount;
		System.out.print(i+1+"번째 1000원 출금완료 / 잔액 : "+balance+"\n");
		}
	int getBalance() {
		return balance;
		}
	}

class Parent extends Thread {
	BankAccount b;
	Parent(BankAccount b) {
		this.b = b;
		}
	public void run() {
		for (int i=0; i<100000; i++){
			b.deposit(1000,i);
			//System.out.print(i+1+"번째 1000원 입금완료 / 잔액 : "+b.balance+"\n");
		}
		}
	}

class Child extends Thread {
	BankAccount b;
	Child(BankAccount b) {
		this.b = b;
		}
	public void run() {
		for (int i=0; i<100000; i++){
			b.withdraw(1000,i);
			//System.out.print(i+1+"번째 1000원 출금완료 / 잔액 : "+b.balance+"\n");
		}
		}
	}