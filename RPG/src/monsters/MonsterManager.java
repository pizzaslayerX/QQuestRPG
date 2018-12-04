package monsters;
import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;

import backend.*;
import gameplay.Player;
import gameplay.Story;
public abstract class MonsterManager 
{
	public int id;
	protected int fireR;
	protected int iceR;
	protected int shockR;
    protected int evade;
    protected int def;
    protected int health;
    protected int maxHealth;
    protected int attack;
    protected int crit;
    protected int dmgTaken;
    protected String name;
    protected boolean smart = false;
    protected String[] attackNames = new String[3];
    protected int total;
    protected int[] triggerRate;
    protected String[] atkMsg;
    protected int[] dmg;
    protected boolean[] useTurn;
    protected String[] sound;
    protected int[] useCounter = new int[0];
    protected String song;
    protected String[] moves;
    protected String desc;
   // {Ability Amount,Ability1 Total Effects,Status Id,damage,Duration...}
    protected int[] statusEffect;
    protected String pic;
    public static ArrayList<MonsterManager> enemies = new ArrayList<MonsterManager>();
    public static ArrayList<statusEffect.Monster> enemyStatuses = new ArrayList<statusEffect.Monster>();
    public static ArrayList<MonsterManager> deadEnemies = new ArrayList<MonsterManager>();
    private static ArrayList<Integer> checkedId = new ArrayList<Integer>();
    public MonsterManager(String n1,String n2,String n3)
    {
    	 dmgTaken = 0;
         attackNames[0] = n1;
         attackNames[1] = n2;
         attackNames[2] = n3;
         
    }
    
    public MonsterManager() {
    	 dmgTaken = 0;
 
    }
    
    public static void setNames() {
    	int count = 0;
    	int holder = 0;
    	checkedId.clear();
    	for(int i = 0;i<enemies.size()-1;i++) {
    		count = 0;
    		if(checkedId.contains(enemies.get(i).id))
    			continue;
    		checkedId.add(enemies.get(i).id);
    		holder = i;
    		for(int ii = i;ii<enemies.size();ii++) {
    			if(enemies.get(i).id == enemies.get(ii).id)
    				count++;
    		}
    		for(int iii = 1;iii<=count;iii++) {
    			if(count == 1)
    				continue;
    			if(iii == 1) {
    				enemies.get(holder).setName(enemies.get(holder).getName() + " " + iii);
    				continue;
    			}
    			for(int check = holder+1;check<enemies.size();check++) {
    				if(enemies.get(check).id == enemies.get(holder).id){
    					enemies.get(check).setName(enemies.get(check).getName() + " " + iii);
    					holder = check;
    					break;
    				}
    			}
    		}
    	}
    }
    

    
    public static void winLoot() throws InterruptedException {
    	for(MonsterManager m : deadEnemies)
    		m.getDrops();
    	gameplay.LootScreen.battleLoot();
    	deadEnemies.clear();
    }
    
    public boolean getDeath() throws IOException, InterruptedException{
    	int killedHolder = 0;
    	for(int i = 0;i<enemies.size();i++) {
    		System.out.println(enemies.get(i).getName() + "  ");
    		System.out.println(enemyStatuses.get(i) + "  ");
    		if(enemies.get(i) == this)
    			killedHolder = i;
    	}
    	if(health <= 0) {
    		RPGRunner.output.setText("");
    		MainFightPanel.append(MainFightPanel.enemyStatOutput,"\nYou have slain "+this.getName()+"\n",Color.ORANGE,25,true);
    		Story.pause(1500);
    		MainFightPanel.clearEnemyDisplay();
    		deadEnemies.add(this);
    		enemies.remove(killedHolder);
    		enemyStatuses.remove(killedHolder);
    		RPGRunner.target = 0;
    	if(enemies.size() > 0)
    		MainFightPanel.changePic(MonsterManager.enemies.get(0).getPic());
    	return true;
      }
    	return false;
    }
    
    public static void spawn(MonsterManager m) {
    	enemies.add(m);
    	enemyStatuses.add(new statusEffect.Monster(enemies.size()-1));
    	
    }
   
   public String action()
   {
	  return "attacks";
   /* if(smart == false)
    {
       if(health > (maxHealth / 2))
       {
           return "attacks";
        }
        
        else if(health < (maxHealth / 2) && Main.Player.health >= (Main.Player.maxHealth / 3))
        {
            if(!(name.equals("~Pink Slug~")))
           {
            int fleeChance = 1 + (int)(Math.random() * 100);
            if(fleeChance <= 5)
                return "flees";
                else
                    return "attacks";
           }
           else if(name.equals("~Pink Slug~"))
           {
               int fleeChance = 1 + (int)(Math.random() * 100);
               if(fleeChance < 50)
                  return "flees";
                else
                    return "attacks";
            }
        }
    }
    
    return "attacks";
    */
   }
   
   public void tryCrit()
   {
       int threshold =  1 + (int)(Math.random() * 100);
       if(threshold <= Player.weapons[Player.equippedWeapon].crit)
       {
           dmgTaken = dmgTaken * 2;
           MainFightPanel.append(MainFightPanel.user,"\n\nCRITICAL HIT!!! \n",Color.MAGENTA,22,true);
        }
    }
   
   public abstract void getDrops() throws InterruptedException;
   
   public void loseHealth()
    {
        health = health - dmgTaken;
    }
    
   public void spawnMonster(String n, int d, int h, int a,boolean s, String n1,String n2,String n3, int c,int e,int fr,int ir,int sr,String p)
   {
       name = n;
       def = d;
       attack = a;
       health = h;
       maxHealth = h;
       smart = s;
       crit = c;
       evade = e;
       attackNames[0] = n1;
       attackNames[1] = n2;
       attackNames[2] = n3;
       fireR = fr;
       iceR = ir;
       shockR = sr;
       pic = p;
   }
   
   public void moveSet(int t,int[] tr,String[] am, int[] d, boolean[] u, String[] s, int[] se,int[] uc,String so)
   {
	   total = t;
	   triggerRate = tr;
	   atkMsg = am;
	   dmg = d;
	   useTurn = u;
	   sound = s;
	   statusEffect = se;
	   useCounter = uc;
	   song = so;
   }
    public void getDamage()
    {   
        if( Player.getDmg() > 10)
        {
        double total = Player.getDmg() - ( Player.getDmg() * 0.2) + (Math.random() * ( Player.getDmg() * 0.2));
        total = total +  Player.weapons[Player.equippedWeapon].bonusDmg + weapon.WeaponManager.strPlus;
        dmgTaken = (int)total;
    }
        else 
        {
            dmgTaken =  Player.getDmg();
            dmgTaken = dmgTaken +  Player.weapons[Player.equippedWeapon].bonusDmg;
        }
        tryCrit();
    }
    
    public void getResist()
    {
        dmgTaken = dmgTaken - (int)(dmgTaken * (def / 100.0));
        if(dmgTaken < 0)
        	dmgTaken = 0;
    }

	public int getFireR() {
		return fireR;
	}

	public void setFireR(int fireR) {
		this.fireR = fireR;
	}

	public int getIceR() {
		return iceR;
	}

	public void setIceR(int iceR) {
		this.iceR = iceR;
	}

	public int getShockR() {
		return shockR;
	}

	public void setShockR(int shockR) {
		this.shockR = shockR;
	}

	public int getEvade() {
		return evade;
	}

	public void setEvade(int evade) {
		this.evade = evade;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getCrit() {
		return crit;
	}

	public void setCrit(int crit) {
		this.crit = crit;
	}

	public int getDmgTaken() {
		return dmgTaken;
	}

	public void setDmgTaken(int dmgTaken) {
		this.dmgTaken = dmgTaken;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isSmart() {
		return smart;
	}

	public void setSmart(boolean smart) {
		this.smart = smart;
	}

	public String[] getAttackNames() {
		return attackNames;
	}

	public void setAttackNames(String[] attackNames) {
		this.attackNames = attackNames;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int[] getTriggerRate() {
		return triggerRate;
	}

	public void setTriggerRate(int[] triggerRate) {
		this.triggerRate = triggerRate;
	}

	public String[] getAtkMsg() {
		return atkMsg;
	}

	public void setAtkMsg(String[] atkMsg) {
		this.atkMsg = atkMsg;
	}

	public int[] getDmg() {
		return dmg;
	}

	public void setDmg(int[] dmg) {
		this.dmg = dmg;
	}

	public boolean[] getUseTurn() {
		return useTurn;
	}

	public void setUseTurn(boolean[] useTurn) {
		this.useTurn = useTurn;
	}

	public String[] getSound() {
		return sound;
	}

	public void setSound(String[] sound) {
		this.sound = sound;
	}

	public int[] getUseCounter() {
		return useCounter;
	}

	public void setUseCounter(int[] useCounter) {
		this.useCounter = useCounter;
	}

	public String getSong() {
		return song;
	}

	public void setSong(String song) {
		this.song = song;
	}

	public int[] getStatusEffect() {
		return statusEffect;
	}

	public void setStatusEffect(int[] statusEffect) {
		this.statusEffect = statusEffect;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String[] getMoves() {
		return moves;
	}
	
	public void setMoves(String[] m) {
		this.moves = m;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public void setDesc(String d) {
		this.desc = d;
	}
	
	
	public static ArrayList<MonsterManager> getEnemies() {
		return enemies;
	}

}
