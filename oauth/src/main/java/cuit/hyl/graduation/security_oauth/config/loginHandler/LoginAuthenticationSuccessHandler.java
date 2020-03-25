package cuit.hyl.graduation.security_oauth.config.loginHandler;
import java.time.LocalDateTime;
import	java.util.HashMap;

import com.alibaba.fastjson.JSON;
import cuit.hyl.graduation.security_oauth.common.utils.ResultUtils;
import cuit.hyl.graduation.security_oauth.entity.Result.ResponseResult;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * 登录成功
 */
@Configuration
public class LoginAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {

        ResponseResult<Object> result = ResultUtils.success("登录成功!");
        Map map = new HashMap<String, Object>();
        map.put("loginTime",LocalDateTime.now());

        result.setData(map);
        httpServletResponse.setCharacterEncoding("utf-8");
        httpServletResponse.setContentType("application/json;charset=utf-8");
        httpServletResponse.getWriter().write(JSON.toJSONString(result));
    }
}
