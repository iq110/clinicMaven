package homeCompany.homeProdactions;

import homeCompany.homeProdactions.Pets.Cat;
import homeCompany.homeProdactions.Pets.Dog;
import homeCompany.homeProdactions.Pets.Pet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Серега on 21.09.2015.
 */
public class Client {

    private String name;// client's name
    private ArrayList<Pet> pets = new ArrayList<Pet>(); // client's pets


    public Client(String clientName) {
        this.name = clientName;
    }//Constructor


    public String getName() {
        return this.name;
    }
    public void setName(String n) {
        this.name = n;
    }


    /**
     * Has client some pet or no
     *
     * @param petName
     * @return true-yes, false-didn't
     */
    public boolean hasPet(String petName) {
        for (Pet p : pets) {
            if (p.getName().equals(petName))
                return true;
        }
        return false;
    }

    /**
     * @param petName
     * @return pet's name if OK, "null" if clients has no pet with this name
     */
    public Pet getPetByName(String petName) {
        if (pets.size() == 0) {
            System.out.println("Client Has No Pets!");
            return null;
        }
        for (Pet p : this.pets) {
            if (p.getName().equals(petName))
                return p;
        }
        System.out.println("Client Has No Pet With This Name!");
        return null;
    }
    /**
     * print client's pets on console
     */
    public void printPets() {
        if(pets.size()==0)
            System.out.println("Client Has No Pets!");
        else
            for (Pet p : pets) {
            System.out.println(p.getName());
        }
    }


    public Pet addPetToClient(int typeOfPet, String petName) {
        Pet newPet = null;
            if (typeOfPet == 1) {
                newPet = new Cat(petName);
                this.pets.add(newPet);
            }
            else
            if (typeOfPet == 2) {
                newPet = new Dog(petName);
                this.pets.add(newPet);
            }
            else
                System.out.println("Wrong Choices Type Of Pet!");

        return newPet;
    }


    /**
     * remove one clients pet
     *
     * @param petName
     * @return
     */
    public boolean removePet(String petName) {
        for (Pet p : pets) {
            if (p.getName().equals(petName)) {
                pets.remove(p);
                System.out.println(petName + " Was Removed!");
                return true;
            }
        }
        System.out.println("Client Has No Pet With This Name!");
        return false;
    }

    public void removeAllPets(){
        pets.clear();
    }




}
