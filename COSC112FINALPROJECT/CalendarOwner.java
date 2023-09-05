public class CalendarOwner {
    private String firstname;
    private String lastname;
    private int userID;
    static int owners = 0;

    public CalendarOwner(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
        owners++;

        //this assigns an incrementing userID for each user -- consider making this random at a later stage
        this.userID = owners;

    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getUserID() {
        return userID;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
