package iwhale.zuulweb.test;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpServletRequest;

public class AccessFilter  extends ZuulFilter {

    private static Logger log=LoggerFactory.getLogger(AccessFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx=RequestContext.getCurrentContext();
        HttpServletRequest request=ctx.getRequest();
        log.info("send{} request to {}",request.getMethod(),request.getRequestURL().toString());

        Object accessToken=request.getParameter("accessToken");
        if(accessToken==null){
            log.warn("access token is empty");
            ctx.setSendZuulResponse(false);//另zuul过滤该请求，不对其进行路由
            ctx.setResponseStatusCode(401);//设置返回的错误码
            return null;
        }
        log.info("access token ok");
        return null;
    }
}
