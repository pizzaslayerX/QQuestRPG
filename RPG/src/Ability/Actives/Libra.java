package Ability.Actives;

import java.io.Serializable;

import gameplay.Player;

public class Libra extends Special implements Serializable
{
	private static boolean targetAll = false;
    private static int manaCost;
    private static int heal;
    private static int percentHeal;
    private static String name = "Libra";
    private static String desc = "Provides an in-depth analysis of enemies. This action takes time...";
    private static String atkDesc = "You gain a vast amount of knowledge about the enemy";
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {1,17,0,0};
    public static boolean limit = false;
    public static boolean use;
    public static boolean useTurn = false;
    
    public Libra() throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll);
    }
    
    public static void equip() throws InterruptedException {
    	Player.abilities.add(new Libra());
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
