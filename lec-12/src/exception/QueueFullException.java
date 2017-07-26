package exception;

public class QueueFullException extends Exception{

	public QueueFullException()
	{
		super("Stack is full");
	}
}
