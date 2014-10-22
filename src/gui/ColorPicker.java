package gui;

import java.util.Locale;
import java.util.ResourceBundle;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.JOptionPane;

/**
 *
 * Allows user to set colors for simulation cells
 *
 * @author Wenjun
 * @author Kevin Rhine
 */
public class ColorPicker extends javafx.scene.control.ColorPicker {
	private GridInfo infoSheet = new GridInfo();
	private Grid grid;

	public ColorPicker(Grid g) {
		grid = g;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private GridPane buildColorPickerMenu(Text text, GridPane gridpane) {
		final ColorPicker colorPicker = new ColorPicker(grid);
		text.setFont(Font.font("Verdana", 20));
		String stateType = text.getText();
		Color myColor = infoSheet.getColor(stateType);
		colorPicker.setValue(myColor);
		text.setFill(myColor);

		colorPicker.setOnAction(new EventHandler() {

			@Override
			public void handle(Event t) {

				Color myColor = colorPicker.getValue();
				text.setFill(myColor);
				infoSheet.setColor(stateType, myColor);

				if ((text.getText() == "BACKGROUND")
						| (text.getText().contains("_"))) {
					grid.updateBackgroundColor(myColor);
				}
			}
		});

		gridpane.add(colorPicker, 1, index);
		gridpane.add(text, 2, index);

		return gridpane;

	}


	public void showColorPicker() {
		Stage myStage = new Stage();
		myStage.setResizable(false);
		myStage.setTitle("Choose colors for the simulation!");
		GridPane gridpane = new GridPane();
		gridpane.getColumnConstraints().add(new ColumnConstraints(60));
		gridpane.getColumnConstraints().add(new ColumnConstraints(90));
		Text[] colorsToChange = {new Text("Background"),new Text("Pen")};
		for (int i = 0; i < colorsToChange.length; i++) {
			gridpane.getRowConstraints().add(new RowConstraints(35));
		}

		Scene scene = new Scene(gridpane, 400, 40 * colorsToChange.length);

		for (int i = 0; i < colorsToChange.length; i++) {
			gridpane = buildColorPickerMenu(colorsToChange[i], gridpane);
		}

		myStage.setScene(scene);
		myStage.show();
	}
}