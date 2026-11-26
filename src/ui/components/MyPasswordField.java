package ui.components;

import javax.swing.JPasswordField;

import ui.themes.Theme;
import ui.utils.DrawUtils;

public class MyPasswordField extends JPasswordField {
    private String placeHolder;
    private final Theme theme;

    public MyPasswordField(String placeHolder, Theme theme) {
        this.placeHolder = placeHolder;
        this.theme = theme;
        setEchoChar('*');
        DrawUtils.styleField(this, theme);
    }

    @Override
    protected void paintComponent(java.awt.Graphics g) {
        DrawUtils.paintFieldBackground(g, this);
        super.paintComponent(g);
        DrawUtils.paintPlaceholder(g, this, this.placeHolder, theme.textOverColor().darker());
    }
}
