package monsters;

public class BasicClown extends MonsterManager
{
    public static boolean easy = false;
    public static boolean med = false;
    public static boolean hard = false;
    private String[] movess = {"Employs moderate physical attacks.","Can inflict Silence and Stun.","Occasionally experiences fits of rage."};
	private String descs = "Just your generic clown man: insane, mindless, and murderous... Oh yeah, and it's always smiling (creepy!).";
    // instance variables - replace the example below with your own
   public BasicClown() {
	   super("Throws balls at", "Honks a horn at","Jumps on");
	   setStats();
	   name = "Scary Clown";
	   smart = true;
		pic = "Clown.jpg";
		maxHealth = health;
		id=3;
		moves = movess;
    	desc = descs;
   }
	
    private void setStats()
    {
        if(easy == true)
        {
            evade = 0;
            crit = 25;
            def = 20;
            health = 90;
            attack = 9;
        }
        else if(med == true)
        {
            evade = 0;
            crit = 25;
            def = 20;
            health = 95;
            attack = 10;
        }
        
        else if(hard == true)
        {
            evade = 0;
            crit = 25;
            def = 20;
            health = 110;
            attack = 10;
        }    
        }
    
    
    public void getDrops() throws InterruptedException
    {
        int gold = 13 + (int)(Math.random() * 8);
        gameplay.LootScreen.setGold(gold);
        int exp = 15 + (int)(Math.random() * 21);
        int threshold = (int)(Math.random() * 101);
        int amt = (int)(Math.random() * 3) + 1;
        if(threshold < 50)
            gameplay.LootScreen.setLootMisc("Red Ball",amt);
        threshold = (int)(Math.random() * 101);
        if(threshold < 16)
            gameplay.LootScreen.setLootMisc("Blue Ball",1);
         gameplay.LootScreen.setExp(exp);
         gameplay.LootScreen.open();
    }
   }


