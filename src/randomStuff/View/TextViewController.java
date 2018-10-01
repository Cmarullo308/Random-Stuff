package randomStuff.View;

import java.io.IOException;

import Tools.Print;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import randomStuff.Main;

public class TextViewController {
	final double CONVERTERS_CELL_HEIGHT = 23.5;
	final double LINETOOLS_CELL_HEIGHT = 24.5;
	@FXML
	private BorderPane OptionsWindow;
	// -----Converters-----
	@FXML
	private ListView<String> textConverterList;
	ObservableList<String> textConverterListItems;

	// -----Line Tools-----
	@FXML
	private ListView<String> textLineToolsList;
	ObservableList<String> textLineToolsListItems;

	// every 5 - 1.5
	@FXML
	private void initialize() {
		// Converters
		textConverterListItems = FXCollections.observableArrayList("Reverse Text", "To Uppercase", "To Lower", "Random Case", "Space Out", "ASCII to Text", "Hexadecimal to Text", "Binary to Text",
				"Text to Octal", "Text to Morse Code", "Capitalize Words", "Capitalize Sentence", "Remove Letter Accents", "Reverse Words");
		textConverterList.setPrefHeight(CONVERTERS_CELL_HEIGHT * textConverterListItems.size());
		textConverterList.setItems(textConverterListItems);
		// Line Tools
		textLineToolsListItems = FXCollections.observableArrayList("Filter Lines");
		textLineToolsList.setPrefHeight(LINETOOLS_CELL_HEIGHT * textLineToolsListItems.size());
		textLineToolsList.setItems(textLineToolsListItems);
	}

	/**
	 * Called when an option from the outter list is selected
	 */
	// @FXML
	// private void handleFirstListChoice() {
	// String selectedList = outerList.getSelectionModel().getSelectedItem();
	//
	// if (selectedList.equals("Text")) { // All function under "Text"
	// textConverterListItems = FXCollections.observableArrayList("Reverse
	// Text", "To Uppercase", "To Lower", "Random Case", "Space Out");
	// textConverterList.setPrefHeight(CELL_HEIGHT *
	// textConverterListItems.size());
	// textConverterList.setItems(textConverterListItems);
	// } else if (selectedList.equals("Option 2")) {
	// testO2Items = FXCollections.observableArrayList("Test", "AAAAAAAAAA123");
	// testO2.setItems(testO2Items);
	// }
	// }

	/**
	 * Called when an option from the Text/Converters list is selected
	 * 
	 * @throws IOException
	 */
	@FXML
	private void handleTextConverterListChoice() {
		String resourcePath = null;
		String selectedItem = textConverterList.getSelectionModel().getSelectedItem();

		switch (selectedItem) {
		case "Reverse Text":
			resourcePath = "View/Text/Converters/ReverseTextView.fxml";
			break;
		case "To Uppercase":
			resourcePath = "View/Text/Converters/ToUpperView.fxml";
			break;
		case "To Lower":
			resourcePath = "View/Text/Converters/ToLowerView.fxml";
			break;
		case "Random Case":
			resourcePath = "View/Text/Converters/RandomCaseView.fxml";
			break;
		case "Space Out":
			resourcePath = "View/Text/Converters/SpaceOutView.fxml";
			break;
		case "ASCII to Text":
			resourcePath = "View/Text/Converters/ASCIIToTextView.fxml";
			break;
		case "Hexadecimal to Text":
			resourcePath = "View/Text/Converters/HexadecimalToTextView.fxml";
			break;
		case "Binary to Text":
			resourcePath = "View/Text/Converters/BinaryToTextView.fxml";
			break;
		case "Text to Octal":
			resourcePath = "View/Text/Converters/TextToOctalView.fxml";
			break;
		case "Text to Morse Code":
			resourcePath = "View/Text/Converters/TextToMorseCodeView.fxml";
			break;
		case "Capitalize Words":
			resourcePath = "View/Text/Converters/CapitalizeWordsView.fxml";
			break;
		case "Capitalize Sentence":
			resourcePath = "View/Text/Converters/CapitalizeSentenceView.fxml";
			break;
		case "Remove Letter Accents":
			resourcePath = "View/Text/Converters/RemoveLetterAccentsView.fxml";
			break;
		case "Reverse Words":
			resourcePath = "View/Text/Converters/ReverseWordsView.fxml";
			break;
		default:
			Print.pl("Default in switch in handleTextConverterListChoice");
			return;
		}

		Main.setOptionsBoxView(OptionsWindow, resourcePath);
	}

	@FXML
	private void handleLineToolsListChoice() {
		String resourcePath;
		String selectedItem = textLineToolsList.getSelectionModel().getSelectedItem();

		switch (selectedItem) {
		case "Filter Lines":
			resourcePath = "View/Text/LineTools/FilterLinesView.fxml";
			break;
		default:
			return;
		}

		Main.setOptionsBoxView(OptionsWindow, resourcePath);
	}
}
