package src.main.java.program;

import src.main.java.utils.ScreenDimension;

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

public class MainFrame extends JFrame{

    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame("HDash");
        mainFrame.setSize(mainFrame.getMainFrameSize());
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel[] panels = new JPanel[6];

        for (int i = 0; i < 6; i++) {
            src.main.java.program.NASAPanel NASAPanel = new src.main.java.program.NASAPanel(mainFrame.getPanelDimension());
            if(i == 0) {
                NASAPanel.doGet("https://api.nasa.gov/planetary/apod?api_key=APIKEY", "NASA", true);
            }
            panels[i] = NASAPanel;
        }

        mainFrame.addInitialPanel(panels);
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

        updatePanelDimension(new Dimension(mainFrameWidth / 3 , mainFrameHeight / 2));

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

    public void addInitialPanel(JPanel[] panels) {
        for (int i = 0; i < panels.length; i++) {
            if (i < 3) {
                mainFrameConstraints.gridx = i;
                mainFrameConstraints.gridy = 0;
            }
            else {
                mainFrameConstraints.gridx = i - 3;
                mainFrameConstraints.gridy = 1;
            }
            if(i % 2 == 0)
                panels[i].setBackground(Color.black);
            add(panels[i], mainFrameConstraints);
        }
    }

    public Dimension getMainFrameSize() {
        return mainFrameSize;
    }

    public Dimension getPanelDimension() {
        return panelDimension;
    }
}
