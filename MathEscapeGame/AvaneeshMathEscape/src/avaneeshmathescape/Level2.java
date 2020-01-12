/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avaneeshmathescape;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class Level2 extends JFrame{
    int xPos = 50;
    int yPos = (int) (250*0.5);
    int xChangeVal = 0;
    int yChangeVal = 0;
    public Timer t = new Timer();
    ArrayList<Door> enemies = new ArrayList();
    String playerName;
    
    public Level2(String userName)
    {
        playerName = userName;
        // Create frame
        JFrame frame = new JFrame("Level Two");
       
       
        // Create panel
        JPanel contentPane = new JPanel();
        
        contentPane.setOpaque(true);
        contentPane.setBackground(Color.WHITE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        contentPane.setLayout(null);
        // Create hero
        
        JLabel hero = new JLabel(new ImageIcon("C:\\Users\\Avaneesh\\Desktop\\AvaneeshMathEscape\\Hero.png"));
        JLabel Question = new JLabel("What is 3-2-1");
        JLabel Answer1 = new JLabel("1");
        JLabel Answer2 = new JLabel("2");
        JLabel Answer3 = new JLabel("0");
        Dimension size = hero.getPreferredSize();
        hero.setBounds(xPos, yPos, size.width, size.height);
        Question.setBounds(200,0, 650, 145);
        Question.setFont(new Font("Serif", Font.PLAIN, 100));
        
        Answer1.setBounds(650,50, 250, 300);
        Answer1.setFont(new Font("Serif", Font.PLAIN, 75));
        
        Answer2.setBounds(650,300, 250, 300);
        Answer2.setFont(new Font("Serif", Font.PLAIN, 75));
        
        Answer3.setBounds(650,550, 250, 300);
        Answer3.setFont(new Font("Serif", Font.PLAIN, 75));
        
        for (int x = 0; x < 3; x++)
        {
            Door temp = new Door(new ImageIcon("C:\\Users\\Avaneesh\\Desktop\\AvaneeshMathEscape\\Door.jpg"));
          
            temp.setX(500);
            if (x==0){
                temp.setY((int) (250*0.5));
            }
            else if (x==1){
                temp.setY((int) (250*1.5));
            }
            else if (x==2){
                temp.setY((int) (250*2.5));
            }
           
            
           
            enemies.add(temp);
        }
        

        // Add labels to panel
        contentPane.add(Question);
        contentPane.add(Answer1);
        contentPane.add(Answer2);
        contentPane.add(Answer3);
        contentPane.add(hero);
        
        
        
        for (int x = 0; x < enemies.size(); x++)
        {
            contentPane.add(enemies.get(x));
        }
        
        frame.setResizable(false);
        frame.setContentPane(contentPane);
        frame.setFocusable(true);
        frame.setSize(1000,900);
        frame.setVisible(true);
        
        frame.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                yChangeVal = 0;
                xChangeVal = 0;
            }

            @Override
            public void keyPressed(KeyEvent e) {
                //  React to keys
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    yChangeVal = 0;
                    xChangeVal = -10;
                    if ((hero.getLocation().x >= 460 && hero.getLocation().x <= 530) && (hero.getLocation().y >= 115 && hero.getLocation().y <= 145)) {
                        t.cancel();
                        JOptionPane.showMessageDialog(frame, "Incorrect Game Over");
                         try {
                            ScoreBoard board = new ScoreBoard(playerName,100);
                        } catch (IOException ex) {
                            Logger.getLogger(Level1.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                    if ((hero.getLocation().x >= 460 && hero.getLocation().x <= 530) && (hero.getLocation().y >= 365 && hero.getLocation().y <= 405)) {
                        t.cancel(); try {
                            ScoreBoard board = new ScoreBoard(playerName,100);
                        } catch (IOException ex) {
                            Logger.getLogger(Level1.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        JOptionPane.showMessageDialog(frame, "Incorrect Game Over");

                    }
                    if ((hero.getLocation().x >= 460 && hero.getLocation().x <= 530) && (hero.getLocation().y >= 605 && hero.getLocation().y <= 655)) {
                        t.cancel();
                       
                        JOptionPane.showMessageDialog(frame, "Answer 3 Correct");
                        frame.setVisible(false);
                        dispose(); 
                        Level3 level3 = new Level3(playerName);
                        

                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    yChangeVal = 0;
                    xChangeVal = 10;
                    if ((hero.getLocation().x >= 460 && hero.getLocation().x <= 530) && (hero.getLocation().y >= 115 && hero.getLocation().y <= 145)) {
                        t.cancel();
                         JOptionPane.showMessageDialog(frame, "Incorrect Game Over");
                         try {
                            ScoreBoard board = new ScoreBoard(playerName,100);
                        } catch (IOException ex) {
                            Logger.getLogger(Level1.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                    if ((hero.getLocation().x >= 460 && hero.getLocation().x <= 530) && (hero.getLocation().y >= 365 && hero.getLocation().y <= 405)) {
                        t.cancel();
                        JOptionPane.showMessageDialog(frame, "Incorrect Game Over");
                         try {
                            ScoreBoard board = new ScoreBoard(playerName,100);
                        } catch (IOException ex) {
                            Logger.getLogger(Level1.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                    if ((hero.getLocation().x >= 460 && hero.getLocation().x <= 530) && (hero.getLocation().y >= 605 && hero.getLocation().y <= 655)) {
                        t.cancel();
                        JOptionPane.showMessageDialog(frame, "Answer 3 Correct");
                        frame.setVisible(false);
                        dispose(); 
                        Level3 level3 = new Level3(playerName);
                       

                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    yChangeVal = -10;
                    xChangeVal = 0;
                    if ((hero.getLocation().x >= 460 && hero.getLocation().x <= 530) && (hero.getLocation().y >= 115 && hero.getLocation().y <= 145)) {
                        t.cancel();
                        JOptionPane.showMessageDialog(frame, "Incorrect Game Over");
                         try {
                            ScoreBoard board = new ScoreBoard(playerName,100);
                        } catch (IOException ex) {
                            Logger.getLogger(Level1.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                    if ((hero.getLocation().x >= 460 && hero.getLocation().x <= 530) && (hero.getLocation().y >= 365 && hero.getLocation().y <= 405)) {
                        t.cancel();
                        JOptionPane.showMessageDialog(frame, "Incorrect Game Over");
                         try {
                            ScoreBoard board = new ScoreBoard(playerName,100);
                        } catch (IOException ex) {
                            Logger.getLogger(Level1.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                    if ((hero.getLocation().x >= 460 && hero.getLocation().x <= 530) && (hero.getLocation().y >= 605 && hero.getLocation().y <= 655)) {
                        t.cancel();
                         JOptionPane.showMessageDialog(frame, "Answer 3 Correct");
                        frame.setVisible(false);
                        dispose(); 
                        Level3 level3 = new Level3(playerName);
                        

                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    yChangeVal = 10;
                    xChangeVal = 0;
                    if ((hero.getLocation().x >= 460 && hero.getLocation().x <= 530) && (hero.getLocation().y >= 115 && hero.getLocation().y <= 145)) {
                        t.cancel();
                        JOptionPane.showMessageDialog(frame, "Incorrect Game Over");
                        try {
                            ScoreBoard board = new ScoreBoard(playerName,100);
                        } catch (IOException ex) {
                            Logger.getLogger(Level1.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    if ((hero.getLocation().x >= 460 && hero.getLocation().x <= 530) && (hero.getLocation().y >= 365 && hero.getLocation().y <= 405)) {
                        t.cancel();
                        JOptionPane.showMessageDialog(frame, "Incorrect Game Over");
                         try {
                            ScoreBoard board = new ScoreBoard(playerName,100);
                        } catch (IOException ex) {
                            Logger.getLogger(Level1.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                    if ((hero.getLocation().x >= 460 && hero.getLocation().x <= 530) && (hero.getLocation().y >= 605 && hero.getLocation().y <= 655)) {
                        t.cancel();
                         JOptionPane.showMessageDialog(frame, "Answer 3 Correct");
                        frame.setVisible(false);
                        dispose(); 
                        Level3 level3 = new Level3(playerName);
                        

                    }
                }
                
                
                contentPane.repaint();
            }
            
            

        });

        
        t.schedule(new TimerTask() {
           @Override
           public void run() 
           {     
               
               hero.setLocation(hero.getX() + xChangeVal, hero.getY() + yChangeVal);
               
           }
        }, 0, 50);
    }
}
    
    

        
