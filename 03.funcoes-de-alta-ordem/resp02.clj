; Letra a)
(defn length [sequencia]
  (if (empty? sequencia)
    0
    (+ 1 (length (rest sequencia)))))

(assert (= (length [1 2 3 4 5]) 5))
(assert (= (length []) 0))
(assert (= (length ["Filipe" "Magno"]) 2))

; Letra b)
(defn value_at [i sequencia]
  (cond
    (= i 1) (first sequencia)
    (empty? sequencia) nil
    :else (value_at (- i 1) (rest sequencia))))

(assert (= (value_at 2 [2, 4, 6, 8]) 4))
(assert (= (value_at 3 []) nil))
(assert (= (value_at 6 [1 2 3]) nil))
(assert (= (value_at -1 [3, 5, 7]) nil))

; Letra c)
(defn index
  ([v sequencia i]
  (cond 
    (empty? sequencia) -1
    (= v (first sequencia)) i
    :else (index v (rest sequencia) (inc i))))
  
  ([v sequencia]
   (index v sequencia 0)))

(assert (= (index 2 [1 5 2]) 2))
(assert (= (index 5 [1 4 3]) -1))
(assert (= (index 3 []) -1))
(assert (= (index 10 [10 2 5 15]) 0))
(assert (= (index 4 [1 2 3 4]) 3))
(assert (= (index 7 [3 4 5 6]) -1))
(assert (= (index 8 [1 2 3 4 5]) -1))
