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
	public  int damage;
    private  int fireDuration;
    public  boolean burnActive;
    public  int fireDmg;
    public  int burnRound;
    private  int iceDuration;
    public  boolean iceActive;
    public  int iceDmg;
    public  int iceRound;
    private  int shockDuration;
    public  boolean shockActive;
    public  int shockDmg;
    public  int shockRound;
    private  int poisonDuration;
    public  boolean poisonActive;
    private  int poisonDmg;
    public  int poisonTotal = 0;
    public  int silenceRound;
    public  boolean silenceActive;
    public  int silenceDuration;
    public  int disableRound;
    public  boolean disableActive;
    public  int disableDuration;
    public  int stunDuration;
    public  int stunRound;
    public  boolean stunActive;
    public  int fortifyDuration;
    public  int fortifyRound;
    public  boolean fortifyActive; 
    public  int fortifyAmount;
    public  int fragileDuration;
    public  int fragileRound;
    public  boolean fragileActive; 
    public  int fragileAmount;
    public  boolean strengthActive;
    public  int strengthDuration;
    public  int strengthRound;
    public  int strengthAmount;
    public  boolean weakActive;
    public  int weakDuration;
    public  int weakRound;
    public  int weakAmount; 
    public  boolean healActive;
    public  int healAmount;
    public  int healDuration;
    public  int healRound;
    public  boolean weaponActive = false;
    public  boolean armorActive = false;
    public  int transformDuration;
    public  int transformRound;
    public  boolean transformActive;
    public  int pDef;
    public  String pDefName;
    public  String pDefDesc;
    public  int pMaxHealth;
    private  int iceRDuration;
    public  boolean iceRActive;
    public  int iceRDmg;
    public  int iceRRound;
    private  int fireRDuration;
    public  boolean fireRActive;
    public  int fireRDmg;
    public  int fireRRound;
    private  int shockRDuration;
    public  boolean shockRActive;
    public  int shockRDmg;
    public  int shockRRound;
    
    
    private  int iceWDuration;
    public  boolean iceWActive;
    public  int iceWDmg;
    public  int iceWRound;
    private  int fireWDuration;
    public  boolean fireWActive;
    public  int fireWDmg;
    public  int fireWRound;
    private  int shockWDuration;
    public  boolean shockWActive;
    public  int shockWDmg;
    public  int shockWRound;
    
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
    public void startBurnResist(int d,int dmg)
    {
    	 MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\nFire",FIRE_RED,20,true);
         MainFightPanel.append(MainFightPanel.enemyStatOutput," resistance increased");
         MainFightPanel.append(MainFightPanel.enemyStatOutput,"!\n");
        Story.pause(1500);
        Monsters.MonsterManager.enemies.get(id).setFireR(Monsters.MonsterManager.enemies.get(id).getFireR() + dmg);
        
        fireRDuration = d;
        fireRDmg += dmg;
        fireRRound = Run.RPGRunner.round;
        fireRActive = true;
        
    }
    public void startIceResist(int d,int dmg)
    {  
       MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\nIce",LIGHT_BLUE,20,true);
       MainFightPanel.append(MainFightPanel.enemyStatOutput," resistance increased");
       MainFightPanel.append(MainFightPanel.enemyStatOutput,"!\n");
       Monsters.MonsterManager.enemies.get(id).setIceR(Monsters.MonsterManager.enemies.get(id).getIceR() + dmg);
        Story.pause(1500);
        
        iceRDuration = d;
        iceRDmg += dmg;
        iceRRound = Run.RPGRunner.round;
        iceRActive = true;
        
    }
    public void startShockResist(int d,int dmg)
    {
    	 MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\nShock",Color.YELLOW,20,true);
         MainFightPanel.append(MainFightPanel.enemyStatOutput," resistance increased");
         MainFightPanel.append(MainFightPanel.enemyStatOutput,"!\n");
         Main.Player.baseShockR += dmg;
        Story.pause(1500);
        Monsters.MonsterManager.enemies.get(id).setShockR(Monsters.MonsterManager.enemies.get(id).getShockR() + dmg);
        shockRDuration = d;
        shockRDmg += dmg;
        shockRRound = Run.RPGRunner.round;
        shockRActive = true;
        
    }
    public  void startShockWeak(int d,int dmg)
    {
    	 MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\nShock",Color.YELLOW,20,true);
         MainFightPanel.append(MainFightPanel.enemyStatOutput," resistance decreased");
         MainFightPanel.append(MainFightPanel.enemyStatOutput,"!\n");
         Monsters.MonsterManager.enemies.get(id).setShockR(Monsters.MonsterManager.enemies.get(id).getShockR() - dmg);
        Story.pause(1500);
        
        shockWDuration = d;
        shockWDmg -= dmg;
        shockWRound = Run.RPGRunner.round;
        shockWActive = true;
        
    }
    
    public  void startBurnWeak(int d,int dmg)
    {
    	 MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\nFire",FIRE_RED,20,true);
         MainFightPanel.append(MainFightPanel.enemyStatOutput," resistance decreased");
         MainFightPanel.append(MainFightPanel.enemyStatOutput,"!\n");
        Story.pause(1500);
        Monsters.MonsterManager.enemies.get(id).setFireR(Monsters.MonsterManager.enemies.get(id).getFireR() - dmg);
        
        fireWDuration = d;
        fireWDmg -= dmg;
        fireWRound = Run.RPGRunner.round;
        fireWActive = true;
        
    }
    public  void startIceWeak(int d,int dmg)
    {  
       MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\nIce",LIGHT_BLUE,20,true);
       MainFightPanel.append(MainFightPanel.enemyStatOutput," resistance decreased");
       MainFightPanel.append(MainFightPanel.enemyStatOutput,"!\n");
       Monsters.MonsterManager.enemies.get(id).setIceR(Monsters.MonsterManager.enemies.get(id).getIceR() - dmg);
        Story.pause(1500);
        
        iceWDuration = d;
        iceWDmg -= dmg;
        iceWRound = Run.RPGRunner.round;
        iceWActive = true;
        
    }
    public void startFragility(int d, int dmg)
    {
    	
    	MainFightPanel.append(MainFightPanel.user,"\n\n" + Monsters.MonsterManager.enemies.get(id).getName());
       MainFightPanel.append(MainFightPanel.user," defense has been lowered");
        Story.pause(1500);
        fragileDuration = d;
        fragileRound = Run.RPGRunner.round;
        fragileAmount -= dmg;
        fragileActive = true;
        Monsters.MonsterManager.enemies.get(id).setDef(Monsters.MonsterManager.enemies.get(id).getDef() - dmg);


    
    }
    public void startWeak(int d, int dmg)
    {
    	
    	MainFightPanel.append(MainFightPanel.user,"\n\n" + Monsters.MonsterManager.enemies.get(id).getName() + " has become ");
         MainFightPanel.append(MainFightPanel.user,"weaker",Color.LIGHT_GRAY,22,true);
         MainFightPanel.append(MainFightPanel.user,"!\n");
        Story.pause(1500);
        dmg = (int)(Monsters.MonsterManager.enemies.get(id).getAttack() * (double)(dmg/100.0));
        Monsters.MonsterManager.enemies.get(id).setAttack(Monsters.MonsterManager.enemies.get(id).getAttack() - dmg);

        weaponActive = true;
        weakDuration = d;
        weakRound = Run.RPGRunner.round;
        weakAmount -= dmg;
        weakActive = true;
    	
        
    }
    public  void startPoison(int d,int dmg)
    {
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
    	 if(weakActive == true)
         {
             if(!(r <= weakRound + weakDuration))
             {
             	Monsters.MonsterManager.enemies.get(id).setAttack(Monsters.MonsterManager.enemies.get(id).getAttack() - weakAmount);     
                MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\n"+Monsters.MonsterManager.enemies.get(id).getName());
             	MainFightPanel.append(MainFightPanel.enemyStatOutput,"'s weakness has worn off.");
              pause(2500);
              MainFightPanel.clearDisplay();
              weakActive = false;
              weakAmount = 0;
             }
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
        if(fragileActive == true)
        {
            if(!(r <= fragileRound + fragileDuration))
            {
            	Monsters.MonsterManager.enemies.get(id).setDef(Monsters.MonsterManager.enemies.get(id).getDef() - fragileAmount);
                MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\n"+Monsters.MonsterManager.enemies.get(id).getName());
            	MainFightPanel.append(MainFightPanel.enemyStatOutput,"'s defense has been repaired!");
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
            	Monsters.MonsterManager.enemies.get(id).setFireR(Monsters.MonsterManager.enemies.get(id).getFireR() - fireRDmg);
                MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\n"+Monsters.MonsterManager.enemies.get(id).getName());
            	MainFightPanel.append(MainFightPanel.enemyStatOutput,"'s extra fire resistance has worn off!");
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
            	Monsters.MonsterManager.enemies.get(id).setIceR(Monsters.MonsterManager.enemies.get(id).getIceR() - iceRDmg);
                MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\n"+Monsters.MonsterManager.enemies.get(id).getName());
            	MainFightPanel.append(MainFightPanel.enemyStatOutput,"'s extra ice resistance has worn off!");
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
            	Monsters.MonsterManager.enemies.get(id).setShockR(Monsters.MonsterManager.enemies.get(id).getShockR() - shockRDmg);
                MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\n"+Monsters.MonsterManager.enemies.get(id).getName());
            	MainFightPanel.append(MainFightPanel.enemyStatOutput,"'s extra shock resistance has worn off!");
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
            	Monsters.MonsterManager.enemies.get(id).setFireR(Monsters.MonsterManager.enemies.get(id).getFireR() - fireWDmg);
                MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\n"+Monsters.MonsterManager.enemies.get(id).getName());
            	MainFightPanel.append(MainFightPanel.enemyStatOutput,"'s weakness to fire has worn off!");
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
            	Monsters.MonsterManager.enemies.get(id).setIceR(Monsters.MonsterManager.enemies.get(id).getIceR() - iceWDmg);
                MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\n"+Monsters.MonsterManager.enemies.get(id).getName());
            	MainFightPanel.append(MainFightPanel.enemyStatOutput,"'s weakness to ice has worn off!");
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
            	Monsters.MonsterManager.enemies.get(id).setShockR(Monsters.MonsterManager.enemies.get(id).getShockR() - shockWDmg);
                MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\n"+Monsters.MonsterManager.enemies.get(id).getName());
            	MainFightPanel.append(MainFightPanel.enemyStatOutput,"'s weakness to electricity has worn off!");
             pause(2500);
             MainFightPanel.clearDisplay();
             shockWActive = false;
             shockWDmg = 0;
            }
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
