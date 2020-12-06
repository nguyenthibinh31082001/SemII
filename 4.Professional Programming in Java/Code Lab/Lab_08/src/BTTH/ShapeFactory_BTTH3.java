/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTH;

/**
 *
 * @author ADMIN
 */
public class ShapeFactory_BTTH3 {
    public Shape getShape(String shapeType) {
        if (shapeType == null) {
           return null;
        }
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
        return new Circle();

        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
        return new Rectangle_BTTH3();

        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
        return new Square();
        }

        return null;
    }
    
    public static void main(String[] args) {
        ShapeFactory_BTTH3 shapeFactory = new ShapeFactory_BTTH3();

        Shape shape1 = shapeFactory.getShape("CIRCLE");
        shape1.draw();

        Shape shape2 = shapeFactory.getShape("RECTANGLE");

        shape2.draw();

        Shape shape3 = shapeFactory.getShape("SQUARE");

        shape3.draw();
    }
}
