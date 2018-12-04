package Ability.Actives;

import gameplay.Player;

public class FairyFire extends Special
{
	private static boolean targetAll = false;
    private static int percentHeal;
    private static int manaCost = 68;
    private static int heal;
    private static String name = "Fairy Fire";
    private static String desc = "Deals 80 fire dmg over 5 turns and Heals 80 HP over 5 turns | Cost: 68 Mana";
    private static String atkDesc = "A red and green fairy comes to your aid!";
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {2,1,16,5,8,16,5};
    public static boolean limit = false;
    public static boolean use;
    public static boolean useTurn = true;
    
    public FairyFire() throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll);
    }
    
    public static void equip() throws InterruptedException {
    	Player.abilities.add(new FairyFire());
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
