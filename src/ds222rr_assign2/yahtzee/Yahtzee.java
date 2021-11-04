package ds222rr_assign2.yahtzee;

import java.util.Random;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Yahtzee extends Application {
	
	int rolls = 3;
	
	public static void main(String[] args) {
		launch(args);	// launch application
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Yahtzee");				// Stage Title
		GridPane pane = new GridPane();			// Create new GridPane object
				
		pane.setPadding(new Insets(10, 10, 10, 10));
		pane.setHgap(7.5);
		pane.setVgap(7.5);
		
		HBox titleBox = new HBox();					// Box for title
		titleBox.setPadding(new Insets(5,5,5,5));
		final Label title = new Label("Yahtzee");	// Label for title
		title.setFont(new Font("Arial", 30));		// Set title font and fontsize
		titleBox.getChildren().add(title);			// Add title to its box
		
		Random rand = new Random();			// Create new Random object for random dices	
		Dice [] dice = new Dice[5];			// Array to store dices
		HBox [] diceBoxes = new HBox[5];	// Array to store boxes for dices
		
		// Iterative statement to create and store dices and diceBoxes
		for (int i = 0; i < dice.length; i++) {
			dice[i] = new Dice(rand.nextInt(6)+1);
			diceBoxes[i] = new HBox();
			diceBoxes[i].getChildren().add(dice[i]);
			diceBoxes[i].setPadding(new Insets(10, 10, 10,10));
			pane.add(diceBoxes[i], i, 1);
		}

		CheckBox [] checkBox = new CheckBox[5];	// Array to store checkBoxes
		HBox [] checkBoxBox = new HBox[5];		// Array to store boxes for checkBoxes
		
		// Iterative statement to create and store checkBoxes and checkBoxBoxes
		for (int i = 0; i < checkBox.length; i++) {
			checkBox[i] = new CheckBox();
			checkBoxBox[i] = new HBox();
			checkBoxBox[i].getChildren().add(checkBox[i]);
			checkBoxBox[i].setAlignment(Pos.CENTER);
			pane.add(checkBoxBox[i], i, 2);
		}
		
		Button roll = new Button("Roll the dice!");		// Command Button
		pane.add(roll, 0, 4);

		Label result = new Label();							// Label for result
		result.setText("You have "+rolls+" roll(s) left");	
		pane.add(result, 1, 4);
		
		HBox buttom = new HBox();						// Box for Command Button and result
		buttom.setPadding(new Insets(10, 10, 10, 10));
		buttom.setSpacing(20);
		buttom.setAlignment(Pos.CENTER_LEFT);
		buttom.getChildren().addAll(roll, result);
		
		VBox vBox = new VBox();								// box for scene
		vBox.getChildren().addAll(titleBox, pane, buttom);
				
		roll.setOnAction(e -> {		// perform roll
			if (rolls > 0) {	// In case remaining rolls are above zero
				// Iterative statement to verify all checkBoxes
				for (int i = 0; i < checkBox.length; i++) {
					// In case a checkBox is not selected
					if ((!checkBox[i].isSelected())) {
						diceBoxes[i].getChildren().clear();			// delete dice
						dice[i] = new Dice(rand.nextInt(6)+1);		// get new dice
						diceBoxes[i].getChildren().add(dice[i]);
						stage.show();
					}
				}
				rolls--;			// decrease remaining rolls
				if (rolls > 0) {	// In case rolls are still available
					result.setText("You have "+rolls+" roll(s) left");
				}
				else {		// In case no rolls are available
					int [] numbers = new int[6];	// Array to count all diced numbers
					boolean five = false;			// true if all dices are the same
					boolean four = false;			// true if four dices are the same
					boolean three = false;			// true if three dices are the same
					int two = 0;					// to count number of pairs
					int one = 0;					// to count number of single numbers
					
					// Iterative statement to count all diced numbers
					for (int i = 0; i < dice.length; i++) {
						int a = dice[i].getValue()-1;
						numbers[a]++;
					}	
					
					/* Iterative statement to determine whether numbers[] contains
					   five, four, or three numbers of same kind or pairs */					
					for (int i = 0; i < numbers.length; i++) {
						if (numbers[i] == 5) {
							five = true;
							break;
						}
						else if (numbers[i] == 4) {
							four = true;
							break;
						}
						else if (numbers[i] == 3) {
							three = true;
						}
						else if (numbers[i] == 2) {
							two++;
						}
					}
					// Iterative statement to determine whether numbers[] contains a street
					if (five != true && four != true && three == false && two < 2) {
						for (int i = 0; i < numbers.length; i++) {
							if (numbers[i] >= 1) {
								one++;
							}
							else if (numbers[i] == 0 && one < 4) {
								one = 0;
							}
							else if (numbers[i] == 0) {
								break;
							}
						}
					}
					// Determine result and setText
					if (five == true) {
						result.setText("Yahtzee");
					}
					else if (four == true) {
						result.setText("Four of a kind");
					}
					else if (three == true && two >= 1) {
						result.setText("Full House");
					}
					else if (three == true) {
						result.setText("Three of a kind");
					}
					else if (one == 5) {
						result.setText("Large Straight");
					}
					else if (one == 4) {
						result.setText("Small Straight");
					}
					else if (two == 2) {
						result.setText("Two pairs");
					}
					else if (two == 1) {
						result.setText("Pair");
					}
					else {
						result.setText("None");
					}
				}
			}
		});
		stage.setScene(new Scene(vBox));
		stage.show();
	}
}
