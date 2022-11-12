package btap_3;

import java.io.File; 
import java.util.HashMap;
import java.util.Map;

public class daLuong {
	
	public static void main(String[] args) {
	
		File folder = new File("D:\\Code\\session1_Vccorp\\btap_3\\input_3");
		File[] listOfFiles = folder.listFiles();
		int soluong = listOfFiles.length;
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		String[] filename1 = new String[50];
		String[] filename2 = new String[50];
		String[] filename3 = new String[50];
		
		for(int i = 0; i < (soluong/3); i++) {
			filename1[i] = listOfFiles[i].getAbsolutePath();
		}
	
		for(int i = soluong/3; i < (2*soluong/3); i++) {
			filename2[i-soluong/3 +1] = listOfFiles[i].getAbsolutePath();
		}
		
		for(int  i = 2*soluong/3; i < soluong; i++) {
			filename3[i - 2*soluong/3 + 1] = listOfFiles[i].getAbsolutePath();
		}
		
		daLuongThread th1 = new daLuongThread(filename1, map);
		th1.start();
		
		daLuongThread th2 = new daLuongThread(filename2, map);
		th2.start();
		
		daLuongThread th3 = new daLuongThread(filename3, map);
		th3.start(); 
		
		System.out.println(map.toString());
	}
}
