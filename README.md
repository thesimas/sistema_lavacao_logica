# Sistema de Gestão de Lavação de Carros - CleanCar

Este projeto é um sistema de console desenvolvido em Java para gerenciar os atendimentos de uma empresa de lavação de carros. O programa gerencia o fluxo de dados desde a entrada de informações de cada cliente até a geração de um relatório estatístico completo ao final dos atendimentos.

Este trabalho foi desenvolvido como parte da avaliação da disciplina de Lógica de Programação no curso de Técnico em Desenvolvimento de Sistemas pelo IFSC.

## 📋 Funcionalidades Principais

O sistema implementa as seguintes funcionalidades, conforme os requisitos do projeto:

* **Registro Dinâmico de Atendimentos:** O programa inicia solicitando ao operador a quantidade de atendimentos que serão processados.
* **Coleta de Dados do Cliente:** Para cada atendimento, o sistema coleta:
    * Nome do cliente.
    * Tipo de veículo (Pequeno, Médio, Grande).
    * Tipo de serviço (Lavação externa, Externa + Interna, Externa + Interna + Cera).
* **Validação de Entradas:** O sistema valida as entradas para tipo de veículo e serviço, garantindo que apenas as opções válidas (1, 2 ou 3) sejam aceitas.
* **Cálculo de Preços por Matriz:** O valor de cada serviço é calculado automaticamente com base em uma matriz de preços pré-definida, que cruza o tipo do veículo com o tipo do serviço.
* **Relatório Final Completo:** Ao final de todos os registros, um relatório detalhado é gerado, contendo:
    * A relação geral de todos os clientes com os detalhes de seus atendimentos.
    * O percentual de atendimentos por tipo de veículo.
    * O percentual de atendimentos por tipo de serviço.
    * O valor total arrecadado pela empresa.
    * A identificação do tipo de veículo e serviço mais popular, tratando corretamente os casos de empate.

## 🛠️ Tecnologias Utilizadas

* **Java Purinho** 

O programa iniciará no console, solicitando as informações necessárias para o processamento.

## 🏛️ Estrutura do Código

O código é modularizado em várias funções estáticas para melhorar a organização e a legibilidade:

* `main()`: Orquestra todo o fluxo do programa, desde a solicitação inicial até a chamada do relatório final.
* `calcular_valor()`: Recebe o tipo de veículo e serviço e retorna o preço exato consultando a matriz de valores.
* `msg_tipo_carro()` e `msg_tipo_servico()`: Funções auxiliares que retornam a descrição em texto do código numérico do veículo/serviço.
* `mensagem_final()`: Exibe um resumo individual e formatado para cada cliente após o seu registro.
* `relatorio_final()`: Processa os dados de todos os atendimentos armazenados nos vetores para calcular e exibir as estatísticas completas.
