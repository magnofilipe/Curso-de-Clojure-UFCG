(defn soma-quadrados-de-pares [sequencia]
  (reduce +
    (map (fn [x] (* x x))
      (filter even? sequencia))))

(assert (= (soma-quadrados-de-pares [1 2 3 4 5 6]) 56))
(assert (= (soma-quadrados-de-pares []) 0))
(assert (= (soma-quadrados-de-pares [2 3]) 4))
(assert (= (soma-quadrados-de-pares [6]) 36))
(assert (= (soma-quadrados-de-pares [1 3 5]) 0))
