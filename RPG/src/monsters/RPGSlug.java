package monsters;

public class RPGSlug extends MonsterManager
{
    public static boolean easy = false;
    public static boolean med = false;
    public static boolean hard = false;
    // instance variables - replace the example below with your own
    private int defs;
    private int healths;
    private int evades;
    private int attacks;
    private int crits;
    private String names = "Slug";
    private boolean smarts = false;
	private int fireRs;
	private int iceRs;
	private int shockRs;
    private String pics = "Slug.jpg";
    private String[] movess = {"Weak."};
   	private String descs = "A typical RPG starter enemy. It is made to die.";  
    public RPGSlug() {
    	super();
    	setStats();
    	summon();
    	maxHealth = health;
    	id=27;
    	moves = movess;
    	desc = descs;
    }
    
    private void setStats()
    {
        if(easy == true)
        {
            evades = 0;
            crits = 0;
            defs = 0;
            healths = 3;
            attacks = 1;
        }
        else if(med == true)
        {
            evades = 0;
            crits = 0;
            defs = 0;
            healths = 3;
            attacks = 1;
        }
        
        else if(hard == true)
        {
            evades = 0;
            crits = 0;
            defs = 0;
            healths = 3;
            attacks = 2;
        }    
        }
    
    private void summon()
    {
       spawnMonster(names,defs,healths,attacks,smarts,"bites", "vomits on","licks",crits,evades,fireRs,iceRs,shockRs,pics);
    }
    
    public void getDrops() throws InterruptedException
    {
        int gold = 1 + (int)(Math.random() * 9);
        gameplay.LootScreen.setGold(gold);
        int exp = 1 + (int)(Math.random() * 2);
        gameplay.LootScreen.setExp(exp);
        gameplay.LootScreen.open();
    }
   }
