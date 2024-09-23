package com.acostajp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acostajp.model.Report;


public interface IReportRepository  extends JpaRepository<Report, Long>{

}
