import java.util.concurrent.Semaphore;

public class App {
	public static void main(String[] args) {

		Semaphore sem = new Semaphore(0);

		ThreadMatch match1 = new ThreadMatch("Les bleus", "Les nuls", "Moncuq", 12, sem);
		ThreadMatch match2 = new ThreadMatch("Barcelone", "Madrid", "Changai", 733, sem);
		ThreadMatch match3 = new ThreadMatch("Les enfants tétraplégiques", "Les vieux de l'ehpad", "Everest", 38363917, sem);

		Thread t1 = new Thread(match1);
		Thread t2 = new Thread(match2);
		Thread t3 = new Thread(match3);
		
		// JOIN

		/* System.out.println("Début du match " + match1.getTeam1() + " VS " + match1.getTeam2());
		t1.start();

		try {
			t1.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Début du match " + match2.getTeam1() + " VS " + match2.getTeam2());
		t2.start();
		
		try {
			t2.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Début du match " + match3.getTeam1() + " VS " + match3.getTeam2());
		t3.start();
		
		try {
			t3.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		} */

		t1.start();
		t2.start();
		t3.start();

		while(t1.isAlive() || t2.isAlive() || t3.isAlive()) {
			try {
				if(sem.availablePermits() == 1) {
					System.out.println("BUUUUUUUUUUUUUUUUU !!");
					sem.acquire();
				}
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}	
}
