package tutorial.javabasic.enumbasic;

public enum Gender {
	
	MALE("M","MALE"), FEMALE("F","FEMALE");
	
	private String code;
	private String text;
	
	private Gender(String code, String text) {
		this.code = code;
		this.text = text;
	}
	
	public static Gender getGenderbycode(String code) {
		for(Gender x: Gender.values()) {
			if (x.code.equals(code)) {
				return x;
			}
		}
		return null;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
}
