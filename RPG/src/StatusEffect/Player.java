package StatusEffect;
import java.awt.Color;

import Main.Story;
import Run.*;
public class Player
{
    public static int damage;
    private static int fireDuration;
    public static boolean burnActive;
    public static int fireDmg;
    public static int burnRound;
    private static int iceDuration;
    public static boolean iceActive;
    public static int iceDmg;
    public static int iceRound;
    private static int shockDuration;
    public static boolean shockActive;
    public static int shockDmg;
    public static int shockRound;
    private static int poisonDuration;
    public static boolean poisonActive;
    private static int poisonDmg;
    public static int poisonTotal = 0;
    public static int silenceRound;
    public static boolean silenceActive;
    public static int silenceDuration;
    public static int disableRound;
    public static boolean disableActive;
    public static int disableDuration;
    public static int stunDuration;
    public static int stunRound;
    public static boolean stunActive;
    public static int fortifyDuration;
    public static int fortifyRound;
    public static boolean fortifyActive; 
    public static int fortifyAmount;
    public static int fragileDuration;
    public static int fragileRound;
    public static boolean fragileActive; 
    public static int fragileAmount;
    public static boolean strengthActive;
    public static int strengthDuration;
    public static int strengthRound;
    public static int strengthAmount;
    public static boolean weakActive;
    public static int weakDuration;
    public static int weakRound;
    public static int weakAmount; 
    public static boolean healActive;
    public static int healAmount;
    public static int healDuration;
    public static int healRound;
    public static boolean weaponActive = false;
    public static boolean armorActive = false;
    public static int transformDuration;
    public static int transformRound;
    public static boolean transformActive;
    public static int pDef;
    public static String pDefName;
    public static String pDefDesc;
    public static int pMaxHealth;
    private static int iceRDuration;
    public static boolean iceRActive;
    public static int iceRDmg;
    public static int iceRRound;
    private static int fireRDuration;
    public static boolean fireRActive;
    public static int fireRDmg;
    public static int fireRRound;
    private static int shockRDuration;
    public static boolean shockRActive;
    public static int shockRDmg;
    public static int shockRRound;
    
    
    private static int iceWDuration;
    public static boolean iceWActive;
    public static int iceWDmg;
    public static int iceWRound;
    private static int fireWDuration;
    public static boolean fireWActive;
    public static int fireWDmg;
    public static int fireWRound;
    private static int shockWDuration;
    public static boolean shockWActive;
    public static int shockWDmg;
    public static int shockWRound;
    

    private static final Color PUKE_GREEN = new Color(37,148,33);
    private static final Color FIRE_RED = new Color(255,0,0);
    private static final Color LIGHT_BLUE = new Color(0,166,255);
    public static void startBurn(int d,int dmg)
    {
       MainFightPanel.append(MainFightPanel.user,"\n\nYou have been ");
       MainFightPanel.append(MainFightPanel.user,"Burned",FIRE_RED,20,true);
       MainFightPanel.append(MainFightPanel.user,"!\n");
        Story.pause(1500);
        if(dmg > fireDmg) {
        fireDuration = d;
        fireDmg = dmg;
        burnRound = Run.RPGRunner.round;
        burnActive = true;
        }
    }
    public static void startBurnResist(int d,int dmg)
    {
    	 MainFightPanel.append(MainFightPanel.user,"\n\nFire",FIRE_RED,20,true);
         MainFightPanel.append(MainFightPanel.user," resistance increased");
         MainFightPanel.append(MainFightPanel.user,"!\n");
        Story.pause(1500);
        Main.Player.baseFireR += dmg;
        
        fireRDuration = d;
        fireRDmg += dmg;
        fireRRound = Run.RPGRunner.round;
        fireRActive = true;
        
    }
    public static void startIceResist(int d,int dmg)
    {  
       MainFightPanel.append(MainFightPanel.user,"\n\nIce",LIGHT_BLUE,20,true);
       MainFightPanel.append(MainFightPanel.user," resistance increased");
       MainFightPanel.append(MainFightPanel.user,"!\n");
       Main.Player.baseIceR += dmg;
        Story.pause(1500);
        
        iceRDuration = d;
        iceRDmg += dmg;
        iceRRound = Run.RPGRunner.round;
        iceRActive = true;
        
    }
    public static void startIce(int d,int dmg)
    {  
       MainFightPanel.append(MainFightPanel.user,"\n\nYou have been ");
       MainFightPanel.append(MainFightPanel.user,"Iced",LIGHT_BLUE,20,true);
       MainFightPanel.append(MainFightPanel.user,"!\n");
        Story.pause(1500);
        if(dmg > iceDmg) {
        iceDuration = d;
        iceDmg = dmg;
        iceRound = Run.RPGRunner.round;
        iceActive = true;
        }
    }
    public static void startShock(int d,int dmg)
    {
       MainFightPanel.append(MainFightPanel.user,"\n\nYou have been ");
       MainFightPanel.append(MainFightPanel.user,"Zapped",Color.YELLOW,20,true);
       MainFightPanel.append(MainFightPanel.user,"!\n");
      
        Story.pause(1500);
        if(dmg > shockDmg) {
        shockDuration = d;
        shockDmg = dmg;
        shockRound = Run.RPGRunner.round;
        shockActive = true;
        }
    }
    public static void startShockResist(int d,int dmg)
    {
    	 MainFightPanel.append(MainFightPanel.user,"\n\nShock",Color.YELLOW,20,true);
         MainFightPanel.append(MainFightPanel.user," resistance increased");
         MainFightPanel.append(MainFightPanel.user,"!\n");
         Main.Player.baseShockR += dmg;
        Story.pause(1500);
        
        shockRDuration = d;
        shockRDmg += dmg;
        shockRRound = Run.RPGRunner.round;
        shockRActive = true;
        
    }
    
    public static void startShockWeak(int d,int dmg)
    {
    	 MainFightPanel.append(MainFightPanel.user,"\n\nShock",Color.YELLOW,20,true);
         MainFightPanel.append(MainFightPanel.user," resistance decreased");
         MainFightPanel.append(MainFightPanel.user,"!\n");
         Main.Player.baseShockR -= dmg;
        Story.pause(1500);
        
        shockWDuration = d;
        shockWDmg -= dmg;
        shockWRound = Run.RPGRunner.round;
        shockWActive = true;
        
    }
    
    public static void startBurnWeak(int d,int dmg)
    {
    	 MainFightPanel.append(MainFightPanel.user,"\n\nFire",FIRE_RED,20,true);
         MainFightPanel.append(MainFightPanel.user," resistance decreased");
         MainFightPanel.append(MainFightPanel.user,"!\n");
        Story.pause(1500);
        Main.Player.baseFireR -= dmg;
        
        fireWDuration = d;
        fireWDmg -= dmg;
        fireWRound = Run.RPGRunner.round;
        fireWActive = true;
        
    }
    public static void startIceWeak(int d,int dmg)
    {  
       MainFightPanel.append(MainFightPanel.user,"\n\nIce",LIGHT_BLUE,20,true);
       MainFightPanel.append(MainFightPanel.user," resistance decreased");
       MainFightPanel.append(MainFightPanel.user,"!\n");
       Main.Player.baseIceR -= dmg;
        Story.pause(1500);
        
        iceWDuration = d;
        iceWDmg -= dmg;
        iceWRound = Run.RPGRunner.round;
        iceWActive = true;
        
    }
    
    public static void startPoison(int d,int dmg)
    {
       MainFightPanel.append(MainFightPanel.user,"\n\nYou have been ");
       MainFightPanel.append(MainFightPanel.user,"Poisoned",PUKE_GREEN,20,true);
       MainFightPanel.append(MainFightPanel.user,"!\n");
        Story.pause(1500);
        if(dmg > poisonDmg) {
        poisonDuration = d;
        poisonDmg = dmg;
        poisonActive = true;
        }
    }
    public static void startSilence(int d,int dmg)
    {;
       MainFightPanel.append(MainFightPanel.user,"\n\nYou have been ");
       MainFightPanel.append(MainFightPanel.user,"Silenced",Color.BLUE,20,true);
       MainFightPanel.append(MainFightPanel.user,"!\n");
        Story.pause(1500);
        if(d > silenceDuration) {
        silenceDuration = d;
        silenceRound = Run.RPGRunner.round;
        silenceActive = true;
        }
    }
        public static void startDisable(int d,int dmg)
    {
       MainFightPanel.append(MainFightPanel.user,"\n\nYou have been ");
       MainFightPanel.append(MainFightPanel.user,"Disabled",Color.MAGENTA,20,true);
       MainFightPanel.append(MainFightPanel.user,"!\n");
        Story.pause(1500);
        if(d > disableDuration) {
        disableDuration = d;
        disableRound = Run.RPGRunner.round;
        disableActive = true;
    }
    }
    public static void startStun(int d,int dmg)
    {
       MainFightPanel.append(MainFightPanel.user,"\n\nYou have been ");
       MainFightPanel.append(MainFightPanel.user,"Stunned",Color.ORANGE,20,true);
       MainFightPanel.append(MainFightPanel.user,"!\n");
        pause(1500);
        if(d > stunDuration) {
        stunDuration = d;
        stunRound = Run.RPGRunner.round;
        stunActive = true;
        }
    }
    public static void startFortify(int d, int dmg)
    {
    	
       MainFightPanel.append(MainFightPanel.user,"\n\nDefense boost!!!");
        Story.pause(1500);
        fortifyDuration = d;
        fortifyRound = Run.RPGRunner.round;
        fortifyAmount += dmg;
        fortifyActive = true;
        Main.Player.baseDef = Main.Player.baseDef + dmg;
        armorActive = true;
    
    }
    public static void startFragility(int d, int dmg)
    {
    	
       MainFightPanel.append(MainFightPanel.user,"\n\nYour defense has been lowered");
        Story.pause(1500);
        fragileDuration = d;
        fragileRound = Run.RPGRunner.round;
        fragileAmount -= dmg;
        fragileActive = true;
        Main.Player.baseDef = Main.Player.baseDef - dmg;

    
    }
    public static void doMultiHit(int t, int dmg) throws InterruptedException
    {
    	MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\nThe " + Monsters.MonsterManager.enemies.get(RPGRunner.monsterTurn).getName() + " attacked you ");
    	MainFightPanel.append(MainFightPanel.enemyStatOutput,t+"",Color.RED,20,true);
    	MainFightPanel.append(MainFightPanel.enemyStatOutput," times!\n");
        pause(1300);
        int countHits  = 0;
        for(int i = 0;i<t;i++)
        {
        	if(countHits == 3) {
            	MainFightPanel.clearEnemyDisplay();
            	MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\nThe " + Monsters.MonsterManager.enemies.get(RPGRunner.monsterTurn).getName() + " attacked you ");
            	MainFightPanel.append(MainFightPanel.enemyStatOutput,t+"",Color.RED,20,true);
            	MainFightPanel.append(MainFightPanel.enemyStatOutput," times!\n");
            	countHits = 0;
            }
            
            int hitD = ((dmg / 2) + (int)(Math.random() * ((dmg / 2) +1)));
            Main.Player.health = Main.Player.health - hitD; 
            MainFightPanel.clearDisplay();
            MainFightPanel.append(MainFightPanel.enemyStatOutput,"The " + Monsters.MonsterManager.enemies.get(RPGRunner.monsterTurn).getName() + " dealt ");
        	MainFightPanel.append(MainFightPanel.enemyStatOutput,hitD+"",Color.RED,20,true);
        	MainFightPanel.append(MainFightPanel.enemyStatOutput," damage!\n");
            Playlist.playEffect("/sounds/MultiHit.wav");
            countHits++;
            pause(700);
        }
        pause(1500);
        MainFightPanel.clearEnemyDisplay();
    }
    public static void startStrength(int d, int dmg)
    {
    	
    	MainFightPanel.append(MainFightPanel.user,"\n\nYou grow ");
         MainFightPanel.append(MainFightPanel.user,"stronger",Color.RED,22,true);
         MainFightPanel.append(MainFightPanel.user,"!\n");
        Story.pause(1500);
        Main.Player.baseDmg = Main.Player.baseDmg + dmg;
        weaponActive = true;
        strengthDuration = d;
        strengthRound = Run.RPGRunner.round;
        strengthAmount += dmg;
        strengthActive = true;
    	
        
    }
    public static void startWeak(int d, int dmg)
    {
    	
    	MainFightPanel.append(MainFightPanel.user,"\n\nYou have become");
         MainFightPanel.append(MainFightPanel.user," weaker",Color.LIGHT_GRAY,22,true);
         MainFightPanel.append(MainFightPanel.user,"!\n");
        Story.pause(1500);
        Main.Player.baseDmg = Main.Player.baseDmg - dmg;
        weaponActive = true;
        weakDuration = d;
        weakRound = Run.RPGRunner.round;
        weakAmount -= dmg;
        weakActive = true;
    	
        
    }
    
         public static void startHeal(int d,int dmg)
    {
        	 MainFightPanel.append(MainFightPanel.user,"\n\nYou're body has begun to ");
             MainFightPanel.append(MainFightPanel.user,"heal",Color.GREEN,20,true);
             MainFightPanel.append(MainFightPanel.user,"!\n");
        Story.pause(1500);
        
        healDuration = d;
        healAmount += dmg;
        healRound = Run.RPGRunner.round;
        healActive = true;
        
    }
    public static void doSacrifice(int d, int dmg)
    {
    	MainFightPanel.append(MainFightPanel.user,"\n\nYou lost "); 
         MainFightPanel.append(MainFightPanel.user,dmg+"",Color.RED,20,true);
         MainFightPanel.append(MainFightPanel.user," HP!\n");
           Story.pause(1500);
           Main.Player.health = Main.Player.health - dmg;
     }
    
    public static void startTransform(int d,int dmg)
    {
    	pMaxHealth = Main.Player.maxHealth;
		pDef = Main.Player.armor[Main.Player.equippedArmor].def;
		pDefDesc = Main.Player.armor[Main.Player.equippedArmor].desc;
		pDefName = Main.Player.armor[Main.Player.equippedArmor].name;
		
		double maxHealth = Main.Player.maxHealth * 1.0;
			double percentHealth = (Main.Player.health / maxHealth);
			System.out.println("\n\n\n" + percentHealth);
		Main.Player.health = (int)(percentHealth * Monsters.MonsterManager.enemies.get(RPGRunner.monsterTurn).getMaxHealth());
		System.out.println(Main.Player.health);
		Main.Player.maxHealth = Monsters.MonsterManager.enemies.get(RPGRunner.monsterTurn).getMaxHealth();
		Main.Player.armor[Main.Player.equippedArmor].def = Monsters.MonsterManager.enemies.get(RPGRunner.monsterTurn).getDef();
		Main.Player.armor[Main.Player.equippedArmor].desc = "The same stuff that " + Monsters.MonsterManager.enemies.get(RPGRunner.monsterTurn).getName() + " uses.";
		Main.Player.armor[Main.Player.equippedArmor].name = Monsters.MonsterManager.enemies.get(RPGRunner.monsterTurn).getName() + "'s Armor";
		if(Main.Player.health > Main.Player.maxHealth)
			Main.Player.health = Main.Player.maxHealth;
		MainFightPanel.append(MainFightPanel.user,"\n\nThis feels like puberty all over again. Only 1000x faster!\n");
        pause(3000);
        MainFightPanel.clearDisplay();
        transformDuration = d;
        transformRound = Run.RPGRunner.round;
        transformActive = true;
    }
    
  
    
    public static void getEffects(int r)
    {
        if(strengthActive == true)
        {
            if(!(r <= strengthRound + strengthDuration))
            {
            	Main.Player.baseDmg -=strengthAmount;               
            	MainFightPanel.append(MainFightPanel.user,"\n\nYour extra strength has left you.");
             pause(2500);
             MainFightPanel.clearDisplay();
             weaponActive = false;
             strengthActive = false;
             strengthAmount = 0;
            }
        }
        if(weakActive == true)
        {
            if(!(r <= weakRound + weakDuration))
            {
            	Main.Player.baseDmg -=weakAmount;               
            	MainFightPanel.append(MainFightPanel.user,"\n\nYour weakness has worn off.");
             pause(2500);
             MainFightPanel.clearDisplay();
             weakActive = false;
             weakAmount = 0;
            }
        }
        if(strengthActive == false && weaponActive == true)
        {
        	Main.Player.baseDmg -=strengthAmount;
            MainFightPanel.append(MainFightPanel.user,"\n\nYour extra strength has left you.");
             pause(2500);
             MainFightPanel.clearDisplay();
             weaponActive = false;
             strengthAmount = 0;
             strengthActive = false;
        }
        
        
        if(fortifyActive == true)
        {
            if(!(r <= fortifyRound + fortifyDuration))
            {
            	Main.Player.baseDef -= fortifyAmount;
             MainFightPanel.append(MainFightPanel.user,"\n\nYour extra defense has worn off!");
             pause(2500);
             MainFightPanel.clearDisplay();
             armorActive = false;
             fortifyActive = false;
             fortifyAmount = 0;
            }
        }
        
        if(fragileActive == true)
        {
            if(!(r <= fragileRound + fragileDuration))
            {
            	Main.Player.baseDef -= fragileAmount;
             MainFightPanel.append(MainFightPanel.user,"\n\nYour fragility has worn off!");
             pause(2500);
             MainFightPanel.clearDisplay();
             fragileActive = false;
             fragileAmount = 0;
            }
        }
        if(fireRActive == true)
        {
            if(!(r <= fireRRound + fireRDuration))
            {
            	Main.Player.baseFireR -= fireRDmg;
             MainFightPanel.append(MainFightPanel.user,"\n\nYour extra fire resistance has worn off!");
             pause(2500);
             MainFightPanel.clearDisplay();
             fireRActive = false;
             fireRDmg = 0;
            }
        }
        if(iceRActive == true)
        {
            if(!(r <= iceRRound + iceRDuration))
            {
            	Main.Player.baseIceR -= iceRDmg;
             MainFightPanel.append(MainFightPanel.user,"\n\nYour extra ice resistance has worn off!");
             pause(2500);
             MainFightPanel.clearDisplay();
             iceRActive = false;
             iceRDmg = 0;
            }
        }
        if(shockRActive == true)
        {
            if(!(r <= shockRRound + shockRDuration))
            {
            	Main.Player.baseShockR -= shockRDmg;
             MainFightPanel.append(MainFightPanel.user,"\n\nYour extra shock resistance has worn off!");
             pause(2500);
             MainFightPanel.clearDisplay();
             shockRActive = false;
             shockRDmg = 0;
            }
        }
        if(fireWActive == true)
        {
            if(!(r <= fireWRound + fireWDuration))
            {
            	Main.Player.baseFireR -= fireWDmg;
             MainFightPanel.append(MainFightPanel.user,"\n\nYour weakness to fire has worn off!");
             pause(2500);
             MainFightPanel.clearDisplay();
             fireWActive = false;
             fireWDmg = 0;
            }
        }
        if(iceWActive == true)
        {
            if(!(r <= iceWRound + iceWDuration))
            {
            	Main.Player.baseIceR -= iceWDmg;
             MainFightPanel.append(MainFightPanel.user,"\n\nYour weakness to ice has worn off!");
             pause(2500);
             MainFightPanel.clearDisplay();
             iceWActive = false;
             iceWDmg = 0;
            }
        }
        if(shockWActive == true)
        {
            if(!(r <= shockWRound + shockWDuration))
            {
            	Main.Player.baseShockR -= shockWDmg;
             MainFightPanel.append(MainFightPanel.user,"\n\nYour weakness to electricity has worn off!");
             pause(2500);
             MainFightPanel.clearDisplay();
             shockWActive = false;
             shockWDmg = 0;
            }
        }
        if(fortifyActive == false && armorActive == true)
        {
        	Main.Player.baseDef -= fortifyAmount;
             MainFightPanel.append(MainFightPanel.user,"\n\nYou extra defense has worn off!");
             pause(2500);
             MainFightPanel.clearDisplay();
             armorActive = false;
             fortifyActive = false;
             fortifyAmount = 0;
        }
        if(burnActive == true)
        {
            if(r <= burnRound + fireDuration)
            {
                 MainFightPanel.append(MainFightPanel.user,"\n\nYou are on ");
                 MainFightPanel.append(MainFightPanel.user,"fire",FIRE_RED,20,true);
                 MainFightPanel.append(MainFightPanel.user,"!\n");
                 pause(1000);
                if(Main.Player.getFireR() == 0)
                 {
                	 MainFightPanel.append(MainFightPanel.user,"You took ");
                     MainFightPanel.append(MainFightPanel.user,fireDmg+"",Color.RED,20,true);
                     MainFightPanel.append(MainFightPanel.user," fire ",FIRE_RED,20,true);
                     MainFightPanel.append(MainFightPanel.user,"damage\n");
                	 Main.Player.health = Main.Player.health - fireDmg;
                 }
                else if(Main.Player.getFireR() > 0 && Main.Player.getFireR() < 101)
                 {
                	if(Main.Player.getFireR() < 100)
                	  MainFightPanel.append(MainFightPanel.user,"RESIST!\n");
                	else
                		MainFightPanel.append(MainFightPanel.user,"IMMUNE!\n");
                	 pause(1000);
                	 double total = (fireDmg * (double)(Main.Player.getFireR() / 100.0));
                	 int burnDmg = fireDmg - (int)total;
                	 MainFightPanel.append(MainFightPanel.user,"You took ");
                     MainFightPanel.append(MainFightPanel.user,burnDmg+"",Color.RED,20,true);
                     MainFightPanel.append(MainFightPanel.user," fire ",FIRE_RED,20,true);
                     MainFightPanel.append(MainFightPanel.user,"damage\n");
                 	Main.Player.health = Main.Player.health - burnDmg;
                 }
                else if(Main.Player.getFireR() > 100)
                {
                	  MainFightPanel.append(MainFightPanel.user,"ABSORB!\n");
                	 pause(1000);
                	 double total = (fireDmg * (double)((Main.Player.getFireR()-100) / 100.0));
                	 int burnDmg = (int)total;
                	 MainFightPanel.append(MainFightPanel.user,"You absorbed the ");
                	 MainFightPanel.append(MainFightPanel.user," fire",FIRE_RED,20,true);
                	 MainFightPanel.append(MainFightPanel.user," and gained: ");
                     MainFightPanel.append(MainFightPanel.user,burnDmg+"",Color.GREEN,20,true);
                     MainFightPanel.append(MainFightPanel.user," HP.\n");
                 	Main.Player.health = Main.Player.health + burnDmg;
                 	if(Main.Player.health > Main.Player.maxHealth)
                 		Main.Player.health = Main.Player.maxHealth;
                }
                else
                {
                	MainFightPanel.append(MainFightPanel.user,"WEAKNESS!\n");
                	pause(1000);
                	double total = (fireDmg * (double)((Main.Player.getFireR() * -1) / 100.0));
                	int burnDmg = (int)total + fireDmg;
                	 MainFightPanel.append(MainFightPanel.user,"You are weak to ");
                     MainFightPanel.append(MainFightPanel.user,"fire",FIRE_RED,20,true);
                     MainFightPanel.append(MainFightPanel.user," and took ");
                     MainFightPanel.append(MainFightPanel.user,"%"+(Main.Player.getFireR() * -1),Color.WHITE,20,true);
                     MainFightPanel.append(MainFightPanel.user," extra ");
                     MainFightPanel.append(MainFightPanel.user,"fire",FIRE_RED,20,true);
                     MainFightPanel.append(MainFightPanel.user," damage\n");
                	pause(2000);
                	MainFightPanel.append(MainFightPanel.user,"You lost ");
                    MainFightPanel.append(MainFightPanel.user,burnDmg+"",Color.RED,20,true);
                    MainFightPanel.append(MainFightPanel.user," HP.\n");
            	Main.Player.health = Main.Player.health - burnDmg;
                 
                }
                pause(2000);
                MainFightPanel.clearDisplay();
            }
            else {
            burnActive = false;
            fireDmg = 0;
            }
        }
        if(iceActive == true)
        {
            if(r <= iceRound + iceDuration)
            {
            	MainFightPanel.append(MainFightPanel.user,"\n\nYou are ");
                MainFightPanel.append(MainFightPanel.user,"freezing",LIGHT_BLUE,20,true);
                MainFightPanel.append(MainFightPanel.user,"!\n");
                 pause(1000);
                if(Main.Player.getIceR() == 0)
                 {
                	 MainFightPanel.append(MainFightPanel.user,"You took ");
                     MainFightPanel.append(MainFightPanel.user,iceDmg+"",Color.RED,20,true);
                     MainFightPanel.append(MainFightPanel.user," frost ",LIGHT_BLUE,20,true);
                     MainFightPanel.append(MainFightPanel.user,"damage\n");
                	 Main.Player.health = Main.Player.health - iceDmg;
                 }
                else if(Main.Player.getIceR() > 0 && Main.Player.getIceR() < 101)
                 {
                	if(Main.Player.getIceR() < 100)
                	  MainFightPanel.append(MainFightPanel.user,"RESIST!\n");
                	else
                		MainFightPanel.append(MainFightPanel.user,"IMMUNE!\n");
                	 pause(1000);
                	 double total = (iceDmg * (double)(Main.Player.getIceR() / 100.0));
                	 int frostDmg = iceDmg - (int)total;
                	 MainFightPanel.append(MainFightPanel.user,"You took ");
                     MainFightPanel.append(MainFightPanel.user,frostDmg+"",Color.RED,20,true);
                     MainFightPanel.append(MainFightPanel.user," frost ",LIGHT_BLUE,20,true);
                     MainFightPanel.append(MainFightPanel.user,"damage\n");
                 	Main.Player.health = Main.Player.health - frostDmg;
                 }
                else if(Main.Player.getIceR() > 100)
                {
                	  MainFightPanel.append(MainFightPanel.user,"ABSORB!\n");
                	 pause(1000);
                	 double total = (iceDmg * (double)((Main.Player.getIceR()-100) / 100.0));
                	 int frostDmg = (int)total;
                	 MainFightPanel.append(MainFightPanel.user,"You absorbed the ");
                	 MainFightPanel.append(MainFightPanel.user," ice",LIGHT_BLUE,20,true);
                	 MainFightPanel.append(MainFightPanel.user," and gained: ");
                     MainFightPanel.append(MainFightPanel.user,frostDmg+"",Color.GREEN,20,true);
                     MainFightPanel.append(MainFightPanel.user," HP.\n");
                 	Main.Player.health = Main.Player.health + frostDmg;
                 	if(Main.Player.health > Main.Player.maxHealth)
                 		Main.Player.health = Main.Player.maxHealth;
                }
                else
                {
                	MainFightPanel.append(MainFightPanel.user,"WEAKNESS!\n");
                	pause(1000);
                	double total = (iceDmg * (double)((Main.Player.getIceR() * -1) / 100.0));
                	int frostDmg = (int)total + iceDmg;
                	MainFightPanel.append(MainFightPanel.user,"You are weak to ");
                    MainFightPanel.append(MainFightPanel.user,"frost",LIGHT_BLUE,20,true);
                    MainFightPanel.append(MainFightPanel.user," and took ");
                    MainFightPanel.append(MainFightPanel.user,"%"+(Main.Player.getIceR() * -1),Color.WHITE,20,true);
                    MainFightPanel.append(MainFightPanel.user," extra ");
                    MainFightPanel.append(MainFightPanel.user,"frost",LIGHT_BLUE,20,true);
                    MainFightPanel.append(MainFightPanel.user," damage\n");
                	pause(2000);
                	MainFightPanel.append(MainFightPanel.user,"You lost ");
                   MainFightPanel.append(MainFightPanel.user,frostDmg+"",Color.RED,20,true);
                   MainFightPanel.append(MainFightPanel.user," HP.\n");
            	Main.Player.health = Main.Player.health - frostDmg;
                 
                }
                pause(2000);
                MainFightPanel.clearDisplay();
            }
            else {
            iceActive = false;
            iceDmg = 0;
            }
        }
        if(shockActive == true)
        {
            if(r <= shockRound + shockDuration)
            {;
                 MainFightPanel.append(MainFightPanel.user,"\n\nYou are ");
                 MainFightPanel.append(MainFightPanel.user,"electrified",Color.YELLOW,20,true);
                 MainFightPanel.append(MainFightPanel.user,"!\n");
                 pause(1000);
                if(Main.Player.getShockR() == 0)
                 {
                	 MainFightPanel.append(MainFightPanel.user,"You took ");
                     MainFightPanel.append(MainFightPanel.user,shockDmg+"",Color.RED,20,true);
                     MainFightPanel.append(MainFightPanel.user," shock ",Color.YELLOW,20,true);
                     MainFightPanel.append(MainFightPanel.user,"damage\n");
                	 Main.Player.health = Main.Player.health - shockDmg;
                 }
                else if(Main.Player.getShockR() > 0 && Main.Player.getShockR() < 101)
                 {
                	if(Main.Player.getShockR() < 100)
                	  MainFightPanel.append(MainFightPanel.user,"RESIST!\n");
                	else
                		MainFightPanel.append(MainFightPanel.user,"IMMUNE!\n");
                	 pause(1000);
                	 double total = (shockDmg * (double)(Main.Player.getShockR() / 100.0));
                	 int frostDmg = shockDmg - (int)total;
                	 MainFightPanel.append(MainFightPanel.user,"You took ");
                     MainFightPanel.append(MainFightPanel.user,frostDmg+"",Color.RED,20,true);
                     MainFightPanel.append(MainFightPanel.user," shock ",Color.YELLOW,20,true);
                     MainFightPanel.append(MainFightPanel.user,"damage\n");
                 	Main.Player.health = Main.Player.health - frostDmg;
                 }
                else if(Main.Player.getShockR() > 100)
                {
                	  MainFightPanel.append(MainFightPanel.user,"ABSORB!\n");
                	 pause(1000);
                	 double total = (shockDmg * (double)((Main.Player.getShockR()-100) / 100.0));
                	 int frostDmg = (int)total;
                	 MainFightPanel.append(MainFightPanel.user,"You absorbed the ");
                	 MainFightPanel.append(MainFightPanel.user," electricity",Color.YELLOW,20,true);
                	 MainFightPanel.append(MainFightPanel.user," and gained: ");
                     MainFightPanel.append(MainFightPanel.user,frostDmg+"",Color.GREEN,20,true);
                     MainFightPanel.append(MainFightPanel.user," HP.\n");
                 	Main.Player.health = Main.Player.health + frostDmg;
                 	if(Main.Player.health > Main.Player.maxHealth)
                 		Main.Player.health = Main.Player.maxHealth;
                }
                else
                {
                	MainFightPanel.append(MainFightPanel.user,"WEAKNESS!\n");
                	pause(1000);
                	double total = (shockDmg * (double)((Main.Player.getShockR() * -1) / 100.0));
                	int frostDmg = (int)total + shockDmg;
                	MainFightPanel.append(MainFightPanel.user,"You are weak to ");
                    MainFightPanel.append(MainFightPanel.user,"electricity",Color.YELLOW,20,true);
                    MainFightPanel.append(MainFightPanel.user," and took ");
                    MainFightPanel.append(MainFightPanel.user,"%"+(Main.Player.getShockR() * -1),Color.WHITE,20,true);
                    MainFightPanel.append(MainFightPanel.user," extra ");
                    MainFightPanel.append(MainFightPanel.user,"shock",Color.YELLOW,20,true);
                    MainFightPanel.append(MainFightPanel.user," damage\n");
                	pause(2000);
                	MainFightPanel.append(MainFightPanel.user,"You lost ");
                   MainFightPanel.append(MainFightPanel.user,frostDmg+"",Color.RED,20,true);
                   MainFightPanel.append(MainFightPanel.user," HP.\n");
            	Main.Player.health = Main.Player.health - frostDmg;
                 
                }
                pause(2000);
                MainFightPanel.clearDisplay();
            }
            else {
            shockActive = false;
            shockDmg = 0;
            }
        }
        if(poisonActive == true)
        {
            if((double)(Main.Player.maxHealth * (poisonDuration / 100.0)) > poisonTotal)
            		{
            			MainFightPanel.append(MainFightPanel.user,"\n\nYou are ");
            			MainFightPanel.append(MainFightPanel.user,"Poisoned",PUKE_GREEN,20,true);
            			MainFightPanel.append(MainFightPanel.user,"!\n");
            			pause(1000);
            			MainFightPanel.append(MainFightPanel.user,"You lost ");
            			MainFightPanel.append(MainFightPanel.user,poisonDmg+"",Color.RED,20,true);
            			MainFightPanel.append(MainFightPanel.user," HP.\n");
                    	Main.Player.health = Main.Player.health - poisonDmg;
                    	poisonTotal = poisonTotal + poisonDmg;
                    	pause(2000);
                        MainFightPanel.clearDisplay();
            		}
            else
            {
            poisonActive = false;
            poisonTotal = 0;
            MainFightPanel.append(MainFightPanel.user,"\n\nYou have recovered from the poison.");
            pause(2200);
            MainFightPanel.clearDisplay();
            }
        }
        if(silenceActive == true)
        {
            if(r <= silenceRound + silenceDuration)
            {
            MainFightPanel.append(MainFightPanel.user,"\n\nYou can't utter a sound!\n");
            pause(2000);
            MainFightPanel.clearDisplay();
           }
           else {
           silenceActive = false;
           silenceDuration = 0;
           }
        }
        if(disableActive == true)
        {
            if(r <= disableRound + disableDuration)
            {
            MainFightPanel.append(MainFightPanel.user,"\n\nYou can't move your limbs!\n");
            pause(2000);
            MainFightPanel.clearDisplay();
           }
           else {
           disableActive = false;
           disableDuration = 0;
           }
        }
        if(stunActive == true)
        {
            if(r <= stunRound + stunDuration)
            {
            int threshold = 1 + (int)(Math.random() * 100);
            if(threshold <= 50)
            {
            MainFightPanel.append(MainFightPanel.user,"\n\nYou are unable to take action!\n");
            RPGRunner.pTurn = false;
            }
            else
            {
                MainFightPanel.append(MainFightPanel.user,"\n\nYou are barely able to take action\n");
            }
            pause(2500);
            MainFightPanel.clearDisplay();
           }
           else {
           stunActive = false;
           stunDuration = 0;
           }
        }
        if(healActive == true)
        {
            if(r <= healRound + healDuration)
            {
                 MainFightPanel.append(MainFightPanel.user,"\n\nYour health is regenerating!\n");
                 pause(2000);
                 MainFightPanel.append(MainFightPanel.user,"You gained ");
                 MainFightPanel.append(MainFightPanel.user,healAmount+"",Color.GREEN,20,true);
                 MainFightPanel.append(MainFightPanel.user," HP.\n");
                 Main.Player.health = Main.Player.health + healAmount;
                 if(Main.Player.health > Main.Player.maxHealth)
                	 	Main.Player.health = Main.Player.maxHealth;
                 pause(2000);
                 MainFightPanel.clearDisplay();
            }
            else {
            	healActive = false;
            	healAmount = 0;
            }
        }
        if(transformActive == true)
        {

            if(r > transformRound + transformDuration)
            {
            	transformActive = false;
            	MainFightPanel.append(MainFightPanel.user,"\n\nPOOF!!! You turn back to normal!\n");
            	pause(2000);
                MainFightPanel.clearDisplay();
                double maxHealth = Main.Player.maxHealth * 1.0;
    			double percentHealth = (Main.Player.health / maxHealth);
                   
        		Main.Player.health = (int)(percentHealth * pMaxHealth);
                Main.Player.maxHealth = pMaxHealth;
                Main.Player.armor[Main.Player.equippedArmor].def = pDef;
                Main.Player.armor[Main.Player.equippedArmor].desc = pDefDesc;
                Main.Player.armor[Main.Player.equippedArmor].name = pDefName;
        		if(Main.Player.health > Main.Player.maxHealth)
        			Main.Player.health = Main.Player.maxHealth;
            }
        }
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
