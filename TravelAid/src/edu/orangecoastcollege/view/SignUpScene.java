package edu.orangecoastcollege.view;


import edu.orangecoastcollege.controller.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class SignUpScene {
    private static Controller controller = Controller.getInstance();

	@FXML
	private TextField nameTF;
	@FXML
	private TextField emailAddressTF;
	@FXML
	private TextField passwordTF;
	@FXML
	private Label nameErrorLabel;
	@FXML
	private Label emailErrorLabel;
	@FXML
	private Label passwordErrorLabel;
	@FXML
	private Label signUpErrorLabel;

	// Event Listener on Button.onAction
	@FXML
	public void signup(MouseEvent event) {
		// TODO Autogenerated
	    ViewNavigator.loadScene("Sign Up", ViewNavigator.SIGN_IN_SCENE);
	}
	   @FXML
	    public boolean signin(ActionEvent event) {
	        // TODO Autogenerated
	       //
	       String name = nameTF.getText();
	       String email = emailAddressTF.getText();
	       String password = passwordTF.getText();

	       nameErrorLabel.setVisible(name.isEmpty());
	       emailErrorLabel.setVisible(email.isEmpty());
	       passwordErrorLabel.setVisible(password.isEmpty());


	        //If either one is visible, return false
	        if (emailErrorLabel.isVisible() || passwordErrorLabel.isVisible() || nameErrorLabel.isVisible())
	            return false;

	        //Let's try to sign the user in
	        String result = controller.signUpUser(name, email, password);

	        if(result.equalsIgnoreCase("SUCCESS")) {
	            signUpErrorLabel.setVisible(false);
	            ViewNavigator.loadScene("User Information", ViewNavigator.USER_INFORMATION_SCENE);
	            return true;
	        }
	        signUpErrorLabel.setText(result);
	        signUpErrorLabel.setVisible(true);
	        return true;

	    }

//	private static Controller controller = Controller.getInstance();
//
//	@FXML
//	private TextField nameTF;
//	@FXML
//	private TextField emailAddressTF;
//	@FXML
//	private TextField passwordTF;
//	@FXML
//	private Label nameErrorLabel;
//	@FXML
//	private Label emailErrorLabel;
//	@FXML
//	private Label passwordErrorLabel;
//	@FXML
//	private Label signUpErrorLabel;
//
//	@FXML
//	public boolean signUp() {
//		String name = nameTF.getText();
//		String email = emailAddressTF.getText();
//		String password = passwordTF.getText();
//
//		nameErrorLabel.setVisible(name.isEmpty());
//		emailErrorLabel.setVisible(email.isEmpty());
//		passwordErrorLabel.setVisible(password.isEmpty());
//
//		if (nameErrorLabel.isVisible() || emailErrorLabel.isVisible() || passwordErrorLabel.isVisible())
//			return false;
//
//		String result = controller.signUpUser(name, email, password);
//		if (result.equalsIgnoreCase("SUCCESS")) {
//			signUpErrorLabel.setVisible(false);
//			ViewNavigator.loadScene("User Information", ViewNavigator.USER_INFORMATION_SCENE);
//			return true;
//		}
//		signUpErrorLabel.setText(result);
//		signUpErrorLabel.setVisible(true);
//		return false;
//	}
//
//	@FXML
//	public Object loadSignIn()
//	{
//		ViewNavigator.loadScene("Sign In", ViewNavigator.SIGN_IN_SCENE);
//		return this;
//	}

}