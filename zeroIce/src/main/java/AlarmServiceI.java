import Ice.Current;
import SSIP.AlarmHandlerPrx;
import SSIP.AlarmMessage;
import SSIP.ScheduleMessage;
import SSIP._AlarmServiceDisp;


public class AlarmServiceI extends _AlarmServiceDisp {

	@Override
	public void initAlarmHandler(AlarmHandlerPrx proxy, Current __current) {
		// TODO 自动生成的方法存根
		System.out.println("initiating callback");
		ScheduleMessage smlist[]=new ScheduleMessage[100];
		for (int i = 0; i < smlist.length; i++) {
			smlist[i] =new ScheduleMessage("你好",1111,111);
			
		}
		ScheduleMessage sm =new ScheduleMessage("你好",1111,111);
		proxy.onChangedSchedule(smlist);
		
		AlarmMessage[] msglist = new AlarmMessage[100];
		for (int i = 0; i < 100; i++) {
			msglist[i] = new AlarmMessage("1", Byte.valueOf("1"),
					Byte.valueOf("1"), Byte.valueOf("1"), "1", i, i, i,
					"坏人", "1", "1", "1", "1", "1");

		}
		proxy.onAlarm(msglist);
	/*	Ice.Communicator ic = null;
		ic = Ice.Util.initialize();
		Ice.ObjectAdapter adapter = ic.createObjectAdapterWithEndpoints(
				"AlarmHandlerAdapter", "default -h 127.0.0.1 -p 15022");
		//Ice.Object object = new PrinterI();
		AlarmHandlerI servant = new AlarmHandlerI();
		adapter.add(servant, Ice.Util.stringToIdentity("AlarmHandler"));
		// 锟斤拷锟斤拷ObjectAdapter
		adapter.activate();
		System.out.print("server started ");
		ic.waitForShutdown();*/
	}

}
