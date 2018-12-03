package Ability.Actives;

import java.util.ArrayList;

import Main.Player;

public class DivineLove extends Special
{
	private static boolean targetAll = false;
    private static int manaCost = 300;
    private static int heal;
    private static int percentHeal = 100;
    private static String name = "Divine Love";
    private static String desc = "Fully restores HP. +10% def and elemental resistance for 4 turns. Restores 36 HP over 3 turns. | Cost: 300 mana";
    private static String atkDesc = "An almighty creator has chosen you as his vessel. Slay all the infidels!";
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {5,4,10,4,26,10,4,27,10,4,28,10,4,8,12,3};
    public static boolean limit = true;
    public static boolean use;
    public static boolean useTurn = true;
    
    public DivineLove(boolean t) throws InterruptedException
    {
       super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,350,t);
    }
    public static void equip() throws InterruptedException {
    	new DivineLove(true);
    }
    @Override
	public ArrayList<Class<? extends Special>> getNewSpecial() {
		ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
		return list;
	}

	@Override
	public boolean isLearnable() {
		if(Player.checkAbility(Blessing.class) && Player.checkAbility(HelpingHands.class))
			return true;
		return false;
	}
}
