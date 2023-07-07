import java.util.Scanner;

public class ContaBancaria {

    public static void exibeExtratoInicial(String nomeDoCliente, String tipoConta, double saldo) {
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

    public static void apresentaMenu() {
        String menu = """
                Operações
                
                1- Consultar saldos
                2- Receber valor
                3- Transferir valor
                4- Sair
                
                Digite a opção desejada:
                """;
        System.out.print(menu);
    }

    public static void consultaSaldo(double saldo) {
        System.out.println(String.format("\nSaldo atual: %.2f\n", saldo));
    }

    public static double recebeTransferencia(Scanner teclado) {
        double valorRecebido;
        do {
            System.out.println("\nInforme o valor a ser recebido:");
            valorRecebido = teclado.nextDouble();
            if(valorRecebido < 0)
                System.out.println("\nValor recebido inválido.\n");
        } while(valorRecebido < 0);
        return valorRecebido;
    }

    public static double fazTransferencia(Scanner teclado, double saldo) {
        double valorTransferido = 0;
        if(saldo <= 0) {
            System.out.println("\nSeu saldo é insuficiente para realizar transferências.\n");
        } else {
            do {
                System.out.println("\nInforme o valor a ser transferido:");
                valorTransferido = teclado.nextDouble();
                if(valorTransferido < 0 || valorTransferido > saldo)
                    System.out.println("\nValor transferido inválido;\n");
            } while(valorTransferido < 0 || valorTransferido > saldo);
        }
        return valorTransferido;
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String nomeDoCliente = "Leonorico Borges";
        String tipoConta = "Corrente";
        double saldoAtual = 1800;
        double saldoAtualizado = saldoAtual;
        int opcaoSelecionada = 0;

        exibeExtratoInicial(nomeDoCliente,tipoConta,saldoAtual);
        do {
            apresentaMenu();
            opcaoSelecionada = teclado.nextInt();
            switch(opcaoSelecionada) {
                case 1:
                    consultaSaldo(saldoAtual);
                    break;
                case 2:
                    saldoAtualizado += recebeTransferencia(teclado);
                    break;
                case 3:
                    saldoAtualizado -= fazTransferencia(teclado, saldoAtual);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("\nOpção inválida.\n");
            }
            if(saldoAtual != saldoAtualizado) {
                System.out.println(String.format("\nSaldo atualizado: R$ %.2f\n", saldoAtualizado));
                saldoAtual = saldoAtualizado;
            }
        } while(opcaoSelecionada != 4);

        System.out.print("\nSaindo da conta bancária.\n");

    }
}
