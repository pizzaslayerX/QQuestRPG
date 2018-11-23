package Ability.Actives;

import Main.Player;

public class SuperNova extends Special
{
	private static boolean targetAll = false;
    private static int manaCost = 300;
    private static int heal = 0;
    private static int percentHeal = 0;
    private static String name = "Super Nova";
    private static String desc = "80 pure Dmg. Stuns: 2 turns. 105 fire dmg over 5 turns | Costs: 300 mana";
    private static String atkDesc = "The power of the sun incinerates the enemy";
    private static int dmg = 80;
    private static boolean pureDmg = true;
    private static boolean doesDmg = true;
    private static boolean statusEffect = true;
    public static boolean limit = true;
    public static boolean use;
    public static boolean useTurn = true;
     private static int[] statusVal = {2,1,21,5,3,0,2};
    public SuperNova() throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll);
    }
    
    public static void equip() throws InterruptedException {
    	Player.abilities.add(new SuperNova());
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
