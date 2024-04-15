(defn conta
  ([] (println (conta 0)))
  ([valor] (println valor)
   (println (conta (+ 1 valor)))))

(conta)
