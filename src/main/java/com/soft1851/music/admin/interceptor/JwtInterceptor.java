//package com.soft1851.music.admin.interceptor;
//
//import com.soft1851.music.admin.common.ResultCode;
//import com.soft1851.music.admin.exception.CustomException;
//import com.soft1851.music.admin.exception.JwtException;
//import com.soft1851.music.admin.service.SysAdminService;
//import com.soft1851.music.admin.util.JwtTokenUtil;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * @ClassName JwtInterceptor
// * @Description Jwt拦截器
// * @Author mq_xu
// * @Date 2020/4/15
// * @Version 1.0
// */
//@Slf4j
//@Component
//public class JwtInterceptor implements HandlerInterceptor {
//    @Resource
//    private SysAdminService sysAdminService;
//
//    /**
//     * 前置处理，拦截请求
//     *
//     * @param request
//     * @param response
//     * @param handler
//     * @return boolean
//     * @throws Exception
//     */
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        String token = request.getHeader("Authorization");
//        //认证
//        if (token == null) {
//            log.info("### 用户未登录，请先登录 ###");
//            //通过自定义异常抛出未登录的信息，由全局统一处理
//            throw new CustomException("用户未登录，请先登录", ResultCode.USER_NOT_SIGN_IN);
//        } else {
//            //已经登录
//            log.info("## token= {}", token);
//            //从token中解析出roles
//            String adminId = JwtTokenUtil.getAdminId(token);
//            String roles = JwtTokenUtil.getRoles(token);
//            //从request中取得客户端传输的roleId，到roles中查找比对，此部分代码在SysRoleService服务中
//
//            if (!adminService.checkRole(JwtTokenUtil.getUserRole(token))) {
//                log.info("### 用户权限不足 ###");
//                //通过自定义异常抛出权限不足的信息，由全局统一处理
//                throw new CustomException("用户权限不足", ResultCode.PERMISSION_NO_ACCESS);
//            } else {
//                return  true;
////                if (JwtTokenUtil.isExpiration(token)) {
////                    log.info("### token已失效 ###");
////                    //抛出InvalidClaimException，由全局统一处理
//////                    throw new InvalidClaimException("Token已失效");
////                } else {
////                    //之前的拦截全部通过，放行到controller层调用接口
////                    return true;
////                }
//            }
//        }
//    }
//}
