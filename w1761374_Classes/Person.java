public class Person {

    //creating private veriables
    private String firstName;
    private String lastName;
    private String cardNumber;

    public Person(String firstName,String lastName,String cardNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cardNumber = cardNumber;
    }

    //create a getter and setters for First name
    public String getFirstName() {
        return firstName;
    }

    public Person setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    //create a getter and setters for Last name
    public String getLastName() {
        return lastName;
    }

    public Person setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    //create a getter and setters for card number
    public String getCardNumber() {
        return cardNumber;
    }

    public Person setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }
}