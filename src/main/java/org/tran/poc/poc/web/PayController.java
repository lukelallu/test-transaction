package org.tran.poc.poc.web;

import org.tran.poc.poc.dao.UserDao;
import org.tran.poc.poc.dao.TransAudit;
import org.tran.poc.poc.model.User;
import org.tran.poc.poc.util.MQListener;
import org.tran.poc.poc.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.gson.Gson;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;

@Controller
@RequestMapping(value = "/pay")
public class PayController {

    private final Logger slf4jLogger = LoggerFactory.getLogger(PayController.class);

    @Autowired
    private MQListener mqListener;

    @Autowired
    private UserDao userDao;



    @RequestMapping(method = RequestMethod.GET)
    public String viewPay(Map<String, Object> model) {
        User userForm = new User();

        model.put("userForm", userForm);


        return "Pay";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processPay(@ModelAttribute("userForm") User user,
                             Map<String, Object> model) {

        // implement your own Pay logic here...

        // for testing purpose:
        slf4jLogger.info("From: " + user.getFrom());
        slf4jLogger.info("To: " + user.getTo());
        slf4jLogger.info("Amount: " + user.getAmount());
        slf4jLogger.info("When: " + user.getWhen());

        // Check Point 1
        slf4jLogger.info("************CHECK POINT 1 **************");
        Gson gson = new Gson();
        String json = gson.toJson(user);
        mqListener.sendMessage(json);
        String jsonReturn = mqListener.consumeMessage();
        // Convert JSON to Java Object
        User userNew = gson.fromJson(jsonReturn, User.class);

        //Check Point 2
        slf4jLogger.info("************CHECK POINT 2 **************");
        String restResponse = Utility.callAccounts(user);
        slf4jLogger.info("Rest Response ::: " + restResponse);


        //Check Point 3
        slf4jLogger.info("************CHECK POINT 3 **************");
        TransAudit userMap = new TransAudit();
        userMap.setFrom(user.getFrom());
        userMap.setTo(user.getTo());
        userMap.setAmount(Integer.parseInt(user.getAmount()));
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        String reportDate = df.format(user.getWhen());
        userMap.setWhen(reportDate);
        userDao.save(userMap);

        model.put("userForm", user);

        return "PaySuccess";
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setMqListener(MQListener mqListener) {
        this.mqListener = mqListener;
    }

}