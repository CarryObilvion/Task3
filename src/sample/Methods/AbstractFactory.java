package sample.Methods;

import javafx.scene.canvas.Canvas;

public interface AbstractFactory {
    AbstractProductArrow CreateArrow(Canvas canvas);
}
