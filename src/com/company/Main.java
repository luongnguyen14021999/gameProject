package com.company;

import javax.swing.JFrame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Main extends JFrame {

    Painting painting = new Painting();
    public Main()
    {
        setResizable(false);
        setVisible(true);
        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(painting);
        setTitle("Flappy Bird");
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                painting.bird.decreaseY();
            }
        });
    }
    public static void main(String[] args) throws InterruptedException {
          Main main = new Main();
    }
}
