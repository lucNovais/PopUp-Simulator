package main;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window
{
    private final JPanel panel;
    private final JFrame frame;
    private final JButton startButton;
    private int size;
    private Random rand;
    
    public Window(String name)
    {
        rand = new Random();
        
        panel = new JPanel();
        frame = new JFrame(name);
        startButton = new JButton("START!"); 
        
        frame.setBounds(0, 0, 600, 480);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        startButton.setFont(new Font(startButton.getFont().getName(), Font.PLAIN, 50));
        startButton.setSize(new Dimension(230, 80));
        startButton.setLocation(180, 165);
        startButton.addActionListener((ActionEvent e) -> {
            OnClickStart();
        });
        
        panel.setBounds(0, 0, 600, 480);
        panel.setLayout(null);
        panel.add(startButton);
        
        frame.add(panel);
    }
    
    private void OnClickStart()
    {
        System.out.println("Clique!");
        size = rand.nextInt(250);
        if(size < 120)
            while(size < 120)
                size = rand.nextInt(250);
        PopUp(size);
        PopUp(size - 80);
    }
    private void PopUp(int size)
    {
        JFrame framePop = new JFrame();
        JPanel panelPop = new JPanel();
        JButton newStart = new JButton();
        
        int bounds = rand.nextInt(150);
        
        if(bounds < 50)
            while(bounds < 50)
                bounds = rand.nextInt(150);
        int pos = rand.nextInt(2);
        
        if(pos == 0)
            bounds *= -1;
        else
            bounds *= 1;
        
        System.out.println(bounds);
        System.out.println(pos);
        
        framePop.setBounds(size + bounds, size - bounds, size, size);
        framePop.setVisible(true);
        panelPop.setBounds(size + bounds, size - bounds, size, size);
        newStart.setSize(new Dimension(size - 10, size - 10));
        newStart.setText("START!");
        newStart.setLocation(0, 0);
        
        newStart.addActionListener((ActionEvent e) -> {
            OnClickStart();
        });
        
        panelPop.add(newStart);
        framePop.add(panelPop);
    }
}
