; A função main está nas últimas linhas. Isto porque é necessário primeiro
; definir as funções que poderão vir a ser utilizadas. Depois, o
; usuário pode de fato escolher qual usar.

(defn eh_bissexto [ano]
  (if (or (and (zero? (mod ano 400))
               (not (zero? (mod ano 100))))
          (zero? (mod ano 4)))

      (println "É bissexto")
      (println "Não é bissexto")))

; -=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=
; -=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=

(defn eh_triangulo [a b c]

  (cond
    (or (>= a (+ b c)) (>= b (+ a c)) (>= c (+ b a))) "Triângulo inválido"
    :else "Triângulo válido"))

; -=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=
; -=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=

(defn tipo_triangulo [a b c]
  (cond
    (= a b c) :equilátero
    (or (= a b) (= a c) (= b c)) :isósceles
    (not= a b c) :escaleno
    :else "nil"))

; -=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=
; -=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=

(defn fatorial [n]
  (if (or (= n 1) (= n 0))
          1
          (* n (fatorial (dec n)))))

; -=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=
; -=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=--=

(defn main []
  (println
  "Digite o número correspondente a função você deseja utilizar: 
  (1) Eh_bissexto: retorna se um ano é ou não bissexto.
  (2) Eh_triangulo: diz se um triângulo é válido, dada suas medidas.
  (3) Tipo_triangulo: retorna keywords indicando o tipo de um triângulo, dada suas medidas.
  (4) fatorial: apresenta o fatorial de um número.")

  (def opcao (read))

  (cond 
    (= opcao 1) (println(eh_bissexto(read)))
    (= opcao 2) (println(eh_triangulo(read) (read) (read)))
    (= opcao 3) (println(tipo_triangulo(read) (read) (read)))
    (= opcao 4) (println(fatorial(read)))))

(main)
