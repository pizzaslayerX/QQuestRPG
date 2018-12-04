package monsters;

public class BalloonImp extends MonsterManager
{

    // instance variables - replace the example below with your own
    public static boolean easy = false;
    public static boolean med = false;
    public static boolean hard = false;
    private String[] movess = {"Attacks in groups."};
	private String descs = "A definite monstrosity. This is obviously the result of an experiment involving souls and inanimate objects gone wrong.";
	public BalloonImp() {
    	super("Launches balloon rockets at", "Bites","Slobbers on");
    	setStats();
    	pic = "BalloonImp.jpg";
    	smart = true;
    	name = "Balloon Imp";
    	maxHealth = health;
    	id=2;
    	moves = movess;
    	desc = descs;
    }
	
    private void setStats()
    {
        if(easy == true)
        {
            evade = 22;
            crit = 0;
            def = 3;
            health = 65;
            attack = 7;
        }
        else if(med == true)
        {
            evade = 25;
            crit = 10;
            def = 5;
            health = 65;
            attack = 7;
        }
        
        else if(hard == true)
        {
            evade = 25;
            crit = 10;
            def = 5;
            health = 74;
            attack = 8;
        }    
        }
    
    
    public void getDrops() throws InterruptedException
    {
        int gold = 20 + (int)(Math.random() * 17);
        gameplay.LootScreen.setGold(gold);
        int exp = 18 + (int)(Math.random() * 13);
        int threshold = (int)(Math.random() * 101);
        if(threshold < 45)
            gameplay.LootScreen.setLootMisc("Red Ball",1);
        threshold = (int)(Math.random() * 101);
        if(threshold < 4)
            weapon.BalloonLauncher.lootWeapon();
         gameplay.LootScreen.setExp(exp);
         gameplay.LootScreen.open();
    }
   }


