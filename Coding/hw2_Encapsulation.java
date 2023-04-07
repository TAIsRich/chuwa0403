public class hw2_Encapsulation {
    private String firstName;
    private String lastName;
    private int ID;
    public String getFName() {
        return firstName;
    }
    public String getLname() {
        return lastName;
    }
    public int getID() {
        return ID;
    }
    public void setFName(String newFName) {
        firstName = newFName;
    }
    public void setLName( String newLName) {
        lastName = newLName;
    }
    public void setID( int newID) {
        ID = newID;
    }
}