
package utils.thread.task;

/**
 * A Task represents a class that can be attatched as what A TThread runs
 */
public abstract class Task
{

    protected boolean enabled = true;

    /**
     * perform() gets called iterably by the TThread
     */
    public abstract void perform();

    public void setEnabled(boolean enabled)
    {
        this.enabled = enabled;
    }

    public boolean isEnabled()
    {
        return enabled;
    }

}
