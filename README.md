
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

![d](https://github.com/Rafael-Bessa/AdopetAPI/assets/104053775/fb5fba8a-5077-4f68-b39e-d8c8dd3792ad)

![e](https://github.com/Rafael-Bessa/AdopetAPI/assets/104053775/b9bd33b2-da62-470b-9e8c-87641491258b)


A figura acima mostra o mapeamento, com a ajuda do Spring Data e o Hybernate, as tabelas do banco foram criadas automaticamente, sem precisar escrever os comandos SQL.

Durante a última Sprint, implementei várias funcionalidades novas que aprimoraram significativamente o sistema. Entre elas, destaco a Classe Pet, a Classe Abrigo e a funcionalidade de Adoção.

Adotei uma regra de negócios específica para o meu sistema. Ao cadastrar um abrigo, posso optar por cadastrar pets simultaneamente ou não. Caso opte por não cadastrar os pets no momento da criação do abrigo, posso fazê-lo posteriormente, fornecendo o ID do abrigo.

Quanto à funcionalidade de adoção, ela requer um Tutor e um Pet. Uma vez concluída a adoção, o atributo ‘adotado’ do Pet é atualizado para ‘true’.

Para facilitar esse processo, criei uma classe auxiliar que recebe um JSON específico. Este JSON contém o e-mail do tutor, que é único no meu banco de dados, e o ID do Pet que é o alvo da adoção.

Abaixo as entradas do método POST para as funcionalidades:

![a](https://github.com/Rafael-Bessa/AdopetAPI/assets/104053775/88492251-30eb-4c2e-852e-739ddd153b45)

![b](https://github.com/Rafael-Bessa/AdopetAPI/assets/104053775/d82a5701-a0ef-49dd-9938-e8f03910ec09)

![c](https://github.com/Rafael-Bessa/AdopetAPI/assets/104053775/097270ff-fc59-4060-80f5-723b126e55cb)

![f](https://github.com/Rafael-Bessa/AdopetAPI/assets/104053775/0d6b48f4-d9a1-4780-a840-05401b1222b5)

![g](https://github.com/Rafael-Bessa/AdopetAPI/assets/104053775/e0fea0b0-c46c-4e20-8cba-5216998feaf1)

# A Terceira Sprint do Projeto

Depois de implementar os CRUD's e funcionalidades (ainda faltando alguns ajustes). Nessa Sprint o objetivo é implementar a segurança da API, vou utilizar o Spring Security e o Token JWT.
Pretendo também ao final criar uma documentação no swagger.

Primeiro passo é adicionar as dependências necessárias no pom.xml

![sec](https://github.com/Rafael-Bessa/AdopetAPI/assets/104053775/26a58432-d851-4fd1-b9aa-ffe85d270d85)



