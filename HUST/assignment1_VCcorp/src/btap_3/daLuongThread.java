package btap_3;

import java.io.File;  
import java.util.Map;
import java.io.Reader;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class daLuongThread extends Thread {
	
	String[] filename;
	Map<String, Integer> map;
	
	public daLuongThread(String[] filename, Map<String, Integer> map) {
		this.filename = filename;
		this.map = map;
	}
	
	public String[] getFilename() {
		return filename;
	}

	public void setFilename(String[] filename) {
		this.filename = filename;
	}

	public Map<String, Integer> getMap() {
		return map;
	}

	public void setMap(Map<String, Integer> map) {
		this.map = map;
	}

	public void run() {
		try {
			for (int k=0; k < filename.length; k++) {
				File file = new File(filename[k]);
				Reader r = new FileReader(file);
				BufferedReader br = new BufferedReader(r);
		
				String s = null;
		
				while((s = br.readLine()) != null) {
			
					String s1 = new String(s);
					char b = ' ';
					for (int i = 0; i < s1.length(); i++) {
						char a = s1.charAt(i);
						if((33 <= a && a <= 47) || (58 <= a && a <= 64) || (91 <= a && a <= 96) || (123 <= a && a <= 126)) {
							s1=s1.replace(a,b);
						}
					}
			
					if (s1.contains("   "))
						s1.replaceAll("   "," ");
			
					for(String a: s1.trim().split(" ")) {
						if (map.containsKey(a)) {
							map.put(a, map.get(a) +1);
						}
						else {
							map.put(a,1);
						}
					}
					br.close();
				}
			}
		}catch(IOException ex) {
			System.out.println("Out of file");
		}
		
	}
}
