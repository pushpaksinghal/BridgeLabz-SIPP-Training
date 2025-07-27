class history{
	String link;
	history prev;
	history next;
	
	history(String link){
		this.link=link;
	}
}

class brower{
	private history current ;
	
	public void visit(String link) {
		history newnode = new history(link);
		if(current!=null) {
			current.next = newnode;
			newnode.prev = current;
			
		}
		current = newnode;
		
	}
	public void back() {
		if(current!=null && current.prev !=null) {
			current = current.prev;
			
		}
		else {
			System.out.println("no previous link avalibla");
		}
	}
	
	public void forward() {
		if(current !=null && current.next!=null) {
			current = current.next;
		}
		else {
			System.out.println("no next link avalibla");
		}
	}
	public void  currentpage() {
		if(current !=null) {
			System.out.println("current page:" + current);
		}
		else {
			System.out.println("no page visited yet");
		}
	}
	public void erasehistory() {
		current.next = null;
		current.prev = null;
	}
}

public class BrowserHistory_linkedlist{
	public static void main(String []args) {
		brower h1 = new brower();
		
		h1.visit("www.google.com");
		h1.visit("www.twitter.com");
		h1.visit("www.youtube.com");
		h1.visit("www.facebook.com");
		h1.visit("www.instagram.com");
		
		h1.back();
		h1.forward();
		h1.back();
		h1.currentpage();
		h1.erasehistory();
		h1.currentpage();
		h1.back();
		
	}
}