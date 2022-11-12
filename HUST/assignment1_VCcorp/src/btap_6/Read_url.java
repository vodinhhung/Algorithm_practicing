package btap_6;

public class Read_url {
	
	public static void main(String args[]) {
		
		String name = new String("https://www.google.com.vn/search?q=string+java+practice&rlz=1C1CHZL_viVN741VN741&oq=string&aqs=chrome.2.69i57j69i60j69i59j69i60.2342j0j1&sourceid=chrome&ie=UTF-8");
		
		for (int i=0; i < name.length(); i++) {
			char c = name.charAt(i);
			System.out.println(c+ ":"+i);
		}
		
		System.out.println("Domain name: " +name.substring(8,25));
		System.out.println("q: " +name.substring(35,54));
		System.out.println("rlz: " +name.substring(60,79));
		System.out.println("oq: "+name.substring(84, 89));
		System.out.println("aqs: " +name.substring(95, 135));
		System.out.println("sourceid: " +name.substring(146,151));
		System.out.println("ie: " +name.substring(156, 160));
	}
}
