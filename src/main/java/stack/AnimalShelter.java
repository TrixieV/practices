package stack;

import java.util.*;

public class AnimalShelter {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();

        animals.add(new Dogs("Husky", "01/05/2019"));
        animals.add(new Dogs("Alaska", "01/06/2019"));
        animals.add(new Cats("Silver", "01/07/2019"));
        animals.add(new Dogs("Short", "01/08/2019"));
        animals.add(new Cats("Orange", "01/09/2019"));
        animals.add(new Dogs("Golden", "01/10/2019"));
        animals.add(new Cats("White", "01/11/2019"));
        animals.add(new Cats("Black", "01/12/2019"));

        Queue<Animal> dogs = new LinkedList<>();
        Queue<Animal> cats = new LinkedList<>();
        for (Animal animal : animals) {
            if (animal instanceof Dogs) {
                dogs.offer(animal);
            }
            else {
                cats.offer(animal);
            }
        }

//        for (Animal dog: dogs) {
//            System.out.println(dog);
//        }
//        System.out.println(dogs.poll());
//        System.out.println(dogs.poll());


        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("Choose type of animals you want to adopt " +
                    "or press any other word to quit");
            String input = scanner.nextLine().toLowerCase();
            switch (input) {
                case "dog" -> System.out.printf("You have adopted a dog!" +
                        "%nDog information: " + dogs.poll()+ "%n") ;
                case "cat" -> System.out.printf("You have adopted a cat!" +
                        "%nCat information: " + cats.poll()+ "%n");
                default -> {
                    loop = false;
                }
            }
        }
    }
}

class Animal {
    private String name;
    private String type;
    private String date;

    public Animal(String name, String type, String date) {
        this.name = name;
        this.type = type;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}

class Dogs extends Animal {

    public Dogs(String name, String type, String date) {
        super(name, type, date);
    }

    public Dogs(String name, String date) {
        super(name, "Dog", date);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + getName() + '\'' +
                ", date='" + getDate() + '\'' +
                '}';
    }
}

class Cats extends Animal {

    public Cats(String name, String type, String date) {
        super(name, type, date);
    }

    public Cats(String name, String date) {
        super(name, "Cat", date);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + getName() + '\'' +
                ", date='" + getDate() + '\'' +
                '}';
    }
}