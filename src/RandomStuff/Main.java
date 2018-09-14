package randomStuff;

import java.io.IOException;

import Tools.Print;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
	private static Stage primaryStage;
	private static BorderPane mainLayout;
	static FXMLLoader loader;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Main.primaryStage = primaryStage;
		Main.primaryStage.setTitle("Random Stuff");
		showMainView();
		// setOptionsBoxView(); // delete
	}

	private void showMainView() {
		loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/MainView.fxml"));
		try {
			mainLayout = loader.load();
		} catch (IOException e) {
			Print.pl("thrown from \"showMainView\" in Main");
			e.printStackTrace();
		}
		Scene scene = new Scene(mainLayout);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	/**
	 * Sets up the options after clicking a lebel in the inner list
	 * @param optionsWindow
	 * @param selectedItemFromList
	 * @throws IOException 
	 */
	public static void setOptionsBoxView(BorderPane optionsWindow, String resourcePath) throws IOException {
		loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource(resourcePath));
		BorderPane mainItems = loader.load();
		
		optionsWindow.setCenter(mainItems);
	}

	public static void quitProgram() {
		System.exit(0);
		return;
	}
}
