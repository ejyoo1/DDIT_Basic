package i_api;

public class StringEx1 {
	public static void main (String[] args) {
		String s1 = new String("Hello");
		System.out.println (s1);
		
		char[] c = {'H', 'e','l','l','o'};
		String s2 = new String(c);
		System.out.println (s2);
		
		StringBuffer sb = new StringBuffer("Hello");
		String s3 = new String(sb);
		System.out.println (s3);
		
		String s4 = "Hello";
		String n1 = "0123456";
		char c3 = s4.charAt (1);
		char c2 = n1.charAt (1);
		System.out.println (c3);
		System.out.println (c2);
		
		int i = "aaa".compareTo ("aaa");
		System.out.println (i);
		i = "aaa".compareTo ("bbb");
		System.out.println (i);
		i = "bbb".compareTo ("aaa");
		System.out.println (i);
		
		
		String s = "Hello";
		String see2 = s.concat(" World");
		System.out.println (see2);
		
		
		s = "abcedfg";
		boolean b = s.contains ("bc");
		System.out.println (b);
		
		String file = "Hello.txt";
		b = file.endsWith ("txt");
		System.out.println (b);
		
		s = "Hello";
		b = s.equals ("Hello");
		System.out.println (b);
		b = s.equals("hello");
		System.out.println (b);
		
		
		s = "Hello";
		b = s.equalsIgnoreCase ("HELLO");
		System.out.println (b);
		b = s.equalsIgnoreCase ("heLLo");
		System.out.println (b);
		
		
		s = "Hello";
		int idx1 = s.indexOf ('o');
		System.out.println (idx1);
		int idx2 = s.indexOf ('k');
		System.out.println (idx2);
		
		
		s = "Helelo";
		idx1 = s.indexOf ('e', 0);
		System.out.println (idx1);
		idx2 = s.indexOf ('e', 2);
		System.out.println (idx2);
		
		
		s = "ABCDEFG";
		int idx = s.indexOf ("CD");
		System.out.println (idx);
		
		
		s = new String("abc");
		s2 = new String("abc");
		
		b = (s==s2);
		System.out.println (b);
		b = s.equals (s2);
		System.out.println (b);
		b = (s.intern ()==s2.intern ());
		System.out.println (s.intern ());
		
		
		s = "java.lang.Object";
		idx1 = s.lastIndexOf ('.');
		System.out.println (idx1);
		idx1 = s.indexOf ('.');
		System.out.println (idx1);
		
		
	}
}
