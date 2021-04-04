package Object_Oriented.继承练习;

public class Kids extends ManKind{
    private int yearsOld;

    public void setYearsOld(int yearsOld) {
        this.yearsOld = yearsOld;
    }

    public int getYearsOld() {
        return yearsOld;
    }

    public void ageInfo()
    {
        System.out.println("YearsOld："+yearsOld+"!");
    }
}
