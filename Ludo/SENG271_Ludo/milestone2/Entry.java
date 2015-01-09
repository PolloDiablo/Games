package milestone2;


public class Entry extends Field {
	private Player owner;
	
	public Entry(int i){
		super(i);
	}

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}
}
