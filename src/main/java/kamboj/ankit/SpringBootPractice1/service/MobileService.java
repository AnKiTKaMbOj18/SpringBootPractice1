package kamboj.ankit.SpringBootPractice1.service;

import java.util.Optional;
import kamboj.ankit.SpringBootPractice1.domain.Mobile;
import kamboj.ankit.SpringBootPractice1.dto.MobileDto;

import java.util.List;

public interface MobileService {

    List<Mobile> getAllMobiles();

    Optional<Mobile> getMobile(Long id);

    Long addMobile(MobileDto mobileDto);

    Boolean updateMobile(MobileDto mobileDto);

    Boolean deleteMobile(Long id);
}
