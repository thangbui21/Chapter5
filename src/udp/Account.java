/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package udp;

/**
 *
 * @author Thắng Bùi
 */
public class Account {
    private int money;
    private String history;

    public Account() {
    }

    public Account(int money, String history) {
        this.money = money;
        this.history = history;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }
   
}
