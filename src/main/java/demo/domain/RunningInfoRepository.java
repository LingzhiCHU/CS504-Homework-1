package demo.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RunningInfoRepository extends JpaRepository<RunningInformation,Long> {


    RunningInformation findByRunningId(@Param("runningId") String runningId);


}
