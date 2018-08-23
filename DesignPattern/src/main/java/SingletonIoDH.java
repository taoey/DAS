public class SingletonIoDH{
	private SingletonIoDH() {}

	private static class HolerClass{   //控制类
		private static final SingletonIoDH instance = new SingletonIoDH();
	}

	public SingletonIoDH getInstance() {  //对外接口
		return HolerClass.instance;
	}
}
