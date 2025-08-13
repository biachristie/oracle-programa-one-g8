package br.com.alura.conversor.principal;

import br.com.alura.conversor.model.CodigoMoeda;
import br.com.alura.conversor.service.ConversaoDados;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Principal {

    private final Scanner leitura = new Scanner(System.in);
    private final ConversaoDados conversaoDados;

    public Principal(ConversaoDados conversaoDados) {
        this.conversaoDados = conversaoDados;
    }

    public void exibeMenu() {
        int opcao = -1;
        double valor = 0.0;

        do {
            System.out.println("""
                    
                    --------------------------------------------------------------------------
                                               CONVERSOR DE MOEDAS
                    --------------------------------------------------------------------------
                    
                    Escolha uma das opções:
                    
                    1 - Real => Dólar Americano
                    2 - Dólar Americano => Real
                    3 - Real => Iene
                    4 - Iene => Real
                    5 - Real => Peso Chileno
                    6 - Peso Chileno => Real
                    0 - Sair
                    
                    --------------------------------------------------------------------------
                    
                    """);

            opcao = leitura.nextInt();
            leitura.nextLine();

            if (opcao != 0) {
                System.out.println("\nDigite o valor que deseja converter: ");
                valor = leitura.nextDouble();
                leitura.nextLine();
            }

            switch (opcao) {
                case 1:
                    System.out.println(conversaoDados.realizarConversao(CodigoMoeda.BRL.name(), CodigoMoeda.USD.name(), valor));
                    break;
                case 2:
                    System.out.println(conversaoDados.realizarConversao(CodigoMoeda.USD.name(), CodigoMoeda.BRL.name(), valor));
                    break;
                case 3:
                    System.out.println(conversaoDados.realizarConversao(CodigoMoeda.BRL.name(), CodigoMoeda.JPY.name(), valor));
                    break;
                case 4:
                    System.out.println(conversaoDados.realizarConversao(CodigoMoeda.JPY.name(), CodigoMoeda.BRL.name(), valor));
                    break;
                case 5:
                    System.out.println(conversaoDados.realizarConversao(CodigoMoeda.BRL.name(), CodigoMoeda.CLP.name(), valor));
                    break;
                case 6:
                    System.out.println(conversaoDados.realizarConversao(CodigoMoeda.CLP.name(), CodigoMoeda.BRL.name(), valor));
                    break;
                case 0:
                    System.out.println("\nEncerrando conversor...\n");
                    break;
            }

        } while (opcao != 0);
    }

}