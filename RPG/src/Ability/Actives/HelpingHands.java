package Ability.Actives;

import Main.Player;

public class HelpingHands extends Special
{
	private static boolean targetAll = false;
    private static String name = "Helping Hands";
    private static String desc = "Heals 20 HP. Heals another 42 HP over 6 turns  | Cost: 56 Mana";
    private static String atkDesc = "You feel a spirit helping you recover";
    private static int manaCost = 35;
    private static int heal = 20;
    private static int percentHeal;
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {1,8,7,6};
    public static boolean limit = false;
    public static boolean use;
    public static boolean useTurn = true;
    
    public HelpingHands() throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll);
    }
    
    public static void equip() throws InterruptedException {
    	Player.abilities.add(new HelpingHands());
    }
    
        public static void pause(int t)
    {
        try {
            Thread.sleep(t);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
