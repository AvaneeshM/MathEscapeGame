/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avaneeshmathescape;

public class Player {
    private String name;
     private int score;
     //sets name and score of the player
    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    //gets the name and score of the player
    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
   
    
}
