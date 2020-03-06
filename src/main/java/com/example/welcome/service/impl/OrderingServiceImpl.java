package com.example.welcome.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.welcome.service.BinaryComparator;
import com.example.welcome.service.OrderingService;

@Service
public class OrderingServiceImpl implements OrderingService {

    @Override
    public List<Integer> sort(List<Integer> list) {
	return list.stream()
		   .map(Integer::toBinaryString)
		   .sorted(new BinaryComparator())
		   .map(s -> Integer.valueOf(s, 2))
		   .collect(Collectors.toList());
    }

}
