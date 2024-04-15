(defn quadrados-pares [lista]
    (map (fn [n] (* n n)) (filter even? lista)))

(assert (= (quadrados-pares [1 2 3]) '(4)))
(assert (= (quadrados-pares []) '()))
(assert (= (quadrados-pares [5 15 19]) '()))
