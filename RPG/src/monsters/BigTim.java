package monsters;

public class BigTim extends MonsterManager
{

    // instance variables - replace the example below with your own
    public static boolean easy = false;
    public static boolean med = false;
    public static boolean hard = false;
    private String[] movess = {"Employs powerful physical attacks.","Can inflict Silence and Stun.","Occasionally experiences fits of rage.","Drops Carnival Keys.","Drops rare balls."};
	private String descs = "A fat, oversized clown that has a thing for small creatures. The big guy has lost most of his humanity.";
    public BigTim() {
    	super("Burps on", "Farts on","Belly Flops");
    	setStats();
        name = "Big Tim";
        smart = true;
    	iceR = 25;
    	shockR = 0;
        pic = "BigTim.jpg";
        maxHealth = health;
        id=5;
        moves = movess;
    	desc = descs;
    }
    
    private void setStats()
    {
        if(easy == true)
        {
            evade = 0;
            crit = 5;
            def = 20;
            health = 265;
            attack = 17;
        }
        else if(med == true)
        {
            evade = 0;
            crit = 5;
            def = 20;
            health = 280;
            attack = 17;
        }
        
        else if(hard == true)
        {
            evade = 0;
            crit = 10;
            def = 20;
            health = 311;
            attack = 18;
        }    
        }
    public void getDrops() throws InterruptedException
    {
        int gold = 30 + (int)(Math.random() * 21);
        gameplay.LootScreen.setGold(gold);
        int exp = 55 + (int)(Math.random() * 6);
        int threshold = (int)(Math.random() * 101);
        int amt = (int)(Math.random() * 2) + 1;
        if(threshold < 65)
            gameplay.LootScreen.setLootMisc("Purple Ball",amt);
        threshold = (int)(Math.random() * 101);
        amt = (int)(Math.random() * 4) + 2;
        if(threshold < 50)
            gameplay.LootScreen.setLootMisc("Green Ball",amt);
        threshold = (int)(Math.random() * 101);
         if(threshold < 30)
            consumables.MegaPotion.lootItem();
        gameplay.LootScreen.setLootMisc("Carnival Key",1);
       
         gameplay.LootScreen.setExp(exp);
         gameplay.LootScreen.open();
    }
   }


