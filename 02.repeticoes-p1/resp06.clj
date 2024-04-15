(defn conta [valor]
    (doseq [n (range (+ 1 valor))]
    (println n)))

(conta (read))
