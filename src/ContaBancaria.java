import java.util.Scanner;

public class ContaBancaria {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String nomeDoCliente = "Leonorico Borges";
        String tipoConta = "Corrente";
        double saldo = 1800;
        int opcaoSelecionada = 0;
        String extratoInicial = """
                ******************************************
                Dados iniciais do cliente:
                
                Nome:               %s
                Tipo conta:         %s
                Saldo inicial:      R$ %.2f
                ******************************************
                """.formatted(nomeDoCliente,tipoConta,saldo);

        System.out.println(extratoInicial);
    }
}
