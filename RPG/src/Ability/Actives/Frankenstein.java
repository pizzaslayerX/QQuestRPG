package Ability.Actives;

import Main.Player;

public class Frankenstein extends Special
{
	private static boolean targetAll = false;
    private static int manaCost = 0;
    private static int heal = 0;
    private static int percentHeal = 0;
    private static String name = "Frankenstein's Delight";
    private static String desc = "144 shock dmg,+5 dmg,Stuns for 3 turns. | Cost: 72 health";
    private static String atkDesc = "You summon a monster fueled by storms and blood.";
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {4,13,144,1,3,0,3,6,5,3,9,69,0};
    public static boolean limit = false;
    public static boolean use;
    public static boolean useTurn = true;
    
    public Frankenstein() throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll);
    }
    
    public static void equip() throws InterruptedException {
    	Player.abilities.add(new Frankenstein());
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
