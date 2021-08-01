/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplebanking;

import java.util.ArrayList;

/**
 *
 * @author adder
 */
public class Customers {
    //arraylist of customers 
    ArrayList<Double> transaction = new ArrayList<>();
    private String name;
    private Double funds;
    
    public Customers(String name, double funds ){
        this.name=name;
        this.transaction=new ArrayList<>();
        this.transaction.add(funds);
    }
    
    //getter name
    public String getName(){
        return this.name;
    }
    //add transactions 
    public void addTransactions(double amount){
        this.transaction.add(amount);
    }
    //getter for the arrayList
    public ArrayList<Double> getTransactions(){
        return transaction;
    }
}
