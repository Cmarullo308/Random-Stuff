package randomStuff.View.Text;

import Tools.Print;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;

public class ToUpperController {

	@FXML // First text area (input)
	private TextArea inputTextArea;

	@FXML // Reverse Button
	private Button ToUppercase;

	@FXML // Second text area (output)
	private TextArea outputTextArea;

	@FXML
	private ImageView processingImage;

	@FXML
	private void initialize() {

	}

	@FXML
	private void onToUpperButtonClicked() {
		 processingImage.setVisible(true);

		Thread thread;

		thread = new Thread() {
			@Override
			public void run() {
				outputTextArea.setText(inputTextArea.getText().toUpperCase());
				 processingImage.setVisible(false);
			}
		};

		thread.start();
	}
}
