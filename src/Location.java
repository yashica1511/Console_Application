import java.util.*;

public class Location{
    private static HashMap<Character,Integer> map=new HashMap<>();
    public Location(){
        map.put('A',0);
        map.put('C',4);
        map.put('D',7);
        map.put('F',9);
        map.put('B',15);
        map.put('G',18);
        map.put('H',20);
        map.put('E',23);
    }

    public HashMap<Character,Integer> getMap(){
        return map;
    }
}