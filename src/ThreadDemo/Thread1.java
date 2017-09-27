/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadDemo;

/**
 *
 * @author ADMIN-PC
 */
public class Thread1 extends Thread {

    @Override
    public void run() {
        int i = 20;
        if(i > 0) {
            try {
                System.out.println("My name is Tuan");
                System.out.println("================");
                Thread.sleep(2 * 1000);
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
