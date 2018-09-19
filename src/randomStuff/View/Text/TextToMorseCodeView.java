package randomStuff.View.Text;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import Tools.Print;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import randomStuff.Main;

public class TextToMorseCodeView {
	@FXML
	private Label inputTextLabel;

	@FXML // First text area (input)
	private TextArea inputTextArea;

	@FXML
	private SplitMenuButton convertButton;
	@FXML
	MenuItem morseCodeToTextMenuItem;
	@FXML
	MenuItem TextToMorseCodeMenuItem;
	private String selectedMenuName;

	@FXML // Second text area (output)
	private TextArea outputTextArea;

	@FXML // Copy to clipboard button
	private Button copyToClipboardButton;

	@FXML
	private ImageView processingImage;

	@FXML
	private void initialize() {
		selectedMenuName = "Text to Morse Code";
		convertButton.setText(selectedMenuName);
		outputTextArea.setEditable(false);
	}

	@FXML
	private void convertButtonClicked() {
		processingImage.setVisible(true);

		Main.process = new Thread() {
			@Override
			public void run() {
				if (selectedMenuName.equals("Text to Morse Code")) {
					textToMorseCode();
				} else {
					MorseCodeToText();
				}
				processingImage.setVisible(false);
			}
		};

		Main.process.start();
	}

	private void textToMorseCode() {

	}

	private void MorseCodeToText() {

	}

	@FXML
	private void morseCodeToTextMenuItemClicked() {
		selectedMenuName = "Morse Code to Text";
		convertButton.setText(selectedMenuName);
		inputTextLabel.setText("Enter Morse Code");
	}

	@FXML
	private void textToMorseCodetMenuItemClicked() {
		selectedMenuName = "Text to Morse Code";
		convertButton.setText(selectedMenuName);
		inputTextLabel.setText("Enter Text");
	}

	@FXML
	private void onCopyToClipboard() {
		StringSelection stringSelection = new StringSelection(outputTextArea.getText());
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);
	}
}
