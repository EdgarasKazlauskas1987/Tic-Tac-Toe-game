package View;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import Controllers.GameplayController;
import Controllers.CredentialsController;


public class Start extends Application {

    private Button btnPlay = new Button("Play");
    private Button btnCredits = new Button("Credits");
    private Button btnQuit = new Button("Quit");

    private Scene scnMainMenu;

    private VBox vBoxMainMenu;

    static Stage mainStage;

    GameplayController gameplayController = new GameplayController();
    CredentialsController credentialsController = new CredentialsController();
    Credits credits = new Credits();

    @Override
    public void start(Stage primaryStage) {
        mainStage = new Stage();
        mainStage.setScene(getScnMainMenu());
        mainStage.show();
    }

    private Scene getScnMainMenu() {
        vBoxMainMenu = new VBox();
        scnMainMenu = new Scene(vBoxMainMenu, 200, 300);

        btnPlay.getStyleClass().add("main-menu-button");
        btnCredits.getStyleClass().add("main-menu-button");
        btnQuit.getStyleClass().add("main-menu-button");
        vBoxMainMenu.getStyleClass().add("main-menu-vbox");

        scnMainMenu.getStylesheets().add("Resources/Styles/MainMenuStyles.css");
        vBoxMainMenu.getChildren().addAll(btnPlay, btnCredits, btnQuit);
        vBoxMainMenu.setAlignment(Pos.CENTER);
        vBoxMainMenu.setSpacing(20);

        this.setButtonsOnAction();

        return scnMainMenu;
    }

    private void setButtonsOnAction() {
        btnPlay.setOnAction(event -> {
            mainStage.setScene(credentialsController.getCredentials());
        });

        btnCredits.setOnAction(event -> {
            mainStage.setScene(credits.getCredits());
        });

        btnQuit.setOnAction(event -> {
            System.exit(1);
        });
    }

    public void setSceneToMainStage() {
        mainStage.setScene(gameplayController.getGameViewStage());
    }

    public void setMainSceneToStage() {
        mainStage.setScene(getScnMainMenu());
    }
}
