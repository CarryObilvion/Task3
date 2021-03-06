package sample.Methods;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class ArrowPropertySequence extends AbstractProductArrow  {

    public final Canvas canvas;
    double arrowHeadSize;// размер кончика стрелки

    public ArrowPropertySequence(double startX, double startY, double endX, double endY, double lineDash,Canvas canvas) {

        this.color = Color.BLACK;

        this.width = 1.8;

        this.lineDash = lineDash;

        this.startX = startX;

        this.startY = startY;

        this.endX = endX;

        this.endY = endY;

        this.canvas = canvas;
// определение пропорций кончика стрелки

        arrowHeadSize=0.09*Math.sqrt((this.startX-this.endX)*(this.startX-this.endX)+(this.startX-this.endX)*(this.startX-this.endX));



    }

    @Override
    public void draw(GraphicsContext gc) {
                drawArrowStart( gc);//начало стрелки

       drawLine(gc, this.lineDash);//линия

       drawArrowEnd(gc);//коней стрелки
    }

    public void setStartX(double StartX) {
        this.startX = StartX;
    }

    public void setStartY(double StartY) {
        this.startY = StartY;
    }

    public void setEndX(double EndX) {
        this.endX = EndX;
    }

    public void setEndY(double EndY) {
        this.endY = EndY;
    }

    public String toString() {

        return "Выбор объекта";  }

    public void drawArrowStart(GraphicsContext gc) {

        gc.setFill(color);

        gc.strokeOval(this.startX-width, this.startY-width, 2*width, 2*width);   }


    @Override
    public void drawLine(GraphicsContext gc, double lineDash) {

        this.canvas.getGraphicsContext2D().setStroke(color);

        this.canvas.getGraphicsContext2D().setLineWidth(width);

        this.canvas.getGraphicsContext2D().setLineDashes(this.lineDash);

        this.canvas.getGraphicsContext2D().moveTo(this.startX, this.startY);

        this.canvas.getGraphicsContext2D().lineTo(this.endX, this.endY);

        this.canvas.getGraphicsContext2D().stroke();// соединить точки

    }

    public void drawArrowEnd(GraphicsContext gc) {

        gc.moveTo(this.endX, this.endY);

        double angle = Math.atan2((this.endY - this.startY), (this.endX - this.startX)) - Math.PI / 2.0;

        double sin = Math.sin(angle);

        double cos = Math.cos(angle);

        //point1

        double x1 = (- 1.0 / 2.0 * cos + Math.sqrt(3) / 2 * sin) * arrowHeadSize + this.endX;

        double y1 = (- 1.0 / 2.0 * sin - Math.sqrt(3) / 2 * cos) * arrowHeadSize + this.endY;

        //point2

        double x2 = (1.0 / 2.0 * cos + Math.sqrt(3) / 2 * sin) * arrowHeadSize + this.endX;

        double y2 = (1.0 / 2.0 * sin - Math.sqrt(3) / 2 * cos) * arrowHeadSize + this.endY;

        gc.lineTo(x1, y1);

        gc.moveTo(x2, y2);

        gc.lineTo(this.endX, this.endY);

        gc.stroke();

    }

}