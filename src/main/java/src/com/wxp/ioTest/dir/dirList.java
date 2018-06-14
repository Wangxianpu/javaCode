package src.com.wxp.ioTest.dir;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * 功能说明: <br>
 * 系统版本: 1.0 <br>
 * 开发人员: wangxp
 * 开发时间: 2018/1/8<br>
 * <br>
 */
public class dirList {
    public static void main(String[] args){
        File path = new File(".");
        String[] list;
        if(args.length==0){
            list = path.list();
        }else
            list = path.list(new DirFilter(args[0]));
        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
        for(String dirItem : list){
            System.out.println(dirItem);
        }
    }

}
class DirFilter implements FilenameFilter{

    private Pattern pattern;

    public DirFilter(String regex) {
        this.pattern = Pattern.compile(regex);
    }

    @Override
    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }
}
