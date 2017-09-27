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
public class Thread2 implements Runnable {

    Thread tr2;
    String t;
    String s;
    int vaicaLon;

    public Thread2(String name) {
        Thread tr;
        tr = new Thread(this, name);
        tr.start();
        

    }

    

    public void run() {
        int i = 20;
        while (i > 0) {
            try {
                System.out.println("My email is truonganhtuan016@gmail.com");
                System.out.println("======================================");
                Thread.sleep(2 * 1000);
                i--;
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
