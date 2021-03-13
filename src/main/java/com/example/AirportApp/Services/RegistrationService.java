package com.example.AirportApp.Services;
import com.example.AirportApp.Dao.RegistrationDao;
import com.example.AirportApp.Models.UserModel;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.List;


@Service
public class RegistrationService {


    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    RegistrationDao registrationDao;



    public void registerUser(UserModel userModel){
        String randomCode = RandomString.make(64);
//        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
//        userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
        userModel.setVerificationCode(randomCode);
        registrationDao.registerUser(userModel);
    }


   public Boolean checkIsEnabledByName(String name){
       return registrationDao.checkIsEnabledByName(name);
   }

    public void sendVerificationEmail(UserModel userModel, String siteURL) throws UnsupportedEncodingException, MessagingException {
        String subject = "Please verify your registration";
        String senderName = "Romanian Flying";
        String emailContent = "<p>Dear " + userModel.getUserName() + " </p>";
        emailContent += "<p>please click the link below to verify your registration:</p>";
        String verifyURL = siteURL + "/verify?code=" + userModel.getVerificationCode();
        emailContent += "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>";
        emailContent += "<p>Thank you<br> The Romanian Flying Team</p>";
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom("romanianflying@yahoo.com", senderName);
        helper.setTo(userModel.getEmail());
        helper.setSubject(subject);
        emailContent =  emailContent.replace("[[URL]]", verifyURL);
        helper.setText(emailContent, true);

        mailSender.send(message);
    }

    public List<String> getUserEmail(){
       return registrationDao.getUserEmail();
    }

    public List<String> getUserName(){
        return registrationDao.getUserName();
    }

    public boolean verifyCode(String verificationCode){
        UserModel userModel = registrationDao.getUserByRegistrationCode(verificationCode);
        if (userModel == null){
            return false;
        }else{
            registrationDao.enable(verificationCode);
            return true;
        }
    }
}
