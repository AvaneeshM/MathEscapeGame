/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avaneeshmathescape;

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class ScoreBoard {
    int playerScore;
    String playerName;
    
    public ScoreBoard(String userName, int userScore) throws FileNotFoundException, IOException
    {
        playerScore = userScore;
        playerName = userName;
               // BufferedReader br = new BufferedReader(new FileReader(file)); 
        JFrame frame = new JFrame("Scoreboard");
       
        // Create panel
        JPanel contentPane = new JPanel();
        
       

        
        contentPane.setOpaque(true);
        contentPane.setBackground(Color.WHITE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        contentPane.setLayout(null);
        JLabel Title = new JLabel("Scoreboard");
        JTextArea scoreOutput= new JTextArea ("");
        scoreOutput.setEditable(false);
        JScrollPane sP = new JScrollPane(scoreOutput);
        
        Title.setFont(new Font("Serif", Font.PLAIN, 50));
        
        Title.setBounds(200,0, 650, 145);
        scoreOutput.setBounds(200,200, 650, 250);
        
        contentPane.add(scoreOutput);
        contentPane.add(sP);
        contentPane.add(Title);
        
        
        
        frame.setContentPane(contentPane);
        frame.setFocusable(true);
        frame.setSize(1000,900);
        frame.setVisible(true);
        frame.setResizable(false);
        
        
        //Format playerName,playerScore
        StringBuilder buildPlayer = new StringBuilder(playerName);
        buildPlayer.append(",");
        buildPlayer.append(playerScore);
        buildPlayer.append(System.lineSeparator());
        
        String filePath = "C:\\Users\\Avaneesh\\Desktop\\AvaneeshMathEscape\\MathEscapeGameScore.txt";
        File file = new File(filePath);
        //write into file
         BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
         bw.append(buildPlayer.toString());
         bw.close();
         
        
         //read all line from file
                List <String> lines = Files.readAllLines(Paths.get("C:\\Users\\Avaneesh\\Desktop\\AvaneeshMathEscape\\MathEscapeGameScore.txt"));
                //create empty PLayer List
                List<Player> playerList = new ArrayList<>();
                
                //reading each Line of file 
                for(String line : lines){
                    //each Line is a player so we creating an empty player
                    Player player = new Player();
                    
                    //getting playerName
                    String user = line.split(",")[0];
                    //getting score
                    String score = line.split(",")[1];
                    
                    //set name to player object
                    player.setName(user);
                    //set score to player object
                    player.setScore(Integer.parseInt(score));
                    //adding this player to player list
                    playerList.add(player);
                }
              
                             
                
               // sort players based on score               
                Comparator<Player> playerComparator
                 = Comparator.comparing(Player::getScore);
                 Collections.sort(playerList,Collections.reverseOrder(playerComparator));
                 StringBuilder sb = new StringBuilder(); 
                 for(Player p : playerList){
                     if(p.getScore()>=100){
                         //every player is top score
                         sb.append(p.getName()+"  " + p.getScore());
                         sb.append(System.lineSeparator());
                     }
                 }
                // out puts all the scores
                scoreOutput.append(sb.toString());
                
    }
    
    
}
