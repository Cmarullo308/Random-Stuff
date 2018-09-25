package randomStuff.View.Text.Converters;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ToLowerController {
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
	private void onToLowerButtonClicked() {
		processingImage.setVisible(true);

		Thread thread;

		thread = new Thread() {
			@Override
			public void run() {
				outputTextArea.setText(inputTextArea.getText().toLowerCase());
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
