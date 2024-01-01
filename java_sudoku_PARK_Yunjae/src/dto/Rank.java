package dto;

public class Rank implements Comparable<Rank> {
	private String name;
	private int score;
	private String time;
	private int level;

	public String getName() {
		return name;
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

	public Rank(String name, int score, String time, int level) {
		this.name = name;
		this.score = score;
		this.time = time;
		this.level = level;
	}

	private Rank(String name, String score, String time, String level) {
		this.name = name;
		this.score = Integer.parseInt(score);
		this.time = time;
		this.level = Integer.parseInt(level);
	}

	public static Rank CreateMember(String[] info) {
		if (info == null || info.length == 0)
			return null;

		return new Rank(info[0], info[1], info[2], info[3]);
	}

	public String DataToFile() {
		return "%s/%d/%s/%d".formatted(name, score, time, level);
	}

	@Override
	public int compareTo(Rank o) {
		if (this.score < o.score)
			return 1;
		else if (this.score > o.score)
			return -1;
		else
			return 0;
	}
}
