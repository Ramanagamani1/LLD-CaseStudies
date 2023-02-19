package exceptions;

public class EmptyMovesUndoOperationException extends Exception {

    public EmptyMovesUndoOperationException() {
        super("There are no moves to perform an undo operation");
    }
}
