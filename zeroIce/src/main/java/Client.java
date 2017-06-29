import SSIP.AlarmHandlerPrx;
import SSIP.AlarmHandlerPrxHelper;
import SSIP.AlarmServicePrx;
import SSIP.AlarmServicePrxHelper;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int status = 0;
		Ice.Communicator ic = null;
		try {
			ic = Ice.Util.initialize(args);
			Ice.ObjectPrx base = ic
					.stringToProxy("AlarmSender:default -h 127.0.0.1 -p 15020");
			// Ice.ObjectPrx base2 = ic
			// .stringToProxy("AlarmHandler:default -h 127.0.0.1 -p 15022");
			AlarmServicePrx sender = AlarmServicePrxHelper.uncheckedCast(base);
			// AlarmServicePrxHelper.uncheckedCast(base.ice_identity(Ice.Util.stringToIdentity("AlarmSender")));
			System.out.println("连上服务器");
			// SSIP.AlarmHandlerPrx sender =
			// SSIP.AlarmHandlerPrxHelper.checkedCast(base);10.143.100.209
			Ice.ObjectAdapter adapter = ic
					.createObjectAdapterWithEndpoints("AlarmHandlerAdapter",
							"default -h 127.0.0.1 -p 12020");
			AlarmHandlerI servant = new AlarmHandlerI();
			adapter.add(servant, Ice.Util.stringToIdentity("AlarmHandler"));
			adapter.activate();
			AlarmHandlerPrx receiver = AlarmHandlerPrxHelper
					.uncheckedCast(adapter.createProxy(ic
							.stringToIdentity("AlarmHandler")));
			// receiver.
			// AlarmServicePrxHelper.uncheckedCast(base);
			// if (sender == null)
			// throw new Error("Invalid proxy");
			// AlarmHandlerPrx proxy=AlarmHandlerPrxHelper.checkedCast(base2);

			// sender.initAlarmHandler(proxy);
			if (receiver == null)
				throw new Error("Invalid proxy");
			// sender.onChangedSchedule();
			sender.initAlarmHandler(receiver);
			// AlarmMessage[] msglist = new AlarmMessage[100];
			// for (int i = 0; i < 100; i++) {
			// msglist[i] = new AlarmMessage("1", Byte.valueOf("1"),
			// Byte.valueOf("1"), Byte.valueOf("1"), "1", i, i, i,
			// "1", "1", "1", "1", "1", "1");
			//
			// }
			// sender.onAlarm(msglist);
			// sender.onChangedSchedule();
			System.out.print(1111111);
		} catch (Ice.LocalException e) {
			e.printStackTrace();
			status = 1;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			status = 1;
		}
//不能关闭链接
//		if (ic != null) {
//			// clean up
//			try {
//				ic.destroy();
//			} catch (Exception e) {
//				System.err.println(e.getMessage());
//				status = 1;
//			}
//		}

//		System.exit(status);
	}

}
