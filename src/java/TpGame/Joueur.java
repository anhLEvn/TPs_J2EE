/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TpGame;

/**
 *
 * @author vanan
 */
public class Joueur {
    
   private String lastname;
   private String firstname;
   private int age;
   private String loginName;
   private String password;

    public Joueur(String firstname, String lastname, int age, String loginName, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.loginName = loginName;
        this.password = password;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
   
    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public int getAge() {
        return age;
    }

    public String getLoginName() {
        return loginName;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Joueur{" + "lastname=" + lastname + ", firstname=" + firstname + ", age=" + age + ", loginName=" + loginName + ", password=" + password + '}';
    }
    
    
}

