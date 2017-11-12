package gui;

import javafx.scene.layout.Pane;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem; 

public class PaneOrganizer {
	
	private Pane _pane;
	private Menu _menu;
	
	public PaneOrganizer() {
		_pane = new Pane();
		this.setUpMenu();
	}
	
	public Pane getRoot() {
		return _pane;
	}
	
	private void setUpMenu() {
		_menu = new Menu();
		MenuItem open = new MenuItem("Classes?");
		_menu.getItems().add(open);
	}
}
