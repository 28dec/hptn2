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
public class Order {
    private int id;
    private int tbl_reservation_id;
    private int tbl_employee_id;
    private int is_deleted;
    private long created;
    private long last_updated;
    private DB db;

    public Order() {
        this.db = new DB();
    }
    
    public int get_id(){
        return this.id;
    }
    
    public void update_order_by_reservation_id(int reservation_id){
        String query = String.format("SELECT `%s`, `%s`, `%s`, `%s`, `%s`, `%s` FROM tbl_order WHERE `is_deleted` = 0 AND `tbl_reservation_id` = %d;", "id", "tbl_reservation_id", "tbl_employee_id", "is_deleted", "created", "last_updated", reservation_id);
        ResultSet rs = this.db.execute_query(query);
        try {
            while(rs.next()){
                this.id = rs.getInt("id");
                this.tbl_employee_id = rs.getInt("tbl_employee_id");
                this.tbl_reservation_id = rs.getInt("tbl_employee_id");
                this.is_deleted = rs.getInt("is_deleted");
                this.created = rs.getLong("created");
                this.last_updated = rs.getLong("last_updated");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Product> get_all_products_by_reservation_id(int reservation_id){
        System.out.println(this.getClass() + " get_all_products_by_reservation_id() performed! reservation_id = " + reservation_id);
        update_order_by_reservation_id(reservation_id);
        List<Product> rtn = new ArrayList();
        try {
            ResultSet rs = get_all_products_record_by_order_id(this.id);
            while(rs.next()){
                rtn.add(new Product(rs.getInt("id"), rs.getString("code"), rs.getInt("type"), rs.getString("name"), rs.getString("describe"), rs.getDouble("in_order_price")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            System.out.println(rtn.size() + " record found!");
            return rtn;
        }
    }
        
    public ResultSet get_all_products_record_by_order_id(int order_id){
        ResultSet rs = null;
        String query = String.format("SELECT p.`%s`, p.`%s`, p.`%s`, p.`%s`, p.`%s`, p.`%s`, po.`%s` as in_order_price, p.`%s`, p.`%s`, p.`%s` FROM tbl_product as p INNER JOIN tbl_product_order as po ON p.id = po.tbl_product_id WHERE po.is_deleted = 0 and po.tbl_order_id = %d;", "id", "code", "type", "name", "describe", "price", "price","is_deleted", "created", "last_updated", order_id);
        rs = this.db.execute_query(query);
        return rs;
    }
    
    public List<Combo> get_all_combos_by_reservation_id(int reservation_id){
        update_order_by_reservation_id(reservation_id);
        List<Combo> rtn = new ArrayList();
        try {
            ResultSet rs = get_all_combos_record_by_order_id(this.id);
            while(rs.next()){
                rtn.add(new Combo(rs.getInt("id"), rs.getString("code"), rs.getString("name"), rs.getString("describe"), rs.getDouble("in_order_price")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return rtn;
        }
    }

    
    public ResultSet get_all_combos_record_by_order_id(int order_id){
        ResultSet rs = null;
        String query = String.format("SELECT c.`%s`, c.`%s`, c.`%s`, c.`%s`, c.`%s`, co.`%s` as in_order_price, c.`%s`, c.`%s`, c.`%s` FROM tbl_combo as c INNER JOIN tbl_combo_order as co ON c.id = co.tbl_combo_id WHERE co.is_deleted = 0 and co.tbl_order_id = %d;", "id", "code", "name", "describe", "price", "price","is_deleted", "created", "last_updated", order_id);
        rs = this.db.execute_query(query);
        return rs;
    }
    
    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", tbl_reservation_id=" + tbl_reservation_id + ", tbl_employee_id=" + tbl_employee_id + ", is_deleted=" + is_deleted + ", created=" + created + ", last_updated=" + last_updated + '}';
    }
    
    
}
