package com.aoki.test.enumtest;

public class JavaPizzaMainTest {
    public static void main(String[] args) {
        JavaPizza tsPizza = new JavaPizza();
        JavaPizza tsPizza2 = new JavaPizza();

        tsPizza.setStatus(JavaPizza.PizzaStatus.READY);

        System.out.println(" "+tsPizza.isDeliverable());
        System.out.println(" "+tsPizza2.isDeliverable());
    }
}
