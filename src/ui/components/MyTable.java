package ui.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import ui.themes.Theme;

public class MyTable extends JTable {
    private Theme theme;
    private DefaultTableModel model;

    public MyTable(String[] cStrings, Object[][] rData, Theme theme) {
        this.theme = theme;
        this.model = new DefaultTableModel(cStrings, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        this.setModel(this.model);

        setFont(theme.font(Font.PLAIN, 14));
        setRowHeight(32);
        setShowGrid(false);
        setIntercellSpacing(new Dimension(0, 0));
        setFillsViewportHeight(true);
        setBackground(theme.primaryBase());
        setForeground(theme.primary());
        setSelectionBackground(theme.buttonhoverColor());
        setSelectionForeground(theme.textOverColor());
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setFocusable(false);
        styleCells();
        styleHeader();
        setData(rData);

    }

    private void styleCells() {
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        setDefaultRenderer(Object.class, renderer);
    }

    private void styleHeader() {
        JTableHeader header = getTableHeader();
        header.setBackground(theme.buttonBackgroudColor());
        header.setForeground(theme.buttonTextColor());
        header.setFont(theme.font(Font.BOLD, 14));
        header.setPreferredSize(new Dimension(0, 36));
        header.setReorderingAllowed(false);
    }

    public void setData(Object[][] data) {
        model.setRowCount(0);
        for (Object[] row : data) {
            model.addRow(row);
        }
    }

    public void addRow(Object[] row) {
        model.addRow(row);
    }

    public JScrollPane inScrollPane() {
        JScrollPane scrollPane = new JScrollPane(this);
        Color border = theme.buttonBorderColor();
        scrollPane.setBorder(javax.swing.BorderFactory.createLineBorder(border));
        scrollPane.getViewport().setBackground(theme.primaryBase());
        return scrollPane;
    }

}
