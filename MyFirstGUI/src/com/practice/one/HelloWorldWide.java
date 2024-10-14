package com.practice.one;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloWorldWide extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		Label messageLabel_01 = new Label("Hello World");

		Label messageLabel_02 = new Label(
				"Click any button below to change the programming \n" + "language for displaying  \"Hello World!\"");

		Button java = new Button("Java");

		java.setOnAction(e -> {
			messageLabel_02.setText("public class HelloWorld {\n" + "  public static void main(String[] args) {\n" +
					"    System.out.println(\"Hello, World!\");\n" + "  }\n" + "}");
		});

		Button cPlusPlus = new Button("C++");

		cPlusPlus.setOnAction(e -> {
			messageLabel_02.setText("#include <iostream>\n" + "\n" + "int main() {\n" +
					"  std::cout << \"Hello, World!\" << std::endl;\n" + "  return 0;\n" + "}");
		});

		Button python = new Button("Python");

		python.setOnAction(e -> {
			messageLabel_02.setText("print(\"Hello World!\")");
		});

		Button javaScript = new Button("JavaScript");

		javaScript.setOnAction(e -> {
			messageLabel_02.setText("console.log(\"Hello World!\")");
		});

		Button cSharp = new Button("C#");

		cSharp.setOnAction(e -> {
			messageLabel_02
					.setText("using System;\n" + "\n" + "class HelloWorld\n" + "{\n" + "    static void Main()\n" +
							"    {\n" + "        Console.WriteLine(\"Hello, World!\");\n" + "    }\n" + "}\n" + "");
		});

		Button exit = new Button("Exit");

		exit.setOnAction(e -> {
			System.exit(0);
		});
		HBox hbox = new HBox(messageLabel_02);

		VBox vbox = new VBox(10, hbox, java, cPlusPlus, python, javaScript, cSharp, exit);

		hbox.setAlignment(Pos.TOP_CENTER);

		vbox.setAlignment(Pos.TOP_CENTER);

		Scene scene = new Scene(vbox, 300, 400);

		primaryStage.setScene(scene);

		primaryStage.setTitle(
				"Click any button below to change the programming \n" + "language for displaying  \"Hello World!\"");

		primaryStage.show();

	}

}
