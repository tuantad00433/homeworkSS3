/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threading;

import java.sql.Statement;

/**
 *
 * @author daolinh
 */
public class Threading {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        User u = new User();
        u.setBalance(800);
        System.out.println("Số dư hiện tại: " + u.getBalance());
        // Thực hiện rút tiền.
        Thread rutTien = new Thread() {
            @Override
            public void run() {
                u.rutTien(1500);
            }
        };
        Thread rutTien2 = new Thread() {
            @Override
            public void run() {
                u.rutTien(2500);
            }
        };
        // Thực hiện gửi tiền.
        Thread napTien = new Thread() {
            @Override
            public void run() {
                u.napTien(4000);
            }
        };
        
        rutTien.start();
        rutTien2.start();
        napTien.start();
    }

}
