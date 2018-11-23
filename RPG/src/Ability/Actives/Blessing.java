package Ability.Actives;

import Main.Player;

public class Blessing extends Special
{
	private static boolean targetAll = false;
    private static int manaCost = 70;
    private static int heal = 50;
    private static int percentHeal = 0;
    private static String name = "Blessing";
    private static String desc = "Heals 50 HP. Increases defense by 10% for 3 turns | Costs 70 mana";
    private static String atkDesc = "Your skin thickens... A LOT";
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {1,4,10,3};
    public static boolean limit = false;
    public static boolean use;
    public static boolean useTurn = true;
    
    public Blessing() throws InterruptedException
    {
       super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll);
    }
    public static void equip() throws InterruptedException {
    	Player.abilities.add(new Blessing());
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
