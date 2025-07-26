package cs112.lab08;

import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

//import java.io.IOException;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.lang.Math;
//import java.IOException;


public class HelloApplication extends Application {

    //CONSTANTS

    //array of LoteriaCards to use for game:
    private static final LoteriaCard[] LOTERIA_CARDS = {
            new LoteriaCard("Las matematicas", "1.png", 1),
            new LoteriaCard("Las ciencias", "2.png", 2),
            new LoteriaCard("La Tecnología", "8.png", 8),
            new LoteriaCard("La ingeniería", "9.png", 9),
    };


    @Override
    public void start(Stage stage) {
        //removed FXML code, fill this in with components, scene, stage, etc.
        Label titleLabel = new Label("Welcome to EChALE STEM Loteria!");
        ImageView cardImageView = new ImageView();
        cardImageView.setFitHeight(250);
        cardImageView.setFitWidth(200);
        cardImageView.setPreserveRatio(true);

        cardImageView.setImage(LOTERIA_CARDS[0].getImage());
        Label messageLabel = new Label("Click the button to draw card");
        Button drawCardButton = new Button("Draw");
        ProgressBar gameProgressBar = new ProgressBar(0);
        //progress.

        final int[] numCards = {0};
        drawCardButton.setOnAction(event ->{
            int i = (int) (LOTERIA_CARDS.length * Math.random());
            LoteriaCard drawn = LOTERIA_CARDS[i];
            cardImageView.setImage(drawn.getImage());
            //label.setText()
            numCards[0]++;
            gameProgressBar.setProgress((double)numCards[0]/LOTERIA_CARDS.length);

        });

        VBox layout = new VBox(10, titleLabel, cardImageView, messageLabel, drawCardButton, gameProgressBar);
        layout.setAlignment(Pos.CENTER);
        //layout.setStyle
        Scene s = new Scene(layout, 350, 500);

        stage.setTitle("EChALE STEM Loteria");
        stage.setScene(s);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}