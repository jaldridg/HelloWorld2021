package src.main.java.program;

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
        mainFrame.setVisible(true);
    }

    private int mainFrameWidth;
    private int mainFrameHeight;
    private Dimension mainFrameSize;

    public MainFrame(String frameName) {
        super(frameName);

        mainFrameWidth = ScreenDimension.getScreenWidth() / 2 / 3;
        mainFrameHeight = ScreenDimension.getScreenHeight() / 2 / 3;
        mainFrameSize = new Dimension(mainFrameWidth, mainFrameHeight);
    }

    public Dimension updateDimensions(Dimension dim) {
        this.mainFrameSize = (dim);
        return dim;
    }
}
