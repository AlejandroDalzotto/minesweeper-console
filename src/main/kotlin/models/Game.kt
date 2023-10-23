package models

enum class GameState {
    PLAYING,
    DEFEAT,
    VICTORY
}

class Game(
    val player: String = "Unknown",
    val boardRows: Int = 10,
    val boardColumns: Int = 10,
    val numberOfMines: Int = 10,
    var cellsDiscovered: Int = 0,
    var state: GameState = GameState.PLAYING
)