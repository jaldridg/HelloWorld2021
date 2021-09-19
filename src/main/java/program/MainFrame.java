package src.main.java.program;

import src.main.java.program.NASAPanel;
import src.main.java.program.WeatherPanel;
import src.main.java.program.ProgramPanel;
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

    public static void main(String[] args) throws InterruptedException {
        MainFrame mainFrame = new MainFrame("HDash");
        mainFrame.setSize(mainFrame.getMainFrameSize());
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        mainFrame.createPanelArray();
        JPanel[] panels = new JPanel[]{mainFrame.programPanel, mainFrame.nasaPanal, mainFrame.weatherPanel};
        mainFrame.addInitialPanels(panels);
        mainFrame.setVisible(true);

        mainFrame.dinoGame.repaint();

        while (true) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainFrame.nasaPanal.updateLabels();
        }
    }


    //Define sizes for the mainFrame
    private int mainFrameWidth;
    private int mainFrameHeight;
    private Dimension mainFrameSize;

    //Define sizes for the app panels
    private Dimension panelDimension;

    private final GridBagConstraints mainFrameConstraints;
    private NASAPanel nasaPanal;
    private ProgramPanel programPanel;
    private WeatherPanel weatherPanel;
    private final DinoGame dinoGame = new DinoGame();

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

    public void createPanelArray() {

        Dimension panelSize = getPanelDimension();
        nasaPanal = createNasaPanel(getMainFrameSize());
        weatherPanel = new WeatherPanel(getPanelDimension());
        weatherPanel.doGet("https://api.openweathermap.org/data/2.5/onecall?lat=40.43&lon=-86.92&units=imperial&exclude=hourly,daily,alerts,minutely&appid=APIKEY", "WEATHER", false);
        programPanel = new ProgramPanel(getPanelDimension());

        nasaPanal.setPreferredSize(panelSize);
        nasaPanal.setMinimumSize(panelSize);

        weatherPanel.setPreferredSize(panelSize);
        weatherPanel.setMinimumSize(panelSize);

        programPanel.setPreferredSize(panelSize);
        programPanel.setMinimumSize(panelSize);
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
        dinoPanel.add(dinoGame);
        dinoPanel.setPreferredSize(sortingSize);
        dinoPanel.setMinimumSize(sortingSize);
        dinoPanel.setBackground(Color.darkGray);

        mainFrameConstraints.gridy = 1;
        mainFrameConstraints.anchor = GridBagConstraints.CENTER;
        add(dinoPanel, mainFrameConstraints);
    }

    private static NASAPanel createNasaPanel(Dimension size) {
        NASAPanel panel = new NASAPanel(size);
        panel.doGet("https://api.nasa.gov/planetary/apod?api_key=APIKEY", "NASA", true);
        return panel;
    }

    public Dimension getMainFrameSize() {
        return mainFrameSize;
    }

    public Dimension getPanelDimension() {
        return panelDimension;
    }
}
