package btap_7;

import java.util.ArrayList;

public class Test {

	public static void main(String args[]) {

		Xetai xetai1 = new Xetai();
		Xetai xetai2 = new Xetai();
		Xetai xetai3 = new Xetai();
		
		Oto oto1 = new Oto();
		Oto oto2 = new Oto();
		Oto oto3 = new Oto();
		
		XeDap xedap1 = new XeDap();
		XeDap xedap2 = new XeDap();
		XeDap xedap3 = new XeDap();
		
		ArrayList<VanTai> array = new ArrayList<VanTai>();
		
		array.add(xetai1);
		array.add(xetai2);
		array.add(xetai3);
		
		array.add(oto1);
		array.add(oto2);
		array.add(oto3);
		
		array.add(xedap1);
		array.add(xedap2);
		array.add(xedap3);
		
		for(VanTai x: array) {
			x.dichuyen();
		}
	}
}
