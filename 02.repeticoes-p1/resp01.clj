; A ausência de uma condição de parada faz com que as repetições ocorram indefinidamente.
; Para resolver isto, precisamos escrever condições de forma que o algoritmo encerre corretamente.

(defn msg-rec [string]
  (println string)
  (msg-rec string))

(msg-rec (read))
