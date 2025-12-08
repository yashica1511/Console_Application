import java.util.*;

public class Cab {
    private static int count=0;
    private int cabId;
    private String DriverName;
    private String password;
    private List<Booking> tripDetails;
    private char gender;
    private int age;
    private int earnings;
    private char pos;
    private boolean isavailable;
    private int trips=0;

    Cab(String name,String password,int age,char gender,char pos){
        this.cabId=++count;
        this.DriverName=name;
        this.password=password;
        this.gender=gender;
        this.age=age;
        this.earnings=0;
        this.isavailable=true;
        this.tripDetails=new ArrayList<>();
        this.pos=pos;
    }

    public void setPos(char pos){this.pos=pos;}
    public void setIsavailable(boolean isavailable){this.isavailable=isavailable;}
    public void setEarnings(int amount){this.earnings=earnings;}
    public void setTrips(int trips){this.trips=trips;}

    public int getCabId(){return cabId;}
    public String getDriverName(){return DriverName;}
    public String getPassword(){return password;}
    public boolean getavailable(){return isavailable;}
    public char getPos(){return pos;}
    public List<Booking> getTripDetails(){return tripDetails;}
    public int getTrips(){return trips;}
    public int getEarnings(){return earnings;}
}
