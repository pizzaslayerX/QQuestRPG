package BackPack;
import Run.*;

import java.io.Serializable;
import java.util.ArrayList;
public class Manager implements Serializable
{
     public static RPGRunner run;
    public static ArrayList<Slot> inventory = new ArrayList<Slot>();
    public static boolean quit = false;
    public static boolean isOpen;
    public static int page = 9;
    public static int currentPage;
    public static int pageNum = 1;
    public static int pageNumTotal = 1;
    public static boolean dCheck;
    public static int direction = 0;
    public Manager(RPGRunner r)
    {
        this.run = r;
    }
    
    public static void open()
    {
    	page = 9;
    	pageNum = 1;
    	pageNumTotal = 1;
        quit = false;
        isOpen = true;
        run.output.setText("");
        run.fontSize(20);
        String itemPrint;                 
        String display = "Quit [SHIFT]                                  Page:" + pageNum + "/" + pageNumTotal + "\n\n==============================================BACKPACK==========================================================================\n Empty!\n==================================================================================================================================================";
        if(inventory.size() > 0)
              display =  "Quit [SHIFT]                                  Page:" + pageNum + "/" + pageNumTotal + "\n\n==============================================BACKPACK==========================================================================\n";
        if(inventory.size() > 9)
        {
        	pageNumTotal++;
        	while(inventory.size() > page + 9)
        	{
        		page = page + 9;
        		pageNumTotal++;
        	}
        	currentPage = 0;
        	dCheck = true;
        	  display =  "Quit [SHIFT]                                  Page:" + pageNum + "/" + pageNumTotal + "                               Next Page--->\n\n==============================================BACKPACK==========================================================================\n";
        	 for(int i = 0;i<9;i++)
              {
                 itemPrint = inventory.get(i).getIdItem() + " x" + inventory.get(i).getTotal() + "\n";
                 itemPrint = itemPrint + "===================================================================================================================================================\n";
                 display = display + itemPrint;
              }
        	    run.output.setText(display);
        	    while(quit != true)
             {
        	    	System.out.print("looping");
        	    if(direction == 2 && pageNum != pageNumTotal)
        	    {
        	    	pageNum++;
        	    	currentPage = currentPage + 9;
        	   if(pageNum == pageNumTotal)
        	   {
        	       display =  "Quit [SHIFT]                                  Page:" + pageNum + "/" + pageNumTotal + "                                    <---Back Page\n\n==============================================BACKPACK==========================================================================\n";
        	       for(int i = 0;i<inventory.size() - page;i++)
                   {
                      itemPrint = inventory.get(i+currentPage).getIdItem() + " x" + inventory.get(i+currentPage).getTotal() + "\n";
                      itemPrint = itemPrint + "===================================================================================================================================================\n";
                      display = display + itemPrint;
                   }
        	   
        	   }
        	   else
        	   {
        		   display =  "Quit [SHIFT]                                  Page:" + pageNum + "/" + pageNumTotal + "                      <---Back Page | Next Page--->\n\n==============================================BACKPACK==========================================================================\n";
        	   
        	   for(int i = 0;i<9;i++)
                    {
                       itemPrint = inventory.get(i+currentPage).getIdItem() + " x" + inventory.get(i+currentPage).getTotal() + "\n";
                       itemPrint = itemPrint + "===================================================================================================================================================\n";
                       display = display + itemPrint;
                    }
        	      }
        	    	run.output.setText(display);
        	    	direction = 0;
        	       
        	    }
        	    if(direction == 1 && pageNum != 1)
        	    {
        	    	pageNum--;
        	    	currentPage = currentPage - 9;
        	  if(pageNum == 1)
        	    display =  "Quit [SHIFT]                                  Page:" + pageNum + "/" + pageNumTotal + "                                      Next Page--->\n\n==============================================BACKPACK==========================================================================\n";
        	  else
        		display =  "Quit [SHIFT]                                  Page:" + pageNum + "/" + pageNumTotal + "                      <---Back Page | Next Page--->\n\n==============================================BACKPACK==========================================================================\n";
        	  for(int i = 0;i<9;i++)
                    {
                       itemPrint = inventory.get(i+currentPage).getIdItem() + " x" + inventory.get(i+currentPage).getTotal() + "\n";
                       itemPrint = itemPrint + "===================================================================================================================================================\n";
                       display = display + itemPrint;
                    }
        	    	run.output.setText(display);
        	    	direction = 0;
        	    
        	    }
        	    
        	 }
        }
        else
        {
          for(int i = 0;i<inventory.size();i++)
          {
             itemPrint = inventory.get(i).getIdItem() + " x" + inventory.get(i).getTotal() + "\n";
             itemPrint = itemPrint + "===================================================================================================================================================\n";
             display = display + itemPrint;
          }
          boolean backPrint = false;
          while(quit != true) {
        	  System.out.print("Waiting...");
        	  if(backPrint == false) {
        		  run.output.setText(display);
        		  backPrint = true;
        	  }
          }
        }
        run.output.setText("");
        dCheck = false;
        isOpen = false;
        run.fontSize(20);
    }
    
    public static boolean checkItem(String name, int amt)
    {
        for(int i = 0;i<inventory.size();i++)
        {
           if((inventory.get(i).getIdItem().equals(name)))
           {
                if(inventory.get(i).getTotal() >= amt)
                    return true;
                else
                    return false;
           }
        }
        return false;
    }
    
    public static int itemCount(String name)
    {
    	for(int i = 0;i<inventory.size();i++)
        {
           if((inventory.get(i).getIdItem().equals(name)))
           {
                return inventory.get(i).getTotal();
           }
        }
        return 0;
    }
    public static void add(String name,int amt)
    {
       for(int a = 0;a<amt;a++)
       {
        boolean match = false;
        boolean firstItem = false;
        if(inventory.isEmpty() == true)
            {
                inventory.add(new Slot());
                inventory.get(0).setIdItem(name);
                match = true;
                firstItem = true;
            }
        
       if(firstItem != true)
       {
        for(int i = 0;i<inventory.size();i++)
        {
           if((inventory.get(i).getIdItem().equals(name)))
           {
                inventory.get(i).addItem(name);
                match = true;
           }
        }
        
        if(match == false)
        {
           inventory.add(new Slot());
           inventory.get(inventory.size()-1).setIdItem(name); 
        }
       }
     }
    }
    
    public static void remove(String name, int amt)
    {
        boolean match = false;
        for(int i = 0;i<inventory.size();i++)
        {
           if((inventory.get(i).getIdItem().equals(name)))
           {
               if(inventory.get(i).getTotal() < amt)
               {
                run.append("Not enough materials!");
                run.pause(2000);
                match = true;
               }
               else
               {
                   match = true;
                   int total = inventory.get(i).getTotal();
                 for(int e=0;e<amt;e++)
                 {
                     inventory.get(i).setItem(total-1-e,null);
                 }
                 if(inventory.get(i).getItem(0) == null)
                    inventory.remove(i);
              }
            }
        }
        if(match == false)
        {
            run.append("Material: " + name + " not found!");
            run.pause(2000);
        }
    }
}
