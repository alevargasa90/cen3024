package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

//Author Name: Alejandro Vargas
//Date: 11/14/2021
//Program Name: main.Vargas_module7_word_occurrence
//Purpose: load a text file and output the top 20 most used words with unit testing added 
// I moved the method to a separate class to test that class


/**
 * load a text file and output the top 20 most used words with unit testing added 
// I moved the method to a separate class to test that class
 */
public class Vargas_module7_word_occurrence extends Application {

    private Text actionStatus;
    private Text description, select;
    private TextArea result;

    private WordOccurrence wordOccurrence;

    public static void main(String[] args) {
        launch(args);

    }
/**
 * It starts the first stage of the javaFX app
 */
    public void start(Stage primaryStage) throws Exception {
        wordOccurrence = new WordOccurrence();

        select = new Text("Select the file to be analyzed.");
        select.setTranslateX(10);

        Button open = new Button("Select a file");
        open.setOnAction(new SingleFcButtonListener());
        open.setTranslateX(20);
        HBox open1 = new HBox(10);
        open1.getChildren().addAll(open);

        actionStatus = new Text();
        actionStatus.setTranslateX(10);

        description = new Text("The list displays the words and the number of occurrences in the text.");
        description.setTranslateX(10);

        result = new TextArea();
        result.setPrefHeight(500);
        result.setPrefWidth(400);


        VBox vbox = new VBox(20);
//		vbox.setAlignment(CENTER);
        vbox.getChildren().addAll(select, open1, actionStatus, description, result);
        Scene scene = new Scene(vbox, 500, 600);
        primaryStage.setTitle("Vargas Word Ocurrence");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    /**
     * this class allow the user to select the file using the bottom "select file 
     */
    private class SingleFcButtonListener implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            try {
                showSingleFileChooser();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    
    /**
     * It displays a screen that allows the user to choose the location and file to be processed 
     */
    private void showSingleFileChooser() throws IOException {

        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            wordOccurrence(selectedFile);
            actionStatus.setText("File selected: " + selectedFile.getName());
        }

    }

    
    /**
     * It takes a file and creates a map which takes the words of the text as keys and the occurrences as values. 
     * Then it create a list with the words which have a higher occurrence determine by the variable "top" 
     * and display the list in a box
	 * 
	 * @param file file that will be checked by the wordOccurrence.
	 * @throws IOException if the file does not exist
     */
    private void wordOccurrence(File file) throws IOException {
        int top = 20;
        Map<String, Integer> wordsCounter = wordOccurrence.wordOccurrence(file);

        List<Entry<String, Integer>> topCounters = wordOccurrence.getTopCounters(wordsCounter, top);

        StringBuilder sb = new StringBuilder();
        if (!topCounters.isEmpty()) {
            int size = Math.min(topCounters.size(), top);

            for (int i = 0; i < size; i++) {
                Entry<String, Integer> e = topCounters.get(i);
                sb.append(String.format("%d. %s %d %n", (i + 1), e.getKey(), e.getValue()));
            }
        }

        result.setText(sb.toString());
    }
}
