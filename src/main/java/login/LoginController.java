package login;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private RadioButton adminRadioButton;

    @FXML
    private RadioButton userRadioButton;

    @FXML
    private ToggleGroup userTypeToggleGroup;

    @FXML
    private Button loginButton;

    @FXML
    private Label errorLabel;

    @FXML
    private Pane loginPane;

    @FXML
    private Pane signUpPane;

    @FXML
    private TextField signUpUsernameField;

    @FXML
    private PasswordField signUpPasswordField;

    @FXML
    private PasswordField signUpConfirmPasswordField;

    @FXML
    private void initialize() {
        // Initialize ToggleGroup and set default selection
        userTypeToggleGroup = new ToggleGroup();
        adminRadioButton.setToggleGroup(userTypeToggleGroup);
        userRadioButton.setToggleGroup(userTypeToggleGroup);
        userTypeToggleGroup.selectToggle(userRadioButton); // Set default selection to User
    }

    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String userType = ((RadioButton) userTypeToggleGroup.getSelectedToggle()).getText();

        if (validateLogin(username, password, userType)) {
            // Navigate to main screen
            navigateToMainScreen(userType);
        } else {
            errorLabel.setText("Invalid username, password, or user type");
        }
    }

    private boolean validateLogin(String username, String password, String userType) {
        // Add your logic for validation
        if ("Admin".equals(userType)) {
            return "admin".equals(username) && "admin".equals(password);
        } else {
            return "user".equals(username) && "user".equals(password);
        }
    }

    private void navigateToMainScreen(String userType) {
        // Logic to navigate to the main screen based on user type
        System.out.println("Login successful as " + userType + "! Navigating to the main screen...");
    }

    @FXML
    private void showSignUpPane() {
        loginPane.setVisible(false);
        signUpPane.setVisible(true);
    }

    @FXML
    private void showLoginPane() {
        signUpPane.setVisible(false);
        loginPane.setVisible(true);
    }

    @FXML
    private void handleSignUp() {
        String username = signUpUsernameField.getText();
        String password = signUpPasswordField.getText();
        String confirmPassword = signUpConfirmPasswordField.getText();

        if (password.equals(confirmPassword)) {
            System.out.println("Account created for: " + username);
            // Logic to create a new account
        } else {
            System.out.println("Passwords do not match");
        }
    }
}
