package randomStuff.View.Text.Converters;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import Tools.Print;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;

public class ASCIIToTextController {
	Thread thread;

	@FXML
	private TextArea inputBox;

	@FXML
	private SplitMenuButton convertButton;
	@FXML
	MenuItem ASCIIToTextMenuItem;
	@FXML
	MenuItem TextToASCIIMenuItem;
	@FXML
	private String selectedMenuName;

	@FXML
	private TextArea outputBox;

	@FXML
	private Button copyToClipboardButton;

	@FXML
	private ImageView processingGif;

	@FXML
	private void initialize() {
		selectedMenuName = "Text to ASCII";
		convertButton.setText("Text to ASCII");
	}

	@FXML
	private void handleConvertButtonClicked() {
		switch (selectedMenuName) {
		case "ASCII to Text":
			convertASCIIToText();
			break;
		case "Text to ASCII":
			convertTextToASCII();
			break;
		default:
			Print.pl("default");
			return;
		}
	}

	/**
	 * Converts the inputbox ASCII numbers into text
	 */
	private void convertASCIIToText() {
		processingGif.setVisible(true);

		thread = new Thread() {
			@Override
			public void run() {
				String convertedText = "";
				String inputText = inputBox.getText().replaceAll("[^\\d]", "");
				int numberOfASCIIS = ((int) inputText.length() / 3) * 3;

				for (int i = 0; i < numberOfASCIIS; i += 3) {
					convertedText += (char) Integer.parseInt(inputText.substring(i, i + 3));
				}

				outputBox.setText(convertedText);

				processingGif.setVisible(false);
			}
		};

		thread.start();
	}

	/**
	 * Converts the inputBox text into ASCII numbers
	 */
	private void convertTextToASCII() {
		processingGif.setVisible(true);

		thread = new Thread() {
			@Override
			public void run() {
				String convertText = "";

				for (int i = 0; i < inputBox.getText().length(); i++) {
					convertText += String.format("%03d", (int) inputBox.getText().charAt(i)) + " ";
				}

				convertText = convertText.substring(0, convertText.length() - 1);
				outputBox.setText(convertText);
				processingGif.setVisible(false);
			}
		};

		thread.start();
	}

	@FXML
	private void handleASCIIToTextMenuItemClicked() {
		selectedMenuName = "ASCII to Text";
		convertButton.setText("ASCII to Text");
	}

	@FXML
	private void handleTextToASCIIMenuItemClicked() {
		selectedMenuName = "Text to ASCII";
		convertButton.setText("Text to ASCII");
	}

	@FXML
	private void onCopyToClipboard() {
		StringSelection stringSelection = new StringSelection(outputBox.getText());
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);
	}
}
