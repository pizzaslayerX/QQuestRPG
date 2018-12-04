package Ability.Passives;
import java.awt.Color;
import java.util.Vector;

import backend.*;
import gameplay.Player;
public class Scan
{
    public static String name = "Scan";
    public static boolean unlock = false;
    public static boolean firstUse = true;

   public static void use()
   {
		if(monsters.MonsterManager.enemies.size() > 0 && monsters.MonsterManager.enemies.get(RPGRunner.target).getHealth() > monsters.MonsterManager.enemies.get(RPGRunner.target).getMaxHealth())
			monsters.MonsterManager.enemies.get(RPGRunner.target).setHealth(monsters.MonsterManager.enemies.get(RPGRunner.target).getMaxHealth());
       if(firstUse == true && unlock == true)
       {
           if(List.names.equals("None"))
           List.names = name;
           else
           List.names = List.names + " | " + name;
           firstUse = false;
        }
       if(monsters.MonsterManager.enemies.size() > 0 &&unlock == true && statusEffect.Player.silenceActive == false && RPGRunner.battle == true) {
    	   MainFightPanel.enemyStatOutput.setText("");
    	   MainFightPanel.append(MainFightPanel.enemyStatOutput,"" + monsters.MonsterManager.enemies.get(RPGRunner.target).getName() + " Health: \n");
    	   MainFightPanel.healthDisplay();
    	   RPGRunner.append("\n");
       }
       if(monsters.MonsterManager.enemies.size() > 0 &&unlock == false && statusEffect.Player.silenceActive == false) {
    	  if(RPGRunner.minion == false && RPGRunner.battle == true) {
    	   MainFightPanel.enemyStatOutput.setText("");
    	   MainFightPanel.append(MainFightPanel.enemyStatOutput,"" + monsters.MonsterManager.enemies.get(RPGRunner.target).getName() + " Health: ");
    	   MainFightPanel.append(MainFightPanel.enemyStatOutput,"???",Color.WHITE,20,true);
    	  }
    	 
       }
       if(monsters.MonsterManager.enemies.size() > 0 &&statusEffect.Player.silenceActive == true && RPGRunner.battle == true) {
    	   MainFightPanel.enemyStatOutput.setText("");
    	   MainFightPanel.append(MainFightPanel.enemyStatOutput,"" + monsters.MonsterManager.enemies.get(RPGRunner.target).getName() + " Health: ");
    	   MainFightPanel.append(MainFightPanel.enemyStatOutput,"???",Color.BLUE,20,true);
       }
    }
}
