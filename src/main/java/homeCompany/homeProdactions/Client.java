package homeCompany.homeProdactions;

import homeCompany.homeProdactions.Exceptions.ClientHasNoPetsException;
import homeCompany.homeProdactions.Exceptions.NoPetsWithThisNameException;
import homeCompany.homeProdactions.Exceptions.WrongChoicesTypeOfPetException;
import homeCompany.homeProdactions.Pets.Cat;
import homeCompany.homeProdactions.Pets.Dog;
import homeCompany.homeProdactions.Pets.Pet;

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
    public Pet getPetByName(String petName) throws ClientHasNoPetsException, NoPetsWithThisNameException {
        if (pets.size() == 0) {
            throw new ClientHasNoPetsException();
        }
        for (Pet p : this.pets) {
            if (p.getName().equals(petName))
                return p;
        }
        throw new NoPetsWithThisNameException();
    }
    /**
     * print client's pets on console
     */
    public void printPets() throws ClientHasNoPetsException {
        if(pets.size()==0)
            throw new ClientHasNoPetsException();
        else
            for (Pet p : pets) {
            System.out.println(p.getName());
        }
    }


    public Pet addPetToClient(int typeOfPet, String petName) throws WrongChoicesTypeOfPetException {
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
               throw new WrongChoicesTypeOfPetException();
        return newPet;
    }


    /**
     * remove one clients pet
     *
     * @param petName
     * @return
     */
    public boolean removePet(String petName) throws NoPetsWithThisNameException {
        for (Pet p : pets) {
            if (p.getName().equals(petName)) {
                pets.remove(p);
                System.out.println(petName + " Was Removed!");
                return true;
            }
        }
        throw new NoPetsWithThisNameException();
    }

    public void removeAllPets(){
        pets.clear();
    }




}
