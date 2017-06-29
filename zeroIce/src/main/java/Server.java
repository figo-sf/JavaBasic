public class Server {
	public static void main(String[] args) {
		int status = 0;
		Ice.Communicator ic = null;
		try {
			ic = Ice.Util.initialize(args);
			Ice.ObjectAdapter adapter = ic.createObjectAdapterWithEndpoints(
					"AlarmServiceAdapter", "default -h 127.0.0.1 -p 15020");
			
			AlarmServiceI servant = new AlarmServiceI();
			adapter.add(servant, Ice.Util.stringToIdentity("AlarmSender"));
			// 锟斤拷锟斤拷ObjectAdapter
			adapter.activate();
			System.out.print("server started ");
			ic.waitForShutdown();
		} catch (Ice.LocalException e) {
			e.printStackTrace();
			status = 1;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			status = 1;
		}
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