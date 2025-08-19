import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Digite o limite do cartão: ");
        double limit = reader.nextDouble();
        CreditCard card = new CreditCard(limit);

        int out = 1;
        while (out != 0) {
            System.out.println("Digite a descrição da compra: ");
            String description = reader.next();

            System.out.println("Digite o valor da compra: ");
            double price = reader.nextDouble();

            Purchase purchase = new Purchase(description, price);
            boolean completedPurchase = card.isAPurchase(purchase);

            if (completedPurchase) {
                System.out.println("Compra realizada com sucesso!");
                System.out.println("Digite 0 para sair e 1 para continuar.");
                out = reader.nextInt();
            } else {
                System.out.println("Saldo insuficiente.\n");
                out = 0;
            }
        }

        Collections.sort(card.getPurchases());
        StringBuilder productsList = new StringBuilder();
        for (Purchase p : card.getPurchases()) {
            productsList.append(p.getDescription() + " - " + p.getPrice() + "\n");
        }

        System.out.printf("""
                -----------------------------------------------
                               COMPRAS REALIZADAS
                
                %s
                -----------------------------------------------
                
                Saldo do cartão: %.2f
                """, productsList.toString(), card.getBalance());
    }
}
