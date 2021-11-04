package ds222rr_assign2;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class Snowman extends Application {
	public static void main(String[] args) {
		launch(args);	// launch application
	}

	@Override
	public void start(Stage t) throws Exception {
		Group root = new Group();						// Create new Group object
		Rectangle sky = new Rectangle(0, 0, 800, 400);		// Rectangle for the sky
		sky.setFill(Color.CYAN);							// Color of the sky
		Circle snow1 = new Circle(400, 350, 60);			// Buttom snowball
		Circle snow2 = new Circle(400, 260, 40);			// Middle snowball
		Circle snow3 = new Circle(400, 200, 25);			// Top snowball
		Circle button1 = new Circle(400, 280, 4);			// Buttom button
		Circle button2 = new Circle(400, 260, 4);			// Middle button
		Circle button3 = new Circle(400, 240, 4);			// Top button
		Circle leftEye = new Circle(390, 190, 4);			// Left eye
		Circle rightEye = new Circle(410, 190, 4);			// Right eye
		Line mouth = new Line(390, 210, 410, 210);			// Mouth
		Circle sun = new Circle(700, 100, 50);				// Sun
		snow1.setFill(Color.WHITE);							
		snow2.setFill(Color.WHITE);
		snow3.setFill(Color.WHITE);
		sun.setFill(Color.YELLOW);
		
		// Add all drawings to root
		root.getChildren().addAll(sky, snow1, snow2, snow3, sun);
		root.getChildren().addAll(button1, button2, button3, leftEye, rightEye, mouth);

		//	Create and set new Scene object
		t.setScene(new Scene(root, 800, 600));
		t.setTitle("Snowman");
		t.show();
	}
}
