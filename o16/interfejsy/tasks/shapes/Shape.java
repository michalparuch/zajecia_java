package basics.o16.interfejsy.tasks.shapes;

import java.util.List;

public interface Shape {
    static Shape getFigureWithLargestArea(List<Shape> shapes) {
      Shape shapeWithLargestArea = shapes.getFirst();

      for (Shape shape : shapes){
          if(shape.countArea() > shapeWithLargestArea.countArea()){
              shapeWithLargestArea = shape;
          }
      }
      return shapeWithLargestArea;
    };

    static Shape getFigureWithLargestCircumference(List<Shape> shapes) {
        Shape shapeWithLargestCircumference = shapes.getFirst();

        for (Shape shape : shapes){
            if(shape.countCircumference() > shapeWithLargestCircumference.countCircumference()){
                shapeWithLargestCircumference = shape;
            }
        }
        return shapeWithLargestCircumference;
    };

    Double countArea();
    Double countCircumference();

}
