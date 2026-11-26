package ui.themes;

import java.awt.Color;
import java.awt.Font;

public interface Theme {
    String getName();

    Color primaryBase();

    Color backgroud();

    Color surface();

    Color secondSurface();

    Color primary();

    Color buttonBackgroudColor();

    Color buttonhoverColor();

    Color buttonTextColor();

    Color buttonPressedColor();

    Color buttonDisabledColor();

    Color buttonBorderColor();

    default Color textOverColor() {
        return Color.WHITE;
    }

    Font font(int style, float size);
}
