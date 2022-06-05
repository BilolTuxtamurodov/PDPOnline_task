package com.company.PDPOnline.service;

import com.company.PDPOnline.dto.WorkerDTO;
import com.company.PDPOnline.entity.WorkerEntity;
import com.company.PDPOnline.exception.ItemNotFoundException;
import com.company.PDPOnline.repository.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkerService {
    private final WorkerRepository workerRepository;

    public List<WorkerDTO> getWorker(){
        List<WorkerDTO> workerDTOS = new ArrayList<>();
        List<WorkerEntity> entities = workerRepository.findAll();

        entities.forEach(workers -> {
            workerDTOS.add(toDTO(workers));
        });
        if (workerDTOS.isEmpty()){
            return new LinkedList<>();
        }
        return workerDTOS;
    }

    public WorkerEntity get(Integer id) {
        return workerRepository.findById(id).orElseThrow(()-> new ItemNotFoundException("Not found"));
    }

    public WorkerDTO getById(Integer id) {
        return toDTO(get(id));
    }

    public WorkerDTO create(WorkerDTO dto) {
        WorkerEntity worker = new WorkerEntity();
        worker.setAddressId(dto.getAddressId());
        worker.setName(dto.getName());
        worker.setDeportmentId(dto.getDeportmentId());
        worker.setPhoneNumber(dto.getPhoneNumber());
        workerRepository.save(worker);
        dto.setId(worker.getId());
        return dto;
    }

    public String  update(Integer workerId, WorkerDTO dto) {
        WorkerEntity entity = get(workerId);
        entity.setName(dto.getName());
        entity.setAddressId(dto.getAddressId());
        entity.setDeportmentId(dto.getDeportmentId());
        entity.setPhoneNumber(dto.getPhoneNumber());
        workerRepository.save(entity);
        return "Success";
    }

    public String delete(Integer workerId) {
        WorkerEntity entity = get(workerId);
        workerRepository.delete(entity);
        return "Success";
    }

    public WorkerDTO toDTO(WorkerEntity entity){
        WorkerDTO dto = new WorkerDTO();
        dto.setName(entity.getName());
        dto.setAddressId(entity.getAddressId());
        dto.setDeportmentId(entity.getDeportmentId());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setId(entity.getId());
        return dto;
    }
}
