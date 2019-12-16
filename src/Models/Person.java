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
public class Person {
    protected int id;
    protected String first_name;
    protected String mid_name;
    protected String last_name;
    protected String phone_number;
    protected String email;
    protected String address;
    protected int is_deleted;
    protected long created;
    protected long last_update;

    public Person(int id, String first_name, String mid_name, String last_name, String phone_number, String email, String address, int is_deleted, long created, long last_update) {
        this.id = id;
        this.first_name = first_name;
        this.mid_name = mid_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
        this.email = email;
        this.address = address;
        this.is_deleted = is_deleted;
        this.created = created;
        this.last_update = last_update;
    }
    
    
}
