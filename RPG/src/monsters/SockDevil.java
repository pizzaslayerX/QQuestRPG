package monsters;
import backend.*;
public class SockDevil extends MonsterManager
{
    public static boolean easy = false;
    public static boolean med = false;
    public static boolean hard = false;
    // instance variables - replace the example below with your own
    private int evades;
    private int defs;
    private int healths;
    private int attacks;
    private int crits;
    private String names = "Sock Devil";
    private boolean smarts = true;
	private int fireRs;
	private int iceRs;
	private int shockRs;
    private String pics = "SockDevil.png";
    private String[] movess = {"Can inflict massive damage.","Capable of inflicting Silence and Stun."};
	private String descs = "Much cancer.";
    public SockDevil() {
    	super();
    	setStats();
    	summon();
    	maxHealth = health;
    	id=32;
    	moves = movess;
    	desc = descs;
    }
    
    private void setStats()
    {
        if(easy == true)
        {
            evades = 60;
            crits = 50;
            defs = 5;
            healths = 100;
            attacks = 10;
        }
        else if(med == true)
        {
            evades = 60;
            crits = 50;
            defs = 5;
            healths = 110;
            attacks = 10;
        }
        
        else if(hard == true)
        {
            evades = 65;
            crits = 50;
            defs = 8;
            healths = 120;
            attacks = 11;
        }    
        }
    
    private void summon()
    {
        spawnMonster(names,defs,healths,attacks,smarts,"Chucks hundreds of socks at", "Punishes","Steals blood from",crits,evades,fireRs,iceRs,shockRs,pics);
    }
    
    public void getDrops() throws InterruptedException
    {
        int gold = 50 + (int)(Math.random() * 15);
        gameplay.LootScreen.setGold(gold);
        int exp = 65 + (int)(Math.random() * 16);
        int threshold = (int)(Math.random() * 101);
        if(threshold < 5)
            weapon.SuperSockStaff.lootWeapon();
        threshold = 1 + (int)(Math.random() * 100);
        int amt = 1 + (int)(Math.random() * 2);
        if(threshold <= 20)
        {
           gameplay.LootScreen.setLootMisc("Dark Goo",amt);
        }
        threshold = (int)(Math.random() * 101);
        if(threshold < 30)
            consumables.Ultramarine.lootItem();
        gameplay.LootScreen.setExp(exp);
        gameplay.LootScreen.open();
    }
   }


