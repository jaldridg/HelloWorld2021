package main.java.program;

import main.java.utils.ScreenDimension;
import src.main.java.program.APIPanel;
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
        mainFrame.setSize(mainFrame.mainFrameSize);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        APIPanel apiPanel = new APIPanel(mainFrame.panelDimension);
        mainFrame.add(apiPanel);
        mainFrame.setVisible(true);


    }

    //defines sizes for the mainFrame
    private int mainFrameWidth;
    private int mainFrameHeight;
    private Dimension mainFrameSize;

    //defines sizes for the app panels
    private int panelWidth;
    private int panelHeight;
    private Dimension panelDimension;

    public MainFrame(String frameName) {
        super(frameName);

        updateDimension(new Dimension(ScreenDimension.getScreenWidth() * 2 / 3,
                                          ScreenDimension.getScreenHeight() * 2 / 3));

        updatePanelDimension(new Dimension(mainFrameWidth / 3, mainFrameHeight / 2));
    }

    public Dimension updateDimension (Dimension dim) {
        this.mainFrameSize = (dim);
        this.mainFrameHeight = dim.height;
        this.mainFrameWidth = dim.width;
        return dim;
    }

    public Dimension updatePanelDimension (Dimension dim) {
        this.panelDimension = (dim);
        this.panelHeight = dim.height;
        this.panelWidth = dim.width;
        return dim;
    }
    public int getWidth() {
        return mainFrameWidth;
    }
    public int getHeight() {
        return mainFrameHeight;
    }
    public Dimension getDimensions() {
        return mainFrameSize;
    }
}
