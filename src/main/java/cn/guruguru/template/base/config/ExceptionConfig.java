package cn.guruguru.template.base.config;


import cn.guruguru.template.base.exception.Ex;
import cn.guruguru.template.base.model.response.Rs;
import cn.guruguru.template.base.model.response.code.RCode;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.util.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

import java.util.stream.Collectors;

/**
 * Exception handler configuration
 *
 * @see <a href="https://stackoverflow.com/questions/60492383/how-to-create-spring-bean-of-type-restcontrolleradvice-in-spring-configuration">How to create spring @bean of type RestControllerAdvice in spring configuration class</a>
 */
@Configuration
public class ExceptionConfig {

    @RestControllerAdvice(annotations = {Controller.class, RestController.class})
    @Slf4j
    public static class CommonExceptionHandler {

        @Autowired
        private MessageSource messageSource;

        /**
         * 处理 {@code @RequestParam} 和 {@code @PathVariable} 注解的基本类型参数的验证异常
         *
         * @param ex a {@link ConstraintViolationException}
         * @return a {@link Rs}
         */
        @ExceptionHandler
        @ResponseStatus(HttpStatus.BAD_REQUEST)
        public Rs<Object> handleConstraintViolationException(ConstraintViolationException ex) {
            log.trace("Caused a ConstraintViolationException.");
            String message =
                    ex.getConstraintViolations().stream()
                            .map(
                                    v ->
                                            splitField(v.getPropertyPath().toString())
                                                    + ": "
                                                    + v.getMessage())
                            .collect(Collectors.joining("; "));
            return Rs.exception(RCode.CODE400, message);
        }

        /**
         * 处理表单数据异常，其请求头的 Content-Type 为 {@code MediaType.APPLICATION_FORM_URLENCODED_VALUE}.
         *
         * <p>示例：{@code method(@Valid UserDto userDto)}
         *
         * @param ex BindException
         * @return a {@link Rs}
         */
        @ExceptionHandler(value = BindException.class)
        @ResponseStatus(HttpStatus.BAD_REQUEST)
        public Rs<Object> handleBindException(BindException ex) {
            log.trace("Caused a BindException.");
            String message =
                    ex.getBindingResult().getFieldErrors().stream()
                            .map(err -> err.getField() + ": " + err.getDefaultMessage())
                            .collect(Collectors.joining("; "));
            return Rs.exception(RCode.CODE400, message);
        }

        /**
         * 处理 {@code @RequestBody} 注解的方法参数的验证异常
         *
         * @param ex MethodArgumentNotValidException
         * @return a {@link Rs}
         */
        @ExceptionHandler
        @ResponseStatus(HttpStatus.BAD_REQUEST)
        public Rs<Object> handleMethodArgumentNotValidException(
                MethodArgumentNotValidException ex) {
            String message =
                    ex.getBindingResult().getFieldErrors().stream()
                            .map(err -> err.getField() + ": " + err.getDefaultMessage())
                            .collect(Collectors.joining("; "));
            return Rs.exception(RCode.CODE400, message);
        }

        /**
         * 处理客户端请求错误，如 JSON 格式错误
         *
         * @param ex HttpMessageNotReadableException
         * @return a {@link Rs}
         */
        @ExceptionHandler(value = HttpMessageNotReadableException.class)
        @ResponseStatus(HttpStatus.BAD_REQUEST)
        public Rs<Object> handleHttpMessageNotReadableException(
                HttpMessageNotReadableException ex) {
            log.trace("Caused a HttpMessageNotReadableException.");
            String message = RCode.CODE400.getMessage() + ": " + ex.getMessage();
            return Rs.exception(RCode.CODE400, message);
        }

        /**
         * 处理 {@code @RequestParam(required = true)} 造成字段参数不存在的异常
         *
         * @param ex MissingServletRequestParameterException
         * @return a {@link Rs}
         */
        @ExceptionHandler(value = MissingServletRequestParameterException.class)
        @ResponseStatus(HttpStatus.BAD_REQUEST)
        public Rs<Object> handleMissingServletRequestParameterException(
                MissingServletRequestParameterException ex) {
            log.trace("Caused a MissingServletRequestParameterException.");
            String message = RCode.CODE400.getMessage() + ": " + ex.getMessage();
            return Rs.exception(RCode.CODE400, message);
        }

        /**
         * 处理验证异常
         *
         * @param ex ValidationException
         * @return a {@link Rs}
         */
        @ExceptionHandler(value = ValidationException.class)
        @ResponseStatus(HttpStatus.BAD_REQUEST)
        public Rs<Object> handleValidationException(ValidationException ex) {
            String message = RCode.VALIDATOR_ERROR.getMessage() + ": " + ex.getMessage();
            return Rs.exception(RCode.VALIDATOR_ERROR, message);
        }

        /**
         * 处理访问不存在的数据而触发的异常（EmptyResultDataAccessException）
         *
         * <p>JPA 在更新和删除记录之前先 SELECT 检查记录是否存在
         *
         * <p>查询操作可以访问 Optional，不会抛出该异常
         *
         * <p>以下操作会触发该异常：
         *
         * <ul>
         *   <li>删除不存在的记录
         *   <li>更新不存在的记录
         * </ul>
         *
         * @param ex a {@link EmptyResultDataAccessException}
         * @return a {@link Rs}
         */
        @ExceptionHandler(value = EmptyResultDataAccessException.class)
        @ResponseStatus(HttpStatus.NOT_FOUND)
        public Rs<Object> handleEmptyResultDataAccessException(
                EmptyResultDataAccessException ex) {
            return Rs.exception(RCode.NON_EXISTENT);
        }

        /**
         * 处理 {@link MethodArgumentTypeMismatchException} 异常
         *
         * <p>比如 /projects/{id}，要求 id 是 Long 类型，实际上传递了一个 '80s'
         *
         * <p>`@RequestParam() boolean contains`，其中 contains 是 Query String，此时如果 contains 填写的不是 true
         * 或 false（包括不填），都将抛出该异常
         *
         * @param ex a {@link MethodArgumentTypeMismatchException}
         * @return a {@link Rs}
         */
        @ExceptionHandler(MethodArgumentTypeMismatchException.class)
        @ResponseStatus(HttpStatus.BAD_REQUEST)
        public final Rs<Object> handleMethodArgumentTypeMismatchException(
                MethodArgumentTypeMismatchException ex) {
            log.trace("Caused a MethodArgumentTypeMismatchException.");
            return Rs.exception(RCode.ROUTE_FORMAT_ERROR);
        }

        /**
         * 处理通用的响应异常
         *
         * @param ex a {@link Ex}
         * @param response response
         * @return a {@link Rs}
         */
        @ExceptionHandler(value = Ex.class)
        public Rs<Object> handleRespException(Ex ex, HttpServletResponse response) {
            log.trace("Caused a RespException.");
            if (ex.getCode() <= HttpStatus.NETWORK_AUTHENTICATION_REQUIRED.value()) {
                response.setStatus(ex.getCode());
            }
            return Rs.exception(ex.getCode(), ex.getMessage());
        }

        /**
         * 根据 {@link ApiOperation} 注解统一处理未捕获的异常
         *
         * @param err Exception
         * @param handlerMethod a {@link HandlerMethod}
         * @return a {@link Rs}
         */
        @ExceptionHandler(value = Exception.class)
        @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
        public Rs<Object> handleUncaughtException(
                Exception err, HandlerMethod handlerMethod) {
            log.error(err.getMessage(), err);
            ApiOperation apiOperationAnnotation =
                    handlerMethod.getMethodAnnotation(ApiOperation.class);
            if (apiOperationAnnotation != null) {
                String annotationValue = apiOperationAnnotation.value();
                if (annotationValue != null && !annotationValue.isEmpty()) {
                    String message = annotationValue + "错误";
                    return Rs.error(message);
                }
            }
            String message = RCode.CODE500.getMessage();
            return Rs.error(message);
        }

        // ~ utilities -----------------------------------

        /**
         * Splits field name.
         *
         * @param fieldWithMethodName {@code method.filed}
         */
        private String splitField(String fieldWithMethodName) {
            return String.valueOf(fieldWithMethodName).split("\\.")[1];
        }
    }
}
