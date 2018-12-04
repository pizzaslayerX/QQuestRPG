package monsters;

public class DireSlug extends MonsterManager
{
    
    public static boolean easy = false;
    public static boolean med = false;
    public static boolean hard = false;
    private String[] movess = {"Weak"};
	private String descs = "A hungry slug that is always searching for food.";
	
    public DireSlug() {
    	super("Viciously bites", "vomits on","tackles");
    	setStats();
    	name = "Dire Slug";
        smart = false;
        pic = "DireSlug.jpg";
        maxHealth = health;
        id=9;
        moves = movess;
        desc = descs;
    }
    
    private void setStats()
    {
        if(easy == true)
        {
            evade = 0;
            crit = 0;
            def = 0;
            health = 6;
            attack = 2;
        }
        else if(med == true)
        {
            evade = 0;
            crit = 0;
            def = 0;
            health = 9;
            attack = 2;
        }
        
        else if(hard == true)
        {
            evade = 0;
            crit = 0;
            def = 0;
            health = 9;
            attack = 3;
        }    
        }

    
    public void getDrops() throws InterruptedException
    {
        int gold = 10 + (int)(Math.random() * 10);
        gameplay.LootScreen.setGold(gold);
        int exp = 2 + (int)(Math.random() * 4);
        gameplay.LootScreen.setExp(exp);
        gameplay.LootScreen.open();
        
    }
   }


