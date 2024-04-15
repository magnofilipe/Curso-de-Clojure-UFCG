(defn calcula_delta [a b c] (- (Math/pow b 2) (* 4 a c)))

(defn raizes []
  (def a (read))
  (def b (read))
  (def c (read))

  (def delta (calcula_delta a b c))

  (cond
    (> delta 0) (do
                  (def raiz1 (/ (+ (- b) (Math/sqrt delta)) (* 2 a)))
                  (def raiz2 (/ (- (- b) (Math/sqrt delta)) (* 2 a)))
                  (println "Raiz 1:" raiz1)
                  (println "Raiz 2:" raiz2))
    
    (= delta 0) (do
                  (def raiz (/ (- (- b) (Math/sqrt delta)) (* 2 a)))
                  (println "Raiz 1:" raiz))
    
    :else (println "Sem raizes.")))

(println(raizes))
