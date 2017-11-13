package ru.javawebinar.topjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.List;

import static ru.javawebinar.topjava.util.ValidationUtil.checkNotFoundWithId;

@Service
public class MealServiceImpl implements MealService {

    private MealRepository repository;

    @Autowired
    public MealServiceImpl(MealRepository repository) {
        this.repository = repository;
    }

    @Override
    public Meal create(Meal meal) {
        return repository.save(meal);
    }

    @Override
    public void delete(int id, int userId) throws NotFoundException {
        checkNotFoundWithId(repository.delete(id, userId), id);
    }

    @Override
    public Meal get(int id, int userId) throws NotFoundException {
        return checkNotFoundWithId(repository.get(id, userId), id);
    }

    @Override
    public void update(Meal meal) {
        repository.save(meal);
    }

    @Override
    public Collection<Meal> getAll(int userId) throws NotFoundException {
        return checkNotFoundWithId(repository.getAll(userId), userId);
    }
    @Override
    public Collection<Meal> getAll(int userId, LocalDate start, LocalDate end) {
        return checkNotFoundWithId(repository.getAll(userId, start, end), userId);
    }

    @Override
    public Collection<Meal> getAll(int userId, LocalTime startTime, LocalTime endTime) {
        return checkNotFoundWithId(repository.getAll(userId, startTime, endTime), userId);
    }
}