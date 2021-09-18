import java.awt.*;

/**
 * ScreenDimension
 *
 * Subclass of dimension specifically for holding the dimensions of the screen resolution
 *
 * @author Joseph Miller
 * @version September 18, 2021
 *
 */

public class ScreenDimension extends Dimension {

    private static final Dimension screenRes = Toolkit.getDefaultToolkit().getScreenSize();

    public static int getScreenHeight() {
        return screenRes.height;
    }

    public static int getScreenWidth() {
        return screenRes.width;
    }

    public static Dimension getScreenDim() {
        return screenRes;
    }

}