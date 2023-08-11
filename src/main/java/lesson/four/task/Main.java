package lesson.four.task;

public class Main {
    public static void main(String[] args) {
        Box<Apple> appleBox1 = new Box<>();
        appleBox1.addFruit(new Apple());
        appleBox1.addFruit(new Apple());
        appleBox1.addFruit(new Apple());

        Box<Apple> appleBox2 = new Box<>();
        appleBox2.addFruit(new Apple());
        appleBox2.addFruit(new Apple());

        Box<Orange> orangeBox = new Box<>();
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());

        System.out.println(appleBox1.compare(appleBox2));
        System.out.println(appleBox1.compare(orangeBox));

        appleBox1.transfer(appleBox2);
        System.out.println(appleBox1.getWeight(new Apple()));
        System.out.println(appleBox2.getWeight(new Apple()));
    }
}
