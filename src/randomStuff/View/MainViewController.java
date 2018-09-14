package randomStuff.View;

import java.io.IOException;

import Tools.Print;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import randomStuff.Main;

//To change innerList options go to handleFirstListChoice()
//To change fxml name or path go to changeOptionBoxView()

public class MainViewController {
	Main main;

	ObservableList<String> outerListItems = FXCollections.observableArrayList("Text", "Option 2");
	ObservableList<String> innerListItems;
	// Text Options

	@FXML
	private ListView<String> outerList;
	@FXML
	private ListView<String> innerList;
	@FXML
	private BorderPane OptionsWindow;

	// Menu bar - File
	@FXML
	private MenuItem exit;

	@FXML
	private void initialize() {
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
			innerListItems = FXCollections.observableArrayList("Reverse Text", "To Uppercase");
		} else if (selectedList.equals("Option 2")) {
			innerListItems = FXCollections.observableArrayList("Test");
		}

		innerList.setItems(innerListItems);
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
		String selectedItemFromInnerList = innerList.getSelectionModel().getSelectedItem();
		String slectedItemFromOuterList = outerList.getSelectionModel().getSelectedItem();
		String resourcePath = "";

		switch (slectedItemFromOuterList) {
		case "Text": //------------------------------------------Text
			switch (selectedItemFromInnerList) {
			case "Reverse Text":
				resourcePath = "View/Text/ReverseTextView.fxml";
				break;
			case "To Uppercase":
				resourcePath = "View/Text/ToUpperView.fxml";
				break;
			default:
				return;
			}
			break;
		default://----------------------------------------------No outter Choice (Shouldn't happen)
			return;
		}

		Main.setOptionsBoxView(OptionsWindow, resourcePath);
	}

	@FXML // Calls the quitProgram function in Main
	private void exitButton() {
		Main.quitProgram();
	}
}
