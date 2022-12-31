package E2;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Client client = new Client(1000);

        Transaction transaction0 = new Transaction(client, 200);
        Transaction transaction1 = new Transaction(client, 500);
        Transaction transaction2 = new Transaction(client, 600);

        transaction1.waitFor(transaction0);
        transaction2.waitFor(transaction1);

        transaction0.start();
        transaction1.start();
        transaction2.start();


        System.out.println("Main end");
    }
}
