package utils

import models.Cell
import models.Game
import models.OutputMessage

fun setNewGame(): Game {

    val output = OutputMessage()

    println(output.onUserInputName)
    val player = readln()

    println(output.onUserInputRows)
    val rows = readln().toInt()

    println(output.onUserInputColumn)
    val cols = readln().toInt()

    println(output.onUserInputMines)
    val mines = readln().toInt()

    return Game(player, rows, cols, mines)
}
fun beginning() {

    val keyWords = arrayOf("Welcome", "to Minesweeper", "in console")

    keyWords.forEach {

        val remainingLength = (45 - it.length) / 2
        println("*" + "-".repeat(remainingLength) + " $it " + "-".repeat(remainingLength) + "*")
    }
}

fun isValidInput(value: String): Boolean {
    val regex = Regex("""^\d+x\d+(\s+-mark)?$""")
    return regex.matches(value)
}

fun getCoordinates(value: String): Pair<Boolean, Pair<Int, Int>> {
    val regex = Regex("""^(\d+)x(\d+)(\s+-mark)?$""")
    val matchResult = regex.find(value)
    if (matchResult != null) {
        val (row, col, mark) = matchResult.destructured
        return if (mark.isNotEmpty()) Pair(true, Pair(row.toInt(), col.toInt()))
        else Pair(
            false, Pair(row.toInt(), col.toInt())
        )
    } else {
        throw IllegalArgumentException("Input no válido")
    }
}

fun countAdjacentMines(board: List<List<Cell>>, row: Int, col: Int): Cell {
    var mineCount = 0

    // Check the eight adjacent boxes.
    for (x in row - 1..row + 1) {
        for (y in col - 1..col + 1) {
            if (x >= 0 && x < board.size && y >= 0 && y < board[0].size) {
                val adjacentBox = board[x][y]

                if (adjacentBox == Cell.MINE) {
                    mineCount++
                }
            }
        }
    }

    return when (mineCount) {
        in 1..8 -> Cell.entries[mineCount - 1]
        else -> Cell.EMPTY
    }
}

fun countCellsDiscovered(board: List<List<Cell>>): Int {
    val boardSize = board.size * board[0].size

    var undiscoveredCells = 0

    board.forEach { row ->
        undiscoveredCells += row.count { it == Cell.DEFAULT || it == Cell.MARK }
    }
    return boardSize - undiscoveredCells
}