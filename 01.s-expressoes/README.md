# Lista 1

1. Explique o que você entende por s-expressões?
	
	Possui uma definição recursiva: s-expressões são formados por atómos ou listas de s-expressões!	Os
	átomos podem tanto ser símbolos, quanto operadores, números, strings, boolean, etc...

2. Escreva cinco exemplos de s-expressões atômicas. Não use
   nenhum exemplo dos fornecidos nos slides. Também não use
   exemplos de colegas. Varie ao máximo os tipos de átomos
   usados.

	"Filipe"
	true
	33
	lcc
	+

3. O que são formas? Qual sua relação com s-expressões?

	Uma forma é uma s-expressão que pode ser avaliada por Lisp sem produzir um erro. Um exemplo de
	s-expressão é (* 2 5 5).

4. Escreva três exemplos de s-expressões não atômicas que não
   sejam formas e três outras que sejam formas.

	Exemplos de s-expressões não atômicas que não são formas:
	I. (* 2 5 
	II. ("Quantidade de erros:" 3))
	III. (par = true)

	Exemplos de s-expressões não atômicas que são formas:
	I. (* 2 5)
	II. (defn dobro [n] (* 2 n))
	III. (+ 5 (dec 10) 2)

5. O que são símbolos em Clojure? Dê exemplos de símbolos.
   Explore a linguagem por experimentação no REPL e descubra
   outros simbolos operacionais semelhantes aos de outras
   linguagens que você tenha estudado que sejam válidos em
   Clojure. Escreva uma expressão usando cada um desses símbolos
   que você descobrir.

	Símbolos são tanto variáveis que possuem dados armazenados em seu interior, quanto sinais de operações (chamados símbolos operacionais).
	Símbolos operacionais semelhantes ao de outras linguagens já estudadas por mim: +, -, *, /.
	S-expressão com cada um dos símbolos: (* 5 (+ 1/2 1) (- 16 5))

6. Escreva uma sequência de s-expressões que representem a
   avaliação da s-expressão `(* (+ 2 5 7) (- 8 (inc 3)) 5)`,
   passo a passo, até que seja reduzida à s-expressão atômica
   equivalente.

	I. (* (+ 2 5 7) (- 8 (inc 3)) 5)     // Expressão original
	II. (* (+ 2 5 7) (- 8 4) 5)          // (inc 3) = 4
	III. (* 14 (- 8 4) 5)		     // (+ 2 5 7) = 14
	IV. (* 14 4 5)			     // (- 8 4) = 4
	V. 280				     // (* 14 4 5) = 280
 
7. O que são _formas especiais_ e como diferem das demais formas?
   Por que `def` em uma s-expressão como `(def a 123)` é uma
   forma especial e não uma simples aplicação de função? E `fn`
   por que precisa ser definida como uma forma especial?
	
	São formas que não são de natureza funcional (como  as formas de aplicação de função).
	A s-expressão '(def a 123)' é uma forma especial por armazenar um dado na memória 
	(neste exemplo, armazenando os valores "123" a variável "a") e por propocionar efeito colateral.
	Explicando sucintamente: formas que requerem um tratamento especial por parte de Lisp são
	chamadas formas especiais, que é também o caso de fn!

8. Analise o programa abaixo. Considerando as definições nas
   primeiras três linhas, avalia a sequência de s-expressões
   pelas quais a s-expressão na linha final pode ser
   interpretada, passo a passo.

```clojure
(defn dobro [n] (* 2 n))
(defn triplo [n] (* 3 n))
(defn vezes_12 [n] (dobro (dobro (triplo n))))

(vezes_12 10)
```

	Ao criar a função "(defn vezes_12 [n] (dobro (dobro (triplo n))))", utilizamos outras funções
	definidas anteriormente para realizar a operação de multiplicar uma s-expressão atômica por 12.
	No contexto acima, ainda, podemos utilizar as funções dobro e triplo ou a função que surgira
	a partir da combinação delas (vezes_12). Isto é particularmente útil em diversas situações.

9. No REPL, com a forma especial `fn`, crie uma função anônima
   (ou lambda) que receba três argumentos (`a`, `b` e `c`) que
   representam os três coeficientes inteiros de uma equação de 2o
   grau e que retorne o valor do determinante (o _delta_) da
   equação. Com a forma especial `def`, defina o símbolo
   `eq2delta` e associe-o à função anônima. Em seguida, defina a
   mesma função usando apenas a forma especial `defn`.

	((fn [a b c] (- (Math/pow b 2) (* 4 a c))) 2 8 -24)

	(def eq2delta ((fn [a b c] (- (Math/pow b 2) (* 4 a c))) 2 8 -24))

	(defn eq2delta [a b c] (- (Math/pow b 2) (* 4 a c)))

10. No REPL, experimente as formas especiais `if` e `cond`.  Com
    elas, escreva a função `raizes` que retorne um vetor contendo
    as duas raízes da equação.

11. As formas especiais `print` e `println` nos permitem imprimir
    dados na saída (às vezes, você precisará usar também a forma
    especial `flush` para esvaziar o buffer de saída e garantir
    que o dado seja impresso no momento apropriado. Estude essas
    formas especiais e escreva o famoso _Hello, World!_ em
    Clojure, no arquivo `hello.clj`.

	Arquivo disponível neste diretório.

12. As formas especiais `read` e `read-line` permitem ler dados
    da entrada. E a função `Integer/parseInt` permite converter
    uma string em um valor inteiro. Com base nas formas especiais
    de entrada e saída e nas definições que você mesmo criou
    anteriormente, crie um pequeno programa no arquivo `eq2.clj`
    que leia os coeficientes `a`, `b` e `c` de uma equação de
    segundo grau da entrada e que imprima suas raízes. Se a
    equação não tiver raízes, imprima a mensagem `sem raízes` na
    saída
