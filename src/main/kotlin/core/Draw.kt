package core

import models.Cell
import utils.countAdjacentMines

class Draw {

    companion object {

        fun drawMarkMine(screen: MutableList<MutableList<Cell>>, row: Int, col: Int) {
            screen[row][col] = Cell.MARK
        }

        fun generateGameScreen(rows: Int, cols: Int): MutableList<MutableList<Cell>> {
            val screen: MutableList<MutableList<Cell>> = mutableListOf()
            for (i in 1..rows) {

                val newRow = mutableListOf<Cell>()

                for (j in 1..cols) {
                    newRow.add(Cell.DEFAULT)
                }

                screen.add(newRow)
            }
            return screen
        }

        fun printBoard(board: MutableList<MutableList<Cell>>) {

            board.forEachIndexed { index, row ->
                row.forEach { col ->
                    print(col.dir)
                }
                println("| $index")
            }
        }

        fun drawNumbersOnBoard(board: MutableList<MutableList<Cell>>) {
            for (row in 0..<board.size) {
                for (col in 0..<board[row].size) {
                    val box = board[row][col]

                    // If the box is a mine, we don't need to draw a number on it.
                    if (box == Cell.MINE) {
                        continue
                    }

                    // Count the number of mines adjacent to the box.
                    val mineCount = countAdjacentMines(board, row, col)

                    // Draw the number on the box.
                    board[row][col] = mineCount
                }
            }
        }
    }
}