package edu.orangecoastcollege.view;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainView extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {		
		// Set stage only needs to be called once for the view navigator
		ViewNavigator.setStage(primaryStage);
		System.out.println("Hello");

		ViewNavigator.loadScene("Welcome To TravelAid", ViewNavigator.SIGN_IN_SCENE);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	


}

