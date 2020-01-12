/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avaneeshmathescape;

import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Door extends JLabel {
    private int x;
    private int y;
    public Door(String img) 
    {
        this(new ImageIcon(img));
    }

    public Door(ImageIcon icon) 
    {
        setIcon(icon);
        setSize(icon.getImage().getWidth(null), icon.getImage().getHeight(null));
    }
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    public void setX(int t)
    {
        x = t;
    }
    public void setY(int t)
    {
        y = t;
    }
    

    

    

    
}
