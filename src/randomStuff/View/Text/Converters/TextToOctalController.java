package randomStuff.View.Text.Converters;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import Tools.BaseConverter;
import Tools.MyFuncs;
import Tools.Print;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import randomStuff.Main;

public class TextToOctalController {
	@FXML
	private Label inputTextLabel;

	@FXML // First text area (input)
	private TextArea inputTextArea;

	@FXML
	private SplitMenuButton convertButton;
	@FXML
	MenuItem OctalToTextMenuItem;
	@FXML
	MenuItem TextToOctalMenuItem;
	private String selectedMenuName;

	@FXML // Second text area (output)
	private TextArea outputTextArea;

	@FXML // Copy to clipboard button
	private Button copyToClipboardButton;

	@FXML
	private ImageView processingImage;

	@FXML
	private void initialize() {
		selectedMenuName = "Text to Octal";
		convertButton.setText(selectedMenuName);
		outputTextArea.setEditable(false);
	}

	@FXML
	private void convertButtonClicked() {
		processingImage.setVisible(true);

		Main.process = new Thread() {
			@Override
			public void run() {
				if (selectedMenuName.equals("Text to Octal")) {
					textToOctal();
				} else {
					octalToText();
				}
				processingImage.setVisible(false);
			}
		};

		Main.process.start();
	}

	private void textToOctal() {
		String convertedString = "";

		for (int i = 0; i < inputTextArea.getText().length(); i++) {
			convertedString += MyFuncs.Strings.addLeadingZeros(BaseConverter.convert((int) inputTextArea.getText().charAt(i) + "", 10, 8), 3) + " ";
		}

		outputTextArea.setText(convertedString.substring(0, convertedString.length() - 1));
	}

	private void octalToText() {
		String convertedString = "";
		String input = inputTextArea.getText().replaceAll("[^\\d]", "").replaceAll(" ", "");
		int inputLength = ((int) input.length() / 3) * 3;

		Print.pl(inputLength);
		for (int i = 0; i < inputLength; i += 3) {
			convertedString += (char) Integer.parseInt(BaseConverter.convert(input.substring(i, i + 3), 8, 10));
		}

		outputTextArea.setText(convertedString);
	}

	@FXML
	private void octalToTextMenuItemClicked() {
		selectedMenuName = "Octal to Text";
		convertButton.setText(selectedMenuName);
		inputTextLabel.setText("Enter Octal Number");
	}

	@FXML
	private void textToOctaltMenuItemClicked() {
		selectedMenuName = "Text to Octal";
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
