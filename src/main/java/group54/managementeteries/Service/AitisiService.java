package group54.managementeteries.Service;
import group54.managementeteries.Entity.aitisi;

import group54.managementeteries.Entity.User;
import group54.managementeteries.Repository.AitisiRepository;
import group54.managementeteries.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.swagger.v3.oas.annotations.Hidden;
import java.util.List;
@Hidden
@Service
public class AitisiService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AitisiRepository aitisiRepository;
    public void saveaitisi(aitisi Aitisi,String username){
        User user = userRepository.findByUsername(username).get();
        Aitisi.setUser(user);
        aitisiRepository.save(Aitisi);
        System.out.println("saved aitisi with id "+ Aitisi.getId());
    }

    public void saveaitisi(aitisi Aitisi){
        aitisiRepository.save(Aitisi);
        System.out.println("saved aitisi with id "+ Aitisi.getId());
    }


    public aitisi getaitisi(Integer id){
     return aitisiRepository.findById(id).get();

    }

    public void deleteaitisi(Integer id){
        aitisiRepository.deleteById(id);
    }


    public List<aitisi> getallaitiseis(){
        return aitisiRepository.findAll();

    }
}
