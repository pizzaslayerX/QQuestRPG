package Item;
public class MegaPotion
{
   private static boolean marine = false;
   private static boolean heal = true;
   private static boolean strength = false;
   private static boolean elixer = false;
   private static int healUp = 80;
   private static int strengthUp = 0;
   private static String name = "Mega-Potion";
   private static String desc = "Heals 80% of health";
   public static void newItem() throws InterruptedException
   {
       ItemManager.newItem(heal,strength,elixer,healUp,strengthUp,name,desc,marine);
       ItemManager.setItem();
   }
          public static void lootItem() throws InterruptedException
   {
       Main.LootScreen.setLootItem((name + " | " + desc));
       ItemManager.newItem(heal,strength,elixer,healUp,strengthUp,name,desc,marine);
       ItemManager.setItem();
    }
}
