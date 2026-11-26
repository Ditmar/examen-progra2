package ui.components;

import javax.swing.JPanel;

import ui.themes.Theme;
import ui.utils.DrawUtils;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;

public class MyPanel extends JPanel {
    private int radius;
    private Color borderColor;

    public MyPanel(Theme theme, int radius, LayoutManager layoutManager) {
        super(layoutManager);
        this.radius = radius;
        this.borderColor = theme.textOverColor();
        setBackground(theme.primaryBase());
        setOpaque(false);
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = DrawUtils.antialiased(g);

        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
        if (borderColor != null) {
            g2.setColor(borderColor);
            g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
        }

        g2.dispose();
        super.paintComponent(g);
    }
}
