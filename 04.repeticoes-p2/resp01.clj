(defn quadrados [lista]
  (map (fn [n] (* n n)) lista))

(assert (= (quadrados [1 2 3 4 5]) [1 4 9 16 25]))
(assert (= (quadrados [2]) [4]))
(assert (= (quadrados []) []))
(assert (= (quadrados '(1 2 3 4 5)) '(1 4 9 16 25)))
