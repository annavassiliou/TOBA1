/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.account;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import user.javabean.User;

public class Account implements Serializable {
    
    public enum Type {
        Checking,
        Savings
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountID;
    private Type type;
    private float balance;
    @ManyToOne
    private User user;
    
    public Account () {
        this.type = Type.Checking;
        this.balance = 0.0f;
        this.user = user;
    }
    
    public Account (Type type, float balance, User user) {
        this.type = type;
        this.balance = balance;
        this.user = user;
    }
    
    public Long getAccountID() {
        return this.accountID;
    }
    
    public void setAccountID (Long accountID) {
        this.accountID = accountID;
    }
    
    public Type getType() {
        return this.type;
    }
    
    public void setType (Type getType) {
        this.type = type;
    }
    
    public float getBalance() {
        return this.balance;
    }
    
    public void credit (float amount) {
        this.balance += amount;
    }
    
    public void debit (float amount) {
        this.balance -= amount;
    }
    
    public User getUser() {
        return this.user;
    }
    
    public void setUser (User user) {
        this.user = user;
    }
    
    
}
