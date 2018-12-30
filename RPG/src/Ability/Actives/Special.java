package Ability.Actives;

import java.io.Serializable;
import java.util.ArrayList;

import Ability.Passives.List;
import gameplay.Player;

public abstract class Special implements Serializable{
    public int manaCost;
    public int heal;
    public String name;
    public String desc;
    public String atkDesc;
    public int dmg;
    public int percentHeal;
    public boolean pureDmg;
    public boolean doesDmg;
    public boolean statusEffect;
    public boolean limit;
    public boolean use;
    public boolean useTurn;
    public int[] statusVal;
    public boolean targetAll;
    public int id;
    public int cost;

    private static int idCount = 0;
    
    
    public Special(String n, String dc, String ad,int d,boolean pd,boolean dd,boolean s,boolean l,boolean u,boolean ut,int[]sv,int h,int m,int ph,boolean t,int co,boolean bo) throws InterruptedException {
    	statusVal = new int[30];
        name = n;
        cost = co;
        desc = dc;
        atkDesc = ad;
        dmg = d;                                              
        pureDmg = pd;
        doesDmg = dd;
        statusEffect = s;
        limit = l;
        use = u;
        useTurn = ut;
        manaCost = m;
        heal = h;
        percentHeal = ph;
        for(int i = 0; i < sv.length;i++)
        	statusVal[i] = sv[i];
        
        if(bo && !(this instanceof Vampire)) {
        	Manager.setAbility(this);
        	equipAbility();
        }
        
        if(this instanceof Vampire) {
        	Player.abilities.add(this);
        	 if(List.names.equals("None"))
                 List.names = "Vampirism";
                 else
                	 List.names = List.names + " | Vampirism";
        	 Player.evadeChance += 20;
        	 Player.baseDef -= 25;
        	 Player.baseFireR -= 50;
        	 Player.maxHealth += (Player.maxHealth * 0.2);
    	}
        
        if(bo && this instanceof Karmazatz) {
        		Player.maxHealth = (int)(Player.maxHealth * 0.75);
        	Player.maxMana += 30;
        	Ability.Passives.Lucky.unlock = true;
        	Ability.Passives.Lucky.use();
        	Player.baseIceR += 10;
        }
        	
        
        targetAll = t;
        id = idCount;
        idCount++;
    }
    
    
    
    	/**
    	 * The object oriented method of the equip() method found in the other Special objects. This method spawned from bad coding practices!
    	 * @throws InterruptedException
    	 */
    public void equipAbility() throws InterruptedException{
    	Player.abilities.add(this);
    	
    }
    
    public abstract ArrayList<Class<? extends Special>> getNewSpecial();
    
    public abstract boolean isLearnable();
   
    
    public int getID() {
    	return id;
    }
    
}
