package demo.services;

import demo.domain.RunningInformation;

import java.util.List;

public interface InformationService {
    List<RunningInformation> saveRunningInformation(List<RunningInformation> runningInformation);

    void deleteByRunningId(String runningId);

}
