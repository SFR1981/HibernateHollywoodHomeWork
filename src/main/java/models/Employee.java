package models;


import db.DBHelper;

import javax.persistence.*;

@Entity
@Table(name = "employees")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "employee_type")
public abstract class Employee {

    private int id;
    private String name;
    private int bank;
    private int payRate;

    public Employee() {

    }

    public Employee(String name, int payRate) {
        this.name = name;
        this.bank = 0;
        this.payRate = payRate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "bank")
    public int getBank() {
        return bank;
    }


    public void setBank(int bank) {
        this.bank = bank;
    }

    @Column(name = "pay_rate")
    public int getPayRate() {
        return payRate;
    }

    public void setPayRate(int payRate) {
        this.payRate = payRate;
    }

    public void isPaid() {
        int pay = this.payRate;
        this.bank += pay;
      //  DBHelper.update(this);
        // studio budget down - save both to db
        // test later on during extension
    }

    public void payRateIncrease(int increase) {
        this.payRate += increase;
    }

}
