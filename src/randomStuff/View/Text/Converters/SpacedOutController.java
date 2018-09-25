package randomStuff.View.Text.Converters;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;

public class SpacedOutController {
	@FXML // First text area (input)
	private TextArea inputTextArea;

	@FXML // Reverse Button
	private Button SpaceOutButton;

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
	private void onSpaceOutButtonClicked() {
		processingImage.setVisible(true);

		Thread thread;

		thread = new Thread() {
			@Override
			public void run() {
				String spaceOutText = "";
				if (inputTextArea.getText().length() > 0) {
					for (int i = 0; i < inputTextArea.getText().length(); i++) {
						spaceOutText += inputTextArea.getText().charAt(i) + " ";
					}

					spaceOutText = spaceOutText.substring(0, spaceOutText.length() - 1);

					outputTextArea.setText(spaceOutText);
				}
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
