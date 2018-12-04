package backend;
import java.awt.event.*;

import gameplay.*;
public class KeyHandler implements KeyListener{

	private MainFightPanel mainFight;
    private RPGRunner run;
    private LibraScreen libraScreen;
    private AbilityPageScreen apScreen;
    String text;

    public KeyHandler(RPGRunner r) throws InterruptedException {
       run = r;
    }
    
    public KeyHandler(MainFightPanel m) throws InterruptedException {
       mainFight = m;
    }
    
    public KeyHandler(LibraScreen l) throws InterruptedException {
        libraScreen = l;
     }
    public KeyHandler(AbilityPageScreen ap) throws InterruptedException {
        apScreen = ap;
     }
    
        public void keyPressed(KeyEvent e)
    {
        	
        	//* TESTING
        	 if((e.getKeyCode() == KeyEvent.VK_UP))
             {
                 Sounds.cursorStart();
                 
             }
             if((e.getKeyCode() == KeyEvent.VK_DOWN))
             {
                 Sounds.cursorStart();
                 
             }
        	//*/
        	
        	
        if((e.getKeyCode() == KeyEvent.VK_LEFT) && gameplay.Shop.shopOpen == true && consumables.ItemManager.full == false && Ability.Actives.Manager.full == false)
        {
             Sounds.cursorStart();
            gameplay.Shop.checkDirection(1);
        }
        else if((e.getKeyCode() == KeyEvent.VK_RIGHT) && gameplay.Shop.shopOpen == true && consumables.ItemManager.full == false && Ability.Actives.Manager.full == false)
        {
             Sounds.cursorStart();
            gameplay.Shop.checkDirection(2);
        }
        else if((e.getKeyCode() == KeyEvent.VK_UP) && gameplay.Shop.shopOpen == true && consumables.ItemManager.full == false && Ability.Actives.Manager.full == false)
        {
             Sounds.cursorStart();
            gameplay.Shop.checkUDDirection(1);
            System.out.println(gameplay.Shop.UDDirection);
        }
        else if((e.getKeyCode() == KeyEvent.VK_DOWN) && gameplay.Shop.shopOpen == true && consumables.ItemManager.full == false && Ability.Actives.Manager.full == false)
        {
             Sounds.cursorStart();
            gameplay.Shop.checkUDDirection(-1);
            System.out.println(gameplay.Shop.UDDirection);
        }
        else if((e.getKeyCode() == KeyEvent.VK_UP) && gameplay.Shop.shopOpen == false && crafting.List.isOpen == false && RPGRunner.battle == false)
        {
             run.output.grabFocus();
        }

        else if((e.getKeyCode() == KeyEvent.VK_DOWN) && gameplay.Shop.shopOpen == false && crafting.List.isOpen == false && RPGRunner.battle == false)
        {
             run.input.grabFocus();
        }
        else if((e.getKeyCode() == KeyEvent.VK_UP) && crafting.List.isOpen == true && crafting.Recipe.isOpen == false && backpack.Manager.isOpen == false)
        {
        	if(crafting.List.getMax() > 1)
        		Sounds.cursorStart();
             crafting.List.getDirection(-1);
             
        }
        else if((e.getKeyCode() == KeyEvent.VK_DOWN)  && crafting.List.isOpen == true && crafting.Recipe.isOpen == false && backpack.Manager.isOpen == false)
        {
        	if(crafting.List.getMax() > 1)
        		Sounds.cursorStart();
        	crafting.List.getDirection(1);
        }
          if((e.getKeyCode() == KeyEvent.VK_ENTER) && gameplay.Shop.shopOpen == true && gameplay.Shop.buying == true && consumables.ItemManager.full == false && Ability.Actives.Manager.full == false)
        {
            gameplay.Shop.checkEnter(true);
        }
                if((e.getKeyCode() == KeyEvent.VK_ENTER) && gameplay.Shop.shopOpen == true && gameplay.Shop.buying == false && consumables.ItemManager.full == false && Ability.Actives.Manager.full == false)
        {
             Sounds.enterStart();
            gameplay.Shop.checkEnter(true);
        }
        if((e.getKeyCode() == KeyEvent.VK_SHIFT) && gameplay.Shop.shopOpen == true && consumables.ItemManager.full == false && Ability.Actives.Manager.full == false)
        {
            Sounds.cancelStart();
            gameplay.Shop.checkQuit(true);
            gameplay.Shop.checkEnter(true);
        }
        if((e.getKeyCode() == KeyEvent.VK_LEFT) && gameplay.Story.atRoads == true)
        {
           Story.checkDirection(1,5,-1);
            Sounds.cursorStart();
            System.out.println(gameplay.Story.direction + "Outcome");
        }
        
        
        if((e.getKeyCode() == KeyEvent.VK_SHIFT) && backend.LibraScreen.libraOpen == true)
        {
        	backend.LibraScreen.confirm = true;
            Sounds.cancelStart();
        }
        
        
         if((e.getKeyCode() == KeyEvent.VK_RIGHT) && gameplay.Story.atRoads == true)
        {
            
            gameplay.Story.checkDirection(1,5,1);
            Sounds.cursorStart();
            System.out.println(gameplay.Story.direction);
        }
         if((e.getKeyCode() == KeyEvent.VK_ENTER) && gameplay.Story.atRoads == true && gameplay.Shop.buying == false)
        {
            Sounds.enterStart();
            gameplay.Story.pause(50);
            gameplay.Story.checkEnter(true);
        }
        if((e.getKeyCode() == KeyEvent.VK_ENTER) && gameplay.Story.twoChoiceH == true  && gameplay.Shop.buying == false)
        {
            Sounds.enterStart();
            gameplay.Story.checkEnter(true);
        }
        if((e.getKeyCode() == KeyEvent.VK_RIGHT) && gameplay.Story.twoChoiceH == true)
        {
            Sounds.cursorStart();
            gameplay.Story.checkDirection(1,3,1);
            System.out.println(gameplay.Story.direction);
        }
        if((e.getKeyCode() == KeyEvent.VK_LEFT) && gameplay.Story.twoChoiceH == true)
        {
            Sounds.cursorStart();
            gameplay.Story.checkDirection(1,3,-1);
            System.out.println(gameplay.Story.direction);
        }
        if((e.getKeyCode() == KeyEvent.VK_RIGHT) && DungeonTwo.entrance == true && crafting.List.isOpen == false)
        {
            Sounds.cursorStart();
            DungeonTwo.checkDirection(1,3,1);
            
        }
        if((e.getKeyCode() == KeyEvent.VK_LEFT) && DungeonTwo.entrance == true && crafting.List.isOpen == false)
        {
            Sounds.cursorStart();
            DungeonTwo.checkDirection(1,3,-1);
            
        }
        if((e.getKeyCode() == KeyEvent.VK_ENTER) && DungeonTwo.menu == true && crafting.List.isOpen == false)
        {
            Sounds.enterStart();
            gameplay.Story.pause(50);
            DungeonTwo.checkEnter(true);
        }
        if((e.getKeyCode() == KeyEvent.VK_ENTER) && crafting.List.isOpen == true && crafting.Recipe.isOpen == false && backpack.Manager.isOpen == false)
        {
            Sounds.enterStart();
            gameplay.Story.pause(50);
            crafting.List.isSelected(true);
        }
        if((e.getKeyCode() == KeyEvent.VK_ENTER) && gameplay.Dungeon.carnivalChoice == true && gameplay.Shop.buying == false)
        {
            Sounds.enterStart();
            gameplay.Story.pause(50);
            gameplay.Dungeon.checkEnter(true);
        }
        if((e.getKeyCode() == KeyEvent.VK_RIGHT) && gameplay.Dungeon.carnivalChoice == true)
        {
            Sounds.cursorStart();
            gameplay.Dungeon.checkDirection(1,4,1);
            System.out.println(gameplay.Dungeon.direction);
        }
        if((e.getKeyCode() == KeyEvent.VK_LEFT) && gameplay.Dungeon.carnivalChoice == true)
        {
            Sounds.cursorStart();
            gameplay.Dungeon.checkDirection(1,4,-1);
            System.out.println(gameplay.Dungeon.direction);
        }
        
        
        
        if((e.getKeyCode() == KeyEvent.VK_UP) && MainFightPanel.playerTurn == true)
        {
            Sounds.cursorStart();
            MainFightPanel.checkDirection(1,6,-1);
            System.out.println(MainFightPanel.direction);
        }
        if((e.getKeyCode() == KeyEvent.VK_DOWN) && MainFightPanel.playerTurn == true)
        {
            Sounds.cursorStart();
            MainFightPanel.checkDirection(1,6,1);
            System.out.println(MainFightPanel.direction);
        }
        if((e.getKeyCode() == KeyEvent.VK_ENTER) && MainFightPanel.playerTurn == true && MainFightPanel.direction == -5)
        {
            gameplay.Story.pause(50);
            MainFightPanel.checkEnter(true);
        }
        else if((e.getKeyCode() == KeyEvent.VK_ENTER) && MainFightPanel.playerTurn == true && MainFightPanel.direction != -5 && MainFightPanel.direction != -4) {
        	Sounds.enterStart();
            gameplay.Story.pause(50);
            MainFightPanel.checkEnter(true);
        }
        if((e.getKeyCode() == KeyEvent.VK_ENTER) && MainFightPanel.playerTurn == true && MainFightPanel.direction == -4 && statusEffect.Player.silenceActive == false)
        {
        	Sounds.enterStart();
            gameplay.Story.pause(50);
            MainFightPanel.checkEnter(true);
        }
        else if((e.getKeyCode() == KeyEvent.VK_ENTER) && MainFightPanel.playerTurn == true && MainFightPanel.direction == -4 && statusEffect.Player.silenceActive == true) {
            gameplay.Story.pause(50);
            MainFightPanel.checkEnter(true);
        }
        
        
        
        if((e.getKeyCode() == KeyEvent.VK_UP) && consumables.ItemManager.opened == true)
        {
            Sounds.cursorStart();
            consumables.ItemManager.checkDirection(1,consumables.ItemManager.slotCount+2,-1);
            System.out.println(consumables.ItemManager.direction);
        }
        if((e.getKeyCode() == KeyEvent.VK_DOWN) && consumables.ItemManager.opened == true)
        {
            Sounds.cursorStart();
            consumables.ItemManager.checkDirection(1,consumables.ItemManager.slotCount+2,1);
            System.out.println(consumables.ItemManager.direction);
        }
        if((e.getKeyCode() == KeyEvent.VK_ENTER) && consumables.ItemManager.opened == true)
        {
        	Sounds.enterStart();
            gameplay.Story.pause(50);
            consumables.ItemManager.checkEnter(true);
        }
        
        
        
        
        if((e.getKeyCode() == KeyEvent.VK_UP) && Ability.Actives.Manager.opened == true)
        {
            Sounds.cursorStart();
            Ability.Actives.Manager.checkDirection(1,5+3,-1);
            System.out.println(Ability.Actives.Manager.direction);
        }
        if((e.getKeyCode() == KeyEvent.VK_DOWN) && Ability.Actives.Manager.opened == true)
        {
            Sounds.cursorStart();
            Ability.Actives.Manager.checkDirection(1,5+3,1);
            System.out.println(Ability.Actives.Manager.direction);
        }
        if((e.getKeyCode() == KeyEvent.VK_ENTER) && Ability.Actives.Manager.opened == true)
        {
        	Sounds.enterStart();
            gameplay.Story.pause(50);
            Ability.Actives.Manager.checkEnter(true);
        }
        
        
        
        if((e.getKeyCode() == KeyEvent.VK_UP) && Ability.Actives.Manager.switchOpened == true)
        {
            Sounds.cursorStart();
            Ability.Actives.Manager.checkDirection(1,Ability.Actives.Manager.pageCount+1,-1);
            System.out.println(Ability.Actives.Manager.direction);
        }
        if((e.getKeyCode() == KeyEvent.VK_DOWN) && Ability.Actives.Manager.switchOpened == true)
        {
            Sounds.cursorStart();
            Ability.Actives.Manager.checkDirection(1,Ability.Actives.Manager.pageCount+1,1);
            System.out.println(Ability.Actives.Manager.direction);
        }
        if((e.getKeyCode() == KeyEvent.VK_ENTER) && Ability.Actives.Manager.switchOpened == true)
        {
        	Sounds.enterStart();
            gameplay.Story.pause(50);
            Ability.Actives.Manager.checkEnter(true);
        }
        
        
        
        if((e.getKeyCode() == KeyEvent.VK_UP) && MainFightPanel.targetSelect == true)
        {
            Sounds.cursorStart();
            MainFightPanel.checkDirection(1,monsters.MonsterManager.enemies.size()+2,-1);
            System.out.println(Ability.Actives.Manager.direction);
        }
        if((e.getKeyCode() == KeyEvent.VK_DOWN) && MainFightPanel.targetSelect == true)
        {
            Sounds.cursorStart();
            MainFightPanel.checkDirection(1,monsters.MonsterManager.enemies.size()+2,1);
            System.out.println(Ability.Actives.Manager.direction);
        }
        if((e.getKeyCode() == KeyEvent.VK_ENTER) && MainFightPanel.targetSelect == true)
        {
            gameplay.Story.pause(50);
            MainFightPanel.checkEnter(true);
        }
        
        
        if((e.getKeyCode() == KeyEvent.VK_RIGHT) && gameplay.DungeonTwo.mineChoice == true && crafting.List.isOpen == false)
        {
            Sounds.cursorStart();
            gameplay.DungeonTwo.checkDirection(1,4,1);
        }
        if((e.getKeyCode() == KeyEvent.VK_LEFT) && gameplay.DungeonTwo.mineChoice == true && crafting.List.isOpen == false)
        {
            Sounds.cursorStart();
            gameplay.DungeonTwo.checkDirection(1,4,-1);
        }
        if((e.getKeyCode() == KeyEvent.VK_RIGHT) && gameplay.Story.lockedDoor == true && backpack.Manager.isOpen == false)
        {
            gameplay.Story.setDirection(1);
            System.out.println(gameplay.Story.direction);
        }
        if((e.getKeyCode() == KeyEvent.VK_LEFT) && gameplay.Story.lockedDoor == true && backpack.Manager.isOpen == false)
        {
            Sounds.cursorStart();
            gameplay.Story.setDirection(-1);
            System.out.println(gameplay.Story.direction);
        }
        
        if((e.getKeyCode() == KeyEvent.VK_SHIFT) && backpack.Manager.isOpen == true)
        {
            Sounds.cancelStart();
            backpack.Manager.quit = true;
        }
        if((e.getKeyCode() == KeyEvent.VK_SHIFT) && crafting.List.isOpen == true && backpack.Manager.isOpen == false && crafting.Recipe.isOpen == false)
        {
            Sounds.cancelStart();
            crafting.List.quit = true;
        }
        if((e.getKeyCode() == KeyEvent.VK_LEFT) && backpack.Manager.isOpen == true && backpack.Manager.dCheck == true  && backpack.Manager.pageNum != 1)
        {
            Sounds.cursorStart();
            backpack.Manager.direction = 1;
        }
        if((e.getKeyCode() == KeyEvent.VK_RIGHT) && backpack.Manager.isOpen == true && backpack.Manager.dCheck == true  && backpack.Manager.pageNum != backpack.Manager.pageNumTotal)
        {
            Sounds.cursorStart();
            backpack.Manager.direction = 2;
        }
        
                if((e.getKeyCode() == KeyEvent.VK_B) && gameplay.Story.lockedDoor == true && backpack.Manager.isOpen == false)
        {
            gameplay.Story.isBPressed(true);
        }
         if((e.getKeyCode() == KeyEvent.VK_B) && crafting.List.isOpen == true && backpack.Manager.isOpen == false && crafting.Recipe.isOpen == false)
           {
        	 crafting.List.isBPressed(true);
           }             
         if((e.getKeyCode() == KeyEvent.VK_SHIFT) && gameplay.Dungeon.mainMenu == true)
        {
            Sounds.cancelStart();
            gameplay.Dungeon.checkQuit(true);
            gameplay.Dungeon.checkEnter(true);
        }
         if((e.getKeyCode() == KeyEvent.VK_SHIFT) && gameplay.DungeonTwo.mainMenu == true)
         {
             Sounds.cancelStart();
             gameplay.DungeonTwo.checkQuit(true);
             gameplay.DungeonTwo.checkEnter(true);
         }
          if((e.getKeyCode() == KeyEvent.VK_RIGHT) && gameplay.Dungeon.twoChoiceH == true)
        {
            Sounds.cursorStart();
            gameplay.Dungeon.checkDirection(1,3,1);
        }
        if((e.getKeyCode() == KeyEvent.VK_LEFT) && gameplay.Dungeon.twoChoiceH == true)
        {
            Sounds.cursorStart();
            gameplay.Dungeon.checkDirection(1,3,-1);
        }
        if((e.getKeyCode() == KeyEvent.VK_ENTER) && gameplay.Dungeon.twoChoiceH == true && gameplay.Shop.buying == false)
        {
            Sounds.enterStart();
            gameplay.Story.pause(50);
            gameplay.Dungeon.checkEnter(true);
        }
        
    }
    public void keyReleased(KeyEvent e)
    {
        if((e.getKeyCode() == KeyEvent.VK_ENTER) && gameplay.Shop.shopOpen == true)
        {
            gameplay.Shop.checkEnter(false);
        }
        if((e.getKeyCode() == KeyEvent.VK_SHIFT) && gameplay.Shop.shopOpen == true)
        {
            gameplay.Shop.checkEnter(false);
        }
    }
    
    public void keyTyped(KeyEvent e)
    {

    }

    
    
}

