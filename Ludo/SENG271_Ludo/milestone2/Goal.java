package milestone2;

public class Goal extends Field {
	private Player owner;
	
	public Goal(int i) {
		super(i);
	}
	
	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

}