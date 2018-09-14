package randomStuff.View.Text;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;

public class ToLowerController {
	@FXML // First text area (input)
	private TextArea inputTextArea;

	@FXML // Reverse Button
	private Button ToLowercaseButton;

	@FXML // Second text area (output)
	private TextArea outputTextArea;

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
}
