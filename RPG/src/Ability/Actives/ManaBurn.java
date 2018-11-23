package Ability.Actives;

import Main.Player;

public class ManaBurn extends Special
{
	private static boolean targetAll = false;
    private static int manaCost;
    private static int heal;
    private static int percentHeal;
    private static String name = "Mana Burn";
    private static String desc = "Deals remaining mana as pure dmg. | Cost: All Mana";
    private static String atkDesc = "You channel your mana into a destructive beam";
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {1,7,0,0};
    public static boolean limit = true;
    public static boolean use;
    public static boolean useTurn = true;
    
    public ManaBurn() throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll);
    }
    
    public static void equip() throws InterruptedException {
    	Player.abilities.add(new ManaBurn());
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
