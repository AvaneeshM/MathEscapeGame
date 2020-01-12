/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avaneeshmathescape;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


public class GameMenu extends JFrame {

    GameMenu() throws FileNotFoundException, IOException {

        // Create frame
        JFrame frame = new JFrame("Main Menu");

        // Create panel
        JPanel contentPane = new JPanel();

        JTextField usernameTxt = new JTextField();

        contentPane.setOpaque(true);
        contentPane.setBackground(Color.WHITE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        contentPane.setLayout(null);
        JLabel Title = new JLabel("Welcome to Math Escape!");
        JButton btnStart = new JButton("Start Game!");
        Title.setFont(new Font("Serif", Font.PLAIN, 50));
        btnStart.setFont(new Font("Serif", Font.PLAIN, 25));
        Title.setBounds(200, 0, 650, 145);
        btnStart.setBounds(375, 200, 250, 70);
        usernameTxt.setBounds(375, 400, 250, 70);

        contentPane.add(Title);
        contentPane.add(btnStart);
        contentPane.add(usernameTxt);

        frame.setResizable(false);
        frame.setContentPane(contentPane);
        frame.setFocusable(true);
        frame.setSize(1000, 900);
        frame.setVisible(true);
        frame.setResizable(false);
        
        btnStart.addActionListener((ActionEvent e) -> {
            try {
               String enterText = usernameTxt.getText().isEmpty() ? "Anonymous" : usernameTxt.getText();
                boolean userNameFound = false;
                //read all line from file
                List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\Avaneesh\\Desktop\\AvaneeshMathEscape\\MathEscapeGameScore.txt"));
                //create empty PLayer List
                List<Player> playerList = new ArrayList<>();

                //reading each Line of file 
                for (String line : lines) {
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
                Collections.sort(playerList, Collections.reverseOrder(playerComparator));
                //check is player Name exists;
                if (!enterText.equalsIgnoreCase("Anonymous")) {  
                    for (Player playeer : playerList) {
                        if (playeer.getName().equalsIgnoreCase(enterText)) {
                            userNameFound = true;
                        }
                    }

                }
                

                //if the username already exists then it prompts the user to enter a new name                
                if (userNameFound) {
                    JOptionPane.showMessageDialog(frame, "Username already exists enter new name");
                    usernameTxt.setText("");
                }
                //else the user will start the game
                else {
                    JOptionPane.showMessageDialog(frame, "Welcome to Math Escape "+enterText);
                    frame.setVisible(false);
                    dispose();
                    Level1 level1 = new Level1(enterText);
                    

                }
            } catch (IOException ex) {
                Logger.getLogger(GameMenu.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
    }

    public static void main(String[] args) {
        // TODO code application logic here

        SwingUtilities.invokeLater(() -> {
            try {
                GameMenu gameMenu = new GameMenu();
            } catch (IOException ex) {
                Logger.getLogger(GameMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
}
