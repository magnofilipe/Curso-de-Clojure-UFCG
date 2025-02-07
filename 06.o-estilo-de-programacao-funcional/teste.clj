(defn mensagem-padrao [jogador]
  (println (str "\nJogo da Velha"
                 "\nVez do jogador: " jogador
                 "\nDigite a linha e coluna que deseja jogar (31, por exemplo, significa linha 3, coluna 1)"
                 "\nou use 'qq' para sair do jogo.")))

(defn exibir-tabuleiro [board placar]
  (println "   ")
  (dotimes [i 3]
    (println (str "   " (nth (nth board i) 0) " │ "
                      (nth (nth board i) 1) " │ "
                      (nth (nth board i) 2) "  "))
    (if (< i 2) (println "  ───┼───┼─── ")))
  (println "   ")
  (println "Placar atual:")
  (doseq [[jogador vitorias] placar]
    (println (str jogador ": " vitorias))))

(defn mensagem-posicao-entrada-invalida []
  (println "Posição ou entrada inválidas.\n"))

(defn mensagem-vencedor [jogador placar]
  (println (str "Jogador " jogador " venceu!")))

(defn mensagem-empate []
  (println ("\nEmpate!")))

(defn mensagem-posicao-ocupada []
  (println("\nEsta posição já está ocupada. Tente novamente.")))

(defn escolher-posicao []
  (let [entrada (read)]

    (if (= entrada "qq")
      (System/exit 0)
      (if (not= (count entrada) 2)
        (escolher-posicao)
        [(.charAt entrada 0) (.charAt entrada 1)]))))

(escolher-posicao)
