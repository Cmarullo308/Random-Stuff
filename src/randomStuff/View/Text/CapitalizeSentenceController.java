package randomStuff.View.Text;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import Tools.Print;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import randomStuff.Main;

public class CapitalizeSentenceController {
	@FXML
	private Label functionName;
	
	@FXML
	private Label inputTextLabel;

	@FXML // First text area (input)
	private TextArea inputTextArea;

	@FXML
	private Button convertButton;

	@FXML // Second text area (output)
	private TextArea outputTextArea;

	@FXML // Copy to clipboard button
	private Button copyToClipboardButton;

	@FXML
	private ImageView processingImage;

	@FXML
	private void initialize() {
		functionName.setText("Capitalize Sentence");
		convertButton.setText("Capitalize Sentences");
		outputTextArea.setEditable(false);
	}

	@FXML
	private void convertButtonClicked() {
		processingImage.setVisible(true);

		Main.process = new Thread() {
			@Override
			public void run() {
				capitalizeSentence();
				processingImage.setVisible(false);
			}
		};

		Main.process.start();
	}

	private void capitalizeSentence() {
		String output = "";
		String input[] = inputTextArea.getText().split("\\.");

		for (String sentence : input) {
			sentence = sentence.trim();
			if (sentence.charAt(0) > 96 && sentence.charAt(0) < 123) {
				output += (char) (sentence.charAt(0) - 32) + sentence.substring(1, sentence.length()) + ". ";
			} else {
				output += sentence + ". ";
			}
		}

		outputTextArea.setText(output.substring(0, output.length() - 1));
	}

	@FXML
	private void onCopyToClipboard() {
		StringSelection stringSelection = new StringSelection(outputTextArea.getText());
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);
	}
}
