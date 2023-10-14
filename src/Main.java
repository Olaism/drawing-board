import java.awt.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Ch5DrawShape screensaver = new Ch5DrawShape();
        screensaver.start();
    }
}

class Ch5DrawShape { // constructor
    // Data member
    private final DrawingBoard canvas;
    private Scanner scanner;
    public Ch5DrawShape() {
        canvas = new DrawingBoard();
    }
    public void start() {
        DrawableShape shape1 = getShape();
        canvas.addShape(shape1);
        canvas.setMovement(inputMotionType());
        canvas.setVisible(true);
        canvas.start();
    }
    private DrawingBoard.Movement inputMotionType() {
        System.out.println("Selection: Enter the motion number\n" +
                "   1 - Stationary (no movement) \n" +
                "   2 - Random Movement \n" +
                "   3 - Smooth Movement \n");
        int selection = scanner.nextInt();
        DrawingBoard.Movement type;
        switch (selection) {
            case 1 -> type = DrawingBoard.Movement.STATIONARY;
            case 2 -> type = DrawingBoard.Movement.RANDOM;
            case 3 -> type = DrawingBoard.Movement.SMOOTH;
            default -> type = DrawingBoard.Movement.SMOOTH;
        }
        return type;
    }

    private DrawableShape getShape() {
        DrawableShape.Type type = inputShapeType();
        Dimension dim = inputDimension();
        Point centerPt = inputCenterPoint();
        Color color = inputColor();
        DrawableShape shape = new DrawableShape(type, dim, centerPt, color);
        return  shape;
    }
    private Color inputColor() {
        System.out.println("Selection: Enter the Color number: \n" +
                "   1 - red\n" +
                "   2 - Green\n" +
                "   3 - Yellow\n" +
                "   4 - Magenta\n" +
                "   default - Blue \n");
        int selection = scanner.nextInt();
        Color color;
        switch (selection) {
            case 1 -> color = Color.RED;
            case 2 -> color = Color.GREEN;
            case 3 -> color = Color.YELLOW;
            case 4 -> color = Color.MAGENTA;
            default -> color = Color.BLUE;
        }
        return color;
    }
    private Dimension inputDimension() {
        System.out.println("Enter the width of the shape \nbetween 100 and 500 inclusive: ");
        int width = scanner.nextInt();
        if (width < 100 || width > 500) {
            width = 100;
        }
        System.out.println("Enter the height of the shape \nbetween 100 and 500 inclusive: ");
        int height = scanner.nextInt();
        if (height < 100 || height > 500) {
            height = 100;
        }
        return new Dimension(width, height);
    }
    private Point inputCenterPoint() {
        System.out.println("Enter the x value of the center point\n between 200 and 800 inclusive: ");
        int x = scanner.nextInt();
        if (x < 200 || x > 800) {
            x = 200;
        }
        System.out.println("Enter the y value of the center point\n between 100 and 500 inclusive: ");
        int y = scanner.nextInt();
        if (y < 100 || x > 500) {
            y = 100;
        }
        return new Point(x, y);
    }
    private DrawableShape.Type inputShapeType() {
        System.out.println("Selection: Enter the shape number\n" +
                "   1 - Ellipse \n" +
                "   2 - Rectangle \n" +
                "   3 - Rounded Rectangle \n");
        int selection = scanner.nextInt();
        DrawableShape.Type type;
        switch (selection) {
            case 1:
                type = DrawableShape.Type.ELLIPSE;
                break;
            case 2:
                type = DrawableShape.Type.RECTANGLE;
                break;
            case 3:
                type = DrawableShape.Type.ROUNDED_RECTANGLE;
                break;
            default:
                type = DrawableShape.Type.ELLIPSE;
                break;
        }
        return type;
    }
}
class DrawingBoard {
    public enum Movement {SMOOTH, STATIONARY, RANDOM};
    private Movement movement;
    public DrawingBoard() {  // constructor

    }
    public void setVisible(boolean state) {

    }
    public void setBackground(Color color) {

    }
    public void setDelayTime(double delay) {

    }
    public void addShape(DrawableShape shape) {

    }
    public void setMovement(Movement type) {
        movement = type;
    }

    public void start() {

    }
}

class DrawableShape {
    public static enum Type {ELLIPSE, RECTANGLE, ROUNDED_RECTANGLE};
    private static final Dimension DEFAULT_DIMENSION = new Dimension(200, 200);
    private static final Point DEFAULT_CENTER_PT = new Point(350, 350);
    private static final Color DEFAULT_COLOR = Color.BLUE;
    private Dimension dimension;
    private Point centerPoint;
    private Color fillColor;
    private Type type;
    public DrawableShape(Type sType, Dimension sDim, Point sCenter, Color sColor) {  // constructor
        type = sType;
        dimension = sDim;
        centerPoint = sCenter;
        fillColor = sColor;
    }
    public void draw(Graphics g) {
        g.setColor(fillColor);
        drawShape(g);
    }
    public void setType(Type shapeType) {
        type = shapeType;
    }
    private void drawShape(Graphics g) {
        switch (type) {
            case ELLIPSE -> g.fillOval(centerPoint.x - dimension.width / 2, centerPoint.y - dimension.height / 2, dimension.width, dimension.height);
            case RECTANGLE -> g.fillRect(centerPoint.x - dimension.width / 2, centerPoint.y - dimension.height / 2, dimension.width, dimension.height);
            case ROUNDED_RECTANGLE -> g.fillRoundRect(centerPoint.x - dimension.width / 2,
                    centerPoint.y - dimension.height / 2,
                    dimension.width, dimension.height,
                    (int) (dimension.width * 0.3), (int) (dimension.height * 0.3));
        }
    }
    public Dimension getDimension() {
        return new Dimension(200, 200);
    }
    public Point getCenterPoint() {
        return centerPoint;
    }
    public void setCenterPoint(Point point) {
        centerPoint = point;
    }
}