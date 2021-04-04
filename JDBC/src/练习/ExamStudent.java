package 练习;

public class ExamStudent {
    private int flowID;
    private int type;
    private String IDCard;
    private String examCard;
    private String name;
    private String location;
    private int grade;

    public ExamStudent() {
        super();
    }

    public ExamStudent(int flowID, int type, String IDCard, String examCard, String name, String location, int grade) {
        this.flowID = flowID;
        this.type = type;
        this.IDCard = IDCard;
        this.examCard = examCard;
        this.name = name;
        this.location = location;
        this.grade = grade;
    }

    public void setFlowID(int flowID) {
        this.flowID = flowID;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setIDCard(String IDCard) {
        this.IDCard = IDCard;
    }

    public void setExamCard(String examCard) {
        this.examCard = examCard;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getFlowID() {
        return flowID;
    }

    public int getType() {
        return type;
    }

    public String getIDCard() {
        return IDCard;
    }

    public String getExamCard() {
        return examCard;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "========学生信息========\n" +
                "流水号:" + flowID +"\n"+
                "四级/六级:" + type +"\n"+
                "身份证号:" + IDCard +"\n"+
                "准考证号：" + examCard +"\n"+
                "姓名：" + name +"\n"+
                "成绩：" + grade+"\n"+
                "地区：" + location;
    }
}
