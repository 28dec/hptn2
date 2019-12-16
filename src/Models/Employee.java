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
public class Employee extends Person {
    private int id;
    private int tbl_person_id;
    private String code;
    private int type;
    private int is_deleted;
    private long created;
    private long last_updated;

    public Employee(int id, int tbl_person_id, String code, int type, int is_deleted, long created, long last_updated, String first_name, String mid_name, String last_name, String phone_number, String email, String address, int super_is_deleted, long super_created, long super_last_update) {
        super(tbl_person_id, first_name, mid_name, last_name, phone_number, email, address, super_is_deleted, super_created, super_last_update);
        this.id = id;
        this.tbl_person_id = tbl_person_id;
        this.code = code;
        this.type = type;
        this.is_deleted = is_deleted;
        this.created = created;
        this.last_updated = last_updated;
    }

    
    
    
    public int get_id(){
        return this.id;
    }
    
    public String get_code(){
        return this.code;
    }
    
    public String get_full_name(){
        return String.format("%s %s %s", this.first_name, this.mid_name, this.last_name);
    }
    
    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", tbl_person_id=" + tbl_person_id + ", code=" + code + ", type=" + type + ", is_deleted=" + is_deleted + ", created=" + created + ", last_updated=" + last_updated + '}';
    }
    
    
}
