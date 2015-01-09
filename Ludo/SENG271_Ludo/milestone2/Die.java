package milestone2;

import java.util.Random;

public class Die {
	Random r;
	public Die(){
		r = new Random();
	}
	
	public int throwDie(){
		int result = r.nextInt(6)+1;
		Controller.displayRoll(result);
		return (result);
	}
}
