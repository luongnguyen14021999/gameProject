package com.company;

import java.awt.Graphics;
import java.awt.Color;

public class Bird {

    int x = 100, y = 100;
    int width = 30, height = 30;
    public void paint(Graphics g)  {
        g.setColor(Color.red);
        g.fillRect(x, y, width, height);
    }
    public void increaseY()
    {
        y = y + 1;
    }
    public void decreaseY()
    {

        y = y - 35 ;
    }

}
