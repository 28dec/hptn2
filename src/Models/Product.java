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
public class Product {
    private int id;
    private String code;
    private int type;
    private String name;
    private String describe;
    private double price;

    public Product(int id, String code, int type, String name, String describe, double price) {
        this.id = id;
        this.code = code;
        this.type = type;
        this.name = name;
        this.describe = describe;
        this.price = price;
    }

    public int get_id() {
        return id;
    }

    public String get_code() {
        return code;
    }

    public int get_type() {
        return type;
    }

    public String get_name() {
        return name;
    }

    public String get_describe() {
        return describe;
    }

    public double get_price() {
        return price;
    }

    
    
    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", code=" + code + ", type=" + type + ", name=" + name + ", describe=" + describe + ", price=" + price + '}';
    }
    
    
}
