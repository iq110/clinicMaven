package homeCompany.homeProdactions.Exceptions;

/**
 * if type !=1 &&  type!=2
 */
public class WrongChoicesTypeOfPetException extends Exception {
    public WrongChoicesTypeOfPetException(){
        super("Wrong Choices Type Of Pet!");
    }
}
