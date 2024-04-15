(defn auxiliar-quadrados-rec [lista resultado]
  (let [primeiro (first lista)
        restante (rest lista)]

    (if (empty? restante)
      (cons (* primeiro primeiro) resultado)
      (auxiliar-quadrados-rec restante (cons (* primeiro primeiro) resultado)))))

(defn quadrados-rec [lista]
  (if (empty? lista)
    '()
    (reverse (auxiliar-quadrados-rec lista '()))))

(assert (= (quadrados-rec [1 2 3]) '(1 4 9)))
(assert (= (quadrados-rec []) '()))
(assert (= (quadrados-rec [2]) '(4)))
