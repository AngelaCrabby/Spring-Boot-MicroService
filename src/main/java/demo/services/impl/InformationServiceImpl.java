package demo.services.impl;

import demo.domain.RunningInformation;
import demo.domain.RunningInformationRepository;
import demo.services.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InformationServiceImpl implements InformationService {

    private RunningInformationRepository repository;

    @Autowired
    public InformationServiceImpl(RunningInformationRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<RunningInformation> saveRunningInformation(List<RunningInformation> runningInformation) {
        return this.repository.save(initialList(runningInformation));
    }

    @Override
    public void deleteByRunningId(String runningId) {
        repository.delete(repository.findByRunningId(runningId));
    }

    // generate random number between [60, 200] for heartRate
    private int generateHeartRate() {
        int min = 60;
        int max = 200;
        return min + (int) (Math.random() * (max - min + 1));
    }

    // generate healthWarningLevel, according to heartRate
    private String generateHealthWarningLevel(int heartRate) {
        if (heartRate >= 60 && heartRate <= 75) {
            return "LOW";
        } else if (heartRate > 75 && heartRate <= 120) {
            return "NORMAL";
        } else {
            return "HIGH";
        }
    }

    // initial list of runningInfo save into DB, by generating initial heartRate & HealthWarningLevel
    private List<RunningInformation> initialList(List<RunningInformation> listToInitial) {
        List<RunningInformation> initial = new ArrayList<>();

        for (RunningInformation info : listToInitial) {
            info.setHeartRate(generateHeartRate());
            info.setHealthWarningLevel(generateHealthWarningLevel(info.getHeartRate()));
            initial.add(info);
        }

        return initial;
    }
}





















