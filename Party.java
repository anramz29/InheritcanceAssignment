// First step in the Instructions, Creating the Party Class Java
public class Party{

    private int numGuests; // initializing the number of guests

    // Setter as specified in the instructions
    void setNumGuests(int numGuests) {
        this.numGuests = numGuests; // using the .this method to specify instance
    }
    public int getNumGuests() {
        return numGuests;
    }
    public void Invitation(){
        System.out.println("Please come to my party!");
    }
}
