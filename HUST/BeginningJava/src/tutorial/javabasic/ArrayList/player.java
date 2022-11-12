package tutorial.javabasic.ArrayList;

public class player implements Comparable<player> {
	
	private int goldMedal;
	private int silverMedal;
	private int bronzeMedal;
	private String name;
	
	public player(String name, int goldMedal, int silverMedal, int bronzeMedal) {
		this.name = name;
		this.goldMedal = goldMedal;
		this.silverMedal = silverMedal;
		this.bronzeMedal = bronzeMedal;
	}
	
	public int compareTo(player other) {
		int value = this.goldMedal - other.goldMedal;
		if(value != 0) {
			return value;
		}
		value = this.silverMedal - other.silverMedal;
		if(value != 0) {
			return value;
		}
		value = this.bronzeMedal - other.bronzeMedal;
		return value;
	}
	
	public String toString() {
		return "[" +this.name+ ", Gold: " +this.goldMedal //
				+ ",Silver: " +this.silverMedal+ ",Bronze: "//
				+this.bronzeMedal + "]";
	}
}
