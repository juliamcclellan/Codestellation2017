package gui;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem; 
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;


public class App extends Application {
	
	@Override 
	public void start(Stage stage) {
		LoginScene scene1 = new LoginScene();
		//PaneOrganizer organizer = new PaneOrganizer();
		//Scene scene = new Scene(organizer.getRoot(), 900, 600);
		stage.setTitle("Title");
		stage.setScene(scene1.getScene());
		stage.show();
	}

	public static void main(String[] argv) {
		launch(argv);
	}

}
