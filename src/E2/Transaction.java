package E2;

public class Transaction extends Thread{
    private static int COUNT = 0;

    private int id;

    private final Client client;

    private int amount;

    private Transaction transactionBefore;

    @Override
    public void run() {
        if (transactionBefore != null){
            try {
                transactionBefore.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            withdrawMoney();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Transaction(Client client, int amount) {
        this.id = Transaction.COUNT++;
        this.client = client;
        this.amount = amount;
    }

    public void waitFor(Transaction transaction){
        this.transactionBefore = transaction;
    }

    private void withdrawMoney() throws InterruptedException {
        // other code

        synchronized (client){

        if (client.getBalance() - amount >= 0){
            printStep("Before Transaction : " + client.getBalance());
            //sleep(1000);
            client.pay(amount);
            printStep("After Transaction : " + client.getBalance());
        }else {
            printStep("Declined");
        }

        }


    }

    private void printStep(String text){
        System.out.println(" | Thread name : " + getName() + " | " + text);
    }


}
