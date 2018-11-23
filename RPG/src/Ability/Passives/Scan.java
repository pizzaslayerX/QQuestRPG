package Ability.Passives;
import java.awt.Color;
import java.util.Vector;

import Main.Player;
import Run.*;
public class Scan
{
    public static String name = "Scan";
    public static boolean unlock = false;
    public static boolean firstUse = true;

   public static void use()
   {
		if(Monsters.MonsterManager.enemies.size() > 0 && Monsters.MonsterManager.enemies.get(RPGRunner.target).getHealth() > Monsters.MonsterManager.enemies.get(RPGRunner.target).getMaxHealth())
			Monsters.MonsterManager.enemies.get(RPGRunner.target).setHealth(Monsters.MonsterManager.enemies.get(RPGRunner.target).getMaxHealth());
       if(firstUse == true && unlock == true)
       {
           if(List.names.equals("None"))
           List.names = name;
           else
           List.names = List.names + " | " + name;
           firstUse = false;
        }
       if(Monsters.MonsterManager.enemies.size() > 0 &&unlock == true && StatusEffect.Player.silenceActive == false && RPGRunner.battle == true) {
    	   MainFightPanel.enemyStatOutput.setText("");
    	   MainFightPanel.append(MainFightPanel.enemyStatOutput,"" + Monsters.MonsterManager.enemies.get(RPGRunner.target).getName() + " Health: \n");
    	   MainFightPanel.healthDisplay();
    	   RPGRunner.append("\n");
       }
       if(Monsters.MonsterManager.enemies.size() > 0 &&unlock == false && StatusEffect.Player.silenceActive == false) {
    	  if(RPGRunner.minion == false && RPGRunner.battle == true) {
    	   MainFightPanel.enemyStatOutput.setText("");
    	   MainFightPanel.append(MainFightPanel.enemyStatOutput,"" + Monsters.MonsterManager.enemies.get(RPGRunner.target).getName() + " Health: ");
    	   MainFightPanel.append(MainFightPanel.enemyStatOutput,"???",Color.WHITE,20,true);
    	  }
    	 
       }
       if(Monsters.MonsterManager.enemies.size() > 0 &&StatusEffect.Player.silenceActive == true && RPGRunner.battle == true) {
    	   MainFightPanel.enemyStatOutput.setText("");
    	   MainFightPanel.append(MainFightPanel.enemyStatOutput,"" + Monsters.MonsterManager.enemies.get(RPGRunner.target).getName() + " Health: ");
    	   MainFightPanel.append(MainFightPanel.enemyStatOutput,"???",Color.BLUE,20,true);
       }
    }
}
