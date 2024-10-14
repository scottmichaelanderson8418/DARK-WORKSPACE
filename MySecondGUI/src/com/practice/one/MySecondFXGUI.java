package com.practice.one;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MySecondFXGUI extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		Label promptLabel = new Label("Restaurant Charge");
		TextField chargesTextField = new TextField();
		Button calcButton = new Button("Calculate Tip");
		Label outputLabel = new Label("Amount to Tip");
		Label tipAmountLabel = new Label();

		// Put the controls in a VBox
		VBox vbox = new VBox(10, promptLabel, chargesTextField, calcButton, outputLabel, tipAmountLabel);

		// Center align the VBox
		vbox.setAlignment(Pos.CENTER);

		// Add padding to the VBox
		vbox.setPadding(new Insets(10));

		// Register an event handler for the Button
		calcButton.setOnAction(e -> {
			double tip = Double.parseDouble(chargesTextField.getText()) * 0.2;
			tipAmountLabel.setText(String.format("$%.2f", tip));
		});

		// Make the VBox the root node
		Scene scene = new Scene(vbox);

		// Set a stylesheet for the scene
		scene.getStylesheets().add("nccia.css");

		// Set the scene to the stage
		primaryStage.setScene(scene);

		// show the window
		primaryStage.show();

	}

}
