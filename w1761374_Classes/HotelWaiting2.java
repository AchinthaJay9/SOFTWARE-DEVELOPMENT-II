public class HotelWaiting2 {
    int SIZE = 5;
    int front, rear;
    Room items[] = new Room[SIZE];

    HotelWaiting2() {
        front = -1;
        rear = -1;
    }


    //check Queue is full
    boolean isFull() {
        if (front == 0 && rear == SIZE - 1) {
            return true;
        }
        if (front == rear + 1) {
            return true;
        }
        return false;
    }


    //check Queue is empty
    boolean isEmpty() {
        if (front == -1)
            return true;
        else
            return false;
    }


    //enter value for add circular queve
    void enQueue(Room room) {
        if (isFull()) {
            System.out.println("Queue is full");
        } else {
            if (front == -1)
                front = 0;
            rear = (rear + 1) % SIZE;
            items[rear] = room;
            System.out.println("Inserted " + room.getRoomName());
        }
    }


    //removing queue
    Room deQueue() {

        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        } else {

            Room item = items[front];

            if (front == rear) {
                front = -1;
                rear = -1;
            } else {
                front = (front + 1) % SIZE;
            }
            return item;
        }
    }

}