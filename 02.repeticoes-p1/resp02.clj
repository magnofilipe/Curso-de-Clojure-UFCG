; Precisamos de duas funções porque isso facilita a compreensão do código - haja vista a necessidade
; de um olhar mais clínico para entender recursão - e modulariza nosso programa, o que nos ajuda
; a reutilizar o código.

(defn conta-rec [valor]
    (println valor)
    (conta-rec (+ 1 valor)))

(defn conta []
  (conta-rec 0))

(conta)
