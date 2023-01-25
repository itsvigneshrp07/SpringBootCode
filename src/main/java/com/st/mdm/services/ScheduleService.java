package com.st.mdm.services;
import java.util.List;

import com.st.mdm.models.Bucket;
import com.st.mdm.models.Schedule;
import com.st.mdm.models.UcicMaster;
public interface ScheduleService {
	List<Schedule> createScheduleDetails(String inputData);
	public Schedule updateScheduleDetails(Schedule data);
	List<Schedule> getScheduleDetails(long id);
	//public UcicMaster updateProjectDetails(UcicMaster data);

}
