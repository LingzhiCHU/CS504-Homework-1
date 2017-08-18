package demo.rest;

import demo.domain.RunningInformation;
import demo.domain.RunningInfo;
import demo.service.RunningInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RunningInfoRestController {

    @Autowired
    private RunningInfoService runningInfoService;

    @RequestMapping(value = "/", method = RequestMethod.GET)  // "/" = root URL, send HTTP GET request, route to this function
    public String helloWorld(){
        return "Entered";
    }

    @RequestMapping(value = "/running", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<RunningInformation> runningInformations) {
        runningInfoService.saveRunningInformations(runningInformations);
    }

    @RequestMapping(value = "/purge", method = RequestMethod.DELETE)
    public void purge() {
        this.runningInfoService.deleteAll();
    }

    @RequestMapping(value = "/purge/runningId/{runningId}", method = RequestMethod.DELETE)
    public void purgeById(@PathVariable String runningId){
        this.runningInfoService.deleteByRunningId(runningId);
    }

    @RequestMapping(value = "/find/sort",method = RequestMethod.GET)
    public Page<RunningInformation> findByHealthWarningLevel(@RequestParam(name = "page") int page, @RequestParam(name = "size") int size){
        return this.runningInfoService.findByHealthWarningLevel(new PageRequest(0, 2, new Sort(Sort.Direction.DESC,"heartRate")));

    }
}
