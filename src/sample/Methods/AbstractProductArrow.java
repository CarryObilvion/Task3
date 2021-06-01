package sample.Methods;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class AbstractProductArrow {

    Color color;

    double width;

    double startX;

    double startY;

    double endX;

    double endY;

    double lineDash;

    public abstract void draw(GraphicsContext gc);

    public abstract void setStartX(double x);

    public abstract void setStartY(double y);

    public abstract void setEndX(double x);

    public abstract void setEndY(double y);

    public abstract void drawArrowStart(GraphicsContext graphicsContext2D);

    public abstract void drawArrowEnd(GraphicsContext graphicsContext2D);

    public abstract void drawLine(GraphicsContext gc, double lineDash);
}
