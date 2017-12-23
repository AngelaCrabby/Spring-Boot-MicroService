package demo.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(path = "information")
public interface RunningInformationRepository extends JpaRepository<RunningInformation, Long> {

    // http://localhost:8080/information/search/user?username=ross0
    @RestResource(path = "user")
    List<RunningInformation> findByUserInfoUsername(@Param("username") String username);

    // http://localhost:8080/information/search/runningId?runningId=7c08973d-bed4-4cbd-9c28-9282a02a6032
    @RestResource(path = "runningId")
    List<RunningInformation> findByRunningId(@Param("runningId") String runningId);

    Page<RunningInformation> findAllByOrderByHeartRateDesc(Pageable pageable);

}
