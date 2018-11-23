package Ability.Actives;

import Main.Player;

public class Plague extends Special
{
	private static boolean targetAll = false;
    private static int manaCost = 0;
    private static int heal = 0;
    private static int percentHeal = 0;
    private static String name = "Plague";
    private static String desc = "Deals 8 poison dmg per turn until 25% of enemy max health is lost from posion dmg.";
    private static String atkDesc = "A deadly pathogen has been unleashed!";
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg = false;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {1,14,8,25};
    public static boolean limit = true;
    public static boolean use;
    public static boolean useTurn = true;
    
    public Plague() throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll);
    }
    
    public static void equip() throws InterruptedException {
    	Player.abilities.add(new Plague());
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
