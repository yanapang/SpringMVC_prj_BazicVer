package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class LogTestController {

    //private final Logger log = LoggerFactory.getLogger(getClass());
    //getClass() 대신 클래스명.class로 써도 동일함.
    //내 클래스 지정.
    //@Slf4j사용시 동일하게 작동.

    @RequestMapping("/log-test")
    public String logTest(){
        String name = "Spring";

        System.out.println("name = " + name); //name = Spring

        //log로 출력해야 현 시간, 로그 타입, 하위 로그 레벨 등 모두 확인 가능.

        /* 로그 정보 출력 시작 */
        log.trace("trace log={}", name);
        log.debug("debug log={}", name); //debug용 로그. 개발서버용.
        log.info("info log={}", name); //운영시스템에서도 볼 비즈니스 정보 등.
        log.warn("warn log={}", name); //경고
        log.error("error log={}", name); //{}, name 값으로 대체됨.
        /* 로그 정보 출력 끝 */

        //로그 선언 방식 3가지.
        //private Logger log = LoggerFactory.getLogger(getClass());
        //private static final Logger log = LoggerFactory.getLogger(XXX.class);
        //@Slf4j : 롬복으로도 사용가능.

        //log.warn("warn log={}", name); //경고
        //log.warn("warn log=" + name); //경고
        //위 두방식은 동일한 결과를 나타내는듯 보이지만, 아래의 경우 application.properties의 설정과 상관없이
        //일단 값을 대치해서 넣어놓고(연산을 다 처리 후에) 출력이 안되는 형식이다.
        //쓸데 없이 리소스를 헛사용하게 되므로, 위의 {}를 사용하는 방식이 자원을 아낄 수 있어 권장됨.

        return "ok";
    }
}
