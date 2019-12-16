/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author longnh
 */
public class Coupon {
    private int id;
    private int tbl_bill_id;
    private String code;
    private String name;
    private int percentage;
    private Date expire_date;
    private int is_deleted;
    private long created;
    private long last_updated;
    private DB db;
    
    public Coupon(){
        this.db = new DB();
    }
    
    public void apply_coupon_to_bill(String coupon, int bill_id){
        String query = String.format("UPDATE tbl_coupon SET `tbl_bill_id` = %d WHERE `code` = %s;", bill_id, coupon);
        this.db.execute_update(query);
    }
    
    public int get_coupon_availability(String coupon){
        String query = String.format("SELECT `id`, `tbl_bill_id`, `name`, `percentage`, `expire_date` from tbl_coupon WHERE is_deleted = 0 AND `code` = '%s' LIMIT 1", coupon);
        ResultSet rs = this.db.execute_query(query);
        try {
            if(rs.next()){
                this.id = rs.getInt("id");
                this.tbl_bill_id = rs.getInt("tbl_bill_id");
                this.name = rs.getString("name");
                this.percentage = rs.getInt("percentage");
                this.expire_date = rs.getDate("expire_date");
            } else {
                return -1;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Coupon.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("exceptionnnnnnnnnnnnnnnnnnnnnnnnnnnn");
        }
        Date current_date = new java.sql.Date(new java.util.Date().getTime());
        if(this.expire_date.before(current_date)){
            return -2; // expired coupon
        } else if(this.tbl_bill_id != 0){
            return -3; // used coupon
        } else return 1; // valid coupon
    }
    
    @Override
    public String toString() {
        return "Coupon{" + "id=" + id + ", tbl_bill_id=" + tbl_bill_id + ", code=" + code + ", name=" + name + ", percentage=" + percentage + ", is_deleted=" + is_deleted + ", created=" + created + ", last_updated=" + last_updated + '}';
    }
    
    
}
