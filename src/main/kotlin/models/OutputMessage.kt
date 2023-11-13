package models

class OutputMessage(player: String = "Unknown", english: Boolean = true) {

    val onInvalidInput =
        if (english) "Invalid input, try again (Example input: 2x3)"
        else "Entrada invalida, intentalo de nuevo (Ejemplo de entrada: 2x3)"

    val onPlayerLose =
        if (english) "🟥🟥🟥 You lose, thanks for playing 🟥🟥🟥"
        else "🟥🟥🟥 Has perdido, gracias por jugar 🟥🟥🟥"

    val onPlayerWin =
        if (english) "🟩🟩🟩 Congratulations $player, you win!! 🟩🟩🟩"
        else "🟩🟩🟩 Felicidades $player, has ganado!! 🟩🟩🟩"

    val onOutOfRange =
        if (english) "Coordinates are out of range, try again"
        else "Las coordenadas están fuera de rango, inténtalo de nuevo"

    val onUserInputName =
        if (english) "Enter a username: "
        else "Ingresa un nombre de usuario: "

    val onUserInputRows =
        if (english) "Enter the number of rows on the board: "
        else "Ingresa la cantidad de filas del tablero: "

    val onUserInputColumn =
        if (english) "Enter the number of columns on the board: "
        else "Ingresa la cantidad de columnas del tablero: "

    val onUserInputMines =
        if (english) "Enter the number of mines: "
        else "Ingresa la cantidad de minas: "

    val onUserInputValue =
        if (english) "Enter row and column (e.g., 1x2): "
        else "Ingresa la fila y columna (Ejemplo, 1x2): "
}