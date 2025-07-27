class song{
	String songname;
	int runtime;
	song next;
	song prev;
	
	song(String songname , int runtime){
		this.songname = songname;
		this.runtime = runtime;
	}
}

class playlist{
	private song current;
	
	public void addsong(String songname, int runtime) {
		song newsong = new song(songname,runtime);
		if(current!=null) {
			current.next = newsong;
			newsong.prev = current;
		}
		
		current = newsong;
	}
	
	public void playnext() {
		if(current!=null && current.next!=null) {
			current = current.next;
		}
		else {
			System.out.println("No song added to the playlist");
		}
	}
	
	public void playprev() {
		if(current!=null && current.prev!=null) {
			current = current.prev;
		}
		else {
			System.out.println("No song added to the playlist");
		}
	}
	
	public void removesong() {
		if(current !=null && current.next!=null && current.prev!=null) {
			current.prev.next = current.next;
			current.next.prev = current.prev;
			
			current = current.next;
		}
		else if(current !=null && current.next!=null && current.prev ==null) {
			current = current.next;
			
			current.prev = null;
		}
		
		else if (current !=null && current.next==null && current.prev !=null) {
			current=  current.prev;
			
			current.next = null;
		}
		else {
			current = null;
		}
	}
	public void currentsong() {
		if(current !=null) {
			System.out.println("current song:" + current.songname);
		}
		else {
			System.out.println("no song added yet");
		}
	}
}

public class musicplayer{
	public static void main(String[]args) {
		playlist m1 = new playlist();
		m1.addsong("fell down", 182);
		m1.addsong("fallen", 182);
		m1.addsong("perfect", 182);
		m1.addsong("tum tak", 182);
		m1.addsong("lonely", 182);
		
		m1.playprev();
		m1.playnext();
		m1.removesong();
		m1.currentsong();
		
	}
}