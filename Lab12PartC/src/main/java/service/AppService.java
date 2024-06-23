package service;

import configuration.AppProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppService {

    @Autowired
    private AppProperties appProperties;

    public void print(){
        System.out.println("ApplicationName: " + appProperties.getApplicationName());
        System.out.println("Version: " + appProperties.getVersion());
        System.out.println("ServerURL: " + appProperties.getServerURL());
        System.out.println("ServerName: " + appProperties.getServerName());
        System.out.println("UserFirstName: " + appProperties.getUserFirstName());
        System.out.println("UserLastName: " + appProperties.getUserLastName());
        System.out.println("UserName: " + appProperties.getUserName());
        System.out.println("Password: " + appProperties.getPassword());
        System.out.println("Countries: " + appProperties.getCountries());
    }
}
