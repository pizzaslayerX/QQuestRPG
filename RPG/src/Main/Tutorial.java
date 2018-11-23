package Main;
import Run.*;
public class Tutorial
{
     public static RPGRunner run;

    public Tutorial(RPGRunner r)
    {
        this.run = r;
    }
    
    public static void tutorFight() throws InterruptedException
    {
        run.append("");
        run.append("============================================================================================\n");
        run.append("Hey, I'm God by the way! This is a gauntlet, so I'm going to throw you right into a battle.\nTry not to die.\n");
        run.append("============================================================================================\n");
        //Queue Tutorial
        String name = "player";
        int eHealth = 1000000;
        int health = 20;
        run.append("Player Health: " + health + " || Menu[m] | Attack[a] | Items[i] | Special[s]: \n");
        run.append("The Legendary Wyvern has " + eHealth + " HP. You're level 1, so you do 1 damage. What's your plan? \n");
        String answer = run.getString();
        run.append("That's a TERRIBLE plan. How about I give you a better weapon.\n");
        Player.userWait();
        run.output.setText("");
        run.append("You equipped ~Excalibur~\n");
        run.append("Go to the menu to check out your sick new weapon.\n");
        run.append("player Health: " + health + " || Menu[m] | Attack[a] | Items[i] | Special[s]: \n");
        answer = run.getString();
        run.append("");
        run.output.setText("");
        run.append("Level 1: Nooby\n");
        run.append("============INVENTORY============\n");
        run.append("Gold: 0\n");
        run.append("Weapon: ~Excalibur~ || Dmg: 250000 | Crit: 100 | Price: $999999999999999999999999999999999999999\n");
        run.append("Weapon Ability: None\n");
        run.append("Armor 1: Plot Armor || Def: ? | You can't die with this on.\n");
        run.append("=================================\n");
        Player.userWait();
        run.append("\n");
        run.append("For the future if you ever want to equip something press [e] to equip it.\n");
        run.append("Equipped items PERMANENTLY replace the item you currently have so choose wisely!\n");
        Player.userWait();
        run.append("");
        run.output.setText("");
        run.append("Now then, ATTACK the enemy!\n");
        run.append("player Health: " + health + " || Menu[m] | Attack[a] | Items[i] | Special[s]: \n");
        answer = run.getString();
        run.output.setText("");
        run.append("You attacked the Legendary Wyvern\n");
        run.append("CRITICAL!!! The Legendary Wyvern lost 500000 HP\n");
        eHealth = eHealth - 500000;
        run.append("The Legendary Wyvern has " + eHealth + " HP.\n");
        Player.userWait();
        run.append("");
        run.output.setText("");
        run.append("The Legendary Wyvern: Pokes you...\n");
        run.append("You lost 19 HP\n");
        health = health - 19;

        Player.userWait();
        run.append("");
        run.output.setText("");
        run.append("Wow, you're pretty screwed. Use an item so that you don't die on your FIRST fight\n");
        run.append("player Health: " + health + " || Menu[m] | Attack[a] | Items[i] | Special[s]: \n");
        answer = run.getString();
        run.append("");
        run.append("================ITEMS================\n");
        run.append("[1]: Elixir\n");
        run.append("=====================================\n");
        run.append("Type a slot number to use an item:\n");
        int answerr = run.getInt();
        run.append("You used a(n) Elixer!\n");
        run.append("Health Maxed out. Turn Priority!\n");
        run.append("");
        run.append("Alright, let's finish this with style. Use a special ability.\n");
        run.append("player Health: 20 || Menu[m] | Attack[a] | Items[i] | Special[s]: \n");
        answer = run.getString();
        run.append("");
        run.output.setText("");
        run.append("=============ABILITIES=============\n");
        run.append("Passives: Scan, Hand of God, Immortality\n");
        run.append("Actives:\n");
        run.append("[1]: Divine Judgement\n");
        run.append("===================================\n");
        run.append("Type a slot number to use an ability:\n");
        run.append("");
        answerr = run.getInt();
        run.output.setText("");
        run.append("You used Divine Judgement...\n");
        Player.userWait();
        run.append("");
        run.output.setText("");
        run.append("The Legendary Wyvern has been burned.\n");
        run.append("The Legendary Wyvern has been poisened.\n");
        run.append("The Legendary Wyvern has been silenced.\n");
        run.append("The Legendary Wyvern has been stunned.\n");
        run.append("The Legendary Wyvern has been cursed.\n");
        run.append("The Legendary Wyvern lost 9999999999 HP.\n");
        run.append("The Legendary Wyvern has been killed.\n");
        Player.userWait();
        run.append("");
        run.output.setText("");
        run.append("Wow. Now that's what I call overkill. \nI'm going to take all of your items and abilities\nas well as any items this boss dropped as compensation for helping.\n");
        run.append("Good luck\n");
        try {
            Thread.sleep(8000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        run.output.setText("");
    }
}
