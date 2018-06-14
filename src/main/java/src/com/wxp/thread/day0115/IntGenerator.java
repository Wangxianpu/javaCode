package src.com.wxp.thread.day0115;

/**
 * 功能说明: <br>
 * 系统版本: 1.0 <br>
 * 开发人员: wangxp
 * 开发时间: 2018/1/15<br>
 * <br>
 */
public abstract class IntGenerator {
    private volatile boolean canceled = false;
    public abstract int next();
    public void cancel(){
        canceled = true;
    }
    public boolean isCanceled(){
        return canceled;
    }
}
