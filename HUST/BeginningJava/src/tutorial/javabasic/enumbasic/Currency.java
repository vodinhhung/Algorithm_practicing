package tutorial.javabasic.enumbasic;

public enum Currency {
	
	VND, USD, EURO, WON, YEN;
	
	public String toString() {
		if(this == VND) {
			return "Dong";
		}else if( this == USD) {
			return "Dola";
		}
		return super.toString();
	}
	
	public static void main(String[] args) {
		Currency money = Currency.USD;
		
		System.out.println("Money: " +money);
		System.out.println("Money: " +money.toString());
		System.out.println("VND" +Currency.VND);
		System.out.println("EURO" +Currency.EURO);
	}
}
