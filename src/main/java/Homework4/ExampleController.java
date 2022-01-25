package main.java.Homework4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ExampleController  {
@FXML
    public Label labelText;
@FXML
    public Button btnClick;

    public void click(ActionEvent actionEvent) {

        System.out.println("Click");
        labelText.setText("Hello");
        btnClick.setText("Pressed");
        btnClick.setScaleX(5.0);


    }
}