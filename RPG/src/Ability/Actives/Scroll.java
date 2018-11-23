package Ability.Actives;

import Main.Shoppable;

public class Scroll implements Shoppable{

	private Special special;
	private int price;
	
	public Scroll(Special s,int p) {
		special = s;
		price = p;
	}
	
	public void learn() throws InterruptedException {
		special.equipAbility();
	}
	
	@Override
	public int sell() {
		return (int)(price * 0.75);
	}

	@Override
	public int buy() {
		return price;
	}

	@Override
	public String getDesc() {
		return special.desc;
	}

	@Override
	public String getName() {
		return special.name;
	}
	
}
