package ru.javawebinar.topjava.web.meal;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.to.MealWithExceed;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/meals")
public class MealRestController extends AbstractMealController {

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        super.delete(id);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody Meal meal, @PathVariable Integer id) {
        super.update(meal, id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Meal> createMeal(@RequestBody Meal meal) {
        Meal created = super.create(meal);
        return new ResponseEntity<Meal>(created, HttpStatus.CREATED);
    }

//    @GetMapping(value = "/between", produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<MealWithExceed> getBetween(@RequestParam(value = "startDate", required = false) String startDate,
//                                           @RequestParam(value = "endLDT", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {
//        StringToLocalDateConverterFactory localDateConv = null;
//        LocalDate ld = (LocalDate) localDateConv.getConverter(LocalDate.class).convert(startDate);
//        List<MealWithExceed> withExceeds = super.getBetween(ld, start.toLocalTime(), end.toLocalDate(), end.toLocalTime());
//        return withExceeds;
//    }

    @GetMapping(value = "/between", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MealWithExceed> getBetween(@RequestParam(value = "startDate", required = false) LocalDate startDate,
                                           @RequestParam(value = "endDate", required = false) LocalDate endDate,
                                           @RequestParam(value = "startTime", required = false) LocalTime startTime,
                                           @RequestParam(value = "endTime", required = false) LocalTime endTime) {
        List<MealWithExceed> withExceeds = super.getBetween(startDate, startTime, endDate, endTime);
        return withExceeds;
    }

    @GetMapping("/{id}")
    public Meal get(@PathVariable int id) {
        return super.get(id);
    }

}