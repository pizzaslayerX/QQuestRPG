package StatusEffect;
import java.awt.Color;

import Main.Story;
import Run.*;
public class Monster
{
	public Monster(int d) {
		id = d;
	}
	
	public int id;
    private  int fireDuration;
    public  boolean burnActive;
    private  int fireDmg;
    private  int burnRound;
    private  int poisonDuration;
    public  boolean poisonActive;
    private  int poisonDmg;
    public  int poisonTotal = 0;
    private  int iceDuration;
    public  boolean iceActive;
    private  int iceDmg;
    private  int iceRound;
    private  int shockDuration;
    public  boolean shockActive;
    public  int shockDmg;
    public  int shockRound;
    public  int silenceRound;
    public  boolean silenceActive;
    public  int silenceDuration;
    public  int stunDuration;
    public  int stunRound;
    public  boolean stunActive;
    public  int fortifyDuration;
    public  int fortifyRound;
    public  boolean fortifyActive;
    public  int fortifyAmount;
    public  boolean armorActive = false;
    public  boolean healActive;
    public  int healAmount;
    public  int healDuration;
    public  int healRound;
    public  boolean strengthActive;
    public  int strengthDuration;
    public  int strengthRound;
    public  int strengthAmount;
    public  boolean weaponActive = false;
    public static boolean weakActive;
    public static int weakDuration;
    public static int weakRound;
    public static int weakAmount; 
    
    private static final Color PUKE_GREEN = new Color(37,148,33);
    private static final Color FIRE_RED = new Color(255,0,0);
    private static final Color LIGHT_BLUE = new Color(0,166,255);
    public  void startBurn(int d,int dmg)
    {
    	System.out.print(id);
        MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\n"+Monsters.MonsterManager.enemies.get(id).getName() + " has been ");
        MainFightPanel.append(MainFightPanel.enemyStatOutput,"Burned",FIRE_RED,20,true);
        MainFightPanel.append(MainFightPanel.enemyStatOutput,"!\n");
        Story.pause(1500);
        MainFightPanel.clearEnemyDisplay();
        if(dmg > fireDmg) {
        burnActive = true;
        fireDuration = d;
        fireDmg = dmg;
        burnRound = Run.RPGRunner.round;
        }
    }
    public  void startIce(int d,int dmg)
    {
        MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\n"+Monsters.MonsterManager.enemies.get(id).getName() + " has been ");
        MainFightPanel.append(MainFightPanel.enemyStatOutput,"Iced",LIGHT_BLUE,20,true);
        MainFightPanel.append(MainFightPanel.enemyStatOutput,"!\n");
        Story.pause(1500);
        MainFightPanel.clearEnemyDisplay();
        if(dmg > iceDmg) {
        iceActive = true;
        iceDuration = d;
        iceDmg = dmg;
        iceRound = Run.RPGRunner.round;
        }
    }
    public  void startShock(int d,int dmg)
    {
    	 MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\n"+Monsters.MonsterManager.enemies.get(id).getName() + " has been ");
         MainFightPanel.append(MainFightPanel.enemyStatOutput,"Zapped",Color.YELLOW,20,true);
         MainFightPanel.append(MainFightPanel.enemyStatOutput,"!\n");
        Story.pause(1500);
        MainFightPanel.clearEnemyDisplay();
        if(dmg > shockDmg) {
        shockActive = true;
        shockDuration = d;
        shockDmg = dmg;
        shockRound = Run.RPGRunner.round;
        }
    }
    public  void startPoison(int d,int dmg)
    {;
        MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\n"+Monsters.MonsterManager.enemies.get(id).getName() + " has been ");
        MainFightPanel.append(MainFightPanel.enemyStatOutput,"Poisoned",PUKE_GREEN,20,true);
        MainFightPanel.append(MainFightPanel.enemyStatOutput,"!\n");
        Story.pause(1500);
        MainFightPanel.clearEnemyDisplay();
        if(dmg > poisonDmg) {
        poisonActive = true;
        poisonDuration = d;
        poisonDmg = dmg;
        }
    }
    public  void startSilence(int d,int dmg)
    {
        MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\n"+Monsters.MonsterManager.enemies.get(id).getName() + " has been ");
        MainFightPanel.append(MainFightPanel.enemyStatOutput,"Silenced",Color.BLUE,20,true);
        MainFightPanel.append(MainFightPanel.enemyStatOutput,"!\n");
        if(d > silenceDuration) {
        silenceDuration = d;
        silenceRound = Run.RPGRunner.round;
        silenceActive = true;
        }
        pause(2000);
        MainFightPanel.clearEnemyDisplay();
    }
    public  void startStun(int d,int dmg)
    {
        MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\n"+Monsters.MonsterManager.enemies.get(id).getName() + " has been ");
        MainFightPanel.append(MainFightPanel.enemyStatOutput,"Stunned",Color.ORANGE,20,true);
        MainFightPanel.append(MainFightPanel.enemyStatOutput,"!\n");
        pause(1500);
        if(d > stunDuration) {
        stunDuration = d;
        stunRound = Run.RPGRunner.round;
        stunActive = true;
        }
    }
    public void startFortify(int d, int dmg)
    {
    	
    	MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\nDefense boost!!!\n");
        Story.pause(1500);
        fortifyDuration = d;
        fortifyRound = Run.RPGRunner.round;
        fortifyActive = true;
        fortifyAmount += dmg;
        Monsters.MonsterManager.enemies.get(id).setDef(Monsters.MonsterManager.enemies.get(id).getDef() + dmg);
        armorActive = true;
    }
         public  void startHeal(int d,int dmg)
    {
        MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\n"+Monsters.MonsterManager.enemies.get(id).getName() + " has started ");
        MainFightPanel.append(MainFightPanel.enemyStatOutput,"Healing",Color.GREEN,20,true);
        MainFightPanel.append(MainFightPanel.enemyStatOutput,"!\n");
        Story.pause(1500);
        if(dmg > healAmount) {
        healDuration = d;
        healAmount = dmg;
        healRound = Run.RPGRunner.round;
        healActive = true;
        }
    }
    public  void doMultiHit(int t, int dmg) throws InterruptedException
    {
        pause(2500);
        MainFightPanel.clearEnemyDisplay();
        MainFightPanel.clearDisplay();
        MainFightPanel.append(MainFightPanel.user,"\n\nYou strike the enemy ");
        MainFightPanel.append(MainFightPanel.user,t+"",Color.RED,20,true);
    	MainFightPanel.append(MainFightPanel.user," times!\n");
        pause(2500);
        int countHits = 0;
        for(int i = 0;i<t;i++)
        {
        	if(countHits == 3) {
            	MainFightPanel.clearDisplay();
            	MainFightPanel.append(MainFightPanel.user,"\n\nYou strike the enemy ");
                MainFightPanel.append(MainFightPanel.user,t+"",Color.RED,20,true);
            	MainFightPanel.append(MainFightPanel.user," times!\n");
            	countHits = 0;
            }
            
            int hitD = ((dmg / 2) + (int)(Math.random() * ((dmg / 2) + 1)));
            Monsters.MonsterManager.enemies.get(id).setHealth(Monsters.MonsterManager.enemies.get(id).getHealth() - hitD);
            MainFightPanel.clearEnemyDisplay();
            Playlist.playEffect("/sounds/MultiHit.wav");
            MainFightPanel.append(MainFightPanel.user,"You dealt ");
            MainFightPanel.append(MainFightPanel.user,hitD+"",Color.RED,20,true);
        	MainFightPanel.append(MainFightPanel.user," HP to " + Monsters.MonsterManager.enemies.get(id).getName() +"\n");
        	countHits++;
        	pause(700);
        }
        pause(1500);
        MainFightPanel.clearDisplay();
    }
    public  void doManaBurn() throws InterruptedException
    {
        pause(2000);
        MainFightPanel.clearEnemyDisplay();
            int hitD = Main.Player.mana;
            Main.Player.mana = 0;
            Monsters.MonsterManager.enemies.get(id).setHealth(Monsters.MonsterManager.enemies.get(id).getHealth() - hitD);
            MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\n"+Monsters.MonsterManager.enemies.get(id).getName() + " lost ");
            MainFightPanel.append(MainFightPanel.enemyStatOutput,hitD+"",Color.RED,20,true);
        	MainFightPanel.append(MainFightPanel.enemyStatOutput," HP.\n");
        	pause(1800);
        MainFightPanel.clearEnemyDisplay();
    }
    public  void startStrength(int d, int dmg)
    {
        MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\n"+Monsters.MonsterManager.enemies.get(id).getName() +  " grows ");
        MainFightPanel.append(MainFightPanel.enemyStatOutput,"stronger",Color.RED,22,true);
        MainFightPanel.append(MainFightPanel.enemyStatOutput,"!\n");
        Story.pause(1500);
        MainFightPanel.append(MainFightPanel.enemyStatOutput,"+" + dmg + " dmg\n");
        MainFightPanel.append(MainFightPanel.enemyStatOutput,""+dmg,Color.RED,20,true);
        MainFightPanel.append(MainFightPanel.enemyStatOutput," dmg\n");
        Story.pause(1500);
        Monsters.MonsterManager.enemies.get(id).setAttack(Monsters.MonsterManager.enemies.get(id).getAttack() + dmg);
        weaponActive = true;
        strengthDuration = d;
        strengthRound = Run.RPGRunner.round;
        strengthAmount += dmg;
        strengthActive = true;
        
    }
    
    
    public  void getEffects(int r)
    {
    	if(strengthActive == true)
        {
            if(!(r <= strengthRound + strengthDuration))
            {
            	Monsters.MonsterManager.enemies.get(id).setAttack(Monsters.MonsterManager.enemies.get(id).getAttack() - strengthAmount);
            	MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\n"+Monsters.MonsterManager.enemies.get(id).getName() + "'s extra strength has left.");
             pause(2500);
             MainFightPanel.clearEnemyDisplay();
             weaponActive = false;
             strengthActive = false;
             strengthAmount = 0;
            }
        }
    	if(strengthActive == false && weaponActive == true)
        {
    		Monsters.MonsterManager.enemies.get(id).setAttack(Monsters.MonsterManager.enemies.get(id).getAttack() - strengthAmount);
             MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\n"+Monsters.MonsterManager.enemies.get(id).getName() + "'s extra strength has left.");
             pause(2500);
             MainFightPanel.clearEnemyDisplay();
             weaponActive = false;
             strengthActive = false;
             strengthAmount =0;
        }
        if(fortifyActive == true)
        {
            if(!(r <= fortifyRound + fortifyDuration))
            {
                 Monsters.MonsterManager.enemies.get(id).setDef(Monsters.MonsterManager.enemies.get(id).getDef() - fortifyAmount);
             MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\nThe enemy's extra defense has worn off!");
             pause(2500);
             MainFightPanel.clearEnemyDisplay();
             armorActive = false;
             fortifyActive = false;
             fortifyAmount = 0;
            }
        }
        if(fortifyActive == false && armorActive == true)
        {
        	 Monsters.MonsterManager.enemies.get(id).setDef(Monsters.MonsterManager.enemies.get(id).getDef() - fortifyAmount);
             MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\nThe enemy's extra defense has worn off!");
             pause(2500);
             MainFightPanel.clearEnemyDisplay();
             armorActive = false;
             fortifyActive = false;
             fortifyAmount = 0;
        }
        if(burnActive == true)
        {
            if(r < burnRound + fireDuration)
            {
                 MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\n"+Monsters.MonsterManager.enemies.get(id).getName() + " is on ");
                 MainFightPanel.append(MainFightPanel.enemyStatOutput,"fire",FIRE_RED,20,true);
                 MainFightPanel.append(MainFightPanel.enemyStatOutput,"!\n");
                 pause(1000);
                if(Monsters.MonsterManager.enemies.get(id).getFireR() == 0)
                 {
                	 MainFightPanel.append(MainFightPanel.enemyStatOutput,Monsters.MonsterManager.enemies.get(id).getName() +" took ");
                     MainFightPanel.append(MainFightPanel.enemyStatOutput,fireDmg+"",Color.RED,20,true);
                     MainFightPanel.append(MainFightPanel.enemyStatOutput," fire ",FIRE_RED,20,true);
                     MainFightPanel.append(MainFightPanel.enemyStatOutput,"damage\n");
                	 Monsters.MonsterManager.enemies.get(id).setHealth(Monsters.MonsterManager.enemies.get(id).getHealth() - fireDmg);
                 }
                else if(Monsters.MonsterManager.enemies.get(id).getFireR() > 0 && Monsters.MonsterManager.enemies.get(id).getFireR() < 101)
                 {
                	 double total = (fireDmg * (double)(Monsters.MonsterManager.enemies.get(id).getFireR() / 100.0));
                	 int burnDmg = fireDmg - (int)total;
                	 MainFightPanel.append(MainFightPanel.enemyStatOutput,Monsters.MonsterManager.enemies.get(id).getName() +" took ");
                     MainFightPanel.append(MainFightPanel.enemyStatOutput,burnDmg+"",Color.RED,20,true);
                     MainFightPanel.append(MainFightPanel.enemyStatOutput," fire ",FIRE_RED,20,true);
                     MainFightPanel.append(MainFightPanel.enemyStatOutput,"damage\n");
                	 Monsters.MonsterManager.enemies.get(id).setHealth(Monsters.MonsterManager.enemies.get(id).getHealth() - burnDmg);
                 }
                else if(Monsters.MonsterManager.enemies.get(id).getFireR() > 100)
                {
                	 double total = (fireDmg * (double)((Monsters.MonsterManager.enemies.get(id).getFireR()-100) / 100.0));
                	 int burnDmg = (int)total;
                	 MainFightPanel.append(MainFightPanel.enemyStatOutput,Monsters.MonsterManager.enemies.get(id).getName() +" absorbed the ");
                	 MainFightPanel.append(MainFightPanel.enemyStatOutput," fire",FIRE_RED,20,true);
                	 MainFightPanel.append(MainFightPanel.enemyStatOutput," and gained: ");
                     MainFightPanel.append(MainFightPanel.enemyStatOutput,burnDmg+"",Color.GREEN,20,true);
                     MainFightPanel.append(MainFightPanel.enemyStatOutput," HP.\n");
                	 Monsters.MonsterManager.enemies.get(id).setHealth(Monsters.MonsterManager.enemies.get(id).getHealth() + burnDmg);
                 	if(Monsters.MonsterManager.enemies.get(id).getHealth() > Monsters.MonsterManager.enemies.get(id).getMaxHealth())
                 		Monsters.MonsterManager.enemies.get(id).setHealth( Monsters.MonsterManager.enemies.get(id).getMaxHealth());
                }
                else
                {
                	double total = (fireDmg * (double)((Monsters.MonsterManager.enemies.get(id).getFireR() * -1) / 100.0));
                	int burnDmg = (int)total + fireDmg;
                	MainFightPanel.append(MainFightPanel.enemyStatOutput,Monsters.MonsterManager.enemies.get(id).getName() + " lost ");
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,burnDmg+"",Color.RED,20,true);
                    MainFightPanel.append(MainFightPanel.enemyStatOutput," HP.\n");
                	Monsters.MonsterManager.enemies.get(id).setHealth(Monsters.MonsterManager.enemies.get(id).getHealth() - burnDmg);
                 
                }
                pause(2000);
                MainFightPanel.clearEnemyDisplay();
            }
            else {
            burnActive = false;
            fireDmg = 0;
            }
        }
        if(iceActive == true)
        {
            if(r < iceRound + iceDuration)
            {
                 MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\n"+Monsters.MonsterManager.enemies.get(id).getName() + " is ");
                 MainFightPanel.append(MainFightPanel.enemyStatOutput,"freezing",LIGHT_BLUE,20,true);
                 MainFightPanel.append(MainFightPanel.enemyStatOutput,"!\n");
                 pause(1000);
                if(Monsters.MonsterManager.enemies.get(id).getIceR() == 0)
                 {
                	 MainFightPanel.append(MainFightPanel.enemyStatOutput,Monsters.MonsterManager.enemies.get(id).getName() +" took ");
                     MainFightPanel.append(MainFightPanel.enemyStatOutput,iceDmg+"",Color.RED,20,true);
                     MainFightPanel.append(MainFightPanel.enemyStatOutput," frost ",LIGHT_BLUE,20,true);
                     MainFightPanel.append(MainFightPanel.enemyStatOutput,"damage\n");
                	 Monsters.MonsterManager.enemies.get(id).setHealth(Monsters.MonsterManager.enemies.get(id).getHealth() - iceDmg);
                 }
                else if(Monsters.MonsterManager.enemies.get(id).getIceR() > 0 && Monsters.MonsterManager.enemies.get(id).getIceR() < 101)
                 {
                	
                	 double total = (iceDmg * (double)(Monsters.MonsterManager.enemies.get(id).getIceR() / 100.0));
                	 int frostDmg = iceDmg - (int)total;
                	 MainFightPanel.append(MainFightPanel.enemyStatOutput,Monsters.MonsterManager.enemies.get(id).getName() +" took ");
                     MainFightPanel.append(MainFightPanel.enemyStatOutput,frostDmg+"",Color.RED,20,true);
                     MainFightPanel.append(MainFightPanel.enemyStatOutput," frost ",LIGHT_BLUE,20,true);
                     MainFightPanel.append(MainFightPanel.enemyStatOutput,"damage\n");
                	 Monsters.MonsterManager.enemies.get(id).setHealth(Monsters.MonsterManager.enemies.get(id).getHealth() - frostDmg);
                 }
                else if(Monsters.MonsterManager.enemies.get(id).getIceR() > 100)
                {
                	 double total = (iceDmg * (double)((Monsters.MonsterManager.enemies.get(id).getIceR()-100) / 100.0));
                	 int frostDmg = (int)total;
                	 MainFightPanel.append(MainFightPanel.enemyStatOutput,Monsters.MonsterManager.enemies.get(id).getName() +" absorbed the ");
                	 MainFightPanel.append(MainFightPanel.enemyStatOutput," ice",LIGHT_BLUE,20,true);
                	 MainFightPanel.append(MainFightPanel.enemyStatOutput," and gained: ");
                     MainFightPanel.append(MainFightPanel.enemyStatOutput,frostDmg+"",Color.GREEN,20,true);
                     MainFightPanel.append(MainFightPanel.enemyStatOutput," HP.\n");
                	 Monsters.MonsterManager.enemies.get(id).setHealth(Monsters.MonsterManager.enemies.get(id).getHealth() + frostDmg);
                 	if(Monsters.MonsterManager.enemies.get(id).getHealth() > Monsters.MonsterManager.enemies.get(id).getMaxHealth())
                 		Monsters.MonsterManager.enemies.get(id).setHealth(Monsters.MonsterManager.enemies.get(id).getMaxHealth());
                }
                else
                {
                	
                	double total = (iceDmg * (double)((Monsters.MonsterManager.enemies.get(id).getIceR() * -1) / 100.0));
                	int frostDmg = (int)total + iceDmg;
                	MainFightPanel.append(MainFightPanel.enemyStatOutput,Monsters.MonsterManager.enemies.get(id).getName() + " lost ");
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,frostDmg+"",Color.RED,20,true);
                    MainFightPanel.append(MainFightPanel.enemyStatOutput," HP.\n");
                	Monsters.MonsterManager.enemies.get(id).setHealth(Monsters.MonsterManager.enemies.get(id).getHealth() - frostDmg);
                 
                	
               	pause(2000);
               	
                }
                pause(2000);
                MainFightPanel.clearEnemyDisplay();
            }
            else {
            	iceActive = false;
            	iceDmg = 0;
            }
        }
        if(shockActive == true)
        {
            if(r < shockRound + shockDuration)
            {
                 MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\n"+Monsters.MonsterManager.enemies.get(id).getName() + " is ");
                 MainFightPanel.append(MainFightPanel.enemyStatOutput,"electrified",Color.YELLOW,20,true);
                 MainFightPanel.append(MainFightPanel.enemyStatOutput,"!\n");
                 pause(1000);
                if(Monsters.MonsterManager.enemies.get(id).getShockR() == 0)
                 {
                	 Monsters.MonsterManager.enemies.get(id).setHealth(Monsters.MonsterManager.enemies.get(id).getHealth() - shockDmg);
                	 MainFightPanel.append(MainFightPanel.enemyStatOutput,Monsters.MonsterManager.enemies.get(id).getName() +" took ");
                     MainFightPanel.append(MainFightPanel.enemyStatOutput,shockDmg+"",Color.RED,20,true);
                     MainFightPanel.append(MainFightPanel.enemyStatOutput," shock ",Color.YELLOW,20,true);
                     MainFightPanel.append(MainFightPanel.enemyStatOutput,"damage\n");
                 }
                else if(Monsters.MonsterManager.enemies.get(id).getShockR() > 0 && Monsters.MonsterManager.enemies.get(id).getShockR() < 101)
                 {
                
                	 double total = (shockDmg * (double)(Monsters.MonsterManager.enemies.get(id).getShockR() / 100.0));
                	 int frostDmg = shockDmg - (int)total;
                	 MainFightPanel.append(MainFightPanel.enemyStatOutput,Monsters.MonsterManager.enemies.get(id).getName() +" took ");
                     MainFightPanel.append(MainFightPanel.enemyStatOutput,frostDmg+"",Color.RED,20,true);
                     MainFightPanel.append(MainFightPanel.enemyStatOutput," shock ",Color.YELLOW,20,true);
                     MainFightPanel.append(MainFightPanel.enemyStatOutput,"damage\n");
                	 Monsters.MonsterManager.enemies.get(id).setHealth(Monsters.MonsterManager.enemies.get(id).getHealth() - frostDmg);
                 }
                else if(Monsters.MonsterManager.enemies.get(id).getShockR() > 100)
                {
                	  
                	 double total = (shockDmg * (double)((Monsters.MonsterManager.enemies.get(id).getShockR()-100) / 100.0));
                	 int frostDmg = (int)total;
                	 MainFightPanel.append(MainFightPanel.enemyStatOutput,Monsters.MonsterManager.enemies.get(id).getName() +" absorbed the ");
                	 MainFightPanel.append(MainFightPanel.enemyStatOutput," electricity",Color.YELLOW,20,true);
                	 MainFightPanel.append(MainFightPanel.enemyStatOutput," and gained: ");
                     MainFightPanel.append(MainFightPanel.enemyStatOutput,frostDmg+"",Color.GREEN,20,true);
                     MainFightPanel.append(MainFightPanel.enemyStatOutput," HP.\n");
                	 Monsters.MonsterManager.enemies.get(id).setHealth(Monsters.MonsterManager.enemies.get(id).getHealth() + frostDmg);
                 	if(Monsters.MonsterManager.enemies.get(id).getHealth() > Monsters.MonsterManager.enemies.get(id).getMaxHealth())
                 		Monsters.MonsterManager.enemies.get(id).setHealth(Monsters.MonsterManager.enemies.get(id).getMaxHealth());
                }
                else
                {
                	
                	double total = (shockDmg * (double)((Monsters.MonsterManager.enemies.get(id).getShockR() * -1) / 100.0));
                	int frostDmg = (int)total + shockDmg;
                	MainFightPanel.append(MainFightPanel.enemyStatOutput,Monsters.MonsterManager.enemies.get(id).getName() + " lost ");
                    MainFightPanel.append(MainFightPanel.enemyStatOutput,frostDmg+"",Color.RED,20,true);
                    MainFightPanel.append(MainFightPanel.enemyStatOutput," HP.\n");
                	Monsters.MonsterManager.enemies.get(id).setHealth(Monsters.MonsterManager.enemies.get(id).getHealth() - frostDmg);
                 
                }
                pause(2000);
                MainFightPanel.clearEnemyDisplay();
            }
            else {
            shockActive = false;
            shockDmg = 0;
            }
        }
        if(poisonActive == true)
        {
            if((double)(Monsters.MonsterManager.enemies.get(id).getMaxHealth() * (poisonDuration / 100.0)) > poisonTotal)
            		{
            			MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\n" + Monsters.MonsterManager.enemies.get(id).getName() + " is ");
            			MainFightPanel.append(MainFightPanel.enemyStatOutput,"Poisoned",PUKE_GREEN,20,true);
            			MainFightPanel.append(MainFightPanel.enemyStatOutput,"!\n");
            			pause(1000);
              			MainFightPanel.append(MainFightPanel.enemyStatOutput,Monsters.MonsterManager.enemies.get(id).getName() + "  lost ");
            			MainFightPanel.append(MainFightPanel.enemyStatOutput,poisonDmg+"",Color.RED,20,true);
            			MainFightPanel.append(MainFightPanel.enemyStatOutput," HP.\n");
                    	Monsters.MonsterManager.enemies.get(id).setHealth(Monsters.MonsterManager.enemies.get(id).getHealth() - poisonDmg);
                    	poisonTotal = poisonTotal + poisonDmg;
                    	pause(2000);
                        MainFightPanel.clearEnemyDisplay();
            		}
            else
            {
            poisonActive = false;
            poisonTotal = 0;
            MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\n"+Monsters.MonsterManager.enemies.get(id).getName() + " has recovered from the poison.");
            pause(2200);
            MainFightPanel.clearEnemyDisplay();
            }
        }
        if(silenceActive == true)
        {
            if(r < silenceRound + silenceDuration)
            {
            MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\n"+Monsters.MonsterManager.enemies.get(id).getName() + " can't utter a sound!\n");
            pause(2000);
            MainFightPanel.clearEnemyDisplay();
           }
           else {
           silenceActive = false;
           silenceDuration = 0;
           }
        }
        if(stunActive == true)
        {
            if(r < stunRound + stunDuration)
            {
            int threshold = 1 + (int)(Math.random() * 100);
            if(threshold < 50)
            {
            MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\n"+Monsters.MonsterManager.enemies.get(id).getName() + " is unable to move!\n");
            RPGRunner.eTurn = false;
            }
            else
            {
                MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\n"+Monsters.MonsterManager.enemies.get(id).getName() + " is barely able to take action\n");
            }
            pause(2500);
            MainFightPanel.clearEnemyDisplay();
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
                 MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\n"+Monsters.MonsterManager.enemies.get(id).getName() + " is regenerating!\n");
                 pause(2000);
                 MainFightPanel.append(MainFightPanel.enemyStatOutput,Monsters.MonsterManager.enemies.get(id).getName() + " gained ");
                 MainFightPanel.append(MainFightPanel.enemyStatOutput,healAmount+"",Color.GREEN,20,true);
                 MainFightPanel.append(MainFightPanel.enemyStatOutput," HP.\n");
                 Monsters.MonsterManager.enemies.get(id).setHealth(Monsters.MonsterManager.enemies.get(id).getHealth() + healAmount);
                 if(Monsters.MonsterManager.enemies.get(id).getHealth() > Monsters.MonsterManager.enemies.get(id).getMaxHealth())
                	 Monsters.MonsterManager.enemies.get(id).setHealth(Monsters.MonsterManager.enemies.get(id).getMaxHealth());
                 pause(2000);
                 MainFightPanel.clearEnemyDisplay();
            }
            else {
            healActive = false;
            healAmount = 0;
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
