package armor;
import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;

import backend.RPGRunner;
import gameplay.Player;
import gameplay.Shoppable;

public class ArmorManager implements Serializable, Shoppable
{
	public int fireR;
	public int iceR;
	public int shockR;
    public int def;
    public int price;
    public String name;
    public String desc;
    public Gem[] jewelSlots;
    
    public ArmorManager (int d, String n, String dc,int p,int fr,int ir,int sr) {
    	def = d;
    	name = n;
    	desc = dc;
    	price = p;
    	fireR = fr;
    	iceR = ir;
    	shockR = sr;
        jewelSlots = new Gem[3];
    }
    
    public ArmorManager (int d, String n, String dc,int p,int fr,int ir,int sr,int js,Gem...gems) {
    	def = d;
    	name = n;
    	desc = dc;
    	price = p;
    	fireR = fr;
    	iceR = ir;
    	shockR = sr;
        jewelSlots = new Gem[js];
        for(Gem g : gems)
        	g.equip(this);
    }
     
    public int timeScore() {
    	int score = 0;
    	for(int i = 0;i<jewelSlots.length;i++) {
    		if(jewelSlots[i] != null && jewelSlots[i].getGemInfo().getType().equals("Chronic")) 
    			score += (jewelSlots[i].getGemInfo().getLevel() + 1);
    	}
    	return score;
    }
    
    public void print() {
    	//U+26AA = white
    	//U+26AB = black
    	RPGRunner.append(name + " ",Color.WHITE,30,false);
    	for(int i = 0;i<jewelSlots.length;i++) {
    		if(jewelSlots[i] == null)
    			RPGRunner.append("\u26AA",Color.WHITE,25,false);
    		else
    			RPGRunner.append("\u26AB",jewelSlots[i].getColor(),25,false);
    	}
    	RPGRunner.append("\n	[def: " + def + "][Fire Resist: %" + fireR + "][Ice Resist: %"+iceR+"][Shock Resist: %"+shockR+"]",Color.WHITE,18,false);
    }
    
    public static void setArmor(int d,String n,String dc,int p,int fr,int ir,int sr) throws InterruptedException
    {
        Player.addArmor(new ArmorManager(d,n,dc,p,fr,ir,sr));
    }

	@Override
	public int sell() {
		return (int)(price * 0.6);
	}

	@Override
	public int buy() {
		return price;
	}

	@Override
	public String getDesc() {
		return desc + "\nDef: " + def + "\nFire Resist: " + fireR + "\nIce Resist: " + iceR + "\nShock Resist: " + shockR + "\nJewel Slots: " + jewelSlots.length;
	}

	@Override
	public String getName() {
		return name;
	}
}
