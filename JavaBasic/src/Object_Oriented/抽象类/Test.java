package Object_Oriented.抽象类;

public class Test {
    public static void main(String[] args) {
//        Employee employee = new Employee("George W.", "Houston, TX", 43);抽象类不可以实例化

        Salary s = new Salary("Mohd Mohtashim", "Ambehta, UP", 3, 3600.00);
        Employee e = new Salary("John Adams", "Boston, MA", 2, 2400.00);

        System.out.println("Call mailCheck using Salary reference --");
        s.mailCheck();

        System.out.println("\n Call mailCheck using Employee reference--");
        e.mailCheck();
    }
}
