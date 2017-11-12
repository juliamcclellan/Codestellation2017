package gui;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class App extends Application {
	
	@Override 
	public void start(Stage stage) {
		PaneOrganizer organizer = new PaneOrganizer();
		Scene scene = new Scene(organizer.getRoot(), 900, 600);
		stage.setTitle("Title");
		stage.setScene(scene);
		stage.show();
		
	}

	public static void main(String[] argv) {
		launch(argv);
	}

}
