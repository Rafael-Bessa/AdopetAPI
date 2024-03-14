
<div align = "center" id='top'>

# API completa para gerenciamento do AdoPet

</div>

A **AdoPet** é uma empresa fictícia que funciona como intermediária entre adotantes de pets e ONGs com foco em retirar animais das ruas. A proposta da AdoPet é trazer mais usuários e aumentar a interação entre possíveis adotantes e representantes dessas ONGs e para isso, o objetivo do projeto é implementar uma plataforma e levar a empresa pro mundo digital.

Este projeto foi desenvolvido como resultado de um Desafio Back-End (6ª edição) exclusivo para alunos da escola de tecnologia [Alura](https://www.alura.com.br). Eu escolhi o Java com o SpringBoot para implementar a API. O Frond-end, assim como as telas de UI/UX do projeto, já foram pré fornecidas.

## Detalhes do projeto

<div>
  <img src="https://img.shields.io/badge/Java-0073b7?style=for-the-badge&logo=java&logoColor=white&color=orange">
  <img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white">
  <img src="https://img.shields.io/badge/Spring%20Boot-3.2.3-green.svg?style=for-the-badge&logo=spring-boot">
</div>


Os arquivos do **Figma** estão disponibilizados em: [Adopet](https://www.figma.com/file/TlfkDoIu8uyjZNla1T8TpH/Challenge---Adopet?type=design&node-id=518-11&mode=design&t=M5URJeV0ZqxnXgsj-0).

## Como eu fiz

 O primeiro passo para iniciar a API é acessar o [Spring Initializr](https://start.spring.io). Uma interface que simplifica o trabalho do desenvolvedor. Aqui, podemos definir o groupId, o artefato e até mesmo as dependências do projeto com apenas alguns cliques. Decidi adicionar algumas dependências posteriormente, ao longo do desenvolvimento do projeto, mas para dar o pontapé inicial, escolhi essas.

<div>
  <img src="https://github.com/Rafael-Bessa/AdopetAPI/assets/104053775/ae88bb10-2be9-4f3b-9be8-11f54e2981c6">
</div>
 
## Database

 O banco de dados para usar a aplicação será o h2, escolhido por ser um ambiente de desenvolvimento e pela praticidade de uso. Para analisar a configuração do banco você deve acessar o arquivo **resources/application.properties**. Vale notar que as tabelas (entidades) serão criadas automaticamente com a ajuda do Spring Data, as classes que serão tabelas estão no pacote **model**

# A primeira Sprint do projeto

Em minha jornada contínua para aprimorar minhas habilidades de desenvolvimento, recebi uma tarefa para criar funcionalidades essenciais na Classe/Entidade Tutor. Estas funcionalidades incluem a implementação dos verbos HTTP: GET, POST, PUT e DELETE.

Minha arquitetura de software é meticulosamente estruturada em camadas distintas, cada uma com sua própria responsabilidade. Tenho a camada model, que define a estrutura dos meus dados. A camada service é onde manipulo a lógica de negócios. A camada controller é responsável por receber e responder às solicitações HTTP. Além disso, tenho a camada config e outras, todas trabalhando juntas para fornecer uma aplicação robusta e escalável.

Para garantir a qualidade e a confiabilidade de minhas implementações, todos os verbos HTTP foram rigorosamente testados no Insomnia, uma plataforma de teste de API de alto desempenho. Isso me permite verificar e validar minhas implementações, garantindo que elas funcionem como esperado.

![a](https://github.com/Rafael-Bessa/AdopetAPI/assets/104053775/a9d113e9-f6a2-4c07-b42c-6939349ea39b) 

![b](https://github.com/Rafael-Bessa/AdopetAPI/assets/104053775/4f049a9c-6feb-44dc-b165-96cc2b300cbc)

![c](https://github.com/Rafael-Bessa/AdopetAPI/assets/104053775/b6d1a612-923c-4d07-8b6c-867edc9d5948)

# A Segunda Sprint do Projeto

*Implementando Pet e Abrigo*

Nesta sprint, vou focar na implementação das entidades Pet e Abrigo no sistema. Após minha própria análise decide criar um relacionamento ManyToOne/OneToMany, onde um Pet pertence a um único Abrigo, e um Abrigo pode ter vários Pets.

Para ambas as entidades, vou implementar o CRUD completo, permitindo a criação, leitura, atualização e exclusão de Pets e Abrigos. A implementação levará em consideração a lógica de negócio específica do projeto, como regras de validação de dados.

Eu também criei o record *Endereço* com o intuito de gravar o endereço do Abrigo, usando a anotação @Embeddable




