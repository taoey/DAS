package pagehelper;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.junit.Test;

public class PageHelperTest {

    @Test
    public void test00(){
        Page<Object> objects = PageHelper.startPage(1, 2);
        objects.getTotal();
        objects.getResult();
    }
}
