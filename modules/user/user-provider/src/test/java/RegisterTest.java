import com.bjike.reborn.common.api.exception.SerException;
import com.bjike.reborn.user.service.UserRegisterSer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import user_common_code.AppConfig;

/**
 * 用户注册业务测试
 *
 * @Author: [liguiqin]
 * @Date: [2016-11-23 15:47]
 * @Description: []
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class RegisterTest {

    /**
     * 基础增删改查，批量操作等
     */

    private UserRegisterSer userRegisterAPI;


    @Test
    public void existUsername() throws SerException {
        boolean users = userRegisterAPI.existUsername("liguiqin");
        System.out.println(users);
    }

    @Test
    public void sendCodeToPhone() throws SerException {
        String phone = "123456";
        userRegisterAPI.verifyAndSendCode(phone);
    }


}
