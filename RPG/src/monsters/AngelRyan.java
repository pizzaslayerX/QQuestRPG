package monsters;
import backend.*;
public class AngelRyan extends MonsterManager
{

    // instance variables - replace the example below with your own
    public static boolean easy = false;
    public static boolean med = false;
    public static boolean hard = false;
    private String[] movess = {"Employs devastating magic attacks.","Can inflict various status ailments.","Employs various buffs.","Summons allies.","Can cast Doom","Possesses rare loot."};
	private String descs = "One of god's three archangels. This one is stationed in the Carnival in which it uses the inhabitants to conduct experiments on the human soul. Not much else is known about this mystical being for those who lay their eyes on it are doomed.";
    public AngelRyan() {
    	super("Throws a chair at", "Hugs","Viciously smacks");
    	setStats();
        name = "Archangel Ryan";
        smart = true;
    	fireR = 20;
    	iceR = 20;
    	shockR = 20;
        pic = "trapdoor.png";
        maxHealth = health;
        id = 1;
    	moves = movess;
    	desc = descs;
    }
   
    private void setStats()
    {
        if(easy == true)
        {
            evade = 0;
            crit = 5;
            def = 16;
            health = 600;
            attack = 13;
        }
        else if(med == true)
        {
            evade = 0;
            crit = 5;
            def = 16;
            health = 650;
            attack = 14;
        }
        
        else if(hard == true)
        {
            evade = 0;
            crit = 5;
            def = 16;
            health = 700;
            attack = 15;
        }    
        }
    
    public void getDrops() throws InterruptedException
    {
        int gold = 170 + (int)(Math.random() * 71);
        gameplay.LootScreen.setGold(gold);
        int exp = 160 + (int)(Math.random() * 81);
        int threshold = (int)(Math.random() * 101);
        if(threshold < 4)
          weapon.RyanBane.lootWeapon();
        else
            weapon.HarmonyBow.lootWeapon();
        threshold = (int)(Math.random() * 101);
        if(threshold < 25)
            gameplay.LootScreen.setLootMisc("Sacred Tear",3);
        threshold = (int)(Math.random() * 101);
        if(threshold < 35)
            consumables.Elixer.lootItem();
        threshold = (int)(Math.random() * 101);
        if(threshold <= 25)
        {
              RPGRunner.output.setText("");
              RPGRunner.append("You learned Fairy Fire!");
              pause(2000);
              Ability.Actives.FairyFire.equip();
        }
        threshold = (int)(Math.random() * 101);
        if(threshold < 50)
            gameplay.LootScreen.setLootMisc("Noble Arts",1);
        
       if(threshold < 50)
            gameplay.LootScreen.setLootMisc("Uber Soul",1);
        gameplay.LootScreen.setLootMisc("*Archangel Rune",1);
        gameplay.LootScreen.notice("**You unlocked another item slot!**");
        if(consumables.ItemManager.slot4unlock == false) {
        	consumables.ItemManager.slot4unlock = true;
        	consumables.ItemManager.slotCount++;
        }else{
        	consumables.ItemManager.slot5unlock = true;
        	consumables.ItemManager.slotCount++;
        }
        	
         gameplay.LootScreen.setExp(exp);
         gameplay.LootScreen.open();
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


