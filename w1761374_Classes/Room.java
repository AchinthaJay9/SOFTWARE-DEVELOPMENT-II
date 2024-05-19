public class Room {

    //creating private veriables
    private String roomName;
    private String guest;
    private Person person;

    public Room(String roomName,String  guest,Person person) {

        this.roomName = roomName;
        this.guest = guest;
        this.person = person;
    }
    //create a getter and setters for room name
    public String getRoomName() {
        return roomName;
    }

    public Room setRoomName(String roomName) {
        this.roomName = roomName;
        return this;
    }
    //create a getter and setters for Guest
    public String getGuest() {
        return guest;
    }

    public Room setGuest(String guest) {
        this.guest = guest;
        return this;
    }

    //create a getter and setters for person
    public Person getPerson() {
        return person;
    }

    public Room setPerson(Person person) {
        this.person = person;
        return this;
    }
}