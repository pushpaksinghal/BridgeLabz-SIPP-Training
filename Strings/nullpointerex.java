public class nullpointerex{
	public static void main(String[] args) {
		String s ;
		s=null;
		try {
			char c =s.charAt(0);
			System.out.println(c);
		}catch(NullPointerException e) {
			System.out.println("NullpointerException => "+ e.getMessage());
		}catch(Exception e) {
			System.out.println("Generic Exception => "+ e.getMessage());
		}
	}
}