package cuit.hyl.graduation.security_oauth.config.loginHandler;

import com.alibaba.fastjson.JSON;
import cuit.hyl.graduation.security_oauth.common.utils.ResultUtils;
import cuit.hyl.graduation.security_oauth.entity.Result.ResponseResult;
import cuit.hyl.graduation.security_oauth.entity.Result.ResultCodeEnum;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录失败
 */
@Configuration
public class LoginAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {

        ResponseResult<Object> result = ResultUtils.fail(ResultCodeEnum.LOGIN_FAIL);
        httpServletResponse.setCharacterEncoding("utf-8");
        httpServletResponse.setContentType("application/json;charset=utf-8");
        httpServletResponse.getWriter().write(JSON.toJSONString(result));
    }
}
