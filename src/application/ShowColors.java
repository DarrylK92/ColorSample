package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ShowColors extends Application {
	
	@Override
	public void start(Stage stage) throws Exception {
		//ColorPane class
		class ColorPane extends Pane {
			
			Rectangle r = new Rectangle();
			
			//Constructor
			ColorPane() {
				super();
				
				super.setHeight(300);
				super.setWidth(300);
				
				r = new Rectangle();
				r.setFill(new Color(.247, .5, .5, 1)); //Set initial color
				//Bind width and height to pane width and height
				r.setWidth(super.getWidth());
				r.setHeight(super.getHeight());
				//Set position to 0, 0
				r.setX(0);
				r.setY(0);
				super.getChildren().add(r); //Add rectangle to pane
			}
			
			//Methods
			public void saturationUp() {
				//Get color of fill from rectangle
				Color c = (Color) r.getFill();
				//Get current values
				double hue = c.getHue();
				double saturation = c.getSaturation();
				double brightness = c.getBrightness();
				//Modify saturation
				if (Math.sqrt(saturation) < 1)
					saturation = Math.sqrt(saturation);
				//Create new color
				Color newC = Color.hsb(hue, saturation, brightness);
				//Assign new color to rectangle
				r.setFill(newC);
			}
			
			public void saturationDown() {
				//Get color of fill from rectangle
				Color c = (Color) r.getFill();
				//Get current values
				double hue = c.getHue();
				double saturation = c.getSaturation();
				double brightness = c.getBrightness();
				//Modify saturation
				if (Math.pow(saturation, 2) > 0.01)
					saturation = Math.pow(saturation, 2);
				//Create new color
				Color newC = Color.hsb(hue, saturation, brightness);
				//Assign new color to rectangle
				r.setFill(newC);
			}
			
			public void hueUp() {
				//Get color of fill from rectangle
				Color c = (Color) r.getFill();
				//Get current values
				double hue = c.getHue();
				double saturation = c.getSaturation();
				double brightness = c.getBrightness();
				//Modify hue
				if (hue + 30 < 359)
					hue += 30;
				//Create new color
				Color newC = Color.hsb(hue, saturation, brightness);
				//Assign new color to rectangle
				r.setFill(newC);
			}
			
			public void hueDown() {
				//Get color of fill from rectangle
				Color c = (Color) r.getFill();
				//Get current values
				double hue = c.getHue();
				double saturation = c.getSaturation();
				double brightness = c.getBrightness();
				//Modify hue
				if (hue - 30 > 0)
					hue -= 30;
				//Create new color
				Color newC = Color.hsb(hue, saturation, brightness);
				//Assign new color to rectangle
				r.setFill(newC);
			}
			
			public void brightnessUp() {
				//Get color of fill from rectangle
				Color c = (Color) r.getFill();
				//Get current values
				double hue = c.getHue();
				double saturation = c.getSaturation();
				double brightness = c.getBrightness();
				//Modify brightness
				if (Math.sqrt(brightness) < 1)
					brightness = Math.sqrt(brightness);
				//Create new color
				Color newC = Color.hsb(hue, saturation, brightness);
				//Assign new color to rectangle
				r.setFill(newC);
			}
			
			public void brightnessDown() {
				//Get color of fill from rectangle
				Color c = (Color) r.getFill();
				//Get current values
				double hue = c.getHue();
				double saturation = c.getSaturation();
				double brightness = c.getBrightness();
				//Modify brightness
				if (Math.pow(brightness, 2) > 0.01)
					brightness = Math.pow(brightness, 2);
				//Create new color
				Color newC = Color.hsb(hue, saturation, brightness);
				//Assign new color to rectangle
				r.setFill(newC);
			}
		}
		
		//Create BorderPane
		BorderPane bPane = new BorderPane();
		
		//Create HBox for saturation and assign to bPane
		HBox top = new HBox(10);
		top.setAlignment(Pos.CENTER);
		bPane.setTop(top);
		
		//Create HBox for brightness and assign to bPane
		HBox bottom = new HBox(10);
		bottom.setAlignment(Pos.CENTER);
		bPane.setBottom(bottom);
		
		//Create VBox for hue and assign to bPane
		VBox right = new VBox(10);
		right.setAlignment(Pos.CENTER);
		bPane.setRight(right);
		
		//Create ColorPane ans assign to bPane
		ColorPane cPane = new ColorPane();
		bPane.setCenter(cPane);
		
		//Add buttons to top HBox
		Button saturationUp = new Button("More Saturated");
		saturationUp.setOnAction(e -> {
			cPane.saturationUp();
		});
		
		Button saturationDown = new Button("Less Saturated");
		saturationDown.setOnAction(e -> {
			cPane.saturationDown();
		});
		
		top.getChildren().addAll(saturationUp, saturationDown);
		
		
		//Add buttons to bottom HBox
		Button brightnessDown = new Button("Darker");
		brightnessDown.setOnAction(e -> {
			cPane.brightnessDown();
		});
		
		Button brightnessUp = new Button("Brighter");
		brightnessUp.setOnAction(e -> {
			cPane.brightnessUp();
		});
		
		bottom.getChildren().addAll(brightnessDown, brightnessUp);
		
		//Add buttons to right VBox
		Button hueUp = new Button("Hue up");
		hueUp.setOnAction(e -> {
			cPane.hueUp();
		});
		
		Button hueDown = new Button("Hue down");
		hueDown.setOnAction(e -> {
			cPane.hueDown();
		});
		
		right.getChildren().addAll(hueUp, hueDown);
		
		
		Scene scene = new Scene(bPane);
		stage.setScene(scene);
		stage.setTitle("Color Sample");
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	
}
