package statusEffect;

import backend.MainFightPanel;
import backend.RPGRunner;

public class Reset
{
   public static void reset()
   {
     
       if(Player.transformActive == true)
       {
       	Player.transformActive = false;
       	MainFightPanel.append(MainFightPanel.user,"\n\nPOOF!!! You turn back to normal!\n");
       	gameplay.Story.pause(2000);
           MainFightPanel.clearDisplay();
           double maxHealth = gameplay.Player.maxHealth * 1.0;
			double percentHealth = (gameplay.Player.health / maxHealth);
   		gameplay.Player.health = (int)(percentHealth * Player.pMaxHealth);
           gameplay.Player.maxHealth = Player.pMaxHealth;
   		gameplay.Player.armorSet[gameplay.Player.equippedArmor].def = Player.pDef;
   		gameplay.Player.armorSet[gameplay.Player.equippedArmor].desc = Player.pDefDesc;
   		gameplay.Player.armorSet[gameplay.Player.equippedArmor].name = Player.pDefName;
   		if(gameplay.Player.health > gameplay.Player.maxHealth)
   			gameplay.Player.health = gameplay.Player.maxHealth;
       }
       Player.getEffects(1000);
       gameplay.Player.baseDmg = 0;
   }
}
