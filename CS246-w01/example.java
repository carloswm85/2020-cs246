package mainPackage;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import figuresPackage.*;
import java.awt.Color;

public class MainFunctionFigures {

    public MainFunctionFigures() {

    }

    public static void main(String[] args){

        // f is figureBag1
        Figure f[] = new Figure[8];

        //Now I'm going to call the constructors.
        f[0] = new Triangle(3);
        f[1] = new Rectangle(2, 4);
        f[2] = new Square(3);
        f[3] = new Circle(4);
        f[4] = new Triangle(6);
        f[5] = new Rectangle(3, 9);
        f[6] = new Square(10);
        f[7] = new Square(10);

        // Color(red, green, blue, alpha);
        f[0].setColor(Color.RED);	f[1].setColor(Color.GREEN);	f[2].setColor(Color.BLUE);	f[3].setColor(Color.WHITE);
        f[4].setColor(Color.RED);	f[5].setColor(Color.GREEN);	f[6].setColor(Color.BLUE);	f[7].setColor(Color.BLUE);

        f[0].setPosition(0, 1);		f[1].setPosition(2, 3);		f[2].setPosition(4, 5);		f[3].setPosition(6, 7);
        f[4].setPosition(8, 9);		f[5].setPosition(10, 11);	f[6].setPosition(12, 13);	f[7].setPosition(12, 13);


        for(int j = 0; j < 8; j++) {
            System.out.println("@Iteration: " + j);
            System.out.println("- whatAreYou(): " + f[j]);
            System.out.println("- Area is: " + f[j].area());
            System.out.println("- Perimeter is: " + f[j].perimeter());
            System.out.println("- Sides are: " + f[j].sides());
            System.out.println("- Figure's color: " + f[j].getColor());
            System.out.println("- Figure's location: " + f[j].getPosition() + "\n");
        }

        //	whatAreYou()
        String whatsThis = f[0].getType();
        System.out.println("- whatAreYou function is: " + whatsThis + "\n");

        //	DIFFERENT
        // equals() compare the objects' values. The == operator also compares the objects' memory location.
        if(f[3] == f[4])
            System.out.println("Are equal.");
        else
            System.out.println("Are different.");

        if(f[3].equals(f[4]))
            System.out.println("Are equal.");
        else
            System.out.println("Are different.");

        //	EQUAL
        if(f[6] == f[7])
            System.out.println("Are equal.");
        else
            System.out.println("Are different.");

        if(f[0].equals(f[4]))
            System.out.println("Are equal.");
        else
            System.out.println("Are different.");

        System.out.println();
        // ARRAYLIST
        // arraylist is a dynamic vector. which is a collection
        List<Figure> figureBag2 = new ArrayList<Figure>();
        Figure f1 = new Circle(2);
        figureBag2.add(f1);						//1� Circle
        figureBag2.add(new Square(2));			//2� Square
        figureBag2.add(new Circle(7));			//3� Circle
        figureBag2.add(new Rectangle(7, 5));	//4� Rectangle
        Figure f2 = new Triangle(2);
        figureBag2.add(2, f2);					//5� to 3� place

        // Iterator for the arraylist. Iterator is an object.
        // listIterator() places the iterator at the beginning of the collection.
        ListIterator<Figure> iteratorFig = figureBag2.listIterator();
        Figure element;

        while(iteratorFig.hasNext()) {

            element = iteratorFig.next();
            int var = element.perimeter();
            System.out.println("Perimeter: " + var + " of figure: " + element.getType());
        }
    }
}
