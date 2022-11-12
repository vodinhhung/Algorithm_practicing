package tutorial.javabasic.comparation.equals;

public class NumberOfMedals {
	
	private int goldCount;
	private int silverCount;
	private int bronzeCount;
	
	public NumberOfMedals(int goldCount, int silverCount, int bronzeCount) {
		this.goldCount = goldCount;
		this.silverCount = silverCount;
		this.bronzeCount = bronzeCount;
	}
	
	public int getGoldCount() {
		return goldCount;
	}
	
	public int getSilverCount() {
		return silverCount;
	}
	
	public int getBronzeCount() {
		return bronzeCount;
	}
	
	public boolean equals(Object other) {
		if(other == null)
			return false;
		if(!(other instanceof  NumberOfMedals))
			return false;
		
		NumberOfMedals otherNoMs = (NumberOfMedals) other;
		
		if(this.goldCount == otherNoMs.goldCount && this.silverCount == otherNoMs.silverCount && this.bronzeCount == otherNoMs.bronzeCount) {
			return true;
		}
		return false;
	}
}
