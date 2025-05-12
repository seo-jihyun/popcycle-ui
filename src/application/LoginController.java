package application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.scene.control.*;

public class LoginController {
    @FXML private ToggleButton producerButton;
    @FXML private ToggleButton managerButton;
    @FXML private ToggleGroup roleGroup;

    @FXML private TextField IDField;
    @FXML private Button loginButton;
    @FXML private Button signinbutton;
    @FXML private Label messageLabel;
    
    @FXML
    private void handleLogin(ActionEvent event) {
        String email = IDField.getText();
        String role = producerButton.isSelected() ? "producer" : managerButton.isSelected() ? "manager" : "";

        if (email.isEmpty() || role.isEmpty()) {
            messageLabel.setText("ID와 역할을 선택해주세요.");
            return;
        }
        try {
            Parent nextScene;
            if (role.equals("producer")) {
                nextScene = FXMLLoader.load(getClass().getResource("/company_register.fxml"));
            } else {
                nextScene = FXMLLoader.load(getClass().getResource("/manager_home.fxml"));
            }

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(nextScene));
            stage.setTitle(role + " 홈");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            messageLabel.setText("ID를 입력해주세요");
        }
    }
}
