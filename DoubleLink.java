package DoubleLink;

public class DoubleLink<T>{
	//表头
	private DNode<T> mHead;

	//尾部
	private DNode<T> mTail;

	//节点个数
	private int mCount;

	//双向链表“节点”对应的结构体
	public class DNode<T> {

		//上一个 
		public DNode prev;

		//下一个
		public DNode next;
		
		public T value;

		//节点值
		public DNode(T value, DNode prev, DNode next) {
			this.value = value;
			this.prev = prev;
			this.next = next;
		}
	}

	//构造函数
	public DoubleLink(){

		// 创建“表头”。注意：表头没有存储数据！
		mHead = new DNode<T> ( null, null, null );
		mHead.prev = mHead.next = mHead;

		// 初始化“节点个数”为0
		mCount = 0;

		//创建“尾部”
		mTail = new DNode<T> (null, mHead, null);
		mHead.next = mTail;
	}

 	// 返回节点数目
 	public int size(){
 		return mCount;
 	}

 	//判断返回链表是否为空
 	public boolean isEmpty(){
 		return mCount == 0;
 	}

 	//获取第index位置的节点
 	private DNode<T> getNode ( int index) {

 		//判断函数是否异常
 		if(index < 0 || index > mCount) {
 			throw new IndexOutOfBoundsException();
 		}
 		//正向查找
 		if (index <= mCount / 2) {
 			DNode<T> node = mHead.next;
 			for(int i = 0; i < index; i++) {
 				node = node.next;
 			}
 			return node;
 		}

 		//反向查找
 		if (index > mCount / 2) {
 			DNode<T> lnode = mTail.prev;
 			int LastIndex = mCount - index - 1;
 			for( int j = 0; j < LastIndex; j++) {
// 				LastIndex = LastIndex.prev;
 				lnode = lnode.prev;
 			}
 			return lnode;
 		}
		return null;
 	}

 		// 获取第index位置的节点的值
 		public T getValue( int index ) {
 			return getNode(index).value;
 		}

 		// 获取第1个节点的值
 		public T getFirstValue( int index ) {
 			return getNode(0).value;
 		}

 		// 获取最后一个节点的值
 		public T getLastValue( int index ) {
 			return getNode( mCount - 1 ).value;
 		}

 		// 将节点插入到第index位置之前
 		public void insert (int index, T t) {
 			if ( index == 0 ) {
 				DNode<T> node = new DNode<T> ( t, mHead, mHead.next );
 				mHead.next.prev = node;
 				mHead.next = node;
 				mCount++;
 				return;
 			}
 			else{
 				DNode<T> insertNode = getNode ( index );
 				DNode<T> tNode = new DNode<T> ( t, insertNode.prev, insertNode );
 				insertNode.prev.next = tNode;
 				insertNode.next = tNode;
 				mCount++;
 				return;
 			}
 		}
 			// 将节点插入第一个节点处。
 			public void inserFirst( T t ) {
 				insert( 0, t);
 			}


 			// 将节点追加到链表的末尾
 			public void appendLast ( T t) {
 				DNode<T> node = new DNode<T> ( t, mHead.prev, mHead );
 				mHead.prev.next = node;
 				mHead.prev = node;
 				mCount++;
 				return;
 			}

 			// 删除index[位置]的节点
 			public void deleteIndex ( int index ) {

 				//获取将被删除的第index位置的节点
 				DNode<T> deleteNode = getNode(index);
 				deleteNode.prev.next = deleteNode.next;
 				deleteNode.next.prev = deleteNode.next;
 				deleteNode = null;
 				mCount--;
 				return;
 				}

 			// 删除第一个节点
 			public void deleteFirstNode () {
 				deleteIndex(0);
 			}

 			// 删除最后一个节点
 			public void deleteLastNode () {
 				deleteIndex (mCount - 1);
 			}

 		}

 	

