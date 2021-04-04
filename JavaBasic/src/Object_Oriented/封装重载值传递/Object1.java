package Object_Oriented.封装重载值传递;

class Student{
    int num,state,score;

    public String info(){
        return "ID:"+num+"\tState:"+state+"\t\tScore:"+score;
    }
}
public class Object1 {
    public static void main(String[] args) {
        Student[] stu = new Student[20];

        for (int i = 0; i < stu.length; i++) {
            stu[i] = new Student();
            stu[i].num = i + 1;
            stu[i].state = (int) (Math.random() * (6 - 1 + 1) + 1);
            stu[i].score = (int) (Math.random() * (100 - 0 + 1));
        }
        System.out.println("____________________________________");
        for (int i = 0; i<stu.length;i++){
            if (stu[i].state == 3){
                System.out.println(stu[i].info());
            }

        }
        System.out.println("____________________________________");

        for (int i = 1; i<=stu.length;i++){
            for (int j = 0; j<stu.length-i;j++){
                if (stu[j].score < stu[j+1].score)
                {
                    Student t;
                    t = stu[j];stu[j]=stu[j+1];stu[j+1] = t;
                }
            }
        }

        for (int i = 0; i<stu.length;i++){
            System.out.println(stu[i].info());;
        }

    }
}
