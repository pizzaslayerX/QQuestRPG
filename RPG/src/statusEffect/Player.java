package statusEffect;
import java.awt.Color;

import backend.*;
import gameplay.Story;
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
    
    private static int swiftDuration;
    public static boolean swiftActive;
    public static int swiftAmount;
    public static int swiftRound;
    
    private static int slowDuration;
    public static boolean slowActive;
    public static int slowAmount;
    public static int slowRound;
    
    private static  int frozenDuration;
    public  static boolean frozenActive;
    public  static int frozenAmount;
    public static int frozenRound;

    private static  int bleedDuration;
    public  static boolean bleedActive;
    public  static int bleedAmount;
    public static int bleedRound;
    
    private static  int curseDuration;
    public  static boolean curseActive;
    public  static int curseAmount;
    public static int curseRound;
    
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
        burnRound = backend.RPGRunner.round;
        burnActive = true;
        }
    }
    public static void startBurnResist(int d,int dmg)
    {
    	 MainFightPanel.append(MainFightPanel.user,"\n\nFire",FIRE_RED,20,true);
         MainFightPanel.append(MainFightPanel.user," resistance increased");
         MainFightPanel.append(MainFightPanel.user,"!\n");
        Story.pause(1500);
        gameplay.Player.baseFireR += dmg;
        
        fireRDuration = d;
        fireRDmg += dmg;
        fireRRound = backend.RPGRunner.round;
        fireRActive = true;
        
    }
    public static void startIceResist(int d,int dmg)
    {  
       MainFightPanel.append(MainFightPanel.user,"\n\nIce",LIGHT_BLUE,20,true);
       MainFightPanel.append(MainFightPanel.user," resistance increased");
       MainFightPanel.append(MainFightPanel.user,"!\n");
       gameplay.Player.baseIceR += dmg;
        Story.pause(1500);
        
        iceRDuration = d;
        iceRDmg += dmg;
        iceRRound = backend.RPGRunner.round;
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
        iceRound = backend.RPGRunner.round;
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
        shockRound = backend.RPGRunner.round;
        shockActive = true;
        }
    }
    public static void startShockResist(int d,int dmg)
    {
    	 MainFightPanel.append(MainFightPanel.user,"\n\nShock",Color.YELLOW,20,true);
         MainFightPanel.append(MainFightPanel.user," resistance increased");
         MainFightPanel.append(MainFightPanel.user,"!\n");
         gameplay.Player.baseShockR += dmg;
        Story.pause(1500);
        
        shockRDuration = d;
        shockRDmg += dmg;
        shockRRound = backend.RPGRunner.round;
        shockRActive = true;
        
    }
    
    public static void startShockWeak(int d,int dmg)
    {
    	 MainFightPanel.append(MainFightPanel.user,"\n\nShock",Color.YELLOW,20,true);
         MainFightPanel.append(MainFightPanel.user," resistance decreased");
         MainFightPanel.append(MainFightPanel.user,"!\n");
         gameplay.Player.baseShockR -= dmg;
        Story.pause(1500);
        
        shockWDuration = d;
        shockWDmg -= dmg;
        shockWRound = backend.RPGRunner.round;
        shockWActive = true;
        
    }
    
    public static void startBurnWeak(int d,int dmg)
    {
    	 MainFightPanel.append(MainFightPanel.user,"\n\nFire",FIRE_RED,20,true);
         MainFightPanel.append(MainFightPanel.user," resistance decreased");
         MainFightPanel.append(MainFightPanel.user,"!\n");
        Story.pause(1500);
        gameplay.Player.baseFireR -= dmg;
        
        fireWDuration = d;
        fireWDmg -= dmg;
        fireWRound = backend.RPGRunner.round;
        fireWActive = true;
        
    }
    public static void startIceWeak(int d,int dmg)
    {  
       MainFightPanel.append(MainFightPanel.user,"\n\nIce",LIGHT_BLUE,20,true);
       MainFightPanel.append(MainFightPanel.user," resistance decreased");
       MainFightPanel.append(MainFightPanel.user,"!\n");
       gameplay.Player.baseIceR -= dmg;
        Story.pause(1500);
        
        iceWDuration = d;
        iceWDmg -= dmg;
        iceWRound = backend.RPGRunner.round;
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
    {
       MainFightPanel.append(MainFightPanel.user,"\n\nYou have been ");
       MainFightPanel.append(MainFightPanel.user,"Silenced",Color.BLUE,20,true);
       MainFightPanel.append(MainFightPanel.user,"!\n");
        Story.pause(1500);
        if(d > silenceDuration) {
        silenceDuration = d;
        silenceRound = backend.RPGRunner.round;
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
        disableRound = backend.RPGRunner.round;
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
        stunRound = backend.RPGRunner.round;
        stunActive = true;
        }
    }
    public static void startFortify(int d, int dmg)
    {
    	
       MainFightPanel.append(MainFightPanel.user,"\n\nDefense boost!!!");
        Story.pause(1500);
        
        fortifyDuration = d;
        fortifyRound = backend.RPGRunner.round;
        fortifyAmount += dmg;
        fortifyActive = true;
        gameplay.Player.baseDef = gameplay.Player.baseDef + dmg;
        armorActive = true;
    
    }
    public static void startFragility(int d, int dmg)
    {
    	
        MainFightPanel.append(MainFightPanel.user,"\n\nYour defense has been lowered");
        Story.pause(1500);
        if(dmg > 100) {
        	dmg = (int)(gameplay.Player.baseDef * (double)(dmg/100.0));
        }
        gameplay.Player.baseDef = gameplay.Player.baseDef - dmg;

        fragileDuration = d;
        fragileRound = backend.RPGRunner.round;
        fragileAmount -= dmg;
        fragileActive = true;
       
    
    }
    public static void startSwiftness(int d, int dmg)
    {
    	
       MainFightPanel.append(MainFightPanel.user,"\n\nSpeed Boost! Gotta go fast!");
        Story.pause(1200);
        swiftDuration = d;
        swiftRound = backend.RPGRunner.round;
        swiftAmount += dmg;
        swiftActive = true;
        gameplay.Player.evadeChance += dmg;
    }
    public static void startBleed(int d, int dmg)
    {
    	
       MainFightPanel.append(MainFightPanel.user,"\n\nYou are ");
       MainFightPanel.append(MainFightPanel.user,"bleeding",new Color(216,95,95),20,true);
       MainFightPanel.append(MainFightPanel.user,"!");
        Story.pause(1200);
        bleedDuration += d;
        bleedRound = backend.RPGRunner.round;
        bleedAmount += (int)(((double)(dmg/100.0) * gameplay.Player.maxHealth)/d);
        bleedActive = true;  
    }
    public static void startCurse(int d, int dmg)
    {
    	
       MainFightPanel.append(MainFightPanel.user,"\n\nYou have been afflicted with a ");
       MainFightPanel.append(MainFightPanel.user,"curse",new Color(184,95,216),20,true);
       MainFightPanel.append(MainFightPanel.user,"!");
        Story.pause(1200);
        
        if(dmg > curseAmount) {
        	curseDuration = d;
        	curseRound = backend.RPGRunner.round;
        	curseAmount = dmg;
        	curseActive = true;  
        }
    }
    
    public static void startSlow(int d, int dmg)
    {
    	
       MainFightPanel.append(MainFightPanel.user,"\n\nYou become sluggish.");
        Story.pause(1200);
        slowDuration = d;
        slowRound = backend.RPGRunner.round;
        slowAmount -= dmg;
        slowActive = true;
        gameplay.Player.evadeChance -= dmg;
    }
    public static  void startFrozen(int d,int dmg)
    {
        MainFightPanel.append(MainFightPanel.user,"\n\nYou have been ");
        MainFightPanel.append(MainFightPanel.user,"frozen",LIGHT_BLUE,20,true);
        MainFightPanel.append(MainFightPanel.user,"!\n");
        pause(1500);
        if(d > frozenDuration) {
        frozenDuration = d;
        frozenRound = backend.RPGRunner.round;
        frozenAmount = frozenAmount > dmg ? frozenAmount : dmg;
        frozenActive = true;
        }
    }
    public static void doMultiHit(int t, int dmg) throws InterruptedException
    {
    	MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\nThe " + monsters.MonsterManager.enemies.get(RPGRunner.monsterTurn).getName() + " attacked you ");
    	MainFightPanel.append(MainFightPanel.enemyStatOutput,t+"",Color.RED,20,true);
    	MainFightPanel.append(MainFightPanel.enemyStatOutput," times!\n");
        pause(1300);
        int countHits  = 0;
        for(int i = 0;i<t;i++)
        {
        	if(countHits == 3) {
            	MainFightPanel.clearEnemyDisplay();
            	MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\nThe " + monsters.MonsterManager.enemies.get(RPGRunner.monsterTurn).getName() + " attacked you ");
            	MainFightPanel.append(MainFightPanel.enemyStatOutput,t+"",Color.RED,20,true);
            	MainFightPanel.append(MainFightPanel.enemyStatOutput," times!\n");
            	countHits = 0;
            }
            
            int hitD = ((dmg / 2) + (int)(Math.random() * ((dmg / 2) +1)));
            gameplay.Player.health = gameplay.Player.health - hitD; 
            MainFightPanel.clearDisplay();
            MainFightPanel.append(MainFightPanel.enemyStatOutput,"The " + monsters.MonsterManager.enemies.get(RPGRunner.monsterTurn).getName() + " dealt ");
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
        
        if(dmg > 100) {
        	dmg = (int)(gameplay.Player.baseDmg * (double)(dmg/100.0));
        }
        
        gameplay.Player.baseDmg = gameplay.Player.baseDmg + dmg;
        weaponActive = true;
        strengthDuration = d;
        strengthRound = backend.RPGRunner.round;
        strengthAmount += dmg;
        strengthActive = true;
    	
        
    }
    public static void startWeak(int d, int dmg) {
    	
    	MainFightPanel.append(MainFightPanel.user,"\n\nYou have become");
         MainFightPanel.append(MainFightPanel.user," weaker",Color.LIGHT_GRAY,22,true);
         MainFightPanel.append(MainFightPanel.user,"!\n");
        Story.pause(1500);
        if(dmg > 100) {
        	dmg = (int)(gameplay.Player.baseDmg * (double)(dmg/100.0));
        }
        
        
        gameplay.Player.baseDmg = gameplay.Player.baseDmg - dmg;
        weaponActive = true;
        weakDuration = d;
        weakRound = backend.RPGRunner.round;
        weakAmount -= dmg;
        weakActive = true;
    }
    
    
         public static void startHeal(int d,int dmg)  {
        	 MainFightPanel.append(MainFightPanel.user,"\n\nYou're body has begun to ");
             MainFightPanel.append(MainFightPanel.user,"heal",Color.GREEN,20,true);
             MainFightPanel.append(MainFightPanel.user,"!\n");
        Story.pause(1500);
        if(dmg > 100) {
        	dmg = (int)(gameplay.Player.maxHealth * (double)(dmg/100.0));
        }
        
        healDuration = d;
        healAmount += dmg;
        healRound = backend.RPGRunner.round;
        healActive = true;
        
    }
    public static void doSacrifice(int d, int dmg)
    {
    	MainFightPanel.append(MainFightPanel.user,"\n\nYou lost "); 
         MainFightPanel.append(MainFightPanel.user,dmg+"",Color.RED,20,true);
         MainFightPanel.append(MainFightPanel.user," HP!\n");
           Story.pause(1500);
           gameplay.Player.health = gameplay.Player.health - dmg;
     }
    
    public static void startTransform(int d,int dmg)
    {
    	pMaxHealth = gameplay.Player.maxHealth;
		pDef = gameplay.Player.armorSet[gameplay.Player.equippedArmor].def;
		pDefDesc = gameplay.Player.armorSet[gameplay.Player.equippedArmor].desc;
		pDefName = gameplay.Player.armorSet[gameplay.Player.equippedArmor].name;
		
		double maxHealth = gameplay.Player.maxHealth * 1.0;
			double percentHealth = (gameplay.Player.health / maxHealth);
			System.out.println("\n\n\n" + percentHealth);
		gameplay.Player.health = (int)(percentHealth * monsters.MonsterManager.enemies.get(RPGRunner.monsterTurn).getMaxHealth());
		System.out.println(gameplay.Player.health);
		gameplay.Player.maxHealth = monsters.MonsterManager.enemies.get(RPGRunner.monsterTurn).getMaxHealth();
		gameplay.Player.armorSet[gameplay.Player.equippedArmor].def = monsters.MonsterManager.enemies.get(RPGRunner.monsterTurn).getDef();
		gameplay.Player.armorSet[gameplay.Player.equippedArmor].desc = "The same stuff that " + monsters.MonsterManager.enemies.get(RPGRunner.monsterTurn).getName() + " uses.";
		gameplay.Player.armorSet[gameplay.Player.equippedArmor].name = monsters.MonsterManager.enemies.get(RPGRunner.monsterTurn).getName() + "'s Armor";
		if(gameplay.Player.health > gameplay.Player.maxHealth)
			gameplay.Player.health = gameplay.Player.maxHealth;
		MainFightPanel.append(MainFightPanel.user,"\n\nThis feels like puberty all over again. Only 1000x faster!\n");
        pause(3000);
        MainFightPanel.clearDisplay();
        transformDuration = d;
        transformRound = backend.RPGRunner.round;
        transformActive = true;
    }
    
  
    
    public static void getEffects(int r) {
    	 if(curseActive == true)  {
    		
             if(r <= curseRound + curseDuration){
            	 MainFightPanel.append(MainFightPanel.user,"\n\nYou are suffering from a curse!\n");
        		 pause(500);
            	 int threshold = (int)(Math.random()*101);
            	 if(threshold < 20) {
            		 gameplay.Player.health -= curseAmount;
            		 MainFightPanel.append(MainFightPanel.user,"You took ");
            		 MainFightPanel.append(MainFightPanel.user,""+curseAmount,Color.RED,25,true);
            		 MainFightPanel.append(MainFightPanel.user," Hex",new Color(184,95,216),25, false);
            		 MainFightPanel.append(MainFightPanel.user," Damage.");
            		 
            	 }else if(threshold >= 20 && threshold < 30) {
            		  MainFightPanel.append(MainFightPanel.user,"\n\nYou have been ");
            	       MainFightPanel.append(MainFightPanel.user,"Silenced",Color.BLUE,20,true);
            	       MainFightPanel.append(MainFightPanel.user,"!\n");
            	        Story.pause(1500);
            	        int sAmount = curseAmount >= 30 ? curseAmount / 15 : 1;
            	        if(sAmount > silenceDuration) {
            	        	silenceDuration = sAmount;
            	        	silenceRound = backend.RPGRunner.round;
            	        	silenceActive = true;
            	        }
            	 }else if(threshold >= 30 && threshold < 40) {
            		 MainFightPanel.append(MainFightPanel.user,"\n\nYou have been ");
            		 MainFightPanel.append(MainFightPanel.user,"Disabled",Color.MAGENTA,20,true);
            		 MainFightPanel.append(MainFightPanel.user,"!\n");
            		 Story.pause(1500);
            		 int dAmount = curseAmount >= 30 ? curseAmount / 15 : 1;
            		 if(dAmount > disableDuration) {
            			 disableDuration = dAmount;
            			 disableRound = backend.RPGRunner.round;
            			 disableActive = true;
            		 }
            	 }else if(threshold >= 40 && threshold < 55) {
            		 MainFightPanel.append(MainFightPanel.user,"\n\nYou have been ");
            		 MainFightPanel.append(MainFightPanel.user,"Weakened",Color.LIGHT_GRAY,20,true);
            		 MainFightPanel.append(MainFightPanel.user,"!\n");
            		 Story.pause(1500);
            	      
            		 int dmg = (int)(curseAmount / 2.8);
            			 weakDuration += (int)((Math.random() * 20)/8) + 1;
            			 weakRound = backend.RPGRunner.round;
            			 weakActive = true;
            			 dmg = (int)(gameplay.Player.baseDmg * (double)(dmg/100.0));
            			 weakAmount -= dmg;
            			 gameplay.Player.baseDmg -= dmg;
            	 	}else if(threshold >= 55 && threshold < 70) {
            	 		MainFightPanel.append(MainFightPanel.user,"\n\nYour defense has been lowered");
            		 	MainFightPanel.append(MainFightPanel.user,"!\n");
            		 	Story.pause(1500);
            	        int dmg = (int)(curseAmount / 3);
            	        dmg = (int)(gameplay.Player.baseDef * (double)(dmg/100.0));
            	        fragileAmount -= dmg;
            	        gameplay.Player.baseDef -= dmg;
            	        fragileDuration += (int)((Math.random() * 20)/8) + 1;
            	        fragileRound = backend.RPGRunner.round;
            	        fragileActive = true;
            		 }else if(threshold >= 70 && threshold < 80) {
            			 MainFightPanel.append(MainFightPanel.user,"\n\nYou are feeling ");
            		       MainFightPanel.append(MainFightPanel.user,"sluggish",Color.LIGHT_GRAY,20,true);
            		       MainFightPanel.append(MainFightPanel.user,"!\n");
            		        pause(1200);
            		        slowDuration += 1+(int)(Math.random()*2.2);
            		        slowRound = backend.RPGRunner.round;
            		        int dmg = curseAmount / 3;
            		        slowAmount -= dmg;
            		        slowActive = true;
            		        gameplay.Player.evadeChance -= dmg;
            		 }else if(threshold >= 80 && threshold < 90) {
            			 MainFightPanel.append(MainFightPanel.user,"\n\nYour elemental resistance has been lowered! ");
          		        pause(1500);
          		        
          		        gameplay.Player.baseShockR -= curseAmount / 2;
          	 
          	        
          		        shockWDuration = (curseAmount / 20) + 1;
          		        shockWDmg -= curseAmount / 2;
          		        shockWRound = backend.RPGRunner.round;
          		        shockWActive = true;
          		      
          		        gameplay.Player.baseFireR -= curseAmount / 2;
          		        fireWDuration = (curseAmount / 20) + 1;
          		        fireWDmg -= curseAmount / 2;
          		        fireWRound = backend.RPGRunner.round;
          		        fireWActive = true;
          		      
          		        gameplay.Player.baseIceR -= curseAmount / 2;
          		        iceWDuration = (curseAmount / 20) + 1;
          		        iceWDmg -= curseAmount / 2;
          		        iceWRound = backend.RPGRunner.round;
          		        iceWActive = true;
          		 }else {
          			 MainFightPanel.append(MainFightPanel.user,"\n\nNothing happens...");
       		        pause(1500);
          		 }
            	 
	            	 
            
        		 MainFightPanel.clearDisplay();
            }else {
            	curseActive = false;
            	curseDuration = 0;
            	curseAmount = 0;
            }
         }
    	
        if(strengthActive == true)
        {
            if(!(r <= strengthRound + strengthDuration))
            {
            	gameplay.Player.baseDmg -=strengthAmount;               
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
            	gameplay.Player.baseDmg -=weakAmount;               
            	MainFightPanel.append(MainFightPanel.user,"\n\nYour weakness has worn off.");
             pause(2500);
             MainFightPanel.clearDisplay();
             weakActive = false;
             weakAmount = 0;
            }
        }
        if(strengthActive == false && weaponActive == true)
        {
        	gameplay.Player.baseDmg -=strengthAmount;
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
            	gameplay.Player.baseDef -= fortifyAmount;
             MainFightPanel.append(MainFightPanel.user,"\n\nYour extra defense has worn off!");
             pause(2500);
             MainFightPanel.clearDisplay();
             armorActive = false;
             fortifyActive = false;
             fortifyAmount = 0;
            }
        }
        
        if(swiftActive == true)
        {
            if(!(r <= swiftRound + swiftDuration))
            {
            	gameplay.Player.evadeChance -= swiftAmount;
             MainFightPanel.append(MainFightPanel.user,"\n\nYour ");
             MainFightPanel.append(MainFightPanel.user,"swiftness ",Color.LIGHT_GRAY,20,true);
             MainFightPanel.append(MainFightPanel.user,"has faded.");
             pause(2500);
             MainFightPanel.clearDisplay();
             swiftActive = false;
             swiftAmount = 0;
            }
        }
        if(slowActive == true)
        {
            if(!(r <= slowRound + slowDuration))
            {
            	gameplay.Player.evadeChance -= slowAmount;
             MainFightPanel.append(MainFightPanel.user,"\n\nYou feel your ");
             MainFightPanel.append(MainFightPanel.user,"energy ",Color.DARK_GRAY,20,true);
             MainFightPanel.append(MainFightPanel.user,"return to you.");
             pause(2500);
             MainFightPanel.clearDisplay();
             slowActive = false;
             slowAmount = 0;
            }
        }
        
        if(fragileActive == true)
        {
            if(!(r <= fragileRound + fragileDuration))
            {
            	gameplay.Player.baseDef -= fragileAmount;
            	 MainFightPanel.append(MainFightPanel.user,"\n\nYour ");
                 MainFightPanel.append(MainFightPanel.user,"fragility ",Color.MAGENTA,20,true);
                 MainFightPanel.append(MainFightPanel.user,"has worn off.");
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
            	gameplay.Player.baseFireR -= fireRDmg;
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
            	gameplay.Player.baseIceR -= iceRDmg;
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
            	gameplay.Player.baseShockR -= shockRDmg;
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
            	gameplay.Player.baseFireR -= fireWDmg;
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
            	gameplay.Player.baseIceR -= iceWDmg;
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
            	gameplay.Player.baseShockR -= shockWDmg;
             MainFightPanel.append(MainFightPanel.user,"\n\nYour weakness to electricity has worn off!");
             pause(2500);
             MainFightPanel.clearDisplay();
             shockWActive = false;
             shockWDmg = 0;
            }
        }
        if(fortifyActive == false && armorActive == true)
        {
        	gameplay.Player.baseDef -= fortifyAmount;
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
                if(gameplay.Player.getFireR() == 0)
                 {
                	 MainFightPanel.append(MainFightPanel.user,"You took ");
                     MainFightPanel.append(MainFightPanel.user,fireDmg+"",Color.RED,20,true);
                     MainFightPanel.append(MainFightPanel.user," fire ",FIRE_RED,20,true);
                     MainFightPanel.append(MainFightPanel.user,"damage\n");
                	 gameplay.Player.health = gameplay.Player.health - fireDmg;
                 }
                else if(gameplay.Player.getFireR() > 0 && gameplay.Player.getFireR() < 101)
                 {
                	if(gameplay.Player.getFireR() < 100)
                	  MainFightPanel.append(MainFightPanel.user,"RESIST!\n");
                	else
                		MainFightPanel.append(MainFightPanel.user,"IMMUNE!\n");
                	 pause(1000);
                	 double total = (fireDmg * (double)(gameplay.Player.getFireR() / 100.0));
                	 int burnDmg = fireDmg - (int)total;
                	 MainFightPanel.append(MainFightPanel.user,"You took ");
                     MainFightPanel.append(MainFightPanel.user,burnDmg+"",Color.RED,20,true);
                     MainFightPanel.append(MainFightPanel.user," fire ",FIRE_RED,20,true);
                     MainFightPanel.append(MainFightPanel.user,"damage\n");
                 	gameplay.Player.health = gameplay.Player.health - burnDmg;
                 }
                else if(gameplay.Player.getFireR() > 100)
                {
                	  MainFightPanel.append(MainFightPanel.user,"ABSORB!\n");
                	 pause(1000);
                	 double total = (fireDmg * (double)((gameplay.Player.getFireR()-100) / 100.0));
                	 int burnDmg = (int)total;
                	 MainFightPanel.append(MainFightPanel.user,"You absorbed the ");
                	 MainFightPanel.append(MainFightPanel.user," fire",FIRE_RED,20,true);
                	 MainFightPanel.append(MainFightPanel.user," and gained: ");
                     MainFightPanel.append(MainFightPanel.user,burnDmg+"",Color.GREEN,20,true);
                     MainFightPanel.append(MainFightPanel.user," HP.\n");
                 	gameplay.Player.health = gameplay.Player.health + burnDmg;
                 	if(gameplay.Player.health > gameplay.Player.maxHealth)
                 		gameplay.Player.health = gameplay.Player.maxHealth;
                }
                else
                {
                	MainFightPanel.append(MainFightPanel.user,"WEAKNESS!\n");
                	pause(1000);
                	double total = (fireDmg * (double)((gameplay.Player.getFireR() * -1) / 100.0));
                	int burnDmg = (int)total + fireDmg;
                	 MainFightPanel.append(MainFightPanel.user,"You are weak to ");
                     MainFightPanel.append(MainFightPanel.user,"fire",FIRE_RED,20,true);
                     MainFightPanel.append(MainFightPanel.user," and took ");
                     MainFightPanel.append(MainFightPanel.user,"%"+(gameplay.Player.getFireR() * -1),Color.WHITE,20,true);
                     MainFightPanel.append(MainFightPanel.user," extra ");
                     MainFightPanel.append(MainFightPanel.user,"fire",FIRE_RED,20,true);
                     MainFightPanel.append(MainFightPanel.user," damage\n");
                	pause(2000);
                	MainFightPanel.append(MainFightPanel.user,"You lost ");
                    MainFightPanel.append(MainFightPanel.user,burnDmg+"",Color.RED,20,true);
                    MainFightPanel.append(MainFightPanel.user," HP.\n");
            	gameplay.Player.health = gameplay.Player.health - burnDmg;
                 
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
                if(gameplay.Player.getIceR() == 0)
                 {
                	 MainFightPanel.append(MainFightPanel.user,"You took ");
                     MainFightPanel.append(MainFightPanel.user,iceDmg+"",Color.RED,20,true);
                     MainFightPanel.append(MainFightPanel.user," frost ",LIGHT_BLUE,20,true);
                     MainFightPanel.append(MainFightPanel.user,"damage\n");
                	 gameplay.Player.health = gameplay.Player.health - iceDmg;
                 }
                else if(gameplay.Player.getIceR() > 0 && gameplay.Player.getIceR() < 101)
                 {
                	if(gameplay.Player.getIceR() < 100)
                	  MainFightPanel.append(MainFightPanel.user,"RESIST!\n");
                	else
                		MainFightPanel.append(MainFightPanel.user,"IMMUNE!\n");
                	 pause(1000);
                	 double total = (iceDmg * (double)(gameplay.Player.getIceR() / 100.0));
                	 int frostDmg = iceDmg - (int)total;
                	 MainFightPanel.append(MainFightPanel.user,"You took ");
                     MainFightPanel.append(MainFightPanel.user,frostDmg+"",Color.RED,20,true);
                     MainFightPanel.append(MainFightPanel.user," frost ",LIGHT_BLUE,20,true);
                     MainFightPanel.append(MainFightPanel.user,"damage\n");
                 	gameplay.Player.health = gameplay.Player.health - frostDmg;
                 }
                else if(gameplay.Player.getIceR() > 100)
                {
                	  MainFightPanel.append(MainFightPanel.user,"ABSORB!\n");
                	 pause(1000);
                	 double total = (iceDmg * (double)((gameplay.Player.getIceR()-100) / 100.0));
                	 int frostDmg = (int)total;
                	 MainFightPanel.append(MainFightPanel.user,"You absorbed the ");
                	 MainFightPanel.append(MainFightPanel.user," ice",LIGHT_BLUE,20,true);
                	 MainFightPanel.append(MainFightPanel.user," and gained: ");
                     MainFightPanel.append(MainFightPanel.user,frostDmg+"",Color.GREEN,20,true);
                     MainFightPanel.append(MainFightPanel.user," HP.\n");
                 	gameplay.Player.health = gameplay.Player.health + frostDmg;
                 	if(gameplay.Player.health > gameplay.Player.maxHealth)
                 		gameplay.Player.health = gameplay.Player.maxHealth;
                }
                else
                {
                	MainFightPanel.append(MainFightPanel.user,"WEAKNESS!\n");
                	pause(1000);
                	double total = (iceDmg * (double)((gameplay.Player.getIceR() * -1) / 100.0));
                	int frostDmg = (int)total + iceDmg;
                	MainFightPanel.append(MainFightPanel.user,"You are weak to ");
                    MainFightPanel.append(MainFightPanel.user,"frost",LIGHT_BLUE,20,true);
                    MainFightPanel.append(MainFightPanel.user," and took ");
                    MainFightPanel.append(MainFightPanel.user,"%"+(gameplay.Player.getIceR() * -1),Color.WHITE,20,true);
                    MainFightPanel.append(MainFightPanel.user," extra ");
                    MainFightPanel.append(MainFightPanel.user,"frost",LIGHT_BLUE,20,true);
                    MainFightPanel.append(MainFightPanel.user," damage\n");
                	pause(2000);
                	MainFightPanel.append(MainFightPanel.user,"You lost ");
                   MainFightPanel.append(MainFightPanel.user,frostDmg+"",Color.RED,20,true);
                   MainFightPanel.append(MainFightPanel.user," HP.\n");
            	gameplay.Player.health = gameplay.Player.health - frostDmg;
                 
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
                if(gameplay.Player.getShockR() == 0)
                 {
                	 MainFightPanel.append(MainFightPanel.user,"You took ");
                     MainFightPanel.append(MainFightPanel.user,shockDmg+"",Color.RED,20,true);
                     MainFightPanel.append(MainFightPanel.user," shock ",Color.YELLOW,20,true);
                     MainFightPanel.append(MainFightPanel.user,"damage\n");
                	 gameplay.Player.health = gameplay.Player.health - shockDmg;
                 }
                else if(gameplay.Player.getShockR() > 0 && gameplay.Player.getShockR() < 101)
                 {
                	if(gameplay.Player.getShockR() < 100)
                	  MainFightPanel.append(MainFightPanel.user,"RESIST!\n");
                	else
                		MainFightPanel.append(MainFightPanel.user,"IMMUNE!\n");
                	 pause(1000);
                	 double total = (shockDmg * (double)(gameplay.Player.getShockR() / 100.0));
                	 int frostDmg = shockDmg - (int)total;
                	 MainFightPanel.append(MainFightPanel.user,"You took ");
                     MainFightPanel.append(MainFightPanel.user,frostDmg+"",Color.RED,20,true);
                     MainFightPanel.append(MainFightPanel.user," shock ",Color.YELLOW,20,true);
                     MainFightPanel.append(MainFightPanel.user,"damage\n");
                 	gameplay.Player.health = gameplay.Player.health - frostDmg;
                 }
                else if(gameplay.Player.getShockR() > 100)
                {
                	  MainFightPanel.append(MainFightPanel.user,"ABSORB!\n");
                	 pause(1000);
                	 double total = (shockDmg * (double)((gameplay.Player.getShockR()-100) / 100.0));
                	 int frostDmg = (int)total;
                	 MainFightPanel.append(MainFightPanel.user,"You absorbed the ");
                	 MainFightPanel.append(MainFightPanel.user," electricity",Color.YELLOW,20,true);
                	 MainFightPanel.append(MainFightPanel.user," and gained: ");
                     MainFightPanel.append(MainFightPanel.user,frostDmg+"",Color.GREEN,20,true);
                     MainFightPanel.append(MainFightPanel.user," HP.\n");
                 	gameplay.Player.health = gameplay.Player.health + frostDmg;
                 	if(gameplay.Player.health > gameplay.Player.maxHealth)
                 		gameplay.Player.health = gameplay.Player.maxHealth;
                }
                else
                {
                	MainFightPanel.append(MainFightPanel.user,"WEAKNESS!\n");
                	pause(1000);
                	double total = (shockDmg * (double)((gameplay.Player.getShockR() * -1) / 100.0));
                	int frostDmg = (int)total + shockDmg;
                	MainFightPanel.append(MainFightPanel.user,"You are weak to ");
                    MainFightPanel.append(MainFightPanel.user,"electricity",Color.YELLOW,20,true);
                    MainFightPanel.append(MainFightPanel.user," and took ");
                    MainFightPanel.append(MainFightPanel.user,"%"+(gameplay.Player.getShockR() * -1),Color.WHITE,20,true);
                    MainFightPanel.append(MainFightPanel.user," extra ");
                    MainFightPanel.append(MainFightPanel.user,"shock",Color.YELLOW,20,true);
                    MainFightPanel.append(MainFightPanel.user," damage\n");
                	pause(2000);
                	MainFightPanel.append(MainFightPanel.user,"You lost ");
                   MainFightPanel.append(MainFightPanel.user,frostDmg+"",Color.RED,20,true);
                   MainFightPanel.append(MainFightPanel.user," HP.\n");
            	gameplay.Player.health = gameplay.Player.health - frostDmg;
                 
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
            if((double)(gameplay.Player.maxHealth * (poisonDuration / 100.0)) > poisonTotal)
            		{
            			MainFightPanel.append(MainFightPanel.user,"\n\nYou are ");
            			MainFightPanel.append(MainFightPanel.user,"Poisoned",PUKE_GREEN,20,true);
            			MainFightPanel.append(MainFightPanel.user,"!\n");
            			pause(1000);
            			MainFightPanel.append(MainFightPanel.user,"You lost ");
            			MainFightPanel.append(MainFightPanel.user,poisonDmg+"",Color.RED,20,true);
            			MainFightPanel.append(MainFightPanel.user," HP.\n");
                    	gameplay.Player.health = gameplay.Player.health - poisonDmg;
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
        if(bleedActive == true)
        {
            if(r <= bleedRound + bleedDuration)
            {
            MainFightPanel.append(MainFightPanel.user,"\n\nYou are bleeding!\n");
            pause(500);
            gameplay.Player.health -= bleedAmount;
            MainFightPanel.append(MainFightPanel.user,"You lost ");
            MainFightPanel.append(MainFightPanel.user,""+bleedAmount,Color.RED,25,true);
            MainFightPanel.append(MainFightPanel.user," HP.");
            pause(2000);
            MainFightPanel.clearDisplay();
           }
           else {
           bleedActive = false;
           bleedDuration = 0;
           bleedAmount = 0;
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
        if(frozenActive == true)
        {
            if(r < frozenRound + frozenDuration){
            	if(burnActive) {
            		frozenActive = false;
            		frozenDuration = 0;
            		frozenAmount = 0;
            		 MainFightPanel.append(MainFightPanel.user,"\n\nYour ice has melted.\n");
                     pause(2000);
                     MainFightPanel.clearDisplay();
            	}else {
           		 	MainFightPanel.append(MainFightPanel.user,"\n\nYou are ");
           		 	MainFightPanel.append(MainFightPanel.user, "frozen\n",LIGHT_BLUE,20,true);
           		 	pause(2000);
           		 	MainFightPanel.clearDisplay();
           		 	RPGRunner.pTurn=false;
            	}
            		
            }
           else {
        	   frozenActive = false;
        	   frozenDuration = 0;
        	   frozenAmount = 0;
      		 	MainFightPanel.append(MainFightPanel.user,"\n\nYour ice has shattered.");
      		 	pause(1000);
       		 	MainFightPanel.append(MainFightPanel.user,"\n\nYou took ");
       		 	MainFightPanel.append(MainFightPanel.user,frozenAmount+"",Color.RED,20,true);
       		 	MainFightPanel.append(MainFightPanel.user," freeze ",LIGHT_BLUE,20,true);
       		 	MainFightPanel.append(MainFightPanel.user,"dmg");
       		 	gameplay.Player.health -= frozenAmount;
       		 	MainFightPanel.clearDisplay();

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
                 gameplay.Player.health = gameplay.Player.health + healAmount;
                 if(gameplay.Player.health > gameplay.Player.maxHealth)
                	 	gameplay.Player.health = gameplay.Player.maxHealth;
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
                double maxHealth = gameplay.Player.maxHealth * 1.0;
    			double percentHealth = (gameplay.Player.health / maxHealth);
                   
        		gameplay.Player.health = (int)(percentHealth * pMaxHealth);
                gameplay.Player.maxHealth = pMaxHealth;
                gameplay.Player.armorSet[gameplay.Player.equippedArmor].def = pDef;
                gameplay.Player.armorSet[gameplay.Player.equippedArmor].desc = pDefDesc;
                gameplay.Player.armorSet[gameplay.Player.equippedArmor].name = pDefName;
        		if(gameplay.Player.health > gameplay.Player.maxHealth)
        			gameplay.Player.health = gameplay.Player.maxHealth;
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
