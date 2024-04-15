(require '[clojure.string :as str])

(def vogais #{"a" "e" "i" "o" "u" "A" "E" "I" "O" "U"})

(defn comeca-com-vogal [palavra]
  (let [primeira-letra (first palavra)]
    (contains? vogais (str primeira-letra))))

(defn ini-vogais [sequencia]
  (map str/lower-case (filter comeca-com-vogal sequencia)))

(assert (= (ini-vogais ["oi" "filipe"]) '("oi")))
(assert (= (ini-vogais ["Ana" "Daniel" "Filipe" "Cláudia"]) '("ana")))
(assert (= (ini-vogais ["Projeto" "NuFuturo"]) '()))
(assert (= (ini-vogais ["UFCG" "UASC" "CEEI"]) '("ufcg" "uasc")))

