import java.math.BigDecimal;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        String name = "Jacqueline Oliveira";
        String accountType = "Corrente";
        String currency = "R$";
        BigDecimal balance = new BigDecimal("2500.00");

        Scanner reader = new Scanner(System.in);
        int option;

        do {
            System.out.printf("""
                *******************************************************
                Dados iniciais do cliente:
                
                Nome:               %s
                Tipo de conta:      %s
                Saldo inicial:      %s %.2f
                *******************************************************
                
                Operações
                
                1 - Consultar saldos
                2 - Receber valor
                3 - Transferir valor
                4 - Sair
                
                Digite a opção desejada:%n""",
            name, accountType, currency, balance);

            option = reader.nextInt();

            if (option <= 0 || option > 4) {
                System.out.printf("Opção inválida. Tente novamente.%n%n");
            }

            switch (option) {
                case 1:
                    System.out.printf("O saldo atual é %s %.2f%n%n", currency, balance);
                    break;
                case 2:
                    System.out.println("Informe o valor a receber:");
                    balance = balance.add(new BigDecimal(reader.next()));
                    System.out.printf("Saldo atualizado: %s %.2f%n%n", currency, balance);
                    break;
                case 3:
                    System.out.println("Informe o valor que deseja transferir:");
                    BigDecimal transfer = new BigDecimal(reader.next());

                    if (balance.compareTo(transfer) < 0) {
                        System.out.printf("Não há saldo suficiente para fazer a transferência.%n%n");
                        break;
                    }

                    balance = balance.subtract(transfer);
                    System.out.printf("Saldo atualizado: %s %.2f%n%n", currency, balance);
                    break;
                case 4:
                    System.out.println("Programa encerrado. Até logo!");
            }

        } while (option != 4);

        reader.close();
    }
}