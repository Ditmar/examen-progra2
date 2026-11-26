package windows;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import ui.components.MyPanel;
import ui.themes.BaseTheme;
import ui.components.MyTable;

public class GradesWindow extends JFrame {
    public GradesWindow() {
        setTitle("Grades Window");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(920, 640);
        setMinimumSize(new Dimension(520, 620));

        BaseTheme baseTheme = new BaseTheme();
        getContentPane().setBackground(baseTheme.primaryBase());

        MyPanel panel = new MyPanel(baseTheme, 10, new BorderLayout(0, 15));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(panel);

        // mock data
        String[] columns = { "Subject", "Grade" };
        Object[][] data = {
                { "Math", 85 },
                { "Science", 72 },
                { "History", 64 },
                { "Programming", 95 },
                { "English", 48 }
        };
        MyTable table = new MyTable(columns, data, baseTheme);
        JScrollPane scrollPane = table.inScrollPane();
        panel.add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }
}
