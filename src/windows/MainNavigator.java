package windows;

public class MainNavigator {
    public MainNavigator() {
        showLogin();
    }

    public void showLogin() {
        new LoginWindow(this);
    }

    public void showGrades() {
        new GradesWindow();
    }

    public void setAction(String actionRoute) {
        if (actionRoute == "login") {
            showLogin();
        } else if (actionRoute == "grades") {
            showGrades();
        }
    }
}
