package Item;

public class Ultramarine
{  private static boolean heal = false;
   private static boolean marine = true;
   private static boolean strength = false;
   private static boolean elixer = false;
   private static int healUp = 0;
   private static int strengthUp = 0;
   private static String name = "Ultramarine";
   private static String desc = "Restores 50% of mana. Re-Do Turn";
   
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
