package monsters;

public class DireClown extends MonsterManager
{

   
    public static boolean easy = false;
    public static boolean med = false;
    public static boolean hard = false;
    private String[] movess = {"Specializes in physical attacks.","Can inflict Silence.","Occassionaly experiences intense fits of pure rage.","Capable of exploding at low health."};
	private String descs = "A scary clown on every drug imaginable. Their utter insanity is unparralleled.";
	
    public DireClown() {
    	super("Screams at", "Lobs paint at","Flails it's arms at");
    	setStats();
    	name = "Dire Clown";
    	smart = true;
    	fireR = 10;
    	iceR = 10;
    	shockR = 10;
    	pic = "DireClown.jpg";
    	maxHealth = health;
    	id=8;
    	moves = movess;
    	desc = descs;
    }
    
    private void setStats()
    {
        if(easy == true)
        {
            evade = 10;
            crit = 35;
            def = 0;
            health = 85;
            attack = 9;
        }
        else if(med == true)
        {
            evade = 10;
            crit = 35;
            def = 0;
            health = 85;
            attack = 11;
        }
        
        else if(hard == true)
        {
            evade = 10;
            crit = 35;
            def = 0;
            health = 90;
            attack = 12;
        }    
        }
    
    public void getDrops() throws InterruptedException
    {
        int gold = 30 + (int)(Math.random() * 11);
        gameplay.LootScreen.setGold(gold);
        int exp = 18 + (int)(Math.random() * 11);
        int threshold = (int)(Math.random() * 101);
        int amt = (int)(Math.random() * 3) + 1;
        if(threshold < 50)
            gameplay.LootScreen.setLootMisc("Blue Ball",amt);
         gameplay.LootScreen.setExp(exp);
         gameplay.LootScreen.open();
    }
   }


