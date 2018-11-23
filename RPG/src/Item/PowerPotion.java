package Item;
public class PowerPotion
{
   public static boolean marine = false;
   public static boolean heal = false;
   public static boolean strength = true;
   public static boolean elixer = false;
   public static int healUp = 0;
   public static int strengthUp = 20;
   public static String name = "Power-Potion";
   public static String desc = "Increase Damage by 20% for 1 fight";
   
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
