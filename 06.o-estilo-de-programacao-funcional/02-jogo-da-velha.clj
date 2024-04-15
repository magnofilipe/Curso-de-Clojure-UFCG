; Funções impuras primeiro.

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

(defn mensagem-vencedor [jogador] 
  (println (str "Jogador " jogador " venceu!")))

(defn mensagem-empate []
  (println ("\nEmpate!")))

(defn mensagem-posicao-ocupada []
  (println ("\nEsta posição já está ocupada. Tente novamente.")))

(defn escolher-posicao []
  (let [entrada (read-line)]
    (if (= entrada "qq")
      [nil nil]
      (if (or (not= (count entrada) 2) (not (every? #(Character/isDigit %) entrada)))
        (do
          (mensagem-posicao-entrada-invalida)
          (escolher-posicao))
        (let [linha (- (Character/getNumericValue (.charAt entrada 0)) 1)
              coluna (- (Character/getNumericValue (.charAt entrada 1)) 1)]
          (if (and (>= linha 0) (< linha 3) (>= coluna 0) (< coluna 3))
            [linha coluna]
            (do
              (mensagem-posicao-entrada-invalida)
              (escolher-posicao))))))))

(defn jogada [board jogador-atual linha coluna]
  (if (= (nth (nth board linha) coluna) \space)
    (assoc-in board [linha coluna] jogador-atual)
    (do
      (mensagem-posicao-ocupada)
      (let [[linha coluna] (escolher-posicao)]
        (jogada board jogador-atual linha coluna)))))

(defn verificar-vitoria [board jogador]
  (let [vitoria? (fn [linha] (every? #(= jogador %) linha))
        diagonais [(map #(get-in board [% %]) (range 3))
                   (map #(get-in board [% (- 2 %)]) (range 3))]
        linhas (concat board (map #(vec %) (apply map vector board)))
        vitorias (concat linhas diagonais)]
    (some vitoria? vitorias)))

(defn verificar-empate [board]
  (not-any? #{\space} (flatten board)))

(defn jogo-da-velha []
  (let [initial-board (vec (repeat 3 (vec (repeat 3 \space))))
        jogador-atual \X
        proximo-jogador \O
        placar {\X 0, \O 0, "Empates" 0}]
    (loop [board initial-board
           jogador-atual jogador-atual]
      (mensagem-padrao jogador-atual)
      (exibir-tabuleiro board placar)
      (let [[linha coluna] (escolher-posicao)]
        (if (and (nil? linha) (nil? coluna))
          (System/exit 0)
          (let [new-board (jogada board jogador-atual linha coluna)
                new-jogador (if (= jogador-atual \X) \O \X)] ;; Alternando os jogadores
            (if (verificar-vitoria new-board jogador-atual)
              (do
                (mensagem-vencedor jogador-atual)
                (recur initial-board jogador-atual))
              (if (verificar-empate new-board)
                (do
                  (mensagem-empate)
                  (recur initial-board new-jogador))
                (recur new-board new-jogador)))))))))

(jogo-da-velha)
