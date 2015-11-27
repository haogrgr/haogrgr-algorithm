package com.haogrgr.algorithm.structure;

import java.util.List;

import com.haogrgr.algorithm.utils.Lists;
import com.haogrgr.algorithm.utils.Strings;

/**
 * 线段树
 * 
 * 讲得比较易懂的博客: http://www.cnblogs.com/shuaiwhu/archive/2012/04/22/2464583.html
 * 
 * @author desheng.tu
 * @date 2015年11月16日 下午4:25:48
 *
 */
public class SegmentTreeTest {

	public static void main(String[] args) {
		int start = 1, end = 5;

		Node<Void> root = build(start, end);

		print(root, 10);
	}

	/**
	 * 构建线段树[start, end], 返回root节点
	 */
	public static <T> Node<T> build(int start, int end) {
		Node<T> root = new Node<>(start, end);
		if (end - start > 1) {
			int middle = (start + end) >> 1;
			root.leftchild = build(start, middle);
			root.rightchild = build(middle, end);
		}
		return root;
	}

	public static class Node<T> {
		int left;
		int right;
		Node<T> leftchild;
		Node<T> rightchild;

		public Node(int left, int right) {
			this.left = left;
			this.right = right;
		}

		@Override
		public String toString() {
			return String.format("[%-3d, %-3d]", left, right);
		}
	}

	/**
	 * 层次遍历线段树输出
	 * @param root 根节点
	 * @param blocklen 每个节点输出所占用的长度(这里是10)
	 */
	public static <T> void print(Node<T> root, int blocklen) {
		//二叉树树的层数, 每个节点文本的长度
		int deep = 1;
		for (int i = 1; i < (root.right - root.left); i = i << 1) {
			deep++;
		}

		//输出每一层的数据
		List<Node<T>> nodes = Lists.array(root);
		while (nodes.size() > 0) {
			List<Node<T>> childs = Lists.array();//记录孩子节点

			int blanklen = ((2 << (--deep - 1)) - 1) * (blocklen / 2);//计算这一层要缩进的长度

			boolean allnull = true;
			for (Node<T> node : nodes) {
				System.out.print(Strings.blanks(blanklen) + (node == null ? Strings.blanks(blocklen) : node.toString())
						+ Strings.blanks(blanklen));

				if (node != null) {
					childs.add(node.leftchild);
					childs.add(node.rightchild);

					if (allnull && (node.leftchild != null || node.rightchild != null)) {
						allnull = false;
					}
				}
			}
			System.out.println();

			nodes = allnull ? Lists.empty() : childs;
		}
	}

}
