package kamboj.ankit.SpringBootPractice1.service.Impl;

import java.util.Optional;
import kamboj.ankit.SpringBootPractice1.domain.Mobile;
import kamboj.ankit.SpringBootPractice1.dto.MobileDto;
import kamboj.ankit.SpringBootPractice1.repository.MobileRepository;
import kamboj.ankit.SpringBootPractice1.service.MobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MobileServiceImpl implements MobileService {

    @Autowired
    MobileRepository mobileRepository;

    @Override
    public List<Mobile> getAllMobiles() {

        List<Mobile> mobiles=new ArrayList<>();
        mobileRepository.findAll()
                .forEach(mobiles::add);
        return mobiles;
    }

    @Override
    public Optional<Mobile> getMobile(Long id) {
        return mobileRepository.findById(id);
    }

    @Override
    public Long addMobile(MobileDto mobileDto) {
        Mobile mobile=Mobile.builder()
            .name(mobileDto.getName())
            .cost(mobileDto.getCost())
            .build();
        mobileRepository.save(mobile);
        return mobile.getId();
    }

    @Override
    public Boolean updateMobile(MobileDto mobileDto) {
        Mobile mobile=mobileRepository.findById(mobileDto.getId()).get();
        mobile.setName(mobileDto.getName());
        mobile.setCost(mobileDto.getCost());
        mobileRepository.save(mobile);
        return true;
    }

    @Override
    public Boolean deleteMobile(Long id) {
        mobileRepository.deleteById(id);
        return true;
    }
}
