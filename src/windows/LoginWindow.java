package windows;

import javax.swing.JFrame;

import ui.components.MyButton;
import ui.components.MyImageLabel;
import ui.components.MyPanel;
import ui.components.MyPasswordField;
import ui.components.MyTextField;
import ui.themes.BaseTheme;

import java.awt.Dimension;

public class LoginWindow extends JFrame {
        public LoginWindow(MainNavigator navigator) {
                setTitle("Login Window");
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setSize(920, 640);
                setMinimumSize(new Dimension(520, 620));
                setVisible(true);
                setLayout(null);

                // use of the panel
                BaseTheme baseTheme = new BaseTheme();
                MyPanel myPanel = new MyPanel(baseTheme, 10, null);
                myPanel.setSize(new Dimension(500, 400));
                add(myPanel);
                // center mypanel
                myPanel.setLocation((getWidth() - myPanel.getWidth()) / 2, (getHeight() - myPanel.getHeight()) / 2);

                javax.swing.JLabel label = new javax.swing.JLabel("Login");
                label.setSize(new Dimension(100, 30));
                myPanel.add(label);
                label.setForeground(baseTheme.textOverColor());
                label.setFont(baseTheme.font(java.awt.Font.BOLD, 20));
                label.setLocation((myPanel.getWidth() - label.getWidth()) / 2, 15);

                MyTextField textField = new MyTextField("Enter text", baseTheme);
                textField.setSize(new Dimension(200, 30));
                myPanel.add(textField);
                textField.setLocation((myPanel.getWidth() - textField.getWidth()) / 2,
                                (myPanel.getHeight() - textField.getHeight()) / 2);

                MyPasswordField passwordField = new MyPasswordField("Enter password", baseTheme);
                passwordField.setSize(new Dimension(200, 30));
                myPanel.add(passwordField);
                passwordField.setLocation((myPanel.getWidth() - passwordField.getWidth()) / 2,
                                (myPanel.getHeight() - passwordField.getHeight()) / 2 + 40);

                MyButton loginButton = new MyButton("Login", baseTheme, 10);
                loginButton.setSize(new Dimension(100, 30));
                myPanel.add(loginButton);
                loginButton.setLocation((myPanel.getWidth() - loginButton.getWidth()) / 2,
                                (myPanel.getHeight() - loginButton.getHeight()) / 2 + 80);

                loginButton.addActionListener((event) -> {
                        navigator.setAction("grades");
                });

                // ---------------------------------------------
                MyImageLabel logo = new MyImageLabel(
                                "/image/logo.png",
                                100, 100, 30);
                myPanel.add(logo);
                logo.setLocation((myPanel.getWidth() - logo.getWidth()) / 2, 100);
        }
}
