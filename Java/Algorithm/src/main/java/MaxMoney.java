import java.awt.FontFormatException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * url :https://www.nowcoder.com/test/question/46e837a4ea9144f5ad2021658cb54c4d?pid=9763997&tid=14848478
 * @author taoey
 *
 */
public class MaxMoney {	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int wNum = in.nextInt();
		int pNum = in.nextInt();
		Map<Integer, Integer> map = new HashMap();
		List<Integer> result = new ArrayList<Integer>();
		//get map data
		for(int i = 0;i<wNum;i++) {
			int ability = in.nextInt();
			int money = in.nextInt();
			map.put(money,ability);
		}
		
		//solve
		for(int i =0;i<pNum;i++) {
			int a = in.nextInt();
			int max = 0;
			for(Map.Entry<Integer, Integer> am: map.entrySet()) {
				if(a >= am.getValue()) {
					max = Math.max(am.getKey(), max);
				}
			}//end for
			result.add(max);
		}//end for
		
		//output
		for (int i : result) {
			System.out.println(i);
		}
		
		
	
	}
}
