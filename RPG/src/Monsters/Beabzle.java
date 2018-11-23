package Monsters;

public class Beabzle extends MonsterManager
{
    public static boolean easy = false;
    public static boolean med = false;
    public static boolean hard = false;
    
    public Beabzle()
    {
    	super("Smacks", "Screams at","Glares at");
    	setStats();
        name = "Beabzle";
        smart = true;
    	fireR = -40;
    	iceR = -40;
    	shockR = 100;
        pic = "Beabzle.jpg";
        maxHealth = health;
        id=4;
        moves = new String[1];
        moves[0] = "???";
        desc = "???";
        
    }
    
    private void setStats()
    {
        if(easy == true)
        {
            evade = 0;
            crit = 0;
            def = 0;
            health = 70;
            attack = 2;
        }
        else if(med == true)
        {
            evade = 0;
            crit = 33;
            def = 5;
            health = 80;
            attack = 3;
        }
        
        else if(hard == true)
        {
            evade = 0;
            crit = 33;
            def = 5;
            health = 95;
            attack = 3;
        }    
        }
    
    public void getDrops() throws InterruptedException
    {
        int gold = 1 + (int)(Math.random() * 6);
        Main.LootScreen.setGold(gold);
        int exp = 30 + (int)(Math.random() * 31);
        int threshold = 1 + (int)(Math.random() * 100);
        for(int i = 0;i<4;i++)
        if(threshold <= 50)
        {
            Weapon.RuneTrident.lootWeapon();
        }
        threshold = 1 + (int)(Math.random() * 100);
         if(threshold <= 8)
        {
            Weapon.HumanityBane.lootWeapon();
        }
         threshold = 1 + (int)(Math.random() * 100);
         if(threshold <= 35)
        {
           Item.PowerPotion.lootItem();
        }
        threshold = 1 + (int)(Math.random() * 100);
        if(threshold <= 50)
        {
           Item.HighPotion.lootItem();
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


