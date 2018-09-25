package randomStuff.View.Text.Converters;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import Tools.Print;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;

public class RandomCaseController {
	@FXML // First text area (input)
	private TextArea inputTextArea;

	@FXML // Reverse Button
	private Button ToLowercaseButton;

	@FXML // Second text area (output)
	private TextArea outputTextArea;

	@FXML // Copy to clipboard button
	private Button copyToClipboardButton;

	@FXML
	private ImageView processingImage;

	@FXML
	private void initialize() {

	}

	@FXML
	private void onRandomCaseButtonClicked() {
		processingImage.setVisible(true);

		Thread thread;

		thread = new Thread() {
			@Override
			public void run() {
				String randomCaseString = "";
				String letter;

				for (int i = 0; i < inputTextArea.getText().length(); i++) {
					if (Tools.MyFuncs.Random.randomIntBetween(0, 1) == 1) {
						letter = Character.toString(inputTextArea.getText().charAt(i));
						randomCaseString += letter.toUpperCase();
					} else {
						letter = Character.toString(inputTextArea.getText().charAt(i));
						randomCaseString += letter.toLowerCase();
					}
				}

				outputTextArea.setText(randomCaseString);

				processingImage.setVisible(false);
			}
		};

		thread.start();
	}

	@FXML
	private void onCopyToClipboard() {
		StringSelection stringSelection = new StringSelection(outputTextArea.getText());
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);
	}
}
