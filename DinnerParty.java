// creating a subclass using the extends feature
public class DinnerParty extends Party {
    // creating an instance of a variable that is encapsulated
    private String dinnerChoice;

    // here we have are getter
    public String getDinnerChoice(){return dinnerChoice; }

    // here we have our setter
    public void setDinnerChoice(String dinnerChoice){
        this.dinnerChoice = dinnerChoice;
    }
}
