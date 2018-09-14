package randomStuff.View.Text;

import Tools.Print;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;

public class ReverseTextController {
	randomStuff.Main main;

	@FXML // First text area (input)
	private TextArea inputTextArea;

	@FXML // Reverse Button
	private Button reverseButton;

	@FXML // Second text area (output)
	private TextArea outputTextArea;

	@FXML
	private ImageView processingImage;

	@FXML
	private void initialize() {
		processingImage.setVisible(false);
		Print.pl("off");
	}

	@FXML
	private void toggleLoadingGif() {
		if (processingImage.isDisable()) {
			processingImage.setDisable(false);
		} else {
			processingImage.setDisable(true);
		}

	}

	@FXML
	private void onReverseButtonClicked() {
		processingImage.setVisible(true);
		Print.pl("On");

		Thread thread;

		thread = new Thread() {
			@Override
			public void run() {
				String reverse = "";

				for (int i = inputTextArea.getText().length(); i > 0; i--) {
					reverse += inputTextArea.getText().charAt(i - 1);
				}
				outputTextArea.setText(reverse);
				processingImage.setVisible(false);
			}
		};
		
		thread.start();
	}
}
