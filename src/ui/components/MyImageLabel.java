package ui.components;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import ui.utils.DrawUtils;

public class MyImageLabel extends JLabel {
    private Image image;
    private int radius;

    public MyImageLabel(String path, int width, int height, int radius) {
        this.radius = radius;
        setPreferredSize(new Dimension(width, height));
        setSize(getPreferredSize());
        setOpaque(false);
        setImage(path);
    }

    public MyImageLabel(String path, int width, int height) {
        this(path, width, height, 0);
    }

    public void setImage(String path) {
        image = null;
        if (path != null) {
            URL url = getClass().getResource(path.startsWith("/") ? path : "/" + path);
            if (url != null) {
                image = new javax.swing.ImageIcon(url).getImage();
            } else if (new File(path).exists()) {
                image = new ImageIcon(path).getImage();
            } else {
                System.err.println("Image not found: " + path);
            }
        }
        repaint();
    }

    public void setRadius(int radius) {
        this.radius = radius;
        repaint();
    }

    @Override
    protected void paintComponent(java.awt.Graphics g) {
        if (image == null) {
            super.paintComponent(g);
            return;
        }

        Graphics2D g2 = DrawUtils.antialiased(g);
        int imgW = image.getWidth(this);
        int imgH = image.getHeight(this);
        double scale = Math.min((double) getWidth() / imgW, (double) getHeight() / imgH);
        int drawW = (int) (imgW * scale);
        int drawH = (int) (imgH * scale);
        int x = (getWidth() - drawW) / 2;
        int y = (getHeight() - drawH) / 2;

        if (this.radius > 0) {
            g2.setClip(new java.awt.geom.RoundRectangle2D.Double(x, y, drawW, drawH, radius, radius));
        }

        g2.drawImage(image, x, y, drawW, drawH, this);
        super.paintComponent(g);
    }

}
