package study.aop.exam;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import study.aop.exam.aop.RetryAspect;
import study.aop.exam.aop.TraceAspect;

import static org.junit.jupiter.api.Assertions.*;

//@Import(TraceAspect.class)
@Import({TraceAspect.class, RetryAspect.class})
@SpringBootTest
class ExamTest {
    @Autowired
    ExamService examService;

    @Test
    void test() {
        for (int i = 0; i < 5; i++) {
            examService.request("data" + i);
        }
    }
}