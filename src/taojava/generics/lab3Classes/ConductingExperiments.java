package taojava.generics.lab3Classes;

import taojava.generics.Box;
import taojava.generics.ExpandableArray;
import taojava.generics.SimpleExpandableArray;

import java.io.PrintWriter;

public class ConductingExperiments {
    public void conductingExperiments() {

        /*
         Create a box and have two variables refer to that box
         */
        Box<String> boxWithString = new Box<>("Initial status");
        Box<String> newBoxWithString = boxWithString;

        /*
        Update the contents of the box through one of the variables
        and verify that the new value is available through the other.
         */
        boxWithString.set("New status for box");
        System.out.println(newBoxWithString.get()); // Output: New status for box


        /*
        Put an integer in a box, have two variables refer to that box,
        and increment the integer in the box using one of the variables.
         */
        Box<Integer> boxWithInteger = new Box<>(25);
        Box<Integer> newBoxWithInteger = boxWithInteger;
        boxWithInteger.set(boxWithInteger.get() + 1);
        System.out.println(newBoxWithInteger.get()); // Output: 26


        /*
         Put the string into an integer box
         */
        Box<Integer> intBoxWithString = new Box<>("Initial status"); // Compile-time error

        /*
         Put the integer into a string box
         */
        Box<String> stringBoxWithInt = new Box<>(25); // Compile-time error


        /*
        bbox1 contains a box box1 which in turn contains a string
         */
        String text = "Status";
        Box<String> box1 = new Box<>(text);
        Box<Box<String>> bbox1 = new Box<>(box1);

        /*
        changing the value of bbox1 indirectly using box2
         */
        Box<String> box2 = new Box<String>("indirectly set tests");
        bbox1.set(box2);

        /*
        changing the value of bbox1 directly creating a box3 object
         */
        Box<String> box3 = bbox1.get();
        box3.set("directly set status");

        /*
        Assigning a box of integer type to another
         */
        Box<Integer> boxWithInt = new Box<Integer>(20);
        Box<Object> boxWithObject = boxWithInt;


        PrintWriter printWriter = new PrintWriter(System.out, true);
        /*
        creating a list of strings
         */
        ExpandableArray<String> strings = new SimpleExpandableArray<>();
        /*
        Set values in list
         */
        for (int i = 0; i < 10; i++) {
            strings.set(i, "String " + i);
        }
        /*
        Get values from list
         */
        for (int i = 0; i < 10; i++) {
            printWriter.println("strings[" + i + "] = " + strings.get(i));
        }
    }
}
