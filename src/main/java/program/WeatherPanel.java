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
import java.util.Scanner;

public class WeatherPanel extends JPanel {
    private HttpURLConnection con;
    private String weatherAuth = "";
    private JSONObject getRequestJSON;
    private BufferedImage buffImg;
    private Dimension size;
    private double temp;
    private JLabel tempIndicator;

    public WeatherPanel(Dimension size) {
        this.size = size;
        this.setMinimumSize(size);
        this.setPreferredSize(size);
        try {
            File authFile = new File("authkey.txt");
            Scanner sc = new Scanner(authFile);
            sc.nextLine();
            weatherAuth = sc.nextLine();
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        loadBackground();
        this.tempIndicator = new JLabel(""+ temp + "°F");
        this.setLayout(new GridBagLayout());
        tempIndicator.setHorizontalAlignment(JLabel.CENTER);
        tempIndicator.setVerticalAlignment(JLabel.CENTER);
        tempIndicator.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        this.add(tempIndicator);
    }
    // CREDIT: https://zetcode.com/java/getpostrequest/
    public JSONObject getRequest(String requestURL, String authType) {
        if(authType.equalsIgnoreCase("WEATHER")) {
                requestURL = requestURL.replace("APIKEY", weatherAuth);
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
                con.disconnect();
                return (new JSONObject(content.toString()));
            } catch (Exception e) {
                e.printStackTrace();
                con.disconnect();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            con.disconnect();
        }
        return null;
    }
    public void doGet(String requestURL, String authType, boolean downloadImage) {
        getRequestJSON = getRequest(requestURL, authType);
        System.out.println(getRequestJSON.toString());
        if(downloadImage) {
            try {
                buffImg = ImageIO.read(new URL(getRequestJSON.getString("url")));
                Image result = buffImg.getScaledInstance(size.width, size.height, Image.SCALE_DEFAULT);
                buffImg.getGraphics().drawImage(result, 0, 0, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        this.temp = getRequestJSON.getJSONObject("current").getDouble("temp");
        String weatherDesc = getRequestJSON.getJSONObject("current").getJSONArray("weather").getJSONObject(0).getString("main");
        int humidity = getRequestJSON.getJSONObject("current").getInt("humidity");
        tempIndicator.setText(""+ temp + "°F\n" + weatherDesc + "\nHumidity: " + humidity + "%");
    }

    private void loadBackground() {
        try {
            buffImg = ImageIO.read(new URL("https://images.unsplash.com/photo-1603376277241-70b32265cf10?ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8Ymx1ZSUyMGNsb3Vkc3xlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&w=1000&q=80"));
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









}
