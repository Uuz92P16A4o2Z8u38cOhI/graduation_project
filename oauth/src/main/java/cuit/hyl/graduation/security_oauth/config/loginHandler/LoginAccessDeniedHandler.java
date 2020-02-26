package cuit.hyl.graduation.security_oauth.config.loginHandler;

import com.alibaba.fastjson.JSON;
import cuit.hyl.graduation.security_oauth.common.utils.ResultUtils;
import cuit.hyl.graduation.security_oauth.entity.Result.ResponseResult;
import cuit.hyl.graduation.security_oauth.entity.Result.ResultCodeEnum;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 无权限
 */
@Configuration
public class LoginAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {

        ResponseResult<Object> result = ResultUtils.fail(ResultCodeEnum.UNAUTHORIZED);
        httpServletResponse.setCharacterEncoding("utf-8");
        httpServletResponse.setContentType("application/json;charset=utf-8");
        httpServletResponse.getWriter().write(JSON.toJSONString(result));
    }
}
