package com.countergrabber.service;


import com.countergrabber.domain.Counter;

import java.util.List;

public interface GrabberService {
    void grab();
    List<Counter> getCounters();
}
