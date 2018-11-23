package Item;
public class Elixer
{
   public static boolean marine = false;
   public static boolean heal = false;
   public static boolean strength = false;
   public static boolean elixer = true;
   public static int healUp;
   public static int strengthUp;
   public static String name = "Elixer";
   public static String desc = "Maxes out Mana and HP. Re-Do Turn";
   
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
