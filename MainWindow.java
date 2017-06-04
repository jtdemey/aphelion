package core;

import javafx.animation.*;
import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.effect.Reflection;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class MainWindow extends Application {

	private Stage session;
	private Scene mainFrame;
	private BorderPane bPane;
	private HBox topBar;
	private Button hb_new;
	private Button hb_quit;
	private TextArea console;
	private TextArea inputBox;
	private String lastInput = "";
	private Button submitInput;
	private ListView<String> sideBar;
	private Game game = null;
	
	public void start(Stage primary) {
		session = primary;
		bPane = new BorderPane();
		topBar = makeTopBar();
		console = makeConsole();
		inputBox = makeInputBox();
		submitInput = makeSubmitInput();
		sideBar = makeSideBar();
		
		bPane.setTop(topBar);
		bPane.setCenter(console);
		bPane.setRight(sideBar);
		bPane.setBottom(inputBox);
		
		mainFrame = new Scene(bPane, 1024, 576);
		session.setScene(mainFrame);
		session.setTitle("-APHELION-");
		session.show();
	}
	
	private HBox makeTopBar() {
		topBar = new HBox();
		topBar.setPadding(new Insets(15, 12, 15, 12));
		topBar.setSpacing(16);
		topBar.setStyle("-fx-background-color: #2E2E2E;");
		
		hb_new = new Button("New");
		hb_quit = new Button("Exit");
		topBar.getChildren().addAll(hb_new, hb_quit);
		return topBar;
	}
	
	private TextArea makeConsole() {
		console = new TextArea("////APHELION V0.1////\n");
		console.setEditable(false);
		console.setFont(new Font("Terminal", 12));
		String style = "-fx-control-inner-background: #424242; "
				+ "-fx-text-fill: white; ";
		console.setStyle(style);
		return console;
	}
	
	private TextArea makeInputBox() {
		inputBox = new TextArea("");
		inputBox.setEditable(true);
		inputBox.setFont(new Font("Courier", 12));
		inputBox.setPrefSize(1024, 48);
		inputBox.setMaxSize(1024, 48);
		inputBox.setPadding(new Insets(16, 30, 16, 30));
		inputBox.setPrefHeight(1);
		
		inputBox.setOnKeyPressed(new EventHandler<KeyEvent> () {
			@Override
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.ENTER) {
					String input = inputBox.getText();
					setLastInput(input);
					console.appendText(">>" + input);
					inputBox.setText("");
				}
			}
		});
		
		String style = "-fx-background-color: #585858; "
				+ "-fx-font-family: Courier New, Courier, monospace; "
				+ "-fx-text-fill: green; "
				+ "overflow: hidden; height: 24px; ";
		inputBox.setStyle(style);
		return inputBox;
	}
	private Button makeSubmitInput() {
		submitInput = new Button();
		submitInput.setFont(new Font("Tahoma", 24));
		submitInput.setText(">>");
		submitInput.setEffect(new Reflection());
		return submitInput;
	}
	
	private ListView<String> makeSideBar() {
		sideBar = new ListView<String>();
		sideBar.setStyle("-fx-background-color: #6E6E6E;");
		return sideBar;
	}

	public static void main(String[] args) {
		launch(MainWindow.class, args);
	}
	
	public void displayLine(String line) {
		console.setText(line);
	}
	
	public String getLastInput() {
		return lastInput;
	}
	
	public void setLastInput(String i) {
		lastInput = i;
	}
}
