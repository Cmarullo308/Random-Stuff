package randomStuff.View.Text.Converters;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import Tools.BaseConverter;
import Tools.Print;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import randomStuff.Main;

public class HexadecimalToTextController {
	@FXML // First text area (input)
	private TextArea inputTextArea;

	@FXML
	private SplitMenuButton toHexadecimalButton;
	@FXML
	MenuItem HexadecimalToTextMenuItem;
	@FXML
	MenuItem TextToHexadecimalMenuItem;
	private String selectedMenuName;

	@FXML // Second text area (output)
	private TextArea outputTextArea;

	@FXML // Copy to clipboard button
	private Button copyToClipboardButton;

	@FXML
	private ImageView processingImage;

	@FXML
	private void initialize() {
		selectedMenuName = "Text to Hexadecimal";
		toHexadecimalButton.setText("Text to Hexadecimal");
	}

	@FXML
	private void toHexadecimalButtonClicked() {
		processingImage.setVisible(true);

		Main.process = new Thread() {
			@Override
			public void run() {
				if (selectedMenuName.equals("Text to Hexadecimal")) {
					convertTextToHexadecimal();
				} else if (selectedMenuName.equals("Hexadecimal to Text")) {
					convertHexadecimalToText();
				}
				processingImage.setVisible(false);
			}
		};

		Main.process.start();

	}

	private void convertHexadecimalToText() {
		String input = inputTextArea.getText().replaceAll(" ", "");
		String output = "";
		int numberOfHexadecimalNums = ((int) input.length() / 2) * 2;

		for (int i = 0; i < numberOfHexadecimalNums; i += 2) {
			output += (char) Integer.parseInt(BaseConverter.convert(input.substring(i, i + 2), 16, 10));
		}

		outputTextArea.setText(output);
	}

	private void convertTextToHexadecimal() {
		String output = "";

		for (int i = 0; i < inputTextArea.getText().length(); i++) {
			output += BaseConverter.convert((int) inputTextArea.getText().charAt(i) + "", 10, 16) + " ";
		}

		outputTextArea.setText(output.substring(0, output.length() - 1));
	}

	@FXML
	private void textToHexadecimalMenuItemClicked() {
		selectedMenuName = "Text to Hexadecimal";
		toHexadecimalButton.setText("Text to Hexadecimal");
	}

	@FXML
	private void HexadecimalToTextMenuItemClicked() {
		selectedMenuName = "Hexadecimal to Text";
		toHexadecimalButton.setText("Hexadecimal to Text");
	}

	@FXML
	private void onCopyToClipboard() {
		StringSelection stringSelection = new StringSelection(outputTextArea.getText());
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);
	}
}
