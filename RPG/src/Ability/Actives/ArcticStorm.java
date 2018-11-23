package Ability.Actives;

import java.util.ArrayList;

import Main.Player;

public class ArcticStorm extends Special
{
	private static boolean targetAll = false;
    private static int manaCost = 160;
    private static int heal = 0;
    private static int percentHeal = 0;
    private static String name = "Arctic Storm";
    private static String desc = "+20 def for 3 turns. Deals 180 frost dmg over 8 turns. | Cost: 160 mana";
    private static String atkDesc = "A blizzard rushes in from the Mountains";
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg = false;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {2,4,20,3,12,10,8};
    public static boolean limit = false;
    public static boolean use;
    public static boolean useTurn = true;
    
    public ArcticStorm() throws InterruptedException
    {
    	super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll);  
    }
    
   
    public static void equip() throws InterruptedException {
    	Player.abilities.add(new ArcticStorm());
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
