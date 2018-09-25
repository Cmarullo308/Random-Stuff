package randomStuff.View.Text.Converters;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.Arrays;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import randomStuff.Main;

public class RemoveLetterAccentController {
	final char[] inputCharsList = "\"©«®µ¸»¼½¾¿ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÑÒÓÔÕÖ×ÙÚÛÜÝßàáâãäåæçèéêëìíîïñòóôõöùúûüýÿĀāĂăĄąĆćĈĉĊċČčĎďĒēĔĕĖėĘęĚěĜĝĞğĠġĢģĤĥĨĩĪīĬĭĮįİĲĳĴĵĶķĹĺĻļĽľŁłŃńŅņŇňŉŌōŎŏŐőŒœŔŕŖŗŘřŚśŜŝŞşŠšŢţŤťŨũŪūŬŭŮůŰűŲųŴŵŶŷŸŹźŻżŽžſƠơƯưǇǈǉǊǋǌǍǎǏǐǑǒǓǔǕǖǗǘǙǚǛǜǞǟǠǡǢǣǦǧǨǩǪǫǬǭǰǱǲǳǴǵǸǹǺǻǼǽǾǿȀȁȂȃȄȅȆȇȈȉȊȋȌȍȎȏȐȑȒȓȔȕȖȗȘșȚțȞȟȦȧȨȩȪȫȬȭȮȯȰȱȲȳˆˈˋˍː˜;ḀḁḂḃḄḅḆḇḈḉḊḋḌḍḎḏḐḑḒḓḔḕḖḗḘḙḚḛḜḝḞḟḠḡḢḣḤḥḦḧḨḩḪḫḬḭḮḯḰḱḲḳḴḵḶḷḸḹḺḻḼḽḾḿṀṁṂṃṄṅṆṇṈṉṊṋṌṍṎṏṐṑṒṓṔṕṖṗṘṙṚṛṜṝṞṟṠṡṢṣṤṥṦṧṨṩṪṫṬṭṮṯṰṱṲṳṴṵṶṷṸṹṺṻṼṽṾṿẀẁẂẃẄẅẆẇẈẉẊẋẌẍẎẏẐẑẒẓẔẕẖẗẘẙẠạẢảẤấẦầẨẩẪẫẬậẮắẰằẲẳẴẵẶặẸẹẺẻẼẽẾếỀềỂểỄễỆệỈỉỊịỌọỎỏỐốỒồỔổỖỗỘộỚớỜờỞởỠỡỢợỤụỦủỨứỪừỬửỮữỰựỲỳỴỵỶỷỸỹ`‐‑‒–—―‘’‚‛“”„‟†•․‥…‵‶‷‹›‼⁄⁈⁉₨€℀℁ℂ℅℆ℊℋℌℍℎℐℑℒℓℕ№ℙℚℛℜℝ℡™ℤℨKℬℭ℮ℯℰℱℳℴℹⅅⅆⅇⅈⅉ⅓⅔⅕⅖⅗⅘⅙⅚⅛⅜⅝⅞⅟ⅠⅡⅢⅣⅤⅥⅦⅧⅨⅩⅪⅫⅬⅭⅮⅯⅰⅱⅲⅳⅴⅵⅶⅷⅸⅹⅺⅻⅼⅽⅾⅿ←→↔⇐⇒⇔−∕∖∗∣∶∼≤≥≪≫⋘⋙"
			.toCharArray();

	final String[] outputCharList = { "\"", "(C)", "<<", "(R)", "u", ",", ">>", " 1/4 ", " 1/2 ", " 3/4 ", "?", "A", "A", "A", "A", "A", "A", "AE", "C", "E", "E", "E", "E", "I", "I", "I", "I", "N",
			"O", "O", "O", "O", "O", "x", "U", "U", "U", "U", "Y", "ss", "a", "a", "a", "a", "a", "a", "ae", "c", "e", "e", "e", "e", "i", "i", "i", "i", "n", "o", "o", "o", "o", "o", "u", "u", "u",
			"u", "y", "y", "A", "a", "A", "a", "A", "a", "C", "c", "C", "c", "C", "c", "C", "c", "D", "d", "E", "e", "E", "e", "E", "e", "E", "e", "E", "e", "G", "g", "G", "g", "G", "g", "G", "g",
			"H", "h", "I", "i", "I", "i", "I", "i", "I", "i", "I", "IJ", "ij", "J", "j", "K", "k", "L", "l", "L", "l", "L", "l", "L", "l", "N", "n", "N", "n", "N", "n", "'n", "O", "o", "O", "o", "O",
			"o", "OE", "oe", "R", "r", "R", "r", "R", "r", "S", "s", "S", "s", "S", "s", "S", "s", "T", "t", "T", "t", "U", "u", "U", "u", "U", "u", "U", "u", "U", "u", "U", "u", "W", "w", "Y", "y",
			"Y", "Z", "z", "Z", "z", "Z", "z", "s", "O", "o", "U", "u", "LJ", "Lj", "lj", "NJ", "Nj", "nj", "A", "a", "I", "i", "O", "o", "U", "u", "U", "u", "U", "u", "U", "u", "U", "u", "A", "a",
			"A", "a", "AE", "ae", "G", "g", "K", "k", "O", "o", "O", "o", "j", "DZ", "Dz", "dz", "G", "g", "N", "n", "A", "a", "AE", "ae", "O", "o", "A", "a", "A", "a", "E", "e", "E", "e", "I", "i",
			"I", "i", "O", "o", "O", "o", "R", "r", "R", "r", "U", "u", "U", "u", "S", "s", "T", "t", "H", "h", "A", "a", "E", "e", "O", "o", "O", "o", "O", "o", "O", "o", "Y", "y", "^", "'", "`",
			"_", ":", "~", ";", "A", "a", "B", "b", "B", "b", "B", "b", "C", "c", "D", "d", "D", "d", "D", "d", "D", "d", "D", "d", "E", "e", "E", "e", "E", "e", "E", "e", "E", "e", "F", "f", "G",
			"g", "H", "h", "H", "h", "H", "h", "H", "h", "H", "h", "I", "i", "I", "i", "K", "k", "K", "k", "K", "k", "L", "l", "L", "l", "L", "l", "L", "l", "M", "m", "M", "m", "M", "m", "N", "n",
			"N", "n", "N", "n", "N", "n", "O", "o", "O", "o", "O", "o", "O", "o", "P", "p", "P", "p", "R", "r", "R", "r", "R", "r", "R", "r", "S", "s", "S", "s", "S", "s", "S", "s", "S", "s", "T",
			"t", "T", "t", "T", "t", "T", "t", "U", "u", "U", "u", "U", "u", "U", "u", "U", "u", "V", "v", "V", "v", "W", "w", "W", "w", "W", "w", "W", "w", "W", "w", "X", "x", "X", "x", "Y", "y",
			"Z", "z", "Z", "z", "Z", "z", "h", "t", "w", "y", "A", "a", "A", "a", "A", "a", "A", "a", "A", "a", "A", "a", "A", "a", "A", "a", "A", "a", "A", "a", "A", "a", "A", "a", "E", "e", "E",
			"e", "E", "e", "E", "e", "E", "e", "E", "e", "E", "e", "E", "e", "I", "i", "I", "i", "O", "o", "O", "o", "O", "o", "O", "o", "O", "o", "O", "o", "O", "o", "O", "o", "O", "o", "O", "o",
			"O", "o", "O", "o", "U", "u", "U", "u", "U", "u", "U", "u", "U", "u", "U", "u", "U", "u", "Y", "y", "Y", "y", "Y", "y", "Y", "y", "`", "-", "-", "-", "-", "--", "-", "'", "'", ",", "'",
			"\"", "\"", ",,", "\"", "+", "o", ".", "..", "...", "`", "``", "```", "<", ">", "!!", "/", "?!", "!?", "Rs", "EUR", "a/c", "a/s", "C", "c/o", "c/u", "g", "H", "H", "H", "h", "I", "I", "L",
			"l", "N", "No", "P", "Q", "R", "R", "R", "TEL", "(TM)", "Z", "Z", "K", "B", "C", "e", "e", "E", "F", "M", "o", "i", "D", "d", "e", "i", "j", " 1/3 ", " 2/3 ", " 1/5 ", " 2/5 ", " 3/5 ",
			" 4/5 ", " 1/6 ", " 5/6 ", " 1/8 ", " 3/8 ", " 5/8 ", " 7/8 ", " 1/", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "L", "C", "D", "M", "i", "ii", "iii", "iv",
			"v", "vi", "vii", "viii", "ix", "x", "xi", "xii", "l", "c", "d", "m", "<-", "->", "<->", "<=", "=>", "<=>", "-", "/", "\\", "*", "|", ":", "~", "<=", ">=", "<<", ">>", "<<<", ">>>" };

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
		functionName.setText("Remove Letter Accents");
		actionButton.setText("Remove Letter Accents");
		outputTextArea.setEditable(false);
	}

	@FXML
	private void convertButtonClicked() {
		processingImage.setVisible(true);

		Main.process = new Thread() {
			@Override
			public void run() {
				removeAccents();
				processingImage.setVisible(false);
			}
		};

		Main.process.start();
	}

	private void removeAccents() {
		char[] inputChars = inputTextArea.getText().toCharArray();
		int charLocation;
		String output = "";

		for (char c : inputChars) {
			charLocation = Arrays.binarySearch(inputCharsList, c);
			if (charLocation > -1) {
				output += outputCharList[charLocation];
			} else {
				output += c;
			}
		}

		outputTextArea.setText(output);
	}

	@FXML
	private void onCopyToClipboard() {
		StringSelection stringSelection = new StringSelection(outputTextArea.getText());
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);
	}
}
