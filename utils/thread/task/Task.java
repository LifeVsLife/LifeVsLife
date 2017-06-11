
package utils.thread.task;

/**
 * The Task interface represents a class that can be attatched as what A TThread runs
 */
public interface Task {

    /**
     * perform() gets called iterably by the TThread
     */
    abstract public void perform() throws Exception;

}
