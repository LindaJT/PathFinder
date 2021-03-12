
package ui;

import java.io.File;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import pathFinder.PathService;


public class UI extends Application {
    
        public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        PathService service = new PathService();
        primaryStage.setTitle("Path Finder");
        
        VBox mainPane = new VBox(10);
        HBox inputPane = new HBox(10);
        mainPane.setPadding(new Insets(10, 10, 10, 10));
        Label fileLabel = new Label("Add map file");
        Text fileText = new Text("");
        
        Button browse = new Button("Browse files");
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Add map file");
        
        browse.setOnAction(
            new EventHandler<ActionEvent>() {
                @Override
                public void handle(final ActionEvent e) {
                    File file = chooser.showOpenDialog(primaryStage);
                    if (file != null) {
                        String fileName = file.getName();
                        boolean success = service.readFile(fileName);
                        if (success) {
                            fileText.setText("File added");
                        } else {
                            fileText.setText("File not found or not readable");
                        }
                    }
                }
            });
   /*     File file = chooser.showOpenDialog(primaryStage);
        if (file != null) {
            String fileName = file.getName();
            boolean success = service.readFile(fileName);
            if (success) {
                fileText.setText("File added");
            } else {
                fileText.setText("File not found or not readable");
            }
        }*/
        
        Text startCoordinatesText = new Text("Give start coordinates: ");
        Label xstartLabel = new Label("x start: ");
        TextField xstartInput = new TextField();
        Label ystartLabel = new Label("y end: ");
        TextField ystartInput = new TextField();
        
        Text endCoordinatesText = new Text("Give end coordinates: ");
        Label xendLabel = new Label("x end: ");
        TextField xendInput = new TextField();
        Label yendLabel = new Label("y end: ");
        TextField yendInput = new TextField();
        
        TilePane radio = new TilePane();
        
        Text heuristicText = new Text("Choose heuristics");
        ToggleGroup tg = new ToggleGroup();
        RadioButton uniformCost = new RadioButton("Uniform cost");
        RadioButton diagonal = new RadioButton("Diagonal");
        RadioButton euclidean = new RadioButton("Euclidean");
        
        uniformCost.setToggleGroup(tg);
        diagonal.setToggleGroup(tg);
        euclidean.setToggleGroup(tg);
        
        radio.getChildren().addAll(heuristicText, uniformCost, diagonal, euclidean);
        
        tg.selectToggle(diagonal);
        
        HBox optionsPane = new HBox(10);
        VBox astarPane = new VBox(10);
        VBox idastarPane = new VBox(10);
        VBox textPane = new VBox(10);
        
        Text distanceTitle = new Text("Find shortes path with ");
        Button aStarButton = new Button("A*");
        Text aStarDistance = new Text("----");
        Text aStarTime = new Text("----");
        
        Button idaStarButton = new Button("IDA*");
        Text idaStarDistance = new Text("----");
        Text idaStarTime = new Text("----");
        
        Text empty = new Text("    ");
        Text distanceDes = new Text("Distance:");
        Text timeText = new Text("Time (in milliseconds):");
        Text infoText = new Text(" ");
        
        aStarButton.setOnAction(e -> {
            int xstart = Integer.parseInt(xstartInput.getText()) + 1;
            int ystart = Integer.parseInt(ystartInput.getText()) + 1;
            int xend = Integer.parseInt(xendInput.getText()) + 1;
            int yend = Integer.parseInt(yendInput.getText()) + 1;
            RadioButton rb = (RadioButton) tg.getSelectedToggle();
            String heuristic = rb.getText();
            long aStartTime = System.currentTimeMillis();
            double distance = service.aStarDistance(xstart, ystart, xend, yend, heuristic);
            long aEndTime = System.currentTimeMillis();
            String text = String.valueOf(distance);
            String text2 = String.valueOf(aEndTime - aStartTime);
            aStarDistance.setText(text);
            aStarTime.setText(text2);
            service.drawPath(true);
            if (distance < 0.) {
                infoText.setText("Path not found");
            } else {
                infoText.setText("Path found");
            }
        });
        
        idaStarButton.setOnAction(e -> {
            int xstart = Integer.parseInt(xstartInput.getText()) + 1;
            int ystart = Integer.parseInt(ystartInput.getText()) + 1;
            int xend = Integer.parseInt(xendInput.getText()) + 1;
            int yend = Integer.parseInt(yendInput.getText()) + 1;
            RadioButton rb = (RadioButton) tg.getSelectedToggle();
            String heuristic = rb.getText();
            long idaStartTime = System.currentTimeMillis();
            double distance = service.idaStarDistance(xstart, ystart, xend, yend, heuristic);
            long idaEndTime = System.currentTimeMillis();
            String text = String.valueOf(distance);
            String text2 = String.valueOf(idaEndTime - idaStartTime);
            idaStarDistance.setText(text);
            idaStarTime.setText(text2);
            service.drawPath(false);
            if (distance < 0.) {
                infoText.setText("Path not found");
            } else {
                infoText.setText("Path found");
            }
        });
        
        astarPane.getChildren().addAll(aStarButton, aStarDistance, aStarTime);
        idastarPane.getChildren().addAll(idaStarButton, idaStarDistance, idaStarTime);
        textPane.getChildren().addAll(empty, distanceDes, timeText, infoText);
        optionsPane.getChildren().addAll(textPane, astarPane, idastarPane); 
        
        mainPane.getChildren().addAll(fileLabel, inputPane, browse, fileText, startCoordinatesText, xstartLabel, xstartInput,
                ystartLabel, ystartInput, endCoordinatesText, xendLabel, xendInput, yendLabel, yendInput, 
                radio, distanceTitle, optionsPane);       
        
        Scene inputScene = new Scene(mainPane, 700, 700);    
        primaryStage.setScene(inputScene);    
        
        primaryStage.show();
    }
    
}
