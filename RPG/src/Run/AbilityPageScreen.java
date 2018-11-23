package Run;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;


public class AbilityPageScreen extends JPanel {
	public static JTextPane enemyMoves,stats,desc,enemyTitle;
    public FlowLayout layout;
    public JLabel label;
    public static JLabel picSpace;
    public JPanel libraPanel;
    public static JPanel picArea,enemy,report;
    public static boolean confirm,libraOpen;
    private static final Color LIGHT_BLUE = new Color(0,166,255);
    KeyHandler keyHandler = new KeyHandler(this);
    
    public AbilityPageScreen() throws Exception{
    	confirm = false;
    	libraOpen = true;
    	
    	
		
    }
    
    public static int switchPage() {
    	if(RPGRunner.battle == true) {
			while(confirm == false) {
				System.out.println("");
			}
			if(RPGRunner.battle == true && Main.Player.armor[Main.Player.equippedArmor].timeScore() < 4) {
	    		RPGRunner.pTurn = false;
	    		RPGRunner.eTurn = true;
	    	}	
		}else {
			while(confirm == false) {
				System.out.println("");
			}
		}
		libraOpen = false;
		return 0;
    }
    
    public static void append(JTextPane p,String n) {
    	
    	StyledDocument doc = p.getStyledDocument();

    SimpleAttributeSet keyWord = new SimpleAttributeSet();
    StyleConstants.setForeground(keyWord, Color.WHITE);
       try
    	{
    	   doc.insertString(doc.getLength(),n, keyWord);
    	} catch(Exception e) { 
    		System.out.println(e);}
    }

  public static void append(JTextPane p, String n, Color c,int size, boolean bold) {
    	
    	StyledDocument doc = p.getStyledDocument();

    SimpleAttributeSet keyWord = new SimpleAttributeSet();
    StyleConstants.setForeground(keyWord,c);
    StyleConstants.setBold(keyWord, bold);
    if(size != 0)
    	StyleConstants.setFontSize(keyWord, size);
       try
    	{
    	   doc.insertString(doc.getLength(),n, keyWord);
    	} catch(Exception e) { 
    		System.out.println(e);}
    }

       private JPanel init(String pic) throws Exception {
	    System.out.println("Running");
        libraPanel = new JPanel(true);
	    enemy = new JPanel();
        enemy.setLayout(new BoxLayout(enemy, BoxLayout.PAGE_AXIS));
        picArea = new JPanel();      
        picArea.setLayout(new GridBagLayout());
        picArea.setBackground(Color.BLACK);
        report = new JPanel();
        report.setLayout(new BoxLayout(report,BoxLayout.PAGE_AXIS));
        enemy.setBackground(Color.BLACK);
        report.setBackground(Color.BLACK);
        enemy.setPreferredSize(new Dimension(570,580));
        enemy.setMinimumSize(new Dimension(570,580));
        enemy.setMaximumSize(new Dimension(570,580));
        
        report.setPreferredSize(new Dimension(1270-enemy.getWidth()-600,580));
        report.setMaximumSize(new Dimension(1270-enemy.getWidth()-600,580));
        report.setMinimumSize(new Dimension(1270-enemy.getWidth()-600,580));
        report.setFont(new Font("Monospaced", Font.PLAIN, 20));
        report.addKeyListener(keyHandler);
        report.add(Box.createVerticalStrut(34));
        report.setFocusable(false);
        
        stats = new JTextPane();
        stats.setEditable(false);
        stats.setPreferredSize(new Dimension(report.getWidth(),334));
        stats.setBackground(Color.BLACK);
        stats.setForeground(Color.white);
        stats.setFont(new Font("Monospaced", Font.PLAIN, 20));
        stats.setEditable(false);
        stats.setFocusable(false);
        TitledBorder border1 = new TitledBorder("Statistics");
        border1.setTitleColor(Color.WHITE);
        border1.setTitleFont(new Font("Monospaced", Font.BOLD, 18));
        border1.setTitleJustification(TitledBorder.LEFT);
        border1.setTitlePosition(TitledBorder.TOP);
        stats.setBorder(border1);
        
        desc = new JTextPane();
        desc.setEditable(false);
        desc.setPreferredSize(new Dimension(report.getWidth(),225));
        desc.setBackground(Color.BLACK);
        desc.setForeground(Color.white);
        desc.setFont(new Font("Monospaced", Font.PLAIN, 20));
        desc.setEditable(false);
        desc.setFocusable(false);
        TitledBorder border2 = new TitledBorder("Description");
        border2.setTitleColor(Color.WHITE);
        border2.setTitleFont(new Font("Monospaced", Font.BOLD, 18));
        border2.setTitleJustification(TitledBorder.LEFT);
        border2.setTitlePosition(TitledBorder.TOP);
        desc.setBorder(border2);
        report.add(stats);
        report.add(Box.createVerticalStrut(3));
        report.add(desc);
        
        
        enemyTitle = new JTextPane();
        enemyTitle.setEditable(false);
        enemyTitle.setPreferredSize(new Dimension(570,40));
        enemyTitle.setBackground(Color.BLACK);
        enemyTitle.setForeground(Color.white);
        enemyTitle.setFont(new Font("Monospaced", Font.PLAIN, 20));
        enemyTitle.setEditable(false);
        enemyTitle.setFocusable(false);
        
        enemyMoves = new JTextPane();
        enemyMoves.setEditable(false);
        enemyMoves.setPreferredSize(new Dimension(570,220));
        enemyMoves.setBackground(Color.BLACK);
        enemyMoves.setForeground(Color.white);
        enemyMoves.setFont(new Font("Monospaced", Font.PLAIN, 20));
        enemyMoves.setEditable(false);
        enemyMoves.setFocusable(false);
        TitledBorder border3 = new TitledBorder("Behavior");
        border3.setTitleColor(Color.WHITE);
        border3.setTitleFont(new Font("Monospaced", Font.BOLD, 18));
        border3.setTitleJustification(TitledBorder.LEFT);
        border3.setTitlePosition(TitledBorder.TOP);
        enemyMoves.setBorder(border3);
        
        picArea.setPreferredSize(new Dimension(900,320));
        picArea.setMinimumSize(new Dimension(900,320));
       BufferedImage image = ImageIO.read(new File("src/pics/" + pic));	
         picSpace = new JLabel(new ImageIcon(image));
        picArea.add(picSpace);
        enemy.add(enemyTitle);
        enemy.add(picArea);
        enemy.add(Box.createVerticalStrut(8));
        enemy.add(enemyMoves);
        
        
        libraPanel.setLayout(new FlowLayout());
        
        libraPanel.add(enemy);
        libraPanel.add(report);
        libraPanel.setBackground(Color.BLACK);
        libraPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        return libraPanel;
	
}
}
