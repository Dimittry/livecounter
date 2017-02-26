package com.countergrabber;

import com.countergrabber.dao.impl.CounterDAOImpl;
import com.countergrabber.dao.impl.SourceDAOImpl;
import com.countergrabber.domain.Counter;
import com.countergrabber.service.CounterService;
import com.countergrabber.service.GrabberService;
import com.countergrabber.service.impl.CounterServiceImpl;
import com.countergrabber.service.impl.GrabberServiceImpl;

import java.util.List;

public class App {
    public static void main(String[] args) {
        GrabberService grabberService = new GrabberServiceImpl(new SourceDAOImpl());
        grabberService.grab();
        List<Counter> counters = grabberService.getCounters();

        CounterService counterService = new CounterServiceImpl(new CounterDAOImpl());
        int saved = counterService.saveCounters(counters);
        System.out.println("Saved items: " + saved);
    }
}
