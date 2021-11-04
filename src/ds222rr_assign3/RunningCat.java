package ds222rr_assign3;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

public class RunningCat extends Application {
	
	private double mov;		// Move speed
	private int pictureNum = 0;	// Number for pictures in array
	private double xPos = 30;	// Starting x-position of the cat
	private ImageView[] temp = new ImageView[8];			// Temporary array for cat pictures 
	private ImageView[] imagesRight = new ImageView[8];		// Array for right-running cat pictures
	private ImageView[] imagesLeft = new ImageView[8];		// Array for left-running cat pictures
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage args) {
		Group root = new Group();
		
		// Adding background
		ImageView background = new ImageView(new Image("file:src//ds222rr_assign3//resources//BG.png"));
		background.setFitHeight(400);
		background.setFitWidth(800);
		root.getChildren().addAll(background);
		
		// Adding ground
		for (int i = 0; i < 7; i++) {
			ImageView imag = new ImageView(new Image("file:src//ds222rr_assign3//resources//2.png"));
			imag.setX(128*i);
			imag.setY(300);	
			root.getChildren().add(imag);
		}
		
		// Adding two copse of trees as boundaries
		ImageView treeOne = new ImageView(new Image("file:src//ds222rr_assign3//resources//Tree_1.png"));
		treeOne.setX(-220);
		treeOne.setY(20);
		ImageView treeTwo = new ImageView(new Image("file:src//ds222rr_assign3//resources//Tree_1.png"));
		treeTwo.setX(650);
		treeTwo.setY(20);
		root.getChildren().addAll(treeOne, treeTwo);
	
		// Adding cat pictures to arrays
		for (int i = 0; i < imagesRight.length; i++) {
			imagesRight[i] = new ImageView("file:src//ds222rr_assign3//resources//Run("+(i+1)+").png");
			imagesRight[i].setFitHeight(100);
			imagesRight[i].setFitWidth(120);
			imagesRight[i].setY(203);
			imagesLeft[i] = new ImageView("file:src//ds222rr_assign3//resources//Run("+(i+1)+".1).png");
			imagesLeft[i].setFitHeight(100);
			imagesLeft[i].setFitWidth(120);
			imagesLeft[i].setY(203);
		}
		// Start moving cat from left to right
		temp = imagesLeft;
		
		// Add start picture of cat
		root.getChildren().add(temp[pictureNum]);
		temp[pictureNum].setX(xPos);
		
		// Create Scene
		Scene scene = new Scene(root, 790, 400);
		args.setTitle("Running Cat");
		args.setScene(scene);
		args.setResizable(false);
		args.show();

		// KeyFrame
		KeyFrame k = new KeyFrame(Duration.millis(50), event -> {
			if (xPos >= 650) {
				root.getChildren().remove(temp[pictureNum]);	// Remove previous cat picture
				temp = imagesLeft;
				mov = -10;
			}
			else if (xPos <= 30) {
				root.getChildren().remove(temp[pictureNum]);	// Remove previous cat picture
				temp = imagesRight;
				mov = 10;
			}
			temp[pictureNum].setX(xPos + mov);				// Moving cat
			xPos = temp[pictureNum].getX();					// Store new position
			root.getChildren().remove(temp[pictureNum]);	// Remove previous cat picture
			// In case the last position of the array has been reached
			if (pictureNum == 7) {	
				pictureNum = -1;
			}
			root.getChildren().add(temp[++pictureNum]);		// Add next cat picture
			temp[pictureNum].setX(xPos);					// Set picture to current position

		});
		Timeline t = new Timeline(k);
		t.setCycleCount(Timeline.INDEFINITE);
		t.play();
	}
}