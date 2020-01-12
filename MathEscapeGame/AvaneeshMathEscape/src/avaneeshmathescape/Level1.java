/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avaneeshmathescape;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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


public class Level1 extends JFrame {
    // sets position for the character
    int xPos = 50;
    int yPos = (int) (250*0.5);
    // used for movement
    int xChangeVal = 0;
    int yChangeVal = 0;
    
    public Timer t = new Timer();
    ArrayList<Door> enemies = new ArrayList();
    // gets the player name
    String playerName;
    
    public Level1(String userName)
    {
        playerName = userName;
        // Creates frame and panel
        JFrame frame = new JFrame("Level One");
        JPanel contentPane = new JPanel();
        
        contentPane.setOpaque(true);
        contentPane.setBackground(Color.WHITE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        contentPane.setLayout(null);
        
        /// labels for the hero, door, question, and answer are created
        JLabel hero = new JLabel(new ImageIcon("C:\\Users\\Avaneesh\\Desktop\\AvaneeshMathEscape\\Hero.png"));
        JLabel Question = new JLabel("What is 3+2+1");
        JLabel Answer1 = new JLabel("6");
        JLabel Answer2 = new JLabel("7");
        JLabel Answer3 = new JLabel("5");
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
        // adds and displays the labels created
        contentPane.add(Question);
        contentPane.add(Answer1);
        contentPane.add(Answer2);
        contentPane.add(Answer3);
        contentPane.add(hero);
        
        
        
        // adds the door to the screen
        for (int x = 0; x < enemies.size(); x++)
        {
            contentPane.add(enemies.get(x));
        }
        
        // this allows us to change the JPanel(content pane)
        frame.setContentPane(contentPane);
        frame.setFocusable(true);
        frame.setSize(1000,900);
        frame.setVisible(true);
        frame.setResizable(false);
        
        // Add the key listener to the frame which will be used to move the character
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
                // if the left arrow key is pressed then hero will move to the left
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    yChangeVal = 0;
                    xChangeVal = -10;
                    
                    //checks are done to see if hero reaches the right door
                    if ((hero.getLocation().x >= 460 && hero.getLocation().x <= 530) && (hero.getLocation().y >= 115 && hero.getLocation().y <= 145)) {
                        t.cancel();
                        // if correct calls on the next level
                        JOptionPane.showMessageDialog(frame, "Answer 1 Correct");
                        frame.setVisible(false);
                        dispose(); 
                        Level2 level2 = new Level2(playerName);
                        

                    }
                    if ((hero.getLocation().x >= 460 && hero.getLocation().x <= 530) && (hero.getLocation().y >= 365 && hero.getLocation().y <= 405)) {
                        t.cancel();
                        JOptionPane.showMessageDialog(frame, "Incorrect Game Over");
                        //if incorrect it calls on the scoreboard to show the scores
                        frame.setVisible(false);
                        dispose(); 
                        try {
                            ScoreBoard board = new ScoreBoard(playerName,0);
                        } catch (IOException ex) {
                            Logger.getLogger(Level1.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                    if ((hero.getLocation().x >= 460 && hero.getLocation().x <= 530) && (hero.getLocation().y >= 605 && hero.getLocation().y <= 655)) {
                        t.cancel();
                        JOptionPane.showMessageDialog(frame, "Incorrect Game Over");
                        //if incorrect it calls on the scoreboard to show the scores
                        frame.setVisible(false);
                        dispose(); 
                        try {
                            ScoreBoard board = new ScoreBoard(playerName,0);
                        } catch (IOException ex) {
                            Logger.getLogger(Level1.class.getName()).log(Level.SEVERE, null, ex);
                        }


                    }
                }
                // if the right arrow key is pressed then hero will move to the right
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    yChangeVal = 0;
                    xChangeVal = 10;
                    
                    if ((hero.getLocation().x >= 460 && hero.getLocation().x <= 530) && (hero.getLocation().y >= 115 && hero.getLocation().y <= 145)) {
                        t.cancel();
                        // if correct calls on the next level
                        JOptionPane.showMessageDialog(frame, "Answer 1 Correct");
                        frame.setVisible(false);
                        dispose(); 
                        Level2 level2 = new Level2(playerName);
                        

                    }
                    if ((hero.getLocation().x >= 460 && hero.getLocation().x <= 530) && (hero.getLocation().y >= 365 && hero.getLocation().y <= 405)) {
                        t.cancel();
                        JOptionPane.showMessageDialog(frame, "Incorrect Game Over");
                        //if incorrect it calls on the scoreboard to show the scores
                        frame.setVisible(false);
                        dispose(); 
                        try {
                            ScoreBoard board = new ScoreBoard(playerName,0);
                        } catch (IOException ex) {
                            Logger.getLogger(Level1.class.getName()).log(Level.SEVERE, null, ex);
                        }


                    }
                    if ((hero.getLocation().x >= 460 && hero.getLocation().x <= 530) && (hero.getLocation().y >= 605 && hero.getLocation().y <= 655)) {
                        t.cancel();
                        JOptionPane.showMessageDialog(frame, "Incorrect Game Over");
                        //if incorrect it calls on the scoreboard to show the scores
                        frame.setVisible(false);
                        dispose(); 
                        try {
                            ScoreBoard board = new ScoreBoard(playerName,0);
                        } catch (IOException ex) {
                            Logger.getLogger(Level1.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                }
                // if the up arrow key is pressed then the hero will move up
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    yChangeVal = -10;
                    xChangeVal = 0;
                    
                    if ((hero.getLocation().x >= 460 && hero.getLocation().x <= 530) && (hero.getLocation().y >= 115 && hero.getLocation().y <= 145)) {
                        t.cancel();
                        JOptionPane.showMessageDialog(frame, "Answer 1 Correct");
                        // if correct calls on the next level
                         frame.setVisible(false);
                         dispose(); 
                        Level2 level2 = new Level2(playerName);

                    }
                    if ((hero.getLocation().x >= 460 && hero.getLocation().x <= 530) && (hero.getLocation().y >= 365 && hero.getLocation().y <= 405)) {
                        t.cancel();
                        JOptionPane.showMessageDialog(frame, "Incorrect Game Over");
                        //if incorrect it calls on the scoreboard to show the scores
                        frame.setVisible(false);
                        dispose(); 
                        try {
                            ScoreBoard board = new ScoreBoard(playerName,0);
                        } catch (IOException ex) {
                            Logger.getLogger(Level1.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                    if ((hero.getLocation().x >= 460 && hero.getLocation().x <= 530) && (hero.getLocation().y >= 605 && hero.getLocation().y <= 655)) {
                        t.cancel();
                        JOptionPane.showMessageDialog(frame, "Incorrect Game Over");
                        frame.setVisible(false);
                        //if incorrect it calls on the scoreboard to show the scores
                        dispose(); 
                        try {
                            ScoreBoard board = new ScoreBoard(playerName,0);
                        } catch (IOException ex) {
                            Logger.getLogger(Level1.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                }
                // if the down arrow key is pressed then the hero will move down
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    yChangeVal = 10;
                    xChangeVal = 0;
                    if ((hero.getLocation().x >= 460 && hero.getLocation().x <= 530) && (hero.getLocation().y >= 115 && hero.getLocation().y <= 145)) {
                        t.cancel();
                        // if correct calls on the next level
                        JOptionPane.showMessageDialog(frame, "Answer 1 Correct");
                         frame.setVisible(false);
                         dispose(); 
                        Level2 level2 = new Level2(playerName);
                        
                    }
                    if ((hero.getLocation().x >= 460 && hero.getLocation().x <= 530) && (hero.getLocation().y >= 365 && hero.getLocation().y <= 405)) {
                        t.cancel();
                        JOptionPane.showMessageDialog(frame, "Incorrect Game Over");
                        frame.setVisible(false);
                        //if incorrect it calls on the scoreboard to show the scores
                        dispose(); 
                        try {
                            ScoreBoard board = new ScoreBoard(playerName,0);
                        } catch (IOException ex) {
                            Logger.getLogger(Level1.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                    if ((hero.getLocation().x >= 460 && hero.getLocation().x <= 530) && (hero.getLocation().y >= 605 && hero.getLocation().y <= 655)) {
                        t.cancel();
                        JOptionPane.showMessageDialog(frame, "Incorrect Game Over");
                        frame.setVisible(false);
                        //if incorrect it calls on the scoreboard to show the scores
                        dispose(); 
                        try {
                            ScoreBoard board = new ScoreBoard(playerName,0);
                        } catch (IOException ex) {
                            Logger.getLogger(Level1.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                }
                
                
                contentPane.repaint();
            }
            
            

        });

        // timer is used to update the movement of the hero
        t.schedule(new TimerTask() {
           @Override
           public void run() 
           {     
               
               hero.setLocation(hero.getX() + xChangeVal, hero.getY() + yChangeVal);
               
           }
        }, 0, 50);
    }
    








}
