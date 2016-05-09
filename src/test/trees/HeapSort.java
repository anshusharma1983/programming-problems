package test.trees;

import test.array.ArrayUtils;

/*
 Left child:      2i
 Right child:    2i+1
 - max heap property -  A(parent(i)) > A(i)
 - All elements from A(n/2 + 1), A(n/2 + 2) and so on are leaves
 */
public class HeapSort {
	public static void main(String[] args) {
		HeapSort hs = new HeapSort();
		int A[] = {6,4,1,7,2,5,3};
		hs.heapSort(A);
		ArrayUtils.printArr(A);
	}

	void maxHeapify(int[] A, int i, int heapSize) {
		int max = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		if (l <= heapSize && A[l] > A[max]) {
			max = l;
		}
		if (r <= heapSize && A[r] > A[max]) {
			max = r;
		}
		if (i != max) {
			ArrayUtils.swap(A, i, max);
			maxHeapify(A, max, heapSize);
		}
	}

	/**
	 * No need to call maxHeapify on leaves
	 * @param A
	 * @param heapSize
	 */
	void buildMaxHeap(int[] A, int heapSize) {
		for (int i = heapSize / 2 - 1; i >= 0; i--) {
			maxHeapify(A, i, heapSize);
		}
	}

	void heapSort(int[] A) {
		int heapSize = A.length - 1;
		buildMaxHeap(A, heapSize);
		for (int i = heapSize; i >=1; i--) {
			ArrayUtils.swap(A, i, 0); // sending highest element to end
			heapSize = heapSize - 1;
			maxHeapify(A, 0, heapSize);
		}
	}

}
