package randomStuff.View;

import java.io.IOException;

import Tools.Print;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
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

	// Categories
	ObservableList<String> outerListItems = FXCollections.observableArrayList("Text", "Option 2");

	// -------------------------------Text-------------------------------
	// Converters
	@FXML
	private VBox TextVBox;

	@FXML
	private ListView<String> textConverterList;
	ObservableList<String> textConverterListItems;

	// ------

	@FXML
	private ListView<String> textLineTools;
	ObservableList<String> textLineToolsItems;
	// -------------------------------Option2-------------------------------
	@FXML
	private ListView<String> testO2;
	ObservableList<String> testO2Items;

	@FXML
	private ListView<String> outerList;
	@FXML
	private BorderPane OptionsWindow;

	// -----Menu bar - File-----
	@FXML // Menu Item exit
	private MenuItem exit;

	@FXML
	private void initialize() {
		// OuterList
		outerList.setItems(outerListItems);
		outerList.getSelectionModel().select(0); // Selects the Text Category
		handleFirstListChoice();
	}

	/**
	 * Called when an option from the outter list is selected
	 */
	@FXML
	private void handleFirstListChoice() {
		String selectedList = outerList.getSelectionModel().getSelectedItem();

		if (selectedList.equals("Text")) { // All function under "Text"
			textConverterListItems = FXCollections.observableArrayList("Reverse Text", "To Uppercase", "To Lower", "Random Case", "Space Out");
			textConverterList.setPrefHeight(CELL_HEIGHT * textConverterListItems.size());
			textConverterList.setItems(textConverterListItems);
		} else if (selectedList.equals("Option 2")) {
			testO2Items = FXCollections.observableArrayList("Test", "AAAAAAAAAA123");
			testO2.setItems(testO2Items);
		}

	}

	/**
	 * Called when an option from the Text/Converters list is selected
	 * 
	 * @throws IOException
	 */
	@FXML
	private void handleTextConverterListChoice() {
		String resourcePath;
		String selectedItem = textConverterList.getSelectionModel().getSelectedItem();

		switch (selectedItem) {
		case "Reverse Text":
			resourcePath = "View/Text/ReverseTextView.fxml";
			break;
		case "To Uppercase":
			resourcePath = "View/Text/ToUpperView.fxml";
			break;
		case "To Lower":
			resourcePath = "View/Text/ToLowerView.fxml";
			break;
		case "Random Case":
			resourcePath = "View/Text/RandomCaseView.fxml";
			break;
		case "Space Out":
			resourcePath = "View/Text/SpaceOutView.fxml";
			break;
		default:
			return;
		}

		try {
			Main.setOptionsBoxView(OptionsWindow, resourcePath);
		} catch (IOException e) {
			Print.pl("thrown from \"handleTextConverterListChoice\" in MainViewController");
			e.printStackTrace();
		}
	}

	@FXML
	private void handleLineToolsListChoice() {
		String resourcePath;
		String selectedItem = textConverterList.getSelectionModel().getSelectedItem();

		switch (selectedItem) {
		case "Reverse Text":
			resourcePath = "View/Text/ReverseTextView.fxml";
			break;
		case "To Uppercase":
			resourcePath = "View/Text/ToUpperView.fxml";
			break;
		case "To Lower":
			resourcePath = "View/Text/ToLowerView.fxml";
			break;
		case "Random Case":
			resourcePath = "View/Text/RandomCaseView.fxml";
			break;
		case "Space Out":
			resourcePath = "View/Text/SpaceOutView.fxml";
			break;
		default:
			return;
		}

		try {
			Main.setOptionsBoxView(OptionsWindow, resourcePath);
		} catch (IOException e) {
			Print.pl("thrown from \"handleLineToolsListChoice\" in MainViewController");
			e.printStackTrace();
		}
	}

	@FXML // Calls the quitProgram function in Main
	private void exitButton() {
		Main.quitProgram();
	}
}
