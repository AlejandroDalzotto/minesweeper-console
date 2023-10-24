import core.Minesweeper
import utils.beginning
import utils.setNewGame

fun main() {
    beginning()

    val game = setNewGame()
    val minesweeper = Minesweeper(game)

    minesweeper.play()
}