package armor;

import java.awt.Color;
import java.io.Serializable;

import gameplay.Shoppable;

public class Gem implements Serializable,Shoppable{
	public enum Type {
		BLUE,WHITE,YELLOW,RED,RAINBOW,TIME;
		
		private int level;
		private String name;
		//0=shard,1=stone,2=gem,3=crystal
		public String getType() {
			switch(this) {
				case BLUE:
					return "Glacial";
				case WHITE:
					return "Moon";
				case YELLOW:
					return "Voltaic";
				case RED:
					return "Blazing";
				case RAINBOW:
					return "Prismatic";
				case TIME:
					return "Chronic";
			}
		 return "error";
		}
		public int getBonus() {
			if(level == 0)
				return 5;
			else if(level == 1)
				return 10;
			else if(level == 2)
				return 15;
			else
				return 20;
		}
		
		public String getName() {
			name = getType() + " ";
			if(level == 0)
				name += "Shard";
			else if(level == 1)
				name += "Stone";
			else if(level == 2)
				name += "Gem";
			else
				name += "Crystal";
			return name;
		}
		
		public int getPrice() {
			if(this == Type.WHITE) {
				if(level == 0)
					return 200;
				else if(level == 1)
					return 650;
				else if(level == 2)
					return 900;
				else return 1500;
			}else if(this == Type.RAINBOW) {
				if(level == 0)
					return 380;
				else if(level == 1)
					return 1000;
				else if(level == 2)
					return 1500;
				else return 2000;
			}else if(this == Type.TIME) {
				if(level == 0)
					return 475;
				else if(level == 1)
					return 950;
				else if(level == 2)
					return 1400;
				else return 2000;
			}else {
				if(level == 0)
					return 50;
				else if(level == 1)
					return 400;
				else if(level == 2)
					return 750;
				else return 1000;
			}
		}
		
		public int getLevel() {
			return level;
		}

		
	}
	private Type color;
	
	public Gem(Type t, int l) {
		color = t;
		color.level = l;
	}
	
	public Type getGemInfo() {
		return color;
	}
	
	@Override
	public String getName() {
		return color.getName();
	}
	
	public Color getColor() {
		if(color == Type.BLUE) {
			return Color.CYAN;
		}
		else if(color == Type.RAINBOW) {
			return Color.PINK;
		}
		else if(color == Type.RED)
			return Color.RED;
		else if(color == Type.WHITE)
			return Color.LIGHT_GRAY;
		else if(color == Type.YELLOW)
			return Color.YELLOW;
		else
			return Color.GREEN;
		
	}
	
	public void equip(armor.ArmorManager a) {
		if(color == Type.BLUE) {
			a.iceR += color.getBonus();
		}
		else if(color == Type.RAINBOW) {
			a.fireR += color.getBonus();
			a.iceR += color.getBonus();
			a.shockR += color.getBonus();
		}
		else if(color == Type.RED)
			a.fireR += color.getBonus();
		else if(color == Type.WHITE)
			a.def += color.getBonus();
		else if(color == Type.YELLOW)
			a.shockR += color.getBonus();
		else if(color == Type.TIME)
			a.fireR += 0;
		for(int i = 0;i<a.jewelSlots.length;i++) {
			if(a.jewelSlots[i] == null) {
				a.jewelSlots[i] = this;
				break;
			}
		}
			
	}

	@Override
	public int sell() {
		return (int)(color.getPrice()*0.6);
	}

	@Override
	public int buy() {
		return color.getPrice();
	}

	@Override
	public String getDesc() {
		if(color == Type.TIME) {
			switch(color.getLevel()) {
				case 0:
					return "Slightly speeds up actions.";
				case 1:
					return "Speeds up actions.";
				case 2:
					return "Greatly speeds up actions.";
				case 3:
					return "Grants mastery over time.";
			}	
		}else if(color == Type.RAINBOW) 
			return "+" + color.getBonus() + "% resistance to all elements.";
		else if(color == Type.WHITE) 
			return "+" + color.getBonus() + "% resistance to normal attacks";
		else if(color == Type.BLUE) 
			return "+" + color.getBonus() + "% resistance to ice.";
		else if(color == Type.RED) 
			return "+" + color.getBonus() + "% resistance to all fire.";
		return "+" + color.getBonus() + "% resistance to all electricity.";
		
			
	}
	
}
