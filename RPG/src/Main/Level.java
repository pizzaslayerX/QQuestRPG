package Main;
import Ability.Actives.DrainTouch;
import Ability.Actives.Fury;
import Armor.Gem;
import Run.*;
public class Level
{
    public static RPGRunner run;
    public Level(RPGRunner r)
    {
        this.run = r;
    }
   
    
    
    public static void getLevelReward() throws InterruptedException
    {
        run.getReset();
        Playlist.playEffect("/sounds/LevelUp.wav");
        while(Player.exp >= Player.levelUpExp)
       {
        if(Player.level == 2)
        {
            RPGRunner.append("~~~~~YOU LEVELED UP~~~~~\n\n");
            RPGRunner.append("Gold x30\n");
            RPGRunner.append("Max Health + 3\n");
            RPGRunner.append("Health Fully Restored!\n\n");
            Player.maxHealth = Player.maxHealth + 3;
            Player.health = Player.maxHealth;
            Player.gold = Player.gold + 30;
            Player.levelUpExp = 15;
            Player.title = "Novice";
            RPGRunner.append("Select NEW Ability [1] [2]\n");
            RPGRunner.append("[1] Scan[Passive]: Allows detection of enemy HP\n");
            RPGRunner.append("[2] Burst[Active]: Deals 5 pure Dmg without using a turn\n\n");
            int choose = run.getInt();
            if(choose == 1)
            {
                Ability.Passives.Scan.unlock = true;
                RPGRunner.append("You unlocked Scan\n");
            }
            else
            {
                Ability.Actives.Burst.equip();
                RPGRunner.append("You unlocked Burst\n");
            }
            Player.userWait();
            RPGRunner.output.setText("");
            contLevelUp();
        }
        if(Player.level == 3)
        {
            RPGRunner.append("~~~~~YOU LEVELED UP~~~~~\n\n");
            RPGRunner.append("Gold x30\n");
            RPGRunner.append("Elixer x1\n");
            RPGRunner.append("New Ability Learned: Libra\n");
            RPGRunner.append("Max Health + 5\n");
            RPGRunner.append("Health Fully Restored!\n\n");
            Player.maxHealth = Player.maxHealth + 5;
            Player.health = Player.maxHealth;
            Player.gold = Player.gold + 30;
            Player.title = "Learner";
            Player.levelUpExp = 45;
        	Ability.Actives.Libra.equip();
            RPGRunner.append("Select NEW Ability [1] [2]\n");
            RPGRunner.append("[1] Snowball[Active]: Deals 6 frost dmg\n");
            RPGRunner.append("[2] Sparky Sparks[Active]: Deals 9 shock dmg over 3 turns\n\n");
            int choose = run.getInt();
            if(choose == 1)
            {
                Ability.Actives.SnowBall.equip();
                RPGRunner.append("You unlocked Snowball\n");
            }
            else
            {
                Ability.Actives.Sparks.equip();
                RPGRunner.append("You unlocked Sparky Sparks\n");
            }
            Player.userWait();
            RPGRunner.output.setText("");
            Item.Elixer.newItem();
            contLevelUp();
        }
        if(Player.level == 4)
        {
            RPGRunner.append("~~~~~YOU LEVELED UP~~~~~\n\n");
            RPGRunner.append("Gold x50\n");
            RPGRunner.append("Max Health + 5\n");
            RPGRunner.append("Health Fully Restored!\n\n");
            Player.maxHealth = Player.maxHealth + 5;
            Player.levelUpExp = 90;
            Player.health = Player.maxHealth;
            Player.gold = Player.gold + 50;
             RPGRunner.append("Select NEW Ability [1] [2]\n");
            RPGRunner.append("[1] Vigor[perk]: +10% Max Health\n");
            RPGRunner.append("[2] Ignite[active]: Deals 15 fire dmg over 5 turns\n\n");
            int choose = run.getInt();
            if(choose == 1)
            {
                Player.maxHealth = Player.maxHealth + (Player.maxHealth / 10);
                Player.health = Player.maxHealth;
                RPGRunner.append("Max Health increased by 10%\n");
            }
            else
            {
                Ability.Actives.Ignite.equip();
                RPGRunner.append("You unlocked Ignite\n");
            }
             Player.userWait();
            RPGRunner.output.setText("");
            contLevelUp();
        }
        if(Player.level == 5)
        {
             RPGRunner.append("~~~~~YOU LEVELED UP~~~~~\n\n");
            RPGRunner.append("Gold x100\n");
            RPGRunner.append("Max Health + 5\n");
            RPGRunner.append("Health Fully Restored!\n\n");
            Player.maxMana = Player.maxMana + 10;
            Player.mana = Player.maxMana;
            Player.maxHealth = Player.maxHealth + 5;
            Player.health = Player.maxHealth;
            Player.gold = Player.gold + 100;
            Player.title = "Apprentice";
            Player.levelUpExp = 127;
             RPGRunner.append("Select NEW Ability/Perk [1] [2] [3]\n");
            RPGRunner.append("[1] Vigor[perk]: +10% Max Health\n");
            RPGRunner.append("[2] Nova[active]: Deals 10 pure Dmg without using a turn\n");
            RPGRunner.append("[3] Draining Touch[active]: Deals 8 Dmg and heals 10 HP | Costs 12 mana\n\n");
            int choose = run.getInt();
            if(choose == 1)
            {
                Player.maxHealth = Player.maxHealth + (Player.maxHealth / 10);
                Player.health = Player.maxHealth;
                RPGRunner.append("Max Health increased by 10%\n");
            }
            else if(choose == 2)
            {
                Ability.Actives.Nova.equip();
                RPGRunner.append("You unlocked Nova\n");
            }
            else{
                  Ability.Actives.DrainTouch.equip();
                  RPGRunner.append("You unlocked Draining Touch\n");
            }
             Player.userWait();
            RPGRunner.output.setText("");
                       contLevelUp();
        }
            
         if(Player.level == 6)
        {
             RPGRunner.append("~~~~~YOU LEVELED UP~~~~~\n\n");
            RPGRunner.append("Gold x50\n");
            RPGRunner.append("Max Health + 5\n");
            RPGRunner.append("Max Mana + 10\n");
             Player.maxMana = Player.maxMana + 10;
            Player.mana = Player.maxMana;
            RPGRunner.append("Health and Mana Fully Restored!\n\n");
            Player.mana = Player.maxMana;
            Player.maxHealth = Player.maxHealth + 5;
            Player.health = Player.maxHealth;
            Player.gold = Player.gold + 50;
            Player.levelUpExp = 190;
             RPGRunner.append("Select NEW Ability/Perk [1] [2] [3] [4]\n");
            RPGRunner.append("[1] Vigor+[perk]: +20% Max Health\n");
            RPGRunner.append("[2] Silence[active]: Prevents enemies from using abilities for 1 turn\n");
            RPGRunner.append("[3] Sword Art[active]: Deals 13 dmg without using a turn.\n");
            RPGRunner.append("[4] Wisened[perk]: +15 Max Mana\n\n ");
            int choose = run.getInt();
            if(choose == 1)
            {
                Player.maxHealth = Player.maxHealth + (Player.maxHealth / 5);
                Player.health = Player.maxHealth;
                RPGRunner.append("Max Health increased by 20%\n");
            }
            else if(choose == 2)
            {
                Ability.Actives.Silence.equip();
                RPGRunner.append("You unlocked Silence\n");
            }
            else if(choose == 3){
                  Ability.Actives.SwordArt.equip();
                  RPGRunner.append("You unlocked Sword Art\n");
            }
            else
            {
                Player.maxMana = Player.maxMana + 15;
                Player.mana = Player.maxMana;
                RPGRunner.append("Max Mana increased by 15\n");
            }
             Player.userWait();
            RPGRunner.output.setText("");
                       contLevelUp();
        }
        
         if(Player.level == 7)
        {
             RPGRunner.append("~~~~~YOU LEVELED UP~~~~~\n\n");
            RPGRunner.append("Gold x50\n");
            RPGRunner.append("Max Health + 3\n");
            RPGRunner.append("Max Mana + 5\n");
            RPGRunner.append("Health and Mana Fully Restored!\n\n");
            Player.maxMana = Player.maxMana + 5;
            Player.mana = Player.maxMana;
            Player.maxHealth = Player.maxHealth + 3;
            Player.health = Player.maxHealth;
            Player.gold = Player.gold + 50;
            Player.levelUpExp = 245;
             RPGRunner.append("Select NEW Ability/Perk [1] [2] [3]\n");
            RPGRunner.append("[1] Evade[passive]: 15% chance to dodge an enemy attack.\n");
            RPGRunner.append("[2] Elixer[item]: Restores max health and max mana. Re-do Turn.\n");
            RPGRunner.append("[3] Foritfy[active]: Increase defense by 15% for 3 turns | Costs 25 mana\n");
            int choose = run.getInt();
            if(choose == 1)
            {
                Ability.Passives.Evade.unlock = true;
                RPGRunner.append("\nYou unlocked Evade!\n");
                Ability.Passives.Evade.use();
            }
            else if(choose == 2)
            {
                Item.Elixer.newItem();
                RPGRunner.append("You obtained Elixer x1\n");
            }
            else{
                  Ability.Actives.Fortify.equip();
                  RPGRunner.append("You unlocked Fortify!\n");
            }
             Player.userWait();
            RPGRunner.output.setText("");
                       contLevelUp();
        }
        
        if(Player.level == 8)
        {
            RPGRunner.append("~~~~~YOU LEVELED UP~~~~~\n\n");
            RPGRunner.append("Gold x200\n");
            RPGRunner.append("Max Health + 5\n");
            RPGRunner.append("Health Fully Restored!\n\n");
            Player.maxHealth = Player.maxHealth + 5;
            Player.health = Player.maxHealth;
            Player.gold = Player.gold + 200;
            Player.title = "Explorer";
            Player.levelUpExp = 300;
            Player.userWait();
            RPGRunner.output.setText("");
            Item.Ultramarine.newItem();
            contLevelUp();
        }
        
         if(Player.level == 9)
        {
             RPGRunner.append("~~~~~YOU LEVELED UP~~~~~\n\n");
            RPGRunner.append("Gold x50\n");
            RPGRunner.append("Max Health + 3\n");
            RPGRunner.append("Health and Mana Fully Restored!\n\n");
            Player.maxHealth = Player.maxHealth + 3;
            Player.health = Player.maxHealth;
            Player.gold = Player.gold + 50;
            Player.levelUpExp = 380;
             RPGRunner.append("Select NEW Ability/Perk [1] [2] [3]\n");
            RPGRunner.append("[1] Silence II[active]: Enemies can't use abilities for 3 turns | Costs 7 mana\n");
            RPGRunner.append("[2] Wisened[perk]: +15 Max Mana\n");
            RPGRunner.append("[3] Cure+[active]: Heals 25% of health without using a turn | Costs 50 mana\n");
            int choose = run.getInt();
            if(choose == 1)
            {
                Ability.Actives.SilenceTwo.equip();
                RPGRunner.append("You unlocked SilenceII!\n");
            }
            else if(choose == 2)
            {
                Player.maxMana = Player.maxMana + 15; 
                Player.mana = Player.maxMana;
                RPGRunner.append("Max Mana increased by 15.\n");
            }
            else{
                  Ability.Actives.CurePlus.equip();
                  RPGRunner.append("You unlocked Cure+!\n");
            }
             Player.userWait();
            RPGRunner.output.setText("");
                       contLevelUp();
        }
        if(Player.level == 10)
        {
            Player.title = "Journeyman";
             RPGRunner.append("~~~~~YOU LEVELED UP~~~~~\n\n");
            RPGRunner.append("Gold x100\n");
            RPGRunner.append("Max Health + 10\n");
            RPGRunner.append("Max Mana + 10\n");
            RPGRunner.append("Health and Mana Fully Restored!\n\n");
            Player.maxHealth = Player.maxHealth + 10;
            Player.health = Player.maxHealth;
            Player.maxMana = Player.maxMana + 10;
            Player.mana = Player.maxMana;
            Player.gold = Player.gold + 100;
            Player.levelUpExp = 500;
            if(Ability.Passives.Scan.unlock == false)
            {
             RPGRunner.append("Select NEW Ability/Perk [1] [2] [3]\n");
            RPGRunner.append("[1] Scan[passive]: Allows detection of enemy HP\n");
            RPGRunner.append("[2] Wisened+[perk]: +25 Max Mana\n");
            RPGRunner.append("[3] Back Kick Combo[active]: Hits twice. Deals 12-20 dmg. Stuns for 1 turn.\n");
            int choose = run.getInt();
            if(choose == 1)
            {
                Ability.Passives.Scan.unlock = true;
                RPGRunner.append("You unlocked Scan\n");
            }
            else if(choose == 2)
            {
                Player.maxMana = Player.maxMana + 25; 
                Player.mana = Player.maxMana;
                RPGRunner.append("Max Mana increased by 25.\n");
            }
            else{
                  Ability.Actives.BackKick.equip();
                  RPGRunner.append("You unlocked Back Kick Combo!\n");
            }
           }
           else
           {
               RPGRunner.append("Select NEW Ability/Perk [1] [2] [3]\n");
            RPGRunner.append("[1] Brilliance[active]: Heals 16 HP. Stuns for 1 turn | Costs 28 mana\n");
            RPGRunner.append("[2] Wisened[perk]: +15 Max Mana\n");
            RPGRunner.append("[3] Back Kick Combo[active]: Hits twice. Deals 12-20 dmg. Stuns for 1 turn.\n");
            int choose = run.getInt();
            if(choose == 1)
            {
                Ability.Actives.Brilliance.equip();
                RPGRunner.append("You unlocked Brilliance\n");
            }
            else if(choose == 2)
            {
                Player.maxMana = Player.maxMana + 15; 
                Player.mana = Player.maxMana;
                RPGRunner.append("Max Mana increased by 15.\n");
            }
            else{
                  Ability.Actives.BackKick.equip();
                  RPGRunner.append("You unlocked Back Kick Combo!\n");
            }
               
               
            }
             Player.userWait();
            RPGRunner.output.setText("");
                       contLevelUp();
        }
         if(Player.level == 11)
        {
             RPGRunner.append("~~~~~YOU LEVELED UP~~~~~\n\n");
            RPGRunner.append("Gold x50\n");
            RPGRunner.append("Max Health + 3\n");
            RPGRunner.append("Max Mana + 10\n");
            RPGRunner.append("Health and Mana Fully Restored!\n\n");
            Player.maxHealth = Player.maxHealth + 3;
            Player.health = Player.maxHealth;
            Player.maxMana = Player.maxMana + 10;
            Player.mana = Player.maxMana;
            Player.gold = Player.gold + 50;
            Player.levelUpExp = 650;
            if(Ability.Passives.Evade.unlock == false)
            {
             RPGRunner.append("Select NEW Ability/Perk [1] [2] [3]\n");
            RPGRunner.append("[1] Evade[passive]: 15% chance to dodge an enemy attack\n");
            RPGRunner.append("[2] Elixer[item]: Fully maxes out HP and Mana. Re-Do turn.\n");
            RPGRunner.append("[3] Eruption[active]: Does 12 pure damage and inflicts 45 damage over 3 turns | Costs 50 mana\n");
            int choose = run.getInt();
            if(choose == 1)
            {
                Ability.Passives.Evade.unlock = true;
                RPGRunner.append("You unlocked Evade\n");
            }
            else if(choose == 2)
            {
                RPGRunner.append("Obtained: Elixer x1\n");
                Item.Elixer.newItem();
            }
            else{
                  Ability.Actives.Eruption.equip();
                  RPGRunner.append("You unlocked Eruption!\n");
            }
           }
           else if(Ability.Passives.Evade.unlock == true && Player.checkAbility(DrainTouch.class) == true)
           {
               RPGRunner.append("Select NEW Ability/Perk [1] [2] [3]\n");
            RPGRunner.append("[1] Reaper's Call[active]: Deals 15 Pure dmg, heals 20 HP, +3 dmg for 1 turn. | Cost: 35 Mana\n");
            RPGRunner.append("[2] Triple Threat[active]: Silience, Stun, and Increase def by 10% for 2 turns. | Costs 42 mana\n");
            RPGRunner.append("[3] Eruption[active]: Does 12 pure damage and inflicts 45 damage over 3 turns | Costs 50 mana\n");
            int choose = run.getInt();
            if(choose == 1)
            {
                Ability.Actives.Reaper.equip();
                RPGRunner.append("You unlocked Reaper's Call\n");
            }
            else if(choose == 2)
            {
                Ability.Actives.TripleThreat.equip();
                RPGRunner.append("You unlocked Triple Threat!\n");
            }
            else{
                  Ability.Actives.Eruption.equip();
                  RPGRunner.append("You unlocked Eruption!\n");
            }
            }
           else{
               RPGRunner.append("Select NEW Ability/Perk [1] [2] [3]\n");
            RPGRunner.append("[1] Triple Threat[active]: Silience, Stun, and Increase def by 10% for 2 turns. | Costs 42 mana\n");
            RPGRunner.append("[2] Elixer[Item]: Fully maxes out HP and Mana. Re-Do turn.\n");
            RPGRunner.append("[3] Eruption[active]: Does 12 pure damage and inflicts 45 damage over 3 turns | Costs 50 mana\n");
            int choose = run.getInt();
            if(choose == 1)
            {
                Ability.Actives.TripleThreat.equip();
                RPGRunner.append("You unlocked Triple Threat!\n");
            }
            else if(choose == 2)
            {
                RPGRunner.append("Obtained: Elixer x1\n");
                Item.Elixer.newItem();
            }
            else{
                  Ability.Actives.Eruption.equip();
                  RPGRunner.append("You unlocked Eruption!\n");
            }
            }
             Player.userWait();
            RPGRunner.output.setText("");
                       contLevelUp();
        }
        if(Player.level == 12)
        {
            RPGRunner.append("~~~~~YOU LEVELED UP~~~~~\n\n");
            RPGRunner.append("Gold x150\n");
            RPGRunner.append("Max Health + 5\n");
            RPGRunner.append("Max Mana + 5\n");
            RPGRunner.append("Received: Chronic Stone x1\n");
            BackPack.Manager.add("Chronic Stone", 1);
            new Gem(Gem.Type.TIME,1).equip(Player.armor[Player.equippedArmor]);
            RPGRunner.append("Health and Mana Fully Restored!\n\n");
            Player.maxMana = Player.maxMana + 5;
            Player.mana = Player.maxMana;
            Player.maxHealth = Player.maxHealth + 5;
            Player.health = Player.maxHealth;
            Player.gold = Player.gold + 150;
            Player.levelUpExp = 800;
             RPGRunner.append("Select NEW Ability/Perk [1] [2] [3]\n");
            RPGRunner.append("[1] Focus[active]: Heals 12% of HP and +5 dmg for 2 turns. | Costs 27 mana\n");
            RPGRunner.append("[2] Wisened+[Perk]: +25 Max Mana\n");
            RPGRunner.append("[3] Fiery Aura[active]: Defense +5% for 5 turns and deals 50 dmg over 5 turns | Costs 40 mana\n");
            int choose = run.getInt();
            if(choose == 1)
            {
                RPGRunner.append("\nYou unlocked Focus\n");
                Ability.Actives.Focus.equip();
            }
            else if(choose == 2)
            {
                Player.maxMana = Player.maxMana + 25;
                Player.mana = Player.maxMana;
                RPGRunner.append("Max Mana increased by 25.\n");
            }
            else{
                  RPGRunner.append("You unlocked Fiery Aura\n");
                  Ability.Actives.FireShield.equip();
            }
             Player.userWait();
            RPGRunner.output.setText("");
                       contLevelUp();
            
        }
        if(Player.level == 13)
        {
            Player.title = "Hunter";
            RPGRunner.append("~~~~~YOU LEVELED UP~~~~~\n\n");
            RPGRunner.append("Gold x200\n");
            RPGRunner.append("Max Health + 5\n");
            RPGRunner.append("Max Mana + 10\n");
            RPGRunner.append("Health and Mana Fully Restored!\n\n");
            Player.maxMana = Player.maxMana + 10;
            Player.mana = Player.maxMana;
            Player.maxHealth = Player.maxHealth + 5;
            Player.health = Player.maxHealth;
            Player.gold = Player.gold + 200;
            Player.levelUpExp = 1000;
             RPGRunner.append("Select NEW Ability/Perk [1] [2]\n");
            RPGRunner.append("[1] Vigor[perk]: +10% Max Health\n");
            RPGRunner.append("[2] Spirit Blade[active]: Deals 25 dmg and Silences for 2 turn without using a turn\n");
            int choose = run.getInt();
            if(choose == 1)
            {
                Player.maxHealth = Player.maxHealth + (Player.maxHealth / 10);
                Player.health = Player.maxHealth;
                RPGRunner.append("Max Health increased by 10%\n");
            }
            else{
                  Ability.Actives.SpiritBlade.equip();
                  RPGRunner.append("You unlocked Spirit Blade!\n");
            }
             Player.userWait();
            RPGRunner.output.setText("");
                       contLevelUp();
            
        }
        if(Player.level == 14)
        {
            RPGRunner.append("~~~~~YOU LEVELED UP~~~~~\n\n");
            RPGRunner.append("Gold x200\n");
            RPGRunner.append("Max Health + 3\n");
            RPGRunner.append("Health and Mana Fully Restored!\n\n");
            Player.mana = Player.maxMana;
            Player.maxHealth = Player.maxHealth + 3;
            Player.health = Player.maxHealth;
            Player.gold = Player.gold + 200;
            Player.levelUpExp = 1285;
             RPGRunner.append("Select NEW Ability/Perk [1] [2]\n");
            RPGRunner.append("[1] Cross Slash[active]: Hits 4 times. Deals 20-44 dmg\n");
            RPGRunner.append("[2] Fury[active]: +18 dmg and +13% defense for 1 turn\n");
            int choose = run.getInt();
            if(choose == 1)
            {
                Ability.Actives.CrossSlash.equip();
                RPGRunner.append("You unlocked Cross Slash!\n");
            }
            else{
                  Ability.Actives.Fury.equip();
                  RPGRunner.append("You unlocked Fury!\n");
            }
             Player.userWait();
            RPGRunner.output.setText("");
                       contLevelUp();
            
        }
        if(Player.level == 15)
        {
           
            RPGRunner.append("~~~~~YOU LEVELED UP~~~~~\n\n");
            RPGRunner.append("Gold x300\n");
            RPGRunner.append("Max Health + 10\n");
            RPGRunner.append("Max Mana + 10\n");
            RPGRunner.append("Health and Mana Fully Restored!\n\n");
            Player.maxMana = Player.maxMana + 10;
            Player.mana = Player.maxMana;
            Player.maxHealth = Player.maxHealth + 10;
            Player.health = Player.maxHealth;
            Player.gold = Player.gold + 300;
            Player.levelUpExp = 1650;
             RPGRunner.append("Select NEW Ability/Perk [1] [2] [3]\n");
            RPGRunner.append("[1] Mana Burn[active]: Deals remaining mana as pure dmg. | Cost Varies\n");
            RPGRunner.append("[2] Vigor[perk]: +10% Max Health\n");
            RPGRunner.append("[3] Helping Hands[active]: Heals 20 HP. Heals another 42 HP over 6 turns  | Cost: 56 Mana\n");
            int choose = run.getInt();
            if(choose == 1)
            {
                Ability.Actives.ManaBurn.equip();
                RPGRunner.append("You unlocked Mana Burn!\n");
            }
            else if(choose == 2){
                                  Player.maxHealth = Player.maxHealth + (Player.maxHealth / 10);
                Player.health = Player.maxHealth;
                RPGRunner.append("Max Health increased by 10%\n");
            }
            else
            {
                Ability.Actives.HelpingHands.equip();
                RPGRunner.append("You unlocked Helping Hands!\n");
            }
             if(Player.maxMana > 120)
                Player.title = "Wizard";
             else
                Player.title = "Warrior";
             Player.userWait();
            RPGRunner.output.setText("");
                       contLevelUp();
            
        }
        if(Player.level == 16)
        {
           
            RPGRunner.append("~~~~~YOU LEVELED UP~~~~~\n\n");
            RPGRunner.append("Gold x180\n");
            RPGRunner.append("Item slot +1\n");
            RPGRunner.append("Max Health + 10\n");
            RPGRunner.append("Max Mana + 8\n");
            RPGRunner.append("Health and Mana Fully Restored!\n\n");
            Item.ItemManager.slot4unlock = true;
            Item.ItemManager.slotCount = 4;
            Player.maxMana = Player.maxMana + 8;
            Player.mana = Player.maxMana;
            Player.maxHealth = Player.maxHealth + 10;
            Player.health = Player.maxHealth;
            Player.gold = Player.gold + 180;
            Player.levelUpExp = 1900;
             RPGRunner.append("Select NEW Ability/Perk [1] [2] [3]\n");
            RPGRunner.append("[1] Wisened[perk]: +15 Max Mana\n");
            RPGRunner.append("[2] Vigor[perk]: +10% Max Health\n");
            RPGRunner.append("[3] Treasure![bonus]: +1000 Gold\n");
            int choose = run.getInt();
            if(choose == 1)
            {
                Player.maxMana = Player.maxMana + 15;
                Player.mana = Player.maxMana;
                RPGRunner.append("Max Mana increased by 15.\n");
            }
            else if(choose == 2){
                                  Player.maxHealth = Player.maxHealth + (Player.maxHealth / 10);
                Player.health = Player.maxHealth;
                RPGRunner.append("Max Health increased by 10%\n");
            }
            else
            {
                Player.gold = Player.gold + 1000;
                RPGRunner.append("You gained: 1000 Gold!\n");
            }
        }
        if(Player.level == 17)
        {
            if(Player.checkAbility(Fury.class) == true)
           {
               RPGRunner.append("~~~~~YOU LEVELED UP~~~~~\n\n");
            RPGRunner.append("Gold x350\n");
            RPGRunner.append("Max Health + 5\n");
            RPGRunner.append("Max Mana + 15\n");
            RPGRunner.append("Health and Mana Fully Restored!\n\n");
            Player.maxMana = Player.maxMana + 15;
            Player.mana = Player.maxMana;
            Player.maxHealth = Player.maxHealth + 5;
            Player.health = Player.maxHealth;
            Player.gold = Player.gold + 350;
            Player.levelUpExp = 2220;
             RPGRunner.append("Select NEW Ability/Perk [1] [2] [3]\n");
            RPGRunner.append("[1] Fatal Blow[active]: Deals 50 dmg without using a turn\n");
            RPGRunner.append("[2] Empower[perk]: Permanently increase all weapon damage by 5.\n");
            RPGRunner.append("[3] Feint[active]: +35 dmg for 1 turn. Costs 20 HP.\n");
            int choose = run.getInt();
            if(choose == 1)
            {
                Ability.Actives.FatalBlow.equip();
                RPGRunner.append("You learned Fatal Blow!\n");
            }
            else if(choose == 2){
                Weapon.WeaponManager.strPlus = Weapon.WeaponManager.strPlus + 5;
                RPGRunner.append("Damage bonus increased by 5!\n");
            }
            else
            {
                 Ability.Actives.Feint.equip();
                RPGRunner.append("You learned Feint!");
            }
            }
           else
           {
            RPGRunner.append("~~~~~YOU LEVELED UP~~~~~\n\n");
            RPGRunner.append("Gold x350\n");
            RPGRunner.append("Max Health + 5\n");
            RPGRunner.append("Max Mana + 15\n");
            RPGRunner.append("Health and Mana Fully Restored!\n\n");
            Player.maxMana = Player.maxMana + 15;
            Player.mana = Player.maxMana;
            Player.maxHealth = Player.maxHealth + 5;
            Player.health = Player.maxHealth;
            Player.gold = Player.gold + 350;
            Player.levelUpExp = 2220;
             RPGRunner.append("Select NEW Ability/Perk [1] [2]\n");
            RPGRunner.append("[1] Thunder[active]: Deals 33 shock dmg. Stuns for 3 turns\n");
            RPGRunner.append("[2] Empower[perk]: Permanently increase all weapon damage by 5.\n");
            
            int choose = run.getInt();
            if(choose == 1)
            {
                Ability.Actives.Thunder.equip();
                RPGRunner.append("You learned Thunder!\n");
            }
            else{
                Weapon.WeaponManager.strPlus = Weapon.WeaponManager.strPlus + 5;
                RPGRunner.append("Damage bonus increased by 5!\n");
            }

         }
        }
        if(Player.level == 18)
        {
           
           if(Player.title.equals("Warrior"))
           {
               Player.title = "Brute";
            RPGRunner.append("~~~~~YOU LEVELED UP~~~~~\n\n");
            RPGRunner.append("Gold x400\n");
            RPGRunner.append("Max Health + 20\n");
            RPGRunner.append("Health and Mana Fully Restored!\n\n");
            Player.mana = Player.maxMana;
            Player.maxHealth = Player.maxHealth + 20;
            Player.health = Player.maxHealth;
            Player.gold = Player.gold + 400;
            Player.levelUpExp = 2500;
             RPGRunner.append("Select NEW Ability/Perk [1] [2] [3] [4]\n");
             RPGRunner.append("[1] Plague[active]: Deals 8 poison dmg per turn until 25% of enemy max health is lost from posion dmg.\n");
            RPGRunner.append("[2] Empower+[perk]: Permanently increase base damage by 15.\n");
            RPGRunner.append("[3] Feint[active]: +35 dmg for 2 turns. Stuns for 1 turn. Costs 20 HP.\n");
            RPGRunner.append("[4] Untouchable![active]: +40 def for 2 turns. Silences for 2 turns. | Cost: 100 Mana\n");
            int choose = run.getInt();
            if(choose == 1)
            {
                Ability.Actives.Plague.equip();;
                RPGRunner.append("You learned Plague!\n");
            }
            else if(choose == 2)
            {
                Weapon.WeaponManager.strPlus = Weapon.WeaponManager.strPlus + 15;
                RPGRunner.append("Damage bonus increased by 15!\n");
            }
            else if(choose == 3)
            {
                 Ability.Actives.Feint.equip();
                RPGRunner.append("You learned Feint!");
            }
            else
            {
            	Player.title = "Tank";
            	Ability.Actives.Untouchable.equip();
                RPGRunner.append("You learned Untouchable!");
            }
          }
          else if(Player.title.equals("Wizard"))
           {
               Player.title = "Magus";
            RPGRunner.append("~~~~~YOU LEVELED UP~~~~~\n\n");
            RPGRunner.append("Gold x400\n");
            RPGRunner.append("Max Mana + 35\n");
            RPGRunner.append("Health and Mana Fully Restored!\n\n");
            Player.maxMana = Player.maxMana + 35;
            Player.mana = Player.maxMana;
            Player.health = Player.maxHealth;
            Player.gold = Player.gold + 400;
            Player.levelUpExp = 2500;
             RPGRunner.append("Select NEW Ability [1] [2] [3] [4]\n");
            RPGRunner.append("[1] Plague[active]: Deals 8 poison dmg per turn until 25% of enemy max health is lost from posion dmg.\n");
            RPGRunner.append("[2] Hellish Void[active]: Silence for 3 turns. Deals 198 fire dmg over 6 turns. | Cost: 185 mana\n");
            RPGRunner.append("[3] Arctic Storm[active]: +20 def for 3 turns. Deals 180 frost dmg over 8 turns. | Cost: 160 mana\n");
            RPGRunner.append("[4] Frakenstein's Delight[active]: Deals 144 shock dmg. +5 dmg and Stuns for 3 turns. | Cost: 69 health\n");
            int choose = run.getInt();
            if(choose == 1)
            {
            	RPGRunner.append("You learned Plague!\n");
                Ability.Actives.Plague.equip();
                
            }
            else if(choose == 2)
            {
            	Player.title = "Pyromancer";
            	RPGRunner.append("You learned Hellish Void!\n");
                Ability.Actives.HellVoid.equip();
                
            }
            else if(choose == 3)
            {
            	Player.title = "Cryomancer";
            	RPGRunner.append("You learned Arctic Storm!\n");
                Ability.Actives.ArcticStorm.equip();
                
            }
            else
            {
            	Player.title = "Electromancer";
            	RPGRunner.append("You learned Frakenstein's Delight!\n");
                Ability.Actives.Frankenstein.equip();
                
            }
          }
        }
        if(Player.level == 19)
        {
           
            RPGRunner.append("~~~~~YOU LEVELED UP~~~~~\n\n");
            RPGRunner.append("Gold x250\n");
            RPGRunner.append("Mega Potion x1\n");
            RPGRunner.append("Max Health + 10\n");
            RPGRunner.append("Max Mana + 10\n");
            RPGRunner.append("Health and Mana Fully Restored!\n\n");
            Player.maxMana = Player.maxMana + 10;
            Item.MegaPotion.newItem();
            Player.mana = Player.maxMana;
            Player.maxHealth = Player.maxHealth + 10;
            Player.health = Player.maxHealth;
            Player.gold = Player.gold + 250;
            Player.levelUpExp = 2800;
             RPGRunner.append("Select NEW Ability/Perk [1] [2] [3] [4]\n");
            RPGRunner.append("[1] Polymorph[active]: Transform into the enemy for 3 turns. Does not use turn.\n");
            RPGRunner.append("[2] Lucky Lucky[passive]: Increases all gold found in chests by 20%\n");
            RPGRunner.append("[3] Midas Touch[passive]: Increases all gold dropped from enemies by 10%\n");
            RPGRunner.append("[4] Empower[perk]: Permanently increase base damage by 5.\n");
            int choose = run.getInt();
            if(choose == 1)
            {
            	Ability.Actives.Polymorph.equip();
                RPGRunner.append("You learned Polymorph!\n");
            }
            else if(choose == 2){
            	 Ability.Passives.Lucky.unlock = true;
                 RPGRunner.append("You unlocked Lucky Lucky\n");
            }
            else if(choose == 3)
            {
            	 Ability.Passives.Midas.unlock = true;
                 RPGRunner.append("You unlocked Midas Touch\n");
            }
            else
            {
            	 Weapon.WeaponManager.strPlus = Weapon.WeaponManager.strPlus + 5;
                 RPGRunner.append("Damage bonus increased by 5!\n");
            }
        }
    }
   }
    public static void tryLevelUp() throws InterruptedException
    {
        if(Player.exp >= Player.levelUpExp)
        {
            Player.level++;
            getLevelReward();
        }
    }
    public static void contLevelUp() throws InterruptedException
    {
        if(Player.exp >= Player.levelUpExp)
        {
            Player.level++;
        }
        }
}

