package budgetapp.domain;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class Budget {

    private int id;
    private Wallet wallet;
    private double budget;
    private String info;
    private static final DecimalFormat centsFormat = new DecimalFormat("0.00");
//  private static final NumberFormat EURO_FORMAT_FRANCE = NumberFormat.getCurrencyInstance(Locale.FRANCE);

    public Budget(int id, double budget, String info, Wallet myWallet) {
        this.id = id;
        this.budget = budget;
        this.info = info;
        this.wallet = myWallet;

    }
    
    public Budget(double budget, String info, Wallet myWallet) {
        this.id = id;
        this.budget = budget;
        this.info = info;
        this.wallet = myWallet;

    }

    public int getId() {
        return id;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public double getBudget() {
        return budget;
    }

    public String getInfo() {
        return info;
    }
    

}
