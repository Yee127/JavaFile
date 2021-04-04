package com.Arr_List_Map.beanLife;

public class Orders {
    public Orders() {
        System.out.println("① 执行无参构造创建bean实例");
    }

    private String oName;

    public void setoName(String oName) {
        this.oName = oName;
        System.out.println("② 调用set方法设置属性值");
    }
//    创建初始化方法
    public void  initMethod(){
        System.out.println("③ 执行初始化方法");
    }
//    创建执行的销毁方法
    public void destoryMehtod(){
        System.out.println("⑤ 执行销毁的方法");
    }
}
