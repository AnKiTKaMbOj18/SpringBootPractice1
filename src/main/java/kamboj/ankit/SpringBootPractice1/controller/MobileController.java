package kamboj.ankit.SpringBootPractice1.controller;

import java.util.Optional;
import java.util.stream.Collectors;
import kamboj.ankit.SpringBootPractice1.domain.Mobile;
import kamboj.ankit.SpringBootPractice1.dto.MobileDto;
import kamboj.ankit.SpringBootPractice1.service.MobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*@CrossOrigin(origins = "http://localhost:4400", maxAge = 3600,
        allowCredentials = "true",
        methods = { RequestMethod.DELETE,RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,
                RequestMethod.OPTIONS})*/
/*@CrossOrigin(origins = "*", maxAge = 3600)*/

@RestController
@RequestMapping("/mobiles")
public class MobileController {

    @Autowired
    MobileService mobileService;

    public static final String OK="OK";

    @GetMapping("")
    public List<MobileDto> getAllMobiles(){
        return mobileService.getAllMobiles().stream().map(this::buildMoileDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public MobileDto getMobile(@PathVariable Long id){
         Optional<Mobile> mobile=mobileService.getMobile(id);
      return buildMoileDto(mobile.get());
    }

    @PostMapping
    public Long addMobile(@RequestBody MobileDto mobileDto){
        return mobileService.addMobile(mobileDto);
    }

    @PutMapping
    public String updateMobile(@RequestBody MobileDto mobileDto){
        mobileService.updateMobile(mobileDto);
        return OK;
    }

    @DeleteMapping("/{id}")
    public String deleteMobile(@PathVariable Long id){
        mobileService.deleteMobile(id);
        return OK;
    }

    private MobileDto buildMoileDto(Mobile mobile){
        return MobileDto.builder()
            .id(mobile.getId())
            .name(mobile.getName())
            .cost(mobile.getCost())
            .build();
    }
}
