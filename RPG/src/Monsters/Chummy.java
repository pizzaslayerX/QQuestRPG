package Monsters;
public class Chummy extends MonsterManager
{

    // instance variables - replace the example below with your own
	 public static boolean easy = false;
	    public static boolean med = false;
	    public static boolean hard = false;
	    private String[] movess = {"Capable of exploding at low health."};
		private String descs = "These small circus freaks are everywhere. They mindlessly attack and live only to explode.";
	
    public Chummy() {
    	super("Boops", "Runs into","Smiles at");
    	setStats();
    	name = "Chummy";
    	 smart = true;
    	   fireR = -15;
    	pic = "Chummy.png";
    	maxHealth = health;
    	id=7;
    	desc = descs;
    	moves = movess;
    }
    
    private void setStats()
    {
        if(easy == true)
        {
            evade = 40;
            crit = 0;
            def = 0;
            health = 45;
            attack = 3;
        }
        else if(med == true)
        {
            evade = 45;
            crit = 0;
            def = 0;
            health = 45;
            attack = 3;
        }
        
        else if(hard == true)
        {
            evade = 50;
            crit = 0;
            def = 0;
            health = 46;
            attack = 3;
        }    
        }

    public void getDrops() throws InterruptedException
    {
        int gold = 10 + (int)(Math.random() * 6);
        int threshold = (int)(Math.random() * 101);
        if(threshold < 50)
            Main.LootScreen.setLootMisc("Red Ball",2);
             threshold = (int)(Math.random() * 101);
        if(threshold < 10)
            Main.LootScreen.setLootMisc("Purple Ball",2);
         threshold = (int)(Math.random() * 101);
        if(threshold < 26)
            Main.LootScreen.setLootMisc("Eww Matter",1);
            threshold = (int)(Math.random() * 101);
        if(threshold < 40)
            Main.LootScreen.setLootMisc("Green Ball",1);
        Main.LootScreen.setGold(gold);
        int exp = 20 + (int)(Math.random() * 16);
         Main.LootScreen.setExp(exp);
         Main.LootScreen.open();
    }
   }


