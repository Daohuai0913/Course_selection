import com.gok.daohuai.mapper.TeacherMapper;
import com.gok.daohuai.pojo.Teacher;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Test {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        sqlSession.getMapper(TeacherMapper.class).insertTeacher("zhaoliu", "123", "6个6", "男", 1);

        sqlSession.getMapper(TeacherMapper.class).insertClass("语文", 10, 0, 1, "语文课程");

    }
}

