package single;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;

public class SingleDemo {
        private static SingleDemo demo=null;
        private SingleDemo() {
        	  System.out.println("创建了一个新实例");
        }
        public static SingleDemo getInstance() {
        	if(demo==null) {
        		demo=new SingleDemo();
        	}
        	else {
        		return demo;
        	}
        	return demo;
        }
        public static String reverse(String originStr) {
            if(originStr == null || originStr.length() <= 1) 
                return originStr;
            return reverse(originStr.substring(1)) + originStr.charAt(0);
        }
        public static void main(String[] args) throws UnsupportedEncodingException {
			SingleDemo demo=SingleDemo.getInstance();
			SingleDemo demo2=SingleDemo.getInstance();
		
			String s1 = "Programming";
	        String s2 = new String("Programming");
	        String s3 = "Program" + "ming";
	        System.out.println(s1 == s2);
	        System.out.println(s1 == s3);
	        System.out.println(s1 == s1.intern());
	        s3=s3.substring(1, 11);
	        System.out.println(s3);
	        String s4=SingleDemo.reverse("abcdefghijklmn");
	        System.out.println(s4);
	        LocalDateTime today = LocalDateTime.now();
	        LocalDateTime yesterday = today.minusDays(1);
	        
	        System.out.println(yesterday);
	        String s5 = "你好";
	        String s6 = new String(s5.getBytes("GB2312"), "ISO-8859-1");
	        System.out.println(s5);
	        System.out.println(s6);
	        
	        
		}
}
