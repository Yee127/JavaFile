package Object_Oriented.继承练习;

public class KidsTest {
    public static void main(String[] args) {
        Kids someKid = new Kids();
        someKid.setYearsOld(20);
        someKid.ageInfo();

        someKid.setSalary(5000);
        someKid.setSex(1);

        someKid.employeed();
        someKid.manOrWoman();

    }
}
