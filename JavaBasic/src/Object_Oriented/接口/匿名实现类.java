package Object_Oriented.接口;

public class 匿名实现类 {
    public static void main(String[] args) {
        Computer computer = new Computer();
//        创建接口的非匿名实现类的非匿名对象
        Phone phone = new Phone();
        computer.DriveEquipment(phone);
//        创建接口的非匿名实现类的实现对象
        computer.DriveEquipment(new iPad());
//          创建接口的匿名实现类的非匿名对象
        Driver iphone = new Driver() {
            @Override
            public void start() {
                System.out.println("Your iPhone 开始工作....");
            }

            @Override
            public void stop() {
                System.out.println("Your iPhone  停止工作....");
            }
        };
        computer.DriveEquipment(iphone);
//        创建接口的匿名实现类的匿名对象
        computer.DriveEquipment(new Driver() {
            @Override
            public void start() {
                System.out.println("开始播放音乐🎵");
            }

            @Override
            public void stop() {
                System.out.println("停止播放音乐🎵");
            }
        });

    }
}
class Computer {
    public void DriveEquipment(Driver driver){
        driver.start();
        System.out.println("show detail#######");
        driver.stop();

    }
}
class Phone implements Driver{
    @Override
    public void start() {
        System.out.println("Phone 开始工作....");
    }

    @Override
    public void stop() {
        System.out.println("Phone 停止工作....");

    }
}
class iPad implements Driver{
    @Override
    public void start() {
        System.out.println("iPad 开始工作....");
    }

    @Override
    public void stop() {
        System.out.println("iPad 停止工作....");
    }
}
interface Driver{
    void start();

    void stop();
}

