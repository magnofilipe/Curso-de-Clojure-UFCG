# Antes de tudo, vamos isolar todas as funções com impurezas relacionadas a saídas.

def mensagem_padrao(jogador):
    print(f'\nJogo da Velha - Python Funcional\
    \nVez do jogador: {jogador}.\
    \nDigite a linha e coluna que deseja jogar (31, por exemplo, significa linha 3, coluna 1)\
    \nou use "qq" para sair do jogo.')

def exibir_tabuleiro(board, placar):
    print("   ")
    for i in range(3):
        print(f"   {board[i][0]} │ {board[i][1]} │ {board[i][2]}  ")
        if i < 2:
            print("  ───┼───┼─── ")
    print("   ")

    print("Placar atual:")
    for jogador, vitorias in placar.items():
        print(f"{jogador}: {vitorias}")

def mensagem_posicao_entrada_invalida():
    print("\nPosição ou entrada inválidas.")

def mensagem_vencedor(jogador):
    print(f'\nJogador {jogador} venceu!')

def mensagem_empate():
    print("\nEmpate!")

def mensagem_posicao_ocupada():
    print("\nEsta posição já está ocupada. Tente novamente.")

# Este é o único momento em que há entrada de dados pelo usuário.
# Daqui pra frente, tudo que há são tratamentos desta entrada e
# verificações (se houve vitória, por exemplo).

def escolher_posicao():
    entrada = input("\n")
 
    if entrada == "qq":
        return None, None
    
    if len(entrada) != 2 or not entrada.isnumeric():
        mensagem_posicao_entrada_invalida()
        return escolher_posicao()

    linha = int(entrada[0])
    coluna = int(entrada[1])

    if linha not in [1, 2, 3] or coluna not in [1, 2, 3]:
        mensagem_posicao_entrada_invalida()
        return escolher_posicao()

    return linha, coluna

def jogada(board, jogador_atual, linha, coluna):
    if board[linha - 1][coluna - 1] == ' ':
        board[linha - 1][coluna - 1] = jogador_atual
    else:
        mensagem_posicao_ocupada()
        linha, coluna = escolher_posicao()
        jogada(board, jogador_atual, linha, coluna)

def verificar_vitoria(board, jogador):
    resultado = False

    for linha in board:
        if all(cell == jogador for cell in linha):
            resultado = True

    for coluna in range(3):
        if all(board[linha][coluna] == jogador for linha in range(3)):
            resultado = True

    # Verificando diagonais
    if all(board[i][i] == jogador for i in range(3)) or all(board[i][2-i] == jogador for i in range(3)):
        resultado = True

    return resultado

def verificar_empate(board):
    resultado = True
    for linha in board:
        if ' ' in linha:
            resultado = False
    return resultado

def jogo_da_velha():
    board = [[' ' for i in range(3)] for j in range(3)]
    jogador_atual = 'X'
    proximo_jogador = 'O'
    placar = {'X': 0, 'O': 0, 'Empates': 0}

    while True:
        mensagem_padrao(jogador_atual)
        exibir_tabuleiro(board, placar)
        linha, coluna = escolher_posicao()
        if linha is None or coluna is None:
            break
        jogada(board, jogador_atual, linha, coluna)
        if verificar_vitoria(board, jogador_atual):
            mensagem_vencedor(jogador_atual)
            placar[jogador_atual] += 1
            board = [[' ' for i in range(3)] for j in range(3)]
        elif verificar_empate(board):
            mensagem_empate()
            placar['Empates'] += 1
            board = [[' ' for i in range(3)] for j in range(3)]
        else:
            jogador_atual, proximo_jogador = proximo_jogador, jogador_atual

jogo_da_velha()

