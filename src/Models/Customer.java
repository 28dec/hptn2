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
public class Customer extends Person{
    private int id;
    private int person_id;
    private String code;
    private int is_deleted;
    private long created;
    private long last_update;

    public Customer(int id, int person_id, String code, int is_deleted, long created, long last_update, String first_name, String mid_name, String last_name, String phone_number, String email, String address, int super_is_deleted, long super_created, long super_last_update) {
        super(person_id, first_name, mid_name, last_name, phone_number, email, address, is_deleted, created, last_update);
        this.id = id;
        this.person_id = person_id;
        this.code = code;
        this.is_deleted = is_deleted;
        this.created = created;
        this.last_update = last_update;
    }

    public String get_code() {
        return code;
    }

    public String get_first_name() {
        return first_name;
    }

    public String get_mid_name() {
        return mid_name;
    }

    public String get_last_name() {
        return last_name;
    }

    public String get_phone_number() {
        return phone_number;
    }
    
    public String get_full_name(){
        return String.format("%s %s %s", this.first_name, this.mid_name, this.last_name);
    }
    
}
