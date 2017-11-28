/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nnttt;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Qmppu842
 */
public class HumanInterface extends Application {

    private Game game;
    private Stage stage;

    public HumanInterface(Game game) {
        this.game = game;
    }

    public HumanInterface() {
        if (game == null) {
            buildNewGame(false, false);
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

//        Label teks = new Label("asdsdddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddads");
//        Label teks2 = new Label("asdads22");
//        FlowPane komponenttiryhma = new FlowPane();
//        komponenttiryhma.getChildren().add(teks);
//        komponenttiryhma.getChildren().add(teks2);
////        Scene aass = new Scene(komponenttiryhma);
        stage = primaryStage;
        primaryStage.setScene(startingScene());
        primaryStage.setWidth(400);
        primaryStage.setHeight(400);

//        primaryStage.setScene(gameSetupScene());
        primaryStage.setTitle("asd");
        primaryStage.show();
    }

    public void launchIt() {
        launch(HumanInterface.class);
    }

    private Scene startingScene() {

        //RIGHT pane
        FlowPane rightPanel = new FlowPane();
        Button newGame = new Button("new Game");
        newGame.setOnAction((ActionEvent event) -> {
            //TODO Working scene change
            stage.setScene(gameSetupScene());
        });
        rightPanel.getChildren().add(newGame);

        //CENTER pane
        Label placeholder = new Label("Asd placeholder");

        //layout settings
        BorderPane layout = new BorderPane();
        layout.setCenter(placeholder);
        layout.setRight(rightPanel);

        //SCENE
        Scene startScreen = new Scene(layout);

        return startScreen;
    }

    private Scene gameSetupScene() {
        VBox blah = new VBox();
        Label thing = new Label("New Game!");

        HBox p1 = new HBox();
        Label isP1Bot = new Label("Is player 1 human?");
        CheckBox boxP1 = new CheckBox();

        p1.getChildren().add(isP1Bot);
        p1.getChildren().add(boxP1);

        HBox p2 = new HBox();
        Label isP2Bot = new Label("Is player 2 human?");
        CheckBox boxP2 = new CheckBox();

        p2.getChildren().add(isP2Bot);
        p2.getChildren().add(boxP2);

        boolean p1Hum = boxP1.isSelected();
        boolean p2Hum = boxP2.isSelected();

        Button start = new Button("Start game!");
        start.setOnAction((event) -> {
            buildNewGame(p1Hum, p2Hum);
            stage.setScene(drawSomeGame(listOfButtons(game.flatBoard())));
        });

        blah.getChildren().add(thing);
        blah.getChildren().add(p1);
        blah.getChildren().add(p2);
        blah.getChildren().add(start);

        Scene setup = new Scene(blah);
        return setup;
    }

    private Game buildNewGame(boolean isP1Human, boolean isP2Human) {
        Game game = new Game();
        if (isP1Human) {
            game.setPlayer1toHuman();
        }
        if (isP2Human) {
            game.setPlayer2toHuman();
        }
        this.game = game;
        return null;
    }

//    private Scene gameOn() {
//        BorderPane asd = new BorderPane();
//
//        GridPane peli = new GridPane();
//        ArrayList<StateOfSquare> flatBoard = game.flatBoard();
//        for (int y = 0; y < 3; y++) {
//            for (int x = 0; x < 3; x++) {
//                System.out.println(Math.floorDiv(y, 3) + x % 3);
//                String nimi = flatBoard.get(Math.floorDiv(y, 3) + x % 3).getName();
//                Button asddd = new Button();
//                int carrX = 0;
//                asddd.setOnAction((ActionEvent event) -> {
//                    int turn = game.getTurnNumber();
//                    StateOfSquare t = StateOfSquare.X;
//                    if (turn % 2 == 0) {
//                        t = t.X;
//                    } else {
//                        t = t.O;
//                    }
//                    carrX = x;
//                });
//                boolean didItGo = game.inputTurn(t, y, x);
//
//                peli.add(asddd, x, y);
//            }
//        }
//
//        Scene afk = new Scene(peli);
//        return afk;
//    }
    private ArrayList<TheButtonCustomThingClass> listOfButtons(ArrayList<StateOfSquare> flatBoard) {
        //TODO Custom class that handless buttoning...

//        TheButtonCustomThingClass but = new TheButtonCustomThingClass(3,3);
//        int posX = but.getPosX();
        ArrayList<TheButtonCustomThingClass> ready = new ArrayList<>();
        for (int i = 0; i < flatBoard.size(); i++) {
            TheButtonCustomThingClass button = new TheButtonCustomThingClass(i, flatBoard.get(i));
            button.setOnAction((event) -> {
                pressed(button);
            });
            ready.add(button);

        }

        return ready;
    }

    private void pressed(TheButtonCustomThingClass asd) {
        StateOfSquare t = StateOfSquare.X;
        if (game.getTurnNumber() % 2 == 0) {
            t = t.X;
        } else {
            t = t.O;
        }

        boolean action = game.inputTurn(t, asd.getPosY(), asd.getPosX());
        if (action) {
            asd.setText(t.getName());
        }
        
        if (game.checkWinners() != StateOfSquare.EMPTY) {
            stage.setScene(winScene());
        }

    }

    private Scene drawSomeGame(ArrayList<TheButtonCustomThingClass> ready) {
        GridPane gamee = new GridPane();
        for (int i = 0; i < ready.size(); i++) {
            TheButtonCustomThingClass asdd = ready.get(i);
            gamee.add(asdd, asdd.getPosX(), asdd.getPosY());
        }
        Scene gameOnScene = new Scene(gamee);
        return gameOnScene;
    }

    public int[] fromFlatTo2D(int flatPos) {
        int posX = Math.floorDiv(flatPos, 3);
        int posY = flatPos % 3;

        int[] coordinaatit = new int[2];
        coordinaatit[0] = posX;
        coordinaatit[1] = posY;

        return coordinaatit;
    }

    private Scene winScene() {
        String winText = "And the winner is: " + game.checkWinners().getName() + "! \n GZ!";
        Label winner = new Label(winText);
        FlowPane ssss = new FlowPane();
        ssss.getChildren().add(winner);
        Scene s = new Scene(ssss);
        return s;
    }
}
