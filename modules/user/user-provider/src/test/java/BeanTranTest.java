import com.alibaba.fastjson.JSON;
import com.bjike.reborn.common.utils.bean.BeanTransform;
import com.bjike.reborn.common.utils.date.DateUtil;
import com.bjike.reborn.user.bo.UserBO;
import com.bjike.reborn.user.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import user_common_code.AppConfig;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: [liguiqin]
 * @Date: [2017-03-02 15:03]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class BeanTranTest {
    // bo 转 entity (字符串时间转换成相应的时间类型LocalDateTime,DateTime,LocalDate)
    @Test
    public void BOTransformEntity() {
        UserBO bo = new UserBO();
//        bo.setCreateTime(DateUtil.dateToString(LocalDateTime.now()));
        bo.setUsername("liguiqin");
        User user = BeanTransform.copyProperties(bo, User.class, true);
        System.out.println(JSON.toJSONString(user));
    }

    public static void main(String[] args) {
        UserBO bo = new UserBO();
//        bo.setCreateTime(DateUtil.dateToString(LocalDateTime.now()));
        bo.setUsername("liguiqin");
        User user = BeanTransform.copyProperties(bo, User.class, true);
        System.out.println(JSON.toJSONString(user));
    }

    //  entity转  bo(LocalDateTime,DateTime,LocalDate时间类型转换成字符串类型)

    @Test
    public void EntityTransformBO() {
        User user = new User();
        user.setCreateTime(LocalDateTime.now());
        user.setUsername("liguiqin");

        //方式1
        UserBO bo = BeanTransform.copyProperties(user, UserBO.class);
        System.out.println(JSON.toJSONString(bo));

        //方式2
        UserBO bo2 =new UserBO();
        BeanTransform.copyProperties(user, bo2);
        System.out.println(JSON.toJSONString(bo2));
    }

    //  批量转换

    @Test
    public void TransformList() {
        User user1 = new User();
        user1.setCreateTime(LocalDateTime.now().plusDays(1));
        user1.setUsername("liguiqin1");

        User user2 = new User();
        user2.setCreateTime(LocalDateTime.now().plusDays(2));
        user2.setUsername("liguiqin2");

        List<User> users = Arrays.asList(user1, user2);
        List<UserBO> bos = BeanTransform.copyProperties(users, UserBO.class);
        System.out.println(JSON.toJSONString(bos));

    }
    @Test
    public void Transform() {
        UserBO userBO = new UserBO();
        userBO.setUsername("liguiqin1");

        UserBO userBO2 = new UserBO();
        userBO2.setUsername("liguiqin2");

        List<UserBO> userBOS = Arrays.asList(userBO, userBO2);
        List<User> users = BeanTransform.copyProperties(userBOS, User.class,true);
        System.out.println(JSON.toJSONString(users));

    }

}
