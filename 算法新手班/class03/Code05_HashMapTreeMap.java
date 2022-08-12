package class03;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * 常数操作：固定时间可以完成的操作，比如加减乘除、数组寻址都是固定时间
 * 时间复杂度：对于冒泡排序来说，假定一个谁大谁往右的操作记为a，那会有n*(n-1),,,*1次
 * sn=n*a+n(n-1)/2
 * 	 =n^2/2 - (1-n/2)a
 * 只关注最大项n^2
 * 所以时间复杂度o(n^2),这个事就很模糊
 * 只认最高阶
 * o(n)优于o(n^2)
 * 有等差感是o(n^2)
 * 常见复杂度：
 * o(1)<o(log n)<o(n)<o(n*log n)<o(n^2)<o(n^3)<o(n^k)<o(2^n)<o(3^n)<o(k^n)<o(n!)
 *
 * 动态数组使用和扩容
 * int[]找index的时间复杂度是o(1)
 * arraylist[]动态数组，有动态扩容行为，找index会不会影响时间复杂度？
 * 假定加N个数，扩容总代价是多少？
 * arraylist[a]1
 * arraylist[a,b]2
 * arraylist[a,b,c,d]4
 * 8
 * 16
 * .
 * .
 * .
 * 一直到追上N
 * 这是一个等比数列 所以时间复杂度是o(N)
 * 均摊到每一步的时间复杂度就是o(1)
 * 结论：动态数组，虽然有扩容行为，但是对整体性能在时间复杂度上面无影响
 * 		和固定数组一样好，还能动态扩容。
 *
 * 哈希表、有序表用法
 * 哈希表也可以当作<k,v>表
 * 哈希表不管增加多少条记录，增删改查的时间复杂度都是o(1)
 * 但是这个常数操作的时间大于其他常数操作的时间
 *
 * map2,ab内存地址不一样，但是却都存在，这说明在原生的数据类型下，是按值传递的key
 *
 * map3非原生类型，按引用传递，只问内存地址
 *
 * 有序表TreeMap
 * 代码中的一些方法看一下
 * 时间复杂度是o(log n)
 *
 * 那为什么还用hashmap?因为hashmap时间复杂度是o(1)
 *
 */
public class Code05_HashMapTreeMap {

	public static class Node {
		public int value;

		public Node(int v) {
			value = v;
		}
	}

	// (K V)表
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<>();
		map.put("zuochengyun", "我是左程云");
		System.out.println(map.containsKey("zuochengyun"));
		System.out.println(map.containsKey("zuo"));
		System.out.println(map.get("zuochengyun"));

		map.put("zuochengyun", "他是左程云");
		System.out.println(map.get("zuochengyun"));

//		map.remove("zuochengyun");
//		System.out.println(map.containsKey("zuochengyun"));
//		System.out.println(map.get("zuochengyun"));

		String test1 = "zuochengyun";
		String test2 = "zuochengyun";
		System.out.println(map.containsKey(test1));
		System.out.println(map.containsKey(test2));

		HashMap<Integer, String> map2 = new HashMap<>();
		map2.put(1234567, "我是1234567");

		Integer a = 1234567;
		Integer b = 1234567;

		System.out.println(a == b);//false 比内存地址
		System.out.println(map2.containsKey(a));//都能查出对应的值，说明是按值传递的
		System.out.println(map2.containsKey(b));

		Node node1 = new Node(1);
		Node node2 = new Node(1);
		HashMap<Node, String> map3 = new HashMap<>();
		map3.put(node1, "我进来了！");
		System.out.println(map3.containsKey(node1));
		System.out.println(map3.containsKey(node2));

		System.out.println("===================");

		TreeMap<Integer, String> treeMap1 = new TreeMap<>();

		treeMap1.put(3, "我是3");
		treeMap1.put(0, "我是3");
		treeMap1.put(7, "我是3");
		treeMap1.put(2, "我是3");
		treeMap1.put(5, "我是3");
		treeMap1.put(9, "我是3");

		System.out.println(treeMap1.containsKey(7));
		System.out.println(treeMap1.containsKey(6));
		System.out.println(treeMap1.get(3));

		treeMap1.put(3, "他是3");
		System.out.println(treeMap1.get(3));

		treeMap1.remove(3);
		System.out.println(treeMap1.get(3));

		System.out.println(treeMap1.firstKey());
		System.out.println(treeMap1.lastKey());
		// <=5 离5最近的key告诉我
		System.out.println(treeMap1.floorKey(5));
		// <=6 离6最近的key告诉我
		System.out.println(treeMap1.floorKey(6));
		// >=5 离5最近的key告诉我
		System.out.println(treeMap1.ceilingKey(5));
		// >=6 离6最近的key告诉我
		System.out.println(treeMap1.ceilingKey(6));

//		Node node3 = new Node(3);
//		Node node4 = new Node(4);
//		TreeMap<Node, String> treeMap2 = new TreeMap<>();
//		treeMap2.put(node3, "我是node3");
//		treeMap2.put(node4, "我是node4");

	}

}
