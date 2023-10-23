package models

enum class Command(val dir: String) {
    CHECK("-check"),
    UNCHECK("-uncheck"),
    COMMANDS("-commands");

    companion object {
        fun getCommandFromValue(value: String): Command? {
            return entries.find { it.dir == value }
        }
    }
}