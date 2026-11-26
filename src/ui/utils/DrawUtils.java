package ui.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.text.JTextComponent;

//import ui.tema.Tema;
import ui.themes.Theme;

public final class DrawUtils {

    private DrawUtils() {
    }

    public static Graphics2D antialiased(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        return g2;
    }

    public static Color blend(Color a, Color b, double t) {
        return new Color(
                (int) (a.getRed() + (b.getRed() - a.getRed()) * t),
                (int) (a.getGreen() + (b.getGreen() - a.getGreen()) * t),
                (int) (a.getBlue() + (b.getBlue() - a.getBlue()) * t));
    }

    public static Color withAlpha(Color c, int alpha) {
        return new Color(c.getRed(), c.getGreen(), c.getBlue(), alpha);
    }

    public static void styleField(JTextComponent field, Theme tema) {
        field.setOpaque(false);
        field.setBackground(tema.backgroud());
        field.setForeground(tema.textOverColor());
        field.setCaretColor(tema.textOverColor());
        field.setSelectionColor(tema.primary());
        field.setSelectedTextColor(tema.textOverColor());
        field.setFont(tema.font(Font.PLAIN, 14));
        field.setBorder(new RoundedBorder(tema.primary(), tema.primary(), 12));
        field.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                field.repaint();
            }

            @Override
            public void focusLost(FocusEvent e) {
                field.repaint();
            }
        });
    }

    public static void paintFieldBackground(Graphics g, JTextComponent field) {
        Graphics2D g2 = antialiased(g);
        g2.setColor(field.getBackground());
        g2.fillRoundRect(0, 0, field.getWidth() - 1, field.getHeight() - 1, 12, 12);
        g2.dispose();
    }

    public static void paintPlaceholder(Graphics g, JTextComponent field, String text, Color color) {
        if (text == null || field.getDocument().getLength() > 0) {
            return;
        }
        Graphics2D g2 = antialiased(g);
        g2.setColor(color);
        g2.setFont(field.getFont());
        Insets insets = field.getInsets();
        FontMetrics fm = g2.getFontMetrics();
        int y = (field.getHeight() - fm.getHeight()) / 2 + fm.getAscent();
        g2.drawString(text, insets.left, y);
        g2.dispose();
    }
}
