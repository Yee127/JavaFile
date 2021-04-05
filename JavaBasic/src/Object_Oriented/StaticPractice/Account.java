package Object_Oriented.StaticPractice;

public class Account {
    private int user_id;
    private String passward;
    private double balance;
    private static double MinBalance;
    private static double  interestRate;
    private static int init = 1001;// 用于随机生成id

    public Account(String passward,double balance){
        user_id = init++;
        this.balance = balance;
        this.passward = passward;

    }

    public Account(){
        user_id = init++;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setPassward(String passward) {
        this.passward = passward;
    }

    public String getPassward() {
        return passward;
    }

    public static void setMinBalance(Double minBalance) {
        MinBalance = minBalance;
    }

    public static double getMinBalance() {
        return MinBalance;
    }

    public static void setInterestRate(double interestRate) {
        Account.interestRate = interestRate;
    }

    public static double getInterestRate() {
        return interestRate;
    }

    @Override
    public String toString() {
        return "Account{" +
                "user_id=" + user_id +
                ", passward='" + passward + '\'' +
                ", balance=" + balance +
                '}';
    }
}
