package com.transaction.bean;

public class Tran {
    private String id;
    private String name;
    private String balance;

    @Override
    public String toString() {
        return "Tran{\n" +
                "id='" + id + '\'' +
                ", \nname='" + name + '\'' +
                ", \nbalance='" + balance + '\'' +
                '}';
    }

    public Tran(String id, String name, String balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }
}
