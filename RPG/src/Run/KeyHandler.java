package Run;
import java.awt.event.*;
import Main.*;
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
        	
        	
        if((e.getKeyCode() == KeyEvent.VK_LEFT) && Main.Shop.shopOpen == true && Item.ItemManager.full == false && Ability.Actives.Manager.full == false)
        {
             Sounds.cursorStart();
            Main.Shop.checkDirection(1);
        }
        else if((e.getKeyCode() == KeyEvent.VK_RIGHT) && Main.Shop.shopOpen == true && Item.ItemManager.full == false && Ability.Actives.Manager.full == false)
        {
             Sounds.cursorStart();
            Main.Shop.checkDirection(2);
        }
        else if((e.getKeyCode() == KeyEvent.VK_UP) && Main.Shop.shopOpen == true && Item.ItemManager.full == false && Ability.Actives.Manager.full == false)
        {
             Sounds.cursorStart();
            Main.Shop.checkUDDirection(1);
            System.out.println(Main.Shop.UDDirection);
        }
        else if((e.getKeyCode() == KeyEvent.VK_DOWN) && Main.Shop.shopOpen == true && Item.ItemManager.full == false && Ability.Actives.Manager.full == false)
        {
             Sounds.cursorStart();
            Main.Shop.checkUDDirection(-1);
            System.out.println(Main.Shop.UDDirection);
        }
        else if((e.getKeyCode() == KeyEvent.VK_UP) && Main.Shop.shopOpen == false && Crafting.List.isOpen == false && RPGRunner.battle == false)
        {
             run.output.grabFocus();
        }

        else if((e.getKeyCode() == KeyEvent.VK_DOWN) && Main.Shop.shopOpen == false && Crafting.List.isOpen == false && RPGRunner.battle == false)
        {
             run.input.grabFocus();
        }
        else if((e.getKeyCode() == KeyEvent.VK_UP) && Crafting.List.isOpen == true && Crafting.Recipe.isOpen == false && BackPack.Manager.isOpen == false)
        {
        	if(Crafting.List.getMax() > 1)
        		Sounds.cursorStart();
             Crafting.List.getDirection(-1);
             
        }
        else if((e.getKeyCode() == KeyEvent.VK_DOWN)  && Crafting.List.isOpen == true && Crafting.Recipe.isOpen == false && BackPack.Manager.isOpen == false)
        {
        	if(Crafting.List.getMax() > 1)
        		Sounds.cursorStart();
        	Crafting.List.getDirection(1);
        }
          if((e.getKeyCode() == KeyEvent.VK_ENTER) && Main.Shop.shopOpen == true && Main.Shop.buying == true && Item.ItemManager.full == false && Ability.Actives.Manager.full == false)
        {
            Main.Shop.checkEnter(true);
        }
                if((e.getKeyCode() == KeyEvent.VK_ENTER) && Main.Shop.shopOpen == true && Main.Shop.buying == false && Item.ItemManager.full == false && Ability.Actives.Manager.full == false)
        {
             Sounds.enterStart();
            Main.Shop.checkEnter(true);
        }
        if((e.getKeyCode() == KeyEvent.VK_SHIFT) && Main.Shop.shopOpen == true && Item.ItemManager.full == false && Ability.Actives.Manager.full == false)
        {
            Sounds.cancelStart();
            Main.Shop.checkQuit(true);
            Main.Shop.checkEnter(true);
        }
        if((e.getKeyCode() == KeyEvent.VK_LEFT) && Main.Story.atRoads == true)
        {
           Story.checkDirection(1,5,-1);
            Sounds.cursorStart();
            System.out.println(Main.Story.direction + "Outcome");
        }
        
        
        if((e.getKeyCode() == KeyEvent.VK_SHIFT) && Run.LibraScreen.libraOpen == true)
        {
        	Run.LibraScreen.confirm = true;
            Sounds.cancelStart();
        }
        
        
         if((e.getKeyCode() == KeyEvent.VK_RIGHT) && Main.Story.atRoads == true)
        {
            
            Main.Story.checkDirection(1,5,1);
            Sounds.cursorStart();
            System.out.println(Main.Story.direction);
        }
         if((e.getKeyCode() == KeyEvent.VK_ENTER) && Main.Story.atRoads == true && Main.Shop.buying == false)
        {
            Sounds.enterStart();
            Main.Story.pause(50);
            Main.Story.checkEnter(true);
        }
        if((e.getKeyCode() == KeyEvent.VK_ENTER) && Main.Story.twoChoiceH == true  && Main.Shop.buying == false)
        {
            Sounds.enterStart();
            Main.Story.checkEnter(true);
        }
        if((e.getKeyCode() == KeyEvent.VK_RIGHT) && Main.Story.twoChoiceH == true)
        {
            Sounds.cursorStart();
            Main.Story.checkDirection(1,3,1);
            System.out.println(Main.Story.direction);
        }
        if((e.getKeyCode() == KeyEvent.VK_LEFT) && Main.Story.twoChoiceH == true)
        {
            Sounds.cursorStart();
            Main.Story.checkDirection(1,3,-1);
            System.out.println(Main.Story.direction);
        }
        if((e.getKeyCode() == KeyEvent.VK_RIGHT) && DungeonTwo.entrance == true && Crafting.List.isOpen == false)
        {
            Sounds.cursorStart();
            DungeonTwo.checkDirection(1,3,1);
            
        }
        if((e.getKeyCode() == KeyEvent.VK_LEFT) && DungeonTwo.entrance == true && Crafting.List.isOpen == false)
        {
            Sounds.cursorStart();
            DungeonTwo.checkDirection(1,3,-1);
            
        }
        if((e.getKeyCode() == KeyEvent.VK_ENTER) && DungeonTwo.menu == true && Crafting.List.isOpen == false)
        {
            Sounds.enterStart();
            Main.Story.pause(50);
            DungeonTwo.checkEnter(true);
        }
        if((e.getKeyCode() == KeyEvent.VK_ENTER) && Crafting.List.isOpen == true && Crafting.Recipe.isOpen == false && BackPack.Manager.isOpen == false)
        {
            Sounds.enterStart();
            Main.Story.pause(50);
            Crafting.List.isSelected(true);
        }
        if((e.getKeyCode() == KeyEvent.VK_ENTER) && Main.Dungeon.carnivalChoice == true && Main.Shop.buying == false)
        {
            Sounds.enterStart();
            Main.Story.pause(50);
            Main.Dungeon.checkEnter(true);
        }
        if((e.getKeyCode() == KeyEvent.VK_RIGHT) && Main.Dungeon.carnivalChoice == true)
        {
            Sounds.cursorStart();
            Main.Dungeon.checkDirection(1,4,1);
            System.out.println(Main.Dungeon.direction);
        }
        if((e.getKeyCode() == KeyEvent.VK_LEFT) && Main.Dungeon.carnivalChoice == true)
        {
            Sounds.cursorStart();
            Main.Dungeon.checkDirection(1,4,-1);
            System.out.println(Main.Dungeon.direction);
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
            Main.Story.pause(50);
            MainFightPanel.checkEnter(true);
        }
        else if((e.getKeyCode() == KeyEvent.VK_ENTER) && MainFightPanel.playerTurn == true && MainFightPanel.direction != -5 && MainFightPanel.direction != -4) {
        	Sounds.enterStart();
            Main.Story.pause(50);
            MainFightPanel.checkEnter(true);
        }
        if((e.getKeyCode() == KeyEvent.VK_ENTER) && MainFightPanel.playerTurn == true && MainFightPanel.direction == -4 && StatusEffect.Player.silenceActive == false)
        {
        	Sounds.enterStart();
            Main.Story.pause(50);
            MainFightPanel.checkEnter(true);
        }
        else if((e.getKeyCode() == KeyEvent.VK_ENTER) && MainFightPanel.playerTurn == true && MainFightPanel.direction == -4 && StatusEffect.Player.silenceActive == true) {
            Main.Story.pause(50);
            MainFightPanel.checkEnter(true);
        }
        
        
        
        if((e.getKeyCode() == KeyEvent.VK_UP) && Item.ItemManager.opened == true)
        {
            Sounds.cursorStart();
            Item.ItemManager.checkDirection(1,Item.ItemManager.slotCount+2,-1);
            System.out.println(Item.ItemManager.direction);
        }
        if((e.getKeyCode() == KeyEvent.VK_DOWN) && Item.ItemManager.opened == true)
        {
            Sounds.cursorStart();
            Item.ItemManager.checkDirection(1,Item.ItemManager.slotCount+2,1);
            System.out.println(Item.ItemManager.direction);
        }
        if((e.getKeyCode() == KeyEvent.VK_ENTER) && Item.ItemManager.opened == true)
        {
        	Sounds.enterStart();
            Main.Story.pause(50);
            Item.ItemManager.checkEnter(true);
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
            Main.Story.pause(50);
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
            Main.Story.pause(50);
            Ability.Actives.Manager.checkEnter(true);
        }
        
        
        
        if((e.getKeyCode() == KeyEvent.VK_UP) && MainFightPanel.targetSelect == true)
        {
            Sounds.cursorStart();
            MainFightPanel.checkDirection(1,Monsters.MonsterManager.enemies.size()+2,-1);
            System.out.println(Ability.Actives.Manager.direction);
        }
        if((e.getKeyCode() == KeyEvent.VK_DOWN) && MainFightPanel.targetSelect == true)
        {
            Sounds.cursorStart();
            MainFightPanel.checkDirection(1,Monsters.MonsterManager.enemies.size()+2,1);
            System.out.println(Ability.Actives.Manager.direction);
        }
        if((e.getKeyCode() == KeyEvent.VK_ENTER) && MainFightPanel.targetSelect == true)
        {
            Main.Story.pause(50);
            MainFightPanel.checkEnter(true);
        }
        
        
        if((e.getKeyCode() == KeyEvent.VK_RIGHT) && Main.DungeonTwo.mineChoice == true && Crafting.List.isOpen == false)
        {
            Sounds.cursorStart();
            Main.DungeonTwo.checkDirection(1,4,1);
        }
        if((e.getKeyCode() == KeyEvent.VK_LEFT) && Main.DungeonTwo.mineChoice == true && Crafting.List.isOpen == false)
        {
            Sounds.cursorStart();
            Main.DungeonTwo.checkDirection(1,4,-1);
        }
        if((e.getKeyCode() == KeyEvent.VK_RIGHT) && Main.Story.lockedDoor == true && BackPack.Manager.isOpen == false)
        {
            Main.Story.setDirection(1);
            System.out.println(Main.Story.direction);
        }
        if((e.getKeyCode() == KeyEvent.VK_LEFT) && Main.Story.lockedDoor == true && BackPack.Manager.isOpen == false)
        {
            Sounds.cursorStart();
            Main.Story.setDirection(-1);
            System.out.println(Main.Story.direction);
        }
        
        if((e.getKeyCode() == KeyEvent.VK_SHIFT) && BackPack.Manager.isOpen == true)
        {
            Sounds.cancelStart();
            BackPack.Manager.quit = true;
        }
        if((e.getKeyCode() == KeyEvent.VK_SHIFT) && Crafting.List.isOpen == true && BackPack.Manager.isOpen == false && Crafting.Recipe.isOpen == false)
        {
            Sounds.cancelStart();
            Crafting.List.quit = true;
        }
        if((e.getKeyCode() == KeyEvent.VK_LEFT) && BackPack.Manager.isOpen == true && BackPack.Manager.dCheck == true  && BackPack.Manager.pageNum != 1)
        {
            Sounds.cursorStart();
            BackPack.Manager.direction = 1;
        }
        if((e.getKeyCode() == KeyEvent.VK_RIGHT) && BackPack.Manager.isOpen == true && BackPack.Manager.dCheck == true  && BackPack.Manager.pageNum != BackPack.Manager.pageNumTotal)
        {
            Sounds.cursorStart();
            BackPack.Manager.direction = 2;
        }
        
                if((e.getKeyCode() == KeyEvent.VK_B) && Main.Story.lockedDoor == true && BackPack.Manager.isOpen == false)
        {
            Main.Story.isBPressed(true);
        }
         if((e.getKeyCode() == KeyEvent.VK_B) && Crafting.List.isOpen == true && BackPack.Manager.isOpen == false && Crafting.Recipe.isOpen == false)
           {
        	 Crafting.List.isBPressed(true);
           }             
         if((e.getKeyCode() == KeyEvent.VK_SHIFT) && Main.Dungeon.mainMenu == true)
        {
            Sounds.cancelStart();
            Main.Dungeon.checkQuit(true);
            Main.Dungeon.checkEnter(true);
        }
         if((e.getKeyCode() == KeyEvent.VK_SHIFT) && Main.DungeonTwo.mainMenu == true)
         {
             Sounds.cancelStart();
             Main.DungeonTwo.checkQuit(true);
             Main.DungeonTwo.checkEnter(true);
         }
          if((e.getKeyCode() == KeyEvent.VK_RIGHT) && Main.Dungeon.twoChoiceH == true)
        {
            Sounds.cursorStart();
            Main.Dungeon.checkDirection(1,3,1);
        }
        if((e.getKeyCode() == KeyEvent.VK_LEFT) && Main.Dungeon.twoChoiceH == true)
        {
            Sounds.cursorStart();
            Main.Dungeon.checkDirection(1,3,-1);
        }
        if((e.getKeyCode() == KeyEvent.VK_ENTER) && Main.Dungeon.twoChoiceH == true && Main.Shop.buying == false)
        {
            Sounds.enterStart();
            Main.Story.pause(50);
            Main.Dungeon.checkEnter(true);
        }
        
    }
    public void keyReleased(KeyEvent e)
    {
        if((e.getKeyCode() == KeyEvent.VK_ENTER) && Main.Shop.shopOpen == true)
        {
            Main.Shop.checkEnter(false);
        }
        if((e.getKeyCode() == KeyEvent.VK_SHIFT) && Main.Shop.shopOpen == true)
        {
            Main.Shop.checkEnter(false);
        }
    }
    
    public void keyTyped(KeyEvent e)
    {

    }

    
    
}

