package com.cssl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cssl.pojo.StudentInfo;
import com.cssl.pojo.Users;
import com.cssl.service.StudentInfoService;
import com.cssl.service.UsersService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Serializable;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisplusApplicationTests {

    @Autowired
    private UsersService usersService;
    @Test
    public void contextLoads() {
        //查询
        Users users = new Users();
        users.setUser_Uname("GG");
        //System.out.println(usersService.insert(users));
        /*
        * update ("需要修改的对象",指定修改规则)
        * */
        /*System.out.println(usersService.update(users,
                new QueryWrapper<Users>().eq("user_uid","1")
                ));*/
        /*System.out.println(usersService.delete(
                new QueryWrapper<Users>().eq("user_uid","1")
        ));*/
        //查询总数据量 可以带参数
        /*System.out.println(usersService.selectCount(
                null
        ));*/

        List<Users> user_uid = usersService.selectList(
                new QueryWrapper<Users>().in("user_uid", 2, 3)
        );

        user_uid.forEach(i -> System.out.println(i));


    }

}
