package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;
import sample.Methods.AbstractProductArrow;
//import sample.Methods.FactoryAssociation;
import sample.Methods.FactoryParallel;
import sample.Methods.FactorySequence;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private AbstractProductArrow currentArrow;

    public Canvas canvas;
    public ChoiceBox<String> arrows;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        arrows.getItems().addAll("Последовательный вызов", "Параллельный вызов");
        arrows.setValue("Последовательный вызов");


        currentArrow =new FactorySequence().CreateArrow(canvas);

        canvas.getGraphicsContext2D().setLineWidth(1.0);

    }

    public void checked(ActionEvent actionEvent) {

        String current=arrows.getValue(); // получение выбранного  текстового значения
        System.out.println(current);
        if(current.equals("Последовательный вызов")) currentArrow = new FactorySequence().CreateArrow(canvas);
        if(current.equals("Параллельный вызов")) currentArrow = new FactoryParallel().CreateArrow(canvas);
    }



    public void onBegin(MouseEvent mouseEvent) {
        System.out.println("Mouse pressed");
        currentArrow.setStartX(mouseEvent.getX());
        currentArrow.setStartY(mouseEvent.getY());
        currentArrow.drawArrowStart(canvas.getGraphicsContext2D());
    }

    public void onEnd(MouseEvent dragEvent) {
        System.out.println("Mouse released");
        currentArrow.setEndX(dragEvent.getX());
        currentArrow.setEndY(dragEvent.getY());
        currentArrow.drawLine(canvas.getGraphicsContext2D(),20.);
        currentArrow.drawArrowEnd(canvas.getGraphicsContext2D());
    }

    public void clearCanvas() {
        System.out.println("Canvas cleared");
        canvas.getGraphicsContext2D().clearRect(0,0,canvas.getWidth(),canvas.getHeight());
    }



}