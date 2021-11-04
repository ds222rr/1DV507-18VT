package ds222rr_assign2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class CompoundInterest extends Application {

	public static void main(String[] args) {
		launch(args);	// launch application
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Compound Interest");				// Stage Title
		GridPane pane = new GridPane();						// Create new GridPane object

		pane.setPadding(new Insets(5, 5, 0, 10));
		pane.setHgap(20);
		pane.setVgap(7.5);
		
		HBox titleBox = new HBox();							// Box for title
		titleBox.setPadding(new Insets(5,10,5,5));
		titleBox.setAlignment(Pos.CENTER);
		final Label title = new Label("Compound Interest");	
		title.setFont(new Font("Arial", 30));				// Set title font and fontsize
		titleBox.getChildren().add(title);					// Add title to its box

		pane.add(new Label("Start Amount: "), 0, 1);		// Label for amount
		final TextField amount = new TextField();			// TextField for amount
		pane.add(amount, 1, 1);								
		
		pane.add(new Label("Interest: "), 0, 2);			// Label for interest
		final TextField interest = new TextField();			// TextField for interest
		pane.add(interest,  1, 2);							
		
		pane.add(new Label("Number of years: "), 0, 3);		// Label for years
		final TextField numberOfYears = new TextField();	// TextField for years
		pane.add(numberOfYears, 1 , 3);						
		
		Button calculate = new Button("Calculate");			// Button to perform calculation
		pane.add(calculate, 0, 4);
		
		Label result = new Label();
		HBox resultBox = new HBox();						// Box for result
		resultBox.getChildren().add(result);				// Add result to its box
		resultBox.setPadding(new Insets(5, 0, 5, 10));
		
		VBox vBox = new VBox();			// box for scene
		vBox.getChildren().addAll(titleBox, pane, resultBox);
			
		calculate.setOnAction(e -> {							// perform calculation
			String strAmount = amount.getText();				// get amount-String
			String strInterest = interest.getText();			// get interest-String
			String strNumberOfYears = numberOfYears.getText();	// get years-String
			
			boolean amountFlag = verify(strAmount);					// verify amount-input
			boolean interestFlag = verify(strInterest);				// verify interest-input
			boolean numberOfYearsFlag = verify(strNumberOfYears);	// verify years-input
			
			if (amountFlag == true && interestFlag == true && numberOfYearsFlag == true) {
				double property = Integer.parseInt(strAmount);	// get property-double
				int add = Integer.parseInt(strInterest);		// get interest-double
				int years = Integer.parseInt(strNumberOfYears);	// get years-int
				
				for (int i = 0; i < years; i++) {		// calculate compound interest
					double more = (property*add/100);
					property += more;
				}
				result.setText("In total that will be: "+Math.round(property));	// result
			}
			else {	// if input is incorrect
				result.setText("Invalid Input!");
			}
		}); 
		stage.setScene(new Scene(vBox));
		stage.show();
	}
	
	public boolean verify(String text) {	// verify input
		boolean flag = true;	// flag for valid or invalid input
		for (int i = 0; i < text.length(); i++) {
			// In case any character is not a digit
			if (!(Character.isDigit(text.charAt(i)))) {
				flag = false;
				break;
			}
		}
		// In case input is empty
		if (text.equals("")) {
			flag = false;
		}
		return flag;
	}
}
