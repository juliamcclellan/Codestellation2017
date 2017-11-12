package gui;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.event.EventHandler;
import javafx.geometry.Pos;

import files.Login;

public class LoginScene {
	
	private Scene _scene;
	private BorderPane _openingPane;
	private HBox _hbox;
	private VBox _vbox;
	private TextField _tf;
	private PasswordField _pf;
	
	public LoginScene() {
		_openingPane = new BorderPane();
		this.configureTextFields();
		_openingPane.setCenter(_hbox);
		_hbox.setAlignment(Pos.CENTER);
		_scene = new Scene(_openingPane, Constants.APP_WIDTH, Constants.APP_HEIGHT);
	}
	
	public Scene getScene() {
		return _scene;
	}
	
	private void configureTextFields() {
		_hbox = new HBox();
		_vbox = new VBox(10);
		TextField tf = new TextField();
		tf.setPromptText("Username");
		PasswordField pf = new PasswordField();
		pf.setPromptText("Password");
		_vbox.setAlignment(Pos.CENTER);
		_vbox.getChildren().addAll(tf, pf);
		_hbox.getChildren().addAll(_vbox);
	}
	
	private void checkPassword() {
		
		//_tf.getCharacters().toString() == username;
		//_pf.getCharacters().toString() == password;
		
	}
	
	private class TextHandler implements EventHandler<KeyEvent> {
		@Override 
		public void handle(KeyEvent e) {
			KeyCode keyPressed = e.getCode();
			if(keyPressed == KeyCode.ENTER) {
				LoginScene.this.checkPassword();
			}
			e.consume();
		}
	}
}



