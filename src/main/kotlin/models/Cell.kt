package models

enum class Cell(val dir: String) {
    ONE("1️⃣"),
    TWO("2️⃣"),
    THREE("3️⃣"),
    FOUR("4️⃣"),
    FIVE("5️⃣"),
    SIX("6️⃣"),
    SEVEN("7️⃣"),
    EIGHT("8️⃣"),
    DEFAULT("⬜"),
    MARK("🟥"),
    EMPTY("🟦"),
    MINE("💣");

    companion object {
        fun isNumericCell(value: Cell): Boolean {
            val numericCells: Array<Cell> = arrayOf(ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT)
            return numericCells.contains(value)
        }
    }
}

