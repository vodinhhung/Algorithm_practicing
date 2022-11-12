package btap_2;

import java.io.Reader; 
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Map;
import java.util.HashMap;

public class InstanceDemo {

	public static void main(String[] args) throws IOException {
		
		Reader r = new FileReader("D:\\Code\\session1_Vccorp\\01.txt");
		BufferedReader br = new BufferedReader(r);
		
		String s = null;
		Map<String, Integer> map = new HashMap<String, Integer>(); 
		
		while((s = br.readLine()) != null) {
			
			String s1 = new String(s);
			char b = ' ';
			for (int i = 0; i < s1.length(); i++) {
				char a = s1.charAt(i);
				if((33 <= a && a <= 47) || (58 <= a && a <= 64) || (91 <= a && a <= 96) || (123 <= a && a <= 126)) {
					s1=s1.replace(a,b);
				}
			}
			
			s1 = s1.toLowerCase();
			
			while (s1.contains("   ")) {
				s1.replaceAll("   "," ");
			}
			
			for(String a: s1.trim().split(" ")) {
				if (map.containsKey(a)) {
					map.put(a, map.get(a) +1);
				}
				else {
					map.put(a,1);
				}
			}
			
		}
		
		System.out.println(map.toString());
		br.close();
	}
}
