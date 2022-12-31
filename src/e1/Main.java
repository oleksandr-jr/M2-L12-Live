package e1;

import common.Console;

public class Main {
    public static void main(String[] args) {
        Count count0 = new Count(Console.color.BLUE);
        Count count1 = new Count(Console.color.GREEN);

        count0.start();
        count1.start();
    }
}


class Count extends Thread{

    String color;


    public Count(String color) {
        this.color = color;
    }

    @Override
    public void run() {
        for (int i = 0; i < 500; i++) {
            Console.println(this.getName() + " " + i,  color);
        }
    }
}