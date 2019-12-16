///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package Models;
//
//import java.util.*;
//
///**
// *
// * @author longnh
// */
//public class driver {
//    static private Reservation rev;
//    public static void main(String[] args) {
//        List<Reservation> reservations = new Reservation().get_all();
//        for(Reservation r: reservations){
//            System.out.println(r);
//            List<Product> products = new Order().get_all_product_by_reservation_id(r.get_id());
//            List<Combo> combos = new Order().get_all_combo_by_reservation_id(r.get_id());
//            System.out.printf("reservation with id = %d has %d product%n", r.get_id(), products.size());
//            for(Product p: products){
//                System.out.println(p);
//            }
//            System.out.printf("reservation with id = %d has %d combo%n", r.get_id(), combos.size());
//            for(Combo c: combos){
//                System.out.println(c);
//            }
//        }
//    }
//}
