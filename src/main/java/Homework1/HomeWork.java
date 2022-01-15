package Homework1;


import java.util.Objects;

public class HomeWork {
    public static void main(String[] args) {

        Object[] let = {
                new Treadmill(120),
                new Treadmill(50),
                new Treadmill(150),
                new Wall(100),
                new Wall(15),
                new Wall(30)};

        Move[] moves = {
                new Human("Jask", 50, 20),
                new Human("Bob", 200, 50),
                new Cat("Vaska", 200, 20),
                new Cat("Lysi", 200, 20),
                new Robot("A1", 50, 50),
                new Robot("Z", 100, 30)};
        andJumping(moves, let);

    }

    public static void andJumping(Move[] moves, Object[] let) {
        for (int i = 0; i < moves.length; i++) {
            for (int j = 0; j < let.length; j++) {
                if ((moves[i] instanceof Human) && (let[j] instanceof Treadmill)) {
                    moves[i].run((Treadmill) let[j]);
                } else if ((moves[i] instanceof Human) && (let[j] instanceof Wall)) {
                    moves[i].jump((Wall) let[j]);
                }
                {if ((moves[i] instanceof Cat) && (let[j] instanceof Treadmill)) {
                    moves[i].run((Treadmill) let[j]);
                } else if ((moves[i] instanceof Cat) && (let[j] instanceof Wall)) {
                    moves[i].jump((Wall) let[j]);
                }
                }
                {if ((moves[i] instanceof Robot) && (let[j] instanceof Treadmill)) {
                    moves[i].run((Treadmill) let[j]);
                } else if ((moves[i] instanceof Robot) && (let[j] instanceof Wall)) {
                    moves[i].jump((Wall) let[j]);
                }
                }
            }
        }
    }
}







