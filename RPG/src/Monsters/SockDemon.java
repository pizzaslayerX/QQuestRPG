package Monsters;
import Run.*;
public class SockDemon extends MonsterManager
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
    private String names = "Sock Demon";
    private boolean smarts = true;
	private int fireRs = -10;
	private int iceRs;
	private int shockRs;
    private String pics = "SockDemon.jpg";
    private String[] movess = {"Can inflict massive damage.","Capable of inflicting Silence and Stun."};
	private String descs = "Cancer.";
    public SockDemon() {
    	super();
    	setStats();
    	summon();
    	maxHealth = health;
    	id=31;
    	moves = movess;
    	desc = descs;
    }
    
    private void setStats()
    {
        if(easy == true)
        {
            evades = 60;
            crits = 50;
            defs = 0;
            healths = 50;
            attacks = 5;
        }
        else if(med == true)
        {
            evades = 60;
            crits = 50;
            defs = 0;
            healths = 55;
            attacks = 5;
        }
        
        else if(hard == true)
        {
            evades = 65;
            crits = 50;
            defs = 0;
            healths = 60;
            attacks = 6;
        }    
        }
    
    private void summon()
    {
        spawnMonster(names,defs,healths,attacks,smarts,"Rubs", "Shoots a volley of socks at","Flops on",crits,evades,fireRs,iceRs,shockRs,pics);
    }
    
    public void getDrops() throws InterruptedException
    {
        int gold = 15 + (int)(Math.random() * 15);
        Main.LootScreen.setGold(gold);
        int exp = 18 + (int)(Math.random() * 8);
        int threshold = (int)(Math.random() * 101);
        if(threshold < 5)
            Weapon.SockStaff.lootWeapon();
        threshold = (int)(Math.random() * 101);
         int amt = (int)(Math.random() * 3) + 1;
        if(threshold < 30)
            Main.LootScreen.setLootMisc("Dark Dust",amt);
        threshold = (int)(Math.random() * 101);
        if(threshold < 30)
            Item.Ultramarine.lootItem();
        Main.LootScreen.setExp(exp);
        Main.LootScreen.open();
    }
   }


