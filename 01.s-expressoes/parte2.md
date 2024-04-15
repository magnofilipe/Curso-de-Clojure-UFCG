# Parte 2

Nos exercícios abaixo, crie as funções pedidas e crie uma função
`main` de apoio que permita testar a função com algum dado lido
da entrada. Mais adiante, forneceremos testes automáticos para
todas estas questões (tanto para as funções principais, como para
as funções `main` de cada questão).

-=-=-=-=-=-=- AVISO: AS FUNÇÕES E O MAIN ESTÃO IMPLEMENTADOS -=-=-=-=-=-=-
-=-=-=-=-=-=-  NO ARQUIVO MAIN.CLJ, NESTE MESMO DIRETÓRIO!!! -=-=-=-=-=-=-

13. Escreva a função `eh_bissexto` que avalia se um ano passado
    como argumento é ou não bissexto. Lembre que um ano é
    bissexto se for divisível por 400 ou se for divisível por 4 e
    não por 100.

14. Escreva a função `eh_triangulo` que, dadas as três medidas dos
    lados de um triângulo, determina se o triângulo é o ou não
    válido (pesquisa a chamada condição de existência do
    triângulo para saber como resolver o problema).

15. Escreva a função `tipo_triangulo` que, dadas as três medidas
    dos lados de um triângulo, determina o tipo de triângulo e
    deve retornar um _keyword_ indicando o tipo: `:equilátero`,
    `:isósceles` e `:escaleno`. Se as medidas não corresponderem
    a nenhum dos três tipos, deve retornar `nil`.

16. Escreva a função `fatorial` que, dado um número inteiro
    N retorna o fatorial de N. Lembre que, por definição, o
    fatorial de 0 e 1 é igual a 1 e que o fatorial de qualquer
    outro inteiro K maior que 1 é igual a K multiplicado pelo
    fatorial de K - 1.

    > Observação. Obviamente, esta função requer repetição que é
    > tema que ainda não vimos (será visto nas próximas aulas).
    > Mas nesta implementação, use recursão direta. Isso tornará
    > o código muito simples e lhe dará um gosto da forma geral
    > de repetições em Lisp e Clojure.
