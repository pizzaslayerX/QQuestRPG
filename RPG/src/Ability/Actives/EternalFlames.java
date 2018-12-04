package Ability.Actives;

import gameplay.Player;

public class EternalFlames extends Special
{
	private static boolean targetAll = false;
    private static int manaCost = 80;
    private static int heal = 0;
    private static int percentHeal = 0;
    private static String name = "Eternal Flames";
    private static String desc = "Deals 11 fire dmg every turn for an entire fight | Costs 80 mana";
    private static String atkDesc = "Eternal flames cover the battlefield";
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {1,1,11,99};
    public static boolean limit = true;
    public static boolean use;
    public static boolean useTurn = true;
    
    public EternalFlames() throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll);
    }
    public static void equip() throws InterruptedException {
    	Player.abilities.add(new EternalFlames());
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
