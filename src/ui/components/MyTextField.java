package ui.components;

import java.awt.Graphics;

import javax.swing.JTextField;

import ui.themes.Theme;
import ui.utils.DrawUtils;

public class MyTextField extends JTextField {
    private String placeHolder;
    private Theme theme;

    public MyTextField(String placeholder, Theme theme) {
        super(20);
        this.placeHolder = placeholder;
        this.theme = theme;
        DrawUtils.styleField(this, theme);
    }

    @Override
    protected void paintComponent(Graphics g) {
        DrawUtils.paintFieldBackground(g, this);
        super.paintComponent(g);
        DrawUtils.paintPlaceholder(g, this, placeHolder, theme.textOverColor().darker());
    }
}
