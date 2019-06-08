package com.johnvon.fjy;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.TreeMultimap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MultiMapApplicationTests {

	@Test
	public void testHashMultimap(){
		Multimap<Integer, Integer> map = HashMultimap.create();
		map.put(4, 2);
		map.put(4, 7);
		map.put(1, 4);
		map.put(1, 5);
		map.put(1, 3);
		map.put(2, 3);
		map.put(2, 9);
		map.put(2, 7);
		map.put(4, 5);
		System.out.println(map.toString());

		/*输出结果：
		 *{1=[4, 5, 3], 2=[9, 3, 7], 4=[5, 2, 7]}
		 */
	}

	@Test
	public void testLinkedHashMultimap(){
		Multimap<Integer, Integer> map = LinkedHashMultimap.create();
		map.put(4, 2);
		map.put(4, 7);
		map.put(1, 4);
		map.put(1, 5);
		map.put(1, 3);
		map.put(2, 3);
		map.put(2, 9);
		map.put(2, 7);
		map.put(4, 5);
		System.out.println(map.toString());

		/*输出结果：
		 *{4=[2, 7, 5], 1=[4, 5, 3], 2=[3, 9, 7]}
		 */
	}

	@Test
	public void testTreeMultimap(){
		Multimap<Integer, Integer> map = TreeMultimap.create();
		map.put(4, 2);
		map.put(4, 7);
		map.put(1, 4);
		map.put(1, 5);
		map.put(1, 3);
		map.put(2, 3);
		map.put(2, 9);
		map.put(2, 7);
		map.put(4, 5);
		System.out.println(map.toString());

		/*输出结果：
		 *{1=[3, 4, 5], 2=[3, 7, 9], 4=[2, 5, 7]}
		 */
	}

}
