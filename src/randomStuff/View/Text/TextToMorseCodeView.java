package randomStuff.View.Text;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.Arrays;
import java.util.Vector;

import Tools.Print;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import randomStuff.Main;

public class TextToMorseCodeView {
	char[] textList = " !\"$&'()+,-./0123456789:;=?@_abcdefghijklmnopqrstuvwxyz".toCharArray();

	String[] morseList = { "/", "-·-·--", "·-··-·", "···-··-", "·-···", "·----·", "-·--·", "-·--·-", "·-·-·", "--··--", "-····-", "·-·-·-", "-··-·", "-----", ".----", "..---", "...--", "....-",
			".....", "-....", "--...", "---..", "----.", "---···", "-·-·-·", "-···-", "··--··", "·--·-·", "··--·-", ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-",
			".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };

	@FXML
	private Label inputTextLabel;

	@FXML // First text area (input)
	private TextArea inputTextArea;

	@FXML
	private SplitMenuButton convertButton;
	@FXML
	MenuItem morseCodeToTextMenuItem;
	@FXML
	MenuItem TextToMorseCodeMenuItem;
	private String selectedMenuName;

	@FXML // Second text area (output)
	private TextArea outputTextArea;

	@FXML // Copy to clipboard button
	private Button copyToClipboardButton;

	@FXML
	private ImageView processingImage;

	@FXML
	private void initialize() {
		selectedMenuName = "Text to Morse Code";
		convertButton.setText(selectedMenuName);
		outputTextArea.setEditable(false);
	}

	@FXML
	private void convertButtonClicked() {
		processingImage.setVisible(true);

		Main.process = new Thread() {
			@Override
			public void run() {
				if (selectedMenuName.equals("Text to Morse Code")) {
					textToMorseCode();
				} else {
					MorseCodeToText();
				}
				processingImage.setVisible(false);
			}
		};

		Main.process.start();
	}

	private void textToMorseCode() {
		String output = "";
		int charLocation;

		for (int i = 0; i < inputTextArea.getText().length(); i++) {
			charLocation = Arrays.binarySearch(textList, inputTextArea.getText().charAt(i));
			if (charLocation != -1) {
				output += morseList[charLocation] + " ";
			} else {
				output += "?";
			}
		}

		outputTextArea.setText(output.substring(0, output.length() - 1));
	}

	private void MorseCodeToText() {
		String output = "";
		String[] input = inputTextArea.getText().replaceAll("\\s+", " ").split(" ");
		int morseLocation;

		for (int i = 0; i < input.length; i++) {
			morseLocation = getMorseLocation(input[i]);

			if (morseLocation >= 0) {
				output += textList[morseLocation];
			} else {
				output += "???";
			}
		}

		outputTextArea.setText(output);
	}

	private int getMorseLocation(String input) {
		for (int i = 0; i < morseList.length; i++) {
			if (input.equals(morseList[i])) {
				return i;
			}
		}
		return -1;
	}

	@FXML
	private void morseCodeToTextMenuItemClicked() {
		selectedMenuName = "Morse Code to Text";
		convertButton.setText(selectedMenuName);
		inputTextLabel.setText("Enter Morse Code");
	}

	@FXML
	private void textToMorseCodetMenuItemClicked() {
		selectedMenuName = "Text to Morse Code";
		convertButton.setText(selectedMenuName);
		inputTextLabel.setText("Enter Text");
	}

	@FXML
	private void onCopyToClipboard() {
		StringSelection stringSelection = new StringSelection(outputTextArea.getText());
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);
	}
}
