package src.main.java.program;

import program.NASAPanel;
import src.main.java.program.WeatherPanel;
import src.main.java.utils.ScreenDimension;
import src.main.java.program.DinoGame.DinoGame;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import javax.swing.*;
import java.awt.*;

/**
 * MainFrame
 *
 * Creates the basic frame for the program that contains all components
 *
 * @author Joseph Miller,
 * @version September 18, 2021
 */

public class MainFrame extends JFrame {

    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame("HDash");
        mainFrame.setSize(mainFrame.getMainFrameSize());
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel[] panels = new JPanel[3];

        for (int i = 0; i < panels.length; i++) {
            JPanel panel;
            Dimension panelSize = mainFrame.getPanelDimension();

            if (i == 1) {
                NASAPanel temp =  new NASAPanel(mainFrame.getPanelDimension());
                temp.doGet("https://api.nasa.gov/planetary/apod?api_key=APIKEY", "NASA", true);
                panel = temp;
            } else if (i == 2) {
                WeatherPanel temp = new WeatherPanel(mainFrame.getPanelDimension());
                temp.doGet("https://api.openweathermap.org/data/2.5/onecall?lat=40.43&lon=-86.92&units=imperial&exclude=hourly,daily,alerts,minutely&appid=APIKEY", "WEATHER", false);
                panel = temp;
            }
            else {
                panel = new JPanel();
                panel.setPreferredSize(panelSize);
                panel.setMinimumSize(panelSize);
            }
            panel.setBackground(Color.red);
            panels[i] = panel;
        }

        mainFrame.addInitialPanels(panels);
        mainFrame.setVisible(true);
    }

    //Define sizes for the mainFrame
    private int mainFrameWidth;
    private int mainFrameHeight;
    private Dimension mainFrameSize;

    //Define sizes for the app panels
    private Dimension panelDimension;

    private final GridBagConstraints mainFrameConstraints;

    public MainFrame(String frameName) {
        super(frameName);

        updateDimension(new Dimension(ScreenDimension.getScreenWidth() * 2 / 3,
                                          ScreenDimension.getScreenHeight() * 2 / 3));

        updatePanelDimension(new Dimension(mainFrameWidth * 98 / 100 / 3 , mainFrameHeight * 98 / 100 / 2));

        setLayout(new GridBagLayout());
        mainFrameConstraints = new GridBagConstraints();
    }

    public void updateDimension (Dimension dim) {
        this.mainFrameSize = (dim);
        this.mainFrameHeight = dim.height;
        this.mainFrameWidth = dim.width;
    }

    public void updatePanelDimension (Dimension dim) {
        this.panelDimension = (dim);
    }

    public void addInitialPanels(JPanel[] panels) {
        JPanel topThreePanel = new JPanel();
        Dimension sortingSize = new Dimension(mainFrameWidth, mainFrameHeight / 2);
        System.out.println(sortingSize.width + " " + sortingSize.height);
        topThreePanel.setPreferredSize(sortingSize);
        topThreePanel.setMinimumSize(sortingSize);

        GridBagConstraints topThreeConstraints = new GridBagConstraints();
        topThreeConstraints.ipadx = 0;
        topThreeConstraints.ipady = 0;

        for (int i = 0; i < panels.length; i++) {
            if (i < 3) {
                topThreeConstraints.gridx = i;
                topThreeConstraints.gridy = 0;
            }
            if(i % 2 == 0)
                panels[i].setBackground(Color.black);
            System.out.println(i);
            topThreePanel.add(panels[i], topThreeConstraints);
        }
        mainFrameConstraints.gridx = 0;
        mainFrameConstraints.gridy = 0;
        topThreePanel.setBackground(Color.darkGray);
        add(topThreePanel, mainFrameConstraints);

        //add dino Panel
        JPanel dinoPanel = new JPanel();
        dinoPanel.setPreferredSize(sortingSize);
        dinoPanel.setMinimumSize(sortingSize);
        dinoPanel.setBackground(Color.green);
        dinoPanel.add(new DinoGame());

        mainFrameConstraints.gridy = 1;
        add(dinoPanel, mainFrameConstraints);
    }

    private static NASAPanel addNasaPanel(Dimension size) {
        NASAPanel panel = new NASAPanel(size);
        panel.doGet("https://api.nasa.gov/planetary/apod?api_key=APIKEY", "NASA", true);
        //                                                   0123456789
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/ddHH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String date = dtf.format(now).substring(0, 10);
        String time = dtf.format(now).substring(10);

        JLabel timeLabel = new JLabel(time);
        JLabel dateLabel = new JLabel(date);

        timeLabel.setOpaque(false);
        timeLabel.setFont(new Font("Serif", Font.PLAIN, 60));
        timeLabel.setForeground(Color.white);

        dateLabel.setOpaque(false);
        dateLabel.setFont(new Font("Serif", Font.PLAIN, 60));
        dateLabel.setForeground(Color.white);

        panel.setLayout(new GridBagLayout());

        timeLabel.setHorizontalAlignment(JLabel.CENTER);
        timeLabel.setVerticalAlignment(JLabel.CENTER);

        dateLabel.setHorizontalAlignment(JLabel.CENTER);
        dateLabel.setVerticalAlignment(JLabel.CENTER);

        GridBagConstraints panelConstraints = new GridBagConstraints();
        panelConstraints.gridx = 0;

        panelConstraints.gridy = 0;
        panel.add(dateLabel, panelConstraints);

        panelConstraints.gridy = 1;
        panel.add(timeLabel, panelConstraints);
        return panel;
    }

    public Dimension getMainFrameSize() {
        return mainFrameSize;
    }

    public Dimension getPanelDimension() {
        return panelDimension;
    }
}
