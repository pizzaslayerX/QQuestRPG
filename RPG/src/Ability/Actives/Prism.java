package Ability.Actives;

import java.util.ArrayList;

import gameplay.Player;

public class Prism extends Special
{
	private static boolean targetAll = false;
    private static int manaCost = 0;
    private static int heal = 0;
    private static int percentHeal = 0;
    private static String name = "Prism";
    private static String desc = "+15 to all elemental resistances for 3 turns| Cost: 160 mana";
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
    
    public Prism() throws InterruptedException 
    {
    	super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,50);  
    }
    
   
    public static void equip() throws InterruptedException {
    	Player.abilities.add(new Prism());
    }
    
        public static void pause(int t)
    {
        try {
            Thread.sleep(t);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }


		@Override
		public ArrayList<Class<? extends Special>> getNewSpecial() {
			// TODO Auto-generated method stub
			return null;
		}


		@Override
		public boolean isLearnable() {
			// TODO Auto-generated method stub
			return false;
		}
}
