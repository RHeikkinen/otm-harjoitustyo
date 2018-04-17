package budgetapp.domain;

public class Income {

    private int id;
    private Wallet wallet;
    private double amount;
    private String info;
    
    public Income(int id, Wallet wallet, double amount, String info) {
        this.id = id;
        this.wallet = wallet;
        this.amount = amount;
        this.info = info;
    }

    public int getId() {
        return id;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public double getAmount() {
        return amount;
    }

    public String getInfo() {
        return info;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setInfo(String info) {
        this.info = info;
    }
    
    

}
