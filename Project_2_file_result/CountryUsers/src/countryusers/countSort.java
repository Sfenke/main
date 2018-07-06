package countryusers;

import java.util.Comparator;

public class countSort implements Comparator<Users> {
    
@Override
    public int compare(Users o1, Users o2) {
        int flag = o2.getCount()- o1.getCount();
        if(flag == 0) flag = o2.getUser_id()-o1.getUser_id();
        return flag;
    }
}
