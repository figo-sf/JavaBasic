import Ice.Current;
import SSIP.AlarmMessage;
import SSIP.ScheduleMessage;
import SSIP._AlarmHandlerDisp;

public class AlarmHandlerI extends _AlarmHandlerDisp {

	@Override
	public void onAlarm(AlarmMessage[] msglist, Current __current) {
		// TODO Auto-generated method stub
		System.out.println("onAlarm");
		for (int i = 0; i < msglist.length; i++) {
			System.out.println(msglist[i].datetime);
		}
	}

	@Override
	public void onChangedSchedule(ScheduleMessage[] slist, Current __current) {
		System.out.println("onChangedSchedule");
		// TODO Auto-generated method stub
		for (int i = 0; i < slist.length; i++) {
			System.out.println(slist[i].schedule_file_name);
		}
	}



}
