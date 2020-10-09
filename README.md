# data-processor

Utilizado:

Java 8

Gradle 6.6-rc-3

Lombok 1.18.8

Guava 27.1-jre

Junit 4.12



Você deve criar um sistema de análise de dados, onde o sistema deve importar
lotes de arquivos, ler e analisar os dados e produzir um relatório.
Existem 3 tipos de dados dentro desses arquivos.
Para cada tipo de dados há um layout diferente.

Dados do vendedor
Os dados do vendedor têm o formato id 001 e a linha terá o seguinte formato.
001çCPFçNameçSalary

Dados do cliente
Os dados do cliente têm o formato id 002 e a linha terá o seguinte formato.
002çCNPJçNameçBusiness Area

Dados de vendas
Os dados de vendas têm o formato id 003 . Dentro da linha de vendas, existe a lista
de itens, que é envolto por colchetes []. A linha terá o seguinte formato.
003çSale IDç[Item ID-Item Quantity-Item Price]çSalesman name

Dados de Exemplo
O seguinte é um exemplo dos dados que o sistema deve ser capaz de ler.
001ç1234567891234çPedroç50000
001ç3245678865434çPauloç40000.99
002ç2345675434544345çJose da SilvaçRural
002ç2345675433444345çEduardo PereiraçRural
003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro
003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çPaulo

sistema deverá ler continuamente todos os arquivos dentro do diretório padrão
HOMEPATH/data/in e colocar o arquivo de saída em HOMEPATH/data/out.
No arquivo de saída o sistema deverá possuir os seguintes dados:
• Quantidade de clientes no arquivo de entrada
• Quantidade de vendedores no arquivo de entrada
• ID da venda mais cara•
O pior vendedor
Requisitos técnicos


O sistema deve rodar continuamente e capturar novos arquivos assim que eles sejam
inseridos no diretório padrão.
Você tem total liberdade para escolher qualquer biblioteca externa se achar
necessário.