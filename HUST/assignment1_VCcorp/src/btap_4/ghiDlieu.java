package btap_4;

import java.util.List;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ghiDlieu {
	
		public void ghi(Object o, String name) {
			try(FileOutputStream fos = new FileOutputStream(new File(name))){
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(o);
			}catch(Exception e){
				System.out.println("can loi");
			}
		}
		
		public void ghiDS(List<Point> list, String name) {
			try(FileOutputStream fos = new FileOutputStream(new File(name))){
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(list);
			}catch(Exception e){
				System.out.println("can loi");
			}
		}
}
