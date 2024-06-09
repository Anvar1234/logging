import test_classes.MyTest;

public class Main {
    public static void main(String[] args) {
        MyTest myTest = new MyTest();

        System.out.println("sum : " + myTest.sum(5, 10));
        System.out.println("division : " + myTest.division(5, 2));
    }
}