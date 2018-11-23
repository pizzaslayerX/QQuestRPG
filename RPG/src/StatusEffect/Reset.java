package StatusEffect;

import Run.MainFightPanel;
import Run.RPGRunner;

public class Reset
{
   public static void reset()
   {
     
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
       Player.getEffects(1000);
   }
}
