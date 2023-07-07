import java.util.Scanner;

public class ContaBancaria {

    public static void apresentaMenu() {
        String menu = """
                Operações
                
                1- Consultar saldos
                2- Receber valor
                3- Transferir valor
                4- Sair
                
                Digite a opção desejada:
                """;
        System.out.println(menu);
    }

    public static double consultaSaldo() {
        return 0;
    }

    public static double recebeTransferencia() {
        return 0;
    }

    public static double fazTransferencia() {
        return 0;
    }

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

        do {
            apresentaMenu();
            switch(opcaoSelecionada) {
                case 1:
                    consultaSaldo();
                    break;
                case 2:
                    recebeTransferencia();
                    break;
                case 3:
                    fazTransferencia();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while(opcaoSelecionada != 4);

        System.out.println("Saindo da conta bancária.");
    }
}
