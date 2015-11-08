package hackable.form;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by shaun on 08/11/15.
 */
@Controller
public class FormController {

    private Logger logger = LoggerFactory.getLogger(FormController.class);

    @RequestMapping(value="/members", method=RequestMethod.GET)
    public String membersForm(Model model) {
        model.addAttribute("member", new Member());
        return "member";
    }

    @RequestMapping(value="/members", method=RequestMethod.POST)
    public String membersSubmit(@ModelAttribute Member member, Model model) {
        model.addAttribute("member", member);

        if("Fergus".equals(member.getName()) && "hotel".equals(member.getPass())) {
            logger.info("success: name={} pass={}",member.getName(),member.getPass());
            return "success";
        }

        logger.info("failure: name={} pass={}",member.getName(),member.getPass());
        return "failure";
    }
}
