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
    private DB db;
    
    public int get_id(){
        return this.id;
    }
    
    public Bill(int tbl_employee_id, int tbl_order_id) {
        this.db = new DB();
        this.tbl_employee_id = tbl_employee_id;
        this.tbl_order_id = tbl_order_id;
        this.created = new java.util.Date().getTime();
    }
    
    public int create(){
        String query = String.format("INSERT INTO tbl_bill(`tbl_employee_id`, `tbl_order_id`, `created`, `last_updated`) VALUES %d, %d, %ld, %ld", this.tbl_employee_id, this.tbl_order_id, this.created, 0);
        return  this.db.execute_insert(query);
    }
    
    @Override
    public String toString() {
        return "Bill{" + "id=" + id + ", is_deleted=" + is_deleted + ", created=" + created + ", last_updated=" + last_updated + '}';
    }
    
    
}
