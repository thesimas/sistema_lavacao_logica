import java.util.Scanner;
public class sistema_lavacao {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        System.out.println("\n------------------------ Bem-Vindo ao Sistema de Lavação - CleanCar! ------------------------");
        byte quant_atendimentos;

        do{
            System.out.print("Para iniciarmos você deverá me informar a quantidade de atendimentos que serão processados: ");
            quant_atendimentos = leia.nextByte();
        }while (quant_atendimentos < 1); //validando a entrada para que seja sempre acima de 0.

        int[][] matriz_valores = { // declarando a matriz com os preços
                {50, 70, 90}, // tipo de veiculo é linha
                {70, 90, 110}, // tipo de serviço é coluna
                {90, 110, 130}
        };
        String[] nomes_clientes = new String[quant_atendimentos];
        int[] tipo_servico = new int[quant_atendimentos];
        int[] tipo_veiculo = new int[quant_atendimentos];
        int[] valores_pagos = new int[quant_atendimentos];
        String[] tipo_veiculo_escolhido = new String[quant_atendimentos];
        String[] tipo_servico_escolhido = new String[quant_atendimentos];
        byte opcao;

        for(int i = 0; i < quant_atendimentos; i ++){
            System.out.print("Nome do " + (i+1) + "° cliente:  "); nomes_clientes[i] = leia.next();
            do{
                System.out.println("Me informe o tipo do veiculo. Digite: \n1 - Pequeno (populares)\n2 - Médio (SUV e Picape)\n3 - Grande (Van e micro-ônibus).");
                opcao = leia.nextByte();

                if (opcao >= 1 && opcao <= 3){
                    tipo_veiculo[i] = opcao;
                }
                else{
                    System.out.println("Tipo de veículo inválido! Por favor, digite 1, 2 ou 3.");
                }
            }while (opcao < 1 || opcao > 3);
            do{
                System.out.println("Me informe o tipo de serviço. Digite: \n1 - (Lavação externa) \n2 - (Lavação externa + interna) \n3 - Lavação externa + interna + cera.");
                opcao = leia.nextByte();
                if (opcao >= 1 && opcao <= 3){
                    tipo_servico[i] = opcao;
                }
                else{
                    System.out.println("Tipo de serviço inválido! Por favor, digite 1, 2 ou 3.");
                }
            }while (opcao < 1 || opcao > 3);

            tipo_veiculo_escolhido[i] = msg_tipo_carro(tipo_veiculo[i]);
            tipo_servico_escolhido[i] = msg_tipo_servico(tipo_servico[i]);
            valores_pagos[i] = calcular_valor(matriz_valores, tipo_veiculo[i], tipo_servico[i]);
            mensagem_final(valores_pagos[i], tipo_veiculo_escolhido[i], tipo_servico_escolhido[i], nomes_clientes[i]); //Mensagem para cada processamento de usuario

        }
        relatorio_final(quant_atendimentos,valores_pagos,tipo_veiculo,tipo_servico,nomes_clientes);
        leia.close();
    }
    public static int calcular_valor(int[][] matriz_valores, int tipo_veiculo, int tipo_servico){
        //A função utiliza o tipo de veículo e o tipo de serviço como coordenadas para localizar o preço exato na matriz, que já foi atribuida no main.
        return matriz_valores[tipo_veiculo - 1][tipo_servico -1];
    }
    public static String msg_tipo_carro(int tipo_veiculo){ //função feita para resgatar a frase sobre o tipo de veiculo escolhido.
        String msg_carro;
        if (tipo_veiculo == 1){
            msg_carro = "1 - Pequeno (populares).";
        }else if (tipo_veiculo == 2) {
            msg_carro = "2 - Médio (SUV e Picape).";
        }else{
            msg_carro = "3 - Grande (Van e micro-ônibus).";
        }
        return msg_carro;
    }
    public static String msg_tipo_servico(int tipo_servico){ //função para resgatar a frase sobre o tipo de serviço escolhido.
        String msg_servico;
        if (tipo_servico == 1){
            msg_servico = "1 - (Lavação externa).";
        }else if (tipo_servico == 2) {
            msg_servico = "2 - (Lavação externa + interna).";
        }else{
            msg_servico = "3 - (Lavação externa + interna + cera).";
        }
        return msg_servico;
    }
    public static void mensagem_final(int valores_pagos, String tipo_veiculo_escolhido, String tipo_servico_escolhido, String nomes_clientes){
        // função para mostrar a mensagem para cada processamento de cliente.
        System.out.println("\nCliente: "+ nomes_clientes + " escolheu:");
        System.out.println("Tipo de Veiculo: " + tipo_veiculo_escolhido);
        System.out.println("Tipo de Serviço: " + tipo_servico_escolhido);
        System.out.println("Deverá pagar: R$"+ valores_pagos + " reais!\n");
    }
    public static void relatorio_final(byte quant_atendimentos,int[] valores_pagos,int[] tipo_veiculo,int[] tipo_servico, String[] nomes_clientes){
        int contador_veic_1 = 0;
        int contador_veic_2 = 0;
        int contador_veic_3 = 0;
        int contador_serv_1 = 0;
        int contador_serv_2 = 0;
        int contador_serv_3 = 0;
        int total_pago = 0;
        System.out.println("----------------Relação-dos-Clientes----------------");
        for(int i = 0; i < quant_atendimentos; i ++) {

            total_pago += valores_pagos[i];
            if(tipo_veiculo[i] == 1) {
                contador_veic_1++;
            } else if (tipo_veiculo[i] == 2) {
                contador_veic_2++;
            } else{
                contador_veic_3++;
            }

            if (tipo_servico[i] == 1) {
                contador_serv_1++;
            } else if (tipo_servico[i] == 2) {
                contador_serv_2++;
            } else{
                contador_serv_3++;
            }

                System.out.println("O " + (i+1) + "° Cliente: " + nomes_clientes[i] + ", optou:");
                System.out.println("* Pelo tipo de Veiculo: " + msg_tipo_carro(tipo_veiculo[i]));
                System.out.println("* Pelo tipo de Serviço: " + msg_tipo_servico(tipo_servico[i]));
                System.out.println("* E pagou: R$" + valores_pagos[i] + " reais!");
                System.out.println("----------------------------------------------------");
        }
        double percentual_veic_1 = contador_veic_1 * 100.0 / quant_atendimentos;
        double percentual_veic_2 = contador_veic_2 * 100.0 / quant_atendimentos;
        double percentual_veic_3 = contador_veic_3 * 100.0 / quant_atendimentos;
        double percentual_serv_1 = contador_serv_1 * 100.0 / quant_atendimentos;
        double percentual_serv_2 = contador_serv_2 * 100.0 / quant_atendimentos;
        double percentual_serv_3 = contador_serv_3 * 100.0 / quant_atendimentos;

        System.out.println("\n---------------------- Estatísticas ----------------------");
        System.out.printf("Percentual por tipo de veículo:\n (1) Veículo Pequeno: %.2f%% | (2) Veículo Médio: %.2f%% | (3) Veículo Grande: %.2f%%\n", percentual_veic_1, percentual_veic_2, percentual_veic_3);
        System.out.printf("Percentual por tipo de serviço:\n (1) Lavação Externa: %.2f%% | (2) Lavação Completa: %.2f%% | (3) Lavação Completa+Cera: %.2f%%\n", percentual_serv_1, percentual_serv_2, percentual_serv_3);
        System.out.println("O valor total arrecado foi: " + total_pago + " Reais!");

        //Condições para encontrar o veiculo mais atendido e da mostrar qual foi o serviço mais atendido,
        //atraves de uma comparação de variaveis.

        int veiculo_mais_atendido = contador_veic_1;

        if (contador_veic_2 > veiculo_mais_atendido){
            veiculo_mais_atendido = contador_veic_2;
        }
        if(contador_veic_3 > veiculo_mais_atendido){
            veiculo_mais_atendido = contador_veic_3;
        }
        System.out.println("Veículo(s) mais atendido(s) com " + veiculo_mais_atendido + " atendimentos:");
        if (contador_veic_1 == veiculo_mais_atendido) {
            System.out.println("(Tipo 1) - Pequeno (Populares).");
        }
        if (contador_veic_2 == veiculo_mais_atendido) {
            System.out.println("(Tipo 2) - Médio (SUVs e Picapes).");
        }
        if (contador_veic_3 == veiculo_mais_atendido) {
            System.out.println("(Tipo 3) - Grande (Vans e Micro-ônibus).");
        }
        //condição para encontrar o serviço mais atendido!
        //Caso tenha empate entre os serviços ele mostra mais de um servico.
        int servico_mais_atendido = contador_serv_1;

        if (contador_serv_2 > servico_mais_atendido) {
            servico_mais_atendido = contador_serv_2;
        }
        if(contador_serv_3 > servico_mais_atendido) {
            servico_mais_atendido = contador_serv_3;
        }
        System.out.println("Serviço(s) mais atendido(s) com " + servico_mais_atendido + " atendimentos:");
        if (contador_serv_1 == servico_mais_atendido) {
            System.out.println("(Tipo 1) - (Lavação externa).");
        }
        if (contador_serv_2 == servico_mais_atendido) {
            System.out.println("(Tipo 2) - (Lavação externa + Interna).");
        }
        if (contador_serv_3 == servico_mais_atendido) {
            System.out.println("(Tipo 3) - (Lavação externa + Interna + cera).");
        }
        System.out.println("----------------------------------------------------------");
    }
}