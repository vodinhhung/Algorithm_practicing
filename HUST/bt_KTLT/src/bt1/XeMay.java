package bt1;

public class XeMay 
{
	String hangxe;
	String model;
	long vantoc;
	
	void tangga() {
		vantoc += 0.1;
	}
	
	void giamga() {
		if(vantoc > 1) {
			vantoc -= 1;
		}
	}
}


