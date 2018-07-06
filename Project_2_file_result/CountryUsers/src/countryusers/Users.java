
package countryusers;

public class Users {

    private int user_id;
    private int count;
    private String country;

 public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    public int getUser_id() {
        return user_id;
    }

    public int getCount() {
        return count;
    }

    public String getCountry() {
        return country;
    }

    public Users(int user_id, int count, String country) {
        this.user_id = user_id;
        this.count = count;
        this.country = country;
    }

    @Override
    public String toString() {
        return country + "\t" + count + "\t" + user_id;
    }

    
}
