package E2;

public class Client {
    private int balance;

    public Client(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void pay(int sum){
        balance -= sum;
    }

    @Override
    public String toString() {
        return "Client{" +
                "balance=" + balance +
                '}';
    }
}
