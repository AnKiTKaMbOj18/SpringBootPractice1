package kamboj.ankit.SpringBootPractice1.repository;

import kamboj.ankit.SpringBootPractice1.domain.Mobile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MobileRepository extends JpaRepository<Mobile,Long> {


}
