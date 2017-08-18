package demo.service.impl;

import demo.domain.RunningInfoRepository;
import demo.domain.RunningInformation;
import demo.service.RunningInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RunningInfoServiceImpl implements RunningInfoService {

    @Autowired
    private  RunningInfoRepository runningInfoRepository;

    @Override
    public List<RunningInformation> saveRunningInformations(List<RunningInformation> runningInformations) {
        for(RunningInformation runningInformation : runningInformations){
            runningInformation.getHeartRate();
            runningInformation.getHealthWarningLevel();
            runningInformation.getUserAddress();
            runningInformation.getUserName();
        }
        return runningInfoRepository.save(runningInformations);
    }

    @Override
    public void deleteAll() {
        runningInfoRepository.deleteAll();
    }

    @Override
    public void deleteByRunningId(String runningId){
        runningInfoRepository.delete(runningInfoRepository.findByRunningId(runningId));
    }



    @Override
    public Page<RunningInformation> findByHealthWarningLevel(Pageable pageable){


        Page<RunningInformation> result = this.findAll(pageable);
        return result;
    }




    @Override
    @Query("select new entity.RunningInformation(r.userId,r.runningId,r.totalRunningTime,r.userInfo, r.userAddress,r.healthWarningLevel) from RunningInformation r")
    public Page<RunningInformation> findAll(Pageable pageable){
        Page<RunningInformation> result = runningInfoRepository.findAll(pageable);
        return result;
    }



}
