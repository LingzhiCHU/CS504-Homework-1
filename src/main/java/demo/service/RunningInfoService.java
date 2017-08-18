package demo.service;

import demo.domain.RunningInformation;
import demo.domain.RunningInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RunningInfoService {
    List<RunningInformation> saveRunningInformations(List<RunningInformation> runningInformations);

    void deleteAll();

    void deleteByRunningId(String runningId);

    Page<RunningInformation> findByHealthWarningLevel(Pageable pageable);

    Page<RunningInformation> findAll(Pageable pageable);

}
