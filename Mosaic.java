// Jake Mikiewicz
// Due: March 14, 2021 @ 11:59 PM
// File: Mosaic.java

// Imports
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Container; 
import java.awt.GridLayout;
import java.awt.BorderLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.util.Random;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

import java.util.ArrayList;

class Tile extends JPanel implements MouseListener {
    private int red, green, blue;
    private String letter;

    // Face Getters and Setters
    public boolean drawface; // Causes the drawface
    public Face myFace; // Our Face
    int facetype;
    public void setFaceType(int newfacetype) {this.facetype = newfacetype;}
    public int getFaceType() { return facetype;}

    Tile() {
        super();
        SetRandomValues();
        drawface = false;
        Face myFace = new Face(3,3, getWidth()-3, getHeight()-3);
        addMouseListener(this);
    }

    //Non default tile constructor that can change the default drawface value.
    Tile(boolean NewFace) {
        super();
        SetRandomValues();
        this.drawface = NewFace;
        Face myFace = new Face(3,3, getWidth()-3, getHeight()-3);
        addMouseListener(this);
    }

    final public void SetRandomValues() {
        red = GetNumberBetween(0,255);
        green = GetNumberBetween(0,255);
        blue = GetNumberBetween(0,255);

        letter = "A";

        if (GetNumberBetween(0,25) == 1) {
            letter = "B";
        }
        else if (GetNumberBetween(0,25) == 2) {
            letter = "C";
        }
        else if (GetNumberBetween(0,25) == 3) {
            letter = "D";
        }
        else if (GetNumberBetween(0,25) == 4) {
            letter = "E";
        }
        else if (GetNumberBetween(0,25) == 5) {
            letter = "F";
        }
        else if (GetNumberBetween(0,25) == 6) {
            letter = "G";
        }
        else if (GetNumberBetween(0,25) == 7) {
            letter = "H";
        }
        else if (GetNumberBetween(0,25) == 8) {
            letter = "I";
        }
        else if (GetNumberBetween(0,25) == 9) {
            letter = "J";
        }
        else if (GetNumberBetween(0,25) == 10) {
            letter = "K";
        }
        else if (GetNumberBetween(0,25) == 11) {
            letter = "L";
        }
        else if (GetNumberBetween(0,25) == 12) {
            letter = "M";
        }
        else if (GetNumberBetween(0,25) == 13) {
            letter = "N";
        }
        else if (GetNumberBetween(0,25) == 14) {
            letter = "O";
        }
        else if (GetNumberBetween(0,25) == 15) {
            letter = "P";
        }
        else if (GetNumberBetween(0,25) == 16) {
            letter = "Q";
        }
        else if (GetNumberBetween(0,25) == 17) {
            letter = "R";
        }
        else if (GetNumberBetween(0,25) == 18) {
            letter = "S";
        }
        else if (GetNumberBetween(0,25) == 19) {
            letter = "T";
        }
        else if (GetNumberBetween(0,25) == 20) {
            letter = "U";
        }
        else if (GetNumberBetween(0,25) == 21) {
            letter = "V";
        }
        else if (GetNumberBetween(0,25) == 22) {
            letter = "W";
        }
        else if (GetNumberBetween(0,25) == 23) {
            letter = "X";
        }
        else if (GetNumberBetween(0,25) == 24) {
            letter = "Y";
        }
        else if (GetNumberBetween(0,25) == 25) {
            letter = "Z";
        }
    }

    private static int GetNumberBetween(int min, int max) {
        Random Random = new Random();
        return min + Random.nextInt(max - min + 1);
    }   

     public void paintComponent(Graphics g) {
        super.paintComponent(g); 

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        // Draws Actual Face
        if(drawface == true) {
            // left eye
            g.fillArc(10, 10, panelWidth/2, panelHeight - 10, 0, 360);        
            g.setColor( Color.black);

            // right eye
            g.drawArc(10, 10, panelWidth/2, panelHeight - 10, 0, 360);
            g.setColor(Color.white);

            // left eye
            g.fillArc(10,20,10,10,0,360);

            // right eye
            g.fillArc(30,20,10,10,0,360);

            // mouth
            g.drawArc(15, 30, 20, 10, 0, -180 );
    
        } else {


        g.setColor(new Color(red, green, blue));

        if (GetNumberBetween(0,1) == 0) {
            g.fillOval(0, 0, panelWidth, panelHeight);
        } else {
            g.fillRect(0, 0, panelWidth, panelHeight);

        }

        g.setColor(new Color(GetContrastingColor(red),GetContrastingColor(green),GetContrastingColor(blue)));


        final int fontSize = 20;

        g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
        int stringX = (panelWidth / 2) - 4;
        int stringY = (panelHeight / 2) + 10;
        g.drawString(letter, stringX, stringY);
    }
}

    private static int GetContrastingColor(int colorIn) {
        return ((colorIn + 128) %256);
    }

    public void mousePressed(MouseEvent e) {System.out.println("Mouse pressed");}
    public void mouseReleased(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {drawface = true; repaint();}
    public void mouseExited(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
}

class MosaicFrame extends JFrame implements ActionListener {
    private ArrayList<Tile> tileList;
    final static int GridSize = 12;

    public MosaicFrame() {
        setBounds(200,10,700,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        // Randomizer button
        JButton randomize = new JButton("Randomize!");
        buttonPanel.add(randomize);
        randomize.addActionListener(this);

        JPanel GridPanel = new JPanel();
        contentPane.add(GridPanel, BorderLayout.CENTER);
        GridPanel.setLayout(new GridLayout(GridSize,GridSize));

        tileList = new ArrayList<Tile>();
        for(int i = 0; i<(GridSize*GridSize); i++) {
            Tile tile = new Tile();
            tileList.add(tile);
            GridPanel.add(tile);
            System.out.print(tile);
            System.out.print("\n");
        }
    }

    public void actionPerformed(ActionEvent e) {
        for(Tile tile : tileList) {
            tile.SetRandomValues();
        }
        repaint();
    }
}

public class Mosaic {
    public static void main(String[] args) {
        System.out.println("Start paint***");

        MosaicFrame myMosaicFrame = new MosaicFrame();
        myMosaicFrame.setVisible(true);
    }
}