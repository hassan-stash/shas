
package shas.devices.interfaces;

import java.util.Date;


public interface ISprinkler {
	
	void Set_sprinklers(String day_of_week, Date time_of_day, Integer length);
	void Turn_off_sprinklers();
	void Rain_sensor(Integer day_begins, Integer time_begin, Integer time_of_day, Integer length );
}
