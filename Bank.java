/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplebanking;

import java.util.ArrayList;

public class Bank {

    private String Bname;
    private ArrayList<Branches> branches;
    //= new ArrayList<>(); 

    public Bank(String name) {
        this.Bname = name;
        this.branches = new ArrayList<Branches>();
    }
    // ADD BRANCH

    public boolean addBranch(String branchName) {
        if (findBranch(branchName) == null) {
            this.branches.add(new Branches(branchName));
        }
        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double ia) {
        Branches branch = findBranch(branchName);
        if (branch != null) {
            return branch.addNewCustomer(customerName, ia);
        }
        return false;
    }

    /*
    private Customer findCustomer(String customerName) {
        for (int i = 0; i < this.customer.size(); i++) {
            Customer checkedCustomer = this.customer.get(i);
            if (checkedCustomer.getName().equals(customerName)) {
                return checkedCustomer;
            }
        }
        return null;
    }
     */
    private Branches findBranch(String branchName) {
        for (int i = 0; i < this.branches.size(); i++) {
            Branches checkedBranch = this.branches.get(i); // save branch name in variable  

            if (checkedBranch.getName().equals(branchName)) {
                return checkedBranch;
            }
        }

        return null;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double amount) {
        Branches b = findBranch(branchName);        //find branches name return boolean 
        if (b != null) {          //verifies that branch is not empty 
            b.addAdditionalTransaction(customerName, amount);
           // System.out.println("Additional transaction was added.");
            return true;
        }
        return false;
    }

    /**
     * List all the customers for a given branch and optionally their
     * transactions Returns boolean in case branch was not found
     *
     * @param branchName
     * @param showTransactions
     * @return
     */
    public boolean listCustomers(String branchName, boolean showTransactions) {
        Branches branch = findBranch(branchName);   // finds branch
        if (branch != null) {
            System.out.println("Customer details for branch " + branch.getName());    // gets branch name
            //list of customer for branch -> variable for branch customers 
            ArrayList<Customers> branchCustomer = branch.getCustomers();   // gets customers for paticulr branch 
            for (int i = 0; i < branchCustomer.size(); i++) {    //loops through list of branch customers 
                Customers branchCustomers = branchCustomer.get(i);           //returns specific customer for branch        
                System.out.println("Customer: " + branchCustomers.getName() + "[" + (i + 1) + "]");       // prints out list of customers 
                //if show transactions set to true show them 
                if (showTransactions) {
                    System.out.println("Transactions");
                    ArrayList<Double> transactions = branchCustomers.getTransactions();
                    for (int j = 0; j < transactions.size(); j++) {
                        System.out.println("[" + (j + 1) + "]" + "Amount" + transactions.get(i));
                        //  return true;
                    }
                }

            }
            return true;
        } else {
            return false;    
        }

    }
}
