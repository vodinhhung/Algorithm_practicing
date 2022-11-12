package tutorial.javabasic.file;

import java.io.File;
import java.util.Date;

public class FileIntoExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File apath = new File("D:\\Code\\mytext");
		
		System.out.println("Path exists?: "+apath.exists());
		
		if(apath.exists()) {
			
			System.out.println("Directory? "+apath.isDirectory());
			System.out.println("Hidden? " +apath.isHidden());
			System.out.println("Simple Name: " +apath.getName());
			System.out.println("Absolute Path: " +apath.getAbsolutePath());
			System.out.println("Length(byte): "+apath.length());
			
			long x = apath.lastModified();
			Date y = new Date(x);
			System.out.println("Last Modify Date: " +y);
		}
	}
}
