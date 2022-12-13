package com.tu.travel.service.Impl;

import com.tu.travel.exception.TripDeletionFails;
import com.tu.travel.exception.TripNotFoundException;
import com.tu.travel.model.entities.DayEntity;
import com.tu.travel.model.entities.TripEntity;
import com.tu.travel.model.services.TripServiceModel;
import com.tu.travel.repository.DayRepository;
import com.tu.travel.repository.TripDayRepository;
import com.tu.travel.repository.TripRepository;
import com.tu.travel.service.TripService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TripServiceImpl implements TripService {
    private final TripRepository tripRepository;
    private final DayRepository dayRepository;
    private final TripDayRepository tripDayRepository;
    private final ModelMapper modelMapper;

    public TripServiceImpl(
            TripRepository tripRepository,
            DayRepository dayRepository,
            TripDayRepository tripDayRepository,
            ModelMapper modelMapper
    ) {
        this.tripRepository = tripRepository;
        this.dayRepository = dayRepository;
        this.tripDayRepository = tripDayRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<TripServiceModel> getTrips() throws TripNotFoundException {
        List<TripServiceModel> trips = tripRepository.getTripEntities()
                .stream()
                .map((trip) -> modelMapper.map(trip, TripServiceModel.class))
                .collect(Collectors.toList());
        return trips;
    }

    @Override
    public TripServiceModel getTripById(long id) throws TripNotFoundException {
        return tripRepository.findById(id)
                .map(trip -> modelMapper.map(trip, TripServiceModel.class))
                .orElseThrow(() -> new TripNotFoundException(id));
    }

    @Override
    public TripServiceModel addTrip(TripServiceModel tripInput) throws TripNotFoundException {
        TripEntity trip = modelMapper.map(tripInput, TripEntity.class);
        TripEntity result = tripRepository.save(trip);

        return getTripById(result.getId());
    }

    @Override
    public long deleteTripById(long id) throws TripNotFoundException, TripDeletionFails {
        Optional<TripEntity> tripToBeDeleteOpt = tripRepository.findById(id);

        if (tripToBeDeleteOpt.isEmpty()) {
            throw new TripNotFoundException(id);
        }

        tripRepository.delete(tripToBeDeleteOpt.get());

        if(tripRepository.findById(id).isPresent()) {
            throw new TripDeletionFails(id);
        }

        return id;
    }

    @Override
    @Transactional
    public void addDays(Long tripId, List<Long> daysIds) throws TripNotFoundException {
        List<DayEntity> days = dayRepository.getDaysByIds(daysIds);
        TripEntity trip = modelMapper.map(getTripById(tripId), TripEntity.class);

        days.forEach(day -> day.getTrips().add(trip));
        trip.setDays(days);

        tripRepository.saveAndFlush(trip);
    }
}
