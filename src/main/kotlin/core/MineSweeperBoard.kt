package core

import models.Cell
import kotlin.random.Random

class MineSweeperBoard(private val rows: Int, private val cols: Int, private val mines: Int) {
    val board = MutableList(rows) { MutableList(cols) { Cell.EMPTY } }

    init {
        require(mines <= rows * cols) { "The number of mines cannot be greater than the total number of cells." }
        placeMines()
    }

    private fun placeMines() {
        val random = Random.Default
        var minesToPlace = mines

        while (minesToPlace > 0) {
            val row = random.nextInt(rows)
            val col = random.nextInt(cols)

            if (board[row][col] != Cell.MINE) {
                board[row][col] = Cell.MINE
                minesToPlace--
            }
        }
    }
}