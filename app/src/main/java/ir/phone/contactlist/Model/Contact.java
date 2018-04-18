package ir.phone.contactlist.Model;

/**
 * Created by Shahrzad on 17/04/2018.
 */

public class Contact {

    private String DisplayName;
    private String DisplayPhoneNumber;

    public Contact(String displayName, String displayPhoneNumber) {
        DisplayName = displayName;
        DisplayPhoneNumber = displayPhoneNumber;
    }

    public String getDisplayName() {
        return DisplayName;
    }

    public void setDisplayName(String displayName) {
        DisplayName = displayName;
    }

    public String getDisplayPhoneNumber() {
        return DisplayPhoneNumber;
    }

    public void setDisplayPhoneNumber(String displayPhoneNumber) {
        DisplayPhoneNumber = displayPhoneNumber;
    }

}
