package StatusEffect;

import java.awt.Color;

import Main.Story;
import Run.MainFightPanel;
import Run.RPGRunner;
import Monsters.MonsterManager;

public class Identifier
{
    private static int id;
    private static int dmg;
    private static int duration;
    
   public static void set(int i,int d,int du) throws InterruptedException
   {
   id = i;
   dmg = d;
   duration = du;
    if(id == 1)
    {
        MonsterManager.enemyStatuses.get(RPGRunner.target).startBurn(duration,dmg);
    }
    if(id == 2)
    {
    	MonsterManager.enemyStatuses.get(RPGRunner.target).startSilence(duration,dmg); 
    }
    if(id == 3)
    {
    	MonsterManager.enemyStatuses.get(RPGRunner.target).startStun(duration,dmg);
    }
    if(id == 4)
    {
        Player.startFortify(duration,dmg);
    }
    if(id == 5)
    {
    	MonsterManager.enemyStatuses.get(RPGRunner.target).doMultiHit(duration,dmg);
    }
    if(id == 6)
    {
        Player.startStrength(duration,dmg);
    }
    if(id == 7)
    {
    	MonsterManager.enemyStatuses.get(RPGRunner.target).doManaBurn();
    }
    if(id == 8)
    {
        Player.startHeal(duration,dmg);
    }
    if(id == 9)
    {
        Player.doSacrifice(duration,dmg);
    }
    if(id == 10)
    {
        int gold = (int)(Math.random() * (dmg + 1)) + duration;
        Main.Player.gold = Main.Player.gold + gold;
        MainFightPanel.append(MainFightPanel.user,"\n\nYou stole ");
        MainFightPanel.append(MainFightPanel.user,gold+"",Color.ORANGE,20,true);
        MainFightPanel.append(MainFightPanel.user," gold!\n");
        Story.pause(1500);
        MainFightPanel.clearDisplay();
    }
    if(id == 11)
    {
    	Player.startTransform(duration,dmg);
    }
    if(id == 12)
    {
    	MonsterManager.enemyStatuses.get(RPGRunner.target).startIce(duration,dmg);
    }
    if(id == 13)
    {
    	MonsterManager.enemyStatuses.get(RPGRunner.target).startShock(duration,dmg);
    }
    if(id == 14)
    {
    	MonsterManager.enemyStatuses.get(RPGRunner.target).startPoison(duration,dmg);
    }
    if(id == 15)
    {
    	if(dmg == 0)
    	{
    		MainFightPanel.append(MainFightPanel.user,"\n\nYou're status effects have been removed.\n",Color.MAGENTA,20,false);
            Story.pause(2000);
            MainFightPanel.clearDisplay();
    		   Player.burnActive = false;
    	       Player.iceActive = false;
    	       Player.shockActive = false;
    	       Player.silenceActive = false;
    	       Player.fortifyActive = false;
    	       Player.stunActive = false;
    	       Player.strengthActive = false;
    	       Player.healActive = false;
    	       Player.poisonActive = false;
    	       Player.disableActive = false;
    	       if(Player.transformActive == true)
    	       {
    	       	Player.transformActive = false;
    	       	MainFightPanel.append(MainFightPanel.user,"\n\nPOOF!!! You turn back to normal!\n");
    	       	Main.Story.pause(2000);
    	           MainFightPanel.clearDisplay();
    	           double maxHealth = Main.Player.maxHealth * 1.0;
    				double percentHealth = (Main.Player.health / maxHealth);
    	   		Main.Player.health = (int)(percentHealth * Player.pMaxHealth);
    	           Main.Player.maxHealth = Player.pMaxHealth;
    	   		Main.Player.armor[Main.Player.equippedArmor].def = Player.pDef;
    	   		Main.Player.armor[Main.Player.equippedArmor].desc = Player.pDefDesc;
    	   		Main.Player.armor[Main.Player.equippedArmor].name = Player.pDefName;
    	   		if(Main.Player.health > Main.Player.maxHealth)
    	   			Main.Player.health = Main.Player.maxHealth;
    	       }
    	}
    	else if(dmg == 1)
    	{
    		MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\n"+Monsters.MonsterManager.enemies.get(RPGRunner.monsterTurn).getName() + "'s status effects have been removed.\n",Color.MAGENTA,20,false);
            Story.pause(2000);
            MainFightPanel.clearEnemyDisplay();
            MonsterManager.enemyStatuses.get(RPGRunner.target).burnActive = false;
            MonsterManager.enemyStatuses.get(RPGRunner.target).iceActive = false;
            MonsterManager.enemyStatuses.get(RPGRunner.target).shockActive = false;
            MonsterManager.enemyStatuses.get(RPGRunner.target).silenceActive = false;
            MonsterManager.enemyStatuses.get(RPGRunner.target).fortifyActive = false;
            MonsterManager.enemyStatuses.get(RPGRunner.target).stunActive = false;
            MonsterManager.enemyStatuses.get(RPGRunner.target).strengthActive = false;
            MonsterManager.enemyStatuses.get(RPGRunner.target).healActive = false;
 	      MonsterManager.enemyStatuses.get(RPGRunner.target).poisonActive = false;
 	      // Monster.disableActive = false;
    	}
    	else
    	{
    		MainFightPanel.append(MainFightPanel.enemyStatOutput,"\n\nAll status effects have been removed.\n",Color.MAGENTA,20,false);
    		MainFightPanel.append(MainFightPanel.user,"\n\nAll status effects have been removed.\n",Color.MAGENTA,20,false);
            Story.pause(2000);
            MainFightPanel.clearDisplay();
            MainFightPanel.clearEnemyDisplay();
    		Reset.reset();
    	}
    }
    if(id == 16)
    {
    	Player.startDisable(duration, dmg);
    }
    
    if(id == 20)
    {
    	MonsterManager.enemyStatuses.get(RPGRunner.target).startBurnResist(duration,dmg);
    }
    if(id == 21)
    {
    	MonsterManager.enemyStatuses.get(RPGRunner.target).startIceResist(duration,dmg);
    }
    if(id == 22)
    {
    	MonsterManager.enemyStatuses.get(RPGRunner.target).startShockResist(duration,dmg);
    }
    if(id == 23)
    {
    	MonsterManager.enemyStatuses.get(RPGRunner.target).startBurnWeak(duration,dmg);
    }
    if(id == 24)
    {
    	MonsterManager.enemyStatuses.get(RPGRunner.target).startIceWeak(duration,dmg);
    }
    if(id == 25)
    {
    	MonsterManager.enemyStatuses.get(RPGRunner.target).startShockWeak(duration,dmg);
    }
    if(id == 26)
    {
    	Player.startBurnResist(duration, dmg);
    }
    if(id == 27)
    {
    	Player.startIceResist(duration, dmg);
    }
    if(id == 28)
    {
    	Player.startShockResist(duration, dmg);
    }
    if(id == 29)
    {
    	Player.startBurnWeak(duration, dmg);
    }
    if(id == 30)
    {
    	Player.startIceWeak(duration, dmg);
    }
    if(id == 31)
    {
    	Player.startShockWeak(duration, dmg);
    }
    
   
    if(id == 40)
    {
    	MonsterManager.enemyStatuses.get(RPGRunner.target).startFortify(duration, dmg);
    }
    if(id == 41)
    {
    	MonsterManager.enemyStatuses.get(RPGRunner.target).startFragility(duration, dmg);
    }
    if(id == 42)
    {
    	Player.startFragility(duration, dmg);
    }
    if(id == 43)
    {
    	MonsterManager.enemyStatuses.get(RPGRunner.target).startWeak(duration, dmg);
    }
    if(id == 44)
    {
    	Player.startWeak(duration, dmg);
    }
    
    
    if(id == 60)
    {
    	MonsterManager.enemyStatuses.get(RPGRunner.target).startStrength(duration, dmg);
    }
    if(id == 61)
    {
    	Player.startIce(duration,dmg);
    }
    if(id == 62)
    {
    	Player.startShock(duration,dmg);
    }
    if(id == 63)
    {
    	Player.startPoison(duration,dmg);
    }
    if(id == 64)
    {
    	Player.startBurn(duration,dmg);
    }
    if(id == 65)
    {
    	Player.startSilence(duration,dmg);
    }
    if(id == 66)
    {
       Player.doMultiHit(duration,dmg);
    }
    if(id == 67)
    {
    	MonsterManager.enemyStatuses.get(RPGRunner.target).startHeal(duration,dmg);
    }
    if(id == 68)
    {
        Player.startStun(duration,dmg);
    }
    }
}
