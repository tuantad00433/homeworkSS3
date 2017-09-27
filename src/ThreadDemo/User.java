/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threading;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author daolinh
 */
public class User {

    private int balance = 0;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    synchronized void rutTien(int money) {
        System.out.println("Tiến hành rút: " + money);
        if (this.balance < money) {
            try {
                System.err.println("Không thể thực hiện giao dịch. Chờ gửi thêm tiền.");
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }            
        } 
        this.balance -= money;
        // Làm gì ?
        System.out.println("Giao dịch rút tiền hoàn tất. Số dư: " + this.balance);
        System.out.println("---------------------------");
    }

    synchronized void napTien(int money) {
        System.out.println("Tiến hành gửi tiền: " + money);
        this.balance += money;
        System.out.println("Giao dịch nạp tiền hoàn tất. Số dư: " + this.balance);
        notify();        
        System.out.println("---------------------------");
    }
}
