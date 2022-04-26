/*
    Compilador online usado para testes: https://www.jdoodle.com/online-java-compiler/
    By: Guilherme Silva(Encrypton)

    Código meramente ilustrativo para fins de trabalho escolar, 
    não envolvolve nenhuma segurança nem o guardo de dados obtidos em banco de dados.
*/

import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class contaCorrente
{
    // variaveis globais, pertencente a tudo na classe contaCorrente
    static int conta = 0, agencia, qtdSaques;
    static double saldo;
    static String nomeCliente;
    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args)
    {
        telaInicial();
    }

    public static void telaInicial(){
         System.out.println("\t ** Bem vindo ao Ecrypton Bank **");
         System.out.println("\t Para continuar, faça login ou cadastre-se");
         System.out.println("1. Entrar");
         System.out.println("2. Cadastrar-me");
         opcaoEscolhida1();
    }

    public static void menuPrincipal()
    {
        System.out.println("1.Sacar");
        System.out.println("2.Depositar");
        System.out.println("3.Imprimir");
        System.out.println("\t\n -> Por favor, digite a opção númerica referente ao serviço desejado");
        opcaoEscolhida();
    }

    public static void saques()
    {
        System.out.println("\n Quanto você deseja sacar? \t Exemplo 5.50");
        System.out.println("Saldo atual: R$" + saldo);
        String valorSacar = entrada.nextLine();
        double dinheiroSaque = Double.parseDouble(valorSacar);
        if(saldo >= dinheiroSaque)
        {
            saldo -= dinheiroSaque;
            qtdSaques ++;
            System.out.println("valor sacado: R$" + dinheiroSaque);
            System.out.println("Novo valor em conta: R$" + saldo);
            menuPrincipal();
        }
        else{
            System.out.println("Saldo insuficiente");
            System.out.println("Valor atual em conta: R$ " + saldo);
            menuPrincipal();
        }
    }

    public static void depositos()
    {
        System.out.println("\nQual o valor do deposito? \t Exemplo 20.00");
        String valorDeposito = entrada.nextLine();
        double dinheiroDepositado = Double.parseDouble(valorDeposito);
        saldo += dinheiroDepositado;
        System.out.println("Valor depositado: R$" + dinheiroDepositado);
        System.out.println("Novo saldo em conta: R$" + saldo);
        menuPrincipal();
    }

     public static void opcaoEscolhida1()
    {
       String opcaoCliente1 = entrada.nextLine();
       int opcaoNumerica1 = Integer.parseInt(opcaoCliente1);
       switch(opcaoNumerica1)
        {
            case 1:
                System.out.println("\nPor favor, informe o número de sua conta: ");
                String contaNumeros = entrada.nextLine();


                int number = Integer.parseInt(contaNumeros);
                Long converterLongConta = (long) conta;
                Long converterLongEntrada = (long) number;
                int ultimaTentativa = converterLongConta.compareTo(converterLongEntrada);
               
               if(ultimaTentativa == 0){
                   System.out.println("login efetuado com sucesso!\n\n");
                   menuPrincipal(); 
               }
               else{
                    System.out.println("\n\t Primeira comparação: " + converterLongEntrada + " do tipo: " + converterLongEntrada.getClass().getSimpleName());
                    System.out.println("\n\t  Segunda comparação: " + converterLongConta + " do tipo: " + converterLongConta.getClass().getSimpleName());
                    System.out.println("\n usuario invalido!\n\n");
                    telaInicial();
               }
            case 2:
               System.out.println("\nPor favor, informe seu nome completo:");
               String nomeClienteInfo = entrada.nextLine();
               Random random = new Random();
               int numberRandom = random.nextInt(10000, 99999);
               System.out.println("\nConta criada com sucesso!\n");
           
               conta = numberRandom;
               nomeCliente = nomeClienteInfo;

               System.out.println("Número da conta: " + conta);
               System.out.println("Usuário: " + nomeCliente);
               System.out.println("\n\nREDIRECIONANDO PARA LOGIN\n\n");
               telaInicial();
            break;
            default:
                System.out.println("\n\n Opção invalida");
                telaInicial();
            break;
        }
    }

    public static void opcaoEscolhida()
    {
       String opcaoCliente = entrada.nextLine();
       int opcaoNumerica = Integer.parseInt(opcaoCliente);
       switch(opcaoNumerica)
        {
            case 1:
                saques();
            break;
            case 2:
                depositos();
            break;
            case 3:
                DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yy/MM/dd HH:mm:ss");
                System.out.println("** BIP BIP BUUUP ** \n");
                System.out.println("Nome: " + nomeCliente);
                System.out.println("Data e hora: "+dtf2.format(LocalDateTime.now()));
                System.out.println("Valor em conta corrente: R$" + saldo);
                menuPrincipal();
            break;
            default:
                System.out.println("Opção invalida");
                menuPrincipal();
            break;
        }
    }
}
