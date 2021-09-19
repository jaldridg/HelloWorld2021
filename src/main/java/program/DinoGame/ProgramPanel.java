package src.main.java.program;

import java.awt.*;
import org.json.JSONObject;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import javax.swing.*;
import javax.imageio.*;
import java.net.http.HttpClient;
import java.util.Scanner;

public class ProgramPanel extends JPanel implements MouseListener {
    private BufferedImage buffImg;
    private Dimension size;
    private double temp;
    private JLabel tempIndicator;

    public ProgramPanel(Dimension size) {
        super.addMouseListener(this);
        this.size = size;
        this.setMinimumSize(size);
        this.setPreferredSize(size);
        loadCustomBackground("https://ak.picdn.net/shutterstock/videos/1072439945/thumb/6.jpg");
    }

    private void getCustomBackground() {
        URLConnection con = null;
        try {
            con = new URL("https://picsum.photos/" + this.size.width + "/" + this.size.height).openConnection();
            con.connect();
            InputStream is = con.getInputStream();
            System.out.println("NEW URL: " + con.getURL().toString());
            loadCustomBackground(con.getURL().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    private void loadCustomBackground(String background) {
        try {
            System.out.println(background);
            buffImg = ImageIO.read(new URL(background));
            Image result = buffImg.getScaledInstance(size.width, size.height, Image.SCALE_DEFAULT);
            buffImg.getGraphics().drawImage(result, 0, 0, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        if(buffImg != null) {
            int w = buffImg.getWidth();
            int h = buffImg.getHeight();
            g2.drawImage(buffImg, 0, 0, w, h, null);

        }


    }


    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("Clicked!");
        getCustomBackground();
        this.repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
