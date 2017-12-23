package demo.rest;

import demo.domain.RunningInformation;
import demo.domain.RunningInformationRepository;
import demo.services.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InformationAnalysisRestController {

    private RunningInformationRepository repository;
    private InformationService service;

    @Autowired
    public InformationAnalysisRestController(RunningInformationRepository repository, InformationService service) {
        this.repository = repository;
        this.service = service;
    }

    // http://localhost:8080/bulk/runningInformation
    @RequestMapping(value = "/bulk/runningInformation", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<RunningInformation> information) {
        service.saveRunningInformation(information);
    }

    // check all lists in repository : http://localhost:8080/all?page=0&size=10
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Page<RunningInformation> checkRepo(@RequestParam(name = "page") int page, @RequestParam(name = "size") int size){
        return repository.findAll(new PageRequest(page, size));
    }

    // http://localhost:8080/healthWarningLevel?page=0
    @RequestMapping(value = "/healthWarningLevel", method = RequestMethod.GET) // find using get method
    public Page<RunningInformation> orderByHealthWarningLevelDesc(@RequestParam(name = "page") int page) {
        return repository.findAllByOrderByHeartRateDesc(new PageRequest(page, 2));
    }

    // http://localhost:8080/purge/2f3c321b-d239-43d6-8fe0-c035ecdff232
    @RequestMapping(value = "/purge/{runningId}", method = RequestMethod.DELETE)
    public void purge(@PathVariable String runningId) {
        service.deleteByRunningId(runningId);
    }

}


















