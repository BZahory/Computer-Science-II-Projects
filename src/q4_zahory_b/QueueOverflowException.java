package q4_zahory_b;

public class QueueOverflowException extends RuntimeException
{
  public QueueOverflowException()
  {
    super();
  }

  public QueueOverflowException(String message)
  {
    super(message);
  }
}