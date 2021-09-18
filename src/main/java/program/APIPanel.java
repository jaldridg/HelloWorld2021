package src.main.java.program;
import java.awt.*;
import org.json.JSONObject;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import javax.swing.*;
import javax.imageio.*;
import java.util.Scanner;

public class APIPanel extends JPanel {
    private JPanel panel;
    private HttpURLConnection con;
    private String nasaAuth = "";
    private JSONObject getRequestJSON;
    private BufferedImage buffImg;
    public APIPanel(Dimension size) {
        this.setSize(size);
        this.setBackground(Color.darkGray);
        try {
            File authFile = new File("authkey.txt");
            Scanner sc = new Scanner(authFile);
            nasaAuth = sc.nextLine();
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    // CREDIT: https://zetcode.com/java/getpostrequest/

    public void doGet(String requestURL, String authType, boolean downloadImage) {
        if(authType.toUpperCase().equals("NASA")) {
            requestURL = requestURL.replace("APIKEY", nasaAuth);
        }
        try {
            URL url = new URL(requestURL);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            StringBuilder content;
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                String line;
                content = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    content.append(line);
                    content.append(System.lineSeparator());
                }
                getRequestJSON = new JSONObject(content.toString());
            } catch (Exception e) {
                e.printStackTrace();
                con.disconnect();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            con.disconnect();
        }
        try {
            buffImg = ImageIO.read(new URL(getRequestJSON.getString("url")));

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        int w = buffImg.getWidth();
        int h = buffImg.getHeight();
        g2.drawImage(buffImg, 0, 0, w, h, null);
    }









}
