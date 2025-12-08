import java.util.*;

public class User {
    private String Id;
    private String Name;
    private String password;
    private char gender;
    private int age;

    private static int cabcount=1;
    private int earnings;
    private char pos;
    private boolean isavailable;
    private int trips=0;
    private List<Booking> tripDetails;

    private static int cuscount=1;
    private List<Booking> traveldetails;

    private static int addcount=1;

    User(String Name,String password){
        this.Id="A"+ addcount;
        this.Name=Name;
        this.password=password;
    }

    User(String name,String password,int age,char gender){
        this.Id="C"+cuscount++;
        this.Name=name;
        this.password=password;
        this.age=age;
        this.gender=gender;
        this.traveldetails=new ArrayList<>();
    }

    User(String name,String password,int age,char gender,char pos){
        this.Id="D"+ cabcount++;
        this.Name=name;
        this.password=password;
        this.gender=gender;
        this.age=age;
        this.earnings=0;
        this.isavailable=true;
        this.tripDetails=new ArrayList<>();
        this.pos=pos;
    }

    public String getId(){return Id;}

    public String getName(){return Name;}

    public String getPassword(){return password;}

    public List<Booking> getTravelDetails(){return traveldetails;}


    public void setPos(char pos){this.pos=pos;}
    public void setIsavailable(boolean isavailable){this.isavailable=isavailable;}
    public void setEarnings(int amount){this.earnings=amount;}
    public void setTrips(int trips){this.trips=trips;}


    public boolean getavailable(){return isavailable;}
    public char getPos(){return pos;}
    public List<Booking> getTripDetails(){return tripDetails;}
    public int getTrips(){return trips;}
    public int getEarnings(){return earnings;}
}
