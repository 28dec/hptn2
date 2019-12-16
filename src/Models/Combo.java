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
public class Combo {
    private int id;
    private String code;
    private String name;
    private String describe;
    private double price;

    public Combo(int id, String code, String name, String describe, double price) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.describe = describe;
        this.price = price;
    }
    
    public String get_code(){
        return this.code;
    }
    
    public String get_name(){
        return this.name;
    }
    
    public String get_describe(){
        return this.describe;
    }
    
    public double get_price(){
        return this.price;
    }
    
    @Override
    public String toString() {
        return "Combo{" + "id=" + id + ", code=" + code + ", name=" + name + ", describe=" + describe + ", price=" + price + '}';
    }
    
}
