package com.haogrgr.algorithm.structure;

/**
 * 线段树练习题
 * 
 * 题目:
 * 某次列车途经C个城市，城市编号依次为1到C，列车上共有S个座位，
 * 每一个售票申请包含三个参数，分别用O、D、N表示，O为起始站，D为目的地站，N为车票张数，
 * 售票系统对该售票申请作出受理或不受理的决定，
 * 只有在从O到D的区段内列车上都有N个或N个以上的空座位时该售票申请才被受理，
 * 请你写一个程序，实现这个自动售票系统.
 * 
 * 1<=C<=60000, 1<=S<=60000, 1<=R<=60000
 * C为城市个数,     S为列车上座位数       R为所有售票申请总数
 * 
 * 
 * 
 * @author desheng.tu
 * @date 2015年11月18日 上午11:31:17 
 *
 */
public class TrainTicketSystem {

	public static void main(String[] args) {

	}

	//车票
	public static class Ticket {
		int start, end, count;//起始站, 结束站, 座位数
	}

}
