import SSIP.AlarmServicePrx;
import SSIP.AlarmServicePrxHelper;

public class Client2 {

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
			
			AlarmServicePrx sender = AlarmServicePrxHelper.uncheckedCast(base);
		sender.ice_ping();
		} catch (Ice.LocalException e) {
			e.printStackTrace();
			status = 1;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			status = 1;
		}

	}

}
