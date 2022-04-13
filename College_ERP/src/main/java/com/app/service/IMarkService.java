package com.app.service;

import com.app.pojos.Attendance;
import com.app.pojos.Mark;

public interface IMarkService {
	Mark addMarkDetails(Mark mark);
	Attendance addAttendance(Attendance attendance);
}
