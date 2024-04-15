(defn quadrados-pares-rec [lista]
  (let [primeiro (first lista)]
    
    (if (empty? lista)
      '()
      (if (even? primeiro)
        (cons (* primeiro primeiro) (quadrados-pares-rec (rest lista)))
        (quadrados-pares-rec (rest lista))))))

(assert (= (quadrados-pares-rec [2 3 4]) '(4 16)))
(assert (= (quadrados-pares-rec [1 3 5]) '()))
(assert (= (quadrados-pares-rec [1 2]) '(4)))
(assert (= (quadrados-pares-rec []) '()))
