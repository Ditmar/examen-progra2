package ui.themes;

import java.awt.Color;
import java.awt.Font;

public class BaseTheme implements Theme {

    @Override
    public String getName() {
        return "Base Theme";
    }

    @Override
    public Color backgroud() {
        return hex("#355872");
    }

    @Override
    public Color surface() {
        return hex("#F7F8F0");
    }

    @Override
    public Color secondSurface() {
        return hex("#9CD5FF");
    }

    @Override
    public Color primary() {
        return hex("#7AAACEd");
    }

    @Override
    public Font font(int style, float size) {
        return new Font("Arial", style, (int) size);
    }

    private Color hex(String color) {
        return Color.decode(color);
    }

    @Override
    public Color primaryBase() {
        return Color.decode("#213448");
    }

    @Override
    public Color buttonBackgroudColor() {
        return hex("#0F2854");
    }

    @Override
    public Color buttonhoverColor() {
        return hex("#1C4D8D");
    }

    @Override
    public Color buttonTextColor() {
        return hex("#F7F8F0");
    }

    @Override
    public Color buttonPressedColor() {
        return hex("#0A1C3A");
    }

    @Override
    public Color buttonDisabledColor() {
        return hex("#7A7A7A");
    }

    @Override
    public Color buttonBorderColor() {
        return hex("#0F2854");
    }

}
