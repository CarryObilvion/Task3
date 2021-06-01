package sample.Methods;

import javafx.scene.canvas.Canvas;

public class FactorySequence implements  AbstractFactory {

    @Override

    public AbstractProductArrow CreateArrow(Canvas canvas) {

        int startX = 10;
        int startY = 100;

        int endX = 200;
        int endY = 150;

        return new ArrowPropertySequence(startX, startY, endX, endY,2.);
    }
}