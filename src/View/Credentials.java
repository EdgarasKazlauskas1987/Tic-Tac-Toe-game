package View;

import Controllers.GameplayController;
import Model.TTTButton;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Credentials {

    Scene scnCredentials;

    VBox vBox = new VBox();
    HBox hBox = new HBox();
    HBox hBox2 = new HBox();
    HBox hBox3 = new HBox();

    Label lblInsertNames = new Label("Insert players names");
    Label lblPlayer1Name = new Label("Player 1 name");
    Label lblPlayer2Name = new Label("Player 2 name");

    TextField txtPlayer1Name = new TextField();
    TextField txtPlayer2Name = new TextField();

    TTTButton btnContinue = new TTTButton("Continue");
    TTTButton btnBack = new TTTButton("Go back");

    String msgWarning = "Insert Name";

    //GameplayController gameplayController = new GameplayController();

    public Scene getCredentials()
    {
        scnCredentials = new Scene(vBox, 280, 200);
        scnCredentials.getStylesheets().add("Resources/Styles/CredentialsStyles.css");

        lblInsertNames.getStyleClass().add("title-label");
        lblPlayer1Name.getStyleClass().add("name-label");
        lblPlayer2Name.getStyleClass().add("name-label");

        txtPlayer1Name.getStyleClass().add("name-text-field");
        txtPlayer2Name.getStyleClass().add("name-text-field");

        btnContinue.getStyleClass().add("credentials-button");
        btnBack.getStyleClass().add("credentials-button");

        vBox.getStyleClass().add("credentials-vbox");

        hBox.getChildren().addAll(lblPlayer1Name, txtPlayer1Name);
        hBox2.getChildren().addAll(lblPlayer2Name, txtPlayer2Name);
        hBox3.getChildren().addAll( btnBack, btnContinue);

        vBox.getChildren().addAll(lblInsertNames, hBox,hBox2, hBox3);
        this.setButtonsOnAction();

        return scnCredentials;
    }

    public void setButtonsOnAction()
    {
        btnContinue.setOnAction(event -> {
            if (txtPlayer1Name.getText().trim().equals("") || txtPlayer2Name.getText().trim().equals(""))
            {
                txtPlayer1Name.setPromptText(msgWarning);
                txtPlayer2Name.setPromptText(msgWarning);
            }
            else if (txtPlayer1Name.getText().trim().equals(""))
                txtPlayer1Name.setPromptText(msgWarning);

            else if (txtPlayer2Name.getText().trim().equals(""))
                txtPlayer2Name.setPromptText(msgWarning);

            else
                GameplayController.gameplayController.setGameplayToStage();
                //gameplayController.setGameplayToStage();
        });

        btnBack.setOnAction(event -> {

        });
    }
}
