package com.company.PDPOnline.controller;

import com.company.PDPOnline.dto.WorkerDTO;
import com.company.PDPOnline.service.WorkerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/worker")
@RequiredArgsConstructor
public class WorkerController {
    private final WorkerService workerService;

    @GetMapping("/list")
    public ResponseEntity<List<WorkerDTO>> getWorker(){
        return ResponseEntity.ok(workerService.getWorker());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<WorkerDTO> getWorker(@PathVariable("id") Integer id){
        return ResponseEntity.ok(workerService.getById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<WorkerDTO> create(@RequestBody @Valid WorkerDTO dto){
        return ResponseEntity.ok(workerService.create(dto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable("id") Integer addressId,
                                         @RequestBody WorkerDTO dto){
        return ResponseEntity.ok(workerService.update(addressId, dto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer addressId){
        return ResponseEntity.ok(workerService.delete(addressId));
    }
}
