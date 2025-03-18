package parser;

public enum TokenType {
    /**
     * Represents the "use" command.
     */
    USE,

    /**
     * Represents the "get" command.
     */
    GET,

    /**
     * Represents the "drop" command.
     */
    DROP,

    /**
     * Represents the "look" command.
     */
    LOOK,

    /**
     * Represents the "status" command.
     */
    STATUS,

    /**
     * Represents the "help" command.
     */
    HELP,

    /**
     * Represents the "quit" command.
     */
    QUIT,

    /**
     * Represents an error token, typically for invalid input.
     */
    ERROR,

    /**
     * Represents a variable or unclassified word.
     */
    VAR,

    /**
     * Represents the "move" command.
     */
    MOVE,

    /**
     * Represents a preposition such as "on", "with", or "using".
     */
    PREPOSITION,

    /**
     * Represents the end of a line or command.
     */
    EOL,

    TALK,

    COMBINE;

}
