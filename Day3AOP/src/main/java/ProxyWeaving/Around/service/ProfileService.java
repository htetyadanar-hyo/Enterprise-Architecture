package ProxyWeaving.Around.service;

import org.springframework.stereotype.Service;

@Service
public class ProfileService {
    public void addProfile(){
        System.out.println("Adding Profile....");
    }
}
