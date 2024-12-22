import agregateurcommentaires.CommentGenerator;
import java.util.concurrent.Semaphore;

public class ThreadMatch implements Runnable{
	
	// Attributes

	private String team1;

	private String team2;

	private String place;

	private int visitors;

	private Semaphore sem;

	// Constructor

	public ThreadMatch(String team1, String team2, String place, int visitors, Semaphore sem) {
		this.setTeam1(team1);
		this.setTeam2(team2);
		this.setPlace(place);
		this.setVisitors(visitors);

		this.sem = sem;
	}

	// To String :

	public String toString() {
		return "[" + this.place + "] " + this.team1 + " - " + this.team2 + " : ";
	}

	// Getters

	public String getTeam1() {
		return this.team1;
	}

	public String getTeam2() {
		return this.team2;
	}

	public String getPlace() {
		return this.place;
	}

	public int getVisitors() {
		return this.visitors;
	}

	// Setters

	public void setTeam1(String team1) {
		if(!team1.equals(null))
			this.team1 = team1;
	}

	public void setTeam2(String team2) {
		if(!team2.equals(null))
			this.team2 = team2;
	}

	public void setPlace(String place) {
		if(!place.equals(null))
			this.place = place;
	}

	public void setVisitors(int visitors) {
		if(visitors >= 0)
			this.visitors = visitors;
	}

	// Methods

	@Override
	public void run() {
		String comment = null;
		for(int i = 0; i < 5; ++i) {
			try {
				Thread.sleep(Math.round((Math.random()*100)%10)*100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			comment = CommentGenerator.getRandomComment();
			System.out.println(this + comment);
			if(comment.substring(0, 3).equals("But")) {
				this.sem.release();
			}
		}
	}
}
