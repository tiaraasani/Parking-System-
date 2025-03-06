package implementasi;

import java.util.Date;


public class NodeExit {

    public int ticketNumber;
    public String plat;
    public String type;
    public NodeExit leftChild;
    public NodeExit rightChild;
    public String entryTime;
    public String exitTime;
    public long duration;
    public long tarif;
    public Date date;

    // Konstruktor
    public NodeExit(int ticketNumber, String plat, String type, String entryTime, String exitTime, long duration, long tarif) {
        this.ticketNumber = ticketNumber;
        this.plat = plat;
        this.type = type;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
        this.duration = duration;
        this.tarif = tarif;
        this.leftChild = null;
        this.rightChild = null;
    }
}