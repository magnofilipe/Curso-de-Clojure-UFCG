(defn soma-quadrados [lista]
  (reduce + (map (fn [n] (* n n)) lista)))

(assert (= (soma-quadrados [1 2 3 4]) 30))
(assert (= (soma-quadrados []) 0))
