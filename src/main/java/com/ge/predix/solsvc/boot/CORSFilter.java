package com.ge.predix.solsvc.boot;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


/**
 * CORS Filter.
 * @author 204069133
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CORSFilter implements Filter {
    /**
     * Base allowed headers.
     */
    private static final String[] BASE_ORIGIN_LIST = new String[] {"localhost:9000",
            "predix.com", "run.asv-pr.ice.predix.io", "run.aws-usw02-pr.ice.predix.io"};

    /**
     * Base allowed headers.
     */
    private static final String BASE_ALLOWED_HEADERS = "Origin,Accept,X-Requested-With,Content-Type,"
            + "Content-Disposition,Access-Control-Request-Method,Access-Control-Request-Headers,"
            + "Authorization,tenant";

    /**
     * Base allowed methods.
     */
    private static final String BASE_ALLOWED_METHODS = "GET,POST,PUT,OPTIONS,HEAD";

    /**
     * Max age.
     */
    private static final String BASE_MAX_AGE = "3600";

    /**
     * Base allow credentials.
     */
    private static final String BASE_ALLOW_CREDENTIAL = "true";

    /**
     * Additional origin list.
     */
    @Value("${corsControlAdditionalAllowOrigin:}")
    private String addtionalOriginList;

    /**
     * Additional allowed headers.
     */
    @Value("${corsControlAdditionalAllowHeaders:}")
    private String addtionalAllowedHeaders;

    /**
     * Additional allowed methods.
     */
    @Value("${corsControlAdditionalAllowMethods:}")
    private String addtionalAllowedMethods;

    /**
     * set containing allowed origins.
     */
    private Set<String> allowedOrigins;

    /**
     * set containing allowed methods.
     */
    private Set<String> allowedMethods;

    @Override
    public void doFilter(final ServletRequest req, final ServletResponse res, final FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest request = (HttpServletRequest) req;
        String method = request.getMethod();

        String originHeader = request.getHeader("Origin");
//        log.info("originHeader::" + originHeader);
        boolean isOriginAllowed = isOriginAllowed(originHeader);
        if (isOriginAllowed) {
            response.setHeader("Access-Control-Allow-Origin", originHeader);
        }
        if (allowedMethods.contains(method)) {
            response.setHeader("Access-Control-Allow-Methods", concat(BASE_ALLOWED_METHODS, addtionalAllowedMethods));
        }
        response.setHeader("Access-Control-Max-Age", BASE_MAX_AGE);
        response.setHeader("Access-Control-Allow-Credentials", BASE_ALLOW_CREDENTIAL);
        response.setHeader("Access-Control-Allow-Headers", concat(BASE_ALLOWED_HEADERS, addtionalAllowedHeaders));

        if ("OPTIONS".equals(method)) {
            // logger.info("Bailing out for OPTIONS method with httpstatus.OK");
            response.setStatus(HttpStatus.OK.value());
        } else {
            chain.doFilter(req, res);
        }

    }

    /**
     * Concat method.
     * @param base of type string.
     * @param additional of type string.
     * @return of type string.
     */
    public String concat(final String base, final String additional) {
        StringBuilder sb = new StringBuilder();
        sb.append(base);
        if (additional.length() > 0) {
            sb.append(",").append(additional);
        }
        return sb.toString();
    }

    @Override
    public void init(final FilterConfig filterConfig) {
        /*
         * Adding allowed origins
         */
        allowedOrigins = new HashSet<>();
        allowedOrigins.addAll(Arrays.asList(BASE_ORIGIN_LIST));
        if (!StringUtils.isEmpty(addtionalOriginList)) {
            String[] additionalOriginList = addtionalOriginList.split(",");
            allowedOrigins.addAll(Arrays.asList(additionalOriginList));
        }

        /*
         * Adding allowed methods
         */
        allowedMethods = new HashSet<>();
        allowedMethods.addAll(Arrays.asList(BASE_ALLOWED_METHODS.split(",")));
        if (!StringUtils.isEmpty(addtionalAllowedMethods)) {
            String[] addtionalAllowedMethodsList = addtionalAllowedMethods.split(",");
            allowedMethods.addAll(Arrays.asList(addtionalAllowedMethodsList));
        }
    }

    /**
     * Method to check if the origin is from the allowed list of origins.
     * @param originHeader of type string.
     * @return boolean.
     */
    private boolean isOriginAllowed(final String originHeader) {
        //log.info("BASE_ORIGIN_LIST::" + BASE_ORIGIN_LIST);
       // log.info("allowedOrigins::" + allowedOrigins.toString());
       // log.info("originHeader::" + originHeader);
        boolean isOriginAllowed = false;
        if (!StringUtils.isEmpty(originHeader)) {
            isOriginAllowed = allowedOrigins.stream()
                    .anyMatch(org -> originHeader.matches(".*" + org) || originHeader.compareTo(org) == 0);
        }
       // log.info("******** IS_ORIGIN_ALLOWED::" + isOriginAllowed);
        return isOriginAllowed;
    }

    @Override
    public void destroy() {
        // Nothing special here
    }

}
