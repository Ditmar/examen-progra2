package ui.components;

import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.JButton;

import ui.themes.Theme;
import ui.utils.DrawUtils;

public class MyButton extends JButton {
    private Theme theme;
    private int radius;

    public MyButton(String text, Theme theme, int radius) {
        super(text);
        this.theme = theme;
        this.radius = radius;
        setBackground(theme.buttonBackgroudColor());
        setForeground(theme.buttonTextColor());
        setFont(theme.font(0, 14));

        setBorderPainted(false);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setOpaque(false);

    }

    @Override
    public void paintComponent(java.awt.Graphics g) {
        Graphics2D g2 = DrawUtils.antialiased(g);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        Color backgroundColor = theme.buttonBackgroudColor();
        if (this.getModel().isPressed()) {
            backgroundColor = theme.buttonPressedColor();
        } else if (this.getModel().isRollover()) {
            backgroundColor = theme.buttonhoverColor();
        }

        g2.setColor(backgroundColor);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        super.paintComponent(g);
    }
}
