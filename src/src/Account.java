/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jpr70
 */
public class Account implements AccountBase {
    private final List <Income> incomes;
    private final List <Expense> expenses;

    public Account() {
        this.incomes = new ArrayList <>();
        this.expenses = new ArrayList <>();
    }
    
    /**
     * 
     * @param id 
     * @return Income
     */
    @Override
    public Income getIncome(int id) {
        return this.incomes.get(id);
    }
    
    /**
     * 
     * @param id
     * @return Expense
     */
    @Override
    public Expense getExpense(int id) {
        return this.expenses.get(id);
    }
    
    /**
     * 
     * @param id
     */
    @Override
    public void deleteExpense(int id) {
        this.expenses.remove(id);
    }
    
    /**
     * 
     * @param id
     */
    @Override
    public void deleteIncome(int id) {
        this.incomes.remove(id);
    }

    /**
     * 
     * @param value double
     * @param description String
     * @return String
     */
    @Override
    public String addIncome(double value, String description) {
        Income income = new Income(value, description);
        this.incomes.add(income);
        return ("Saldo Atual:" + this.totalBalance());
    }

    /**
     * 
     * @param value double
     * @param description String
     * @return String
     */
    @Override
    public String addExpense(double value, String description) {
        Expense expense = new Expense(value, description);
        this.expenses.add(expense);
        return ("Saldo Atual:" + this.totalBalance());
    }
    
    /**
     * 
     * @param value double
     * @param description String
     * @param id int
     * @return String
     */
    @Override
    public String editIncome(double value, String description, int id) {
        this.incomes.get(id).setDescription(description);        
        this.incomes.get(id).setValue(value);
        return ("Saldo Atual:" + this.totalBalance());
    }
    
    /**
     * 
     * @param value double
     * @param description String
     * @param id int
     * @return String
     */
    @Override
    public String editExpense(double value, String description, int id) {
        this.expenses.get(id).setDescription(description);        
        this.expenses.get(id).setValue(value);
        return ("Saldo Atual:" + this.totalBalance());
    }
    
    /**
     * 
     * @return Matrix with {income.description, income.value, text}
     */
    @Override
    public Object[][] getIncomesList() {
        int size = this.incomes.size();
        
        Object[][] ob = new Object[size][3];
        int i = 0;
        for (Income income : this.incomes) {
            ob[i][0] = this.incomes.get(i).getDescription();
            ob[i][1] = "R$ " + this.incomes.get(i).getValue();
            ob[i][2] = "Editar";
            i++;
        }
        return ob;
    }
    
    /**
     * 
     * @return Matrix with {expense.description, expense.value, text}
     */
    @Override
    public Object[][] getExpensesList() {
        int size = this.expenses.size();
        
        String[] description = new String[3];
        String[][] ob = new String[size][3];
        int i = 0;
        for (Expense expense : this.expenses) {
            ob[i][0] = expense.getDescription();
            ob[i][1] = "R$ " + expense.getValue();
            ob[i][2] = "Editar";
            i++;
        }
        return ob;
    }

    /**
     * 
     * @return float that represents the sum of all Incomes
     */
    public float sumTotalIncomes() {
        float sum = 0;
        for (Income income : this.incomes) {
            sum += income.getValue();
        }
        return sum;
    }
    
    /**
     * 
     * @return float that represents Total incomes - Total expenses
     */
    @Override
    public float totalBalance() {
        return sumTotalIncomes() - sumTotalExpenses();
    }
    
    /**
     * 
     * @return float that represents the sum of all Expenses
     */
    public float sumTotalExpenses() {
        float sum = 0;
        for (Expense expense : this.expenses) {
            sum += expense.getValue();
        }
        return sum;
    }

}
