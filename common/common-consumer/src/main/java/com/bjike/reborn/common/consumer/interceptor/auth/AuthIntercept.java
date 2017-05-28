package com.bjike.reborn.common.consumer.interceptor.auth;

import com.bjike.reborn.common.api.exception.SerException;
import com.bjike.reborn.user.api.rbac.PermissionAPI;
import com.bjike.reborn.user.bo.rbac.PermissionAuthBO;
import com.bjike.reborn.user.bo.rbac.PermissionBO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 资源权限拦截
 *
 * @Author: [liguiqin]
 * @Date: [2017-04-15 09:34]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public class AuthIntercept extends HandlerInterceptorAdapter {

    private String[] excludes;

    private PermissionAPI permissionAPI;

    public AuthIntercept(PermissionAPI permissionAPI, String... excludes) {
        this.permissionAPI = permissionAPI;
        this.excludes = excludes;
    }

    public AuthIntercept(PermissionAPI permissionAPI) {
        this.permissionAPI = permissionAPI;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        boolean pass = false;
        if (null != excludes) {
            for (String exclude : excludes) { //过滤请求资源
                String last_suffix = StringUtils.substringAfterLast(exclude, "/");
                String pass_url = StringUtils.substringBeforeLast(uri, "/") + "/*";
                if (uri.endsWith(last_suffix) || exclude.equals(pass_url) || uri.equals(exclude)) {
                    pass = true;
                    break;
                }
            }
            if (pass) {
                return super.preHandle(request, response, handler);
            }
        }
        List<PermissionAuthBO> permissions = permissionAPI.currentPermissions();
        for (PermissionAuthBO per : permissions) {
            /**
             * url 完全相匹配
             */
            String resource = per.getResource();
            if (resource.equals(uri)) {
                return super.preHandle(request, response, handler);
            }
            /**
             * 权限资源没有子资源且前缀相匹配
             */
            String per_url = StringUtils.substringBeforeLast(resource, "/*");
            if (StringUtils.isNotBlank(per_url) && uri.indexOf(per_url) != -1) {
                pass = true;
                if (per.getHasChild()) { //如存在子资源,通配符*无效
                    pass = false;
                    for (PermissionAuthBO p : permissions) {
                        resource = p.getResource();
                        if (resource.equals(uri)) {//子资源匹配
                            pass = true;
                            break;
                        }
                        if (-1 != resource.lastIndexOf("/*")) {//子资源匹配
                            per_url = StringUtils.substringBeforeLast(resource, "/*");
                            if (StringUtils.isNotBlank(per_url) && uri.indexOf(per_url) != -1) {
                                pass = true;
                                break;
                            }
                        }

                    }
                    if (pass) {
                        break;
                    }
                }

            }
        }

        if (pass) {
            return super.preHandle(request, response, handler);
        }
        throw new SerException("该权限资源受限:" + uri);

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

}
