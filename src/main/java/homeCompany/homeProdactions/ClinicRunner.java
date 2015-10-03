package homeCompany.homeProdactions;

import homeCompany.homeProdactions.Exceptions.*;
import homeCompany.homeProdactions.Pets.Pet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class to management clinic
 */
public class ClinicRunner {

    //object of class to work with class's methods
    protected static ClinicRunner runner = new ClinicRunner();

    protected Clinic clinic = new Clinic();//clinic object for work
    protected Client client; //selected client
    protected Pet pet; //selected pet
    protected int lastLaunchedSelectedFunctionCrutch = 0;// Crutch for exceptions

    public static void main(String[] args) throws Exception {
        runner.startWorking();
    }

    public void startWorking() throws Exception {
        try {
            switch (runner.lastLaunchedSelectedFunctionCrutch) {
                case (0):
                    runner.doClinicAction(runner.selectClinicActions());
                    break;

                case (1):
                    runner.doClientAction(runner.selectClientActions());
                    break;

                case (2):
                    runner.doPetAction(runner.selectPetActions());
                    break;
            }
        }catch (NumberFormatException e){
            System.out.println("Wrong type!!!");
            runner.startWorking();

        }catch (Exception e){
            System.out.println(e.getMessage());
            runner.startWorking();
        }
    }

    /**
     * Method giving delay while user reads information
     *
     * @throws IOException - input exceptions
     */
    private void waitWhileKeyNotPressed() throws IOException {
        System.out.println("Press Enter To Continue");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();
    }

    private String readString() throws IOException {
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        return reader.readLine();
    }


    /**
     * Writes all possible type of Client Actions
     *
     * @return The values ​​of the chosen user actions
     * @throws IOException - input exceptions
     */
    public int selectClinicActions() throws IOException {
        lastLaunchedSelectedFunctionCrutch = 0;
        System.out.println("Enter type of actions :");
        System.out.println("1. Print All Clients And Them Pets");
        System.out.println("2. Print Clients By Pet Name");
        System.out.println("3. Select Client By It's Name");
        System.out.println("4. Add Client");
        System.out.println("0. Shutdown");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int choice = Integer.parseInt(reader.readLine());
        return choice;
    }
    /**
     * Do  Main selected actions
     *
     * @param choice - values action
     * @throws IOException - input exceptions
     */
    public void doClinicAction(int choice) throws Exception {
        switch (choice) {
            case (1):
                //Print All Clients And Them Pets
                clinic.printClientsAndThemPets();
                waitWhileKeyNotPressed();
                doClinicAction(selectClinicActions());
                break;

            case (2):
                //Print Clients By Pet Name
                System.out.println("Enter Pet's Name : ");
                clinic.printClientsByPetName(readString());
                waitWhileKeyNotPressed();
                doClinicAction(selectClinicActions());
                break;

            case (3):
                //Select Client By It's Name
                System.out.println("Enter Client's Name");
                client = clinic.getClientByName(readString());
                if (!client.equals(null)) {
                    doClientAction(selectClientActions());
                    client = null;
                }
                doClinicAction(selectClinicActions());
                break;

            case (4):
                //Add Client
                System.out.println("Enter Name Of New Client");
                client = clinic.addClient(readString());
                if (!client.equals(null)) {
                    doClientAction(selectClientActions());
                    client = null;
                }
                doClinicAction(selectClinicActions());
                break;


            case (0):
                //Shutdown
                System.exit(0);
            default:
                throw new WrongInputException();
        }
    }


    /**
     * Writes all possible type of Main Actions
     *
     * @return The values ​​of the chosen user actions
     * @throws IOException - input exceptions
     */
    public int selectClientActions() throws Exception {
        lastLaunchedSelectedFunctionCrutch = 1;
        System.out.println("Client " + client.getName() + " Selected!");
        System.out.println("Enter type of actions :");
        System.out.println("1. Print All Client's Pets");
        System.out.println("2. Add Pet To Client");
        System.out.println("3. Change Client's Name");
        System.out.println("4. Select Pet By It's Name");
        System.out.println("5. Remove Selected Client");
        System.out.println("0. Back");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int choise = Integer.parseInt(reader.readLine());
        return choise;
    }
    /**
     * Do selected actions with selected Client
     *
     * @param choice - values action
     * @throws IOException - input exceptions
     */
    public void doClientAction(int choice) throws Exception {
        switch (choice) {
            case (1):
                //Print All Client's Pets
                client.printPets();
                waitWhileKeyNotPressed();
                doClientAction(selectClientActions());
                break;

            case (2):
                //Add Pet To Client
                System.out.println("Enter Type Of Pet (1 - Cat / 2 - Dog) :");
                int typeOfPet = Integer.parseInt(readString());
                if((typeOfPet!=1)&&(typeOfPet!=2))
                    throw new WrongInputException();
                System.out.println("Enter Pet's Name :");
                pet = client.addPetToClient(typeOfPet, readString());
                doClientAction(selectClientActions());
                break;

            case (3):
                //Change Client's Name
                System.out.println("Enter Client's New Name");
                clinic.changeClientName(client, readString());
                doClientAction(selectClientActions());
                break;

            case (4):
                //Select Pet By It's Name
                System.out.println("Enter Pet's Name :");
                pet = client.getPetByName(readString());
                if (pet != null) {
                    doPetAction(selectPetActions());
                    pet = null;
                }
                doClientAction(selectClientActions());
                break;

            case (5):
                //Remove Selected Client
                clinic.removeClient(client.getName());
                doClinicAction(selectClinicActions());
                break;

            case (0):
                //Back
                doClinicAction(selectClinicActions());
                break;

            default:
                throw new WrongInputException();
        }
    }


    /**
     * Writes all possible type of Pet Actions
     *
     * @return The values ​​of the chosen user actions
     * @throws IOException - input exceptions
     */
    public int selectPetActions() throws IOException {
        lastLaunchedSelectedFunctionCrutch = 2;
        System.out.println(client.getName() + "'s " + " Pet " + pet.getName() + " Selected!");
        System.out.println("Enter type of actions :");
        System.out.println("1. Change Pet's Name");
        System.out.println("2. Remove Selected Pet");
        System.out.println("0. Back");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int choise = Integer.parseInt(reader.readLine());
        return choise;
    }
    /**
     * Do selected actions with selected Pet
     *
     * @param choice - values action
     * @throws IOException - input exceptions
     */
    public void doPetAction(int choice) throws Exception {
        switch (choice) {
            case (1):
                //Change Pet's Name
                System.out.println("Enter Pet's New Name");
                clinic.changePetName(pet, readString());
                doPetAction(selectPetActions());
                break;

            case (2):
                //Remove Selected Pet
                client.removePet(pet.getName());
                break;

            case (0):
                //Back
                doClientAction(selectClientActions());
                break;

            default:
                throw new WrongInputException();
        }
    }
}
