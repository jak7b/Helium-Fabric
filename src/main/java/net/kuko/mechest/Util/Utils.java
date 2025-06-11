package net.kuko.mechest.Util;

import java.awt.*;

public class Utils {
    public static int getIntFromRGB(Color color) {
        return (color.getRed() << 16) | (color.getGreen() << 8) | color.getBlue();
    }
}
