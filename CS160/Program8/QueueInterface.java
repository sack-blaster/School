/**
 *  Program 8
 *  This program is a queue interface
 *  CS160-1001
 *  6/20/24
 *  @author  Jacob Archer
  */

public interface QueueInterface { 
  public boolean enQueue(Integer value);
  public Integer deQueue();
  public Integer peek();
  public boolean isEmpty();
}
