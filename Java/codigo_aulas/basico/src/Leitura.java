import java.util.Scanner; // utilizada para ler dados de entrada

public class Leitura {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);

        System.out.println("Digite seu filme favorito:");
        String filme = leitura.nextLine(); // capta a informação digitada

        System.out.println("Qual o ano de lançamento?");
        int anoDeLancamento = leitura.nextInt();

        System.out.println("Diga sua avaliação para o filme:");
        double avaliacao = leitura.nextDouble();

        System.out.printf("""
                Filme: %s
                Ano de lançamento: %d
                Avaliação: %f
                """, filme, anoDeLancamento, avaliacao);
    }
}
