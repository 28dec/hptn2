/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author longnh
 */
public class Reservation {
    private int id;
    private int tbl_employee_id;
    private int tbl_mealtable_id;
    private int tbl_customer_id;
    private int is_deleted;
    private long created;
    private long last_updated;
    private DB db;
    private Customer customer;
    public Reservation(int id, int tbl_employee_id, int tbl_mealtable_id, int tbl_customer_id, int is_deleted, long created, long last_updated) {
        this.id = id;
        this.tbl_employee_id = tbl_employee_id;
        this.tbl_mealtable_id = tbl_mealtable_id;
        this.tbl_customer_id = tbl_customer_id;
        this.is_deleted = is_deleted;
        this.created = created;
        this.last_updated = last_updated;
        this.db = new DB();
        System.out.println("hello");
        this.customer = this.get_customer_by_id(tbl_customer_id);
    }
    
    public Reservation() {
        this.db = new DB();
    }
    
    public int get_id(){
        return this.id;
    }
    

    public int get_employee_id() {
        return tbl_employee_id;
    }

    public int get_mealtable_id() {
        return tbl_mealtable_id;
    }

    public int get_customer_id() {
        return tbl_customer_id;
    }
    
    public String get_customer_info(){
        return String.format("[%s] %s", this.customer.get_code(), this.customer.get_full_name());
    }
    
    public void set_id(int id){
        this.id = id;
    }
    
    
    public List<Reservation> get_all(){
        System.out.println(this.getClass() + "get_all() performed!");
        List<Reservation> rtn = new ArrayList();
        try {
            ResultSet rs = get_all_record();
            while(rs.next()){
                Reservation tmp = new Reservation(rs.getInt("id"), rs.getInt("tbl_employee_id"), rs.getInt("tbl_customer_id"), rs.getInt("tbl_mealtable_id"), rs.getInt("is_deleted"), rs.getLong("created"), rs.getLong("last_updated"));
                rtn.add(tmp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Reservation.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.printf("get_all() return %d reservations%n", rtn.size());
        return rtn;
        
    }
    
    public ResultSet get_all_record(){
        System.out.println(this.getClass() + "get_all_record() performed!");
        ResultSet rs = null;
        String query = String.format("select `%s`, `%s`, `%s`, `%s`, `%s`, `%s`, `%s` from tbl_reservation;", "id", "tbl_employee_id", "tbl_customer_id", "tbl_mealtable_id", "is_deleted", "created", "last_updated");
        rs = this.db.execute_query(query);
        return rs;
    }
    
    public Customer get_customer_by_id(int customer_id){
        System.out.println(this.getClass() + " get_customer_by_id() performed!");
        Customer c = null;
        ResultSet rs = get_customer_record_by_id(customer_id);
        try {
            if(rs.next()){
                c = new Customer(rs.getInt("c.id"), rs.getInt("c.tbl_person_id"), rs.getString("c.code"), rs.getInt("c.is_deleted"), rs.getLong("c.created"), rs.getLong("c.last_updated"), rs.getString("p.first_name"), rs.getString("p.mid_name"), rs.getString("p.last_name"), rs.getString("p.phone_number"), rs.getString("p.email"), rs.getString("p.address"), rs.getInt("p.is_deleted"), rs.getLong("p.created"), rs.getLong("p.last_updated"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Reservation.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Customer -> " + c);
        return c;
        
    }
    
    public ResultSet get_customer_record_by_id(int customer_id){
        System.out.println(this.getClass() + " get_customer_record_by_id() performed!");
        ResultSet rs = null;
        String query = String.format("SELECT c.`id`, c.`tbl_person_id`, c.`code`, c.`is_deleted`, c.`created`, c.`last_updated`, p.`first_name`, p.`mid_name`, p.`last_name`, p.`phone_number`, p.`email`, p.`address`, p.`is_deleted`, p.`created`, p.`last_updated` FROM tbl_person as p INNER JOIN tbl_customer as c ON p.id = c.tbl_person_id WHERE c.`id` = %s LIMIT 1", customer_id);
        System.out.println("query -> " + query);
        rs = this.db.execute_query(query);
        return rs;
    }
    
    public String to_combobox_string(){
        System.out.println(this.customer);
        return String.format("%d-Customer [%s]-Mealtable id: %d", this.get_id(), this.customer.get_full_name(), this.get_mealtable_id());
    }
    
    @Override
    public String toString() {
        return "Reservation{" + "id=" + id + ", tbl_employee_id=" + tbl_employee_id + ", tbl_mealtable_id=" + tbl_mealtable_id + ", tbl_customer_id=" + tbl_customer_id + ", is_deleted=" + is_deleted + ", created=" + created + ", last_updated=" + last_updated + '}';
    }
}
