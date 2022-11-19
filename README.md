# Projeto Desenvolvido para Avaliação da Disciplina de Banco de Dados I

### Tecnologias utilizadas

Para o desenvolvimento deste projeto foram utilizadas as tecnologias:

- Java 17
- Spring Boot Framework
- Spring JPA
- Thymeleaf
- MySQL

### Modelo de Dados

O modelo de dados utilizado para a criação deste projeto está representado abaixo.

![Modelo de dados](/docs/imgs/modelo_logico.png)

Neste projeto foram utilizadas as tabelas Pet e Serviço, as quais possuem um relacionamento de muitos para muitos entre si.

### Funcionalidades

CRUD Completo de Pet
![CRUD Pet](/docs/imgs/pet_crud.png)

CRUD Completo de Serviço
![CRUD Serviço](/docs/imgs/servico_crud.png)

Relacionamento entre as entidades de Pet e Serviço

![Muitos para muitos](/docs/imgs/pedido_crud.png)

### Instalação

Para a instalação do Maven, caso não possua: `mvnw install`

Para a instalação do Projeto, basta importá-lo em sua IDE favorita e então aguardar o Maven fazer download de todas as dependências necessárias. Após concluído o download e o building.

Caso não faça automaticamente, utiliza-se o comando: `mvnclean install`

### Rodando a aplicação localmente:

Para rodar o projeto localmente, utiliza-se o comando: `mvnspring-boot:run`

Antes de rodar o projeto, deve-se alterar o usuário e senha de acesso ao banco e dados presente no arquivo `src/main/resources/application.properties`

Ao iniciar a aplicação, é criado automaticamente a tabela no banco de dados com o nome pethotel. Esta tabela é preenchida automaticamente com alguns itens previamente cadastrados.

### Construção da Aplicação:

Para o backend foi utilizada a linguagem Java 17 junto com o Framework Spring na versão 2.7.5.

Foi feito o uso do Spring JPA para a comunicação do com o branco de dados MySQL, a estrutura das entidades está disponível dentro do pacote `src/main/java/br/ufs/pethotel/model`. Foi realizada a criação de um CRUD completo das entidades de Pet e Serviço, além de contar com uma funcionalidade de criar relacionamento entre essas entidades com a funcionalidade de criar pedidos

Para o frontend, foi utilizado o Template engine Thymeleaf, o qual possue grande compatibilidade com o Spring Framework. O Thymeleaf faz a geração dinâmica dos arquivos HTML e mostra ao usuário as informações geradas pelo backend.

Foram adicionadas também, mensagens de erro para validação do banco de dados e do preenchimento dos formulários durante a criação de itens.

### Autores

- Arthur Franklin Souza de Oliveira
- Raí Rafael Santos Silva
- Rodrigo Alves Andrade
