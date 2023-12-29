package dto;

public class Rank {
	private String id;
	private int score;
	private String time;
	private int level;

	public String getId() {
		return id;
	}

	public int getScore() {
		return score;
	}

	public String getTime() {
		return time;
	}

	public int getLevel() {
		return level;
	}

	public Rank(String id, int score, String time, int level) {
		this.id = id;
		this.score = score;
		this.time = time;
		this.level = level;
	}
}
