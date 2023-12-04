package hello.exception.resolver;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Slf4j
public class MyHandlerExceptionResolver implements HandlerExceptionResolver {


    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        try {
            if(ex instanceof IllegalArgumentException){
                log.info("IllegalArgumentException resolver to 400");
                response.sendError(HttpServletResponse.SC_BAD_REQUEST,ex.getMessage()); // 오류바꾸기
                //response.getWriter().println("{status : fail}"); // 메세지를 그대로 던진다, 직접 json 데이터를 만들어도 된다.
                return new ModelAndView(); //새로운 모델앤뷰(빈값)으로 넘기면 정상적으로 에외가 리턴이 된다.
            }
        } catch (IOException e) {
            log.error("resolver ex",e);
        }

        return null;
    }
}
