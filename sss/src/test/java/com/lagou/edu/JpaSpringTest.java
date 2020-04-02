package com.lagou.edu;

import com.lagou.edu.dao.ResumeDao;
import com.lagou.edu.pojo.Resume;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:application*.xml"})
public class JpaSpringTest {

    // 希望测试ioc容器中的哪个对象你注入即可。
    @Autowired
    private ResumeDao resumeDao;

    @Test
    public void testJpaSpring() {
        List<Resume> resumes = resumeDao.findAll();
        for (int i = 0; i < resumes.size(); i++) {
            Resume resume = resumes.get(i);
            System.out.println(resume);
        }
    }
}
