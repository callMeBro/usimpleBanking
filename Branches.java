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
public class Branches {
    ArrayList<Customers> customer;
    private String name;
    
    public Branches(String name){
        this.name = name;
        this.customer = new ArrayList<Customers>();   
    }
    
   //addAdditionalTransaction
    public void addAdditionalTransaction(String name, double amount){
        Customers exist = findCustomer(name);
        if(exist!=null){
           exist.addTransactions(amount);
        }
    }
    
    //find customer 
    public Customers findCustomer(String customerName){
        for(int i=0; i<customer.size(); i++){
             Customers checkedCustomer = this.customer.get(i);
            if (checkedCustomer.getName().equals(customerName)) {
                return checkedCustomer;
            }
        }
        return null;
    }
    
    //get name
    public String getName(){
        return this.name = name;
    }
    
    //get customers 
    public ArrayList<Customers> getCustomers(){
        return this.customer;
    }
    // add initial transactions  amount - data validation 
    /**
     * This method protects the data or the clients name and transactions by
     * call the constructor
     *
     * @param c
     * @param initialA
     * @return
     */
    public boolean addNewCustomer(String c, Double initialA) {
        //Call construstor from Customer Cl
        if (findCustomer(c) == null) {
            this.customer.add(new Customers(c, initialA));
            //System.out.println("Cusomer is already a member.");
            return true;
        }
        return false;
    }
}
