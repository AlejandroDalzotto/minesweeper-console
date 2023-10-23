import core.Minesweeper
import models.Game

fun main() {
    val game = Game("Dlz", 5, 10, 5)
    val minesweeper = Minesweeper(game)

    minesweeper.play()
}