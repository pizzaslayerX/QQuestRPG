package Ability.Actives;

import java.util.ArrayList;

import gameplay.Player;

public class CryoPlane extends Special
{
	private static boolean targetAll = true;
    private static int percentHeal = 0;
    private static int manaCost = 0;
    private static int heal = 0;
    private static String name = "Cryoplane";
    private static String desc = "+20% Speed, -15% Ice Resist for 4 turns | Targets Everyone | Does not use turn";
    private static String atkDesc = "The air grows chilly. You turn the ground into slippery ice.";
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {4,32,20,4,30,15,4,34,20,4,24,15,4};
    public static boolean limit = true;
    public static boolean use;
    public static boolean useTurn = false;
    
    public CryoPlane(boolean t) throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,55,t);
    }
    
    public static void equip() throws InterruptedException {
    	new CryoPlane(true);
    }
    
      
    

		@Override
		public ArrayList<Class<? extends Special>> getNewSpecial() {
			ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
			list.add(IceShower.class);
			return list;
		}

		@Override
		public boolean isLearnable() {
			if(Player.checkAbility(Gale.class))
				return true;
			return false;
		}
}
