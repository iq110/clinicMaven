package homeCompany.homeProdactions.Pets;

/**
 * Created by Серега on 24.09.2015.
 */
public class Dog implements Pet {

    //Dog's name
    String name;

    public Dog(String s) {
        this.name = s;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }


    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }
}
