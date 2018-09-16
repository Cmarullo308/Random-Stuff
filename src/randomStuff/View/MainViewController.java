package randomStuff.View;

import java.io.IOException;

import Tools.Print;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import randomStuff.Main;

//To change innerList options go to handleFirstListChoice()
//To change fxml name or path go to changeOptionBoxView()

public class MainViewController {
	final double CELL_HEIGHT = 23.21;
	static FXMLLoader loader;

	@FXML
	private BorderPane innerLayout;

	// Categories
	@FXML
	private ListView<String> outerList;
	ObservableList<String> outerListItems = FXCollections.observableArrayList("Text", "Option 2");

	// -----Menu bar - File-----
	@FXML // Menu Item exit
	private MenuItem exit;

	@FXML
	private void initialize() throws IOException {
		// OuterList
		outerList.setItems(outerListItems);
		outerList.getSelectionModel().select(0); // Selects the Text Category
		handleOuterListSelection();
	}

	@FXML
	private void handleOuterListSelection() throws IOException {
		String selection = outerList.getSelectionModel().getSelectedItem();
		
		switch(selection) {
		case "Text":
			Main.changeInnerLayout(innerLayout, "View/TextView.fxml");
			break;
		default:
			return;
		}
	}

	@FXML // Calls the quitProgram function in Main
	private void exitButton() {
		Main.quitProgram();
	}
}
