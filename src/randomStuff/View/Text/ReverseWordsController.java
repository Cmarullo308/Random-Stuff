package randomStuff.View.Text;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import Tools.MyFuncs;
import Tools.Print;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import randomStuff.Main;

public class ReverseWordsController {
	@FXML
	private Label functionName;

	@FXML
	private Label inputTextLabel;

	@FXML // First text area (input)
	private TextArea inputTextArea;

	@FXML
	private Button actionButton;

	@FXML // Second text area (output)
	private TextArea outputTextArea;

	@FXML // Copy to clipboard button
	private Button copyToClipboardButton;

	@FXML
	private ImageView processingImage;

	@FXML
	private void initialize() {
		functionName.setText("Reverse Words");
		actionButton.setText("Reverse Words");
		outputTextArea.setEditable(false);
	}

	@FXML
	private void convertButtonClicked() {
		processingImage.setVisible(true);

		Main.process = new Thread() {
			@Override
			public void run() {
				reverseWords();
				processingImage.setVisible(false);
			}
		};

		Main.process.start();
	}

	private void reverseWords() {
		String[] input = inputTextArea.getText().replace(".", "").split(" ");
		String output = "";
		
		MyFuncs.Arrays.reverseArray(input);
		
		for(String word : input) {
			output += word + " ";
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
