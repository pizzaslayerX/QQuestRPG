package gameplay;
import java.awt.Color;

import backend.*;
public class Chest
{
    public static int type;
   public static RPGRunner run;
   public Chest(RPGRunner r)
    {
        this.run = r;
    }
   public static void open(int t) throws InterruptedException
   {
       type = t;
       if(type == 1)
       {
           Playlist.playEffect("/sounds/ItemGet.wav");
           int newGold = 10 + (int)(Math.random() * (23 - 10));
           Player.gold = Player.gold + newGold; 
           //System.out.println("");
           run.append("=========Contents=========\n",Color.MAGENTA,20,true);
           run.append("Gold: ",Color.ORANGE,20,true);
           run.append(newGold + "");
           run.append("\nPotion x2\n");
           run.append("==========================\n",Color.MAGENTA,20,true);
           consumables.Potion.newItem();
           consumables.Potion.newItem();
       }
       if(type == 2)
       {
           Playlist.playEffect("/sounds/ItemGet.wav");
           int newGold = 20 + (int)(Math.random() * (33 - 20));
           Player.gold = Player.gold + newGold; 
           //System.out.println("");
           run.append("=========Contents=========\n",Color.MAGENTA,20,true);
           run.append("Gold: ",Color.ORANGE,20,true);
           run.append(newGold + "");
           run.append("\nPotion x1\n");
           run.append("==========================\n",Color.MAGENTA,20,true);
           consumables.Potion.newItem();
       }
       if(type == 3)
       {
           
           run.append("You found a chest next to Big Tim!\n\n");
           int newGold = 100 + (int)(Math.random() * 21);
            if(Ability.Passives.Lucky.unlock == true)
            	newGold = newGold + (newGold / 5);
           Player.gold = Player.gold + newGold; 
           Playlist.playEffect("/sounds/ItemGet.wav");
           run.append("=========Contents=========\n",Color.MAGENTA,20,true);
           run.append("Gold: ",Color.ORANGE,20,true);
           run.append(newGold + "");
           run.append("\nElixer x1\n");
           run.append("Rainbow in a bottle x1\n");
           run.append("==========================\n",Color.MAGENTA,20,true);
           backpack.Manager.add("Rainbow in a bottle",1);
        }
    }
   public static void ranChestOpen(int t,int c) throws InterruptedException
   {
      
       int type = t;
       int chance = c;
       int threshold =  1 + (int)(Math.random() * 100);
       int potCount = 0;
       int hPotCount = 0;
       int uPotCount = 0;
       int ePotCount = 0; 
       String addWeapon = "";
       String eaddPot = "";
       String uaddPot = "";
       String addPot = "";
       String hAddPot = "";
       if(type == 1)
       {
        if(threshold <= chance)
        {
             Playlist.playEffect("/sounds/ItemGet.wav");
            run.append("You found a ");
            run.append("chest",Color.MAGENTA,20,true);
            run.append("!\n\n");
             int newGold = 20 + (int)(Math.random() * (35));
             if(Ability.Passives.Lucky.unlock == true)
             	newGold = newGold + (newGold / 5);
             Player.gold = Player.gold + newGold; 
             threshold = 1 + (int)(Math.random() * 100);
             if(threshold <= 60)
             {
                 threshold = 1 + (int)(Math.random() * 100);
                if(threshold <= 40)
                {
                    hPotCount++;
                    hAddPot = "\nHi-Potion x"+hPotCount;
                }
                else
                {
                    potCount++;
                    addPot = "\nPotion x"+potCount;
                }
                }
             
           run.append("=========Contents=========\n",Color.MAGENTA,20,true);
           run.append("Gold: ",Color.ORANGE,20,true);
           run.append(newGold + addPot + hAddPot);
           run.append("\n==========================",Color.MAGENTA,20,true);
           userWait();
           run.output.setText("");
           for(int i = 0;i < hPotCount;i++)
                    consumables.HighPotion.newItem();
           for(int i = 0;i < potCount;i++)
                    consumables.Potion.newItem();
        }
        }
       if(type == 2)
       {
          if(threshold <= chance)
        {
             Playlist.playEffect("/sounds/ItemGet.wav");
            run.append("You found a large chest!\n\n");
             int newGold = 60 + (int)(Math.random() * (110));
             if(Ability.Passives.Lucky.unlock == true)
             	newGold = newGold + (newGold / 5);
             Player.gold = Player.gold + newGold; 
             threshold = 1 + (int)(Math.random() * 100);
             if(threshold <= 55)
             {
                 threshold = 1 + (int)(Math.random() * 100);
                if(threshold <= 60)
                {
                    hPotCount++;
                    hAddPot = "\nMega-Potion x"+hPotCount;
                }
                else
                {
                    potCount++;
                    potCount++;
                    addPot = "\nHi-Potion x"+potCount;
                }
                 run.append("=========Contents=========\n",Color.MAGENTA,20,true);
                 run.append("Gold: ",Color.ORANGE,20,true);
                 run.append(newGold + addPot + hAddPot + uaddPot + addWeapon);
                run.append("\n==========================",Color.MAGENTA,20,true);
                   userWait();
                    run.output.setText("");
                for(int i = 0;i < hPotCount;i++)
                    consumables.MegaPotion.newItem();
                for(int i = 0;i < potCount;i++)
                    consumables.HighPotion.newItem();
                }
             else
             {
            	 run.getReset();
                 threshold = 1 + (int)(Math.random() * 100);
                 if(threshold <= 50)
                {
                    uPotCount++;
                    uaddPot = "\nUltramarine x"+uPotCount;
                }
                else
                {
                    potCount++;
                    addPot = "\nHi-Potion x"+potCount;
                    
                }
                 run.getReset();
                run.append("=========Contents=========\n",Color.MAGENTA,20,true);
                run.append("Gold: ",Color.ORANGE,20,true);
                run.append(newGold + addPot + hAddPot + uaddPot + addWeapon);
                threshold = 1 + (int)(Math.random() * 100);
                if(threshold < 5)
                {
                    run.append("\nRare weapon: Titan's Bane [dmg:39][crit:15]");
                    run.append("\n==========================",Color.MAGENTA,20,true);
                    run.append("\nPress [p] to pick up");
                  String answer = run.getString();
                  if(answer.equals("p")) {
                    weapon.Titan.setWeapon();
                    Player.equipWeapon();
                  }
                }
                else if(threshold < 15 && threshold > 5)
                {
                    run.append("\nRare weapon: Imperius [dmg:33][crit:10][King's Aura]");
                    run.append("\n==========================",Color.MAGENTA,20,true);
                    run.append("\nPress [p] to pick up");
                  String answer = run.getString();
                  if(answer.equals("p")) {
                    weapon.Imperius.setWeapon();
                    Player.equipWeapon();
                  }
                }
                
                else if(threshold < 45 && threshold > 15)
                {
                	run.getReset();
                    run.append("\nTrash weapon: Bone Club [dmg:9][crit:10]");
                    run.append("\n==========================",Color.MAGENTA,20,true);
                    run.append("\nPress [p] to pick up");
                  String answer = run.getString();
                  if(answer.equals("p")) {
                    weapon.BoneClub.setWeapon();
                    Player.equipWeapon();
                  }
                }
                else if(threshold < 70 && threshold > 45)
                {
                    run.append("\nCommon weapon: The Chubby Titan [dmg:12][crit:66]");
                    run.append("\n==========================",Color.MAGENTA,20,true);
                    run.append("\nPress [p] to pick up");
                  String answer = run.getString();
                  if(answer.equals("p")) {
                    weapon.ChubbyTitan.setWeapon();
                    Player.equipWeapon();
                  }
                }
                else 
                 {
                     run.append("\nCommon weapon: Spiked Boomerang [dmg:14][crit:30][Attack+]");
                     run.append("\n==========================",Color.MAGENTA,20,true);
                     run.append("\nPress [p] to pick up");
                  String answer = run.getString();
                  if(answer.equals("p")) {
                     weapon.SpikedBoomerang.setWeapon();
                     Player.equipWeapon();
                  }
                 }
                   
                   userWait();
                    run.output.setText("");
                for(int i = 0;i < uPotCount;i++)
                    consumables.Ultramarine.newItem();
                for(int i = 0;i < potCount;i++)
                    consumables.HighPotion.newItem();
             }
                        
           
          
        
       if(type == 3)
       {
           
        }
   
    }
   }
 }
 public static void userWait() throws InterruptedException
    {
        run.append("\n'Press Enter to Continue'\n");
        run.getString();
    }
}
