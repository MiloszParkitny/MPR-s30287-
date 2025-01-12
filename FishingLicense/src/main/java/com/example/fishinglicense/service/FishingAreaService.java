package com.example.fishinglicense.service;

import com.example.fishinglicense.dto.FishingAreaRequest;
import com.example.fishinglicense.dto.FishingAreaResponse;
import com.example.fishinglicense.mapper.FishingAreaMapper;
import com.example.fishinglicense.model.FishingArea;
import com.example.fishinglicense.repository.FishingAreaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FishingAreaService {

    private final FishingAreaRepository fishingAreaRepository;
    private final FishingAreaMapper fishingAreaMapper;

    public List<FishingAreaResponse> getAllFishingAreas() {
        return fishingAreaRepository.findAll()
                .stream()
                .map(fishingAreaMapper::toResponse)
                .collect(Collectors.toList());
    }

    public FishingAreaResponse getFishingAreaById(Long id) {
        FishingArea fishingArea = fishingAreaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fishing area not found with id: " + id));
        return fishingAreaMapper.toResponse(fishingArea);
    }

    public FishingAreaResponse createFishingArea(FishingAreaRequest fishingAreaRequest) {
        FishingArea fishingArea = fishingAreaMapper.toEntity(fishingAreaRequest);
        FishingArea savedFishingArea = fishingAreaRepository.save(fishingArea);
        return fishingAreaMapper.toResponse(savedFishingArea);
    }

    public FishingAreaResponse updateFishingArea(Long id, FishingAreaRequest fishingAreaRequest) {
        return fishingAreaRepository.findById(id)
                .map(area -> {
                    area.setName(fishingAreaRequest.getName());
                    area.setLocation(fishingAreaRequest.getLocation());
                    return fishingAreaMapper.toResponse(fishingAreaRepository.save(area));
                })
                .orElseThrow(() -> new RuntimeException("Fishing area not found with id: " + id));
    }

    public void deleteFishingArea(Long id) {
        fishingAreaRepository.deleteById(id);
    }
    public FishingAreaResponse getFishingAreaByName(String name) {
        FishingArea fishingArea = fishingAreaRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Fishing area not found with name: " + name));
        return fishingAreaMapper.toResponse(fishingArea);
    }

}
