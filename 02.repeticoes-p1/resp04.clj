(defn conta []
  (loop [valor 0]
    (println valor)
    (recur (+ 1 valor))))

(conta)
