# Relatório

Antes da refatoração dos componentes do código, ao executar o comando cloc, obteve-se a resposta abaixo:

```
-------------------------------------------------------------------------------
Language                     files          blank        comment           code
-------------------------------------------------------------------------------
Java                            13            100             13            513
XML                             12              0              0            474
Maven                            1              6              4             65
-------------------------------------------------------------------------------
SUM:                            26            106             17           1052
-------------------------------------------------------------------------------
```

Com um total de 1052 linhas de código. Após as refatorações de algumas funções, obteve-se a diminuição de algumas funções, ficando com 1046 linhas de código, como consta na tabela abaixo:

```
-------------------------------------------------------------------------------
Language                     files          blank        comment           code
-------------------------------------------------------------------------------
Java                            13            100             13            508
XML                             12              0              0            476
Maven                            1              6              4             65
-------------------------------------------------------------------------------
SUM:                            26            106             17           1046
-------------------------------------------------------------------------------
```

Os problemas identificados eram relacionados a uma repetição na declaração de objetos nas classes de testes, a soluçõa encontrada foi a criação de um único objeto que será compartilhado dentre toda a classe de teste.
Segue abaixo a implementação das correções
[Ajuste 1](https://github.com/brunoricardosecco/arquitetura-software/commit/d4c0dc784a681093183b2d13892a1e153e679282)
[Ajuste 2](https://github.com/brunoricardosecco/arquitetura-software/commit/f8fddc3de38fcabdf2e278da272df739f6aa1107)

Outro ponto de melhoria identificado foi a remoção de um cálculo desnecessário.
[Ajuste](https://github.com/brunoricardosecco/arquitetura-software/commit/ac8f176b860022f65b791559f10dbf9383ecac17)
