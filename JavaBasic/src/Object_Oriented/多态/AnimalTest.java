package Object_Oriented.多态;

public class AnimalTest {
    public static void main(String[] args) {
        AnimalTest t = new AnimalTest();

        t.func(new Dog());

        t.func(new Cat());

    }

    public  void func(Animal animal)
    {

        animal.eat();
        animal.shout();
    }
}

class Animal{

    public void eat(){
        System.out.println("动物 吃");
    }

    public void shout(){
        System.out.println("叫");
    }
}


class Dog extends Animal{

    public void eat(){
        System.out.println("动物 狗");
    }

    public void shout(){
        System.out.println("叫  汪汪汪");
    }
}


class Cat extends Animal{

    public void eat(){
        System.out.println("动物 🐈");
    }

    public void shout(){
        System.out.println("喵喵喵~");
    }
}
