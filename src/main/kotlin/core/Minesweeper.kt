package core

import models.*
import utils.countCellsDiscovered
import utils.getCoordinates
import utils.isValidInput

class Minesweeper(private val game: Game, private val english: Boolean = true) {

    private val numberOfSaveCells = (game.boardRows * game.boardColumns) - game.numberOfMines

    private val board: MutableList<MutableList<Cell>> =
        MineSweeperBoard(game.boardRows, game.boardColumns, game.numberOfMines).board

    init {
        Draw.drawNumbersOnBoard(board)
    }

    private fun reRenderBoard(
        board: MutableList<MutableList<Cell>>,
        screen: MutableList<MutableList<Cell>>,
        row: Int,
        col: Int
    ) {
        val cell = board[row][col]

        if (cell == Cell.MINE) {
            screen[row][col] = cell
            game.state = GameState.DEFEAT
            return
        }

        if (cell == Cell.EMPTY && screen[row][col] != Cell.EMPTY) {
            screen[row][col] = cell
            // Check the eight adjacent boxes.
            for (x in row - 1..row + 1) {
                for (y in col - 1..col + 1) {
                    if (x >= 0 && x < board.size && y >= 0 && y < board[0].size) {
                        if (screen[x][y] != Cell.EMPTY) {
                            reRenderBoard(board, screen, x, y)
                        }
                    }
                }
            }
        } else {
            screen[row][col] = cell
        }
    }

    fun play() {
        val output = OutputMessage(game.player, english)
        val gameScreen = Draw.generateGameScreen(game.boardRows, game.boardColumns)

        mainLoop@ while (true) {

            Draw.printBoard(gameScreen)

            print(output.onUserInputValue)
            val choice = readln()

            if (isValidInput(choice)) {
                val coordinates = getCoordinates(choice)

                if (coordinates.second.first >= board.size || coordinates.second.second >= board[0].size) {
                    println(output.onOutOfRange)
                    continue@mainLoop
                }

                if (coordinates.first) {
                    Draw.drawMarkMine(gameScreen, coordinates.second.first, coordinates.second.second)
                } else {
                    reRenderBoard(board, gameScreen, coordinates.second.first, coordinates.second.second)
                    game.cellsDiscovered = countCellsDiscovered(gameScreen)
                }
            } else {
                println(output.onInvalidInput)
                continue@mainLoop
            }

            if (game.cellsDiscovered == numberOfSaveCells) {
                game.state = GameState.VICTORY
            }

            when (game.state) {
                GameState.DEFEAT -> {
                    Draw.printBoard(gameScreen)
                    println(output.onPlayerLose)
                    break@mainLoop
                }

                GameState.VICTORY -> {
                    println(output.onPlayerWin)
                    Draw.printBoard(board)
                    break@mainLoop
                }

                else -> continue
            }

        }
    }
}