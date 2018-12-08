package Ability.Actives;

import java.util.ArrayList;

import gameplay.Player;

public class Prism extends Special
{
	private static boolean targetAll = false;
    private static int manaCost = 67;
    private static int heal = 0;
    private static int percentHeal = 0;
    private static String name = "Prism";
    private static String desc = "+15% to all elemental resistances for 3 turns| Cost: 67 mana";
    private static String atkDesc = "You become shrouded in rainbows";
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg = false;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {3,26,15,3,27,15,3,28,15,3};
    public static boolean limit = false;
    public static boolean use;
    public static boolean useTurn = true;
    
    public Prism(boolean t) throws InterruptedException 
    {
    	super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,50,t);  
    }
    
   
    public static void equip() throws InterruptedException {
    	new Prism(true);
    }
    
  
    


    @Override
   	public ArrayList<Class<? extends Special>> getNewSpecial() {
   		ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
   		return list;
   	}

   	@Override
   	public boolean isLearnable() {
   		if(Player.checkAbility(Extinguish.class) && Player.checkAbility(ThermoElectricity.class) && Player.checkAbility(Insulate.class))
   			return true;
   		return false;
   	}
}
