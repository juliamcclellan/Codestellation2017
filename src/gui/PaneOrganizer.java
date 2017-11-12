package gui;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem; 
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.*;

public class PaneOrganizer {
	
	private Pane _pane;
	private MenuBar _menu;
	
	public PaneOrganizer() {
		_pane = new Pane();
		this.setUpMenu();
	}
	
	public Pane getRoot() {
		return _pane;
	}
	
	private void setUpInitial() {
		
	}
	
	private void setUpMenu() {
		_menu = new MenuBar();
		Menu menuClass = new Menu("Classes");
		MenuItem i = new MenuItem("Open Classes");
		
		i.setOnAction(e->this.createNewWindow());
		menuClass.getItems().add(i);
		_menu.getMenus().add(menuClass);
		_pane.getChildren().addAll(_menu);
	}
	
	private void createNewWindow() {
		Pane pane = new Pane();
		pane.setStyle("-fx-background-color: blue");
		Rectangle r = new Rectangle(200,200, Color.BLACK);
		_pane.getChildren().add(r);
	}
}
