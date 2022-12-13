package com.tu.travel.service.Impl;

import com.tu.travel.exception.*;
import com.tu.travel.model.entities.DayEntity;
import com.tu.travel.model.services.DayServiceModel;
import com.tu.travel.repository.DayRepository;
import com.tu.travel.service.DayService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DayServiceImpl implements DayService {
    private final DayRepository dayRepository;
    private final ModelMapper modelMapper;

    public DayServiceImpl(DayRepository dayRepository, ModelMapper modelMapper) {
        this.dayRepository = dayRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<DayServiceModel> getDays() throws GetDaysException {
        List<DayServiceModel> days = dayRepository.getDayEntities()
                .stream()
                .map((day) -> modelMapper.map(day, DayServiceModel.class))
                .collect(Collectors.toList());
        return days;
    }

    @Override
    public DayServiceModel getDayById(long id) throws DayNotFoundException {
        return dayRepository.findById(id)
                .map(day -> modelMapper.map(day, DayServiceModel.class))
                .orElseThrow(() -> new DayNotFoundException(id));
    }

    @Override
    public DayServiceModel addDay(DayServiceModel dayInput) throws DayNotFoundException, DaySaveException {
        DayEntity day = modelMapper.map(dayInput, DayEntity.class);
        DayEntity result = dayRepository.save(day);

        return getDayById(day.getId());
    }

    @Override
    public DayServiceModel updateDay(long id, DayServiceModel day) throws DayNotFoundException, DayUpdateException {
        Optional<DayEntity> dayToBeUpdateOpt = dayRepository.findById(id);

        if (dayToBeUpdateOpt.isEmpty()) {
            throw new DayNotFoundException(id);
        }

        DayEntity dayUpdateObject = modelMapper.map(day, DayEntity.class);
        DayEntity dayToBeUpdated = dayToBeUpdateOpt.get();

        dayToBeUpdated.setLocation(dayUpdateObject.getLocation());
        dayToBeUpdated.setDate(dayUpdateObject.getDate());
        dayToBeUpdated.setDescription(dayUpdateObject.getDescription());
        dayToBeUpdated.setComment(dayUpdateObject.getComment());

        dayRepository.save(dayToBeUpdated);
        Optional<DayEntity> updatedDay = dayRepository.findById(id);

        if (updatedDay.isEmpty()) {
            throw new DayUpdateException(id);
        }

        return modelMapper.map(updatedDay, DayServiceModel.class);
    }

    @Override
    public long deleteDayById(long id) throws DayNotFoundException, DayDeletionFails {
        Optional<DayEntity> dayToBeDeleteOpt = dayRepository.findById(id);

        if (dayToBeDeleteOpt.isEmpty()) {
            throw new DayNotFoundException(id);
        }

        dayRepository.delete(dayToBeDeleteOpt.get());

        if(dayRepository.findById(id).isPresent()) {
            throw new DayDeletionFails(id);
        }

        return id;
    }
}
