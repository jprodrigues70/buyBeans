/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.event.ActionEvent;
import src.Account;

/**
 *
 * @author jpr70
 */
public final class NewIncome extends NewTransaction {

    /**
     * Creates new form NewExpense
     * @param account
     */
    public NewIncome(Account account) {
        super(account);
    }

    @Override
    void initComponents() {
        super.initComponents();
        title.setText("Nova Receita");
        description.setText("De onde veio esse valor?");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       String result = account.addIncome((double)value.getValue(), description.getText());
       total.setText(result);
    }
}
