//
import java.util.HashMap;
//
////To add elements to HashMap, use the put() method
//
///**
// * we may also need to change
// */

public class IDsandPasswords {
   HashMap<Object, Object> loginInfo = new HashMap<Object, Object>();

   //constructor.
   public IDsandPasswords(){
       loginInfo.put("DashaAsienga", "pizza");
       loginInfo.put("Priya", "statistics");
   }
   //getmethods for the hashmaps.
    protected HashMap getLoginInfo(){
       return loginInfo;
    }
    void addnewInformations( Object theusername, Object thepassword ){
        loginInfo.put(theusername, thepassword);
    }
    void deletetheinformation (Object anotherusername, Object anotherpassword){
       loginInfo.remove(anotherusername, anotherpassword);
    }
}

// around minutes 18.