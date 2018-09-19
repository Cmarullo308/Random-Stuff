package randomStuff.View.Text;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import Tools.BaseConverter;
import Tools.MyFuncs;
import Tools.Print;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import randomStuff.Main;

public class BinaryToTextController {
	@FXML // First text area (input)
	private TextArea inputTextArea;

	@FXML
	private SplitMenuButton convertButton;
	@FXML
	MenuItem BinaryToTextMenuItem;
	@FXML
	MenuItem TextToBinaryMenuItem;
	private String selectedMenuName;

	@FXML // Second text area (output)
	private TextArea outputTextArea;

	@FXML // Copy to clipboard button
	private Button copyToClipboardButton;

	@FXML
	private ImageView processingImage;

	@FXML
	private void initialize() {
		selectedMenuName = "Binary to Text";
		convertButton.setText("Binary to Text");
		outputTextArea.setEditable(false);
	}

	@FXML
	private void convertButtonClicked() {
		processingImage.setVisible(true);

		Main.process = new Thread() {
			@Override
			public void run() {
				if (selectedMenuName.equals("Text to Binary")) {
					convertToBinary();
				} else {
					convertToText();
				}
				processingImage.setVisible(false);
			}
		};

		Main.process.start();
	}

	private void convertToBinary() {
		String convertedString = "";

		for (int i = 0; i < inputTextArea.getText().length(); i++) {
			convertedString += MyFuncs.Strings.addLeadingZeros(BaseConverter.convert((int) inputTextArea.getText().charAt(i) + "", 10, 2), 8) + " ";
		}

		outputTextArea.setText(convertedString.substring(0, convertedString.length() - 1));
	}

	private void convertToText() {
		String convertedString = "";
		String input = inputTextArea.getText().replaceAll("[^\\d]", "").replaceAll(" ", "");
		int inputLength = ((int) input.length() / 8) * 8;

		Print.pl(inputLength);
		for (int i = 0; i < inputLength; i += 8) {
			convertedString += (char) Integer.parseInt(BaseConverter.convert(input.substring(i, i + 8), 2, 10));
		}

		outputTextArea.setText(convertedString);
	}

	@FXML
	private void BinaryToTextMenuItemClicked() {
		selectedMenuName = "Binary to Text";
		convertButton.setText("Binary to Text");
	}

	@FXML
	private void TextToBinarytMenuItemClicked() {
		selectedMenuName = "Text to Binary";
		convertButton.setText("Text to Binary");
	}

	@FXML
	private void onCopyToClipboard() {
		StringSelection stringSelection = new StringSelection(outputTextArea.getText());
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);
	}
}
