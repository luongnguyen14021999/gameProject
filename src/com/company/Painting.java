package com.company;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Graphics;
import java.awt.Font;

public class Painting extends JPanel implements Runnable {
    Bird bird = new Bird();
    int x1 = 700, x2 = x1 + 200, x3 = x2 + 200, x4 = x3 + 200;
    int soccer = 0;
    int h1,h2,h3,h4;
    static boolean bl1 = false, bl2 = false, bl3 = false, bl4 = false, bl11 = false, bl22 = false, bl33 = false, bl44 = false;

    Thread t;
    public Painting()  {
        t = new Thread(this);
        t.start();
    }




    public void random()
    {
        Random rand = new Random();
        if(bl1 == false)
        {
            h1 = 50 + rand.nextInt(200);
            bl1 = true;
        }
        if(bl2 == false)
        {
            h2 = 50 + rand.nextInt(200);
            bl2 = true;
        }
        if(bl3 == false)
        {
            h3 = 50 + rand.nextInt(200);
            bl3 = true;
        }
        if(bl4 == false)
        {
            h4 = 50 + rand.nextInt(200);
            bl4 = true;
        }
    }
    public void reduceX()
    {
        x1 = x1 - 1;
        x2 = x2 - 1;
        x3 = x3 - 1;
        x4 = x4 - 1;
    }

    public void iterationX()
    {

        if(x1 == -90)
        {
            x1 = 700;
            bl1 = false;
        }
        if(x2 == -90)
        {
            x2 = 700;
            bl2 = false;
        }
        if(x3 == -90)
        {
            x3 = 700;
            bl3 = false;
        }
        if(x4 == -90)
        {
            x4 = 700;
            bl4 = false;
        }
    }
    public void paint(Graphics g)
    {
        random();
        g.setColor(Color.cyan);
        g.fillRect(0,0, getWidth(), getHeight() );
        g.setColor(Color.orange);
        g.fillRect(0, getHeight() - 100, getWidth(), 100);
        g.setColor(Color.green);
        g.fillRect(0, getHeight() - 100, getWidth(), 20);
        g.setColor(Color.white.darker());
        g.setFont(new Font("Arial", Font.BOLD, 40));
        g.drawString("Soccer:" + " " + soccer, 200, 550);
        g.setColor(Color.green.darker());
        g.fillRect(x1,0,50,getHeight() -250 - h1);
        g.setColor(Color.green.darker());
        g.fillRect(x1,getHeight() -100 - h1, 50, h1);
        g.setColor(Color.green.darker());
        g.fillRect(x2,0,50,getHeight()-250-h2);
        g.setColor(Color.green.darker());
        g.fillRect(x2,getHeight() -100 - h2, 50, h2);
        g.setColor(Color.green.darker());
        g.fillRect(x3,0,50,getHeight()-250-h3);
        g.setColor(Color.green.darker());
        g.fillRect(x3,getHeight() -100 - h3, 50, h3);
        g.setColor(Color.green.darker());
        g.fillRect(x4,0,50,getHeight()-250-h4);
        g.setColor(Color.green.darker());
        g.fillRect(x4,getHeight() -100 - h4, 50, h4);
        bird.paint(g);
        if(die() == true)
        {
            g.setColor(Color.BLUE);
            g.setFont(new Font("Arial", Font.BOLD, 50));
            g.drawString("Game Over", 200, 200);
        }
    }
    public boolean die()
    {
        if((bird.y + bird.height >= 465) || (bird.y == 0))
        {
            return true;
        }

        if((bird.y <= getHeight() - 250 - h1) && ((bird.x + bird.width) >= x1) && (bird.x <= x1 + 50))
        {
            return  true;
        }
        if((bird.y + bird.height >= getHeight() - 100 - h1) && (bird.width + bird.x >= x1) && (bird.x <= x1 + 50))
        {
            return true;
        }
        if((bird.y <= getHeight() - h2 - 250) && ((bird.x + bird.width) >= x2) && (bird.x <= x2 + 50))
        {
            return  true;
        }
        if((bird.y+ bird.height >= getHeight() - 100 - h2) && (bird.width + bird.x >= x2) && (bird.x <= x2 + 50))
        {
            return true;
        }
        if((bird.y <= getHeight() - h3 - 250) && ((bird.x + bird.width) >= x3) && (bird.x <= x3 + 50))
        {
            return  true;
        }
        if((bird.y+ bird.height >= getHeight() - 100 - h3) && (bird.width + bird.x >= x3) && (bird.x <= x3 + 50))
        {
            return true;
        }
        if((bird.y <= getHeight() - h4 - 250) && ((bird.x + bird.width) >= x4) && (bird.x <= x4 + 50))
        {
            return  true;
        }
        if((bird.y+ bird.height >= getHeight() - 100 - h4) && (bird.width + bird.x >= x4) && (bird.x <= x4 + 50))
        {
            return true;
        }
        return false;
    }
    public void soccer()
    {
        if((bird.x + 30 > x1 ) && (bird.x < x1 + 50 ))
        {
            bl11 = true;
        }
        if((bl11 == true) && (bird.x > x1 + 50))
        {
            soccer++;
            bl11 = false;
        }
        if((bird.x + 30 > x2 ) && (bird.x < x2 + 50 ))
        {
            bl22 = true;
        }
        if((bl22 == true) && (bird.x > x2 + 50))
        {
            soccer++;
            bl22 = false;
        }
        if((bird.x + 30 > x3 ) && (bird.x < x3 + 50 ))
        {
            bl33 = true;
        }
        if((bl33 == true) && (bird.x > x3 + 50))
        {
            soccer++;
            bl33 = false;
        }
        if((bird.x + 30 > x4 ) && (bird.x < x4 + 50 ))
        {
            bl44 = true;
        }
        if((bl44 == true) && (bird.x > x4 + 50))
        {
            soccer++;
            bl44 = false;
        }

    }



    @Override
    public void run() {
        while (true)
        {
            repaint();
            reduceX();
            try{
                Thread.sleep(6);
            } catch (InterruptedException e) {
                Logger.getLogger(Painting.class.getName()).log(Level.SEVERE,null,e);
            }

            iterationX();
            bird.increaseY();
            soccer();
            while(die() == true)
            {
                try{
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    Logger.getLogger(Painting.class.getName()).log(Level.SEVERE,null,e);
                }
                t.stop();
            }



        }
    }
}

