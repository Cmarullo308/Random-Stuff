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
		//OuterList
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

		if (selectedList.equals("Text")) {
			innerListItems = FXCollections.observableArrayList("Reverse Text");
		} else if (selectedList.equals("Option 2")) {
			innerListItems = FXCollections.observableArrayList("Test");
		}

		innerList.setItems(innerListItems);
	}

	/**
	 * Called when an option from the inner list is selected
	 * @throws IOException
	 */
	@FXML
	private void handleSecondListChoice() throws IOException {
		// Print.pl("handleSecondChoice called");
		changeOptionBoxView(innerList.getSelectionModel().getSelectedItem());
	}

	@FXML
	private void changeOptionBoxView(String selectedItemFromList) throws IOException {
		String resourcePath = "";

		if (selectedItemFromList.equals("Reverse Text")) {
			resourcePath = "View/Text/ReverseTextView.fxml";
			////Random-Stuff/src/randomStuff/View/Text/ReverseTextView.fxml
		} else {
			return;
		}

		Main.setOptionsBoxView(OptionsWindow, resourcePath);
	}

	@FXML // Calls the quitProgram function in Main
	private void exitButton() {
		Main.quitProgram();
	}
}
