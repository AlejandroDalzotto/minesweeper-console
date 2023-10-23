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

}