package hackable.rest;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by shaun on 07/11/15.
 */
@org.springframework.web.bind.annotation.RestController
public class RestController {

    private Logger logger = LoggerFactory.getLogger(RestController.class);

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler({Throwable.class})
    private String handleThrowable(HttpServletRequest req, Exception ex) {
        logger.info("forbidden");
        return "wrong";
    }

    @RequestMapping(value="/login",method= RequestMethod.POST,consumes = "application/json",produces = "text/plain")
    public String login(@RequestBody Creds creds) {
        logger.info("login={}",creds.toString());
        if(!("admin".equals(creds.getName()) && "1234".equals(creds.getPass()))) {
            throw new RuntimeException();
        }
        return "right";
    }

    @RequestMapping(value="/opendoor",method= RequestMethod.GET,produces = "text/plain")
    public String opendoor(@RequestParam String name, @RequestParam String pass) {
        logger.info("opendoor=name:'{}'; pass:'{}'",name,pass);
        if(!("admin".equals(name) && "1234".equals(pass))) {
            throw new RuntimeException();
        }
        return "right";
    }
}
