package Monsters;
import Run.*;
import Ability.Actives.Ignite;
import Main.*;
public class Rasgoth extends MonsterManager
{
    public static boolean easy = false;
    public static boolean med = false;
    public static boolean hard = false;
    private int evades;
    // instance variables - replace the example below with your own
    private int defs;
    private int healths;
    private int attacks;
    private int crits;
    private String names = "The Demon Rasgoth";
    private boolean smarts = true;
	private int fireRs = 20;
	private int iceRs = -50;
	private int shockRs;
    private String pics = "Rasgoth.jpg";
    private String[] movess = {"Employs moderate physical attacks.","Employs powerful magic attacks.","Can inflict stun.","Can summon allies.","Can drops rare items."};
	private String descs = "An ancient and powerful fire demon that dwells in the underworld. These beasts were feared by all until they retreated underground for unknown reasons. It appears that this one is somehow subservient to God.";
    public Rasgoth() {
    	super();
    	setStats();
    	summon();
    	maxHealth = health;
    	id=24;
    	moves = movess;
    	desc = descs;
    }
    
    public void setStats()
    {
        if(easy == true)
        {
            evades = 0;
            crits = 5;
            defs = 15;
            healths = 150;
            attacks = 6;
        }
        else if(med == true)
        {
            evades = 0;
            crits = 10;
            defs = 15;
            healths = 175;
            attacks = 7;
        }
        
        else if(hard == true)
        {
            evades = 0;
            crits = 15;
            defs = 20;
            healths = 200;
            attacks = 7;
        }    
        }
    
    private void summon()
    {
        spawnMonster(names,defs,healths,attacks,smarts,"Blows smoke on", "Slashes","Smashes",crits,evades,fireRs,iceRs,shockRs,pics);
    }
    
    public void getDrops() throws InterruptedException
    {
        int gold = 40 + (int)(Math.random() * 41);
        Main.LootScreen.setGold(gold);
        int exp = 35 + (int)(Math.random() * 16);
        int threshold = 1 + (int)(Math.random() * 100);
        if(threshold <= 50)
        {
            Weapon.HellFork.lootWeapon();
        }
        threshold = 1 + (int)(Math.random() * 100);
         if(threshold <= 30)
        {
            Weapon.Titan.lootWeapon();
        }
         threshold = 1 + (int)(Math.random() * 100);
         if(threshold <= 35)
        {
           Item.PowerPotion.lootItem();
        }
        threshold = 1 + (int)(Math.random() * 100);
         if(threshold <= 40)
        {
           Item.MegaPotion.lootItem();
        }
        threshold = 1 + (int)(Math.random() * 100);
        if(threshold <= 20)
        {
           Item.Elixer.lootItem();
        }
        threshold = 1 + (int)(Math.random() * 100);
        if(threshold <= 20)
        {
           Main.LootScreen.setLootMisc("Dark Goo",3);
        }
        threshold = 1 + (int)(Math.random() * 100);
        if(threshold <= 50)
        {
           Main.LootScreen.setLootMisc("Flaming Tear",1);
        }
        threshold = 1 + (int)(Math.random() * 100);
        if(threshold <= 100 && (Player.checkAbility(Ignite.class) == true))
        {
            RPGRunner.append("You learned Simmer.\n");
            pause(2000);
            Ability.Actives.Simmer.equip();
        }
        threshold = 1 + (int)(Math.random() * 100);
         if(threshold <= 65)
        {
            Armor.LizardHide.lootArmor();
        }
        Main.LootScreen.setExp(exp);
        Main.LootScreen.open();
        
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


