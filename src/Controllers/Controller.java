/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Bill;
import Models.Combo;
import Models.Coupon;
import Models.DB;
import Models.Employee;
import Models.Order;
import Models.Product;
import Models.Reservation;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author longnh
 */
public class Controller {
    
    private DB db;
    private Reservation reservation;
    private Order order;
    private Bill bill;
    private Coupon coupon;
    private Employee employee;
    
    public Controller(){
        this.db = new DB();
        this.reservation = new Reservation();
        this.order = new Order();
        this.coupon = new Coupon();
        this.employee = new Employee(1, 1, "EMP_1102", 1, 0, 0, 0, "Nguyễn", "Hoàng", "Long", "0968686717", "bachvkhoa@gmail.com", "Bắc Ninh", 0, 0, 0);
    }

    public Reservation get_reservation() {
        return reservation;
    }

    public Order get_order() {
        return order;
    }

    public Bill get_bill() {
        return bill;
    }

    public Coupon get_coupon() {
        return coupon;
    }

    public Employee get_employee(){
        return employee;
    }
    
    public void set_db(DB db) {
        this.db = db;
    }

    public void set_reservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public void set_reservation_by_id(List<Reservation> reservations, int reservation_id){
        for(Reservation r: reservations){
            if(r.get_id() == reservation_id){
                this.reservation = r;
                this.order.update_order_by_reservation_id(reservation_id);
                System.out.println("Controller Order id = " + this.order.get_id());
                break;
            }
        }
    }
    
    public void set_order(Order order) {
        this.order = order;
    }

    public void set_bill(Bill bill) {
        this.bill = bill;
    }

    public void set_coupon(Coupon coupon) {
        this.coupon = coupon;
    }
    
    public void set_employee(Employee employee){
        this.employee = employee;
    }
    
    public List<Reservation> get_all_reservations(){
        return this.reservation.get_all();
    }
    
    public List<Product> get_all_products_in_order(){
        return this.order.get_all_products_by_reservation_id(this.reservation.get_id());
    }
    
    public List<Combo> get_all_combos_in_order(){
        return this.order.get_all_combos_by_reservation_id(this.reservation.get_id());
    }
    
    public int apply_coupon_to_bill(String coupon){
        int coupon_availability = this.coupon.get_coupon_availability(coupon);
        if(coupon_availability > 0){
            this.coupon.set_code(coupon);
            this.coupon.set_percentage(coupon_availability);
            this.update_bill_price(coupon_availability);
        }
        return coupon_availability;
    }
    
    public void update_bill_price(float percentage){
        
    }
    
    public void create_bill(){
        this.bill = new Bill(this.employee.get_id(), this.order);
        this.bill.create();
        this.coupon.apply_to_bill(this.bill.get_id());
        this.reservation.mark_as_done();
    }
}
