package helloworld;

import java.util.Locale;

public class HelloWorld {

    public static void main(String[] args) {
	    new HelloWorld().sayHello();

	    HelloWorld hi = new HelloWorld();
	    hi.sayHello();

        float floatVar = (float) 33.2;
        int intVar = 5;
        String stringVar = "Carlos";

        System.out.format(Locale.FRANCE,
                "The value of the float " + "variable is %f, while the " +
                        "value of the integer variable " + "is %d, and the string is %s%n",
                floatVar, intVar, stringVar);
    }

    public void sayHello() {
        System.out.println("Hello World");
    }
}
