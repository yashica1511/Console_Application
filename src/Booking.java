import java.util.*;

public class Booking {
    private static int count=0;
    private int bookId;
    private String cabId;
    private char source;
    private char destination;
    private String cusName;
    private int amount;
    private String custId;
    private double zulacommision;

    Booking(String cabId,char source,char destination,String cusName,int amount,String custId,double zulacommision){
        this.bookId=++count;
        this.cabId=cabId;
        this.source=source;
        this.destination=destination;
        this.cusName=cusName;
        this.amount=amount;
        this.custId=custId;
        this.zulacommision=zulacommision;
    }

    public String  getCabId(){return cabId;}
    public char getSource(){return source;}
    public char getDestination(){return destination;}
    public int getBookId(){return bookId;}
    public String getCustId(){return custId;}
    public int getAmount(){return amount;}
    public double getZulacommision() {return zulacommision;}
}
