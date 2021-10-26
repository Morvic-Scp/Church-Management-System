/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preachersrec;

/**
 *
 * @author Morvic
 */
public class User {
    String username;
    private final static User INSTANCE1 = new User();

    public String getUsername() {
        return username;
    }
    

    public static User getINSTANCE1() {
        return INSTANCE1;
    }


    public void setUsername(String username) {
        this.username = username;
    }
    
}
