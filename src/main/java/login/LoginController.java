package login;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        userTypeToggleGroup = new ToggleGroup();
        adminRadioButton.setToggleGroup(userTypeToggleGroup);
        userRadioButton.setToggleGroup(userTypeToggleGroup);
        userTypeToggleGroup.selectToggle(userRadioButton);
    }

    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String userType = ((RadioButton) userTypeToggleGroup.getSelectedToggle()).getText();

        if (validateLogin(username, password, userType)) {
            navigateToMainScreen(userType);
        } else {
            errorLabel.setText("Invalid username, password, or user type");
        }
    }

    private boolean validateLogin(String username, String password, String userType) {
        boolean isValid = false;
        String query = "SELECT * FROM login WHERE username = ? AND password = ? AND usertype = ?";

        try (Connection connection = LoginDatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, userType);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                isValid = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isValid;
    }

    private void navigateToMainScreen(String userType) {
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
        String userType = ((RadioButton) userTypeToggleGroup.getSelectedToggle()).getText();

        if (password.equals(confirmPassword)) {
            if (createNewUser(username, password, userType)) {
                errorLabel.setText("Account created successfully");
                showLoginPane();
            } else {
                errorLabel.setText("Error creating account");
            }
        } else {
            errorLabel.setText("Passwords do not match");
        }
    }

    private boolean createNewUser(String username, String password, String userType) {
        String query = "INSERT INTO login (username, password, usertype) VALUES (?, ?, ?)";

        try (Connection connection = LoginDatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, userType);

            int result = preparedStatement.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
