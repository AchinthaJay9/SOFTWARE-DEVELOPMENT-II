public class HotelWaiting {
    int SIZE = 5;
    int front, rear;
    String items[][] = new String[5][SIZE];

    HotelWaiting() {
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
    void enQueue(String name,String guest,String fisrt,String last,String card) {
        if (isFull()) {
            System.out.println("Queue is full");
        } else {
            if (front == -1)
                front = 0;
            rear = (rear + 1) % SIZE;
            items[0][rear] = name;
            items[1][rear] = guest;
            items[2][rear] = fisrt;
            items[3][rear] = last;
            items[4][rear] = card;
            System.out.println("Inserted " + name);
        }
    }

    //removing queue
    String[][] deQueue() {
        String[][] element = new String[5][1];
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        } else {
            element[0][0] = items[0][front];
            element[1][0] = items[1][front];
            element[2][0] = items[2][front];
            element[3][0] = items[3][front];
            element[4][0] = items[4][front];
            if (front == rear) {
                front = -1;
                rear = -1;
            } else {
                front = (front + 1) % SIZE;
            }
            return (element);
        }
    }

}