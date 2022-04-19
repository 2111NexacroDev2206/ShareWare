package org.kh.shareware.report.service;

import java.util.List;

import org.kh.shareware.report.domain.Daily;

public interface DailyService {

	public int registerDaily(Daily daily);

	public List<Daily> printAllDaily();

}
