package com.epam.project1.model.entity;

import java.io.Serializable;

public abstract class Human implements Serializable{
    private String name;
    private int age;
    private int height;
    private int weight;
    private double money;

    public Human() {
    }

    public Human(String name, int age, int height, int weight, double money) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human)) return false;

        Human human = (Human) o;

        if (getAge() != human.getAge()) return false;
        if (getHeight() != human.getHeight()) return false;
        if (getWeight() != human.getWeight()) return false;
        if (Double.compare(human.getMoney(), getMoney()) != 0) return false;
        return getName() != null ? getName().equals(human.getName()) : human.getName() == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + getAge();
        result = 31 * result + getHeight();
        result = 31 * result + getWeight();
        temp = Double.doubleToLongBits(getMoney());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                ", money=" + money +
                '}';
    }
}
