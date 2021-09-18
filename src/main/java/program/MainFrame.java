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
        System.out.println();
    }

    private int mainFrameWidth = ScreenDimension.getScreenWidth() / 2 / 3;
    private int mainFrameHeight = ScreenDimension.getScreenHeight() / 2 / 3;
    private Dimension mainFrameSize = new Dimension(mainFrameWidth, mainFrameHeight);

    public MainFrame() {


    }
}
