import java.awt.print.Book;
import java.util.*;

public class Customer {
    private int cusId;
    private static int count=0;
    private String CusName;
    private String password;
    private int age;
    private char gender;
    private List<Booking> traveldetails;

    Customer(String name,String password,int age,char gender){
        this.cusId=++count;
        this.CusName=name;
        this.password=password;
        this.age=age;
        this.gender=gender;
        this.traveldetails=new ArrayList<>();
    }

    public int getCusId(){return cusId;}

    public String getCusName(){return CusName;}

    public String getPassword(){return password;}

    public List<Booking> getTravelDetails(){return traveldetails;}


}
