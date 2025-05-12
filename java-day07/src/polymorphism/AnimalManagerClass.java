package polymorphism;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AnimalManagerClass {
    public static void main(String[] args) {
        DogClass dog1 = new DogClass();
        dog1.name = "다복이";
        dog1.age = 1;

        CatClass cat1 = new CatClass();
        cat1.name = "애옹이";
        cat1.age = 2;

        ParrotClass par1 = new ParrotClass();
        par1.name = "패패";
        par1.age = 3;

        ArrayList<DogClass> dogs = new ArrayList<>();
        dogs.add(dog1);
        ArrayList<CatClass> cats = new ArrayList<>();
        cats.add(cat1);
        ArrayList<ParrotClass> parrots = new ArrayList<>();
        parrots.add(par1);

        AnimalClass ani1 = dog1;
        ani1.sound();
        ani1 = cat1;
        ani1.sound();
        ani1 = par1;
        ani1.sound();

        ArrayList<AnimalClass> animals = new ArrayList<>();
        animals.add(dog1);
        animals.add(cat1);
        animals.add(par1);
    }
}
