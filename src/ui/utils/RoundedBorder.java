package ui.utils;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;

import javax.swing.border.AbstractBorder;

public class RoundedBorder extends AbstractBorder {

    private final Color normalColor;
    private final Color focusColor;
    private final int radius;

    public RoundedBorder(Color normalColor, Color focusColor, int radius) {
        this.normalColor = normalColor;
        this.focusColor = focusColor;
        this.radius = radius;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2 = DrawUtils.antialiased(g);
        boolean focused = c.hasFocus();
        g2.setColor(focused ? focusColor : normalColor);
        g2.setStroke(new BasicStroke(focused ? 2f : 1f));
        g2.drawRoundRect(x + 1, y + 1, width - 3, height - 3, radius, radius);
        g2.dispose();
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(10, 14, 10, 14);
    }

    @Override
    public Insets getBorderInsets(Component c, Insets insets) {
        insets.set(10, 14, 10, 14);
        return insets;
    }
}
