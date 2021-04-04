package Object_Oriented.StaticPractice;

public class BankTest {
    public static void main(String[] args) {
        Account account = new Account();
        Account account1 = new Account("123456",10000);

        account.setPassward("qwerty");
        account.setBalance(20000);
        System.out.println(account);
        System.out.println(account1);


    }

}
