import java.util.*;

public class Main {

    public static Scanner sc=new Scanner(System.in);
    public static HashMap<String,User> user=new HashMap<>();
    public static List<Booking> bookings=new ArrayList<>();
    public static Location loc=new Location();

    public static void main(String[] args) {
        System.out.println("Cab Booking System");

        User a1 = new User("kk","55");
        user.put(a1.getId(), a1);

        User d1 = new User("aaa", "111", 43, 'M', 'D');
        User d2 = new User("bbb", "222", 31, 'M', 'G');
        User d3 = new User("ccc", "333", 38, 'F', 'H');
        User d4 = new User("ddd", "444", 28, 'F', 'A');

        user.put(d1.getId(), d1);
        user.put(d2.getId(), d2);
        user.put(d3.getId(), d3);
        user.put(d4.getId(), d4);

        User c1 = new User("zz", "99", 25, 'F');
        User c2 = new User("yy", "88", 61, 'M');
        User c3 = new User("xx", "77", 22, 'M');
        User c4 = new User("ww", "66", 36, 'F');
        user.put(c1.getId(), c1);
        user.put(c2.getId(), c2);
        user.put(c3.getId(), c3);
        user.put(c4.getId(), c4);

        while (true) {
            System.out.println("\n\n1)Login \n2)Register Customer \n3)Exit Application");
            System.out.println("Enter the options :");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    Login();
                    break;
                case 2:
                    createCustomer();
                    break;
                case 3:
                    System.exit(0);
            }
        }
    }


    private static void Login(){
        System.out.println("Login: ");
        System.out.println("Enter Id ");
        String userid=sc.next().toUpperCase();
        System.out.println("Enter password ");
        String password=sc.next();
        boolean ispassword=false;
        char symbol=userid.charAt(0);
        for(String id:user.keySet()){
            if(id.charAt(0)==symbol && id.equals(userid)){
                User curuser = user.get(id);
                if (password.equals(curuser.getPassword())) {
                    ispassword=true;
                    switch (symbol){
                        case 'A':
                            AdminOperation();
                            break;
                        case 'C':
                            CustomerOperation(curuser);
                            break;
                        case 'D':
                            DriverOperation(curuser);
                            break;
                    }
                    break;
                } else {
                    System.out.println("Password Doesn't match");
                }

            }
        }
    }

    private static void AdminOperation(){
        outer:
            while(true){
                System.out.println("Admin Login: ");
                System.out.println("1.Add Cab \n2.Exit");
                System.out.println("Enter the Options: ");
                int option=sc.nextInt();
                switch(option){
                    case 1:
                        System.out.println("Enter Driver Name: ");
                        String name=sc.next();
                        System.out.println("Enter Password: ");
                        String password=sc.next();
                        System.out.println("Enter the Age: ");
                        int age=sc.nextInt();
                        System.out.println("Enter the Gender: ");
                        char gender=sc.next().toUpperCase().charAt(0);
                        System.out.println("Enter Position: ");
                        char pos=sc.next().toUpperCase().charAt(0);
                        User newcab = new User(name,password,age,gender,pos);
                        user.put(newcab.getId(),newcab);
                        break;
                    case 2:
                        break outer;
                }
            }
    }

    private static void DriverOperation(User cab){
        outer:
            while(true){
                System.out.println("Driver Login:");
                System.out.println("1)View History of Rides\n2)exit");
                System.out.println("Enter the Options: ");
                int option=sc.nextInt();
                switch(option){
                    case 1:
                        List<Booking> rides=cab.getTripDetails();
                        System.out.println("CabId "+ cab.getId());
                        System.out.println("Driver Name: "+cab.getName());
                        System.out.println("source \t destination \t customerDetail \t amount \t zulaCommision");
                        for(Booking ride:rides){
                            System.out.println(ride.getSource()+"\t"+ride.getDestination()+"\t"+ride.getCustId()+"\t"+ride.getAmount()+"\t"+ride.getZulacommision());
                        }
                        break;
                    case 2:
                        break outer;
                }
            }
    }


    private static void CustomerOperation(User cus){
        outer:
            while(true){
                System.out.println("Customer Login:");
                System.out.println("1)Book a Cab\n2)Details of the Customers ride\n3)Exit");
                System.out.println("Enter the Options: ");
                int option = sc.nextInt();
                switch(option){
                    case 1:
                        bookcab(cus);
                        break;
                    case 2:
                        List<Booking> rides=cus.getTravelDetails();
                        System.out.println("Name: "+cus.getName());
                        System.out.println("Id: "+cus.getId());
                        System.out.println("source \t destination \t cabDetail \t amount");
                        for(Booking ride:rides){
                            System.out.println(ride.getSource()+"\t"+ride.getDestination()+"\t"+ride.getCabId()+"\t"+ride.getAmount());
                        }
                        break;
                    case 3:
                        break outer;

                }
            }
    }

    private static void bookcab(User cus){
        System.out.println("Enter the Source: ");
        char source=sc.next().toUpperCase().charAt(0);
        System.out.println("Enter the Destination");
        char destination=sc.next().toUpperCase().charAt(0);

        List<User> available=new ArrayList<>();
        HashMap<Character,Integer> locmap=loc.getMap();

        for(String name: user.keySet()){
            if(name.charAt(0)=='D' && user.get(name).getavailable()){
                available.add(user.get(name));
            }
        }

        System.out.println("Available Cabs are");
        System.out.println("Position \t CabId");
        for(User cab:available){
            System.out.println(cab.getPos()+"\t\t\t"+cab.getId());
        }

        List<User> filtered=new ArrayList<>();
        int max=Math.abs(locmap.get(available.get(0).getPos()) - locmap.get(source));

        for(User c:available){
            int dist = Math.abs(locmap.get(c.getPos()) - locmap.get(source));
            if(dist<=max){
                filtered.add(c);
            }
        }

        User selected=filtered.get(0);

        for(User c:filtered){
            if(c.getTrips()<selected.getTrips()){
                selected=c;
            }
        }

        int amount= Math.abs(locmap.get(destination)-locmap.get(source));
        double zula= (30/100)*amount;

        int trip= selected.getTrips();
        selected.setTrips(trip+1);

        int price=selected.getEarnings();
        selected.setEarnings(price+amount);

        selected.setIsavailable(false);

        Booking book=new Booking(selected.getId(), source,destination, cus.getName(), amount, cus.getId(), zula);

        List<Booking> cabadd=selected.getTripDetails();
        cabadd.add(book);

        List<Booking> cusadd=cus.getTravelDetails();
        cusadd.add(book);

        for(String cab:user.keySet()){
            if(cab.equals(selected.getId())){
                continue;
            }else {
                User cabb=user.get(cab);
                cabb.setIsavailable(true);
            }
        }

        selected.setPos(destination);

        System.out.println("Cab "+selected.getId()+" Assigned Successfully");

    }

    private static void createCustomer(){
        System.out.println("Enter the name: ");
        String name=sc.next();
        System.out.println("Enter the password: ");
        String password=sc.next();
        System.out.println("Enter the Age: ");
        int age=sc.nextInt();
        System.out.println("Enter the Gender: ");
        char gender=sc.next().toUpperCase().charAt(0);
        boolean isname=false;
        for(String cus: user.keySet()){
            if(cus.equals(name)){
                isname=true;
                System.out.println("Username already exists");
                break;
            }
        }
        if(!isname){
            User cus=new User(name,password,age,gender);
            user.put(cus.getId(), cus);
        }

    }
}