package Monsters;
public class CaveSpider extends MonsterManager
{
	 public static boolean easy = false;
	    public static boolean med = false;
	    public static boolean hard = false;
	    
	    private int[] striggerRate = {0,15,16,35,36,50};
	    private String[] satkMsg = {"Cave Spider shoots webs at your mouth","Cave Spider shoots webs at your hands","The Cave Spider bites you!"};
	    private int[] sdmg = {0,0,0};
	    private boolean[] suseTurn = {false,false,true};
	    private int[] suseCounter = {2,0,2,0,1,0};
	    private String[] ssound = {"AcidSpray.wav","AcidSpray.wav","Attack3.wav"};
	    private int[] sstatusEffect = {100,1,65,0,1,101,1,16,0,1,102,1,63,4,33};
	    private String[] movess = {"Can inflict various status ailments.","Can inflict Poison."};
		private String descs = "A common creature found in underground caves. A small group of cave spiders can colonize an entire cave system in a couple of days if left unchecked. These spiders seem to have fresh blood stains on their bodies.";
    public CaveSpider() {
    	super("Slams into", "Pounces on","Slashes");
    	setStats();
    	     name = "Cave Spider";
    	   smart = false;
    	    triggerRate = striggerRate;
    	     atkMsg = satkMsg;
    	     dmg = sdmg;
    	    useTurn = suseTurn;
    	     sound = ssound;
    	     useCounter = suseCounter;
    	    statusEffect = sstatusEffect;
    	    song = "RowdyRumble.wav";
    	    total = 3;
    		fireR = -20;
    	    pic = "CaveSpider.png";
    	    maxHealth = health;
    	    id=6;
    	    moves = movess;
    	    desc = descs;
    }
    
    private void setStats()
    {
        if(easy == true)
        {
            evade = 25;
            crit = 20;
            def = 5;
            health = 130;
            attack = 8;
        }
        else if(med == true)
        {
            evade = 25;
            crit = 15;
            def = 5;
            health = 130;
            attack = 8;
        }
        
        else if(hard == true)
        {
            evade = 25;
            crit = 15;
            def = 5;
            health = 140;
            attack = 9;
        }    
        }
    
    
    public void getDrops() throws InterruptedException
    {
        int gold = 50 + (int)(Math.random() * 35);
        Main.LootScreen.setGold(gold);
        int exp = 30 + (int)(Math.random() * 10);
        int threshold = (int)(Math.random() * 101);
        if(threshold < 25)
            Main.LootScreen.setLootMisc("Venom Sack",1);
        threshold = (int)(Math.random() * 101);
        int amt = (int)(Math.random() * 3) + 1;
        if(threshold < 50)
            Main.LootScreen.setLootMisc("String",amt);
         Main.LootScreen.setExp(exp);
         Main.LootScreen.open();
    }
   }


