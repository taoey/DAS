public class Singleton{	
	private Singleton() {}
	
	private static class HolerClass{   //控制类
		private static final Singleton instance = new Singleton();
	}
	
	public Singleton getInstance() {  //对外接口
		return HolerClass.instance;
	}
}
