package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {

}
