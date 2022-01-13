package Homework1;

public class Cat implements Move {
    private String name;
    private int distance;
    private int height;

    public Cat(String name, int distance, int height) {
        this.name = name;
        this.distance = distance;
        this.height = height;

    }

    @Override
    public boolean run(Treadmill treadmill) {
        if (distance >= treadmill.getDistance()) {
            System.out.println("Cat " + name + " run" + treadmill.getDistance());
            return true;
        } else {
            System.out.println("Cat " + name + " could not run "+treadmill.getDistance());
            return false;
        }

    }


    @Override
    public boolean jump(Wall wall) {
        if (height >= wall.getHeight()) {
            System.out.println("Cat " + name + " jump "+wall.getHeight());
            return true;
        } else {
            System.out.println("Cat " + name + "could not jump "+wall.getHeight());
            return false;
        }

    }

}


