package randomStuff.View.Text.LineTools;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import Tools.Print;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import randomStuff.Main;

public class FilterLinesController {
	@FXML
	private Label functionName;

	@FXML
	private Label inputTextLabel;

	@FXML // First text area (input)
	private TextArea inputTextArea;

	@FXML
	private TextField needle;

	@FXML
	private ComboBox<String> filterType;

	@FXML
	private CheckBox caseSensitive;

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
		functionName.setText("Filter Lines");
		actionButton.setText("Filter");
		filterType.getItems().addAll("Filter out lines without needle", "Filter out lines with needle");
		filterType.getSelectionModel().select(0);
		outputTextArea.setEditable(false);
	}

	@FXML
	private void convertButtonClicked() {
		processingImage.setVisible(true);

		Main.process = new Thread() {
			@Override
			public void run() {
				filterLines();
				processingImage.setVisible(false);
			}
		};

		Main.process.start();
	}

	private void filterLines() {
		String[] lines = inputTextArea.getText().split("\n");
		String output = "";

		// If "Filter out lines without needle" is selected (0)
		if (filterType.getSelectionModel().getSelectedIndex() == 0) {
			for (String line : lines) {
				if (contains(line, needle.getText())) {
					output += line + "\n";
				}
			}
		} else { // If "Filter out lines with needle" is selected (0)
			for (String line : lines) {
				if (!contains(line, needle.getText())) {
					output += line + "\n";
				}
			}
		}

		outputTextArea.setText(output);
	}

	private boolean contains(String string, String needle) {
		if (caseSensitive.isSelected()) {
			for (int i = 0; i < string.length() - needle.length() + 1; i++) {
				if (string.substring(i, i + needle.length()).equals(needle)) {
					return true;
				}
			}
		} else {
			for (int i = 0; i < string.length() - needle.length() + 1; i++) {
				if (string.substring(i, i + needle.length()).equalsIgnoreCase(needle)) {
					return true;
				}
			}
		}
		return false;
	}

	@FXML
	private void onCopyToClipboard() {
		StringSelection stringSelection = new StringSelection(outputTextArea.getText());
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);
	}
}
