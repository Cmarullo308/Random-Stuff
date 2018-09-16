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
	@FXML private VBox TextVBox;
	
	ObservableList<String> textConverterListItems;
	@FXML
	private ListView<String> textConverterList;
	
	//------
	
	ObservableList<String> testSecondListItems;
	@FXML
	private ListView<String> testSecondList;
	// -------------------------------Option2-------------------------------
	ObservableList<String> test;

	@FXML
	private ListView<String> outerList;
	@FXML
	private BorderPane OptionsWindow;

	// -----Menu bar - File-----
	@FXML // Menu Item exit
	private MenuItem exit;

	@FXML
	private void initialize() {
		final double LISTCELLSIZE = 23.15;

		// OuterList
		outerList.setItems(outerListItems);
		outerList.getSelectionModel().select(0);
		handleFirstListChoice();

	}

	/**
	 * Called when an option from the outter list is selected
	 */
	@FXML
	private void handleFirstListChoice() {
		String selectedList = outerList.getSelectionModel().getSelectedItem();

		if (selectedList.equals("Text")) { // All function under "Text"
			textConverterListItems = FXCollections.observableArrayList("Reverse Text", "AAAAA", "To Uppercase", "To Lower", "Random Case", "Space Out");
			textConverterList.setPrefHeight(CELL_HEIGHT * textConverterListItems.size());
			testSecondListItems = FXCollections.observableArrayList("Kek", "Butts");
			testSecondList.setPrefHeight(CELL_HEIGHT * testSecondListItems.size());
		} else if (selectedList.equals("Option 2")) {
			test = FXCollections.observableArrayList("Test");
		}

		textConverterList.setItems(textConverterListItems);
	}

	/**
	 * Called when an option from the inner list is selected
	 * 
	 * @throws IOException
	 */
	@FXML
	private void handleSecondListChoice() throws IOException {
		// Print.pl("handleSecondChoice called");
		changeOptionBoxView();
	}

	@FXML
	private void changeOptionBoxView() throws IOException {
		Print.pl(TextVBox.getSel);
		String selectedItemFromInnerList = textConverterList.getSelectionModel().getSelectedItem();
		String slectedItemFromOuterList = outerList.getSelectionModel().getSelectedItem();
		String resourcePath = "";

		switch (slectedItemFromOuterList) {
		case "Text": // ------------------------------------------Text
			switch (selectedItemFromInnerList) {
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
			break;
		default:// ----------------------------------------------No outter
				// Choice (Shouldn't happen)
			return;
		}

		Main.setOptionsBoxView(OptionsWindow, resourcePath);
	}

	@FXML // Calls the quitProgram function in Main
	private void exitButton() {
		Main.quitProgram();
	}
}
