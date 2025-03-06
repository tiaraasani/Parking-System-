package implementasi;

import java.util.Date;

public class Node {

    public int ticketNumber;
    public String plat;
    public String type;
    public Node leftChild;
    public Node rightChild;
    public java.sql.Timestamp entryTime;
    public Date date;

    // Konstruktor
    public Node(int ticketNumber, String plat, String type, java.sql.Timestamp entryTime, Date date) {
        this.ticketNumber = ticketNumber;
        this.plat = plat;
        this.type = type;
        this.entryTime = entryTime;
        this.leftChild = null;
        this.rightChild = null;
        this.date = date;
    }

    // Getter untuk plat
    public String getPlat() {
        return plat;
    }

    // Getter untuk type
    public String getType() {
        return type;
    }
}
