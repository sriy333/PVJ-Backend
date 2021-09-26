package com.pvj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlowStatusPlanner {

	@Autowired
	private FlowOrderPlanner orderPlanner;
	
}
