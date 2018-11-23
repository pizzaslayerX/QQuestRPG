package Main;
import Run.*;
public class Casino
{
    public static RPGRunner run;
    public static int bet = 0;
    public static int winnings;
    public static boolean win = false;
    public static int roundAmt;
    public static boolean again = false;
    public static double multi = 1;
    public static int number = 1;
    public static int winNum = 1;
    public Casino(RPGRunner r)
   {
    this.run = r;
   }
      public static void dice() throws InterruptedException
   {
       Dungeon.carnivalChoice = false;
       winnings = 0;
       boolean game = true;
       while(game == true)
       {
           bet = 0;
           run.output.setText("");
           run.fontSize(25);
           run.append("Winnings: " + winnings);
           run.append("\nYour gold: " + Player.gold + "\n\n\n");
           run.append(" ___________ \n");
           run.append("|           |\n");
           run.append("|  o     o  |\n");
           run.append("|     o     |\n");
           run.append("|  o     o  |\n");
           run.append("|___________|\n\n");
           run.append("Payout: x3.50\n");
           run.append("Bet Amount: " + bet);
           run.getReset();
           run.append("\n\nHow much money will you bet? [Bet 0 to quit]");
           int amt = run.getInt();
           if(amt < 75 && amt > 0)
           {
           run.append("\nMinimum bet is 75 gold!");
           run.pause(2000);
        }
        else if(amt > Player.gold)
        {
           run.append("\n You don't have that much money!");
           run.pause(2000);
        }
        else if(amt == 0)
            game = false;
        else
        {
            bet = amt;
            Player.gold = Player.gold - bet;
             run.output.setText("");
           run.append("Winnings: " + winnings);
           run.append("\nYour gold: " + Player.gold + "\n\n\n");
           run.append(" ___________ \n");
           run.append("|           |\n");
           run.append("|  o     o  |\n");
           run.append("|     o     |\n");
           run.append("|  o     o  |\n");
           run.append("|___________|\n\n");
           run.append("Payout: x3.50\n");
           run.append("Bet Amount: " + bet);
           run.append("\n\nWhat number are you betting on?");
           run.getReset();
           amt = run.getInt();
           if(amt > 6 || amt < 1)
           {
               run.output.setText("");
           run.append("Winnings: " + winnings);
           run.append("\nYour gold: " + Player.gold + "\n\n\n");
           run.append(" ___________ \n");
           run.append("|           |\n");
           run.append("|  o     o  |\n");
           run.append("|     o     |\n");
           run.append("|  o     o  |\n");
           run.append("|___________|\n\n");
           run.append("Payout: x3.50\n");
           run.append("Bet Amount: " + bet);
           run.append("\n\nThat number isn't on the die.");
           run.pause(2000);
           Player.gold = Player.gold + bet;
           bet = 0;
            }
           else
           {
           number = amt;
           run.output.setText("");
           run.append("Winnings: " + winnings);
           run.append("\nYour gold: " + Player.gold + "\n\n\n");
           run.append(" ___________ \n");
           run.append("|           |\n");
           run.append("|  o     o  |\n");
           run.append("|     o     |        'Enter Anything to Roll Die'\n");
           run.append("|  o     o  |\n");
           run.append("|___________|\n\n");
           run.append("Payout: x3.50\n");
           run.append("Bet Amount: " + bet);
           run.append("\n\nWinning Number: " + number);
            run.getReset();
            run.getString();
           for(int i=0;i<35;i++)
           {
               amt = (int)(Math.random() * 6) + 1;
               if(amt == 1)
               {
                   run.output.setText("");
                           run.append("Winnings: " + winnings);
                           run.append("\nYour gold: " + Player.gold + "\n\n\n");
                           run.append(" ___________ \n");
                           run.append("|           |\n");
                           run.append("|           |\n");
                           run.append("|     o     |\n");
                           run.append("|           |\n");
                           run.append("|___________|\n\n");
                           run.append("Payout: x3.50\n");
                           run.append("Bet Amount: " + bet);
                           run.append("\n\nWinning Number: " + number);
                           winNum = 1;
                }
               else if(amt == 2)
               {
                   run.output.setText("");
                           run.append("Winnings: " + winnings);
                           run.append("\nYour gold: " + Player.gold + "\n\n\n");
                           run.append(" ___________ \n");
                           run.append("|           |\n");
                           run.append("|        o  |\n");
                           run.append("|           |\n");
                           run.append("|  o        |\n");
                           run.append("|___________|\n\n");
                           run.append("Payout: x3.50\n");
                           run.append("Bet Amount: " + bet);
                           run.append("\n\nWinning Number: " + number);
                           winNum = 2;
                }
               else if(amt == 3)
               {
                   run.output.setText("");
                           run.append("Winnings: " + winnings);
                           run.append("\nYour gold: " + Player.gold + "\n\n\n");
                           run.append(" ___________ \n");
                           run.append("|           |\n");
                           run.append("|        o  |\n");
                           run.append("|     o     |\n");
                           run.append("|  o        |\n");
                           run.append("|___________|\n\n");
                           run.append("Payout: x3.50\n");
                           run.append("Bet Amount: " + bet);
                           run.append("\n\nWinning Number: " + number);
                           winNum = 3;
                }
                else if(amt == 4)
               {
                   run.output.setText("");
                           run.append("Winnings: " + winnings);
                           run.append("\nYour gold: " + Player.gold + "\n\n\n");
                           run.append(" ___________ \n");
                           run.append("|           |\n");
                           run.append("|  o     o  |\n");
                           run.append("|           |\n");
                           run.append("|  o     o  |\n");
                           run.append("|___________|\n\n");
                           run.append("Payout: x3.50\n");
                           run.append("Bet Amount: " + bet);
                           run.append("\n\nWinning Number: " + number);
                           winNum = 4;
                }
                else if(amt == 5)
               {
                           run.output.setText("");
                           run.append("Winnings: " + winnings);
                           run.append("\nYour gold: " + Player.gold + "\n\n\n");
                           run.append(" ___________ \n");
                           run.append("|           |\n");
                           run.append("|  o     o  |\n");
                           run.append("|     o     |\n");
                           run.append("|  o     o  |\n");
                           run.append("|___________|\n\n");
                           run.append("Payout: x3.50\n");
                           run.append("Bet Amount: " + bet);
                           run.append("\n\nWinning Number: " + number);
                           winNum = 5;
                }
                else if(amt == 6)
               {
                   run.output.setText("");
                           run.append("Winnings: " + winnings);
                           run.append("\nYour gold: " + Player.gold + "\n\n\n");
                           run.append(" ___________ \n");
                           run.append("|           |\n");
                           run.append("|  o     o  |\n");
                           run.append("|  o     o  |\n");
                           run.append("|  o     o  |\n");
                           run.append("|___________|\n\n");
                           run.append("Payout: x3.50\n");
                           run.append("Bet Amount: " + bet);
                           run.append("\n\nWinning Number: " + number);
                           winNum = 6;
                }
                run.pause(50);
            }
            if(winNum == number)
            {
                winnings = winnings + (int)(bet * 3.5) - bet;
                Player.gold = Player.gold + (int)(bet * 3.5);
            }
            else
            {
                winnings = winnings - bet;
            }
            run.pause(3000);
         }
        }
        }
        run.output.setText("");
        run.fontSize(20);
       if(winnings > 100)
        Story.saveAsk();
        run.output.setText("");
        run.fontSize(30);
        Dungeon.carnivalChoice = true;
    }
   public static void wheel() throws InterruptedException
   {
       Dungeon.carnivalChoice = false;
       winnings = 0;
       boolean game = true;
       while(game == true)
      {
        bet = 0;
        again = true;
       run.output.setText("");
       run.append("Winnings: " + winnings);
       run.append("\nYour gold: " + Player.gold + "\n\n\n\n");
       run.append("                             =======================\n");
       run.append("                                 ~SPIN  TO  WIN~\n");
       run.append("                             =======================\n\n");
       run.append("Bet Amount: " + bet);
       run.getReset();
       run.append("\n\nHow much money will you bet? [Bet 0 to quit]");
       int amt = run.getInt();
       if(amt < 50 && amt > 0)
       {
           run.append("\nMinimum bet is 50 gold!");
           run.pause(2000);
        }
       else if(amt > Player.gold)
       {
           run.append("\n You don't have that much money!");
           run.pause(2000);
        }
       else if(amt == 0)
            game = false;
       else
        {
            bet = amt;
            Player.gold = Player.gold - bet;
             run.output.setText("");
             run.append("Winnings: " + winnings);
             run.append("\nYour gold: " + Player.gold + "\n\n\n\n");
             run.append("                             =======================\n");
             run.append("                                 ~SPIN  TO  WIN~\n");
             run.append("                             =======================\n");
             run.append("Bet Amount: " + bet);
             run.append("\n\n Spin to win...");
             run.getReset();
             String spin = run.getString();
             Playlist.playEffect("/sounds/SlotPull.wav");
             run.pause(550);
             Playlist.playEffect("/sounds/SlotSpin.wav");
             Playlist.songBank[1].loop(1);
             if(!(spin.equals("quuincy is gay")))
            {
                
              while(again == true)
             {
                run.output.setText("");
             run.append("Winnings: " + winnings);
             run.append("\nYour gold: " + Player.gold + "\n\n\n\n");
             run.append("============        ============        ============\n");
             run.append("------------        ------------        ------------\n");
             run.append("============        ============        ============\n");
             run.append("Bet Amount: " + bet);
             run.append("\n\nSpinning 1st Wheel...");
             run.pause(3000);
             int award = (int)(Math.random() * 2) + 1;
             if(award == 1)
             {
                 run.output.setText("");
                 win = true;
                 run.append("Winnings: " + winnings);
                 run.append("\nYour gold: " + Player.gold + "\n\n\n\n");
                 run.append("============        ============        ============\n");
                 run.append("    Win             ------------        ------------\n");
                 run.append("============        ============        ============\n");
                 run.append("Bet Amount: " + bet);
                 run.append("\n\nSpinning 2nd Wheel...");
                 run.pause(3000);
                  amt = (int)(Math.random() * 5) + 1;
                 switch(amt)
                 {
                     case 1:
                        multi = 0.50;
                        break;
                     case 2:
                        multi = 1.00;
                        break;
                     case 3:
                        multi = 2.00;
                        break;
                     case 4:
                        multi = 1.50;
                        break;
                     case 5:
                        multi = 3.00;
                        break;
                 }
                 run.output.setText("");
                 String formattedString = String.format("%.02f", multi);
                 run.append("Winnings: " + winnings);
                 run.append("\nYour gold: " + Player.gold + "\n\n\n\n");
                 run.append("============        ============        ============\n");
                 run.append("    Win                x" + formattedString + "            ------------\n");
                 run.append("============        ============        ============\n");
                 run.append("Bet Amount: " + bet);
                 run.append("\n\nSpinning 3rd Wheel...");
                 run.pause(3000);
                 amt = (int)(Math.random() * 2) + 1;
                 if(amt == 1)
                 {
                     run.output.setText("");
                     run.append("Winnings: " + winnings);
                     run.append("\nYour gold: " + Player.gold + "\n\n\n\n");
                     run.append("============        ============        ============\n");
                     run.append("    Win                x" + formattedString + "               Final\n");
                     run.append("============        ============        ============\n");
                     run.append("Bet Amount: " + bet);
                     again = false;
                 }
                 else
                 {
                     run.output.setText("");
                     run.append("Winnings: " + winnings);
                     run.append("\nYour gold: " + Player.gold + "\n\n\n\n");
                     run.append("============        ============        ============\n");
                     run.append("    Win                x" + formattedString + "             Spin Again\n");
                     run.append("============        ============        ============\n");
                     run.append("Bet Amount: " + bet);
                     again = true;
                 }
              }
             else if(award == 2)
             {
                 run.output.setText("");
                 win = false;
                 run.append("Winnings: " + winnings);
                 run.append("\nYour gold: " + Player.gold + "\n\n\n\n");
                 run.append("============        ============        ============\n");
                 run.append("    Lose            ------------        ------------\n");
                 run.append("============        ============        ============\n");
                 run.append("Bet Amount: " + bet);
                 run.append("\n\nSpinning 2nd Wheel...");
                 run.pause(3000);
                  amt = (int)(Math.random() * 5) + 1;
                 switch(amt)
                 {
                     case 1:
                        multi = 0.50;
                        break;
                     case 2:
                        multi = 1.00;
                        break;
                     case 3:
                        multi = 1.25;
                        break;
                     case 4:
                        multi = 1.50;
                        break;
                     case 5:
                        multi = 2.00;
                        break;
                 }
                  run.output.setText("");
                 run.append("Winnings: " + winnings);
                 String formattedString = String.format("%.02f", multi);
                 run.append("\nYour gold: " + Player.gold + "\n\n\n\n");
                 run.append("============        ============        ============\n");
                 run.append("    Lose               x" + formattedString + "            ------------\n");
                 run.append("============        ============        ============\n");
                 run.append("Bet Amount: " + bet);
                 run.append("\n\nSpinning 3rd Wheel...");
                 run.pause(3000);
                 amt = (int)(Math.random() * 2) + 1;
                 if(amt == 1)
                 {
                     run.output.setText("");
                     run.append("Winnings: " + winnings);
                     run.append("\nYour gold: " + Player.gold + "\n\n\n\n");
                     run.append("============        ============        ============\n");
                     run.append("    Lose               x" + formattedString + "                Final\n");
                     run.append("============        ============        ============\n");
                     run.append("Bet Amount: " + bet);
                     again = false;
                 }
                 else
                 {
                     run.output.setText("");
                      run.append("Winnings: " + winnings);
                     run.append("\nYour gold: " + Player.gold + "\n\n\n\n");
                     run.append("============        ============        ============\n");
                     run.append("    Lose               x" + formattedString + "             Spin Again\n");
                     run.append("============        ============        ============\n");
                     run.append("Bet Amount: " + bet);
                     again = true;
                 }
              }
             if(win == true && again == false)
             {
                 roundAmt = (int)(bet * multi);
                 winnings = winnings + roundAmt - bet;
                 Player.gold = Player.gold + roundAmt;
                 again = false;
                 Playlist.playEffect("/sounds/GambleWin.wav");
              }
             else if(win == false && again == false)
             {
                 roundAmt = (int)(bet * multi);
                 roundAmt = roundAmt * -1;
                 winnings = winnings + roundAmt - bet;
                 Player.gold = Player.gold + roundAmt;
                 again = false;
                 Playlist.playEffect("/sounds/GambleLose.wav");
              }
              if(Player.gold < 0)
                Player.gold = 0;
              run.pause(3000);
             }
            }
             else
                game = false;
        }
    }
            run.output.setText("");
        run.fontSize(20);
      if(winnings > 100)
        Story.saveAsk();
        run.output.setText("");
        run.fontSize(30);
         Dungeon.carnivalChoice = true;
    }

}
