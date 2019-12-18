/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author longnh
 */
public class Bill {
    private int id;
    private int tbl_employee_id;
    private int tbl_order_id;
    private int is_deleted;
    private long created;
    private long last_updated;
    private Order order;
    private Coupon coupon;
    private DB db;
    
    public int get_id(){
        return this.id;
    }
    
    public Bill(int tbl_employee_id, Order order, Coupon coupon) {
        this.db = new DB();
        this.tbl_employee_id = tbl_employee_id;
        this.order = order;
        this.coupon = coupon;
        this.created = new java.util.Date().getTime();
    }
    
    public int create(){
        String query = String.format("INSERT INTO tbl_bill(`tbl_employee_id`, `tbl_order_id`, `created`, `last_updated`) VALUES (%d, %d, %d, %d);", this.tbl_employee_id, this.order.get_id(), this.created, 0);
        long inserted_id =  this.db.execute_insert(query);
        if(inserted_id > 0) this.id = (int)inserted_id;
        System.out.println("inserted_id -> " + inserted_id);
        if(this.coupon != null){
            System.out.println("Bill has coupon!");
            this.coupon.apply_to_bill(this.id);
        } else {
            System.out.println("Bill do not has coupon!");
        }
        return this.id;
    }
    
    @Override
    public String toString() {
        return "Bill{" + "id=" + id + ", is_deleted=" + is_deleted + ", created=" + created + ", last_updated=" + last_updated + '}';
    }
    
    
}
