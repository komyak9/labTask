import java.lang.reflect.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        String classA = "A";
        String classB = "B";
        String classC = "C";
        String classD = "D";


        try {
            Class class1 = Class.forName(classA);
            Constructor<A> cons1 = class1.getConstructor(int[].class);

            Class class2 = Class.forName(classB);
            Constructor<B> cons2 = class2.getConstructor(String[].class);

            Class class3 = Class.forName(classC);
            Constructor<C> cons3 = class3.getConstructor(boolean[].class);

            Class class4 = Class.forName(classD);
            Constructor<D> cons4 = class4.getConstructor(double[].class);



            int[] parameters1 = (int[]) Array.newInstance(int.class, 4);
            Array.set(parameters1, 0, 11);
            Array.set(parameters1, 1, 22);
            Array.set(parameters1, 2, 33);
            Array.set(parameters1, 3, 44);

            String[] parameters2 = (String[]) Array.newInstance(String.class, 2);
            Array.set(parameters2, 0, "MyParam");
            Array.set(parameters2, 1, "MysecondParam");

            boolean[] parameters3 = (boolean[]) Array.newInstance(boolean.class, 3);
            Array.set(parameters3, 0, true);
            Array.set(parameters3, 1, false);
            Array.set(parameters3, 2, true);

            double[] parameters4 = (double[]) Array.newInstance(double.class, 5);
            Array.set(parameters4, 0, 3.1415);
            Array.set(parameters4, 1, 17.98);
            Array.set(parameters4, 2, 2.7);
            Array.set(parameters4, 3, 9.82);
            Array.set(parameters4, 4, 10.3);

            A a = cons1.newInstance((Object) parameters1);
            B b = cons2.newInstance((Object) parameters2);
            C c = cons3.newInstance((Object) parameters3);
            D d = cons4.newInstance((Object) parameters4);

            a.printNumbers();
            b.printStrings();
            c.printBooleans();
            d.printDoubles();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}



class A{
    int[] numbers;
    public A(int[] numbers){
        this.numbers = numbers;
    }

    public void printNumbers(){
        System.out.print("A values:\t");
        for (int n : numbers){
            System.out.print(n + "\t");
        }
        System.out.println("\n");
    }
}

class B{
    String[] strings;
    public B(String[] strings){
        this.strings = strings;
    }

    public void printStrings() {
        System.out.print("B values:\t");
        for(String s : strings){
            System.out.print(s + "\t");
        }
        System.out.println("\n");

    }
}

class C{
    boolean[] booleans;
    public C(boolean[] booleans){
        this.booleans = booleans;
    }

    public void printBooleans() {
        System.out.print("C values:\t");
        for(boolean b : booleans){
            System.out.print(b + "\t");
        }
        System.out.println("\n");
    }
}

class D{
    double[] doubles;
    public D(double[] doubles){
        this.doubles = doubles;
    }

    public void printDoubles() {
        System.out.print("D values:\t");
        for(double d : doubles){
            System.out.print(d + "\t");
        }
        System.out.println("\n");
    }
}