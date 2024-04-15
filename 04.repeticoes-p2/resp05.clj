(defn soma-quadrados [lista]
  (let [lista-quadrado (map (fn [n] (* n n)) lista)]
    (apply + lista-quadrado)))


(assert (= (soma-quadrados [1 2 3 4]) 30))
(assert (= (soma-quadrados []) 0))
(assert (= (soma-quadrados [2]) 4))
