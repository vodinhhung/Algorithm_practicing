package btap_4;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class mainRunning {

	public static void main(String[] args) {
		
		Set<Point> s1 = new HashSet<Point>();
		Set<Point> s2 = new HashSet<Point>();
		Set<Point> s3 = new HashSet<Point>();
		List<Point> l = new ArrayList<Point>();
		Set<Point> s = new HashSet<Point>();
		
		Random ran = new Random();
		
		for (int i = 0; i < 30000; i++) {
			int i1 = ran.nextInt();
			int i2 = ran.nextInt();
			Point p = new Point(i1,i2);
			l.add(i,p);
			s.add(l.get(i));
			
			if(((i1-800)*(i1-800) + (i2-800)*(i2-800)) < 400*400 && s1.size() < 8000) {
				s1.add(p);
			}
			
			if(((i1 - 4000)*(i1-4000) + (i2 - 800)*(i2-800)) < 500*500 && s2.size() < 10000) {
				s2.add(p);
			}
			
			if(((i1 - 2400)*(i1 - 2400) + (i2 - 2400)*(i2 - 2400)) < 600*600 && s3.size() < 12000) {
				s3.add(p);
			}
		}
		
		File dir = new File("D:\\Code\\output4.txt");
		dir.mkdirs();
		
		ghiDlieu x = new ghiDlieu();
		x.ghi(l, dir.getAbsolutePath());
	}
}
